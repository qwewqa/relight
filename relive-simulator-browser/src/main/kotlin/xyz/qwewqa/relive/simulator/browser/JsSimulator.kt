package xyz.qwewqa.relive.simulator.browser

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.browser.window
import kotlinx.coroutines.cancel
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.Worker
import org.w3c.dom.url.URL
import xyz.qwewqa.relive.simulator.client.*
import xyz.qwewqa.relive.simulator.common.*
import xyz.qwewqa.relive.simulator.core.stage.createStageLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.interactive.InteractiveSimulationController
import kotlin.collections.List
import kotlin.collections.MutableMap
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.emptyList
import kotlin.collections.emptyMap
import kotlin.collections.forEach
import kotlin.collections.getOrPut
import kotlin.collections.listOf
import kotlin.collections.map
import kotlin.collections.mapValues
import kotlin.collections.mutableMapOf
import kotlin.collections.set
import kotlin.collections.single
import kotlin.collections.toMap
import kotlin.random.Random

class JsSimulator : Simulator {
    override suspend fun simulate(parameters: SimulationParameters): Simulation {
        return JsSimulation(parameters)
    }

    override suspend fun simulateInteractive(parameters: SimulationParameters): InteractiveSimulation {
        return JsInteractiveSimulation(parameters)
    }

    override suspend fun version(): SimulatorVersion {
        return SimulatorClient.version
    }

    private val httpClient = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = false
                    ignoreUnknownKeys = false
                    allowSpecialFloatingPointValues = true
                    useArrayPolymorphism = false
                    encodeDefaults = true
                }
            )
        }
    }

    // This is a hack where the response from server is just copied here until I think of something better
    override suspend fun options(): SimulationOptions {
        return httpClient.get(
            URL(
                "options.json",
                "${window.location.protocol}//${window.location.host}${window.location.pathname}"
            ).href
        )
    }

    override suspend fun shutdown() {
        error("Not supported")
    }

    override suspend fun features(): SimulatorFeatures {
        return SimulatorFeatures(false)
    }
}

const val BATCH_SIZE = 500

class JsSimulation(val parameters: SimulationParameters) : Simulation {
    var resultCount = 0
    val resultCounts = mutableMapOf<Pair<List<String>, SimulationResultType>, Int>()
    val marginResults = mutableMapOf<SimulationMarginResultType, MutableMap<Int, Int>>()
    val seedProducer = Random(parameters.seed)
    var requestCount = 0
    val startTime = window.performance.now()
    var firstApplicableIteration: IterationResult? = null

    var overallResult = SimulationResult(
        maxIterations = parameters.maxIterations,
        currentIterations = 0,
        results = emptyList(),
        marginResults = emptyMap(),
        log = null,
    )

    @OptIn(ExperimentalSerializationApi::class)
    val workers = List(
        window.navigator.hardwareConcurrency.toInt().coerceAtMost(parameters.maxIterations / BATCH_SIZE)
            .coerceAtLeast(1)
    ) {
        Worker("relive-simulator-worker.js").also { worker ->
            worker.onmessage = { ev ->
                val results = Json.decodeFromString<List<IterationResult>>(ev.data as String)
                if (resultCount == parameters.maxIterations) {
                    // This means that this is the final run, for use with logging.
                    // This block should only be run once per simulation.
                    val result = results.single()
                    overallResult = overallResult.copy(
                        error = result.error,
                        log = result.log?.let {
                            val header = FormattedLogEntry(
                                turn = 0, tile = 0, move = 0,
                                tags = listOf("Info"),
                                content = "Iteration ${result.request.index + 1}",
                            )
                            listOf(header) + it
                        },
                        runtime = (window.performance.now() - startTime) / 1_000.0,
                        complete = true,
                    )
                } else {
                    results.forEach { result ->
                        if (firstApplicableIteration == null ||
                            firstApplicableIteration!!.resultPriority < result.resultPriority ||
                            (firstApplicableIteration!!.resultPriority == result.resultPriority &&
                                    result.request.index < firstApplicableIteration!!.request.index)
                        ) {
                            firstApplicableIteration = result
                        }
                        when (result.result) {
                            SimulationResultType.End -> SimulationMarginResultType.End
                            is SimulationResultType.Wipe -> SimulationMarginResultType.Wipe
                            else -> null
                        }?.let { marginType ->
                            val roundedMargin = (result.margin!! + 10000 - 1) / 10000 * 10000
                            val typeResults = marginResults.getOrPut(marginType) { mutableMapOf() }
                            typeResults[roundedMargin] = (typeResults[roundedMargin] ?: 0) + 1
                        }
                        resultCount++
                        resultCounts[result.tags to result.result] =
                            (resultCounts[result.tags to result.result] ?: 0) + 1
                    }
                    overallResult = SimulationResult(
                        maxIterations = parameters.maxIterations,
                        currentIterations = resultCount,
                        results = resultCounts.map { (k, v) -> SimulationResultValue(k.first, k.second, v) },
                        marginResults = marginResults.mapValues { (_, v) -> v.toMap() },
                        log = null,
                        runtime = (window.performance.now() - startTime) / 1_000.0,
                    )
                    val batchSize = (parameters.maxIterations - requestCount).coerceAtMost(BATCH_SIZE)
                    if (batchSize > 0) {
                        worker.postMessage(Json.encodeToString(List(batchSize) {
                            IterationRequest(
                                requestCount++,
                                seedProducer.nextInt(),
                            )
                        }))
                    }
                    if (resultCount == parameters.maxIterations) {
                        worker.postMessage(
                            Json.encodeToString(
                                listOf(
                                    firstApplicableIteration!!.request.copy(log = true)
                                )
                            )
                        )
                    }
                }
            }
            worker.postMessage(Json.encodeToString(parameters))
            val batchSize = (parameters.maxIterations - requestCount).coerceAtMost(BATCH_SIZE)
            if (batchSize > 0) {
                worker.postMessage(Json.encodeToString(List(batchSize) {
                    IterationRequest(
                        requestCount++,
                        seedProducer.nextInt(),
                    )
                }))
            }
        }
    }

    override suspend fun pollResult() = overallResult
    override suspend fun cancel() {
        workers.forEach { it.terminate() }
        overallResult = overallResult.copy(cancelled = true)
    }
}

class JsInteractiveSimulation(val parameters: SimulationParameters) : InteractiveSimulation {
    private var error: String? = null
    private val controller = try {
        InteractiveSimulationController(parameters.maxTurns, parameters.seed, parameters.createStageLoadout()).also {
            it.play()
        }
    } catch (e: Exception) {
        error = e.message
        null
    }

    override suspend fun getLog(): List<FormattedLogEntry> {
        return controller?.getLog() ?: listOf(FormattedLogEntry(tags = listOf("Error"), content = error!!))
    }

    override suspend fun sendCommand(text: String) {
        controller?.sendCommand(text)
    }

    override suspend fun end() {
        controller?.cancel()
    }
}

@Serializable
data class IterationRequest(
    val index: Int,
    val seed: Int,
    val log: Boolean = false,
)

@Serializable
data class IterationResult(
    val request: IterationRequest,
    val result: SimulationResultType,
    val tags: List<String> = emptyList(),
    val margin: Int? = 0,
    val log: List<FormattedLogEntry>? = null,
    val error: String? = null,
)

private val IterationResult.resultPriority
    get() = when (this.result) {
        is SimulationResultType.Excluded -> 0
        is SimulationResultType.Victory -> 1
        is SimulationResultType.End -> 2
        is SimulationResultType.Wipe -> 3
        is SimulationResultType.Error -> 4
    }
