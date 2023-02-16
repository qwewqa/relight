package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext


object HpRegenBuff : TimedBuffEffect {
    override val name = "HP Regen"
    override val category = BuffCategory.Positive
    override val iconId: Int = 21
}

object BrillianceRegenBuff : TimedBuffEffect {
    override val name = "Brilliance Regen"
    override val category = BuffCategory.Positive
    override val iconId: Int = 22
    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.brillianceRegen += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.brillianceRegen -= value
    }
}

object LockedBrillianceRegenBuff : TimedBuffEffect {
    override val name = "Locked Brilliance Regen"
    override val category = BuffCategory.Positive
    override val iconId: Int = 22
    override val isLocked = true
    override val related = BrillianceRegenBuff
}

object ReviveRegenBuff : TimedBuffEffect {
    override val name = "Revive Regen"
    override val category = BuffCategory.Positive
    override val iconId: Int = 275
}
