package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.SimplePercentTimedEffect


class ActTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override val name = "ActTimedEffect"
    override fun start(context: ActionContext) = context.run {
        self.actPower.buff += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.actPower.buff -= efficacy
    }
}

class CriticalTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun start(context: ActionContext) = context.run {
        self.critical.value += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.critical.value -= efficacy
    }
}


class DexterityTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun start(context: ActionContext) = context.run {
        self.dexterity.value += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.dexterity.value -= efficacy
    }
}

class EffectiveDamageTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy) {
    override fun start(context: ActionContext) = context.run {
        self.effectiveDamage.value += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.effectiveDamage.value -= efficacy
    }
}
