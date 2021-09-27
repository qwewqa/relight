package xyz.qwewqa.relive.simulator.browser

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import xyz.qwewqa.relive.simulator.client.*
import xyz.qwewqa.relive.simulator.client.Simulation
import xyz.qwewqa.relive.simulator.core.presets.condition.conditions
import xyz.qwewqa.relive.simulator.core.presets.dress.bossLoadouts
import xyz.qwewqa.relive.simulator.core.presets.dress.playerDresses
import xyz.qwewqa.relive.simulator.core.presets.memoir.memoirs
import xyz.qwewqa.relive.simulator.core.presets.song.songEffects
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.condition.or
import xyz.qwewqa.relive.simulator.core.stage.condition.plus
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.TeamLoadout
import xyz.qwewqa.relive.simulator.core.stage.song.Song
import xyz.qwewqa.relive.simulator.core.stage.song.SongEffectData
import xyz.qwewqa.relive.simulator.core.stage.strategy.strategyParsers
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class BrowserSimulator : Simulator, CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext get() = job

    override suspend fun getOptions(): SimulationOptionNames {
        return SimulationOptionNames(
            playerDresses.keys.toList(),
            memoirs.keys.toList(),
            songEffects.keys.toList(),
            conditions.keys.toList(),
            bossLoadouts.keys.toList(),
            strategyParsers.keys.toList(),
        )
    }

    override suspend fun shutdown() {
        job.cancelAndJoin()
    }


    data class BrowserSimulation(var result: SimulationResult, var job: Job?) : Simulation {
        override suspend fun pollResult() = result

        override suspend fun cancel() {
            job?.cancelAndJoin()
            result = result.copy(cancelled = true)
        }
    }

    override suspend fun simulate(parameters: SimulationParameters): Simulation {
        val simulation = BrowserSimulation(
            SimulationResult(
                parameters.maxIterations,
                0,
                emptyList(),
                null,
                false,
                null,
            ),
            null,
        )
        if (parameters.maxIterations == 1) {
            simulation.job = simulateSingle(parameters, simulation)
        } else {
            simulation.job = simulateMany(parameters, simulation)
        }
        return simulation
    }

    private fun simulateSingle(parameters: SimulationParameters, simulation: BrowserSimulation) = launch {
        val loadout = parameters.createStageLoadoutOrReportError(simulation) ?: return@launch
        val stage =
            loadout.create(Random(Random(parameters.seed).nextInt()))  // Seed the same was as one iteration of xyz.qwewqa.relive.simulator.browser.simulateMany
        val result = stage.play(parameters.maxTurns)
        val log = stage.logger.toString()
        simulation.result = SimulationResult(
            parameters.maxIterations,
            1,
            listOf(SimulationResultValue(result.toSimulationResult(), 1)),
            log,
            error = (result as? PlayError)?.exception?.stackTraceToString()
        )
    }

    private fun simulateMany(parameters: SimulationParameters, simulation: BrowserSimulation) = launch {
        val loadout = parameters.createStageLoadoutOrReportError(simulation) ?: return@launch
        val seedProducer = Random(parameters.seed)
        var errorMessage: String? = null
        var resultCount = 0
        val resultCounts = mutableMapOf<SimulationResultType, Int>()
        (0 until parameters.maxIterations).asSequence().map { seedProducer.nextInt() }
            .forEach { seed ->
                val nextResult = loadout.create(Random(seed)).play(parameters.maxTurns)
                    .also {
                        if (it is PlayError && errorMessage == null) {
                            errorMessage = it.exception.stackTraceToString()
                        }
                    }
                    .toSimulationResult()
                resultCount++
                resultCounts[nextResult] = resultCounts.getOrPut(nextResult) { 0 } + 1
                if (resultCount % SIMULATE_CHUNK_SIZE == 0 || resultCount == parameters.maxIterations) {
                    simulation.result = SimulationResult(
                        parameters.maxIterations,
                        resultCount,
                        resultCounts.map { (k, v) -> SimulationResultValue(k, v) },
                        null,
                        false,
                        null,
                    )
                }
                yield()
            }

    }

    fun SimulationParameters.createStageLoadout(): StageLoadout {
        require(maxTurns > 0) { "Max turns should be a positive integer." }
        require(maxIterations > 0) { "Max iterations should be a positive integer" }
        require(team.isNotEmpty()) { "Team should not be empty." }
        require(team.map { it.name }.toSet().size == team.size) { "Team must not have duplicate names." }
        return StageLoadout(
            TeamLoadout(
                team.map {
                    ActorLoadout(
                        it.name,
                        playerDresses[it.dress]!!,
                        memoirs[it.memoir]!!,
                        it.unitSkillLevel,
                    )
                },
                guest?.let {
                    ActorLoadout(
                        it.name,
                        playerDresses[it.dress]!!,
                        memoirs[it.memoir]!!,
                        it.unitSkillLevel,
                    )
                },
                Song(
                    song.activeEffects.map {
                        SongEffectData(
                            songEffects[it.name]!!,
                            it.value,
                            it.conditions.map { group ->
                                group.map { name -> conditions[name]!! }.reduce { acc, condition -> acc or condition }
                            }.fold<NamedCondition?, NamedCondition?>(null) { acc, condition -> acc + condition }
                        )
                    },
                    song.passiveEffect?.let {
                        SongEffectData(
                            songEffects[it.name]!!,
                            it.value,
                            it.conditions.map { group ->
                                group.map { name -> conditions[name]!! }.reduce { acc, condition -> acc or condition }
                            }.fold<NamedCondition?, NamedCondition?>(null) { acc, condition -> acc + condition }
                        )
                    }
                ),
                strategyParsers[strategy.type]!!.parse(strategy.value),
            ),
            TeamLoadout(
                listOf(
                    bossLoadouts[boss]!!.loadout
                ),
                strategy = bossLoadouts[boss]!!.strategy
            ),
            {
                player.actors.values.forEach { it.eventBonus = eventBonus }
            },
            RandomDamageCalculator(),
            if (maxIterations > 1) StageConfiguration(logging = false) else StageConfiguration(logging = true)
        )
    }

    private fun SimulationParameters.createStageLoadoutOrReportError(simulation: BrowserSimulation) = try {
        createStageLoadout()
    } catch (e: Exception) {
        simulation.result = SimulationResult(
            maxIterations,
            0,
            emptyList(),
            "Error occurred during setup.",
            cancelled = true,
            error = e.stackTraceToString(),
        )
        null
    }

    fun StageResult.toSimulationResult() = when (this) {
        ExcludedRun -> SimulationResultType.Excluded
        is OutOfTurns -> SimulationResultType.End
        is PlayError -> SimulationResultType.Error
        is TeamWipe -> SimulationResultType.Wipe(turn)
        is Victory -> SimulationResultType.Victory(turn)
    }

}

private const val SIMULATE_CHUNK_SIZE = 1000