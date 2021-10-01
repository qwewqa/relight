package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

object StopBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override fun formatName(value: Int) = name
}

object SleepBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override fun formatName(value: Int) = name
}

object ConfusionBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override fun formatName(value: Int) = name
}

object FreezeBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override fun formatName(value: Int) = name

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= 30
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += 30
    }
}

sealed interface BurnBuffEffect : BuffEffect

object BurnBuff : BurnBuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override fun formatName(value: Int) = name
}

object LockedBurnBuff : BurnBuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val locked: Boolean = true
    override fun formatName(value: Int) = name
}
