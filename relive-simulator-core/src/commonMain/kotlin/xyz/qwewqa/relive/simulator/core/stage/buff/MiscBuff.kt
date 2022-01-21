package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

object PerfectAimBuff : BuffEffect {
    override val name = "Perfect Aim"
    override val category = BuffCategory.Positive
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.perfectAimCounter += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.perfectAimCounter -= 1
    }
}

object AggroBuff : BuffEffect {
    override val name = "Aggro"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onApply(source: Actor?, target: Actor) {
        requireNotNull(source)
        target.aggroTarget = source
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.aggroTarget = null
    }
}

object ProvokeBuff : BuffEffect {
    override val name = "Provoke"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onApply(source: Actor?, target: Actor) {
        requireNotNull(source)
        target.provokeTarget = source
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.provokeTarget = null
    }
}

object CounterHealBuff : BuffEffect {
    override val name = "Counter Heal"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.counterHeal += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.counterHeal -= value
    }
}

object AbsorbBuff : BuffEffect {
    override val name = "Absorb"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueAbsorb += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueAbsorb -= value
    }
}
