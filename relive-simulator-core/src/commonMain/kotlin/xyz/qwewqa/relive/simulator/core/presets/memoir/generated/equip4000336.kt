package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val _equip4000336 = PartialMemoirBlueprint(
  id = 4000336,
  name = "One special day ひかり",
  rarity = 4,
  cost = 12,
  baseStats = StatData(
    hp = 210,
    actPower = 154,
    normalDefense = 158,
    specialDefense = 158,
  ),
  growthStats = StatData(
    hp = 40000,
    actPower = 7800,
    normalDefense = 1800,
    specialDefense = 1800,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(10, 10, 11, 13, 15),
        times = listOf(2, 2, 2, 2, 3),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(10, 10, 11, 13, 15),
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
    ),
  ),
  additionalTags = listOf(EffectTag.Hikari)
)
