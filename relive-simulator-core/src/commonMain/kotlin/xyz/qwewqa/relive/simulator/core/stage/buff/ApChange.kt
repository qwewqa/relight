package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifiers

val ApDownBuff: TimedBuffEffect<Unit> by lazy {
    buffData(105).makeSimpleTimedBuffEffect(
        category = BuffCategory.Positive,
        flipped = { ApUpBuff },
    )
}

val ApUpBuff: TimedBuffEffect<Unit> by lazy {
    buffData(106).copy(name = "AP Up").makeSimpleTimedBuffEffect(
        category = BuffCategory.Negative,
        flipped = { ApDownBuff },
    )
}

val ApDown2Buff: TimedBuffEffect<Unit> by lazy {
    buffData(237).makeSimpleTimedBuffEffect(
        category = BuffCategory.Positive,
    )
}

val ApUp2Buff: TimedBuffEffect<Unit> by lazy {
    buffData(236).makeSimpleTimedBuffEffect(
        category = BuffCategory.Negative,
    )
}

val LockedApDownBuff = buffData(227).makeLockedVariantOf(ApDownBuff)

val LockedApUpBuff = buffData(110).makeLockedVariantOf(ApUpBuff)

inline val Modifiers.apChange: Int
    get() = actor.buffs.run {
        val decrease = when {
            ApDown2Buff in this -> 2
            ApDownBuff in this -> 1
            else -> 0
        }
        val increase = when {
            ApUp2Buff in this -> 2
            ApUpBuff in this -> 1
            else -> 0
        }
        increase - decrease
    }
