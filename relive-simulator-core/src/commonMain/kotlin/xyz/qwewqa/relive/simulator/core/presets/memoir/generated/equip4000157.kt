package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val _equip4000157 = PartialMemoirBlueprint(
  id = 4000157,
  name = "いざ、舞台へ！",
  rarity = 4,
  cost = 12,
  baseStats = StatData(
    hp = 0,
    actPower = 105,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 5000,
    normalDefense = 0,
    specialDefense = 0,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(6, 6, 6, 6, 5),
    startCooldowns = listOf(5, 5, 5, 5, 4),
    cooldowns = listOf(5, 5, 5, 5, 4),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(200, 200, 210, 225, 240),
        times = listOf(1, 1, 1, 1, 1),
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
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
    ),
  ),
  additionalTags = listOf(EffectTag.Aruru)
)
