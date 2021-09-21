package xyz.qwewqa.relive.simulator.stage.passive

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.condition.runIfTrue

object ActPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            boostActPower += value
        }
    }
}

object DexterityPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            valueDexterity += value
        }
    }
}

object CriticalPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            valueCritical += value
        }
    }
}

object DamageDealtPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            valueDamageDealtUp += value
        }
    }
}

object EffectiveDamageDealtPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            valueEffectiveDamageUp += value
        }
    }
}

object NegativeEffectResistPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            valueNegativeEffectResist += value
        }
    }
}
