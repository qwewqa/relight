package xyz.qwewqa.relive.simulator.core.presets.accessory

val accessories = listOf(
    emptyAccessory,
    beachVolleyball,
    goldBarsOfFrontier,
    memorablePotpourri,
    flowerRing,
    flowerPendant,
    flowerBrooch,
    windRing,
    windPendant,
    windBrooch,
    snowRing,
    snowPendant,
    snowBrooch,
    moonRing,
    moonPendant,
    moonBrooch,
    spaceRing,
    spacePendant,
    spaceBrooch,
).sortedBy { it.id }.associateBy { it.name }
