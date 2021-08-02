package xyz.qwewqa.relivesim.dsl

import xyz.qwewqa.relivesim.stage.character.StatData
import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.percent

@StageDslMarker
class StatsBuilder {
    var maxHp: Int = 0
    var actPower: Int = 0
    var normalDefense: Int = 0
    var specialDefense: Int = 0
    var agility: Int = 0
    var dexterity: Percent = 0.percent
    var critical: Percent = 0.percent
    var accuracy: Percent = 0.percent
    var evasion: Percent = 0.percent

    fun build() = StatData(
        maxHp,
        actPower,
        normalDefense,
        specialDefense,
        agility,
        dexterity,
        critical,
        accuracy,
        evasion,
    )
}

fun defaultCharacterStats(): StatsBuilder = StatsBuilder().apply {
    dexterity = 5.percent
    critical = 50.percent
    accuracy = 100.percent
}

fun stats(init: StatsBuilder.() -> Unit) = StatsBuilder().apply(init).build()
