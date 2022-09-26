package xyz.qwewqa.relive.simulator.core.stage.utils

import xyz.qwewqa.relive.simulator.common.StatisticsSummary
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

fun List<Int>.statistics() = if (isEmpty()) {
    null
} else {
    val sorted = sorted()
    val mean = sorted.average()
    val standardDeviation = sorted.map { (it - mean).pow(2) }.average().pow(0.5)
    val min = sorted.first().toDouble()
    val q1 = sorted[sorted.size / 4].toDouble()
    val median = sorted[sorted.size / 2].toDouble()
    val q3 = sorted[sorted.size * 3 / 4].toDouble()
    val max = sorted.last().toDouble()
    StatisticsSummary(mean, standardDeviation, min, q1, median, q3, max)
}

fun resultMarginKernelDensityEstimate(data: List<Int>) =
    epanechnikovKernelDensityEstimate(data.map { it.toDouble() }, 1_000_000.0, 10000)

fun epanechnikovKernelDensityEstimate(data: List<Double>, h: Double, count: Int): Map<Double, Double> {
    if (data.isEmpty()) return emptyMap()
    require(count >= 2)
    fun kernel(x: Double) = 0.75 * (1 - x * x)
    val min = data.min() - h
    val max = data.max() + h
    val step = (max - min) / (count - 1)
    val results = MutableList(count) { 0.0 }
    for (x in data) {
        val lb = ceil((x - h - min) / step).toInt()
        val ub = floor((x + h - min) / step).toInt()
        for (i in lb..ub) {
            results[i] += kernel((x - (min + i * step)) / h) / h / data.size
        }
    }
    return (0 until count).associate { min + it * step to results[it] }
}
