package xyz.qwewqa.relive.simulator.core.presets.accessory

import xyz.qwewqa.relive.simulator.core.presets.accessory.generated.accessory32
import xyz.qwewqa.relive.simulator.core.presets.accessory.generated.accessory34
import xyz.qwewqa.relive.simulator.core.presets.accessory.generated.accessory35
import xyz.qwewqa.relive.simulator.core.stage.accessory.AccessoryBlueprint

val emptyAccessory = AccessoryBlueprint(
    0,
    0,
    "None",
    null,
    emptyList(),
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    0,
    List(100) { 0 },
    emptySet(),
)

val beachVolleyball = accessory32("Beach Volleyball")
val goldBarsOfFrontier = accessory34("Gold Bars of Frontier")
val memorablePotpourri = accessory35("Memorable Potpourri")
