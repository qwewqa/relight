package xyz.qwewqa.relive.simulator.stage.passive

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.TargetContext
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.stage.condition.Condition

data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.target().act {
        applyBuff(buffEffect, value, turns)
    }
}

data class DebuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.target().act {
        applyBuff(buffEffect, value, turns)
    }
}
