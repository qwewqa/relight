package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000004 = PartialMemoirBlueprint(
  id = 4000004,
  name = "模擬戦でも火花バチバチ",
  rarity = 4,
  cost = 9,
  baseStats = StatData(
    hp = 210,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 18,
  ),
  growthStats = StatData(
    hp = 23924,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 2050,
  ),
  additionalTags = listOf(EffectTag.Claudine, EffectTag.Maya)
)
