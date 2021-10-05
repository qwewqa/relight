package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

val ApplyFortitudeBuffPassive: PassiveEffect = GenericBuffPassive(ApplyFortitudeBuff) { targetSelf() }
val ApplyReviveBuffPassive: PassiveEffect = GenericBuffPassive(ApplyReviveBuff) { targetSelf() }

val TeamActPowerUpBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerUpBuff) { targetAllyAoe() }
val TeamDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff) { targetAllyAoe() }
val TeamCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff) { targetAllyAoe() }
val TeamEffectiveDamageDealtUpBuffPassive: PassiveEffect = GenericBuffPassive(EffectiveDamageDealtUpBuff) { targetAllyAoe() }
val SelfPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAim) { targetSelf() }
val SelfDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff) { targetSelf() }
val SelfEffectiveDamageDealtUpBuffPassive : PassiveEffect = GenericBuffPassive(EffectiveDamageDealtUpBuff) { targetSelf() }
val SelfCriticalUpBuffPassive : PassiveEffect = GenericBuffPassive(CriticalUpBuff) { targetSelf() }
val TeamAPDownBuffPassive: PassiveEffect = GenericBuffPassive(ApDownBuff) { targetAllyAoe() }
val SelfClimaxDamageUpBuffPassive: PassiveEffect = GenericBuffPassive(ClimaxDamageUpBuff) { targetSelf() }

val TeamConfusionResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(ConfusionResistanceBuff) { targetAllyAoe() }
val TeamStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff) { targetAllyAoe() }
val SelfStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff) { targetSelf() }
val TeamStunResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StunResistanceBuff) { targetAllyAoe() }

val EnemyBack1ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff) { targetBack(1) }
val EnemyBack1DazeBuffPassive: PassiveEffect = CountableDebuffPassive(CountableBuff.Daze) { targetBack(1) }
val EnemyFront3NightmareBuffPassive : PassiveEffect = DebuffPassive(NightmareBuff) { targetFront(3) }
val EnemyBack3StopBuffPassive : PassiveEffect = DebuffPassive(StopBuff) { targetBack(3) }

private data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartPositive

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
    override val category = PassiveEffectCategory.TurnStartPositive

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

private data class CountableDebuffPassive(
    val buffEffect: CountableBuff,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name}"
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) =
        target(context).act {
            applyCountableBuff(buffEffect, value)
        }
}
