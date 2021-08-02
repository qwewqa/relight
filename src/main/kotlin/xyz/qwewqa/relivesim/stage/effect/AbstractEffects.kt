package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.percent

abstract class SimplePercentTimedEffect(val efficacy: Percent) : TimedEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    override fun toString() = "$name(turns = $turns, efficacy = $efficacy)"

    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative
    override val effectType = EffectType.Other
}

abstract class SimplePercentAutoEffect(val efficacy: Percent) : AutoEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    override fun toString() = "$name(efficacy = $efficacy)"

    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative
}

abstract class TeamAutoEffect : AutoEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    abstract fun apply(context: ActionContext, target: CharacterState)

    override fun activate(context: ActionContext) = context.run {
        team.forEach { apply(this, it) }
    }
}

abstract class SimpleSongEffect<T>(val efficacy: T) : SongEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    override fun toString() = "$name(efficacy = $efficacy)"
}
