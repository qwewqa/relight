package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000020 = PartialMemoirBlueprint(
  id = 4000020,
  name = "雨上がりの星空",
  rarity = 4,
  cost = 9,
  baseStats = StatData(
    hp = 210,
    actPower = 0,
    normalDefense = 18,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 23924,
    actPower = 0,
    normalDefense = 2050,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Claudine, EffectTag.Futaba)
)
