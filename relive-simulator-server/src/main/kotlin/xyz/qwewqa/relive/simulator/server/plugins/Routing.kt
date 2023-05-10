package xyz.qwewqa.relive.simulator.server.plugins

import Accessories
import com.charleskorn.kaml.Yaml
import xyz.qwewqa.relive.simulator.common.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.cancel
import kotlinx.coroutines.cancelAndJoin
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import xyz.qwewqa.relive.simulator.common.*
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.core.stage.autoskill.remakeSkills
import xyz.qwewqa.relive.simulator.core.stage.dress.Dresses
import xyz.qwewqa.relive.simulator.core.stage.memoir.Memoirs
import xyz.qwewqa.relive.simulator.core.stage.strategy.bossStrategyParsers
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers
import xyz.qwewqa.relive.simulator.server.*

fun Application.configureRouting() {
  routing {
    // Static doesn't seem to work with GraalVM properly :(
    val index by lazy {
      Thread.currentThread()
          .contextClassLoader
          .getResourceAsStream("client/index.html")!!
          .bufferedReader()
          .readText()
    }
    val jsMap by lazy {
      Thread.currentThread()
          .contextClassLoader
          .getResourceAsStream("client/relive-simulator-client.js.map")
          ?.bufferedReader()
          ?.readText()
    }
    val codemirrorCss by lazy {
      Thread.currentThread()
          .contextClassLoader
          .getResourceAsStream("client/codemirror.css")!!
          .bufferedReader()
          .readText()
    }
    get("/") { call.respondText(index, ContentType.Text.Html) }
    get("/version") { call.respond(SimulatorVersion.CURRENT_VERSION) }
    get("/features") { call.respond(SimulatorFeatures()) }
    get("/index.html") { call.respondText(index, ContentType.Text.Html) }
    val clientJs by lazy {
      Thread.currentThread()
          .contextClassLoader
          .getResourceAsStream("client/relive-simulator-client.js")!!
          .bufferedReader()
          .readText()
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
    get("/codemirror.css") { call.respondText(codemirrorCss, ContentType.Text.CSS) }
    post("/simulate") {
      val parameters = call.receive<SimulationParameters>()
      val token = simulate(parameters, call.application.environment.log)
      call.respond(SimulateResponse(token))
    }
    post("/simulate_interactive") {
      val parameters = call.receive<SimulationParameters>()
      val token = simulateInteractive(parameters, call.application.environment.log)
      call.respond(SimulateResponse(token))
    }
    get("/interactive/{token}") {
      val token = call.parameters["token"]!!
      val rev = call.request.queryParameters["rev"]?.toIntOrNull() ?: -1
      val controller = interactiveSimulations[token]
      if (controller == null) {
        val errorMessage = interactiveSimulationErrors[token]
        if (errorMessage != null) {
          call.respond(
              InteractiveLog(
                  InteractiveLogData(
                      listOf(
                          LogEntry(tags = listOf("Error"), content = errorMessage),
                      ),
                      error = errorMessage,
                  ),
              )
          )
        } else {
          call.respond(HttpStatusCode.NotFound)
        }
      } else {
        call.respond(controller.getLog(rev))
      }
    }
    post("/interactive/{token}") {
      val token = call.parameters["token"]!!
      val command = call.receive<InteractiveCommand>()
      interactiveSimulations[token]?.sendCommand(command.text)
      call.respond(HttpStatusCode.NoContent)
    }
    get("/interactive/{token}/end") {
      val token = call.parameters["token"]!!
      interactiveSimulations[token]?.cancel()
      if (interactiveSimulations.remove(token) != null ||
          interactiveSimulationErrors.remove(token) != null) {
        call.respond(HttpStatusCode.NoContent)
      } else {
        call.respond(HttpStatusCode.NotFound)
      }
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
    post("/result/{token}/log") {
      val token = call.parameters["token"]!!
      val request = call.receive<FilterLogRequest>()
      val logFilter = logFilters[token]
      if (logFilter == null) {
        call.respond(HttpStatusCode.NotFound)
      } else {
        call.respond(logFilter.get(request))
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

    val resourceCache = mutableMapOf<String, ByteArray>()
    get("/{path...}") {
      val path = call.parameters.getAll("path")?.joinToString("/") ?: ""
      val value =
          resourceCache[path]
              ?: Thread.currentThread()
                  .contextClassLoader
                  .getResourceAsStream("client/$path")
                  ?.readBytes()
                  ?.also { resourceCache[path] = it }
      if (value != null) {
        when {
          path.endsWith(".wasm") -> call.respondBytes(value, ContentType.Application.Wasm)
          path.endsWith(".js") ->
              call.respondText(value.decodeToString(), ContentType.Application.JavaScript)
          path.endsWith(".css") -> call.respondText(value.decodeToString(), ContentType.Text.CSS)
          path.endsWith(".html") -> call.respondText(value.decodeToString(), ContentType.Text.Html)
          path.endsWith(".png") -> call.respondBytes(value, ContentType.Image.PNG)
          else -> call.respondText(value.decodeToString())
        }
      } else {
        call.respond(HttpStatusCode.NotFound)
      }
    }
  }
}

private fun loadResourceText(path: String) =
    Thread.currentThread()
        .contextClassLoader
        .getResourceAsStream(path)
        ?.bufferedReader()
        ?.readText()

private val configSerializer =
    MapSerializer(String.serializer(), MapSerializer(String.serializer(), String.serializer()))

private val tagConfigSerializer =
    MapSerializer(
        String.serializer(),
        MapSerializer(String.serializer(), ListSerializer(String.serializer())))

private fun decodeLocalizationConfig(
    text: String,
    options: Iterable<String>
): List<SimulationOption> {
  val localized = Yaml.default.decodeFromString(configSerializer, text)
  return options.map { SimulationOption(it, localized[it] ?: emptyMap()) }
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
