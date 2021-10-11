package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

val SelfFortitudeBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Fortitude) { targetSelf() }
val SelfEvasionBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Evasion) { targetSelf() }
val SelfReviveBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Revive) { targetSelf() }

val TeamActPowerUpBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerUpBuff, "Team") { targetAllyAoe() }
val TeamDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, "Team") { targetAllyAoe() }
val TeamCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, "Team") { targetAllyAoe() }
val TeamEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, "Team") { targetAllyAoe() }
val SelfPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAim) { targetSelf() }
val SelfDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff) { targetSelf() }
val SelfEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff) { targetSelf() }
val SelfCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff) { targetSelf() }
val TeamAPDownBuffPassive: PassiveEffect = GenericBuffPassive(ApDownBuff, "Team") { targetAllyAoe() }
val SelfClimaxDamageUpBuffPassive: PassiveEffect = GenericBuffPassive(ClimaxDamageUpBuff) { targetSelf() }
val SelfNormalBarrierBuffPassive: PassiveEffect = GenericBuffPassive(NormalBarrierBuff) { targetSelf() }
val SelfSpecialBarrierBuffPassive: PassiveEffect = GenericBuffPassive(SpecialBarrierBuff) { targetSelf() }

val TeamConfusionResistanceBuffPassive: PassiveEffect =
    ResistanceBuffPassive(ConfusionResistanceBuff, "Team") { targetAllyAoe() }
val TeamStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff, "Team") { targetAllyAoe() }
val SelfStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff) { targetSelf() }
val TeamStunResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StunResistanceBuff, "Team") { targetAllyAoe() }
val TeamBurnResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(BurnResistanceBuff, "Team") { targetAllyAoe() }

val EnemyBack1ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff, "Enemy Back 1") { targetBack(1) }
val EnemyBack1DazeBuffPassive: PassiveEffect = CountableDebuffPassive(CountableBuff.Daze, "Enemy Back 1") { targetBack(1) }
val EnemyFront3NightmareBuffPassive: PassiveEffect = DebuffPassive(NightmareBuff, "Enemy Front 3") { targetFront(3) }
val EnemyBack3StopBuffPassive: PassiveEffect = DebuffPassive(StopBuff, "Enemy Back 3") { targetBack(3) }

private data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val targetName: String = "Self",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, time)
        }
}

private data class GenericCountableBuffPassive(
    val buff: CountableBuff,
    val targetName: String = "Self",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Buff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyCountableBuff(buff, time)
        }
}

private data class ResistanceBuffPassive(
    val buffEffect: BuffEffect,
    val targetName: String = "Team",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Resistance Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, time)
        }
}

private data class DebuffPassive(
    val buffEffect: BuffEffect,
    val targetName: String = "Enemy Team",
    val chance: Int = 100,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, time, chance)
        }
}

private data class CountableDebuffPassive(
    val buff: CountableBuff,
    val targetName: String = "Enemy Team",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Debuff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartNegative

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyCountableBuff(buff, value)
        }
}
