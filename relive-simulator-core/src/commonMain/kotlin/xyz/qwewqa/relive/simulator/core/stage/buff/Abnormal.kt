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

object NightmareBuff : BuffEffect {
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

    // 30% bonus handled directly within damage formula
}

object StunBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override fun formatName(value: Int) = name
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
    override val related = BurnBuff
}

object PoisonBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override fun formatName(value: Int) = name
}

object LockedPoisonBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val locked: Boolean = true
    override fun formatName(value: Int) = name
    override val related = PoisonBuff
}

object BlindnessBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override fun formatName(value: Int) = name
}
