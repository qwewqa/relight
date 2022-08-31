package xyz.qwewqa.relive.simulator.core.presets.accessory

val accessories = listOf(
    emptyAccessory,
    beachVolleyball,
    goldBarsOfFrontier,
).sortedBy { it.id }.associateBy { it.name }
