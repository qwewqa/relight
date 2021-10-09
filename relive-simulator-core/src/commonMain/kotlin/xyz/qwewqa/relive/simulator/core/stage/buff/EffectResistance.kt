package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

val ConfusionResistanceBuff: BuffEffect = BuffResistanceBuff(ConfusionBuff)
val StopResistanceBuff: BuffEffect = BuffResistanceBuff(StopBuff)
val StunResistanceBuff: BuffEffect = BuffResistanceBuff(StunBuff)
val BurnResistanceBuff: BuffEffect = BuffResistanceBuff(listOf(BurnBuff, LockedBurnBuff))

object NegativeEffectResistanceBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}

object PositiveEffectResistanceBuff : BuffEffect {
    override val category = BuffCategory.Negative

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist -= value
    }
}

object LockedPositiveEffectResistanceBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val locked: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist -= value
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
