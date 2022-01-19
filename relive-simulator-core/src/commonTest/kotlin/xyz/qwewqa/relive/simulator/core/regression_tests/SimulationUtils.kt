package xyz.qwewqa.relive.simulator.core.regression_tests

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import xyz.qwewqa.relive.simulator.common.SimulationParameters
import xyz.qwewqa.relive.simulator.common.SimulationResultType
import xyz.qwewqa.relive.simulator.core.stage.StageResult
import xyz.qwewqa.relive.simulator.core.stage.createStageLoadout
import xyz.qwewqa.relive.simulator.core.stage.toSimulationResult
import kotlin.random.Random
import kotlin.test.assertEquals

suspend fun assertSimulationResults(
    config: String,
    results: Map<SimulationResultType, Int>,
) = assertEquals(
    // Sorting just makes diffs easier to read
    results.map { (k, v) -> k to v }.sortedBy { it.first.toString() },
    simulationConfig(config).simulate().aggregate().map { (k, v) -> k to v }.sortedBy { it.first.toString() },
)

fun simulationConfig(value: String): SimulationParameters = Json.decodeFromString(value)

suspend fun SimulationParameters.simulate(): List<StageResult> {
    val seedProducer = Random(seed)
    val loadout = createStageLoadout()
    return generateSequence { seedProducer.nextInt() }
        .take(maxIterations)
        .toList()
        .map { seed ->
            loadout.create(Random(seed)).play(maxTurns)
        }
}

fun List<StageResult>.aggregate() = mutableMapOf<SimulationResultType, Int>().also {
    this.forEach { result ->
        val resultType = result.toSimulationResult()
        it[resultType] = (it[resultType] ?: 0) + 1
    }
}
