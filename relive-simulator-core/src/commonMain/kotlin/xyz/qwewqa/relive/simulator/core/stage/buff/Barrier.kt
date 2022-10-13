package xyz.qwewqa.relive.simulator.core.stage.buff

object NormalBarrierBuff : TimedBuffEffect {
    override val name = "Normal Barrier"
    override val category = BuffCategory.Positive
    override val iconId: Int = 23
}

object SpecialBarrierBuff : TimedBuffEffect {
    override val name = "Special Barrier"
    override val category = BuffCategory.Positive
    override val iconId: Int = 24
}

object LockedNormalBarrierBuff : TimedBuffEffect {
    override val name = "Locked Normal Barrier"
    override val category = BuffCategory.Positive
    override val related = NormalBarrierBuff
    override val locked = true
    override val iconId: Int = 23
}

object LockedSpecialBarrierBuff : TimedBuffEffect {
    override val name = "Locked Special Barrier"
    override val category = BuffCategory.Positive
    override val related = SpecialBarrierBuff
    override val locked = true
    override val iconId: Int = 24
}
