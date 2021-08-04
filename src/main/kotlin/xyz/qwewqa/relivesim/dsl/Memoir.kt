package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.character.MemoirData
import xyz.qwewqa.relivesim.stage.character.StatData
import xyz.qwewqa.relivesim.stage.effect.AutoEffect

@StageDslMarker
class MemoirBuilder {
    var name = "Unnamed"
    var stats = StatData()
    var autoEffects = mutableListOf<AutoEffect>()

    inline fun stats(init: StatsBuilder.() -> Unit) {
        stats = StatsBuilder().apply(init).build()
    }

    operator fun AutoEffect.unaryPlus() {
        autoEffects.add(this)
    }

    fun build() = MemoirData(name, stats, autoEffects)
}

inline fun memoir(init: MemoirBuilder.() -> Unit) = MemoirBuilder().apply(init).build()

fun MemoirData.withStats(stats: StatData) = copy(stats = stats)
fun MemoirData.withStats(init: StatsBuilder.() -> Unit) = copy(stats = stats(init))

