package xyz.qwewqa.relive.simulator.stage.passive

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.TargetContext
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.stage.buff.BuffResistanceBuff
import xyz.qwewqa.relive.simulator.stage.condition.Condition

sealed class ActionTarget(val accessor: ActionContext.() -> TargetContext) {
    object Self : ActionTarget({ targetSelf() })
    object Team : ActionTarget({ targetAllyAoe() })
    object EnemyTeam : ActionTarget({ targetAoe() })
    data class EnemyBack(val count: Int) : ActionTarget({ targetBack(count) })

    fun get(context: ActionContext) = context.accessor()
}

// TODO: Conditions here

data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionTarget,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartPositive2

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target.get(context).act {
            applyBuff(buffEffect, value, turns)
        }
}

data class ResistanceBuffPassive(
    val buffEffect: BuffResistanceBuff,
    val target: ActionTarget,
) : PassiveEffect {
    override val name = "Auto Resistance Buff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target.get(context).act {
            applyBuff(buffEffect, value, turns)
        }
}

data class DebuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionTarget,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target.get(context).act {
            applyBuff(buffEffect, value, turns)
        }
}
