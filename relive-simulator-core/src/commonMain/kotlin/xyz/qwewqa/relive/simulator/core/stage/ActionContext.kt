package xyz.qwewqa.relive.simulator.core.stage

import xyz.qwewqa.relive.simulator.common.LogCategory
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
        var successfulHits: Int = 0,
        var attemptedHit: Boolean = false,
        var damageDealtToEnemy: Int = 0,
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

    private fun List<Actor>.targetContext(
            affectedByAggro: Boolean = false,
            autoRepeatHits: Boolean = true
    ): TargetContext {
        return TargetContext(
                this@ActionContext,
                this,
                self.aggroTarget.takeIf { affectedByAggro },
                autoRepeatHits,
        )
    }

    inline fun Actor.act(action: TargetContext.() -> Unit) =
            TargetContext(this@ActionContext, listOf(this)).act(action)

    private fun provokable(selector: () -> List<Actor>) = self.provokeTarget?.let { listOf(it) } ?: selector()

    fun targetSelf() = listOf(self).targetContext()

    fun targetCutinTarget(): TargetContext {
        val target = stage.cutinTarget ?: error("Cutin target not available.")
        return if (target in enemy.actors.values) {
            provokable { listOf(target) }.targetContext(true)
        } else {
            listOf(target).targetContext()
        }
    }

    fun targetFront(count: Int = 1) = provokable { enemy.active.take(count) }.targetContext(true)
    fun targetBack(count: Int = 1) = provokable { enemy.active.takeLast(count) }.targetContext(true)
    fun targetAoe() = enemy.active.targetContext(true)
    fun targetAoe(condition: Condition) = enemy.active.filter { condition.evaluate(it) }.targetContext(true)

    // TODO: Check if pride is affected by provoke / aggro
    fun targetRandom(count: Int = 1) = provokable { List(count) { enemy.active.random(stage.random) } }
            .targetContext(true)

    fun targetAnyRandom(count: Int) = provokable { List(count) { enemy.active.random(stage.random) } }
            .targetContext(true, autoRepeatHits = false)

    fun targetAllyAoe() = team.active.targetContext()
    fun targetAllyAoe(condition: Condition) = team.active.filter { condition.evaluate(it) }.targetContext()
    fun targetAllyFront(count: Int = 1) = team.active.take(count).targetContext()
    fun targetAllyBack(count: Int = 1) = team.active.takeLast(count).targetContext()
    fun targetAllyRandom(count: Int = 1) = List(count) { team.active.random(stage.random) }.targetContext()

    fun <T : Comparable<T>> targetByHighest(count: Int = 1, condition: (Actor) -> T) =
            provokable { enemy.active.sortedBy(condition).takeLast(count) }.targetContext(true)

    fun <T : Comparable<T>> targetByLowest(count: Int = 1, condition: (Actor) -> T) =
            provokable { enemy.active.sortedBy(condition).take(count) }.targetContext(true)

    fun <T : Comparable<T>> targetAllyByHighest(count: Int = 1, selector: (Actor) -> T) =
            team.active.sortedBy(selector).takeLast(count).targetContext()

    fun <T : Comparable<T>> targetAllyByLowest(count: Int = 1, selector: (Actor) -> T) =
            team.active.sortedBy(selector).take(count).targetContext()

    fun Team.forEach(action: (Actor) -> Unit) = active.forEach(action)

    fun applyAllyStageEffect(effect: StageEffect, turns: Int) {
        log("Stage Effect", category = LogCategory.BUFF) { "Apply stage effect ${effect.name} (${turns}t) to ally stage." }
        team.stageEffects.add(effect, turns)
    }

    fun applyEnemyStageEffect(effect: StageEffect, turns: Int) {
        log("Stage Effect", category = LogCategory.BUFF) { "Apply stage effect ${effect.name} (${turns}t) to enemy stage." }
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
        val aggroTarget: Actor? = null,
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
            for (originalTarget in targets) {
                val target = aggroTarget ?: originalTarget
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
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                when (effect.category) {
                    BuffCategory.Positive -> {
                        val applyChance = chance / 100.0 *
                                (100 - positiveEffectResist - (specificBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.add(self, effect, value, turns)
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Positive buff ${effect.formatName(value)} (${turns}t) applied to [$name]." }
                        } else {
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Positive buff ${effect.formatName(value)} (${turns}t) missed to [$name]." }
                        }
                    }
                    BuffCategory.Negative -> {
                        val applyChance = chance / 100.0 *
                                (100 - negativeEffectResist - (specificBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.add(self, effect, value, turns)
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Negative buff ${effect.formatName(value)} (${turns}t) applied to [$name]." }
                        } else {
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Negative buff ${effect.formatName(value)} (${turns}t) missed to [$name]." }
                        }
                    }
                }
            }
        }
    }

    fun applyCountableBuff(effect: CountableBuff, count: Int = 1, chance: Int = 100) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                when (effect.category) {
                    BuffCategory.Positive -> {
                        val applyChance =
                                chance / 100.0 * (100 - positiveEffectResist - (specificCountableBuffResist[effect]
                                        ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.addCountable(effect, count)
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Positive buff [${effect.name}] (${count}x) applied to [$name]." }
                        } else {
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Positive buff [${effect.name}] (${count}x) missed to [$name]." }
                        }
                    }
                    BuffCategory.Negative -> {
                        val applyChance = chance / 100.0 * (100 - negativeCountableResist - (specificCountableBuffResist[effect] ?: 0)) / 100.0
                        if (applyChance >= 1.0 || stage.random.nextDouble() < applyChance) {
                            buffs.addCountable(effect, count)
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Negative buff [${effect.name}] (${count}x) applied to [$name]." }
                        } else {
                            actionContext.log("Buff", category = LogCategory.BUFF) { "Negative buff [${effect.name}] (${count}x) missed to [$name]." }
                        }
                    }
                }
            }
        }
    }

    fun dispelTimed(category: BuffCategory) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Dispel", category = LogCategory.BUFF) { "Dispel timed ${category.name} effects from [$name]." }
                buffs.dispel(category)
            }
        }
    }

    fun dispelTimed(effect: BuffEffect) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Dispel", category = LogCategory.BUFF) { "Dispel timed ${effect.name} effects from [$name]." }
                buffs.removeAll(effect)
            }
        }
    }

    fun flipTimed(category: BuffCategory, count: Int) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Flip", category = LogCategory.BUFF) { "Flip last $count timed ${category.name} effects from [$name]." }
                buffs.flip(category, count)
            }
        }
    }

    fun dispelCountable(category: BuffCategory) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Dispel", category = LogCategory.BUFF) { "Dispel countable ${category.name} effects from [$name]." }
                buffs.dispelCountable(category)
            }
        }
    }

    fun reduceCountable(category: BuffCategory) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Reduce", category = LogCategory.BUFF) {"Remove one of each ${category.name} countable effect from [$name]." }
                buffs.reduceCountable(category)
            }
        }
    }

    fun heal(percent: Int = 0, fixed: Int = 0) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Heal", category = LogCategory.HEAL) { "Heal [$name] (percent: $percent, fixed: $fixed)." }
                this.heal(fixed + (percent * maxHp / 100))
            }
        }
    }

    fun addBrilliance(amount: Int) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Brilliance", category = LogCategory.BRILLIANCE) { "Add brilliance to [$name] (amount: $amount)." }
                this.addBrilliance(amount)
            }
        }
    }

    fun removeBrilliance(amount: Int) {
        if (!self.isAlive) return
        for (originalTarget in targets) {
            val target = aggroTarget ?: originalTarget
            if (!target.isAlive) continue
            target.apply {
                actionContext.log("Brilliance", category = LogCategory.BRILLIANCE) { "Remove brilliance from [$name] (amount: $amount)." }
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
inline fun ActionContext.log(vararg tags: String, category: LogCategory = LogCategory.DEFAULT, debug: Boolean = false,
                             summary: () -> String? = { null }, value: () -> String) {
    contract {
        callsInPlace(value, InvocationKind.AT_MOST_ONCE)
    }

    // Inlining the stage.log call avoids the overhead of the spread operator
    stage.run {
        if (configuration.logging && (!debug || configuration.debug) && logger.prepare()) {
            logger.log(turn, tile, move, category, *tags, summary = summary(), content = value())
        }
    }
}
