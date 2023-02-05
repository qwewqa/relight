package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.abnormalCountableBuffs
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf

object StopBuff : TimedBuffEffect {
    override val name = "Stop"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 53

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.stop += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.stop -= 1
    }
}

object SleepBuff : TimedBuffEffect {
    override val name = "Sleep"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 51

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.sleep += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.sleep -= 1
    }
}

object NightmareBuff : TimedBuffEffect {
    override val name = "Nightmare"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 165

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.nightmare += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.nightmare -= 1
    }
}

object ConfusionBuff : TimedBuffEffect {
    override val name = "Confusion"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 52

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.confusion += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.confusion -= 1
    }
}

object LockedConfusionBuff : TimedBuffEffect {
    override val name = "Locked Confusion"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val isLocked: Boolean = true
    override val iconId: Int = 52
}

object FreezeBuff : TimedBuffEffect {
    override val name = "Freeze"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 54

        // 30% bonus handled directly within damage formula

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.frozen += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.frozen -= 1
    }
}

object StunBuff : TimedBuffEffect {
    override val name = "Stun"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 50

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.stun += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.stun -= 1
    }
}

object LockedStunBuff : TimedBuffEffect {
    override val name = "Locked Stun"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val isLocked: Boolean = true
    override val iconId: Int = 50
        override val related = StunBuff
}

object BurnBuff : TimedBuffEffect {
    override val name = "Burn"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val iconId: Int = 48

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.burn += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.burn -= 1
    }
}

object LockedBurnBuff : TimedBuffEffect {
    override val name = "Locked Burn"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val isLocked: Boolean = true
    override val related = BurnBuff
    override val iconId: Int = 48
}

object PoisonBuff : TimedBuffEffect {
    override val name = "Poison"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val iconId: Int = 47

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.poison += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.poison -= 1
    }
}

object LockedPoisonBuff : TimedBuffEffect {
    override val name = "Locked Poison"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = false
    override val isLocked: Boolean = true
    override val related = PoisonBuff
    override val iconId: Int = 47
}

object BlindnessBuff : TimedBuffEffect {
    override val name = "Blindness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 55

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.blindness += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.blindness -= 1
    }
}

object LockedBlindnessBuff : TimedBuffEffect {
    override val name = "Locked Blindness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val isLocked: Boolean = true
    override val related = BlindnessBuff
    override val iconId: Int = 55
}

object ElectricShockBuff : TimedBuffEffect {
    override val name = "Electric Shock"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 163

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.shock += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.shock -= 1
    }
}

object LockedElectricShockBuff : TimedBuffEffect {
    override val name = "Locked Electric Shock"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val isLocked: Boolean = true
    override val iconId: Int = 163
    override val related = ElectricShockBuff
}

object LovesicknessBuff : TimedBuffEffect {
    override val name = "Lovesickness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 162

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.lovesickness += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.lovesickness -= 1
    }
}

object LockedLovesicknessBuff : TimedBuffEffect {
    override val name = "Locked Lovesickness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val isLocked: Boolean = true
    override val iconId: Int = 162
    override val related = LovesicknessBuff
}

object AbnormalGuardBuff : TimedBuffEffect {
    override val name = "Abnormal Guard"
    override val category = BuffCategory.Positive
    override val isLocked = true
    override val iconId: Int = 74

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

object AgonyBuff : TimedBuffEffect {
    override val name = "Agony"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val iconId: Int = 172

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownDebuff -= 30
        self.agony += 1
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownDebuff += 30
        self.agony -= 1
    }
}

val abnormalBuffs = platformSetOf(
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
    LovesicknessBuff,
    LockedLovesicknessBuff,
    ElectricShockBuff,
    LockedElectricShockBuff,
)
