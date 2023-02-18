package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.modifier.damageReceivedDown
import xyz.qwewqa.relive.simulator.core.stage.modifier.damageReceivedUp

val MarkBuff: TimedBuffEffect<*> by lazy {
    buffData(99).makeIdempotentTimedBuffEffect(
        category = BuffCategory.Negative,
        exclusive = true,
        flipped = { FlippedMarkBuff },
        onStart = {
            self.mod { damageReceivedUp += 30 }
        },
        onEnd = {
            self.mod { damageReceivedUp -= 30 }
        },
    )
}

val FlippedMarkBuff: TimedBuffEffect<*> by lazy {
    buffData(100).makeIdempotentTimedBuffEffect(
        category = BuffCategory.Positive,
        exclusive = true,
        flipped = { MarkBuff },
        onStart = {
            self.mod { damageReceivedDown += 30 }
        },
        onEnd = {
            self.mod { damageReceivedDown -= 30 }
        },
    )
}
