package xyz.qwewqa.relive.simulator.stage.passive

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.condition.runIfTrue

object BrillianceRecoverPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        condition.runIfTrue(self) {
            addBrilliance(value)
        }
    }
}


object TeamBrillianceRecoverPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                addBrilliance(value)
            }
        }
    }
}

object EnemyBrillianceDownPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
        enemy.actors.values.forEach { member ->
            condition.runIfTrue(member) {
                addBrilliance(-value)
            }
        }
    }
}
