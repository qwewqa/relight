package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.DressBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.passive.EventBonusPassive

fun trEventBonusPassive(dress: DressBlueprint) = EventBonusPassive(
    dresses = mapOf(dress.id to 100),
    categories = mapOf(DressCategory.Arcana to 10, DressCategory.StageGirl to 40, DressCategory.Premium2022 to 40)
).new()
