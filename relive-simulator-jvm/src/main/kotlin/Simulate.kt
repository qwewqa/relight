package xyz.qwewa.relive.simulator.jvm

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.StageLoadout
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random
import kotlin.system.measureNanoTime

suspend fun StageLoadout.simulate(count: Int, maxTurns: Int) = coroutineScope {
    val processorCount = Runtime.getRuntime().availableProcessors()
    val progressCounter = AtomicInteger()
    val completed = AtomicBoolean()
    val progressBarJob = launch {
        val barParts = " ▁▂▃▄▅▆▇█"
        val barSegmentCount = 20
        while (true) {
            if (completed.get()) {
                println("[${barParts.last().toString().repeat(barSegmentCount)}] $count/$count (100.00%)")
                break
            }
            val currentCount = progressCounter.get()
            val progress = currentCount.toDouble() / count
            var barBody = barParts.last().toString().repeat((progress * barSegmentCount).toInt())
            if (progress * barSegmentCount % 1 != 0.0) {
                barBody += barParts[(progress * barSegmentCount % 1 * (barParts.length - 1)).toInt()]
            }
            barBody += barParts.first().toString().repeat(barSegmentCount - barBody.length)
            val totalCountText = count.toString()
            print("[$barBody] ${currentCount.toString().padStart(totalCountText.length)}/$totalCountText " +
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
                            this@simulate.create(Random(it)).play(maxTurns).also { progressCounter.incrementAndGet() }
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
    val errors = results.count { it is PlayError }
    val excluded = results.count { it is ExcludedRun }
    if (excluded > 0) {
        println("Excluded $excluded iterations")
    }
    val included = results.size - excluded
    println("Complete in ${time / 1000000}ms (${"%.2f".format(time / results.size.toDouble())}ns per iteration)")
    println("Clear : ${"%.4f".format(100 * wins.toDouble() / included).padStart(8)}%")
    println("End   : ${"%.4f".format(100 * outOfTurns.toDouble() / included).padStart(8)}%")
    println("Wipe  : ${"%.4f".format(100 * wipes.toDouble() / included).padStart(8)}%")
    if (errors > 0) {
        println("Error : ${"%.4f".format(100 * errors.toDouble() / included).padStart(8)}%")
    }
}
