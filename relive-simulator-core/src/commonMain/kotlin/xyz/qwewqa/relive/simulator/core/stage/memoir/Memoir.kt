package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

data class Memoir(
    val name: String,
    val stats: StatData,
    val autoskills: List<PassiveData>,
)
