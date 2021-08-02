package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.*

interface Modifier<T, R> {
    var value: T
    var buff: Percent

    fun get(): R
}

data class AdditivePercentModifier(
    override var value: Percent = 0.percent,
    override var buff: Percent = 0.percent,
) : Modifier<Percent, Percent> {
    override fun get() = value + buff
}

data class MultiplicativeBuffModifier(
    override var value: Int = 0,
    override var buff: Percent = 0.percent,
) : Modifier<Int, Double> {
    override fun get() = value * (100.percent + buff)
}

