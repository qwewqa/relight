package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000010 = PartialMemoirBlueprint(
  id = 4000010,
  name = "子供の頃から変わらない",
  rarity = 4,
  cost = 9,
  baseStats = StatData(
    hp = 150,
    actPower = 7,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 17088,
    actPower = 854,
    normalDefense = 0,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Futaba, EffectTag.Kaoruko)
)
