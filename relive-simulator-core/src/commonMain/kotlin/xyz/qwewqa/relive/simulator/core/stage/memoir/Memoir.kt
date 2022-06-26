package xyz.qwewqa.relive.simulator.core.stage.memoir

import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActData
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprintContext
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData
import xyz.qwewqa.relive.simulator.core.stage.passive.UnitSkill

data class Memoir(
    val id: Int,
    val name: String,
    val stats: StatData,
    val autoskills: List<PassiveData>,
    val cutinData: CutinData? = null,
)

data class MemoirBlueprint(
    val id: Int,
    val name: String,
    val rarity: Int,
    val baseStats: StatData,
    val growthStats: StatData,
    val autoskills: List<List<PassiveData>>,
    val cutinData: CutinBlueprint? = null,
    val additionalTags: List<EffectTag> = emptyList(),
) {
    constructor(
        id: Int,
        name: String,
        rarity: Int,
        baseStats: StatData,
        growthStats: StatData,
        baseAutoskills: List<PassiveData>,
        maxAutoskills: List<PassiveData>,
        cutinData: CutinBlueprint? = null,
        additionalTags: List<EffectTag> = emptyList(),
    ) : this(id,
        name,
        rarity,
        baseStats,
        growthStats,
        List(4) { baseAutoskills } + listOf(maxAutoskills),
        cutinData,
        additionalTags)

    val tags: List<EffectTag> = mutableSetOf<EffectTag>().apply {
        autoskills.last().forEach { passive ->
            addAll(passive.effect.tags)
        }
        if (cutinData != null) {
            add(EffectTag.Cutin)
        }
        addAll(additionalTags)
    }.sortedBy { it.ordinal }

    fun maxLevel(limitBreak: Int) = (rarity + 2) * 10 + limitBreak * 5

    fun create(level: Int, limitBreak: Int): Memoir {
        require(level in 1..maxLevel(limitBreak)) { "Invalid level $level for rarity $rarity at limit break $limitBreak." }
        return Memoir(
            id,
            name,
            baseStats + growthStats * (level - 1) / 1000,
            autoskills[limitBreak],
            cutinData?.create(limitBreak),
        )
    }
}

data class PartialMemoirBlueprint(
    val id: Int,
    val name: String,
    val rarity: Int,
    val baseStats: StatData,
    val growthStats: StatData,
    val cutinData: CutinBlueprint? = null,
    val additionalTags: List<EffectTag> = emptyList(),
) {
    operator fun invoke(
        name: String,
        baseAutoskills: List<PassiveData>,
        maxAutoskills: List<PassiveData>,
        cutinTarget: CutinTarget = CutinTarget.TurnStart,
        cutinAct: ActBlueprintContext.() -> Act = { Act {} },
        additionalTags: List<EffectTag> = emptyList(),
    ) = MemoirBlueprint(
        id,
        name,
        rarity,
        baseStats,
        growthStats,
        baseAutoskills,
        maxAutoskills,
        cutinData?.copy(act = cutinAct, target = cutinTarget),
        this.additionalTags + additionalTags,
    )
}

data class CutinBlueprint(
    val costs: List<Int>,
    val startCooldowns: List<Int>,
    val cooldowns: List<Int>,
    val usageLimits: List<Int>,
    val parameters: List<ActParameters>,
    val target: CutinTarget = CutinTarget.TurnStart,
    val act: ActBlueprintContext.() -> Act = { Act {} },
) {
    fun create(limitBreak: Int): CutinData? = if (limitBreak > 0) {
        CutinData(
            costs[limitBreak],
            startCooldowns[limitBreak],
            cooldowns[limitBreak],
            usageLimits[limitBreak],
            target,
            act(
                ActBlueprintContext(
                    limitBreak + 1,
                    parameters.map { if (limitBreak < it.values.size) it.values[limitBreak] else 0 },
                    parameters.map { if (limitBreak < it.times.size) it.times[limitBreak] else 0 },
                    parameters.map { it.hitRate }
                ),
            ),
        )
    } else {
        null
    }
}

data class CutinData(
    val cost: Int,
    val startCooldown: Int,
    val cooldown: Int,
    val usageLimit: Int,
    val target: CutinTarget,
    val act: Act,
)

sealed class CutinTarget {
    object TurnStart : CutinTarget()
    object TurnEnd : CutinTarget()
    data class BeforeAllyAct(val index: Int) : CutinTarget()
    data class BeforeEnemyAct(val index: Int) : CutinTarget()
}
