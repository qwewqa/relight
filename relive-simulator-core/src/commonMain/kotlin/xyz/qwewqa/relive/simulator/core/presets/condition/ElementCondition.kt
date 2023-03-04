package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FlowerOnlyCondition = attributeCondition(Attribute.Flower)
val WindOnlyCondition = attributeCondition(Attribute.Wind)
val SnowOnlyCondition = attributeCondition(Attribute.Snow)
val MoonOnlyCondition = attributeCondition(Attribute.Moon)
val SpaceOnlyCondition = attributeCondition(Attribute.Space)
val CloudOnlyCondition = attributeCondition(Attribute.Cloud)
val DreamOnlyCondition = attributeCondition(Attribute.Dream)
val SunOnlyCondition = attributeCondition(Attribute.Sun)
val StarOnlyCondition = attributeCondition(Attribute.Star)

fun Attribute.condition() =
    when (this) {
      Attribute.Neutral ->
          error("Neutral element condition not supported.") // Not expecting for this to be needed
      Attribute.Flower -> FlowerOnlyCondition
      Attribute.Wind -> WindOnlyCondition
      Attribute.Snow -> SnowOnlyCondition
      Attribute.Moon -> MoonOnlyCondition
      Attribute.Space -> SpaceOnlyCondition
      Attribute.Cloud -> CloudOnlyCondition
      Attribute.Dream -> DreamOnlyCondition
      Attribute.Sun -> SunOnlyCondition
      Attribute.Star -> StarOnlyCondition
    }

fun attributeCondition(attribute: Attribute) =
    NamedCondition(attribute.name) { it.dress.attribute == attribute }
