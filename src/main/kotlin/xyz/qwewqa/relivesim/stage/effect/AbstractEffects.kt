package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.character.Modifier
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.percent

abstract class SimplePercentTimedEffect(val efficacy: Percent) : TimedEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    override fun toString() = "$name(turns = $turns, efficacy = $efficacy, locked = $locked)"

    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative
    override val effectType = EffectType.Other

    abstract fun getModifier(context: ActionContext): Modifier<*, *>

    override fun start(context: ActionContext) {
        getModifier(context).buff += efficacy
    }

    override fun stop(context: ActionContext) {
        getModifier(context).buff -= efficacy
    }
}

abstract class SimplePercentAutoEffect(val efficacy: Percent) : AutoEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    override fun toString() = "$name(efficacy = $efficacy)"

    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    abstract fun getModifier(context: ActionContext): Modifier<*, *>

    override fun activate(context: ActionContext) {
        getModifier(context).buff += efficacy
    }
}

abstract class TeamAutoEffect : AutoEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    abstract fun apply(context: ActionContext, target: StageGirl)

    override fun activate(context: ActionContext) = context.run {
        team.forEach { apply(this, it) }
    }
}

abstract class SimpleSongEffect<T>(val efficacy: T) : SongEffect {
    open val name: String = this::class.simpleName ?: "Anonymous"
    override fun toString() = "$name(efficacy = $efficacy)"
}
