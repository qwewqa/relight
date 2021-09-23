package xyz.qwewqa.relive.simulator.core.stage.song

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

interface SongEffect {
    val name: String get() = this::class.simpleName ?: "Unknown Song Effect"

    fun start(context: ActionContext, value: Int, condition: Condition)
    fun end(context: ActionContext, value: Int, condition: Condition)
    fun formatName(value: Int, condition: Condition): String {
        val formattedValue = if (value != 0) " $value" else ""
        val formattedCondition = (condition as? NamedCondition)?.let { " ${it.name}" } ?: ""
        return "$name$formattedValue$formattedCondition"
    }
}
