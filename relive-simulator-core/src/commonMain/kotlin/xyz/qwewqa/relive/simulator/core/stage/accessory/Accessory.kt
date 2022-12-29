package xyz.qwewqa.relive.simulator.core.stage.accessory

import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

data class Accessory(
    val id: Int,
    val iconId: Int,
    val name: String,
    val stats: StatData,
    val autoskills: List<PassiveData>,
    val act: ActData? = null,
)
