package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.condition.plus

data class PassiveData(
    val effect: PassiveEffect,
    val value: Int = 0,
    val time: Int = 0,
    val condition: NamedCondition? = null,
) {
  val name
    get() = effect.formatName(value, condition ?: Condition { true })
  fun activate(context: ActionContext) =
      effect.activate(context, value, time, condition ?: Condition { true })

  operator fun plus(condition: NamedCondition) =
      PassiveData(
          effect,
          value,
          time,
          this.condition + condition,
      )
}
