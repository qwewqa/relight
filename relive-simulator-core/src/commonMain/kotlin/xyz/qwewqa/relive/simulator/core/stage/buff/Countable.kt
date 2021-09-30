package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff

object ApplyEvasionBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.buffs.addCountable(CountableBuff.Evasion, value)
    }
}

object ApplyFortitudeBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.buffs.addCountable(CountableBuff.Fortitude, value)
    }
}

// Note: value is unused, though the game seems to support values other than 50%
// If other revive values ever get used, countable buffs will need a rework
object ApplyReviveBuff : BuffEffect {
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.buffs.addCountable(CountableBuff.Revive, value)
    }
}
