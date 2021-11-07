package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000050 = PartialMemoirBlueprint(
  id = 4000050,
  name = "お弁当の中の満開桜",
  rarity = 4,
  baseStats = StatData(
    hp = 300,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 34177,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Tamao, EffectTag.Fumi)
)
