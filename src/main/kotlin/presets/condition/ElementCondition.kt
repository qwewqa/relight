package xyz.qwewqa.relive.simulator.presets.condition

import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.condition.NamedCondition

val FlowerOnlyCondition = NamedCondition("Flower Only") {
    it.dress.attribute == Attribute.Flower
}

val IceOnlyCondition = NamedCondition("Ice Only") {
    it.dress.attribute == Attribute.Ice
}
