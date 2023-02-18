package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff

sealed interface BuffEffect {
    val name: String
    val iconId: Int
    val category: BuffCategory
    val isLocked: Boolean get() = false
    val displayLockIcon: Boolean get() = isLocked
}

enum class BuffCategory {
    Positive,
    Negative,
}

// List of priorities for displaying buffs besides HP bars.
// Not meant for sort order in comprehensive lists.
// This is for highlighting the most important buffs, but not necessarily grouping them by type of effect.
private val buffDisplayPriorityList: List<BuffEffect> = listOf(
    CountableBuff.Daze,
    CountableBuff.Pride,
    CountableBuff.Evasion,
    CountableBuff.InvincibleRebirth,
    CountableBuff.Fortitude,
    CountableBuff.Revive,
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
    NegativeEffectResistanceUpBuff,
    LockedNegativeEffectResistanceUpBuff,
    PositiveEffectResistanceUpBuff,
    NegativeCountableEffectResistanceUpBuff,
    CountableBuff.Hope,
    CountableBuff.Cheer,
    ResilienceBuff,
    InvincibilityBuff,
    AbsorbBuff,
    CounterHealBuff,
    AggroBuff,
    LockedAggroBuff,
    ProvokeBuff,
    MarkBuff,
    FlippedMarkBuff,
    CountableBuff.WeakSpot,
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

private val buffDisplayPriorityMap: Map<BuffEffect, Int> = buffDisplayPriorityList
    .mapIndexed { index, buff -> buff to buffDisplayPriorityList.size - index }
    .toMap()

val BuffEffect.displayPriority: Int get() = buffDisplayPriorityMap[this] ?: -1
