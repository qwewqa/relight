package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000049 = PartialMemoirBlueprint(
  id = 4000049,
  name = "ハッピー・イースター！",
  rarity = 4,
  cost = 9,
  baseStats = StatData(
    hp = 0,
    actPower = 9,
    normalDefense = 0,
    specialDefense = 18,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 1025,
    normalDefense = 0,
    specialDefense = 2050,
  ),
  additionalTags = listOf(EffectTag.Lalafin, EffectTag.Shizuha)
)
