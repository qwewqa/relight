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
val ConcentrationSpace = concentrationAttributeStageEffect(Attribute.Space)
val ConcentrationWind = concentrationAttributeStageEffect(Attribute.Wind)
val ConcentrationSnow = concentrationAttributeStageEffect(Attribute.Snow)
val ApplauseSpace = applauseAttributeStageEffect(Attribute.Space)
val ApplauseCloud = applauseAttributeStageEffect(Attribute.Cloud)

private fun weAreOnTheStageAttributeStageEffect(attribute: Attribute) = StageEffect(
    "We Are on the Stage (${attribute.name})",
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
            StageBuff(AgainstAttributeDamageDealtUpBuff(attribute.advantagedAgainst ?: error("Invalid attribute.")), value),
        )
    },
    StageEffectTarget.All,
    attribute.condition(),
)

//TODO: Check if this SE works correctly
private fun concentrationAttributeStageEffect(attribute: Attribute) = StageEffect(
    "Concentration (${attribute.name})",
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
