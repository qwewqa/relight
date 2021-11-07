package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000018 = PartialMemoirBlueprint(
  id = 4000018,
  name = "ファントムとクリスティーヌ",
  rarity = 4,
  baseStats = StatData(
    hp = 0,
    actPower = 9,
    normalDefense = 18,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 1025,
    normalDefense = 2050,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Junna, EffectTag.Nana)
)
