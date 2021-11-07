package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip2000020 = PartialMemoirBlueprint(
  id = 2000020,
  name = "遠く離れていても",
  rarity = 2,
  baseStats = StatData(
    hp = 0,
    actPower = 4,
    normalDefense = 0,
    specialDefense = 9,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 686,
    normalDefense = 0,
    specialDefense = 1372,
  ),
  additionalTags = listOf(EffectTag.Hikari)
)
