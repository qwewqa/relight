package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000156 = PartialMemoirBlueprint(
  id = 4000156,
  name = "白昼夢のような舞台",
  rarity = 4,
  baseStats = StatData(
    hp = 445,
    actPower = 113,
    normalDefense = 363,
    specialDefense = 363,
  ),
  growthStats = StatData(
    hp = 45000,
    actPower = 3000,
    normalDefense = 3000,
    specialDefense = 3000,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(0, 0, 0, 0, 0),
        times = listOf(1, 1, 1, 1, 2),
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
      ),
    ),
  ),
)
