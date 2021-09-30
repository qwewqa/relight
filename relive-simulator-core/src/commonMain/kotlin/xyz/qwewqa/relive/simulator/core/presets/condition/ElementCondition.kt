package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.stage.character.School

val FlowerOnlyCondition = attributeCondition(Attribute.Flower)
val WindOnlyCondition = attributeCondition(Attribute.Wind)
val IceOnlyCondition = attributeCondition(Attribute.Ice)
val MoonOnlyCondition = attributeCondition(Attribute.Moon)
val SpaceOnlyCondition = attributeCondition(Attribute.Space)
val CloudOnlyCondition = attributeCondition(Attribute.Cloud)
val DreamOnlyCondition = attributeCondition(Attribute.Dream)

private fun attributeCondition(attribute: Attribute) = NamedCondition(attribute.name) {
    it.dress.attribute == attribute
}
