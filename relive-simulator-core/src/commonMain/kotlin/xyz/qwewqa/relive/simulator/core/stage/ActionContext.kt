package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.StageEffect
import xyz.qwewqa.relive.simulator.core.stage.team.Team
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

data class ActionLog(
    var successfulHits: Int = 0
)

class ActionContext(
    val self: Actor,
    val stage: Stage,
    val team: Team,
    val enemy: Team,
) {
    private var focus = 0
    val focusEnabled get() = focus > 0

    var actionLog = ActionLog()

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
    fun targetCutinTarget() = listOf(stage.cutinTarget ?: error("Cutin target not available.")).targetContext()
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

    fun applyAllyStageEffect(effect: StageEffect, turns: Int) {
        log("Stage Effect") { "Apply stage effect ${effect.name} (${turns}t) to ally stage." }
        team.stageEffects.add(effect, turns)
    }

    fun applyEnemyStageEffect(effect: StageEffect, turns: Int) {
        log("Stage Effect") { "Apply stage effect ${effect.name} (${turns}t) to enemy stage." }
        enemy.stageEffects.add(effect, turns)
    }
}


class TargetContext(
    val actionContext: ActionContext,
    /**
     * The targeted actors. Could be either allies or enemies.
     * Note that since multiple actions can be taken within a single TargetContext,
     * there's no guarantee all targets are alive at the start of a particular action.
     */
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
        mode: HitMode = HitMode.NORMAL,
    ) {
        if (!self.isAlive) return
        val hitAttribute = HitAttribute(
            modifier = modifier,
            hitCount = hitCount,
            attribute = attribute,
            damageType = damageType,
            bonusModifier = bonusMultiplier,
            bonusCondition = bonusCondition,
            addBrilliance = addBrilliance,
            focus = focus,
            noReflect = noReflect,
            noVariance = noVariance,
            mode = mode,
        )
        repeat(if (autoRepeatHits) hitCount else 1) {
            targets.forEach { target ->
                if (!self.isAlive) return
                if (target.isAlive) {
                    stage.damageCalculator.damage(
                        self,
                        target,
                        hitAttribute,
                    )
                }
            }
        }
    }

    fun applyBuff(effect: BuffEffect, value: Int = 1, turns: Int, chance: Int = 100) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                when (effect.category) {
                    BuffCategory.Positive -> {
                        val applyChance = chance / 100.0 *
                                (100 - positiveEffectResist - (specificBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.add(effect, value, turns)
                            actionContext.log("Effect") { "Positive buff ${effect.formatName(value)} (${turns}t) applied to [$name]." }
                        } else {
                            actionContext.log("Effect") { "Positive buff ${effect.formatName(value)} (${turns}t) missed to [$name]." }
                        }
                    }
                    BuffCategory.Negative -> {
                        val applyChance = chance / 100.0 *
                                (100 - negativeEffectResist - (specificBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.add(effect, value, turns)
                            actionContext.log("Effect") { "Negative buff ${effect.formatName(value)} (${turns}t) applied to [$name]." }
                        } else {
                            actionContext.log("Effect") { "Negative buff ${effect.formatName(value)} (${turns}t) missed to [$name]." }
                        }
                    }
                }
            }
        }
    }

    fun applyCountableBuff(effect: CountableBuff, count: Int = 1, chance: Int = 100) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                when (effect.category) {
                    BuffCategory.Positive -> {
                        // PER works for countable buffs but NER doesn't for countable debuffs for some reason
                        val applyChance = chance / 100.0 * (100 - positiveEffectResist - (specificCountableBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.addCountable(effect, count)
                            actionContext.log("Effect") { "Positive buff [${effect.name}] (${count}x) applied to [$name]." }
                        } else {
                            actionContext.log("Effect") { "Positive buff [${effect.name}] (${count}x) missed to [$name]." }
                        }
                    }
                    BuffCategory.Negative -> {
                        val applyChance = chance / 100.0 * (100 - (specificCountableBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.addCountable(effect, count)
                            actionContext.log("Effect") { "Negative buff [${effect.name}] (${count}x) applied to [$name]." }
                        } else {
                            actionContext.log("Effect") { "Negative buff [${effect.name}] (${count}x) missed to [$name]." }
                        }
                    }
                }
            }
        }
    }

    fun dispelTimed(category: BuffCategory) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Dispel") { "Dispel timed ${category.name} effects from [$name]." }
                buffs.dispel(category)
            }
        }
    }

    fun flipTimed(category: BuffCategory, count: Int) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Flip") { "Flip last $count timed ${category.name} effects from [$name]." }
                buffs.flip(category, count)
            }
        }
    }

    fun dispelCountable(category: BuffCategory) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Dispel") { "Dispel countable ${category.name} effects from [$name]." }
                buffs.dispelCountable(category)
            }
        }
    }

    fun heal(percent: Int = 0, fixed: Int = 0) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Heal") { "Heal [$name] (percent: $percent, fixed: $fixed)." }
                this.heal(fixed + (percent * maxHp / 100))
            }
        }
    }

    fun addBrilliance(amount: Int) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Brilliance") { "Add brilliance to [$name] (amount: $amount)." }
                this.addBrilliance(amount)
            }
        }
    }

    fun removeBrilliance(amount: Int) {
        if (!self.isAlive) return
        for (target in targets) {
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Brilliance") { "Remove brilliance from [$name] (amount: $amount)." }
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
