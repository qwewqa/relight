package xyz.qwewqa.relivesim.presets.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.EffectType
import xyz.qwewqa.relivesim.stage.effect.TimedEffect

interface BarrierTimedEffect : TimedEffect {
    var value : Int
}

data class NormalBarrierTimedEffect(override var turns: Int, override var value: Int) : BarrierTimedEffect {
    override val effectClass = EffectClass.Positive
    override val effectType = EffectType.NormalBarrier

    override fun start(context: ActionContext) {}

    override fun stop(context: ActionContext) {}
}

data class SpecialBarrierTimedEffect(override var turns: Int, override var value: Int) : BarrierTimedEffect {
    override val effectClass = EffectClass.Positive
    override val effectType = EffectType.SpecialBarrier

    override fun start(context: ActionContext) {}

    override fun stop(context: ActionContext) {}
}