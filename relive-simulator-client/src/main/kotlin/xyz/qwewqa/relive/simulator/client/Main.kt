package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.document
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.html.*
import kotlinx.html.dom.create
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.HTMLTextAreaElement
import org.w3c.dom.url.URL

val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

@OptIn(DelicateCoroutinesApi::class, kotlinx.serialization.ExperimentalSerializationApi::class)
suspend fun main() {
    val simulator = RemoteSimulator(URL("http://localhost:8080/simulate"))
    var simulation: Simulation? = null
    var done = false

    val button = document.getElementById("simulate-button") as HTMLButtonElement
    val parameters = document.getElementById("simulation-parameters") as HTMLTextAreaElement
    val strategy = document.getElementById("simulation-strategy") as HTMLTextAreaElement
    button.addEventListener("click", {
        GlobalScope.launch {
            simulation = simulator.simulate(
                Json.decodeFromString<SimulationParameters>(parameters.value).let {
                    it.copy(
                        strategy = it.strategy.copy(value = strategy.value)
                    )
                }
            )
            done = false
        }
    })

    while (true) {
        if (!done) {
            simulation?.let {
                val result = it.pollResult()
                val existingDiv = document.getElementById("results")!!
                val newDiv = document.create.div {
                    id = "results"
                    p {
                        result.results.forEach { (k, v) ->
                            +"$k: $v (${v * 100.0 / result.currentIterations}%)"
                            br { }
                        }
                        pre {
                            +(result.log ?: "")
                        }
                        pre {
                            +(result.error ?: "")
                        }
                    }
                }
                existingDiv.replaceWith(newDiv)
                done = result.done
            }
        }
        delay(200)
    }
}