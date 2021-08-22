package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext

interface AutoEffect {
    val effectClass: EffectClass
    val autoEffectOrder: AutoEffectOrder

    /**
     * Called once, upon activation.
     */
    fun activate(context: ActionContext)
}

object BlankAutoEffect : AutoEffect {
    override fun toString() = "BlankAutoEffect"

    override val effectClass = EffectClass.Positive
    override val autoEffectOrder = AutoEffectOrder.PASSIVE

    override fun activate(context: ActionContext) {}
}

fun autoEffect(
    name: String,
    effectClass: EffectClass,
    autoEffectOrder: AutoEffectOrder = AutoEffectOrder.PASSIVE,
    action: ActionContext.() -> Unit,
) = object : AutoEffect {
    override fun toString() = name
    override val effectClass = effectClass
    override val autoEffectOrder = autoEffectOrder
    override fun activate(context: ActionContext) {
        context.action()
    }
}

enum class AutoEffectOrder {
    PASSIVE,
    TURN_START_1, // brilliance, resistance buff
    TURN_START_2, // stat buff
}
