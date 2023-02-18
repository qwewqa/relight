package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

private var nextId = 0
private val modifiers = mutableListOf<Modifier>()

class Modifier private constructor(val name: String, val id: Int, val default: Int) {
    companion object {
        fun new(name: String, default: Int = 0) = Modifier(name, nextId++, default).also {
            modifiers += it
        }
    }

    override fun toString() = "Modifier($name, $id, $default)"
}

fun modifier(name: String, default: Int = 0) = Modifier.new(name, default)

// actor is included so that it may be accessed from extension methods,
// since context receivers are not stable yet.
@Suppress("NOTHING_TO_INLINE")
abstract class Modifiers(val actor: Actor) {
    abstract operator fun get(modifier: Modifier): Int
    abstract operator fun set(modifier: Modifier, value: Int)

    inline operator fun Modifier.invoke() = get(this)
    inline operator fun Modifier.invoke(value: Int) { set(this, value) }
    inline operator fun Modifier.invoke(value: Modifier) { set(this, get(value)) }
    inline operator fun Int.invoke() = this
    inline operator fun Modifier.unaryPlus() = get(this)
    inline operator fun Modifier.unaryMinus() = -get(this)

    inline infix fun Modifier.setTo(value: Int) { set(this, value) }
    inline infix fun Modifier.setTo(value: Modifier) { set(this, get(value)) }

    inline operator fun Modifier.plus(other: Int) = get(this) + other
    inline operator fun Modifier.minus(other: Int) = get(this) - other
    inline operator fun Modifier.times(other: Int) = get(this) * other
    inline operator fun Modifier.div(other: Int) = get(this) / other
    inline operator fun Modifier.rem(other: Int) = get(this) % other
    inline operator fun Modifier.rangeTo(other: Int) = get(this)..other
    inline operator fun Modifier.compareTo(other: Int) = get(this).compareTo(other)

    inline operator fun Modifier.plus(other: Modifier) = get(this) + get(other)
    inline operator fun Modifier.minus(other: Modifier) = get(this) - get(other)
    inline operator fun Modifier.times(other: Modifier) = get(this) * get(other)
    inline operator fun Modifier.div(other: Modifier) = get(this) / get(other)
    inline operator fun Modifier.rem(other: Modifier) = get(this) % get(other)
    inline operator fun Modifier.rangeTo(other: Modifier) = get(this)..get(other)
    inline operator fun Modifier.compareTo(other: Modifier) = get(this).compareTo(get(other))

    inline operator fun Int.plus(other: Modifier) = this + get(other)
    inline operator fun Int.minus(other: Modifier) = this - get(other)
    inline operator fun Int.times(other: Modifier) = this * get(other)
    inline operator fun Int.div(other: Modifier) = this / get(other)
    inline operator fun Int.rem(other: Modifier) = this % get(other)
    inline operator fun Int.rangeTo(other: Modifier) = this..get(other)
    inline operator fun Int.compareTo(other: Modifier) = this.compareTo(get(other))

    inline operator fun Modifier.plusAssign(other: Int) { set(this, get(this) + other) }
    inline operator fun Modifier.minusAssign(other: Int) { set(this, get(this) - other) }
    inline operator fun Modifier.timesAssign(other: Int) { set(this, get(this) * other) }
    inline operator fun Modifier.divAssign(other: Int) { set(this, get(this) / other) }
    inline operator fun Modifier.remAssign(other: Int) { set(this, get(this) % other) }

    inline operator fun Modifier.plusAssign(other: Modifier) { set(this, get(this) + get(other)) }
    inline operator fun Modifier.minusAssign(other: Modifier) { set(this, get(this) - get(other)) }
    inline operator fun Modifier.timesAssign(other: Modifier) { set(this, get(this) * get(other)) }
    inline operator fun Modifier.divAssign(other: Modifier) { set(this, get(this) / get(other)) }
    inline operator fun Modifier.remAssign(other: Modifier) { set(this, get(this) % get(other)) }

    inline infix fun Modifier.pfmul(other: Int) = (get(this).toDouble() * other / 100).toInt()
    inline infix fun Int.pfmul(other: Modifier) = (this.toDouble() * get(other) / 100).toInt()
    inline infix fun Modifier.pfmul(other: Modifier) = (get(this).toDouble() * get(other) / 100).toInt()
    inline infix fun Int.pfmul(other: Int) = (this.toDouble() * other / 100).toInt()

    inline infix fun Modifier.pfmod(other: Int) = this pfmul (100 + other)
    inline infix fun Int.pfmod(other: Modifier) = this pfmul (100 + get(other))
    inline infix fun Modifier.pfmod(other: Modifier) = this pfmul (100 + get(other))
    inline infix fun Int.pfmod(other: Int) = this pfmul (100 + other)

    inline infix fun Modifier.given(condition: () -> Boolean) = if (condition()) get(this) else 0
    inline infix fun Int.given(condition: () -> Boolean) = if (condition()) this else 0
    inline infix fun Modifier.given(condition: Boolean) = if (condition) get(this) else 0
    inline infix fun Int.given(condition: Boolean) = if (condition) this else 0

    inline operator fun <T> invoke(block: Modifiers.() -> T) = block()
}

expect class ModifiersImpl(actor: Actor) : Modifiers {
    override operator fun get(modifier: Modifier): Int
    override operator fun set(modifier: Modifier, value: Int)
}

fun _Modifiers(actor: Actor) = ModifiersImpl(actor)

fun Modifiers.getValues() = modifiers.map { it to get(it) }
