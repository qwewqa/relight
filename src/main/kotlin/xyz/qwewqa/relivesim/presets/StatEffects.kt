package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.Modifier
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.SimplePercentTimedEffect


class ActTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.actPower
    }
}

class NormalDefenseTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.normalDefense
    }
}

class SpecialDefenseTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.specialDefense
    }
}

class CriticalTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.critical
    }
}


class DexterityTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.dexterity
    }
}

class EffectiveDamageTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.effectiveDamage
    }
}
