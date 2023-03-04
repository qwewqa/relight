package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AbsorbBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AccuracyDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ActPowerDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ActPowerUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ActionRestrictionResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AggroBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AgilityDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AgilityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AgonyBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApDown2Buff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BrillianceGainDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BrillianceGainUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ClimaxDamageDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ClimaxDamageUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ContinuousNegativeEffectResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.CounterHealBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.CriticalDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.CriticalUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.DamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.DamageReceivedDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.DamageReceivedUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.DexterityDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EffectiveDamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EvasionDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EvasionUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.FlippedMarkBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.InvincibilityBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedAggroBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedBurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedContinuousNegativeEffectResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedLovesicknessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedPoisonBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LockedStunBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.LovesicknessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.MarkBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NegativeCountableEffectResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NightmareBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NormalBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NormalDefenseDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NormalDefenseUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.NormalReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.PoisonBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.PositiveEffectResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ProvokeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ResilienceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SleepBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SpecialBarrierBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SpecialDefenseDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SpecialDefenseUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.SpecialReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.StopBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.StunBuff

sealed interface BuffEffect : FeatureImplementation {
  val name: String
  val iconId: Int
  val category: BuffCategory
  val isLocked: Boolean
    get() = false
  val displayLockIcon: Boolean
    get() = isLocked
}

enum class BuffCategory {
  Positive,
  Negative,
}

// List of priorities for displaying buffs besides HP bars.
// Not meant for sort order in comprehensive lists.
// This is for highlighting the most important buffs, but not necessarily grouping them by type of
// effect.
private val buffDisplayPriorityList: List<BuffEffect> =
    listOf(
        Buffs.DazeBuff,
        Buffs.ImpudenceBuff,
        Buffs.EvasionBuff,
        Buffs.InvincibleRebirth,
        Buffs.Fortitude,
        Buffs.ReviveBuff,
        ActionRestrictionResistanceUpBuff,
        StopBuff,
        SleepBuff,
        NightmareBuff,
        ConfusionBuff,
        LockedConfusionBuff,
        StunBuff,
        LockedStunBuff,
        BlindnessBuff,
        LockedStunBuff,
        ElectricShockBuff,
        LockedElectricShockBuff,
        LovesicknessBuff,
        LockedLovesicknessBuff,
        AgonyBuff,
        BurnBuff,
        LockedBurnBuff,
        PoisonBuff,
        LockedPoisonBuff,
        ContinuousNegativeEffectResistanceUpBuff,
        LockedContinuousNegativeEffectResistanceUpBuff,
        PositiveEffectResistanceUpBuff,
        NegativeCountableEffectResistanceUpBuff,
        Buffs.HopeBuff,
        Buffs.CheerBuff,
        ResilienceBuff,
        InvincibilityBuff,
        AbsorbBuff,
        CounterHealBuff,
        AggroBuff,
        LockedAggroBuff,
        ProvokeBuff,
        MarkBuff,
        FlippedMarkBuff,
        Buffs.WeakSpotBuff,
        ApDownBuff,
        LockedApDownBuff,
        ApDown2Buff,
        ApUpBuff,
        LockedApUpBuff,
        ActPowerDownBuff,
        DexterityDownBuff,
        CriticalDownBuff,
        EvasionDownBuff,
        AccuracyDownBuff,
        AgilityDownBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
        DamageReceivedUpBuff,
        BrillianceGainDownBuff,
        ClimaxDamageDownBuff,
        ActPowerUpBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        EffectiveDamageDealtUpBuff,
        DamageDealtUpBuff,
        EvasionUpBuff,
        ActPowerUpBuff,
        AgilityUpBuff,
        NormalDefenseUpBuff,
        SpecialDefenseUpBuff,
        BrillianceGainUpBuff,
        ClimaxDamageUpBuff,
        DamageReceivedDownBuff,
        PerfectAimBuff,
        NormalReflectBuff,
        SpecialReflectBuff,
        NormalBarrierBuff,
        SpecialBarrierBuff,
    )

private val buffDisplayPriorityMap: Map<BuffEffect, Int> =
    buffDisplayPriorityList
        .mapIndexed { index, buff -> buff to buffDisplayPriorityList.size - index }
        .toMap()

val BuffEffect.displayPriority: Int
  get() = buffDisplayPriorityMap[this] ?: -1
