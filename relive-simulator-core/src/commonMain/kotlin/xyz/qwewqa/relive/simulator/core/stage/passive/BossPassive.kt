package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.advantagedAgainst
import xyz.qwewqa.relive.simulator.core.stage.actor.disadvantagedAgainst
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.abnormalBuffs
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

object AbnormalGuardPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        self.buffs.guardOnAbnormal = true
    }
}

object AbnormalResistPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        abnormalBuffs.forEach { buff ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + value
        }
    }
}

object BossElementResistPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive

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