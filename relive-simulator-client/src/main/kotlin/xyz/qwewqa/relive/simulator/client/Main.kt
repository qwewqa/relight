package xyz.qwewqa.relive.simulator.client

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.browser.document
import kotlinx.coroutines.delay
import kotlinx.html.br
import kotlinx.html.div
import kotlinx.html.dom.create
import kotlinx.html.id
import kotlinx.html.p

val client = HttpClient {
    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }
}

suspend fun main() {
    val response: SimulateResponse = client.post("http://localhost:50505/simulate") {
        contentType(ContentType.Application.Json)
        body = SimulationParameters(
            3,
            1_000_000,
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
        )
    }
    val token = response.token

    while (true) {
        val result: SimulationResult = client.get("http://localhost:50505/result/$token")
        val existingDiv = document.getElementById("results")!!
        val newDiv = document.create.div {
            id = "results"
            p {
                result.results.forEach { (k, v) ->
                    +"$k: $v (${v * 100.0 / result.currentIterations}%)"
                    br {  }
                }
            }
        }
        existingDiv.replaceWith(newDiv)
        if (result.currentIterations == result.maxIterations) break
        delay(200)
    }
}