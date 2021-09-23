package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

/**
 * Autoskill effects.
 * Note that while the game itself differentiates between true passives and before start passives,
 * both are included here.
 */
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

/**
 * Determines the order of passive application.
 */
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
