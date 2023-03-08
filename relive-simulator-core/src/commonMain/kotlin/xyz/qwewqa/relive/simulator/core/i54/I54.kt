@file:Suppress("NOTHING_TO_INLINE", "OVERRIDE_BY_INLINE")

package xyz.qwewqa.relive.simulator.core.i54

import kotlin.jvm.JvmInline
import kotlin.math.truncate

@JvmInline
value class I54(val value: Double) : Comparable<I54> {
  inline operator fun compareTo(other: Byte) = value.compareTo(other)
  inline operator fun compareTo(other: Short) = value.compareTo(other)
  inline operator fun compareTo(other: Int) = value.compareTo(other)
  inline operator fun compareTo(other: Long) = value.compareTo(other)
  inline operator fun compareTo(other: Float) = value.compareTo(other)
  inline operator fun compareTo(other: Double) = value.compareTo(other)
  override operator fun compareTo(other: I54) = value.compareTo(other.value)

  inline operator fun plus(other: Byte) = I54(value + other)
  inline operator fun plus(other: Short) = I54(value + other)
  inline operator fun plus(other: Int) = I54(value + other)
  inline operator fun plus(other: Long) = I54(value + other)
  inline operator fun plus(other: Float) = value + other
  inline operator fun plus(other: Double) = value + other
  inline operator fun plus(other: I54) = I54(value + other.value)

  inline operator fun minus(other: Byte) = I54(value - other)
  inline operator fun minus(other: Short) = I54(value - other)
  inline operator fun minus(other: Int) = I54(value - other)
  inline operator fun minus(other: Long) = I54(value - other)
  inline operator fun minus(other: Float) = value - other
  inline operator fun minus(other: Double) = value - other
  inline operator fun minus(other: I54) = I54(value - other.value)

  inline operator fun times(other: Byte) = I54(value * other)
  inline operator fun times(other: Short) = I54(value * other)
  inline operator fun times(other: Int) = I54(value * other)
  inline operator fun times(other: Long) = I54(value * other)
  inline operator fun times(other: Float) = value * other
  inline operator fun times(other: Double) = value * other
  inline operator fun times(other: I54) = I54(value * other.value)

  inline operator fun div(other: Byte) = I54(truncate(value / other))
  inline operator fun div(other: Short) = I54(truncate(value / other))
  inline operator fun div(other: Int) = I54(truncate(value / other))
  inline operator fun div(other: Long) = I54(truncate(value / other))
  inline operator fun div(other: Float) = value / other
  inline operator fun div(other: Double) = value / other
  inline operator fun div(other: I54) = I54(truncate(value / other.value))

  inline operator fun rem(other: Byte) = I54(value % other)
  inline operator fun rem(other: Short) = I54(value % other)
  inline operator fun rem(other: Int) = I54(value % other)
  inline operator fun rem(other: Long) = I54(value % other)
  inline operator fun rem(other: Float) = value % other
  inline operator fun rem(other: Double) = value % other
  inline operator fun rem(other: I54) = I54(value % other.value)

  inline operator fun inc() = I54(value + 1)

  inline operator fun dec() = I54(value - 1)

  inline operator fun unaryPlus() = this
  inline operator fun unaryMinus() = I54(-value)

  fun toInt() = value.toInt()
  fun toLong() = value.toLong()
  fun toFloat() = value.toFloat()
  fun toDouble() = value
  fun toI54() = this

  override inline fun toString() = value.toLong().toString()

  inline infix fun ptmul(other: Byte) = I54(truncate(value * other / 100.0))
  inline infix fun ptmul(other: Short) = I54(truncate(value * other / 100.0))
  inline infix fun ptmul(other: Int) = I54(truncate(value * other / 100.0))
  inline infix fun ptmul(other: Long) = I54(truncate(value * other / 100.0))
  inline infix fun ptmul(other: Float) = I54(truncate(value * other / 100.0))
  inline infix fun ptmul(other: Double) = I54(truncate(value * other / 100.0))
  inline infix fun ptmul(other: I54) = I54(truncate(value * other.value / 100.0))

  inline infix fun ptmod(other: Byte) = I54(truncate(value * (100 + other) / 100.0))
  inline infix fun ptmod(other: Short) = I54(truncate(value * (100 + other) / 100.0))
  inline infix fun ptmod(other: Int) = I54(truncate(value * (100 + other) / 100.0))
  inline infix fun ptmod(other: Long) = I54(truncate(value * (100 + other) / 100.0))
  inline infix fun ptmod(other: Float) = I54(truncate(value * (100 + other) / 100.0))
  inline infix fun ptmod(other: Double) = I54(truncate(value * (100 + other) / 100.0))
  inline infix fun ptmod(other: I54) = I54(truncate(value * (100 + other.value) / 100.0))
}

inline operator fun Byte.compareTo(other: I54) = compareTo(other.value)

inline operator fun Short.compareTo(other: I54) = compareTo(other.value)

inline operator fun Int.compareTo(other: I54) = compareTo(other.value)

inline operator fun Long.compareTo(other: I54) = compareTo(other.value)

inline operator fun Float.compareTo(other: I54) = compareTo(other.value)

inline operator fun Double.compareTo(other: I54) = compareTo(other.value)

inline operator fun Byte.plus(other: I54) = I54(this + other.value)

inline operator fun Short.plus(other: I54) = I54(this + other.value)

inline operator fun Int.plus(other: I54) = I54(this + other.value)

inline operator fun Long.plus(other: I54) = I54(this + other.value)

inline operator fun Float.plus(other: I54) = this + other.value

inline operator fun Double.plus(other: I54) = this + other.value

inline operator fun Byte.minus(other: I54) = I54(this - other.value)

inline operator fun Short.minus(other: I54) = I54(this - other.value)

inline operator fun Int.minus(other: I54) = I54(this - other.value)

inline operator fun Long.minus(other: I54) = I54(this - other.value)

inline operator fun Float.minus(other: I54) = this - other.value

inline operator fun Double.minus(other: I54) = this - other.value

inline operator fun Byte.times(other: I54) = I54(this * other.value)

inline operator fun Short.times(other: I54) = I54(this * other.value)

inline operator fun Int.times(other: I54) = I54(this * other.value)

inline operator fun Long.times(other: I54) = I54(this * other.value)

inline operator fun Float.times(other: I54) = this * other.value

inline operator fun Double.times(other: I54) = this * other.value

inline operator fun Byte.div(other: I54) = I54(truncate(this / other.value))

inline operator fun Short.div(other: I54) = I54(truncate(this / other.value))

inline operator fun Int.div(other: I54) = I54(truncate(this / other.value))

inline operator fun Long.div(other: I54) = I54(truncate(this / other.value))

inline operator fun Float.div(other: I54) = this / other.value

inline operator fun Double.div(other: I54) = this / other.value

inline operator fun Byte.rem(other: I54) = I54(this % other.value)

inline operator fun Short.rem(other: I54) = I54(this % other.value)

inline operator fun Int.rem(other: I54) = I54(this % other.value)

inline operator fun Long.rem(other: I54) = I54(this % other.value)

inline operator fun Float.rem(other: I54) = this % other.value

inline operator fun Double.rem(other: I54) = this % other.value

/**
 * Equivalent to toI54(), but this is preferred for literals. For non-literals, prefer toI54() for
 * consistency.
 */
inline val Int.i54: I54
  get() = I54(this.toDouble())

inline fun Byte.toI54() = I54(this.toDouble())

inline fun Short.toI54() = I54(this.toDouble())

inline fun Int.toI54() = I54(this.toDouble())

inline fun Long.toI54() = I54(this.toDouble())

inline fun Float.toI54() = I54(truncate(this.toDouble()))

inline fun Double.toI54() = I54(truncate(this))

inline fun Double.toI54Unchecked() = I54(this)

inline fun I54.coerceAtLeast(minimumValue: Int) = I54(value.coerceAtLeast(minimumValue.toDouble()))

inline fun I54.coerceAtMost(maximumValue: Int) = I54(value.coerceAtMost(maximumValue.toDouble()))

inline fun I54.coerceIn(minimumValue: Int, maximumValue: Int) =
    I54(value.coerceIn(minimumValue.toDouble(), maximumValue.toDouble()))

inline fun I54.coerceAtLeast(minimumValue: I54) = I54(value.coerceAtLeast(minimumValue.value))

inline fun I54.coerceAtMost(maximumValue: I54) = I54(value.coerceAtMost(maximumValue.value))

inline fun I54.coerceIn(minimumValue: I54, maximumValue: I54) =
    I54(value.coerceIn(minimumValue.value, maximumValue.value))

inline fun Iterable<I54>.sum(): I54 {
  var sum = I54(0.0)
  for (element in this) {
    sum += element
  }
  return sum
}

inline fun <T> Iterable<T>.sumOfI54(selector: (T) -> I54): I54 {
  var sum = I54(0.0)
  for (element in this) {
    sum += selector(element)
  }
  return sum
}
