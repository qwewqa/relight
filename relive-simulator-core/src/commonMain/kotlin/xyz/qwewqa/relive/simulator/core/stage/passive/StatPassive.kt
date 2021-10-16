package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue

object ActUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            boostActPower += value
        }
    }
}

object TeamActUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                boostActPower += value
            }
        }
    }
}

object DexterityPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            valueDexterity += value
        }
    }
}

object CriticalUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            valueCritical += value
        }
    }
}

object DamageDealtPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            valueDamageDealtUp += value
        }
    }
}

object EffectiveDamageDealtPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            valueEffectiveDamageUp += value
        }
    }
}

object ClimaxActPowerPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            valueClimaxDamageUp += value
        }
    }
}

object PerfectAimPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            perfectAimCounter += 1
        }
    }
}