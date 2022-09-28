package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.abnormalCountableBuffs

object StopBuff : BuffEffect {
    override val name = "Stop"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.stop += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.stop -= 1
    }
}

object SleepBuff : BuffEffect {
    override val name = "Sleep"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.sleep += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.sleep -= 1
    }
}

object NightmareBuff : BuffEffect {
    override val name = "Nightmare"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.nightmare += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.nightmare -= 1
    }
}

object ConfusionBuff : BuffEffect {
    override val name = "Confusion"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.confusion += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.confusion -= 1
    }
}

object LockedConfusionBuff : BuffEffect {
    override val name = "Locked Confusion"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val locked: Boolean = true
}

object FreezeBuff : BuffEffect {
    override val name = "Freeze"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    // 30% bonus handled directly within damage formula

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.frozen += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.frozen -= 1
    }
}

object StunBuff : BuffEffect {
    override val name = "Stun"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.stun += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.stun -= 1
    }
}

object LockedStunBuff : BuffEffect {
    override val name = "Locked Stun"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val locked: Boolean = true
    override val related = StunBuff
}

object BurnBuff : BuffEffect {
    override val name = "Burn"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.burn += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.burn -= 1
    }
}

object LockedBurnBuff : BuffEffect {
    override val name = "Locked Burn"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val locked: Boolean = true
    override val related = BurnBuff
}

object PoisonBuff : BuffEffect {
    override val name = "Poison"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.poison += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.poison -= 1
    }
}

object LockedPoisonBuff : BuffEffect {
    override val name = "Locked Poison"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val locked: Boolean = true
    override val related = PoisonBuff
}

object BlindnessBuff : BuffEffect {
    override val name = "Blindness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.blindness += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.blindness -= 1
    }
}

object LockedBlindnessBuff : BuffEffect {
    override val name = "Locked Blindness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val locked: Boolean = true
    override val related = BlindnessBuff
}

object ElectricShockBuff : BuffEffect {
    override val name = "Electric Shock"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.shock += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.shock -= 1
    }
}

object LockedElectricShockBuff : BuffEffect {
    override val name = "Locked Electric Shock"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val locked: Boolean = true
}

object LovesicknessBuff : BuffEffect {
    override val name = "Lovesickness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.lovesickness += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.lovesickness -= 1
    }
}

object LockedLovesicknessBuff : BuffEffect {
    override val name = "Locked Lovesickness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val locked: Boolean = true
}

object AbnormalGuardBuff : BuffEffect {
    override val name = "Abnormal Guard"
    override val category = BuffCategory.Positive
    override val locked = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        abnormalBuffs.forEach { buff ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + value
        }
        abnormalCountableBuffs.forEach { buff ->
            self.specificCountableBuffResist[buff] = (self.specificCountableBuffResist[buff] ?: 0) + value
        }
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        abnormalBuffs.forEach { buff ->
            self.specificBuffResist[buff] = self.specificBuffResist[buff]!! - value
        }
        abnormalCountableBuffs.forEach { buff ->
            self.specificCountableBuffResist[buff] = self.specificCountableBuffResist[buff]!! - value
        }
    }
}

object AgonyBuff : BuffEffect {
    override val name = "Agony"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownDebuff -= 30
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownDebuff += 30
    }
}

val abnormalBuffs = setOf(
    StopBuff,
    SleepBuff,
    NightmareBuff,
    ConfusionBuff,
    FreezeBuff,
    StunBuff,
    LockedStunBuff,
    BurnBuff,
    LockedBurnBuff,
    PoisonBuff,
    LockedPoisonBuff,
    AgonyBuff,
) //TODO() Electric Shock and Locked Electric Shock in here or just normal? Lovesickness & its locked version too
