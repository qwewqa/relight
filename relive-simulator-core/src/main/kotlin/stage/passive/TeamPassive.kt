package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.runIfTrue

object TeamActPowerUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                member.boostActPower += value
            }
        }
    }
}

object TeamDexterityPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                member.valueDexterity += value
            }
        }
    }
}

object TeamCriticalPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                member.valueCritical += value
            }
        }
    }
}


object TeamHpUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                member.boostMaxHp += value
            }
        }
    }
}