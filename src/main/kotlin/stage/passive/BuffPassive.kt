package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

val ReviveBuffPassive: PassiveEffect = GenericBuffPassive(ReviveBuff) { targetSelf() }

val TeamActPowerUpBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerUpBuff) { targetAllyAoe() }
val TeamDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff) { targetAllyAoe() }
val TeamCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff) { targetAllyAoe() }
val TeamEffectiveDamageDealtUpBuffPassive: PassiveEffect = GenericBuffPassive(EffectiveDamageDealtUpBuff) { targetAllyAoe() }

val TeamConfusionResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(ConfusionResistanceBuff) { targetAllyAoe() }
val TeamStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff) { targetAllyAoe() }

val EnemyBack1ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff) { targetBack(1) }

private data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartPositive2

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, turns)
        }
}

private data class ResistanceBuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Resistance Buff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartPositive1

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, turns)
        }
}

private data class DebuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, turns)
        }
}
