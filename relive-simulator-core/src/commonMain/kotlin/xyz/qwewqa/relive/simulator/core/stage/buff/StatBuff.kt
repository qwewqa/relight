package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute


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
        self.buffDexterity += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.buffDexterity -= value
    }
}

object DexterityDownBuff : BuffEffect {
    override val name = "Dexterity Down"
    override val category = BuffCategory.Negative
    override val flipped get() = DexterityUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.debuffDexterity += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.debuffDexterity -= value
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

object AgilityUpBuff : BuffEffect {
    override val name = "Agility Up"
    override val category = BuffCategory.Positive
    override val flipped get() = AgilityDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostAgility += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostAgility -= value
    }
}

object AgilityDownBuff : BuffEffect {
    override val name = "Agility Down"
    override val category = BuffCategory.Negative
    override val flipped get() = AgilityUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostAgility -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostAgility += value
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

object DamageDealtUpBuff : BuffEffect {
    override val name = "Damage Dealt Up"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageDealtUpBuff += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageDealtUpBuff -= value
    }
}

object BrillianceGainDownBuff : BuffEffect {
    override val name = "Brilliance Gain Down"
    override val category = BuffCategory.Negative
//    override val flipped get() = BrillianceGainUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp += value
    }
}

// Note: does not exist at the moment
object BrillianceGainUpBuff : BuffEffect {
    override val name = "Brilliance Gain Up"
    override val category = BuffCategory.Positive
    override val flipped get() = BrillianceGainDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp -= value
    }
}


object EvasionRateUpBuff : BuffEffect {
    override val name = "Evasion Rate Up"
    override val category = BuffCategory.Positive
    override val flipped get() = EvasionRateDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueEvasion += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueEvasion -= value
    }
}


object EvasionRateDownBuff : BuffEffect {
    override val name = "Evasion Rate Down"
    override val category = BuffCategory.Negative
    override val flipped get() = EvasionRateUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueEvasion -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueEvasion += value
    }
}

object DamageTakenDownBuff : BuffEffect {
    override val name = "Damage Taken Down"
    override val category = BuffCategory.Positive
    override val flipped get() = DamageTakenUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= value
    }
}

object DamageTakenUpBuff : BuffEffect {
    override val name = "Damage Taken Up"
    override val category = BuffCategory.Negative
    override val flipped get() = DamageTakenDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += value
    }
}

object ClimaxDamageUpBuff : BuffEffect {
    override val name = "Climax Damage Up"
    override val category = BuffCategory.Positive
    override val flipped get() = ClimaxDamageDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp -= value
    }
}

object ClimaxDamageDownBuff : BuffEffect {
    override val name = "Climax Damage Down"
    override val category = BuffCategory.Negative
    override val flipped get() = ClimaxDamageUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp += value
    }
}

object NormalReflectBuff : BuffEffect {
    override val name = "Normal Reflect"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNormalReflect += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNormalReflect -= value
    }
}

object SpecialReflectBuff : BuffEffect {
    override val name = "Special Reflect"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueSpecialReflect += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueSpecialReflect -= value
    }
}

data class AgainstAttributeDamageDealtUpBuff(val attribute: Attribute) : BuffEffect {
    override val name = "Against ${attribute.name} Damage Dealt Up"
    override val category = BuffCategory.Positive

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageDealtUp[attribute] = self.againstAttributeDamageDealtUp.getValue(attribute) + value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageDealtUp[attribute] = self.againstAttributeDamageDealtUp.getValue(attribute) - value
    }
}

data class AgainstAttributeDamageTakenUpBuff(val attribute: Attribute) : BuffEffect {
    override val name = "${attribute.name} Damage Taken Up"
    override val category = BuffCategory.Negative

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageTakenDown[attribute] = self.againstAttributeDamageTakenDown.getValue(attribute) - value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageTakenDown[attribute] = self.againstAttributeDamageTakenDown.getValue(attribute) + value
    }
}

object AccuracyRateDownBuff : BuffEffect {
    override val name = "Accuracy Rate Down"
    override val category = BuffCategory.Negative
    override val flipped get() = AccuracyRateUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy += value
    }
}

object AccuracyRateUpBuff : BuffEffect {
    override val name = "Accuracy Rate Up"
    override val category = BuffCategory.Positive
    override val flipped get() = AccuracyRateDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy -= value
    }
}

object HPRecoveryDownBuff : BuffEffect {
    override val name = "HP Recovery Down"
    override val category = BuffCategory.Negative
//    override val flipped get() = HPRecoveryUpBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueHPRecoveryGainUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueHPRecoveryGainUp += value
    }
}

//Does not currently exist
object HPRecoveryUpBuff : BuffEffect {
    override val name = "HP Recovery Up"
    override val category = BuffCategory.Positive
    override val flipped get() = HPRecoveryDownBuff

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueHPRecoveryGainUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueHPRecoveryGainUp -= value
    }
}
