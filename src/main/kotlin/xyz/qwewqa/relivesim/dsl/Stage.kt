package xyz.qwewqa.relivesim.dsl

import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.*
import xyz.qwewqa.relivesim.stage.LoggingDamageCalculator
import xyz.qwewqa.relivesim.stage.Stage
import xyz.qwewqa.relivesim.stage.StageConfiguration
import xyz.qwewqa.relivesim.stage.StageResult
import xyz.qwewqa.relivesim.stage.team.Team
import java.util.concurrent.Executors
import kotlin.random.Random

@StageDslMarker
class StageBuilder {
    var playerTeam: Team? = null
    var enemyTeam: Team? = null
    var damageCalculator = LoggingDamageCalculator()
    var configuration = StageConfiguration()

    fun player(init: TeamBuilder.() -> Unit) {
        playerTeam = TeamBuilder().apply(init).build()
    }

    fun enemy(init: TeamBuilder.() -> Unit) {
        enemyTeam = TeamBuilder().apply(init).build()
    }

    fun build() = Stage(
        playerTeam ?: error("No player team."),
        enemyTeam ?: error("No enemy team"),
        damageCalculator,
        configuration,
    )
}

fun stage(init: StageBuilder.() -> Unit) = StageBuilder().apply(init).build()
suspend fun bulkRun(count: Int, maxTurns: Int, init: StageBuilder.() -> Unit): List<StageResult> = coroutineScope {
    val processorCount = Runtime.getRuntime().availableProcessors()
    val pool = Executors.newFixedThreadPool(processorCount).asCoroutineDispatcher()
    flow { repeat(count) { emit(stage(init)) } }
        .map { async(pool) { it.run(maxTurns) } }
        .buffer(processorCount)
        .map { it.await() }
        .toList()
        .also {
            pool.close()
        }
}
