package xyz.qwewqa.relivesim.stage

/**
 * Value class representing a percentage value.
 */
@JvmInline
value class Percent(val value: Double) : Comparable<Percent> {
    override fun toString() = "$value%"

    operator fun times(other: Percent) = Percent(this.toDouble() * other.value)
    operator fun div(other: Percent) = Percent(this.value / other.toDouble())
    operator fun plus(other: Percent) = Percent(this.value + other.value)
    operator fun minus(other: Percent) = Percent(this.value - other.value)

    operator fun times(int: Int) = this.toDouble() * int
    operator fun times(double: Double) = this.toDouble() * double

    operator fun unaryPlus() = this
    operator fun unaryMinus() = Percent(-this.value)

    override operator fun compareTo(other: Percent) = value.compareTo(other.value)
}

inline val Int.percent get() = Percent(this.toDouble())
inline val Double.percent get() = Percent(this)

fun Double.toPercent() = Percent(this * 100.0)
fun Percent.toDouble() = this.value / 100.0

operator fun Int.times(percent: Percent) = this * percent.toDouble()
operator fun Double.times(percent: Percent) = this * percent.toDouble()
