package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

actual class ModifiersImpl actual constructor(actor: Actor) : Modifiers(actor) {
  val values = run {
    @Suppress("UNUSED_VARIABLE") val size = MAX_MODIFIER_COUNT
    js("Array(size).fill(0)")
  }

  actual override fun _get(modifier: Modifier): Double {
    return values[modifier.id].unsafeCast<Double>()
  }

  actual override fun _set(modifier: Modifier, value: Double) {
    values[modifier.id] = value
  }
}
