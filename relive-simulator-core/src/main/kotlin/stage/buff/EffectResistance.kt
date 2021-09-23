package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

val ConfusionResistanceBuff: BuffEffect = BuffResistanceBuff(ConfusionBuff)
val StopResistanceBuff: BuffEffect = BuffResistanceBuff(StopBuff)

object NegativeEffectResistanceBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}

private data class BuffResistanceBuff(var effects: List<BuffEffect>) : BuffEffect {
    constructor(vararg effects: BuffEffect) : this(effects.toList())
    override val category: BuffCategory = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        effects.forEach { effect ->
            self.specificBuffResist[effect] = (self.specificBuffResist[effect] ?: 0) + value
        }
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        effects.forEach { effect ->
            self.specificBuffResist[effect] = (self.specificBuffResist[effect] ?: 0) - value
        }
    }
}
