package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000344 = PartialMemoirBlueprint(
  id = 4000344,
  name = "キラめき Every day 青嵐総合芸術院",
  rarity = 4,
  cost = 12,
  baseStats = StatData(
    hp = 280,
    actPower = 163,
    normalDefense = 168,
    specialDefense = 168,
  ),
  growthStats = StatData(
    hp = 60000,
    actPower = 3000,
    normalDefense = 8000,
    specialDefense = 8000,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(2, 2, 2, 2, 1),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(15, 15, 20, 25, 30),
        times = listOf(1, 1, 1, 1, 2),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(15, 15, 20, 25, 30),
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
  additionalTags = listOf(EffectTag.Koharu, EffectTag.Suzu, EffectTag.Hisame)
)
