package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.common.LogCategory
import xyz.qwewqa.relive.simulator.core.stage.actor.ActiveBuff
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.team.Team

class StageEffectManager(val team: Team) {
    private val levels = mutableMapOf<StageEffect, Int>()
    private var activeStacks = mutableListOf<ActiveStageEffect>()

    // Just for some sanity checks that effects aren't being activated
    // before the last ones have been expired
    private var activated = false

    private val activeBuffs = mutableListOf<Pair<ActiveBuff, Actor>>()

    fun values() = levels.mapNotNull { (k, v) -> (k to v).takeIf { v > 9 } }

    fun add(effect: StageEffect, turns: Int) {
        if (turns <= 0) return
        activeStacks += ActiveStageEffect(effect, turns)
        levels[effect] = (levels[effect] ?: 0) + 1
    }

    fun tick() {
        activeStacks.forEach { stack ->
            stack.turns--
            if (stack.turns == 0) {
                levels[stack.effect] = levels[stack.effect]!! - 1
            }
        }
        activeStacks.removeAll { it.turns <= 0 }
    }

    fun activate() {
        require(!activated) { "Cannot activate stage effects: stage effects already activated." }
        levels.forEach { (effect, level) ->
            if (level > 0) {
                val targets = getTargets(effect)
                targets.forEach { target ->
                    target.context.log("Stage Effect", category = LogCategory.BUFF) {
                        "Stage effect ${effect.name} (lv. $level) activate."
                    }
                    effect[level].forEach { stageBuff ->
                        activeBuffs +=  stageBuff.activate(target) to target
                    }
                }
            }
        }
        activated = true
    }

    fun deactivate() {
        require(activated) { "Cannot deactivate stage effects: stage effects not activated." }
        activeBuffs.forEach { (activeBuff, actor) ->
            actor.buffs.remove(activeBuff)
        }
        activeBuffs.clear()
        activated = false
    }

    private fun getTargets(effect: StageEffect) = when (effect.target) {
        StageEffectTarget.All -> team.active
        is StageEffectTarget.Front -> team.active.take(effect.target.count)
        is StageEffectTarget.Back -> team.active.takeLast(effect.target.count)
    }.filter { effect.condition?.evaluate(it) ?: true }
}

data class ActiveStageEffect(val effect: StageEffect, var turns: Int)
