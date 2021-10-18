package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue

object SelfTurnBrillianceRecoveryPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(EffectTag.Brilliance)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            buffs.addPassive {
                addBrilliance(value)
            }
        }
    }
}

object BrillianceRecoveryPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(EffectTag.Brilliance)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            addBrilliance(value)
        }
    }
}


object TeamBrillianceRecoveryPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(EffectTag.Brilliance)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                addBrilliance(value)
            }
        }
    }
}

object EnemyBrillianceDrainPassive : PassiveEffect {
    override val category = PassiveEffectCategory.TurnStartNegative
    override val tags = listOf(EffectTag.BrillianceDown)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        enemy.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                addBrilliance(-value)
            }
        }
    }
}
