package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

val ConfusionResistanceBuff: BuffEffect = BuffResistanceBuff(ConfusionBuff)
val StopResistanceBuff: BuffEffect = BuffResistanceBuff(StopBuff)
val StunResistanceBuff: BuffEffect = BuffResistanceBuff(listOf(StunBuff, LockedStunBuff))
val BurnResistanceBuff: BuffEffect = BuffResistanceBuff(listOf(BurnBuff, LockedBurnBuff))
val FreezeResistanceBuff: BuffEffect = BuffResistanceBuff(FreezeBuff)
val BlindnessResistanceBuff: BuffEffect = BuffResistanceBuff(BlindnessBuff)
val SleepResistanceBuff: BuffEffect = BuffResistanceBuff(SleepBuff)
val AggroResistanceBuff: BuffEffect = BuffResistanceBuff(AggroBuff)

object NegativeEffectResistanceBuff : BuffEffect {
    override val name = "Negative Effect Resistance"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}

object LockedNegativeEffectResistanceBuff : BuffEffect {
    override val name = "Locked Negative Effect Resistance"
    override val category = BuffCategory.Positive
    override val locked: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}

object PositiveEffectResistanceBuff : BuffEffect {
    override val name = "Positive Effect Resistance"
    override val category = BuffCategory.Negative

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist -= value
    }
}

object LockedPositiveEffectResistanceBuff : BuffEffect {
    override val name = "Locked Positive Effect Resistance"
    override val category = BuffCategory.Negative
    override val locked: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist -= value
    }
}

object NegativeCountableResistanceBuff : BuffEffect {
    override val name = "Negative Countable Resistance"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeCountableResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeCountableResist -= value
    }
}


private data class BuffResistanceBuff(var effects: List<BuffEffect>) : BuffEffect {
    constructor(vararg effects: BuffEffect) : this(effects.toList())
    override val name = "[${effects.joinToString(", ") {it.name}}] Resistance Buff"
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
