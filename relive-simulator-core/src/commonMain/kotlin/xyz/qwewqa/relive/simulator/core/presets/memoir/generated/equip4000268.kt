package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val _equip4000268 = PartialMemoirBlueprint(
  id = 4000268,
  name = "『BEACH！！』",
  rarity = 4,
  cost = 12,
  baseStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 168,
    specialDefense = 168,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 8000,
    specialDefense = 8000,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(10, 10, 15, 20, 25),
        times = listOf(1, 1, 1, 1, 2),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(10, 10, 15, 20, 25),
        times = listOf(1, 1, 1, 1, 2),
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
  additionalTags = listOf(EffectTag.Akira, EffectTag.Yachiyo)
)
