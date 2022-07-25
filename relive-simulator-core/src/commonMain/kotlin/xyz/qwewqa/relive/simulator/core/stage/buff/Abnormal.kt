package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.abnormalCountableBuffs

object StopBuff : BuffEffect {
    override val name = "Stop"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
}

object SleepBuff : BuffEffect {
    override val name = "Sleep"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
}

object NightmareBuff : BuffEffect {
    override val name = "Nightmare"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
}

object ConfusionBuff : BuffEffect {
    override val name = "Confusion"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
}

object LockedConfusionBuff : BuffEffect {
    override val name = "Confusion"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val locked: Boolean = true
}

object FreezeBuff : BuffEffect {
    override val name = "Freeze"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true

    // 30% bonus handled directly within damage formula
}

object StunBuff : BuffEffect {
    override val name = "Stun"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
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
}

object LockedElectricShockBuff : BuffEffect {
    override val name = "Electric Shock"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
    override val locked: Boolean = true
}

object LovesicknessBuff : BuffEffect {
    override val name = "Lovesickness"
    override val category = BuffCategory.Negative
    override val exclusive: Boolean = true
}

object LockedLovesicknessBuff : BuffEffect {
    override val name = "Lovesickness"
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
