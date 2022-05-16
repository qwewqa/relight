package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000259 = PartialMemoirBlueprint(
  id = 4000259,
  name = "XXI 世界【逆位置】",
  rarity = 4,
  baseStats = StatData(
    hp = 520,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 120000,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 0,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(0, 0, 0, 0, 0),
        times = listOf(2, 2, 2, 2, 3),
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
  additionalTags = listOf(EffectTag.Maya)
)
