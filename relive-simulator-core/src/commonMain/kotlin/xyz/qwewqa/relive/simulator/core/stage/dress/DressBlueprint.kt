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
) {
    fun create(
        rarity: Int,
        level: Int,
        friendship: Int,
        rank: Int,
        rankPanelPattern: List<Boolean>,
        remake: Int,
        unitSkillLevel: Int,
    ): Dress {
        require(rarity in baseRarity..6) { "Invalid rarity $rarity." }
        require(rank in 1..9) { "Invalid rank $rank." }
        require(remake in 0..remakeParameters.size) { "Invalid remake level $remake." }
        require(level in 1..(20 + 10 * rarity + 5 * remake)) { "Invalid level $level." }
        require(friendship in 1..(rarity * 5 + remake * 5)) { "Invalid friendship level $friendship" }
        require(rankPanelPattern.size == 8) { "Invalid rank panel pattern." }
        val maxRankLevelStats = (stats + growthStats * (80 + 5 * remake - 1) / 1000) *
                (100 + rankGrowths[9] + rarityGrowths[6]) / 100
        val panels = friendshipPanels.take(friendship) + // intentionally not friendship - 1
                rankPanels.take(rank - 1).flatten() +
                rankPanels[rank - 1].filterIndexed { i, _ -> rankPanelPattern[i] }
        var panelHp = 0
        var panelActPower = 0
        var panelNormalDefense = 0
        var panelSpecialDefense = 0
        var panelAgility = 0
        var act1Level = 1
        var act2Level = 1
        var act3Level = 1
        var climaxActLevel = 1
        panels.forEach { (type, value) ->
            when (type) {
                StatBoostType.None -> Unit
                StatBoostType.Hp -> panelHp += maxRankLevelStats.hp * value / 100
                StatBoostType.ActPower -> panelActPower += maxRankLevelStats.actPower * value / 100
                StatBoostType.NormalDefense -> panelNormalDefense += maxRankLevelStats.normalDefense * value / 100
                StatBoostType.SpecialDefense -> panelSpecialDefense += maxRankLevelStats.specialDefense * value / 100
                StatBoostType.Agility -> panelAgility += maxRankLevelStats.agility * value / 100
                StatBoostType.Act1Level -> act1Level++
                StatBoostType.Act2Level -> act2Level++
                StatBoostType.Act3Level -> act3Level++
                StatBoostType.ClimaxActLevel -> climaxActLevel++
            }
        }
        val autoSkillCount = autoSkillRanks.zip(autoSkillPanels).count { (rankNumber, panelNumber) ->
            rankNumber != null &&
                    (rankNumber < rank ||
                            (rankNumber == rank && (panelNumber == 0 || rankPanelPattern[panelNumber - 1])))
        }
        val levelStats = (stats + growthStats * (level - 1) / 1000)
        val rankLevelStats = levelStats.fixedPart() +
                levelStats.growthPart() * (100 + rankGrowths[rank] + rarityGrowths[rarity]) / 100
        val panelStats = StatData(
            hp = panelHp,
            actPower = panelActPower,
            normalDefense = panelNormalDefense,
            specialDefense = panelSpecialDefense,
            agility = panelAgility,
        )
        val remakeStats = if (remake > 0) remakeParameters[remake - 1] else StatData()
        return Dress(
            id,
            name,
            character,
            attribute,
            damageType,
            position,
            positionValue,
            rankLevelStats + panelStats + remakeStats,
            acts.associate {
                it.type to it.create(
                    when (it.type) {
                        ActType.Act1 -> act1Level
                        ActType.Act2 -> act2Level
                        ActType.Act3 -> act3Level
                        ActType.ClimaxAct -> climaxActLevel
                        else -> error("Unsupported dress act type.")
                    }
                )
            },
            autoSkills.take(autoSkillCount).flatten(),
            unitSkill.forLevel(unitSkillLevel),
            this,
        )
    }
}

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
    Act1Level,
    Act2Level,
    Act3Level,
    ClimaxActLevel,
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