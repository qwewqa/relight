package xyz.qwewqa.relive.simulator.core.presets.accessory

val accessories = listOf(
    emptyAccessory,
    beachVolleyball,
    goldBarsOfFrontier,
    memorablePotpourri,
).sortedBy { it.id }.associateBy { it.name }
