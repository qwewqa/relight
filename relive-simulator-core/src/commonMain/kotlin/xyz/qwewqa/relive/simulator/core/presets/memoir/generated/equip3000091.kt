package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000091 = PartialMemoirBlueprint(
  id = 3000091,
  name = "彦星様をお手伝い",
  rarity = 3,
  baseStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 21,
    specialDefense = 21,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 2739,
    specialDefense = 2739,
  ),
  additionalTags = listOf(EffectTag.MeiFan, EffectTag.Yachiyo)
)
