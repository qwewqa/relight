package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.runIfTrue

object BrillianceRecoveryPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            addBrilliance(value)
        }
    }
}


object TeamBrillianceRecoveryPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                addBrilliance(value)
            }
        }
    }
}

object EnemyBrillianceDrainPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        enemy.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                addBrilliance(-value)
            }
        }
    }
}
