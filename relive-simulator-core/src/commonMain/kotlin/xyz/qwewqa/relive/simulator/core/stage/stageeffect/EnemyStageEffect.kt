package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val SelfTrapping = stageEffectData(23).makeStageEffect(
    listOf(
        StunBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)


val AlluringEyes = stageEffectData(45).makeStageEffect(
    listOf(
        LovesicknessBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

// TODO: Fumbling
val DeathsKiss = stageEffectData(25).makeStageEffect(
    listOf(
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

// TODO: Curse
val AfterlifeTrials = stageEffectData(28).makeStageEffect(
    listOf(
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val DisasterHail = stageEffectData(24).makeStageEffect(
    listOf(
        BurnBuff,
        ConfusionBuff,
        BlindnessBuff,
    ).targeting(stageEffectTargetAoe())
)

val RoaringFire = stageEffectData(21).makeStageEffect(
    listOf(
        BurnBuff,
        BlindnessBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val Thunder = stageEffectData(13).makeStageEffect(
    listOf(
        ElectricShockBuff,
        ActPowerDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val SunsetTune = stageEffectData(8).makeStageEffect(
    listOf(
        ActPowerDownBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val Hesitation = stageEffectData(54).makeStageEffect(
    listOf(
        ApUpBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe()) + listOf(
        Ap2UpBuff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition)),
)

val CelestialHighlights = stageEffectData(60).makeStageEffect(
    listOf(
        ConstrainBuff,
        ActPowerDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val ShadowStupor = stageEffectData(9).makeStageEffect(
    listOf(
        AgilityDownBuff,
        ActPowerDownBuff,
        DexterityDownBuff,
    ).targeting(stageEffectTargetAoe())
)

// TODO: evil spirit and brilliance down per turn
val Catastrophe = stageEffectData(64).makeStageEffect(
    listOf(
        ElectricShockBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val SugaryCorruption = stageEffectData(56).makeStageEffect(
    listOf(
        BrillianceGainDownBuff,
        AgilityDownBuff,
    ).targeting(stageEffectTargetAoe())
)

//TODO: SE Seal
val PlanOfTheAbyss = stageEffectData(57).makeStageEffect(
    listOf(
        ActPowerDownBuff,
    ).targeting(stageEffectTargetAoe())
)


val BattleStrategy = stageEffectData(74).makeStageEffect(
    listOf(
        ConstrainBuff,
        AgilityDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val GrayWorld = stageEffectData(76).makeStageEffect(
    listOf(
        ConfusionBuff,
        ElectricShockBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)