package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip2000024 = PartialMemoirBlueprint(
  id = 2000024,
  name = "嫉妬のレヴュー",
  rarity = 2,
  baseStats = StatData(
    hp = 75,
    actPower = 3,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 11440,
    actPower = 572,
    normalDefense = 0,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Mahiru)
)
