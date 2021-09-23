package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.condition.plus

data class SongEffectData(
    val effect: SongEffect,
    val value: Int,
    val condition: NamedCondition? = null,
) {
    val name get() = effect.formatName(value, condition ?: Condition { true })
    fun start(context: ActionContext) = effect.start(context, value, condition ?: Condition { true })
    fun end(context: ActionContext) = effect.end(context, value, condition ?: Condition { true })

    operator fun plus(condition: NamedCondition) = SongEffectData(
        effect,
        value,
        this.condition + condition,
    )
}
