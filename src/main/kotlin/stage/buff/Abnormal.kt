package xyz.qwewqa.relive.simulator.stage.buff

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
