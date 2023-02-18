package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.applyIfTrue
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeCountableEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeEffectResistance

val StopResistancePassive: PassiveEffect = BuffResistancePassive(EffectTag.StopResistance, StopBuff)
val BlindnessResistancePassive: PassiveEffect = BuffResistancePassive(EffectTag.BlindnessResistance, BlindnessBuff)
val ConfusionResistancePassive: PassiveEffect = BuffResistancePassive(EffectTag.ConfusionResistance, ConfusionBuff)
val StunResistancePassive: PassiveEffect = BuffResistancePassive(EffectTag.StunResistance, StunBuff)
val FreezeResistancePassive: PassiveEffect = BuffResistancePassive(EffectTag.FreezeResistance, FreezeBuff)

object NegativeEffectResistancePassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.NegativeEffectResistance)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            mod {
                negativeEffectResistance += value
            }
        }
    }
}

object NegativeCountableResistancePassive : PassiveEffect {
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(EffectTag.NegativeCountableResistance)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition)  = context.run {
        condition.applyIfTrue(self) {
            mod {
                negativeCountableEffectResistance += value
            }
        }
    }
}

private data class BuffResistancePassive(val tag: EffectTag, var effects: List<TimedBuffEffect<*>>) : PassiveEffect {
    constructor(tag: EffectTag, vararg effects: TimedBuffEffect<*>) : this(tag, effects.toList())

    override val name = "[${effects.joinToString(", ") { it.name }}] Resistance Passive"
    override val category = PassiveEffectCategory.Passive
    override val tags = listOf(tag)


    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        condition.applyIfTrue(self) {
            effects.forEach { effect ->
                specificBuffResist[effect] = (specificBuffResist[effect] ?: 0) + value
            }
        }
    }
}
