package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FreezeOnlyCondition = NamedCondition("Freeze") {
    it.isFrozen
}

val ElectricShockOnlyCondition = NamedCondition("Electric Shock") {
    it.isShocked
}

val LovesicknessOnlyCondition = NamedCondition("Lovesickness") {
    it.isLovesick
}

val BurnOnlyCondition = NamedCondition("Burn") {
    it.isBurned
}

val PoisonOnlyCondition = NamedCondition("Poison") {
    it.isPoisoned
}
