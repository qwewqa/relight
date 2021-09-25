package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.html.*
import kotlinx.html.dom.create
import org.w3c.dom.url.URL

val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

suspend fun main() {
    val simulator = RemoteSimulator(URL("http://localhost:8080/simulate"))
    val simulation = simulator.simulate(
        SimulationParameters(
            3,
            1,
            listOf(
                PlayerLoadoutParameters(
                    "Death",
                    "Death Tamao",
                    "Urashima Taro Performance Flyer",
                    21,
                ),
                PlayerLoadoutParameters(
                    "Rui",
                    "Stage Girl Rui",
                    "Urashima Taro Performance Flyer",
                    21,
                ),
            ),
            null,
            SongParameters(
                listOf(),
                null,
            ),
            StrategyParameter(
                "fixed",
                ""
            ),
            "TR9 Faith Misora",
            140,
            0,
        )
    )

    while (true) {
        val result = simulation.pollResult()
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
            }
        }
        existingDiv.replaceWith(newDiv)
        if (result.done) break
        delay(200)
    }
}