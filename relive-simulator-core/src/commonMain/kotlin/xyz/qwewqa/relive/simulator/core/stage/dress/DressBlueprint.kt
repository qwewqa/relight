package xyz.qwewqa.relive.simulator.core.stage.dress

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData
import xyz.qwewqa.relive.simulator.core.stage.passive.UnitSkill
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

data class DressBlueprint(
    val id: Int,
    val name: String,
    val baseRarity: Int,
    val character: Character,
    val attribute: Attribute,
    val damageType: DamageType,
    val position: Position,
    val positionValue: Int,
    val stats: StatData,
    val growthStats: StatData,
    val acts: List<ActBlueprint>,
    val autoSkills: List<List<PassiveData>>,
    val autoSkillRanks: List<Int?>,
    val autoSkillPanels: List<Int>,
    val rankPanels: List<List<StatBoost>>,
    val friendshipPanels: List<StatBoost>,
    val remakeParameters: List<StatData>,
    val unitSkill: UnitSkill,
)

data class PartialDressBlueprint(
    val id: Int,
    val name: String,
    val baseRarity: Int,
    val character: Character,
    val attribute: Attribute,
    val damageType: DamageType,
    val position: Position,
    val positionValue: Int,
    val stats: StatData,
    val growthStats: StatData,
    val actParameters: Map<ActType, List<ActParameters>>,
    val autoSkillRanks: List<Int?>,
    val autoSkillPanels: List<Int>,
    val rankPanels: List<List<StatBoost>>,
    val friendshipPanels: List<StatBoost>,
    val remakeParameters: List<StatData>,
) {
    operator fun invoke(
        name: String,
        acts: List<ActBlueprint>,
        autoSkills: List<List<PassiveData>>,
        unitSkill: UnitSkill,
    ) = DressBlueprint(
        id,
        name,
        baseRarity,
        character,
        attribute,
        damageType,
        position,
        positionValue,
        stats,
        growthStats,
        acts.map { if (it.type in actParameters) it.copy(parameters = actParameters[it.type]!!) else it },
        autoSkills,
        autoSkillRanks,
        autoSkillPanels,
        rankPanels,
        friendshipPanels,
        remakeParameters,
        unitSkill,
    )
}

data class StatBoost(val type: StatBoostType, val value: Int)

enum class StatBoostType {
    None,
    Hp,
    ActPower,
    NormalDefense,
    SpecialDefense,
    Agility,
}

val rarityGrowths = listOf(
    0,
    0,
    0,
    10,
    25,
    50,
    75,
)

val rankGrowths = listOf(
    0,
    0,
    15,
    30,
    45,
    60,
    80,
    100,
    110,
    120,
)