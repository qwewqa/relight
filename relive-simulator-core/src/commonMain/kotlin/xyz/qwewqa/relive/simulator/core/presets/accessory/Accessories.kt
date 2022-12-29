package xyz.qwewqa.relive.simulator.core.presets.accessory

val accessories = listOf(
    emptyAccessory,
    beachVolleyball,
    goldBarsOfFrontier,
    memorablePotpourri,
    moonRing,
    moonPendant,
    moonBrooch,
    spaceRing,
    spacePendant,
    spaceBrooch,
).sortedBy { it.id }.associateBy { it.name }
