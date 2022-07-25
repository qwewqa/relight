package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.EvasionRateUpBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

data class TeamScalingPassive(
    val cap: Int,
    override val category: PassiveEffectCategory,
    val effect: TargetContext.(value: Int, time: Int) -> Unit,
) : PassiveEffect {

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        context.targetAllyAoe(condition).act {
            effect((value * targets.size).coerceAtMost(cap), time)
        }
    }
}

val teamActUpScalingPassive100 = TeamScalingPassive(
    100,
    PassiveEffectCategory.Passive,
) { value, _ ->
    targets.forEach {
        it.boostActPower += value
    }
}

val teamEvasionUpBuffScalingPassive60 = TeamScalingPassive(
    60,
    PassiveEffectCategory.TurnStartPositiveB,
) { value, time ->
    applyBuff(
        EvasionRateUpBuff,
        value,
        time,
    )
}
