package xyz.qwewqa.relive.simulator.core.stage.buff

object NormalBarrierBuff : BuffEffect {
    override val name = "Normal Barrier"
    override val category = BuffCategory.Positive
}

object SpecialBarrierBuff : BuffEffect {
    override val name = "Special Barrier"
    override val category = BuffCategory.Positive
}

object LockedNormalBarrierBuff : BuffEffect {
    override val name = "Locked Normal Barrier"
    override val category = BuffCategory.Positive
    override val related = NormalBarrierBuff
    override val locked = true
}

object LockedSpecialBarrierBuff : BuffEffect {
    override val name = "Locked Special Barrier"
    override val category = BuffCategory.Positive
    override val related = SpecialBarrierBuff
    override val locked = true
}
