package xyz.qwewqa.relivesim.dsl

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import xyz.qwewqa.relivesim.stage.LoggingDamageCalculator
import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.StageResult
import xyz.qwewqa.relivesim.stage.team.Team
import java.util.concurrent.Executors
import kotlin.random.Random

@StageDslMarker
class StageBuilder(val seed: Int? = null) {
    var playerTeam: Team? = null
    var enemyTeam: Team? = null
    var damageCalculator = LoggingDamageCalculator()
    var configuration = StageConfiguration()

    inline fun player(init: TeamBuilder.() -> Unit) {
        playerTeam = TeamBuilder().apply(init).build()
    }

    inline fun enemy(init: TeamBuilder.() -> Unit) {
        enemyTeam = TeamBuilder().apply(init).build()
    }

    fun build() = Stage(
        playerTeam ?: error("No player team."),
        enemyTeam ?: error("No enemy team"),
        damageCalculator,
        configuration,
        seed?.let { Random(it) } ?: Random.Default
    )
}

inline fun stage(seed: Int? = null, init: StageBuilder.() -> Unit) = StageBuilder(seed).apply(init).build()
suspend inline fun bulkPlay(count: Int, maxTurns: Int, crossinline init: StageBuilder.() -> Unit): List<StageResult> =
    coroutineScope {
        val processorCount = Runtime.getRuntime().availableProcessors()
        Executors.newFixedThreadPool(processorCount).asCoroutineDispatcher().use { pool ->
            (0 until count).chunked(10000).asFlow()
                .map { seeds ->
                    async(pool) { seeds.map { stage(seed = it, init).play(maxTurns) } }
                }
                .buffer(processorCount)
                .map { it.await() }
                .toList()
                .flatten()
        }
    }
