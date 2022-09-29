package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

object ApDownBuff : BuffEffect {
    override val name = "AP Down"
    override val category = BuffCategory.Positive
    override val flipped get() = ApUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.apDown += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.apDown -= 1
    }
}

object Ap2DownBuff : BuffEffect {
    override val name = "AP 2 Down"
    override val category = BuffCategory.Positive
//    override val flipped get() = Ap2UpBuff TODO: Check if AP 2 Down flips

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.ap2Down += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.ap2Down -= 1
    }
}

object ApUpBuff : BuffEffect {
    override val name = "AP Up"
    override val category = BuffCategory.Negative
    override val flipped get() = ApDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.apUp += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.apUp -= 1
    }
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
        val apDecrease = when {
            isAp2Down -> 2
            isApDown -> 1
            else -> 0
        }
        val apIncrease = when {
            isAp2Up -> 2
            isApUp -> 1
            else -> 0
        }
        return apIncrease - apDecrease
    }
