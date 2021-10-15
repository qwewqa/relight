package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.StopBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue

val StopResistancePassive: PassiveEffect = BuffResistancePassive(StopBuff)

object NegativeEffectResistancePassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            valueNegativeEffectResist += value
        }
    }
}

private data class BuffResistancePassive(var effects: List<BuffEffect>) : PassiveEffect {
    constructor(vararg effects: BuffEffect) : this(effects.toList())

    override val name = "[${effects.joinToString(", ") { it.name }}] Resistance Passive"
    override val category = PassiveEffectCategory.Passive

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            effects.forEach { effect ->
                specificBuffResist[effect] = (specificBuffResist[effect] ?: 0) + value
            }
        }
    }
}
