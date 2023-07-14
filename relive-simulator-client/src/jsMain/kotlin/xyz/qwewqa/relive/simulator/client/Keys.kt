package xyz.qwewqa.relive.simulator.client

import kotlinx.browser.window
import org.w3c.dom.events.KeyboardEvent

private val keys = mutableMapOf<String, Double>()
private const val timeout = 1000.0

fun registerKeyEventListeners() {
  window.addEventListener(
      "keydown",
      { event ->
        event as KeyboardEvent
        keys[event.key] = event.timeStamp.toDouble()
      })
  window.addEventListener(
      "keyup",
      { event ->
        event as KeyboardEvent
        keys[event.key] = 0.0
      })
}

fun isKeyDown(key: String) = (keys[key] ?: 0.0) > (window.performance.now() - timeout)
