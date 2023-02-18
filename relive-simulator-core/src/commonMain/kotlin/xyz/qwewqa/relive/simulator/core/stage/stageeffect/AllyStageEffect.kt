package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val AngelicSmile = stageEffectData(22).makeStageEffect(
    listOf(
        DamageReceivedDownBuff,
        NormalDefenseUpBuff,
        SpecialDefenseUpBuff,
    ).targeting(stageEffectTargetAoe())
)

val BloomingFlowers = stageEffectData(27).makeStageEffect(
    listOf(
        DexterityUpBuff,
        HpRegenBuff,
    ).targeting(stageEffectTargetAoe())
)

val Bullseye = stageEffectData(36).makeStageEffect(
    listOf(
        DexterityUpBuff,
        CriticalUpBuff,
        PerfectAimBuff,
    ).targeting(stageEffectTargetAoe())
)

val JunnaHoshimisStage = stageEffectData(29).makeStageEffect(
    listOf(
        DexterityUpBuff,
        CriticalUpBuff,
    ).targeting(stageEffectTargetAoe())
)

val LightOfCourage = stageEffectData(1).makeStageEffect(
    listOf(
        ActPowerUpBuff,
        DexterityUpBuff,
        CriticalUpBuff,
    ).targeting(stageEffectTargetAoe())
)

val TrialsForHeroesTemptationsForSaints = stageEffectData(30).makeStageEffect(
    listOf(
        ClimaxDamageUpBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        AgilityUpBuff,
    ).targeting(stageEffectTargetAoe(condition = MayaOnlyCondition or ClaudineOnlyCondition))
)

val FlamesFallingTogether = stageEffectData(32).makeStageEffect(
    listOf(
        DexterityUpBuff,
        CriticalUpBuff,
        BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe(condition = MayaOnlyCondition or ClaudineOnlyCondition))
)

val WildHope = stageEffectData(20).makeStageEffect(
    listOf(
        ActPowerUpBuff,
        NormalDefenseUpBuff,
        SpecialDefenseUpBuff,
        CriticalUpBuff,
    ).targeting(stageEffectTargetAoe(condition = FrontierOnlyCondition))
)

val Majestic = stageEffectData(53).makeStageEffect(
    listOf(
        ActPowerUpBuff,
        NormalDefenseUpBuff,
        SpecialDefenseUpBuff,
        CriticalUpBuff,
    ).targeting(stageEffectTargetAoe(condition = RinmeikanOnlyCondition))
)

val ThisIsSeparation = stageEffectData(33).makeStageEffect(
    listOf(
        ApDownBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        NegativeEffectResistanceUpBuff,
    ).targeting(stageEffectTargetAoe(condition = KaorukoOnlyCondition))
)

val YoureAllHopeless = stageEffectData(34).makeStageEffect(
    listOf(
        ApDownBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        CounterHealBuff,
    ).targeting(stageEffectTargetAoe(condition = KaorukoOnlyCondition.or(FutabaOnlyCondition)))
)

val GlitteringStage = stageEffectData(35).makeStageEffect(
    listOf(
        ActPowerUpBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        AgilityUpBuff,
        EffectiveDamageDealtUpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition))
)

val SweetMoment = stageEffectData(31).makeStageEffect(
    listOf(
        NegativeEffectResistanceUpBuff,
        EffectiveDamageDealtUpBuff,
    ).targeting(stageEffectTargetAoe())
)


val WeAreRivals = stageEffectData(43).makeStageEffect(
    listOf(
        ApDownBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        DamageReceivedDownBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition))
)

val RoyalAuthority = stageEffectData(44).makeStageEffect(
    listOf(
        ApDownBuff,
        ActPowerUpBuff,
        DamageReceivedDownBuff,
    ).targeting(stageEffectTargetAoe(condition = SiegfeldOnlyCondition))
)

val ThisIsTheStage = stageEffectData(48).makeStageEffect(
    listOf(
        ApDownBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        EffectiveDamageDealtUpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition)) + listOf(
        DexterityUpBuff,
    ).targeting(stageEffectTargetAoe(condition = KarenOnlyCondition or HikariOnlyCondition)),
)

val GoldenVitality = stageEffectData(58).makeStageEffect(
    listOf(
        NegativeEffectResistanceUpBuff,
        NegativeCountableEffectResistanceUpBuff,
        DamageReceivedDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val SagesCovenant = stageEffectData(59).makeStageEffect(
    listOf(
        ApDownBuff,
        PerfectAimBuff,
        DexterityUpBuff,
        CriticalUpBuff,
    ).targeting(stageEffectTargetAoe()) + listOf(
        HpRegenBuff,
    ).targeting(stageEffectTargetAoe(condition = JunnaOnlyCondition or NanaOnlyCondition)),
)

val BeautifulNobleAndFun = stageEffectData(61).makeStageEffect(
    listOf(
        ApDown2Buff,
        NegativeEffectResistanceUpBuff,
        ActPowerUpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeiranOnlyCondition)),
)

val LightningShade = stageEffectData(10).makeStageEffect(
    listOf(
        AgilityUpBuff,
        ActPowerUpBuff,
        DexterityUpBuff,
    ).targeting(stageEffectTargetAoe()),
)

val DivinePower = stageEffectData(52).makeStageEffect(
    listOf(
        ApDown2Buff,
        NegativeCountableEffectResistanceUpBuff,
        ActPowerUpBuff,
    ).targeting(stageEffectTargetAoe()) + listOf(
        NegativeEffectResistanceUpBuff,
    ).targeting(stageEffectTargetAoe(condition = RoVOnlyCondition)),
)

val HappyFootsteps = stageEffectData(62).makeStageEffect(
    listOf(
        ApDownBuff,
        NegativeEffectResistanceUpBuff,
        ActPowerUpBuff,
        BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe()),
)

val LeapOath = stageEffectData(63).makeStageEffect(
    listOf(
        ApDownBuff,
        NegativeCountableEffectResistanceUpBuff,
        ActPowerUpBuff,
        BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe()),
)

val ElegantInvitation = stageEffectData(71).makeStageEffect(
    listOf(
        NegativeCountableEffectResistanceUpBuff,
        ActPowerUpBuff,
        NormalDefenseUpBuff,
        SpecialDefenseUpBuff,
        CriticalUpBuff,
    ).targeting(stageEffectTargetAoe()),
)

val FloatingWithTheTide = stageEffectData(72).makeStageEffect(
    listOf(
        ApDownBuff,
        NegativeEffectResistanceUpBuff,
        ActPowerUpBuff,
    ).targeting(stageEffectTargetAoe()),
)

val SparklingTide = stageEffectData(73).makeStageEffect(
    listOf(
        EvasionUpBuff,
        DexterityUpBuff,
        CriticalUpBuff,
        BrillianceRegenBuff,
    ).targeting(stageEffectTargetAoe()),
)

val MellowFlavor = stageEffectData(55).makeStageEffect(
    listOf(
        DexterityUpBuff,
        CriticalUpBuff,
        AgilityUpBuff,
        CounterHealBuff,
    ).targeting(stageEffectTargetAoe()),
)
