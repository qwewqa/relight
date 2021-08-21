package xyz.qwewqa.relivesim.presets.effect

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.EffectType
import xyz.qwewqa.relivesim.stage.effect.TimedEffect
import xyz.qwewqa.relivesim.stage.percent

data class NegativeEffectResistanceTimedEffect(
    override var turns: Int,
    val efficacy: Percent = 100.percent,
    override val locked: Boolean = false,
) : TimedEffect {
    override val effectType = EffectType.Other
    override val effectClass = EffectClass.Positive

    override fun start(context: ActionContext) = context.run {
        self.negativeEffectResist.buff += efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.negativeEffectResist.buff -= efficacy
    }
}

data class EffectTypeResistanceTimedEffect(
    override var turns: Int,
    val type: EffectType,
    val efficacy: Percent = 100.percent,
    override val locked: Boolean = false,
) : TimedEffect {
    override val effectType = EffectType.Other
    override val effectClass = EffectClass.Positive

    override fun start(context: ActionContext) = context.run {
        self.effectTypeResist[type] = (self.effectTypeResist[type] ?: 0.percent) + efficacy
    }

    override fun stop(context: ActionContext) = context.run {
        self.effectTypeResist[type] = (self.effectTypeResist[type] ?: 0.percent) - efficacy
    }
}

fun EffectType.resist(turns: Int, efficacy: Percent = 100.percent, locked: Boolean = false) =
    EffectTypeResistanceTimedEffect(turns, this, efficacy, locked)