package xyz.qwewqa.relive.simulator.core.stage.accessory

import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkill

data class Accessory(
    val id: Int,
    val iconId: Int,
    val name: String,
    val stats: StatData,
    val autoskills: List<AutoSkill>,
    val act: ActData? = null,
)
