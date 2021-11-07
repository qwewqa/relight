package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000042 = PartialMemoirBlueprint(
  id = 4000042,
  name = "幸運の四つ葉探し",
  rarity = 4,
  baseStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 30,
    specialDefense = 30,
  ),
  growthStats = StatData(
    hp = 0,
    actPower = 0,
    normalDefense = 3417,
    specialDefense = 3417,
  ),
  additionalTags = listOf(EffectTag.Karen, EffectTag.Aruru)
)
