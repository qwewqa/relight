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
    val version = try {
        simulator.version()
    } catch (e: Throwable) {
        null
    }
    if (version != null) {
        if (version.compatibleWith(SimulatorClient.version)) {
            val client = SimulatorClient(simulator)
            client.start()
        } else {
            val client = SimulatorClient(simulator)
            client.toast("Error", "red", autohide = false) {
                +"Incompatible server found."
                br()
                a(href = "https://github.com/qwewqa/relive-simulator") { +"Update server" }
                +" or "
                a(href = "http://localhost:8080/${window.location.search}") { +"switch to the local client version." }
            }
        }
    } else {
        val client = SimulatorClient(simulator)
        client.toast("Error", "red", autohide = false) {
            +"No running local simulator or incompatible version found."
            br()
            a(href = "https://github.com/qwewqa/relive-simulator") { +"Download from GitHub." }
        }
    }
}

private fun SimulatorVersion.compatibleWith(clientVersion: SimulatorVersion): Boolean {
    return name == clientVersion.name &&
            version.split(".").take(2) == clientVersion.version.split(".").take(2)
}
