package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val _equip4000331 = PartialMemoirBlueprint(
  id = 4000331,
  name = "これにて縁切りや",
  rarity = 4,
  cost = 100,
  baseStats = StatData(
    hp = 10000,
    actPower = 500,
    normalDefense = 1000,
    specialDefense = 1000,
  ),
  growthStats = StatData(
    hp = 379750,
    actPower = 25320,
    normalDefense = 12670,
    specialDefense = 12670,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
    ),
  ),
  additionalTags = listOf(EffectTag.Kaoruko)
)
