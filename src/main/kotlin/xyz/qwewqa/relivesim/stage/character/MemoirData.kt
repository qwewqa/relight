package xyz.qwewqa.relivesim.stage.character

import xyz.qwewqa.relivesim.stage.effect.AutoEffect

data class MemoirData(
    val name: String = "",
    val stats: StatData,
    val autoEffects: List<AutoEffect>,
)
