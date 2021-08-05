package xyz.qwewqa.relivesim.presets.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.EffectType
import xyz.qwewqa.relivesim.stage.effect.TimedEffect

class MarkTimedEffect(
    override var turns: Int,
    override val locked: Boolean = false,
) : TimedEffect {
    override fun toString() = "Mark(locked = $locked)"

    override val effectClass = EffectClass.Negative
    override val effectType = EffectType.Mark

    override fun start(context: ActionContext) = context.run {
        self.markCounter += 1
    }

    override fun stop(context: ActionContext) = context.run {
        self.markCounter -= 1
    }
}

class AntiMark(
    override var turns: Int,
    override val locked: Boolean = false,
) : TimedEffect {
    override fun toString() = "AntiMark(locked = $locked)"

    override val effectClass = EffectClass.Positive
    override val effectType = EffectType.Mark

    override fun start(context: ActionContext) = context.run {
        self.antiMarkCounter += 1
    }

    override fun stop(context: ActionContext) = context.run {
        self.antiMarkCounter -= 1
    }
}