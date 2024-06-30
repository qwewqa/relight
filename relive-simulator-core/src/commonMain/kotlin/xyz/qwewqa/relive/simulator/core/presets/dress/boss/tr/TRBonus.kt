package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr

import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.autoskill.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.ContinuousBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.modifier.positiveEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.target.SkillTargets

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
            dresses = mapOf(dressId to 100),
            categories = mapOf((DressCategory.Birthday2023 + DressCategory.Birthday2024) to 40))
        .new()

fun trEventBonusPassive2023(dressId: Int) =
    EventBonusPassive(
            dresses = mapOf(dressId to 100),
            categories =
                mapOf(
                    (DressCategory.Birthday2023 + DressCategory.Birthday2024) to 40,
                    DressCategory.Sweets to 40,
                ))
        .new()

fun trEventBonusPassive2023V2(dressId: Int) =
    EventBonusPassive(
            dresses = mapOf(dressId to 200),
            categories =
                mapOf(
                    (DressCategory.Birthday2023 + DressCategory.Birthday2024) to 40,
                    DressCategory.Sweets to 40,
                ))
        .new()

fun trEventBonusPassive2024(vararg dressId: Int) =
    EventBonusPassive(
            dresses = dressId.associateWith { 200 },
            categories = mapOf((DressCategory.Birthday2024 to 40)))
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
            .forEach { self.activatePassiveBuff(it, 100.i54) }
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
        self.activatePassiveBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.activatePassiveBuff(Buffs.DamageReceivedDownBuff, 95.i54)
        self.activatePassiveBuff(Buffs.CriticalDamageReceivedDownBuff, 50.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }
      }
}

object SuperBossPassiveTR37Diff4 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.activatePassiveBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.activatePassiveBuff(Buffs.DamageReceivedDownBuff, 99.i54)
        self.activatePassiveBuff(Buffs.CriticalDamageReceivedDownBuff, 50.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }

        resolveTarget(SkillTargets.allEnemies).targets.forEach {
          it.activatePassiveBuff(Buffs.GreaterIgnoranceBuff)
          it.activatePassiveBuff(Buffs.GreaterBrillianceRecoveryDownBuff, 50.i54)
          it.activatePassiveBuff(Buffs.GreaterActPowerDownBuff, 99.i54)
        }
      }
}

object SuperBossPassiveTR38Diff4 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.activatePassiveBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.activatePassiveBuff(Buffs.DamageReceivedDownBuff, 99.i54)
        self.activatePassiveBuff(Buffs.CriticalDamageReceivedDownBuff, 90.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }

        resolveTarget(SkillTargets.allEnemies).targets.forEach {
          it.activatePassiveBuff(Buffs.GreaterStagnationBuff)
          it.activatePassiveBuff(Buffs.GreaterIgnoranceBuff)
          it.activatePassiveBuff(Buffs.GreaterBrillianceRecoveryDownBuff, 50.i54)
          it.activatePassiveBuff(Buffs.GreaterActPowerDownBuff, 99.i54)
        }
      }
}

object SuperBossPassiveTR42Diff4 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.activatePassiveBuff(Buffs.ExcludingGreaterInsanityResistanceUpBuff, 100.i54)
        self.activatePassiveBuff(Buffs.DamageReceivedDownBuff, 99.i54)
        self.activatePassiveBuff(Buffs.CriticalDamageReceivedDownBuff, 90.i54)
        BossElementResistPassive.activate(this, 50, 0) { true }

        resolveTarget(SkillTargets.allEnemies).targets.forEach {
          it.activatePassiveBuff(Buffs.GreaterStagnationBuff)
          it.activatePassiveBuff(Buffs.GreaterIgnoranceBuff)
          it.activatePassiveBuff(Buffs.GreaterBrillianceRecoveryDownBuff, 80.i54)
          it.activatePassiveBuff(Buffs.GreaterActPowerDownBuff, 99.i54)
        }
      }
}

object BossDmgTakenDown90 : PassiveEffect {
  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        self.activatePassiveBuff(Buffs.EnemyDamageReceivedDownBuff, 90.i54)
      }
}

fun Actor.activatePassiveBuff(effect: ContinuousBuffEffect<Unit>, value: I54 = 100.i54) {
  val res =
      when (effect.category) {
        BuffCategory.Positive -> mod.positiveEffectResistance(effect)
        BuffCategory.Negative -> mod.negativeEffectResistance(effect)
      }
  if (res == 0.i54 || context.stage.random.nextDouble() > (res / 100.0)) {
    buffs.activatePsuedoBuff(effect, value = value.toI54())
  }
}
