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

data class MemoirBlueprint(
    val name: String,
    val rarity: Int,
    val baseStats: StatData,
    val growthStats: StatData,
    val autoskills: List<List<PassiveData>>,
    val cutinData: List<CutinData?> = listOf(null, null, null, null, null),
) {
    constructor(
        name: String,
        rarity: Int,
        baseStats: StatData,
        growthStats: StatData,
        baseAutoskills: List<PassiveData>,
        maxAutoskills: List<PassiveData>,
        cutinData: List<CutinData?> = listOf(null, null, null, null, null),
    ) : this(name, rarity, baseStats, growthStats, List(4) { baseAutoskills } + listOf(maxAutoskills), cutinData)

    fun maxLevel(limitBreak: Int) = (rarity + 2) * 10 + limitBreak * 5

    fun create(level: Int, limitBreak: Int): Memoir {
        require(level in 1..maxLevel(limitBreak)) { "Invalid level $level for rarity $rarity at limit break $limitBreak." }
        return Memoir(
            name,
            baseStats + growthStats * (level - 1) / 1000,
            autoskills[limitBreak],
            if (limitBreak > 0) cutinData[limitBreak] else null,
        )
    }
}

data class CutinData(
    val cost: Int,
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
