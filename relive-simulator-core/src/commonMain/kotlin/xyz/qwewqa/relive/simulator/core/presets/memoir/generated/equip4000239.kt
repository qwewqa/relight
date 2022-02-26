package xyz.qwewqa.relive.simulator.core.presets.memoir.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.memoir.CutinBlueprint
import xyz.qwewqa.relive.simulator.core.stage.memoir.PartialMemoirBlueprint

val equip4000239 = PartialMemoirBlueprint(
  id = 4000239,
  name = "キラめきBirthday 鳳ミチル",
  rarity = 4,
  baseStats = StatData(
    hp = 280,
    actPower = 163,
    normalDefense = 168,
    specialDefense = 168,
  ),
  growthStats = StatData(
    hp = 60000,
    actPower = 3000,
    normalDefense = 8000,
    specialDefense = 8000,
  ),
  cutinData = CutinBlueprint(
    costs = listOf(4, 4, 4, 4, 3),
    startCooldowns = listOf(3, 3, 3, 3, 2),
    cooldowns = listOf(3, 3, 3, 3, 2),
    usageLimits = listOf(1, 1, 1, 1, 2),
    parameters = listOf(
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
      ),
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
      ),
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
      ),
      ActParameters(
        values = listOf(10, 10, 12, 16, 20),
        times = listOf(2, 2, 2, 2, 3),
      ),
      ActParameters(
        values = listOf(),
        times = listOf(),
      ),
    ),
  ),
  additionalTags = listOf(EffectTag.Michiru)
)
