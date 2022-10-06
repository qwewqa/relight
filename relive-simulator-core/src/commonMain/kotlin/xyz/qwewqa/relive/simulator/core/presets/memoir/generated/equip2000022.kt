package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip2000022 = PartialMemoirBlueprint(
  id = 2000022,
  name = "あの娘を捜して",
  rarity = 2,
  cost = 4,
  baseStats = StatData(
    hp = 150,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 0,
  ),
  growthStats = StatData(
    hp = 22881,
    actPower = 0,
    normalDefense = 0,
    specialDefense = 0,
  ),
  additionalTags = listOf(EffectTag.Mahiru)
)
