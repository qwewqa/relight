package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000011 = PartialMemoirBlueprint(
  id = 3000011,
  name = "しなやかな肢体のチャイナ娘",
  rarity = 3,
  baseStats = StatData(
    hp = 105,
    actPower = 5,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 13695,
    actPower = 684,
    normalDefense = 0,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.MeiFan, EffectTag.Shiori)
)
