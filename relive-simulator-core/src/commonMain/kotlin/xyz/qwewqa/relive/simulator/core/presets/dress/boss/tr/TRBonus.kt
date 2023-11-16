package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.StageEffects

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

fun trEventBonusPassive2023V2(dressId: Int) =
    EventBonusPassive(
            dresses = mapOf(dressId to 200),
            categories =
                mapOf(
                    DressCategory.Birthday2023 to 40,
                    DressCategory.Sweets to 40,
                ))
        .new()

object TrDamageReductionPassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { self.mod { Modifier.DamageReceivedDown += value } }
}

object FullNegativeEffectResistancePassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.mod {
          Modifier.NegativeEffectResistanceUp += value
          Modifier.NegativeCountableEffectResistanceUp += value
        }
      }
}

object SuperBossPassive1 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.buffs.add(null, Buffs.ActPowerUpBuff, 100.i54, 1)
        self.mod {
          Modifier.NegativeEffectResistanceUp += 100.i54
          Modifier.NegativeCountableEffectResistanceUp += 100.i54
        }
        listOf(
                Buffs.GreaterBurnResistanceUpBuff,
                Buffs.GreaterBlindnessResistanceUpBuff,
                Buffs.GreaterConfusionResistanceUpBuff,
                Buffs.GreaterFreezeResistanceUpBuff,
                Buffs.GreaterStopResistanceUpBuff)
            .forEach { self.buffs.activatePsuedoBuff(it, 100.i54) }
      }
}

object SuperBossPassive2 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.mod {
          Modifier.NegativeEffectResistanceUp += 100
          Modifier.NegativeCountableEffectResistanceUp += 100
          Modifier.GreaterNegativeEffectResistanceUp += 100
          Modifier.GreaterNegativeCountableEffectResistanceUp += 100
        }
        self.specificBuffResist[Buffs.GreaterInsanityBuff] =
            (self.specificBuffResist[Buffs.GreaterInsanityBuff] ?: 0.i54) - 100
      }
}
