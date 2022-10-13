package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

val ConfusionResistanceBuff: TimedBuffEffect = BuffResistanceBuff(ConfusionBuff, iconId = 80)
val StopResistanceBuff: TimedBuffEffect = BuffResistanceBuff(StopBuff,  iconId = 81)
val StunResistanceBuff: TimedBuffEffect = BuffResistanceBuff(listOf(StunBuff, LockedStunBuff), iconId = 78)
val BurnResistanceBuff: TimedBuffEffect = BuffResistanceBuff(listOf(BurnBuff, LockedBurnBuff), iconId = 76)
val FreezeResistanceBuff: TimedBuffEffect = BuffResistanceBuff(FreezeBuff, iconId = 82)
val BlindnessResistanceBuff: TimedBuffEffect = BuffResistanceBuff(BlindnessBuff, iconId = 83)
val SleepResistanceBuff: TimedBuffEffect = BuffResistanceBuff(SleepBuff, iconId = 79)
val AggroResistanceBuff: TimedBuffEffect = BuffResistanceBuff(AggroBuff, iconId = 102)

object NegativeEffectResistanceBuff : TimedBuffEffect {
    override val name = "Negative Effect Resistance"
    override val category = BuffCategory.Positive
    override val iconId: Int = 19

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}

object LockedNegativeEffectResistanceBuff : TimedBuffEffect {
    override val name = "Locked Negative Effect Resistance"
    override val category = BuffCategory.Positive
    override val locked: Boolean = true
    override val iconId: Int = 19

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeEffectResist -= value
    }
}

object PositiveEffectResistanceBuff : TimedBuffEffect {
    override val name = "Positive Effect Resistance"
    override val category = BuffCategory.Negative
    override val iconId: Int = 166

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist -= value
    }
}

object LockedPositiveEffectResistanceBuff : TimedBuffEffect {
    override val name = "Locked Positive Effect Resistance"
    override val category = BuffCategory.Negative
    override val locked: Boolean = true
    override val iconId: Int = 166

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valuePositiveEffectResist -= value
    }
}

object NegativeCountableResistanceBuff : TimedBuffEffect {
    override val name = "Negative Countable Resistance"
    override val category = BuffCategory.Positive
    override val iconId: Int = 173

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeCountableResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeCountableResist -= value
    }
}

object LockedNegativeCountableResistanceBuff : TimedBuffEffect {
    override val name = "Locked Negative Countable Resistance"
    override val category = BuffCategory.Positive
    override val locked: Boolean = true
    override val iconId: Int = 173

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNegativeCountableResist += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNegativeCountableResist -= value
    }
}


private data class BuffResistanceBuff(var effects: List<TimedBuffEffect>, override val iconId: Int) : TimedBuffEffect {
    constructor(vararg effects: TimedBuffEffect, iconId: Int) : this(effects.toList(), iconId)
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
