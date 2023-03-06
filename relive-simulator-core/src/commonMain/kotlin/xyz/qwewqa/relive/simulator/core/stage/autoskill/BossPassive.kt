package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.disadvantagedAgainst
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.actor.Character

interface PassiveEffect {
  val type
    get() = AutoSkillType.Passive

  fun activate(context: ActionContext, value: Int, time: Int, condition: Condition)
}

fun PassiveEffect.new(
    value: Int = 0,
    time: Int = 0,
) =
    object : AutoSkill {
      override val iconId = null

      override val type
        get() = AutoSkillType.Passive

      override fun execute(context: ActionContext) {
        activate(context, value, time, { true })
      }
    }

object AbnormalGuardPassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { self.buffs.guardOnAbnormal = true }
}

object AbnormalResistPassiveA : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        listOf(
                Buffs.StopBuff,
                Buffs.SleepBuff,
                Buffs.ConfusionBuff,
                Buffs.FreezeBuff,
                Buffs.StunBuff,
                Buffs.LockedStunBuff,
                Buffs.BurnBuff,
                Buffs.LockedBurnBuff,
                Buffs.PoisonBuff,
                Buffs.LockedPoisonBuff,
                Buffs.ApUpBuff,
                Buffs.LockedApUpBuff,
                Buffs.BlindnessBuff,
                Buffs.LockedBlindnessBuff,
            )
            .forEach { buff ->
              self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + value
            }
      }
}

object BossElementResistPassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        Attribute.values().forEach {
          self.againstAttributeDamageDealtUp[it] = value
          self.againstAttributeDamageReceivedDown[it] = value
        }
        (self.dress.attribute.disadvantagedAgainst
                ?: error("Expected a non-neutral or dream attribute."))
            .forEach {
              self.againstAttributeDamageDealtUp[it] = 0
              self.againstAttributeDamageReceivedDown[it] = 0
            }
        self.againstAttributeDamageDealtUp[Attribute.Dream] = 0
        self.againstAttributeDamageReceivedDown[Attribute.Dream] = 0
      }
}

object BuggedHMRuiBossElementResistPassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        Attribute.values().forEach {
          self.againstAttributeDamageDealtUp[it] = value
          self.againstAttributeDamageReceivedDown[it] = value
        }
        self.againstAttributeDamageDealtUp[Attribute.Flower] = 0
        self.againstAttributeDamageReceivedDown[Attribute.Flower] = 0
        self.againstAttributeDamageDealtUp[Attribute.Dream] = 0
        self.againstAttributeDamageReceivedDown[Attribute.Dream] = 0
      }
}

/** A passive which sets the event bonuses against the boss which has this passive. */
class EventBonusPassive(
    val dresses: Map<Int, Int> = emptyMap(),
    val characters: Map<Character, Int> = emptyMap(),
    val categories: Map<Set<Int>, Int> = emptyMap(),
) : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        enemy.guest?.applyBonus()
        enemy.actors.values.forEach { it.applyBonus() }
      }

  private fun Actor.applyBonus() {
    val bonus =
        dresses[dress.id]
            ?: characters[dress.character]
                ?: categories.keys.firstOrNull { dress.id in it }?.let { categories[it]!! }
    if (bonus != null) {
      context.run {
        team.actors.values.forEach { member -> member.eventBonus += bonus }
        log("Event Bonus") { "Team event bonus $bonus." }
      }
    }
  }
}
