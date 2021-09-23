package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

object MarkBuff : BuffEffect {
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val flipped get() = AntiMarkBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= 30
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += 30
    }
}

object AntiMarkBuff : BuffEffect {
    override val category = BuffCategory.Positive
    override val exclusive: Boolean = true
    override val flipped get() = MarkBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += 30
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= 30
    }
}
