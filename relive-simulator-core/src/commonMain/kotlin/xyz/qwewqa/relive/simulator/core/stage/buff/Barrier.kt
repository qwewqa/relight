package xyz.qwewqa.relive.simulator.core.stage.buff

val NormalBarrierBuff = buffData(23).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
)

val SpecialBarrierBuff = buffData(24).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
)

val LockedNormalBarrierBuff = buffData(223).makeLockedVariantOf(NormalBarrierBuff)

val LockedSpecialBarrierBuff = buffData(224).makeLockedVariantOf(SpecialBarrierBuff)
