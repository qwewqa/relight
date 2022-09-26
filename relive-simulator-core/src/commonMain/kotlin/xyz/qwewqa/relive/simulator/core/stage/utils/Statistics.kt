package xyz.qwewqa.relive.simulator.core.stage.utils

import xyz.qwewqa.relive.simulator.common.MarginResult
import xyz.qwewqa.relive.simulator.common.SimulationMarginResultType
import xyz.qwewqa.relive.simulator.common.StatisticsSummary
import xyz.qwewqa.relive.simulator.core.stage.MarginStageResult
import xyz.qwewqa.relive.simulator.core.stage.marginResultType
import kotlin.math.ceil
import kotlin.math.floor
import kotlin.math.pow

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

fun resultMarginKernelDensityEstimate(data: List<Int>, h: Double): Map<Double, Double> {
    // Bin the data to reduce the number of points.
    return epanechnikovKernelDensityEstimate(data.map { it.toDouble() }, h, 1_000)
}

fun chooseBandwidth(data: List<Int>): Double {
    val stats = data.statistics() ?: return 1.0
    return 0.6 * stats.stdDev * data.size.toDouble().pow(-0.2)
}

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

fun Map<String, List<MarginStageResult>>.summarize() = SimulationMarginResultType.values().associateWith { type ->
    val typeValues = values.flatten().filter { it.marginResultType() == type }
    val damageH: Double
    val marginH: Double
    val typeResults = typeValues.run {
        val damage = map { it.damage }
        val margins = map { it.margin }
        damageH = chooseBandwidth(damage)
        marginH = chooseBandwidth(margins)
        MarginResult(
            resultMarginKernelDensityEstimate(damage, damageH),
            damage.statistics(),
            resultMarginKernelDensityEstimate(margins, marginH),
            margins.statistics(),
        )
    }
    mapValues { (_, results) ->
        results.filter { it.marginResultType() == type }.run {
            val damage = map { it.damage }
            val margins = map { it.margin }
            val scale = size.toDouble() / typeValues.size
            MarginResult(
                resultMarginKernelDensityEstimate(damage, damageH).mapValues { (_, v) -> v * scale },
                damage.statistics(),
                resultMarginKernelDensityEstimate(margins, marginH).mapValues { (_, v) -> v * scale },
                margins.statistics(),
            )
        }
    } + mapOf(
        null to typeResults,
    )
}
