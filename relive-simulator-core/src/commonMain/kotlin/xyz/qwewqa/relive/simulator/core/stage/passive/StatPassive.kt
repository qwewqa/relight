package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue
import xyz.qwewqa.relive.simulator.core.stage.modifier.*

object ActUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Act)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { actPowerUp += value } } }
}

object StaminaActUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Act)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { staminaActPowerUp += value } } }
}

object TeamActUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Act)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { actPowerUp += value } }
        }
      }
}

object DexterityPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Dexterity)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { buffDexterity += value } } }
}

object CriticalUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Critical)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { buffCritical += value } } }
}

object HpUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.HP)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { maxHpUp += value } } }
}

object DamageDealtPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Damage)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { damageDealtUp += value } } }
}

data class ConditionalDamageDealtPassive(val targetCondition: Condition) : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Damage)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        condition.applyIfTrue(self) { conditionalDamageDealtUp += targetCondition to value }
      }
}

object EffectiveDamageDealtPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.EffectiveDamage)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { effectiveDamageUp += value } } }
}

object ClimaxActPowerPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.ClimaxDamage)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { climaxDamageUp += value } } }
}

object PerfectAimPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.PerfectAim)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { buffs.activatePsuedoBuff(PerfectAimBuff) } }
}

object DamageReceivedDownPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Dexterity)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { damageReceivedDown += value } } }
}

object AgilityPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Agility)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { agilityUp += value } } }
}

object CutinInitialCooldownReductionPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        condition.applyIfTrue(self) {
          mod { cutinInitialCooldownReduction = cutinInitialCooldownReduction.coerceAtLeast(value) }
        }
      }
}

object TurnHPRecoveryPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Regeneration)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run { condition.applyIfTrue(self) { mod { hpFixedRegen += value } } }
}
