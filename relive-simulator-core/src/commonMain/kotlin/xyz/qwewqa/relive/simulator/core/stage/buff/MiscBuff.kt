package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

object PerfectAim : BuffEffect {
    override val category = BuffCategory.Positive
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.perfectAimCounter += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.perfectAimCounter -= 1
    }
}
