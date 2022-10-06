package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000266 = PartialMemoirBlueprint(
  id = 4000266,
  name = "皇帝と愚者と女帝のレヴュー",
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
    costs = listOf(7, 7, 7, 7, 6),
    startCooldowns = listOf(5, 5, 5, 5, 4),
    cooldowns = listOf(5, 5, 5, 5, 4),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(240, 240, 280, 320, 360),
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
  additionalTags = listOf(EffectTag.Akira, EffectTag.MeiFan, EffectTag.Yachiyo)
)
