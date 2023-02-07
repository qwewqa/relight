package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip2000035 = PartialMemoirBlueprint(
  id = 2000035,
  name = "天堂真矢は負けてない",
  rarity = 2,
  cost = 4,
  baseStats = StatData(
    hp = 0,
    actPower = 4,
    normalDefense = 9,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 686,
    normalDefense = 1372,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Claudine)
)
