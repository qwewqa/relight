package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue
import xyz.qwewqa.relive.simulator.core.stage.modifier.*

object TeamActPowerUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Act)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { actPowerUp += value } }
        }
      }
}

object TeamDexterityUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Dexterity)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { buffDexterity += value } }
        }
      }
}

object TeamCriticalUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Critical)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { buffCritical += value } }
        }
      }
}

object TeamHpUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.HP)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { maxHpUp += value } }
        }
      }
}

object TeamNormalDefenseUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Defense)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { normalDefenseUp += value } }
        }
      }
}

object TeamSpecialDefenseUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.SpecialDefense)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { specialDefenseUp += value } }
        }
      }
}

object TeamDamageUpPassive : PassiveEffect {
  override val category = PassiveEffectCategory.Passive
  override val tags = listOf(EffectTag.Damage)

  override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
      context.run {
        team.actors.values.forEach { member ->
          condition.applyIfTrue(member) { mod { damageDealtUp += value } }
        }
      }
}
