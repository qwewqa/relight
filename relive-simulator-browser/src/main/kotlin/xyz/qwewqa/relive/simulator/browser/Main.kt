package xyz.qwewqa.relive.simulator.browser

import xyz.qwewqa.relive.simulator.client.SimulatorClient

suspend fun main() {
  val client = SimulatorClient(JsSimulator())
  client.toast("Info") { +"Please wait while the simulator loads." }
  client.start()
}
