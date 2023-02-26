package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor


interface TimedBuffEffect<T> : BuffEffect {
    override val name: String
    override val iconId: Int
    override val category: BuffCategory
    override val isLocked: Boolean get() = false
    override val displayLockIcon: Boolean get() = isLocked
    val exclusive: Boolean get() = false
    val flipped: TimedBuffEffect<*>? get() = null
    val related: TimedBuffEffect<Unit>? get() = null
    fun onStart(context: ActionContext, value: Int, source: Actor?): T
    fun onEnd(context: ActionContext, value: Int, source: Actor?, data: T)

    fun formatName(value: Int): String = if (value != 0) {
        "$name $value"
    } else {
        name
    }
}
