package xyz.qwewqa.relive.simulator.browser

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.set
import kotlin.random.Random
import kotlinx.browser.window
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.w3c.dom.Worker
import org.w3c.dom.url.URL
import org.w3c.files.Blob
import org.w3c.files.BlobPropertyBag
import xyz.qwewqa.relive.simulator.client.InteractiveSimulation
import xyz.qwewqa.relive.simulator.client.Simulation
import xyz.qwewqa.relive.simulator.client.Simulator
import xyz.qwewqa.relive.simulator.client.SimulatorClient
import xyz.qwewqa.relive.simulator.common.FilterLogRequest
import xyz.qwewqa.relive.simulator.common.FilterLogResponse
import xyz.qwewqa.relive.simulator.common.InteractiveLog
import xyz.qwewqa.relive.simulator.common.InteractiveLogData
import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.MarginResult
import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.SimulationOptions
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResult
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.common.SimulationResultValue
import xyz.qwewqa.relive.simulator.common.SimulatorFeatures
import xyz.qwewqa.relive.simulator.common.SimulatorVersion
import xyz.qwewqa.relive.simulator.core.getSimulationOptions
import xyz.qwewqa.relive.simulator.core.stage.ExcludedRun
import xyz.qwewqa.relive.simulator.core.stage.LogFilter
import xyz.qwewqa.relive.simulator.core.stage.MarginStageResult
import xyz.qwewqa.relive.simulator.core.stage.OutOfTurns
import xyz.qwewqa.relive.simulator.core.stage.PlayError
import xyz.qwewqa.relive.simulator.core.stage.ResultEntry
import xyz.qwewqa.relive.simulator.core.stage.StageResultMetadata
import xyz.qwewqa.relive.simulator.core.stage.TeamWipe
import xyz.qwewqa.relive.simulator.core.stage.Victory
import xyz.qwewqa.relive.simulator.core.stage.createStageLoadout
import xyz.qwewqa.relive.simulator.core.stage.strategy.interactive.InteractiveSimulationController
import xyz.qwewqa.relive.simulator.core.stage.utils.summarize

const val WORKER_URL = "relive-simulator-worker.js"

class JsSimulator : Simulator {

  private var workerScriptBlob: Blob? = null

  private suspend fun getWorkerScript(): Blob =
      workerScriptBlob
          ?: run {
            val response: String =
                httpClient
                    .get(
                        URL(
                                WORKER_URL,
                                "${window.location.protocol}//${window.location.host}${window.location.pathname}")
                            .href)
                    .body()
            val blob = Blob(arrayOf(response), BlobPropertyBag("text/javascript"))
            workerScriptBlob = blob
            blob
          }

  override suspend fun simulate(parameters: SimulationParameters): Simulation {
    return JsSimulation(getWorkerScript(), parameters)
  }

  override suspend fun simulateInteractive(
      parameters: SimulationParameters
  ): InteractiveSimulation {
    return JsInteractiveSimulation(parameters)
  }

  override suspend fun version(): SimulatorVersion {
    return SimulatorClient.version
  }

  private val httpClient = HttpClient {
    install(ContentNegotiation) {
      json(
          Json {
            isLenient = true
            ignoreUnknownKeys = true
            allowSpecialFloatingPointValues = true
            useArrayPolymorphism = false
            encodeDefaults = true
          })
    }
  }

  override suspend fun options(): SimulationOptions = getSimulationOptions()

  override suspend fun shutdown() {
    error("Not supported")
  }

  override suspend fun features(): SimulatorFeatures {
    return SimulatorFeatures(false)
  }
}

const val TARGET_BATCH_SIZE = 500
const val ADD_THREAD_ITERATION_THRESHOLD = 5000

infix fun Int.ceilDiv(divisor: Int): Int = (this + divisor - 1) / divisor

fun calcThreadCount(iterations: Int, maxThreads: Int): Int =
    (iterations ceilDiv ADD_THREAD_ITERATION_THRESHOLD).coerceIn(1, maxThreads)

fun calcBatchSize(iterations: Int, threads: Int): Int {
  val iterationsPerThread = iterations ceilDiv threads
  val batchesPerThread = iterationsPerThread ceilDiv TARGET_BATCH_SIZE
  return iterationsPerThread ceilDiv batchesPerThread
}

class JsSimulation(val scriptBlob: Blob, val parameters: SimulationParameters) : Simulation {
  var resultCount = 0
  val resultCounts = mutableMapOf<Pair<List<String>, SimulationResultType>, Int>()
  val marginResults = mutableMapOf<String, MutableList<MarginStageResult>>()
  val seedProducer = Random(parameters.seed)
  var requestCount = 0
  val startTime = window.performance.now()
  var firstApplicableIteration: IterationResult? = null
  val resultEntries = mutableListOf<ResultEntry>()
  var logFilter: LogFilter? = null

  var marginSummary: Map<SimulationMarginResultType, Map<String?, MarginResult>> = emptyMap()
  var lastUpdatedMarginSummary = 0

  val json = Json { encodeDefaults = true }

  var overallResult =
      SimulationResult(
          maxIterations = parameters.maxIterations,
          currentIterations = 0,
          results = emptyList(),
          marginResults = emptyMap(),
          log = null,
      )

  fun updateResults() {
    if (resultCount == parameters.maxIterations) {
      lastUpdatedMarginSummary = resultCount
      marginSummary = marginResults.summarize()
    } else if (resultCount > lastUpdatedMarginSummary * 1.5) {
      lastUpdatedMarginSummary = resultCount
      marginSummary = marginResults.summarize(500)
    }
    overallResult =
        SimulationResult(
            maxIterations = parameters.maxIterations,
            currentIterations = resultCount,
            results = resultCounts.map { (k, v) -> SimulationResultValue(k.first, k.second, v) },
            marginResults = marginSummary,
            log = null,
            runtime = (window.performance.now() - startTime) / 1_000.0,
        )
  }

  val workerCount =
      calcThreadCount(parameters.maxIterations, window.navigator.hardwareConcurrency.toInt())

  val maxBatchSize = calcBatchSize(parameters.maxIterations, workerCount)

  val workers =
      List(workerCount) {
        Worker(URL.createObjectURL(scriptBlob)).also { worker ->
          worker.onmessage = { ev ->
            val results = Json.decodeFromString<List<IterationResult>>(ev.data as String)
            if (resultCount == parameters.maxIterations) {
              // This means that this is the final run, for use with logging as a rerun of a
              // previous iteration.
              // This block should only be run once per simulation.
              val result = results.single()
              overallResult =
                  overallResult.copy(
                      error = result.error,
                      log =
                          result.log?.let {
                            val header =
                                LogEntry(
                                    turn = 0,
                                    tile = 0,
                                    move = 0,
                                    tags = listOf("Info"),
                                    content = "Iteration ${result.request.index + 1}",
                                )
                            listOf(header) + it
                          },
                      runtime = (window.performance.now() - startTime) / 1_000.0,
                      complete = true,
                  )
              finish()
            } else {
              results.forEach { result ->
                if (firstApplicableIteration == null ||
                    firstApplicableIteration!!.resultPriority < result.resultPriority ||
                    (firstApplicableIteration!!.resultPriority == result.resultPriority &&
                        result.request.index < firstApplicableIteration!!.request.index)) {
                  firstApplicableIteration = result
                }
                val stageResult = result.toStageResult()
                if (stageResult is MarginStageResult) {
                  marginResults
                      .getOrPut(stageResult.metadata.groupName) { mutableListOf() }
                      .add(stageResult)
                }
                resultCount++
                resultCounts[result.tags to result.result] =
                    (resultCounts[result.tags to result.result] ?: 0) + 1
                resultEntries +=
                    ResultEntry(
                        index = result.request.index,
                        seed = result.request.seed,
                        type = result.result,
                        damage = result.damage,
                    )
              }
              updateResults()
              val batchSize = (parameters.maxIterations - requestCount).coerceAtMost(maxBatchSize)
              if (batchSize > 0) {
                worker.postMessage(
                    json.encodeToString(
                        List(batchSize) {
                          IterationRequest(
                              requestCount++,
                              seedProducer.nextInt(),
                          )
                        }))
              }
              if (resultCount == parameters.maxIterations) {
                worker.postMessage(
                    json.encodeToString(
                        listOf(firstApplicableIteration!!.request.copy(log = true))))
              }
            }
          }
          worker.postMessage(json.encodeToString(parameters))
          val batchSize = (parameters.maxIterations - requestCount).coerceAtMost(maxBatchSize)
          if (batchSize > 0) {
            worker.postMessage(
                json.encodeToString(
                    List(batchSize) {
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

  override suspend fun filterLog(request: FilterLogRequest): FilterLogResponse {
    return logFilter?.get(request) ?: FilterLogResponse(null, null, 0)
  }

  private fun finish() {
    workers.forEach { it.terminate() }
    logFilter =
        LogFilter(
            parameters.createStageLoadout(),
            parameters.maxTurns,
            parameters.maxIterations,
            resultEntries,
        )
  }
}

class JsInteractiveSimulation(val parameters: SimulationParameters) : InteractiveSimulation {
  private var rev = -1
  private var error: String? = null
  private val controller =
      try {
        InteractiveSimulationController(
            parameters.maxTurns, parameters.seed, parameters.createStageLoadout())
      } catch (e: Exception) {
        error = e.message
        null
      }

  override suspend fun getLog(): InteractiveLog {
    return controller?.getLog(rev)?.also { rev = it.rev }
        ?: InteractiveLog(
            InteractiveLogData(
                listOf(LogEntry(tags = listOf("Error"), content = error!!)),
                error = error,
            ))
  }

  override suspend fun sendCommand(text: String) {
    controller?.sendCommand(text)
  }

  override suspend fun end() {}
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
    val groupName: String,
    val tags: List<String> = emptyList(),
    val margin: Double? = 0.0,
    val damage: Double? = 0.0,
    val log: List<LogEntry>? = null,
    val error: String? = null,
) {
  fun toStageResult() =
      when (result) {
        is SimulationResultType.Excluded ->
            ExcludedRun(
                StageResultMetadata(groupName, tags),
            )
        is SimulationResultType.Victory ->
            Victory(
                result.turn,
                result.tile,
                StageResultMetadata(groupName, tags),
            )
        is SimulationResultType.End ->
            OutOfTurns(
                damage ?: 0.0,
                margin ?: 0.0,
                StageResultMetadata(groupName, tags),
            )
        is SimulationResultType.Wipe ->
            TeamWipe(
                damage ?: 0.0,
                margin ?: 0.0,
                result.turn,
                result.tile,
                StageResultMetadata(groupName, tags),
            )
        is SimulationResultType.Error ->
            PlayError(
                Exception(error),
                StageResultMetadata(groupName, tags),
            )
      }
}

private val IterationResult.resultPriority
  get() =
      when (this.result) {
        is SimulationResultType.Excluded -> 0
        is SimulationResultType.Victory -> 1
        is SimulationResultType.End -> 2
        is SimulationResultType.Wipe -> 3
        is SimulationResultType.Error -> 4
      }
