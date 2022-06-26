package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000213 = PartialMemoirBlueprint(
  id = 4000213,
  name = "【Star of the day】クロディーヌ＆真矢",
  rarity = 4,
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
    costs = listOf(3, 3, 3, 3, 2),
    startCooldowns = listOf(2, 2, 2, 2, 1),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(30, 30, 45, 60, 75),
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
      ActParameters(
        values = listOf(),
        times = listOf(),
        hitRate = 0,
      ),
    ),
  ),
  additionalTags = listOf(EffectTag.Claudine, EffectTag.Maya)
)
