package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff


interface BuffEffect {
    val name: String
    val iconId: Int
    val category: BuffCategory
    val isLocked: Boolean get() = false
}

// List of priorities for displaying buffs besides HP bars.
// Not meant for sort order in comprehensive lists.
// This is for highlighting the most important buffs, but not necessarily grouping them by type of effect.
private val buffDisplayPriorityList: List<BuffEffect> = listOf(
    CountableBuff.Daze,
    CountableBuff.Pride,
    CountableBuff.Evasion,
    CountableBuff.Fortitude,
    CountableBuff.Revive,
    AbnormalGuardBuff,
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
    NegativeEffectResistanceBuff,
    LockedNegativeEffectResistanceBuff,
    PositiveEffectResistanceBuff,
    LockedNegativeCountableResistanceBuff,
    ResilienceBuff,
    InvincibilityBuff,
    AbsorbBuff,
    CounterHealBuff,
    AggroBuff,
    LockedAggroBuff,
    ProvokeBuff,
    MarkBuff,
    AntiMarkBuff,
    CountableBuff.WeakSpot,
    ApDownBuff,
    LockedApDownBuff,
    Ap2DownBuff,
    ApUpBuff,
    LockedApUpBuff,
    ActPowerDownBuff,
    DexterityDownBuff,
    CriticalDownBuff,
    EvasionRateDownBuff,
    AccuracyRateDownBuff,
    AgilityDownBuff,
    NormalDefenseDownBuff,
    SpecialDefenseDownBuff,
    DamageTakenUpBuff,
    BrillianceGainDownBuff,
    ClimaxDamageDownBuff,
    ActPowerUpBuff,
    DexterityUpBuff,
    CriticalUpBuff,
    EffectiveDamageDealtUpBuff,
    DamageDealtUpBuff,
    EvasionRateUpBuff,
    AccuracyRateUpBuff,
    AgilityUpBuff,
    NormalDefenseUpBuff,
    SpecialDefenseUpBuff,
    BrillianceGainUpBuff,
    ClimaxDamageUpBuff,
    DamageTakenDownBuff,
    PerfectAimBuff,
    NormalReflectBuff,
    SpecialReflectBuff,
    NormalBarrierBuff,
    SpecialBarrierBuff,
)

private val buffDisplayPriorityMap: Map<BuffEffect, Int> = buffDisplayPriorityList
    .mapIndexed { index, buff -> buff to buffDisplayPriorityList.size - index }
    .toMap()

val BuffEffect.displayPriority: Int get() = buffDisplayPriorityMap[this] ?: -1
