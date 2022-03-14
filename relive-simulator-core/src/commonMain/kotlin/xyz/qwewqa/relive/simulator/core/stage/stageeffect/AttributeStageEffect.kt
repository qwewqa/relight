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
