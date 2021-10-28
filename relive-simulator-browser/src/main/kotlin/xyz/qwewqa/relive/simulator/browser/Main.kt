package xyz.qwewqa.relive.simulator.browser

import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.html.a
import kotlinx.html.br
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.RemoteSimulator
import xyz.qwewqa.relive.simulator.client.SimulatorClient

suspend fun main() {
    val simulator = RemoteSimulator(URL("http://localhost:8080"))
    val client = SimulatorClient(simulator)
    val version = try {
        simulator.version()
    } catch (e: Throwable) {
        null
    }
    if (version != null && version.name == "xyz.qwewqa.relive.simulator") {
        if (version == client.version) {
            client.start()
        } else {
            client.toast("Info", "Redirecting to local simulator.")
            delay(1000)
            window.location.href = "http://localhost:8080/${window.location.search}"
        }
    } else {
        client.toast("Error", "red", autohide = false) {
            +"No running local simulator or incompatible version found."
            br()
            a(href = "https://github.com/qwewqa/relive-simulator") { +"Download from GitHub." }
        }
    }
}