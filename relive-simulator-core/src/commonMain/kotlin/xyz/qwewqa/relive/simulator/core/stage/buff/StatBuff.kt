package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext


object ActPowerUpBuff : BuffEffect {
    override val name = "Act Power Up"
    override val category = BuffCategory.Positive
    override val flipped get() = ActPowerDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostActPower += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostActPower -= value
    }
}

object ActPowerDownBuff : BuffEffect {
    override val name = "Act Power Down"
    override val category = BuffCategory.Negative
    override val flipped get() = ActPowerUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostActPower -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostActPower += value
    }
}

object DexterityUpBuff : BuffEffect {
    override val name = "Dexterity Up"
    override val category = BuffCategory.Positive
    override val flipped get() = DexterityDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDexterity += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDexterity -= value
    }
}

object DexterityDownBuff : BuffEffect {
    override val name = "Dexterity Down"
    override val category = BuffCategory.Negative
    override val flipped get() = DexterityUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDexterity -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDexterity += value
    }
}

object CriticalUpBuff : BuffEffect {
    override val name = "Critical Up"
    override val category = BuffCategory.Positive
    override val flipped get() = CriticalDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueCritical += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueCritical -= value
    }
}

object CriticalDownBuff : BuffEffect {
    override val name = "Critical Down"
    override val category = BuffCategory.Negative
    override val flipped get() = CriticalUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueCritical -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueCritical += value
    }
}

object NormalDefenseUpBuff : BuffEffect {
    override val name = "Normal Defense Up"
    override val category = BuffCategory.Positive
    override val flipped get() = NormalDefenseDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense -= value
    }
}

object NormalDefenseDownBuff : BuffEffect {
    override val name = "Normal Defense Down"
    override val category = BuffCategory.Negative
    override val flipped get() = NormalDefenseUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense += value
    }
}

object SpecialDefenseUpBuff : BuffEffect {
    override val name = "Special Defense Up"
    override val category = BuffCategory.Positive
    override val flipped get() = SpecialDefenseDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense -= value
    }
}

object SpecialDefenseDownBuff : BuffEffect {
    override val name = "Special Defense Down"
    override val category = BuffCategory.Negative
    override val flipped get() = SpecialDefenseUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense += value
    }
}

object EffectiveDamageDealtUpBuff : BuffEffect {
    override val name = "Effective Damage Dealt Up"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueEffectiveDamageUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueEffectiveDamageUp -= value
    }
}


object BrillianceGainDownBuff : BuffEffect {
    override val name = "Brilliance Gain Down"
    override val category = BuffCategory.Negative

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp += value
    }
}
