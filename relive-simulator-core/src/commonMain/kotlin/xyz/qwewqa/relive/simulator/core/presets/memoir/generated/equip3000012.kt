package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000012 = PartialMemoirBlueprint(
  id = 3000012,
  name = "お茶会の利き紅茶",
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
  additionalTags = listOf(EffectTag.Akira, EffectTag.Shiori)
)
