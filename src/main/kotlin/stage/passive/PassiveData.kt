package xyz.qwewqa.relive.simulator.stage.passive

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.stage.condition.plus

data class PassiveData(
    val effect: PassiveEffect,
    val value: Int = 0,
    val time: Int = 0,
    val condition: NamedCondition? = null,
) {
    val name get() = effect.formatName(value, condition ?: Condition { true })
    fun activate(context: ActionContext) = effect.activate(context, value, time, condition ?: Condition { true })

    operator fun plus(condition: NamedCondition) = PassiveData(
        effect,
        value,
        time,
        this.condition + condition,
    )
}
