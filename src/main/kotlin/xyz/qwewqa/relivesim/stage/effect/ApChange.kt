package xyz.qwewqa.relivesim.presets.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.EffectType
import xyz.qwewqa.relivesim.stage.effect.FlippableEffect
import xyz.qwewqa.relivesim.stage.effect.TimedEffect

class ApDownTimedEffect(override var turns: Int) : FlippableEffect {
    override val effectClass = EffectClass.Positive
    override val effectType = EffectType.Other

    override fun toString() = "ApDownTimedEffect(turns = $turns)"

    override fun start(context: ActionContext) = context.run {
        self.apDownCounter += 1
    }

    override fun stop(context: ActionContext) = context.run {
        self.apDownCounter -= 1
    }

    override fun flipped(context: ActionContext): TimedEffect {
        return ApUpTimedEffect(turns)
    }
}

class ApUpTimedEffect(override var turns: Int) : FlippableEffect {
    override val effectClass = EffectClass.Negative
    override val effectType = EffectType.Other

    override fun toString() = "ApUpTimedEffect(turns = $turns)"

    override fun start(context: ActionContext) = context.run {
        self.apUpCounter += 1
    }

    override fun stop(context: ActionContext) = context.run {
        self.apUpCounter -= 1
    }

    override fun flipped(context: ActionContext): TimedEffect {
        return ApDownTimedEffect(turns)
    }
}
