package xyz.qwewqa.relivesim.presets.effect

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.FlippableEffect
import xyz.qwewqa.relivesim.stage.effect.SimplePercentTimedEffect
import xyz.qwewqa.relivesim.stage.effect.TimedEffect


class ActTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy), FlippableEffect {
    override fun getModifier(context: ActionContext) = context.run {
        self.actPower
    }

    override fun flipped(context: ActionContext) = ActTimedEffect(turns, -efficacy, locked)
}

class NormalDefenseTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy), FlippableEffect {
    override fun getModifier(context: ActionContext) = context.run {
        self.normalDefense
    }

    override fun flipped(context: ActionContext) = NormalDefenseTimedEffect(turns, -efficacy, locked)
}

class SpecialDefenseTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy), FlippableEffect {
    override fun getModifier(context: ActionContext) = context.run {
        self.specialDefense
    }

    override fun flipped(context: ActionContext) = SpecialDefenseTimedEffect(turns, -efficacy, locked)
}

class CriticalTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy), FlippableEffect {
    override fun getModifier(context: ActionContext) = context.run {
        self.critical
    }

    override fun flipped(context: ActionContext) = CriticalTimedEffect(turns, -efficacy, locked)
}

class DexterityTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy), FlippableEffect {
    override fun getModifier(context: ActionContext) = context.run {
        self.dexterity
    }

    override fun flipped(context: ActionContext) = DexterityTimedEffect(turns, -efficacy, locked)
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

class DamageTakenDownTimedEffect(
    override var turns: Int,
    efficacy: Percent,
    override val locked: Boolean = false,
) : SimplePercentTimedEffect(efficacy), FlippableEffect {
    override fun getModifier(context: ActionContext) = context.run {
        self.damageTakenDownBuff
    }

    override fun flipped(context: ActionContext) = DamageTakenDownTimedEffect(turns, -efficacy, locked)
}
