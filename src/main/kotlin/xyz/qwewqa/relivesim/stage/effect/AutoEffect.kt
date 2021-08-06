package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext

interface AutoEffect {
    val effectClass: EffectClass

    /**
     * Called once, upon activation.
     */
    fun activate(context: ActionContext)
}

object BlankAutoEffect : AutoEffect {
    override fun toString() = "BlankAutoEffect"

    override val effectClass = EffectClass.Positive

    override fun activate(context: ActionContext) {}
}

fun autoEffect(name: String, effectClass: EffectClass, action: ActionContext.() -> Unit) = object : AutoEffect {
    override fun toString() = name
    override val effectClass = effectClass
    override fun activate(context: ActionContext) {
        context.action()
    }
}
