package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000170 = PartialMemoirBlueprint(
  id = 4000170,
  name = "XXIV 慈善【逆位置】",
  rarity = 4,
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
    costs = listOf(3, 3, 3, 3, 2),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(10000, 10000, 11000, 12500, 15000),
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
  additionalTags = listOf(EffectTag.Tsukasa)
)
