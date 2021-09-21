package xyz.qwewqa.relive.simulator.stage.memoir

import xyz.qwewqa.relive.simulator.stage.actor.StatData
import xyz.qwewqa.relive.simulator.stage.passive.PassiveData

data class Memoir(
    val name: String,
    val stats: StatData,
    val autoskills: List<PassiveData>,
)
