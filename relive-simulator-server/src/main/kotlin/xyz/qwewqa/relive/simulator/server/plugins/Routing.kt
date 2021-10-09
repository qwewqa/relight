package xyz.qwewqa.relive.simulator.server.plugins

import com.charleskorn.kaml.Yaml
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.coroutines.cancelAndJoin
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.dress.playerDresses
import xyz.qwewqa.relive.simulator.core.presets.memoir.memoirs
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers
import xyz.qwewqa.relive.simulator.server.*

fun Application.configureRouting() {
    routing {
        // Static doesn't seem to work with GraalVM properly :(
        get("/") {
            call.respondText(Thread.currentThread().getContextClassLoader().getResourceAsStream("client/index.html")!!
                .bufferedReader().readText(), ContentType.Text.Html)
        }
        get("/index.html") {
            call.respondText(Thread.currentThread().getContextClassLoader().getResourceAsStream("client/index.html")!!
                .bufferedReader().readText(), ContentType.Text.Html)
        }
        get("/relive-simulator-client.js") {
            call.respondText(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("client/relive-simulator-client.js")!!.bufferedReader().readText(),
                ContentType.Application.JavaScript)
        }
        get("/codemirror.css") {
            call.respondText(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("client/codemirror.css")!!.bufferedReader().readText(), ContentType.Text.CSS)
        }
        post("/simulate") {
            val parameters = call.receive<SimulationParameters>()
            val token = simulate(parameters)
            call.respond(SimulateResponse(token))
        }
        get("/result/{token}") {
            val token = call.parameters["token"]!!
            val result = simulationResults[token]
            if (result == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                call.respond(result)
            }
        }
        delete("/result/{token}") {
            val token = call.parameters["token"]!!
            simulationResults.remove(token)
            call.respond(HttpStatusCode.NoContent)
        }
        get("/result/{token}/cancel") {
            val token = call.parameters["token"]!!
            val job = simulationJobs[token]
            if (job == null) {
                call.respond(HttpStatusCode.NotFound)
            } else {
                job.cancelAndJoin()
                val currentResult = simulationResults[token]
                // Could lead to a race with delete, but going to ignore that case for now
                if (currentResult != null) simulationResults[token] = currentResult.copy(cancelled = true)
                call.respond(HttpStatusCode.NoContent)
            }
        }
        get("/options") {
            call.respond(
                SimulationOptions(
                    mapOf("en" to "English", "zh_hant" to "繁体中文", "ko" to "한국어"),
                    getLocalizationConfig("commmonText.yaml"),
                    getLocalizationConfig("dress.yaml", playerDresses.keys),
                    getLocalizationConfig("memoir.yaml", memoirs.keys),
                    getLocalizationConfig("songEffect.yaml", songEffects.keys),
                    getLocalizationConfig("condition.yaml", conditions.keys),
                    getLocalizationConfig("bossLoadout.yaml", bossLoadouts.keys),
                    getLocalizationConfig("strategy.yaml", strategyParsers.keys),
                )
            )
        }
    }
}

private fun loadResourceText(path: String) =
    Thread.currentThread().getContextClassLoader().getResourceAsStream(path)?.bufferedReader()?.readText()

private val configSerializer =
    MapSerializer(String.serializer(), MapSerializer(String.serializer(), String.serializer()))

private fun decodeLocalizationConfig(text: String, options: Iterable<String>): List<SimulationOption> {
    val localized = Yaml.default.decodeFromString(configSerializer, text)
    return options.map {
        SimulationOption(it, localized[it] ?: emptyMap())
    }
}

private fun decodeLocalizationConfig(text: String): List<SimulationOption> {
    return Yaml.default.decodeFromString(configSerializer, text).map { (id, localized) ->
        SimulationOption(id, localized)
    }
}

private fun getLocalizationConfig(path: String, options: Iterable<String>) =
    decodeLocalizationConfig(loadResourceText(path) ?: "{}", options)

private fun getLocalizationConfig(path: String) =
    decodeLocalizationConfig(loadResourceText(path) ?: "{}")
