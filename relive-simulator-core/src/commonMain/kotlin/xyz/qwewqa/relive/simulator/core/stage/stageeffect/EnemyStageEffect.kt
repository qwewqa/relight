package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val SelfTrapping = stageEffectData(23).makeStageEffect(
    listOf(
        Buffs.StunBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)


val AlluringEyes = stageEffectData(45).makeStageEffect(
    listOf(
        Buffs.LovesicknessBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

// TODO: Fumbling
val DeathsKiss = stageEffectData(25).makeStageEffect(
    listOf(
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

// TODO: Curse
val AfterlifeTrials = stageEffectData(28).makeStageEffect(
    listOf(
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val DisasterHail = stageEffectData(24).makeStageEffect(
    listOf(
        Buffs.BurnBuff,
        Buffs.ConfusionBuff,
        Buffs.BlindnessBuff,
    ).targeting(stageEffectTargetAoe())
)

val RoaringFire = stageEffectData(21).makeStageEffect(
    listOf(
        Buffs.BurnBuff,
        Buffs.BlindnessBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val Thunder = stageEffectData(13).makeStageEffect(
    listOf(
        Buffs.ElectricShockBuff,
        Buffs.ActPowerDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val SunsetTune = stageEffectData(8).makeStageEffect(
    listOf(
        Buffs.ActPowerDownBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val Hesitation = stageEffectData(54).makeStageEffect(
    listOf(
        Buffs.ApUpBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe()) + listOf(
        Buffs.ApUp2Buff,
    ).targeting(stageEffectTargetAoe(condition = SeishoOnlyCondition)),
)

val CelestialHighlights = stageEffectData(60).makeStageEffect(
    listOf(
        Buffs.ContractionBuff,
        Buffs.ActPowerDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val ShadowStupor = stageEffectData(9).makeStageEffect(
    listOf(
        Buffs.AgilityDownBuff,
        Buffs.ActPowerDownBuff,
        Buffs.DexterityDownBuff,
    ).targeting(stageEffectTargetAoe())
)

// TODO: evil spirit and brilliance down per turn
val Catastrophe = stageEffectData(64).makeStageEffect(
    listOf(
        Buffs.ElectricShockBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val SugaryCorruption = stageEffectData(56).makeStageEffect(
    listOf(
        Buffs.BrillianceGainDownBuff,
        Buffs.AgilityDownBuff,
    ).targeting(stageEffectTargetAoe())
)

//TODO: SE Seal
val PlanOfTheAbyss = stageEffectData(57).makeStageEffect(
    listOf(
        Buffs.ActPowerDownBuff,
    ).targeting(stageEffectTargetAoe())
)


val BattleStrategy = stageEffectData(74).makeStageEffect(
    listOf(
        Buffs.ContractionBuff,
        Buffs.AgilityDownBuff,
    ).targeting(stageEffectTargetAoe())
)

val GrayWorld = stageEffectData(76).makeStageEffect(
    listOf(
        Buffs.ConfusionBuff,
        Buffs.ElectricShockBuff,
        Buffs.NormalDefenseDownBuff,
        Buffs.SpecialDefenseDownBuff,
    ).targeting(stageEffectTargetAoe())
)