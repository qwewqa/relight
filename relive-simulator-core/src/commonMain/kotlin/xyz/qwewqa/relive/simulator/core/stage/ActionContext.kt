package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

class ActionContext(
    val self: Actor,
    val stage: Stage,
    val team: Team,
    val enemy: Team,
) {
    private var focus = 0
    val focusEnabled get() = focus > 0

    fun focus(block: () -> Unit) {
        focus++
        block()
        focus--
    }

    private fun List<Actor>.targetContext(autoRepeatHits: Boolean = true): TargetContext {
        return TargetContext(this@ActionContext, this, autoRepeatHits)
    }

    inline fun Actor.act(action: TargetContext.() -> Unit) =
        TargetContext(this@ActionContext, listOf(this)).act(action)

    fun targetSelf() = listOf(self).targetContext()
    fun targetFront(count: Int = 1) = enemy.active.take(count).targetContext()
    fun targetBack(count: Int = 1) = enemy.active.takeLast(count).targetContext()
    fun targetAoe() = enemy.active.targetContext()
    fun targetAoe(condition: Condition) = enemy.active.filter { condition.evaluate(it) }.targetContext()
    fun targetRandom(count: Int = 1) = List(count) { enemy.active.random(stage.random) }.targetContext()
    fun targetAnyRandom(count: Int) = List(count) { enemy.active.random(stage.random) }.targetContext(false)
    fun targetAllyAoe() = team.active.targetContext()
    fun targetAllyAoe(condition: Condition) = team.active.filter { condition.evaluate(it) }.targetContext()
    fun targetAllyFront(count: Int = 1) = team.active.take(count).targetContext()
    fun targetAllyBack(count: Int = 1) = team.active.takeLast(count).targetContext()
    fun targetAllyRandom(count: Int = 1) = List(count) { team.active.random(stage.random) }.targetContext()
    fun <T : Comparable<T>>  targetByHighest(count: Int = 1, condition: (Actor) -> T) =
        enemy.active.sortedBy(condition).takeLast(count).targetContext()
    fun <T : Comparable<T>>  targetByLowest(count: Int = 1, condition: (Actor) -> T) =
        enemy.active.sortedBy(condition).take(count).targetContext()
    fun <T : Comparable<T>> targetAllyByHighest(count: Int = 1, selector: (Actor) -> T) =
        team.active.sortedBy(selector).takeLast(count).targetContext()
    fun <T : Comparable<T>> targetAllyByLowest(count: Int = 1, selector: (Actor) -> T) =
        team.active.sortedBy(selector).take(count).targetContext()

    fun Team.forEach(action: (Actor) -> Unit) = active.forEach(action)
}


class TargetContext(
    val actionContext: ActionContext,
    val targets: List<Actor>,
    val autoRepeatHits: Boolean = true,
) {
    val stage get() = actionContext.stage
    val self = actionContext.self

    inline fun act(action: TargetContext.() -> Unit) = run(action)

    fun attack(
        modifier: Int,
        hitCount: Int = 1,
        bonusMultiplier: Int = 100,
        bonusCondition: Condition = Condition { false },
        damageType: DamageType = self.dress.damageType,
        attribute: Attribute = self.dress.attribute,
        addBrilliance: Boolean = true,
        focus: Boolean = actionContext.focusEnabled,
        noVariance: Boolean = false,
        noReflect: Boolean = false,
        removeOnConnect: CountableBuff? = null,
    ) {
        if (!self.isAlive) return
        repeat(if (autoRepeatHits) hitCount else 1) {
            targets.forEach { target ->
                stage.damageCalculator.damage(
                    self,
                    target,
                    HitAttribute(
                        modifier = modifier,
                        hitCount = hitCount,
                        attribute = attribute,
                        damageType = damageType,
                        bonus = if (bonusCondition.evaluate(target)) bonusMultiplier else 100,
                        addBrilliance = addBrilliance,
                        focus = focus,
                        noReflect = noReflect,
                        noVariance = noVariance,
                        removeOnConnect = removeOnConnect,
                    )
                )
            }
        }
    }

    fun applyBuff(effect: BuffEffect, value: Int = 1, turns: Int = 0, chance: Int = 100) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                when (effect.category) {
                    BuffCategory.Positive -> {
                        val applyChance = chance / 100.0 *
                                (100 - positiveEffectResist - (specificBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.add(effect, value, turns)
                            context.log("Effect") { "Positive buff ${effect.formatName(value)} (${turns}t) applied" }
                        } else {
                            context.log("Effect") { "Positive buff ${effect.formatName(value)} (${turns}t) missed" }
                        }
                    }
                    BuffCategory.Negative -> {
                        val applyChance = chance / 100.0 *
                                (100 - negativeEffectResist - (specificBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.add(effect, value, turns)
                            stage.log("Effect") { "Negative buff ${effect.formatName(value)} (${turns}t) applied" }
                        } else {
                            stage.log("Effect") { "Negative buff ${effect.formatName(value)} (${turns}t) missed" }
                        }
                    }
                }
            }
        }
    }

    fun applyCountableBuff(effect: CountableBuff, value: Int = 1, chance: Int = 100) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                when (effect.category) {
                    BuffCategory.Positive -> {
                        val applyChance = chance / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.addCountable(effect, value)
                            context.log("Effect") { "Positive buff [${effect.name}] (${value}) applied" }
                        } else {
                            context.log("Effect") { "Positive buff [${effect.name}] (${value}) missed" }
                        }
                    }
                    BuffCategory.Negative -> {
                        val applyChance = chance / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.addCountable(effect, value)
                            stage.log("Effect") { "Negative buff [${effect.name}] (${value}) applied" }
                        } else {
                            stage.log("Effect") { "Negative buff [${effect.name}] (${value}) missed" }
                        }
                    }
                }
            }
        }
    }

    fun dispelTimed(category: BuffCategory) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Dispel") { "[$self] dispels timed ${category.name} effects from ${this.name}" }
                buffs.dispel(category)
            }
        }
    }

    fun flipTimed(category: BuffCategory, count: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Flip") { "[$self] flips last $count timed ${category.name} effects from ${this.name}" }
                buffs.flip(category, count)
            }
        }
    }

    fun dispelCountable(category: BuffCategory) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Dispel") { "[$self] dispels countable ${category.name} effects from ${this.name}" }
                buffs.dispelCountable(category)
            }
        }
    }

    fun heal(percent: Int = 0, fixed: Int = 0) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Heal") { "${self.name} heals ${this.name} (percent: $percent, fixed: $fixed)" }
                this.heal(fixed + (percent * maxHp / 100))
            }
        }
    }

    fun addBrilliance(amount: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Brilliance") { "${self.name} gives brilliance to ${this.name} (amount: $amount)" }
                this.addBrilliance(amount)
            }
        }
    }

    fun removeBrilliance(amount: Int) {
        if (!self.isAlive) return
        targets.forEach {
            it.apply {
                stage.log("Brilliance") { "${self.name} removes brilliance from ${this.name} (amount: $amount)" }
                this.addBrilliance(-amount)
            }
        }
    }
}

fun interface Act {
    fun ActionContext.execute()
}

fun Act.execute(context: ActionContext) = run { context.execute() }

@OptIn(ExperimentalContracts::class)
inline fun ActionContext.log(tag: String = "?", value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    stage.log("${self.name} / $tag", value)
}
