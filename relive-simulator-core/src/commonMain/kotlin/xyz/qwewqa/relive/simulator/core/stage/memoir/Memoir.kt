package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

data class Memoir(
    val name: String,
    val stats: StatData,
    val autoskills: List<PassiveData>,
    val cutinData: CutinData? = null,
)

data class CutinData(
    val cooldownStart: Int,
    val cooldown: Int,
    val usageLimit: Int,
    val target: CutinTarget,
    val act: Act,
)

sealed class CutinTarget {
    object TurnStart : CutinTarget()
    data class BeforeAllyAct(val index: Int) : CutinTarget()
    data class BeforeEnemyAct(val index: Int) : CutinTarget()
}
