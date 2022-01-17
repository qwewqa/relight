package xyz.qwewqa.relive.simulator.core.stage.stageeffect

import xyz.qwewqa.relive.simulator.core.presets.condition.condition
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.advantagedAgainst
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.AgainstAttributeDamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalDefenseUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialDefenseUpBuff

val WeAreOnTheStageSnow = attributeStageEffect(Attribute.Snow)
val WeAreOnTheStageCloud = attributeStageEffect(Attribute.Cloud)
val WeAreOnTheStageMoon = attributeStageEffect(Attribute.Moon)
val WeAreOnTheStageFlower = attributeStageEffect(Attribute.Flower)

private fun attributeStageEffect(attribute: Attribute) = StageEffect(
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