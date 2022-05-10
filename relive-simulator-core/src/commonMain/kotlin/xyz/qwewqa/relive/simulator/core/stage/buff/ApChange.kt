package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

object ApDownBuff : BuffEffect {
    override val name = "AP Down"
    override val category = BuffCategory.Positive
    override val flipped get() = ApUpBuff
}

object Ap2DownBuff : BuffEffect {
    override val name = "AP 2 Down"
    override val category = BuffCategory.Positive
//    override val flipped get() = Ap2UpBuff TODO: Check if AP 2 Down flips
}

object ApUpBuff : BuffEffect {
    override val name = "AP Up"
    override val category = BuffCategory.Negative
    override val flipped get() = ApDownBuff
}

/*object Ap2UpBuff : BuffEffect {
    override val name = "AP 2 Up"
    override val category = BuffCategory.Negative
    override val flipped get() = Ap2DownBuff
}*/

// TODO: Test if locked buffs are flippable

object LockedApDownBuff : BuffEffect {
    override val name = "Locked AP Down"
    override val category = BuffCategory.Positive
    override val related = ApDownBuff
    override val locked = true
}

object LockedApUpBuff : BuffEffect {
    override val name = "Locked AP Up"
    override val category = BuffCategory.Negative
    override val related = ApUpBuff
    override val locked = true
}

val Actor.apChange: Int
    get() {
        var result = 0
        if (buffs.count(ApDownBuff) > 0) result--
        if (buffs.count(ApUpBuff) > 0) result++
        if (buffs.count(Ap2DownBuff) > 0) result -= 2
//        if (buffs.count(Ap2UpBuff) > 0) result += 2
        return result
    }
