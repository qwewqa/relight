package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000149 = PartialMemoirBlueprint(
  id = 4000149,
  name = "大切な場所のために",
  rarity = 4,
  baseStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 289,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 9000,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(2, 2, 2, 2, 1),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(5000, 5000, 6000, 7500, 10000),
        times = listOf(0, 0, 0, 0, 0),
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
