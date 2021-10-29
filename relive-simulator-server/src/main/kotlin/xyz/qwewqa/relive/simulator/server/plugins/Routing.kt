package xyz.qwewqa.relive.simulator.server.plugins

import com.charleskorn.kaml.Yaml
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.coroutines.cancelAndJoin
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import xyz.qwewqa.relive.simulator.common.*
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.dress.playerDresses
import xyz.qwewqa.relive.simulator.core.presets.memoir.memoirs
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.core.stage.strategy.bossStrategyParsers
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers
import xyz.qwewqa.relive.simulator.server.*

fun Application.configureRouting() {
    routing {
        // Static doesn't seem to work with GraalVM properly :(
        val index by lazy {
            Thread.currentThread().contextClassLoader
                .getResourceAsStream("client/index.html")!!.bufferedReader().readText()
        }
        val jsMap by lazy {
            Thread.currentThread().contextClassLoader
                .getResourceAsStream("client/relive-simulator-client.js.map")?.bufferedReader()?.readText()
        }
        val codemirrorCss by lazy {
            Thread.currentThread().contextClassLoader
                .getResourceAsStream("client/codemirror.css")!!.bufferedReader().readText()
        }
        get("/") {
            call.respondText(index, ContentType.Text.Html)
        }
        get("/version") {
            call.respond(SimulatorVersion(MAVEN_GROUP, VERSION, GIT_SHA))
        }
        get("/features") {
            call.respond(SimulatorFeatures(shutdown = true))
        }
        get("/index.html") {
            call.respondText(index, ContentType.Text.Html)
        }
        val clientJs by lazy {
            Thread.currentThread().contextClassLoader
                .getResourceAsStream("client/relive-simulator-client.js")!!.bufferedReader().readText()
        }
        get("/relive-simulator-client.js") {
            call.respondText(clientJs, ContentType.Application.JavaScript)
        }
        get("/relive-simulator-client.js.map") {
            if (jsMap != null) {
                call.respondText(jsMap!!, ContentType.Application.Json)
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
        get("/codemirror.css") {
            call.respondText(codemirrorCss, ContentType.Text.CSS)
        }
        post("/simulate") {
            val parameters = call.receive<SimulationParameters>()
            val token = simulate(parameters, call.application.environment.log)
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

        val options by lazy {
            val locales = mapOf("en" to "English", "zh_hant" to "繁体中文", "ko" to "한국어")
            val tagConfig = getTagConfig("tags.yaml")
            SimulationOptions(
                locales,
                getLocalizationConfig("commonText.yaml"),
                getLocalizationConfig("dress.yaml", playerDresses.keys),
                getLocalizationConfig("memoir.yaml", memoirs.keys).map { option ->
                    val tags = memoirs[option.id]!!.tags
                    option.copy(
                        description = option.name.keys.associateWith { locale ->
                            tags.joinToString(", ") { tag -> tagConfig[tag.name]?.get(locale)?.first() ?: tag.name }
                        },
                        tags = option.name.keys.associateWith { locale ->
                            tags.flatMap { tag -> tagConfig[tag.name]?.get(locale) ?: listOf(tag.name) }
                        },
                    )
                },
                getLocalizationConfig("songEffect.yaml", songEffects.keys),
                getLocalizationConfig("condition.yaml", conditions.keys),
                getLocalizationConfig("boss.yaml", bossLoadouts.keys),
                getLocalizationConfig("strategy.yaml", strategyParsers.keys),
                getLocalizationConfig("strategy.yaml", bossStrategyParsers.keys),
            )
        }
        get("/options") {
            call.respond(options)
        }

        val resourceCache = mutableMapOf<String, ByteArray>()
        get("/{path}") {
            val path = call.parameters["path"]!!
            val value = resourceCache[path]
                ?: Thread.currentThread().contextClassLoader.getResourceAsStream("client/$path")?.readBytes()?.also {
                    resourceCache[path] = it
                }
            if (value != null) {
                when {
                    path.endsWith(".wasm") -> call.respondBytes(value, ContentType.Application.Wasm)
                    path.endsWith(".js") -> call.respondText(value.decodeToString(),
                        ContentType.Application.JavaScript)
                    path.endsWith(".css") -> call.respondText(value.decodeToString(), ContentType.Text.CSS)
                    path.endsWith(".html") -> call.respondText(value.decodeToString(), ContentType.Text.Html)
                    else -> call.respondText(value.decodeToString())
                }
            } else {
                call.respond(HttpStatusCode.NotFound)
            }
        }
    }
}

private fun loadResourceText(path: String) =
    Thread.currentThread().contextClassLoader.getResourceAsStream(path)?.bufferedReader()?.readText()

private val configSerializer =
    MapSerializer(String.serializer(), MapSerializer(String.serializer(), String.serializer()))

private val tagConfigSerializer =
    MapSerializer(String.serializer(), MapSerializer(String.serializer(), ListSerializer(String.serializer())))

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

private fun getTagConfig(path: String): Map<String, Map<String, List<String>>> {
    return Yaml.default.decodeFromString(tagConfigSerializer, loadResourceText(path) ?: "{}")
}

private fun getLocalizationConfig(path: String, options: Iterable<String>) =
    decodeLocalizationConfig(loadResourceText(path) ?: "{}", options)

private fun getLocalizationConfig(path: String) =
    decodeLocalizationConfig(loadResourceText(path) ?: "{}")
