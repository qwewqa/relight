package xyz.qwewqa.relivesim.dsl

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import xyz.qwewqa.relivesim.stage.*
import xyz.qwewqa.relivesim.stage.team.Team
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

@StageDslMarker
class StageBuilder(val seed: Int? = null) : Builder<Stage> {
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

    override fun build() = Stage(
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

suspend fun simulate(count: Int, maxTurns: Int, init: StageBuilder.() -> Unit) = coroutineScope {
    val processorCount = Runtime.getRuntime().availableProcessors()
    val progressCounter = AtomicInteger()
    val completed = AtomicBoolean()
    val progressBarJob = launch {
        val barParts = " ▁▃▄▅▆▇█"
        val barSegmentCount = 20
        while (true) {
            if (completed.get()) {
                println("|${barParts.last().toString().repeat(barSegmentCount)}| $count/$count (100.00%)")
                break
            }
            val currentCount = progressCounter.get()
            val progress = currentCount.toDouble() / count
            var barBody = barParts.last().toString().repeat((progress * barSegmentCount).toInt())
            if (progress * barSegmentCount % 1 != 0.0) {
                barBody += barParts[(progress * barSegmentCount % 1 * (barParts.length - 1)).toInt()]
            }
            barBody += " ".repeat(barSegmentCount - barBody.length)
            val totalCountText = count.toString()
            print("|$barBody| ${currentCount.toString().padStart(totalCountText.length)}/$totalCountText " +
                    "(${"%.2f".format(progress * 100).padStart(6)}%)\r")
            delay(10)
        }
    }
    val results: List<StageResult>
    val time = measureNanoTime {
        results = Executors.newFixedThreadPool(processorCount).asCoroutineDispatcher().use { pool ->
            (0 until count).chunked(10000).asFlow()
                .map { seeds ->
                    async(pool) {
                        seeds.map {
                            stage(seed = it, init).play(maxTurns).also { progressCounter.incrementAndGet() }
                        }
                    }
                }
                .buffer(processorCount)
                .map { it.await() }
                .toList()
                .flatten()
        }
        completed.set(true)
    }
    progressBarJob.join()
    val wins = results.count { it is Victory }
    val outOfTurns = results.count { it is OutOfTurns }
    val wipes = results.count { it is TeamWipe }
    println("Complete in ${time / 1000000}ms (${"%.2f".format(time / count.toDouble())}ns per iteration)")
    println("Win : ${"%.4f".format(100 * wins.toDouble() / results.size).padStart(8)}%")
    println("Fail: ${"%.4f".format(100 * outOfTurns.toDouble() / results.size).padStart(8)}%")
    println("Wipe: ${"%.4f".format(100 * wipes.toDouble() / results.size).padStart(8)}%")
}
