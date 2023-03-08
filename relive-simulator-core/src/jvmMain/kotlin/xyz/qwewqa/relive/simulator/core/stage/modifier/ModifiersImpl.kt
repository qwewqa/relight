package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

actual class ModifiersImpl actual constructor(actor: Actor) : Modifiers(actor) {
  private val values = mutableMapOf<Int, Double>()

  actual override fun _get(modifier: Modifier): Double {
    return values[modifier.id] ?: 0.0
  }

  actual override fun _set(modifier: Modifier, value: Double) {
    values[modifier.id] = value
  }
}
