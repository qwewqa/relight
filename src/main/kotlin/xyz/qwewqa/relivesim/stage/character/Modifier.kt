package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.*

interface Modifier<T, R> {
    var base: T
    var buff: Percent

    val value: R
}

data class AdditivePercentModifier(
    override var base: Percent = 0.percent,
    override var buff: Percent = 0.percent,
) : Modifier<Percent, Percent> {
    override val value get() = base + buff
}

data class MultiplicativeBuffModifier(
    override var base: Int = 0,
    override var buff: Percent = 0.percent,
) : Modifier<Int, Int> {
    override val value get() = (base * (100.percent + buff)).toInt()
}

