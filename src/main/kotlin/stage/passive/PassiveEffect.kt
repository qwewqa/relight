package xyz.qwewqa.relive.simulator.stage.autoskill

import xyz.qwewqa.relive.simulator.stage.ActionContext
import xyz.qwewqa.relive.simulator.stage.condition.Condition
import xyz.qwewqa.relive.simulator.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.stage.passive.PassiveData

interface PassiveEffect {
    val name: String get() = this::class.simpleName ?: "Unknown Passive"
    val category: PassiveEffectCategory

    fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition)
    fun formatName(value: Int, condition: Condition): String {
        val formattedValue = if (value != 0) " $value" else ""
        val formattedCondition = (condition as? NamedCondition)?.let { " ${it.name}" } ?: ""
        return "$name$formattedValue$formattedCondition"
    }
}

enum class PassiveEffectCategory {
    Passive,
    TurnStartPositive1,
    TurnStartPositive2,
    TurnStartNegative,
}

fun PassiveEffect.new(value: Int = 0, turns: Int = 0) = PassiveData(
    this,
    value,
    turns,
)
