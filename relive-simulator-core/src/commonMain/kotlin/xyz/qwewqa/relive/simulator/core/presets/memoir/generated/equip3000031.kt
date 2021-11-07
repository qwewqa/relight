package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip3000031 = PartialMemoirBlueprint(
  id = 3000031,
  name = "相棒のメンテは念入りに",
  rarity = 3,
  baseStats = StatData(
    hp = 0,
    actPower = 6,
    normalDefense = 0,
    specialDefense = 12,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 821,
    normalDefense = 0,
    specialDefense = 1643,
  ),
  additionalTags = listOf(EffectTag.Futaba, EffectTag.Kaoruko)
)
