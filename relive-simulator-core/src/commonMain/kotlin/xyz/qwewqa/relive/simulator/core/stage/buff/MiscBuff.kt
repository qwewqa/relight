package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

object PerfectAimBuff : TimedBuffEffect {
    override val name = "Perfect Aim"
    override val category = BuffCategory.Positive
    override val exclusive: Boolean = true
    override val iconId: Int = 28

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.perfectAimCounter += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.perfectAimCounter -= 1
    }
}

object AggroBuff : TimedBuffEffect {
    override val name = "Aggro"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 101

        override fun onApply(source: Actor?, target: Actor) {
        requireNotNull(source)
        target.aggroTarget = source
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.aggroTarget = null
    }
}

object LockedAggroBuff : TimedBuffEffect {
    override val name = "Locked Aggro"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val isLocked = true
    override val iconId: Int = 101

        override fun onApply(source: Actor?, target: Actor) {
        requireNotNull(source)
        target.aggroTarget = source
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.aggroTarget = null
    }
}

object ProvokeBuff : TimedBuffEffect {
    override val name = "Provoke"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 49

        override fun onApply(source: Actor?, target: Actor) {
        requireNotNull(source)
        target.provokeTarget = source
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.provokeTarget = null
    }
}

object CounterHealBuff : TimedBuffEffect {
    override val name = "Counter Heal"
    override val category = BuffCategory.Positive
    override val iconId: Int = 38

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.counterHeal += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.counterHeal -= value
    }
}

object AbsorbBuff : TimedBuffEffect {
    override val name = "Absorb"
    override val category = BuffCategory.Positive
    override val iconId: Int = 37

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueAbsorb += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueAbsorb -= value
    }
}

object InvincibilityBuff : TimedBuffEffect {
    override val name = "Invincibility"
    override val category = BuffCategory.Positive
    override val iconId: Int = 104

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.invincible += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.invincible -= 1
    }
}

object ExitEvasionBuff : TimedBuffEffect {
    override val name = "Exit Evasion"
    override val category = BuffCategory.Positive
    override val iconId: Int = 103
}

object ResilienceBuff : TimedBuffEffect {
    override val name = "Resilience"
    override val category = BuffCategory.Positive
    override val iconId: Int = 128
}

object LockedResilienceBuff : TimedBuffEffect {
    override val name = "Locked Resilience"
    override val category = BuffCategory.Positive
    override val isLocked = true
    override val related = ResilienceBuff
    override val iconId: Int = 128
}
