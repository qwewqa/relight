package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.common.DisplayStageEffectData
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.stage.BasicTargetSelectionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.platformMapOf
import xyz.qwewqa.relive.simulator.core.stage.team.Team

class StageEffectManager(val team: Team) {
  private val levels = platformMapOf<StageEffect, Int>()
  private var activeStacks = mutableListOf<StageEffectStack>()
  private val activeEffects = platformMapOf<StageEffect, ActiveStageEffect>()

  // TODO: stop using this and just check whether targets changed each refresh
  private var targetsValid = true

  fun values() = levels.mapNotNull { (k, v) -> (k to v).takeIf { v > 9 } }

  fun add(effect: StageEffect, turns: Int, level: Int = 1) {
    if (turns <= 0) return
    activeStacks += StageEffectStack(effect, turns, level)
    levels[effect] = (levels[effect] ?: 0) + level
  }

  fun adjustLevels(category: BuffCategory, count: Int, delta: Int) {
    activeStacks
        .asReversed()
        .asSequence()
        .filter { it.effect.category == category }
        .take(count)
        .forEach { it.adjustLevel(delta) }
    activeStacks.removeAll { it.level == 0 }
  }

  private fun StageEffectStack.adjustLevel(delta: Int) {
    val originalLevel = level
    level = (level + delta).coerceAtLeast(0)
    if (originalLevel != level) {
      levels[effect] = (levels[effect] ?: 0) + (level - originalLevel)
    }
  }

  fun tick() {
    activeStacks.forEach { stack ->
      stack.turns--
      if (stack.turns == 0) {
        levels[stack.effect] = levels[stack.effect]!! - stack.level
      }
    }
    activeStacks.removeAll { it.turns <= 0 }
  }

  fun invalidateTargets() {
    targetsValid = false
  }

  fun refresh() {
    if (!targetsValid) {
      activeEffects.forEach { (_, effect) -> effect.deactivate() }
      activeEffects.clear()
      targetsValid = true
    }
    levels.forEach { (effect, level) ->
      if (level > 0) {
        val previousStatus = activeEffects[effect]
        if (previousStatus == null) {
          activeEffects[effect] = ActiveStageEffect(effect, effect.activate(level), level)
        } else {
          activeEffects[effect] = previousStatus.update(level)
        }
      } else {
        activeEffects.remove(effect)?.deactivate()
      }
    }
  }

  fun getDisplayData(): List<DisplayStageEffectData> {
    val maxTurns = platformMapOf<StageEffect, Int>()
    activeStacks.forEach { stack ->
      maxTurns[stack.effect] = maxOf(maxTurns[stack.effect] ?: 0, stack.turns)
    }
    return maxTurns.mapNotNull { (effect, turns) ->
      DisplayStageEffectData(
          effect.iconId,
          levels[effect]!!.coerceAtMost(5),
          turns,
      )
    }
  }

  private fun StageEffect.activate(level: Int): StageEffectActiveBuffValues =
      buffs.map { buff ->
        val value = buff.values[level.coerceAtMost(buff.values.size) - 1]
        // Note that the team is passed in for both the own and enemy teams, because enemy targeting
        // stage effects
        // are added to the enemy team but retain the enemy targeting.
        val targets = buff.target.getTargets(BasicTargetSelectionContext(null, team, team), null)
        targets.map { actor ->
          actor.buffs.activatePsuedoBuff(buff.effect, value.toI54())
          actor to value
        }
      }

  // TODO: Support changing targets
  private fun StageEffect.update(
      values: StageEffectActiveBuffValues,
      level: Int
  ): StageEffectActiveBuffValues {
    return values.zip(buffs).map { (buffValues, buff) ->
      val newValue = buff.values[level.coerceAtMost(buff.values.size) - 1]
      buffValues.map { (actor, oldValue) ->
        actor.buffs.updatePseudoBuff(buff.effect, oldValue.toI54(), newValue.toI54())
        actor to newValue
      }
    }
  }

  private fun StageEffect.deactivate(values: StageEffectActiveBuffValues) =
      values.zip(buffs).forEach { (buffValues, buff) ->
        buffValues.forEach { (actor, value) ->
          actor.buffs.removePseudoBuff(buff.effect, value.toI54())
        }
      }

  fun ActiveStageEffect.update(level: Int): ActiveStageEffect =
      if (level == this.level) {
        this
      } else {
        ActiveStageEffect(effect, effect.update(values, level), level)
      }

  fun ActiveStageEffect.deactivate() = effect.deactivate(values)
}

class StageEffectStack(val effect: StageEffect, var turns: Int, var level: Int)

typealias StageEffectActiveBuffValues = List<List<Pair<Actor, Int>>>

data class ActiveStageEffect(
    val effect: StageEffect,
    val values: StageEffectActiveBuffValues,
    val level: Int
)
