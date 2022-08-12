package xyz.qwewqa.relive.simulator.browser

import kotlinx.browser.window
import kotlinx.html.a
import kotlinx.html.br
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.RemoteSimulator
import xyz.qwewqa.relive.simulator.client.SimulatorClient
import xyz.qwewqa.relive.simulator.common.SimulatorVersion

suspend fun main() {
    val client = SimulatorClient(JsSimulator())
    client.toast("Info") {
        +"Please wait while the simulator loads."
    }
    client.start()
}
