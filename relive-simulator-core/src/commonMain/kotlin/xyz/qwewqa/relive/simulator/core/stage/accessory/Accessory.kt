package xyz.qwewqa.relive.simulator.core.stage.accessory

import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData

data class Accessory(
    val id: Int,
    val iconId: Int,
    val name: String,
    val stats: StatData,
    val act: ActData? = null,
)
