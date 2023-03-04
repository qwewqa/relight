package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

actual class ModifiersImpl actual constructor(actor: Actor) : Modifiers(actor) {
  private val values = mutableMapOf<Int, Int>()

  actual override fun get(modifier: Modifier): Int {
    return values[modifier.id] ?: 0
  }

  actual override fun set(modifier: Modifier, value: Int) {
    values[modifier.id] = value
  }
}
