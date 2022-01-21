package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue

object TeamActPowerUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.Act)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                boostActPower += value
            }
        }
    }
}

object TeamDexterityUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.Dexterity)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                valueDexterity += value
            }
        }
    }
}

object TeamCriticalUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.Critical)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                valueCritical += value
            }
        }
    }
}

object TeamHpUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.HP)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                boostMaxHp += value
            }
        }
    }
}

object TeamNormalDefenseUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.Defense)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                boostNormalDefense += value
            }
        }
    }
}

object TeamSpecialDefenseUpPassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.SpecialDefense)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        team.actors.values.forEach { member ->
            condition.applyIfTrue(member) {
                boostSpecialDefense += value
            }
        }
    }
}