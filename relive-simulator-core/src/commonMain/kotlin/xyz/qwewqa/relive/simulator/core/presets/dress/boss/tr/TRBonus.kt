package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.modifier.damageReceivedDown

fun trEventBonusPassive(dressId: Int) =
    EventBonusPassive(
            dresses = mapOf(dressId to 100),
            categories =
                mapOf(
                    DressCategory.TroupeRevueShop to 0,
                    DressCategory.Arcana to 10,
                    DressCategory.StageGirl to 40,
                    DressCategory.Birthday2022 to 40))
        .new()

fun trEventBonusPassiveV2(dressId: Int) =
    EventBonusPassive(
            dresses = mapOf(dressId to 100), categories = mapOf(DressCategory.Birthday2023 to 40))
        .new()

fun trEventBonusPassive2023(dressId: Int) =
    EventBonusPassive(
            dresses = mapOf(dressId to 100),
            categories =
                mapOf(
                    DressCategory.Birthday2023 to 40,
                    DressCategory.Sweets to 40,
                ))
        .new()

object TrDamageReductionPassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { self.mod { damageReceivedDown += value } }
}
