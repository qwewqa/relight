package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

actual class ModifiersImpl actual constructor(actor: Actor) : Modifiers(actor) {
    private val values = js("[]")

    actual override operator fun get(modifier: Modifier): Int {
        return values[modifier.id].unsafeCast<Int?>() ?: modifier.default
    }

    actual override operator fun set(modifier: Modifier, value: Int) {
        values[modifier.id] = value
    }
}
