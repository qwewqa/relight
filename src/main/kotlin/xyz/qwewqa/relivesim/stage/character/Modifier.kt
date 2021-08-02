package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.percent
import xyz.qwewqa.relivesim.stage.times

interface Modifier<T> {
    fun get(): T
}

data class SimpleModifier<T>(var value: T) : Modifier<T> {
    override fun get() = value
}

data class ValueBuffModifier(var value: Int = 0, var buff: Percent = 0.percent) : Modifier<Double> {
    override fun get() = (value * (100.percent + buff)).coerceAtLeast(0.0)
}

