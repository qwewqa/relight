package xyz.qwewqa.relivesim.stage.activeeffects

import xyz.qwewqa.relivesim.stage.*
import kotlin.properties.Delegates

abstract class SimplePercentStatEffect(val efficacy: Percent) : CharacterEffect {
    abstract val name: String
    override fun toString() = "$name(turns = $turns, efficacy = $efficacy)"

    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative
    override val effectType = EffectType.Other
}

abstract class SimpleIntStatEffect(val efficacy: Int) : CharacterEffect {
    abstract val name: String
    override fun toString() = "$name(turns = $turns, efficacy = $efficacy)"

    override val effectClass = if (efficacy >= 0) EffectClass.Positive else EffectClass.Negative
    override val effectType = EffectType.Other
}

class ActEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentStatEffect(efficacy) {
    override val name = "ActEffect"

    override fun start(target: CharacterState) {
        target.actPower.buff += efficacy
    }

    override fun stop(target: CharacterState) {
        target.actPower.buff -= efficacy
    }
}

class CriticalEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentStatEffect(efficacy) {
    override val name = "CriticalEffect"

    override fun start(target: CharacterState) {
        target.critical.value += efficacy
    }

    override fun stop(target: CharacterState) {
        target.critical.value -= efficacy
    }
}


class DexterityEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentStatEffect(efficacy) {
    override val name = "DexterityEffect"

    override fun start(target: CharacterState) {
        target.dexterity.value += efficacy
    }

    override fun stop(target: CharacterState) {
        target.dexterity.value -= efficacy
    }
}

class EffectiveDamageEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentStatEffect(efficacy) {
    override val name = "EffectiveDamageEffect"

    override fun start(target: CharacterState) {
        target.effectiveDamage.value += efficacy
    }

    override fun stop(target: CharacterState) {
        target.effectiveDamage.value -= efficacy
    }
}
