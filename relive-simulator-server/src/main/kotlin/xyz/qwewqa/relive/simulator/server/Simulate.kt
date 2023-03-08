package xyz.qwewqa.relive.simulator.server

import com.charleskorn.kaml.Yaml
import xyz.qwewqa.relive.simulator.common.LogEntry
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResult
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.common.SimulationResultValue
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.encodeToString
import org.slf4j.Logger
import xyz.qwewqa.relive.simulator.common.*
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.strategy.interactive.InteractiveSimulationController
import xyz.qwewqa.relive.simulator.core.stage.utils.summarize
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import kotlin.random.Random

val simulationResults = ConcurrentHashMap<String, SimulationResult>()
val logFilters = ConcurrentHashMap<String, LogFilter>()
val simulationJobs = ConcurrentHashMap<String, Job>()
val interactiveSimulations = ConcurrentHashMap<String, InteractiveSimulationController>()
val interactiveSimulationErrors = ConcurrentHashMap<String, String>()

private val tokenChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')

fun generateToken(): String {
  return Array(32) { tokenChars.random() }.joinToString("")
}

private val pool =
    Executors.newFixedThreadPool((Runtime.getRuntime().availableProcessors()))
        .asCoroutineDispatcher()

private const val SIMULATE_CHUNK_SIZE = 10000
private const val BASE_SIMULATE_RESULT_UPDATE_INTERVAL = 1000
private const val SIMULATE_RESULT_UPDATE_INCREMENT = 1000

fun simulate(parameters: SimulationParameters, logger: Logger? = null): String {
  val token = generateToken()
  logger?.info(
      "Performing simulation\nToken: $token\n---\n${Yaml.default.encodeToString(parameters)}",
  )
  simulationResults[token] =
      SimulationResult(
          maxIterations = parameters.maxIterations,
          currentIterations = 0,
          results = emptyList(),
          marginResults = emptyMap(),
          log = null,
      )
  if (parameters.maxIterations == 1) {
    simulationJobs[token] = simulateSingle(parameters, token, logger)
  } else {
    simulationJobs[token] = simulateMany(parameters, token, logger)
  }
  return token
}

fun simulateInteractive(parameters: SimulationParameters, logger: Logger? = null): String {
  val token = generateToken()
  logger?.info(
      "Performing interactive simulation\nToken: $token\n---\n${Yaml.default.encodeToString(parameters)}",
  )
  val loadout =
      try {
        parameters.createStageLoadout()
      } catch (e: Exception) {
        interactiveSimulationErrors[token] = e.stackTraceToString()
        return token
      }
  val controller = InteractiveSimulationController(parameters.maxTurns, parameters.seed, loadout)
  interactiveSimulations[token] = controller
  return token
}

private fun simulateSingle(
  parameters: SimulationParameters,
  token: String,
  logger: Logger? = null,
) =
    CoroutineScope(Dispatchers.Default).launch {
      val loadout = parameters.createStageLoadoutOrReportError(token) ?: return@launch
      val stage =
          loadout.create(
              Random(Random(parameters.seed).nextInt()),
              StageConfiguration(
                  logging = true)) // Seed the same was as one iteration of simulateMany
      val result = stage.play(PlayInfo(parameters.maxTurns, 0, 1))
      val results =
          listOf(SimulationResultValue(result.metadata.tags, result.toSimulationResult(), 1))
      val log = stage.logger.get()
      simulationResults[token] =
          SimulationResult(
                  maxIterations = parameters.maxIterations,
                  currentIterations = 1,
                  results = results,
                  marginResults = emptyMap(),
                  log = log,
                  error = (result as? PlayError)?.exception?.stackTraceToString(),
                  complete = true,
              )
              .also {
                logger?.info(
                    "Completed simulation\nToken: $token\n---\n${
                Yaml.default.encodeToString(ListSerializer(SimulationResultValue.serializer()), results)
            }")
              }
    }

private data class IterationResult(val index: Int, val seed: Int, val result: StageResult)

private val StageResult.resultPriority
  get() =
      when (this) {
        is ExcludedRun -> 0
        is Victory -> 1
        is OutOfTurns -> 2
        is TeamWipe -> 3
        is PlayError -> 4
      }

private fun simulateMany(
  parameters: SimulationParameters,
  token: String,
  logger: Logger? = null,
) =
    CoroutineScope(Dispatchers.Default).launch {
      val loadout = parameters.createStageLoadoutOrReportError(token) ?: return@launch
      val resultsChannel = Channel<IterationResult>(SIMULATE_CHUNK_SIZE)
      val seedProducer = Random(parameters.seed)
      val startTime = System.nanoTime()
      (0 until parameters.maxIterations)
          .asSequence()
          .map { it to seedProducer.nextInt() }
          .chunked(SIMULATE_CHUNK_SIZE)
          .forEach { seeds ->
            launch(pool) {
              seeds.map { (index, seed) ->
                resultsChannel.send(
                    IterationResult(
                        index,
                        seed,
                        loadout
                            .create(Random(seed), StageConfiguration(logging = false))
                            .play(PlayInfo(parameters.maxTurns, index, parameters.maxIterations)),
                    ))
              }
            }
          }
      var resultCount = 0
      val resultCounts = mutableMapOf<Pair<List<String>, SimulationResultType>, Int>()
      val marginResults = mutableMapOf<String, MutableList<MarginStageResult>>()
      var firstApplicableIteration: IterationResult? = null
      var updateInterval = BASE_SIMULATE_RESULT_UPDATE_INTERVAL
      var nextUpdateIndex = BASE_SIMULATE_RESULT_UPDATE_INTERVAL
      val resultEntries = mutableListOf<ResultEntry>()
      while (resultCount < parameters.maxIterations) {
        val nextIteration = resultsChannel.receive()
        if (firstApplicableIteration == null ||
            firstApplicableIteration.result.resultPriority < nextIteration.result.resultPriority ||
            (firstApplicableIteration.result.resultPriority ==
                nextIteration.result.resultPriority &&
                nextIteration.index < firstApplicableIteration.index)) {
          firstApplicableIteration = nextIteration
        }
        resultEntries +=
            ResultEntry(
                nextIteration.index,
                nextIteration.seed,
                nextIteration.result.toSimulationResult(),
                (nextIteration.result as? MarginStageResult)?.damage,
            )
        val nextResult = nextIteration.result
        val resultKey = nextResult.metadata.tags to nextResult.toSimulationResult()
        if (nextResult is MarginStageResult) {
          marginResults.getOrPut(nextResult.metadata.groupName) { mutableListOf() } += nextResult
        }
        resultCount++
        resultCounts[resultKey] = resultCounts.getOrDefault(resultKey, 0) + 1
        if (resultCount == nextUpdateIndex) {
          updateInterval += SIMULATE_RESULT_UPDATE_INCREMENT
          nextUpdateIndex += updateInterval
          simulationResults[token] =
              SimulationResult(
                  maxIterations = parameters.maxIterations,
                  currentIterations = resultCount,
                  results =
                      resultCounts.map { (k, v) -> SimulationResultValue(k.first, k.second, v) },
                  marginResults = marginResults.summarize(),
                  log = null,
                  runtime = (System.nanoTime() - startTime) / 1_000_000_000.0,
              )
        }
      }
      val loggedResult =
          firstApplicableIteration?.let {
            val stage = loadout.create(Random(it.seed), StageConfiguration(logging = true))
            val playResult =
                stage.play(PlayInfo(parameters.maxTurns, it.index, parameters.maxIterations))
            val header =
                LogEntry(
                    turn = 0,
                    tile = 0,
                    move = 0,
                    tags = listOf("Info"),
                    content = "Iteration ${it.index + 1}",
                )
            (listOf(header) + stage.logger.get()) to playResult
          }
      val results = resultCounts.map { (k, v) -> SimulationResultValue(k.first, k.second, v) }
      simulationResults[token] =
          SimulationResult(
                  maxIterations = parameters.maxIterations,
                  currentIterations = resultCount,
                  results = results,
                  marginResults = marginResults.summarize(),
                  log = loggedResult?.first,
                  runtime = (System.nanoTime() - startTime) / 1_000_000_000.0,
                  cancelled = false,
                  error = (loggedResult?.second as? PlayError)?.exception?.stackTraceToString(),
                  complete = true,
              )
              .also {
                logger?.info(
                    "Completed simulation\nToken: $token\n---\n${
                Yaml.default.encodeToString(ListSerializer(SimulationResultValue.serializer()), results)
            }")
              }
      logFilters[token] =
          LogFilter(
              loadout,
              parameters.maxTurns,
              parameters.maxIterations,
              resultEntries,
          )
    }

private fun SimulationParameters.createStageLoadoutOrReportError(token: String) =
    try {
      createStageLoadout()
    } catch (e: Exception) {
      simulationResults[token] =
          SimulationResult(
              maxIterations = maxIterations,
              currentIterations = 0,
              results = emptyList(),
              marginResults = emptyMap(),
              log = null,
              cancelled = true,
              error = e.stackTraceToString(),
          )
      null
    }
