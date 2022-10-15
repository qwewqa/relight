package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute


object ActPowerUpBuff : TimedBuffEffect {
    override val name = "Act Power Up"
    override val category = BuffCategory.Positive
    override val flipped get() = ActPowerDownBuff
    override val iconId: Int = 1

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostActPower += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostActPower -= value
    }
}

object ActPowerDownBuff : TimedBuffEffect {
    override val name = "Act Power Down"
    override val category = BuffCategory.Negative
    override val flipped get() = ActPowerUpBuff
    override val iconId: Int = 2

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostActPower -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostActPower += value
    }
}

object DexterityUpBuff : TimedBuffEffect {
    override val name = "Dexterity Up"
    override val category = BuffCategory.Positive
    override val flipped get() = DexterityDownBuff
    override val iconId: Int = 13

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.buffDexterity += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.buffDexterity -= value
    }
}

object DexterityDownBuff : TimedBuffEffect {
    override val name = "Dexterity Down"
    override val category = BuffCategory.Negative
    override val flipped get() = DexterityUpBuff
    override val iconId: Int = 14

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.debuffDexterity += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.debuffDexterity -= value
    }
}

object CriticalUpBuff : TimedBuffEffect {
    override val name = "Critical Up"
    override val category = BuffCategory.Positive
    override val flipped get() = CriticalDownBuff
    override val iconId: Int = 15

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueCritical += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueCritical -= value
    }
}

object CriticalDownBuff : TimedBuffEffect {
    override val name = "Critical Down"
    override val category = BuffCategory.Negative
    override val flipped get() = CriticalUpBuff
    override val iconId: Int = 16

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueCritical -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueCritical += value
    }
}

object NormalDefenseUpBuff : TimedBuffEffect {
    override val name = "Normal Defense Up"
    override val category = BuffCategory.Positive
    override val flipped get() = NormalDefenseDownBuff
    override val iconId: Int = 3

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense -= value
    }
}

object NormalDefenseDownBuff : TimedBuffEffect {
    override val name = "Normal Defense Down"
    override val category = BuffCategory.Negative
    override val flipped get() = NormalDefenseUpBuff
    override val iconId: Int = 4

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostNormalDefense += value
    }
}

object SpecialDefenseUpBuff : TimedBuffEffect {
    override val name = "Special Defense Up"
    override val category = BuffCategory.Positive
    override val flipped get() = SpecialDefenseDownBuff
    override val iconId: Int = 3

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense -= value
    }
}

object SpecialDefenseDownBuff : TimedBuffEffect {
    override val name = "Special Defense Down"
    override val category = BuffCategory.Negative
    override val flipped get() = SpecialDefenseUpBuff
    override val iconId: Int = 4

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostSpecialDefense += value
    }
}

object AgilityUpBuff : TimedBuffEffect {
    override val name = "Agility Up"
    override val category = BuffCategory.Positive
    override val flipped get() = AgilityDownBuff
    override val iconId: Int = 7

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostAgility += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostAgility -= value
    }
}

object AgilityDownBuff : TimedBuffEffect {
    override val name = "Agility Down"
    override val category = BuffCategory.Negative
    override val flipped get() = AgilityUpBuff
    override val iconId: Int = 8

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.boostAgility -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.boostAgility += value
    }
}

object EffectiveDamageDealtUpBuff : TimedBuffEffect {
    override val name = "Effective Damage Dealt Up"
    override val category = BuffCategory.Positive
    override val iconId: Int = 32

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueEffectiveDamageUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueEffectiveDamageUp -= value
    }
}

object DamageDealtUpBuff : TimedBuffEffect {
    override val name = "Damage Dealt Up"
    override val category = BuffCategory.Positive
    override val iconId: Int = 95

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageDealtUpBuff += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageDealtUpBuff -= value
    }
}

object BrillianceGainDownBuff : TimedBuffEffect {
    override val name = "Brilliance Gain Down"
    override val category = BuffCategory.Negative
//    override val flipped get() = BrillianceGainUpBuff
    override val iconId: Int = 126

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp += value
    }
}

object BrillianceGainUpBuff : TimedBuffEffect {
    override val name = "Brilliance Gain Up"
    override val category = BuffCategory.Positive
//    override val flipped get() = BrillianceGainDownBuff TODO() confirm if these flip to each other
    override val iconId: Int = 251

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueBrillianceGainUp -= value
    }
}


object EvasionRateUpBuff : TimedBuffEffect {
    override val name = "Evasion Rate Up"
    override val category = BuffCategory.Positive
    override val flipped get() = EvasionRateDownBuff
    override val iconId: Int = 11

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueEvasion += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueEvasion -= value
    }
}


object EvasionRateDownBuff : TimedBuffEffect {
    override val name = "Evasion Rate Down"
    override val category = BuffCategory.Negative
    override val flipped get() = EvasionRateUpBuff
    override val iconId: Int = 12

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueEvasion -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueEvasion += value
    }
}

object DamageTakenDownBuff : TimedBuffEffect {
    override val name = "Damage Taken Down"
    override val category = BuffCategory.Positive
    override val flipped get() = DamageTakenUpBuff
    override val iconId: Int = 98

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= value
    }
}

object DamageTakenUpBuff : TimedBuffEffect {
    override val name = "Damage Taken Up"
    override val category = BuffCategory.Negative
    override val flipped get() = DamageTakenDownBuff
    override val iconId: Int = 97

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueDamageTakenDownBuff += value
    }
}

object ClimaxDamageUpBuff : TimedBuffEffect {
    override val name = "Climax Damage Up"
    override val category = BuffCategory.Positive
    override val flipped get() = ClimaxDamageDownBuff
    override val iconId: Int = 33

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp -= value
    }
}

object ClimaxDamageDownBuff : TimedBuffEffect {
    override val name = "Climax Damage Down"
    override val category = BuffCategory.Negative
    override val flipped get() = ClimaxDamageUpBuff
    override val iconId: Int = 161

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueClimaxDamageUp += value
    }
}

object NormalReflectBuff : TimedBuffEffect {
    override val name = "Normal Reflect"
    override val category = BuffCategory.Positive
    override val iconId: Int = 25

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueNormalReflect += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueNormalReflect -= value
    }
}

object SpecialReflectBuff : TimedBuffEffect {
    override val name = "Special Reflect"
    override val category = BuffCategory.Positive
    override val iconId: Int = 26

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueSpecialReflect += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueSpecialReflect -= value
    }
}

data class againstAttributeDamageDealtUpBuff(val attribute: Attribute) : TimedBuffEffect {
    override val name = "Against ${attribute.name} Damage Dealt Up"
    override val category = BuffCategory.Positive
    override val iconId: Int = 95

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageDealtUp[attribute] = self.againstAttributeDamageDealtUp[attribute] + value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageDealtUp[attribute] = self.againstAttributeDamageDealtUp[attribute] - value
    }
}

data class AgainstAttributeDamageTakenUpBuff(val attribute: Attribute) : TimedBuffEffect {
    override val name = "${attribute.name} Damage Taken Up"
    override val category = BuffCategory.Negative
    override val iconId: Int = 146 + attribute.ordinal

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageTakenDown[attribute] = self.againstAttributeDamageTakenDown[attribute] - value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageTakenDown[attribute] = self.againstAttributeDamageTakenDown[attribute] + value
    }
}

data class AgainstAttributeDamageTakenDownBuff(val attribute: Attribute) : TimedBuffEffect {
    override val name = "${attribute.name} Damage Taken Down"
    override val category = BuffCategory.Positive
    override val iconId: Int = 58 + attribute.ordinal

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageTakenDown[attribute] = self.againstAttributeDamageTakenDown[attribute] + value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.againstAttributeDamageTakenDown[attribute] = self.againstAttributeDamageTakenDown[attribute] - value
    }
}

object AccuracyRateDownBuff : TimedBuffEffect {
    override val name = "Accuracy Rate Down"
    override val category = BuffCategory.Negative
    override val flipped get() = AccuracyRateUpBuff
    override val iconId: Int = 10

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy += value
    }
}

object AccuracyRateUpBuff : TimedBuffEffect {
    override val name = "Accuracy Rate Up"
    override val category = BuffCategory.Positive
    override val flipped get() = AccuracyRateDownBuff

    override val iconId: Int = 11
    
    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy += value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueAccuracy -= value
    }
}

object HPRecoveryDownBuff : TimedBuffEffect {
    override val name = "HP Recovery Down"
    override val category = BuffCategory.Negative
//    override val flipped get() = HPRecoveryUpBuff
    override val iconId: Int = 68

    override fun onStart(context: ActionContext, value: Int) = context.run {
        self.valueHPRecoveryGainUp -= value
    }

    override fun onEnd(context: ActionContext, value: Int) = context.run {
        self.valueHPRecoveryGainUp += value
    }
}
