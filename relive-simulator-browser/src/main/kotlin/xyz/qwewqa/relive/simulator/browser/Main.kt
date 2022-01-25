package xyz.qwewqa.relive.simulator.browser

import kotlinx.browser.window
import kotlinx.coroutines.delay
import kotlinx.html.a
import kotlinx.html.br
import org.w3c.dom.Navigator
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.RemoteSimulator
import xyz.qwewqa.relive.simulator.client.SimulatorClient
import xyz.qwewqa.relive.simulator.common.SimulatorVersion

suspend fun main() {
    val simulator = RemoteSimulator(URL("http://localhost:8080"))
    val mobileRe = "Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini".toRegex(RegexOption.IGNORE_CASE)
    val isMobile = mobileRe.containsMatchIn(window.navigator.userAgent)
    val version = if (!isMobile) {
        try {
            simulator.version()
        } catch (e: Throwable) {
            null
        }
    } else {
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
        val client = SimulatorClient(JsSimulator())
        if (!isMobile) {
            client.toast("Info", autohide = false) {
                +"No running local simulator server or incompatible version found. Falling back to JS simulator. For best performance, a local server is recommended."
                br()
                a(href = "https://github.com/qwewqa/relive-simulator") { +"Download from GitHub." }
            }
        }
        client.start()
    }
}

private fun SimulatorVersion.compatibleWith(clientVersion: SimulatorVersion): Boolean {
    return name == clientVersion.name &&
            version.split(".").take(2) == clientVersion.version.split(".").take(2)
}
