package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.EvasionUpBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPowerUp
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHpUp

data class TeamScalingPassive(
    override val name: String,
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

val TeamActUpScalingPassive100 = TeamScalingPassive(
    "Team Act Up Scaling Passive (max 100%)",
    100,
    PassiveEffectCategory.Passive,
) { value, _ ->
    targets.forEach {
        it.mod {
            actPowerUp += value
        }
    }
}

val TeamActUpScalingPassive120 = TeamScalingPassive(
    "Team Act Up Scaling Passive (max 120%)",
    120,
    PassiveEffectCategory.Passive,
) { value, _ ->
    targets.forEach {
        it.mod {
            actPowerUp += value
        }
    }
}

val SelfActUpScalingPassive120 = TeamScalingPassive(
    "Self Act Up Scaling Passive (max 120%)",
    120,
    PassiveEffectCategory.Passive,
) { value, _ ->
    self.mod {
        actPowerUp += value
    }
}

val TeamEvasionUpBuffScalingPassive60 = TeamScalingPassive(
    "Team Evasion Up Buff Scaling Passive (max 60%)",
    60,
    PassiveEffectCategory.TurnStartPositiveB,
) { value, time ->
    applyBuff(
        EvasionUpBuff,
        value,
        time,
    )
}

val TeamHpUpScalingPassive150 = TeamScalingPassive(
    "Team Hp Up Scaling Passive (max 150%)",
    150,
    PassiveEffectCategory.Passive,
) { value, _ ->
    targets.forEach {
        it.mod {
            maxHpUp += value
        }
    }
}