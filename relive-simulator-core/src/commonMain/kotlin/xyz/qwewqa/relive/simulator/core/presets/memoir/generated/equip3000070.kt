package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000070 = PartialMemoirBlueprint(
  id = 3000070,
  name = "名探偵へのプレゼント",
  rarity = 3,
  baseStats = StatData(
    hp = 147,
    actPower = 0,
    normalDefense = 12,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 19173,
    actPower = 0,
    normalDefense = 1643,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Mahiru, EffectTag.Yachiyo)
)
