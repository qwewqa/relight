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
val ConcentrationWind = concentrationAttributeStageEffect(Attribute.Wind, 17)
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

private fun weAreOnTheStageAttributeStageEffect(attribute: Attribute) = StageEffect(
    "We Are on the Stage (${attribute.name})",
    1 + attribute.ordinal,
    listOf(
        20,
        25,
        30,
        40,
        50,
    ).map { value ->
        listOf(
            StageBuff(ActPowerUpBuff, value),
            StageBuff(NormalDefenseUpBuff, value),
            StageBuff(SpecialDefenseUpBuff, value),
            StageBuff(againstAttributeDamageDealtUpBuff(attribute.advantagedAgainst ?: error("Invalid attribute.")), value),
        )
    },
    StageEffectTarget.All,
    attribute.condition(),
)

//TODO: Check if this SE works correctly
private fun concentrationAttributeStageEffect(attribute: Attribute, iconId: Int) = StageEffect(
    "Concentration (${attribute.name})",
    iconId,
    listOf(
        20,
        25,
        30,
        40,
        50,
    ).map { value ->
        listOf(
            StageBuff(ActPowerDownBuff, value),
            StageBuff(NormalDefenseDownBuff, value),
            StageBuff(SpecialDefenseDownBuff, value),
            StageBuff(AgainstAttributeDamageTakenUpBuff(attribute), value),
        )
    },
    StageEffectTarget.All,
    (attribute.advantagedAgainst  ?: error("Invalid attribute.")).condition(),
)
private fun applauseAttributeStageEffect(attribute: Attribute) = StageEffect(
    "Applause (${attribute.name})",
    36 + attribute.ordinal,
    listOf(
        listOf(
            StageBuff(DamageDealtUpBuff, 20),
            StageBuff(NormalDefenseUpBuff, 20),
            StageBuff(SpecialDefenseUpBuff, 20),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 25),
            StageBuff(NormalDefenseUpBuff, 25),
            StageBuff(SpecialDefenseUpBuff, 25),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 30),
            StageBuff(NormalDefenseUpBuff, 30),
            StageBuff(SpecialDefenseUpBuff, 30),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 35),
            StageBuff(NormalDefenseUpBuff, 40),
            StageBuff(SpecialDefenseUpBuff, 40),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 40),
            StageBuff(NormalDefenseUpBuff, 50),
            StageBuff(SpecialDefenseUpBuff, 50),
        ),
    ),
    StageEffectTarget.All,
    attribute.condition(),
)

private fun standingOvationAttributeStageEffect(attribute: Attribute) = StageEffect(
    "Standing Ovation (${attribute.name})",
    64 + attribute.ordinal,
    listOf(
        listOf(
            StageBuff(DamageDealtUpBuff, 40),
            StageBuff(NormalDefenseUpBuff, 20),
            StageBuff(SpecialDefenseUpBuff, 20),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 45),
            StageBuff(NormalDefenseUpBuff, 25),
            StageBuff(SpecialDefenseUpBuff, 25),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 50),
            StageBuff(NormalDefenseUpBuff, 30),
            StageBuff(SpecialDefenseUpBuff, 30),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 55),
            StageBuff(NormalDefenseUpBuff, 40),
            StageBuff(SpecialDefenseUpBuff, 40),
        ),
        listOf(
            StageBuff(DamageDealtUpBuff, 60),
            StageBuff(NormalDefenseUpBuff, 50),
            StageBuff(SpecialDefenseUpBuff, 50),
        ),
    ),
    StageEffectTarget.All,
    attribute.condition(),
)