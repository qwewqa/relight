package xyz.qwewqa.relive.simulator.browser

import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.html.a
import kotlinx.html.br
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.RemoteSimulator
import xyz.qwewqa.relive.simulator.client.SimulatorClient
import xyz.qwewqa.relive.simulator.client.SimulatorVersion

suspend fun main() {
    val simulator = RemoteSimulator(URL("http://localhost:8080"))
    val client = SimulatorClient(simulator)
    val version = try {
        simulator.version()
    } catch (e: Throwable) {
        null
    }
    if (version != null) {
        if (client.version.compatibleWith(version)) {
            client.start()
        } else {
            client.toast("Info", "Incompatible server found. Redirecting to local simulator.")
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

private fun SimulatorVersion.compatibleWith(serverVersion: SimulatorVersion): Boolean {
    return name == serverVersion.name &&
            version.split(".").take(2) == serverVersion.version.split(".").take(2)
}
