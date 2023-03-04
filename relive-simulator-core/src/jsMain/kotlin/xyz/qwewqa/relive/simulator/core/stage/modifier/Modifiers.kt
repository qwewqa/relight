package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

actual class ModifiersImpl actual constructor(actor: Actor) : Modifiers(actor) {
  val values = run {
    @Suppress("UNUSED_VARIABLE") val size = MAX_MODIFIER_COUNT
    js("Array(size).fill(0)")
  }

  actual override operator fun get(modifier: Modifier): Int {
    return values[modifier.id].unsafeCast<Int>()
  }

  actual override operator fun set(modifier: Modifier, value: Int) {
    values[modifier.id] = value
  }
}
