package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier

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

object TrCritDamageReductionPassive : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { self.mod { Modifier.CriticalDamageReceivedDown += value } }
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

object SuperBossPassiveTR37Diff3 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.buffs.activatePsuedoBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.buffs.activatePsuedoBuff(Buffs.DamageReceivedDownBuff, 95.i54)
        self.buffs.activatePsuedoBuff(Buffs.CriticalDamageReceivedDownBuff, 50.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }
      }
}

object SuperBossPassiveTR37Diff4 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.buffs.activatePsuedoBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.buffs.activatePsuedoBuff(Buffs.DamageReceivedDownBuff, 99.i54)
        self.buffs.activatePsuedoBuff(Buffs.CriticalDamageReceivedDownBuff, 50.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }

        enemy.actors.values.forEach {
          it.buffs.activatePsuedoBuff(Buffs.GreaterIgnoranceBuff)
          it.buffs.activatePsuedoBuff(Buffs.GreaterBrillianceRecoveryDownBuff, 50.i54)
          it.buffs.activatePsuedoBuff(Buffs.GreaterActPowerDownBuff, 99.i54)
        }
      }
}

object SuperBossPassiveTR38Diff4 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.buffs.activatePsuedoBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.buffs.activatePsuedoBuff(Buffs.DamageReceivedDownBuff, 99.i54)
        self.buffs.activatePsuedoBuff(Buffs.CriticalDamageReceivedDownBuff, 50.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }

        enemy.actors.values.forEach {
          it.buffs.activatePsuedoBuff(Buffs.GreaterStagnationBuff)
          it.buffs.activatePsuedoBuff(Buffs.GreaterIgnoranceBuff)
          it.buffs.activatePsuedoBuff(Buffs.GreaterBrillianceRecoveryDownBuff, 50.i54)
          it.buffs.activatePsuedoBuff(Buffs.GreaterActPowerDownBuff, 99.i54)
        }
      }
}
