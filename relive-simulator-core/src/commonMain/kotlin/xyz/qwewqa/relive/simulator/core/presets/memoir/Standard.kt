package xyz.qwewqa.relive.simulator.core.presets.memoir

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.memoir.MemoirBlueprint

val EmptyMemoir = MemoirBlueprint(
    -1,
    name = "None",
    rarity = 4,
    cost = 0,
    baseStats = StatData(),
    growthStats = StatData(),
    baseAutoskills = listOf(),
    maxAutoskills = listOf(),
)
