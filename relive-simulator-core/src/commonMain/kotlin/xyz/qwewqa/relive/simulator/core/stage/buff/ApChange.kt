package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

object ApDownBuff : BuffEffect {
    override val name = "AP Down"
    override val category = BuffCategory.Positive
    override val flipped get() = ApUpBuff
}

object ApUpBuff : BuffEffect {
    override val name = "AP Up"
    override val category = BuffCategory.Negative
    override val flipped get() = ApDownBuff
}

val Actor.apChange: Int
    get() {
        var result = 0
        if (buffs.count(ApDownBuff) > 0) result--
        if (buffs.count(ApUpBuff) > 0) result++
        return result
    }
