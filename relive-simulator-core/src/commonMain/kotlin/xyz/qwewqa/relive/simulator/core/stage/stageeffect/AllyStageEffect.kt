package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val AngelicSmile = stageEffectData(22).makeStageEffect(
    listOf(
        Buffs.DamageReceivedDownBuff,
        Buffs.NormalDefenseUpBuff,
        Buffs.SpecialDefenseUpBuff,
    ).targeting(stageEffectTargetAoe())
)

val BloomingFlowers = stageEffectData(27).makeStageEffect(
    listOf(
        Buffs.DexterityUpBuff,
        Buffs.HpRegenBuff,
    ).targeting(stageEffectTargetAoe())
)

val Bullseye = stageEffectData(36).makeStageEffect(
    listOf(
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.PerfectAimBuff,
    ).targeting(stageEffectTargetAoe())
)

val JunnaHoshimisStage = stageEffectData(29).makeStageEffect(
    listOf(
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
    ).targeting(stageEffectTargetAoe())
)

val LightOfCourage = stageEffectData(1).makeStageEffect(
    listOf(
        Buffs.ActPowerUpBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
    ).targeting(stageEffectTargetAoe())
)

val TrialsForHeroesTemptationsForSaints = stageEffectData(30).makeStageEffect(
    listOf(
        Buffs.ClimaxDamageUpBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.AgilityUpBuff,
    ).targeting(stageEffectTargetAoe(condition = MayaOnlyCondition or ClaudineOnlyCondition))
)

val FlamesFallingTogether = stageEffectData(32).makeStageEffect(
    listOf(
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe(condition = MayaOnlyCondition or ClaudineOnlyCondition))
)

val WildHope = stageEffectData(20).makeStageEffect(
    listOf(
        Buffs.ActPowerUpBuff,
        Buffs.NormalDefenseUpBuff,
        Buffs.SpecialDefenseUpBuff,
        Buffs.CriticalUpBuff,
    ).targeting(stageEffectTargetAoe(condition = FrontierOnlyCondition))
)

val Majestic = stageEffectData(53).makeStageEffect(
    listOf(
        Buffs.ActPowerUpBuff,
        Buffs.NormalDefenseUpBuff,
        Buffs.SpecialDefenseUpBuff,
        Buffs.CriticalUpBuff,
    ).targeting(stageEffectTargetAoe(condition = RinmeikanOnlyCondition))
)

val ThisIsSeparation = stageEffectData(33).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
    ).targeting(stageEffectTargetAoe(condition = KaorukoOnlyCondition))
)

val YoureAllHopeless = stageEffectData(34).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.CounterHealBuff,
    ).targeting(stageEffectTargetAoe(condition = KaorukoOnlyCondition.or(FutabaOnlyCondition)))
)

val GlitteringStage = stageEffectData(35).makeStageEffect(
    listOf(
        Buffs.ActPowerUpBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.AgilityUpBuff,
        Buffs.EffectiveDamageDealtUpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition))
)

val SweetMoment = stageEffectData(31).makeStageEffect(
    listOf(
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
        Buffs.EffectiveDamageDealtUpBuff,
    ).targeting(stageEffectTargetAoe())
)


val WeAreRivals = stageEffectData(43).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.DamageReceivedDownBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition))
)

val RoyalAuthority = stageEffectData(44).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.ActPowerUpBuff,
        Buffs.DamageReceivedDownBuff,
    ).targeting(stageEffectTargetAoe(condition = SiegfeldOnlyCondition))
)

val ThisIsTheStage = stageEffectData(48).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.EffectiveDamageDealtUpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition)) + listOf(
        Buffs.DexterityUpBuff,
    ).targeting(stageEffectTargetAoe(condition = KarenOnlyCondition or HikariOnlyCondition)),
)

val GoldenVitality = stageEffectData(58).makeStageEffect(
    listOf(
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
        Buffs.NegativeCountableEffectResistanceUpBuff,
        Buffs.DamageReceivedDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val SagesCovenant = stageEffectData(59).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.PerfectAimBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
    ).targeting(stageEffectTargetAoe()) + listOf(
        Buffs.HpRegenBuff,
    ).targeting(stageEffectTargetAoe(condition = JunnaOnlyCondition or NanaOnlyCondition)),
)

val BeautifulNobleAndFun = stageEffectData(61).makeStageEffect(
    listOf(
        Buffs.ApDown2Buff,
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
        Buffs.ActPowerUpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeiranOnlyCondition)),
)

val LightningShade = stageEffectData(10).makeStageEffect(
    listOf(
        Buffs.AgilityUpBuff,
        Buffs.ActPowerUpBuff,
        Buffs.DexterityUpBuff,
    ).targeting(stageEffectTargetAoe()),
)

val DivinePower = stageEffectData(52).makeStageEffect(
    listOf(
        Buffs.ApDown2Buff,
        Buffs.NegativeCountableEffectResistanceUpBuff,
        Buffs.ActPowerUpBuff,
    ).targeting(stageEffectTargetAoe()) + listOf(
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
    ).targeting(stageEffectTargetAoe(condition = RoVOnlyCondition)),
)

val HappyFootsteps = stageEffectData(62).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
        Buffs.ActPowerUpBuff,
        Buffs.BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe()),
)

val LeapOath = stageEffectData(63).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.NegativeCountableEffectResistanceUpBuff,
        Buffs.ActPowerUpBuff,
        Buffs.BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe()),
)

val ElegantInvitation = stageEffectData(71).makeStageEffect(
    listOf(
        Buffs.NegativeCountableEffectResistanceUpBuff,
        Buffs.ActPowerUpBuff,
        Buffs.NormalDefenseUpBuff,
        Buffs.SpecialDefenseUpBuff,
        Buffs.CriticalUpBuff,
    ).targeting(stageEffectTargetAoe()),
)

val FloatingWithTheTide = stageEffectData(72).makeStageEffect(
    listOf(
        Buffs.ApDownBuff,
        Buffs.ContinuousNegativeEffectResistanceUpBuff,
        Buffs.ActPowerUpBuff,
    ).targeting(stageEffectTargetAoe()),
)

val SparklingTide = stageEffectData(73).makeStageEffect(
    listOf(
        Buffs.EvasionUpBuff,
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe()),
)

val MellowFlavor = stageEffectData(55).makeStageEffect(
    listOf(
        Buffs.DexterityUpBuff,
        Buffs.CriticalUpBuff,
        Buffs.AgilityUpBuff,
        Buffs.CounterHealBuff,
    ).targeting(stageEffectTargetAoe()),
)
