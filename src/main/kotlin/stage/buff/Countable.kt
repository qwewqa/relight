package xyz.qwewqa.relive.simulator.stage.buff

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.actor.CountableBuff

// Note: value is unused, though the game seems to support values other than 50%
// If other revive values ever get used, countable buffs will need a rework
object ReviveBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.buffs.addCountable(CountableBuff.Revive, value)
    }
}
