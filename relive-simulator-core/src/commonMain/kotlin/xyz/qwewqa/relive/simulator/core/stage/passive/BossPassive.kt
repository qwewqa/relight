package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.disadvantagedAgainst
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.stage.character.Character

object AbnormalGuardPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        self.buffs.guardOnAbnormal = true
    }
}

object AbnormalResistPassiveA : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        listOf(
            StopBuff,
            SleepBuff,
            ConfusionBuff,
            FreezeBuff,
            StunBuff,
            LockedStunBuff,
            BurnBuff,
            LockedBurnBuff,
            PoisonBuff,
            LockedPoisonBuff,
            ApUpBuff,
            LockedApUpBuff,
            BlindnessBuff,
            LockedBlindnessBuff,
        ).forEach { buff ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + value
        }
    }
}

object BossElementResistPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        Attribute.values().forEach {
            self.againstAttributeDamageDealtUp[it] = value
            self.againstAttributeDamageTakenDown[it] = value
        }
        val disadvantagedAgainst = self.dress.attribute.disadvantagedAgainst
            ?: error("Expected a non-neutral or dream attribute.")
        self.againstAttributeDamageDealtUp[disadvantagedAgainst] = 0
        self.againstAttributeDamageTakenDown[disadvantagedAgainst] = 0
        self.againstAttributeDamageDealtUp[Attribute.Dream] = 0
        self.againstAttributeDamageTakenDown[Attribute.Dream] = 0
    }
}

object BuggedHMRuiBossElementResistPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        Attribute.values().forEach {
            self.againstAttributeDamageDealtUp[it] = value
            self.againstAttributeDamageTakenDown[it] = value
        }
        self.againstAttributeDamageDealtUp[Attribute.Flower] = 0
        self.againstAttributeDamageTakenDown[Attribute.Flower] = 0
        self.againstAttributeDamageDealtUp[Attribute.Dream] = 0
        self.againstAttributeDamageTakenDown[Attribute.Dream] = 0
    }
}

/**
 * A passive which sets the event bonuses against the boss which has this passive.
 */
class EventBonusPassive(
    val dresses: Map<Int, Int> = emptyMap(),
    val characters: Map<Character, Int> = emptyMap(),
    val categories: Map<DressCategory, Int> = emptyMap(),
) : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        enemy.guest?.applyBonus()
        enemy.actors.values.forEach { it.applyBonus() }
    }

    private fun Actor.applyBonus() {
        val bonus = dresses[dress.id]
            ?: characters[dress.character]
            ?: categories.keys.firstOrNull { it in dress.categories }?.let { categories[it]!! }
        if (bonus != null) {
            context.run {
                team.actors.values.forEach { member ->
                    member.eventBonus += bonus
                }
                log("Event Bonus") { "Team event bonus $bonus." }
            }
        }
    }
}
