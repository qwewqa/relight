package xyz.qwewqa.relive.simulator.server

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import xyz.qwewqa.relive.simulator.core.stage.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.Executors
import kotlin.random.Random

val simulationResults = ConcurrentHashMap<String, SimulationResult>()
val simulationJobs = ConcurrentHashMap<String, Job>()

private val tokenChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
fun generateToken(): String {
    return Array(32) { tokenChars.random() }.joinToString("")
}

private val pool = Executors
    .newFixedThreadPool((Runtime.getRuntime().availableProcessors() - 2).coerceAtLeast(1))
    .asCoroutineDispatcher()

private const val SIMULATE_CHUNK_SIZE = 10000

suspend fun simulate(parameters: SimulationParameters): String {
    val token = generateToken()
    simulationResults[token] = SimulationResult(
        parameters.maxIterations,
        0,
        emptyList(),
        null
    )
    simulationJobs[token] = CoroutineScope(pool).launch {
        val loadout = parameters.createStageLoadout()
        val resultsChannel = Channel<StageResult>(SIMULATE_CHUNK_SIZE)
        (0 until parameters.maxIterations).chunked(SIMULATE_CHUNK_SIZE).forEach { seeds ->
            launch(pool) {
                seeds.map {
                    resultsChannel.send(loadout.create(Random(it)).play(parameters.maxTurns))
                }
            }
        }
        var resultCount = 0
        val resultCounts = mutableMapOf<SimulationResultType, Int>()
        while (resultCount < parameters.maxIterations) {
            val nextResult = resultsChannel.receive().toSimulationResult()
            resultCount++
            resultCounts[nextResult] = resultCounts.getOrDefault(nextResult, 0) + 1
            if (resultCount % SIMULATE_CHUNK_SIZE == 0) {
                simulationResults[token] = SimulationResult(
                    parameters.maxIterations,
                    resultCount,
                    resultCounts.map { (k, v) -> SimulationResultValue(k, v) },
                    null
                )
            }
        }
    }
    return token
}

fun StageResult.toSimulationResult() = when (this) {
    ExcludedRun -> SimulationResultType.Excluded
    is OutOfTurns -> SimulationResultType.End(margin)
    is PlayError -> SimulationResultType.Error
    is TeamWipe -> SimulationResultType.Wipe(turn)
    is Victory -> SimulationResultType.Victory(turn)
}
