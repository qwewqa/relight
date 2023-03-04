package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.DressBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.passive.EventBonusPassive

fun trEventBonusPassive(dress: DressBlueprint) =
    EventBonusPassive(
            dresses = mapOf(dress.id to 100),
            categories =
                mapOf(
                    DressCategory.TroupeRevueShop to 0,
                    DressCategory.Arcana to 10,
                    DressCategory.StageGirl to 40,
                    DressCategory.Birthday2022 to 40))
        .new()

fun trEventBonusPassiveV2(dress: DressBlueprint) =
    EventBonusPassive(
            dresses = mapOf(dress.id to 100), categories = mapOf(DressCategory.Birthday2023 to 40))
        .new()

fun trEventBonusPassive2023(dress: DressBlueprint) =
    EventBonusPassive(
            dresses = mapOf(dress.id to 100),
            categories =
                mapOf(
                    DressCategory.Birthday2023 to 40,
                    DressCategory.Sweets to 40,
                ))
        .new()
