package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.condition
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.advantagedAgainst
import xyz.qwewqa.relive.simulator.core.stage.buff.*

val WeAreOnTheStageSnow = weAreOnTheStageAttributeStageEffect(Attribute.Snow)
val WeAreOnTheStageCloud = weAreOnTheStageAttributeStageEffect(Attribute.Cloud)
val WeAreOnTheStageMoon = weAreOnTheStageAttributeStageEffect(Attribute.Moon)
val WeAreOnTheStageFlower = weAreOnTheStageAttributeStageEffect(Attribute.Flower)
val WeAreOnTheStageWind = weAreOnTheStageAttributeStageEffect(Attribute.Wind)
val WeAreOnTheStageSpace = weAreOnTheStageAttributeStageEffect(Attribute.Space)
val ConcentrationSpace = concentrationAttributeStageEffect(Attribute.Space, 15)
val ConcentrationWind = concentrationAttributeStageEffect(Attribute.Wind, 16)
val ConcentrationSnow = concentrationAttributeStageEffect(Attribute.Snow, 17)
val ApplauseFlower = applauseAttributeStageEffect(Attribute.Flower)
val ApplauseWind = applauseAttributeStageEffect(Attribute.Wind)
val ApplauseSnow = applauseAttributeStageEffect(Attribute.Snow)
val ApplauseCloud = applauseAttributeStageEffect(Attribute.Cloud)
val ApplauseMoon = applauseAttributeStageEffect(Attribute.Moon)
val ApplauseSpace = applauseAttributeStageEffect(Attribute.Space)
val StandingOvationFlower = standingOvationAttributeStageEffect(Attribute.Flower)
val StandingOvationWind = standingOvationAttributeStageEffect(Attribute.Wind)
val StandingOvationSnow = standingOvationAttributeStageEffect(Attribute.Snow)
val StandingOvationCloud = standingOvationAttributeStageEffect(Attribute.Cloud)
val StandingOvationMoon = standingOvationAttributeStageEffect(Attribute.Moon)
val StandingOvationSpace = standingOvationAttributeStageEffect(Attribute.Space)

// Reminder: Attribute starts at Flower = 1 (0 is Neutral)

private fun weAreOnTheStageAttributeStageEffect(attribute: Attribute) =
    stageEffectData(1 + attribute.ordinal).makeStageEffect(
        listOf(
            ActPowerUpBuff,
            NormalDefenseUpBuff,
            SpecialDefenseUpBuff,
            againstAttributeDamageDealtUpBuff(attribute.advantagedAgainst ?: error("Invalid attribute.")),
        ).targeting(stageEffectTargetAoe(condition = attribute.condition())),
    )

//TODO: Check if this SE works correctly
private fun concentrationAttributeStageEffect(attribute: Attribute, id: Int) = stageEffectData(id).makeStageEffect(
    listOf(
        ActPowerDownBuff,
        NormalDefenseDownBuff,
        SpecialDefenseDownBuff,
        againstAttributeDamageReceivedUpBuff(attribute),
    ).targeting(stageEffectTargetAoe(condition = attribute.condition())),
)

private fun applauseAttributeStageEffect(attribute: Attribute) =
    stageEffectData(36 + attribute.ordinal).makeStageEffect(
        listOf(
            DamageDealtUpBuff,
            NormalDefenseUpBuff,
            SpecialDefenseUpBuff,
        ).targeting(stageEffectTargetAoe(condition = attribute.condition())),
    )

private fun standingOvationAttributeStageEffect(attribute: Attribute) =
    // Temporary measure, until all ovation SEs are in data
    (stageEffectDataOrNull(64 + attribute.ordinal) ?: stageEffectData(65)).copy(iconId = 64 + attribute.ordinal)
        .makeStageEffect(
            listOf(
                DamageDealtUpBuff,
                NormalDefenseUpBuff,
                SpecialDefenseUpBuff,
            ).targeting(stageEffectTargetAoe(condition = attribute.condition())),
        )
