package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FlowerOnlyCondition = NamedCondition("Flower Only") {
    it.dress.attribute == Attribute.Flower
}

val IceOnlyCondition = NamedCondition("Ice Only") {
    it.dress.attribute == Attribute.Ice
}
