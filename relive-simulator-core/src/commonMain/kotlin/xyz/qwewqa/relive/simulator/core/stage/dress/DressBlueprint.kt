package xyz.qwewqa.relive.simulator.core.stage.dress

import xyz.qwewqa.relive.simulator.core.gen.getLocalizedString
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.FeatureImplementation
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.Character
import xyz.qwewqa.relive.simulator.core.stage.actor.DamageType
import xyz.qwewqa.relive.simulator.core.stage.actor.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.autoskill.AutoSkill
import xyz.qwewqa.relive.simulator.core.stage.autoskill.RemakeSkill
import xyz.qwewqa.relive.simulator.core.stage.autoskill.UnitSkillBlueprint
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf

data class DressBlueprint(
    override val id: Int,
    val name: String,
    val names: Map<String, String>? = null,
    val baseRarity: Int,
    val cost: Int,
    val character: Character,
    val attribute: Attribute,
    val damageType: DamageType,
    val position: Position,
    val positionValue: Int,
    val stats: StatData,
    val growthStats: StatData,
    val acts: List<ActBlueprint>,
    val autoSkills: List<List<AutoSkill>>,
    val autoSkillRanks: List<Int?>,
    val autoSkillPanels: List<Int>,
    val rankPanels: List<List<StatBoost>>,
    val friendshipPanels: List<StatBoost>,
    val remakeParameters: List<StatData>,
    val unitSkill: UnitSkillBlueprint,
    val multipleCA: Boolean,
    val releaseTime: Int? = null,
) : FeatureImplementation {
  val fullName
    get() = "$name ${character.displayName}"
  val fullNames
    get() =
        names?.mapValues { (lang, name) -> "$name ${character.names.getLocalizedString(lang) }" }
            ?: mapOf("en" to fullName)

  fun create(
      rarity: Int,
      level: Int,
      friendship: Int,
      rank: Int,
      rankPanelPattern: List<Boolean>,
      remake: Int,
      unitSkillLevel: Int,
      remakeSkill: RemakeSkill?,
  ): Dress {
    require(rarity in baseRarity..6) { "Invalid rarity $rarity." }
    require(rank in 1..9) { "Invalid rank $rank." }
    require(remake in 0..remakeParameters.size) { "Invalid remake level $remake." }
    require(level in 1..(20 + 10 * rarity + 5 * remake)) { "Invalid level $level." }
    require(friendship in 1..(rarity * 5 + remake * 5)) { "Invalid friendship level $friendship" }
    require(rankPanelPattern.size == 8) { "Invalid rank panel pattern." }
    val maxRankLevelStats =
        (stats + growthStats * (80 + 5 * remake - 1) / 1000) *
            (100 + rankGrowths[9] + rarityGrowths[6]) / 100
    val panels =
        friendshipPanels.take(friendship) + // intentionally not friendship - 1
        rankPanels.take(rank - 1).flatten() +
            rankPanels[rank - 1].filterIndexed { i, _ -> rankPanelPattern[i] }
    var panelHp = 0.i54
    var panelActPower = 0.i54
    var panelNormalDefense = 0.i54
    var panelSpecialDefense = 0.i54
    var panelAgility = 0.i54
    var act1Level = 1
    var act2Level = 1
    var act3Level = 1
    var climaxActLevel = 1
    panels.forEach { (type, value) ->
      when (type) {
        StatBoostType.None -> Unit
        StatBoostType.Hp -> panelHp += maxRankLevelStats.hp * value / 100
        StatBoostType.ActPower -> panelActPower += maxRankLevelStats.actPower * value / 100
        StatBoostType.NormalDefense ->
            panelNormalDefense += maxRankLevelStats.normalDefense * value / 100
        StatBoostType.SpecialDefense ->
            panelSpecialDefense += maxRankLevelStats.specialDefense * value / 100
        StatBoostType.Agility -> panelAgility += maxRankLevelStats.agility * value / 100
        StatBoostType.Act1Level -> act1Level++
        StatBoostType.Act2Level -> act2Level++
        StatBoostType.Act3Level -> act3Level++
        StatBoostType.ClimaxActLevel -> climaxActLevel++
      }
    }
    val autoSkillCount =
        autoSkillRanks.zip(autoSkillPanels).count { (rankNumber, panelNumber) ->
          rankNumber != null &&
              (rankNumber < rank ||
                  (rankNumber == rank && (panelNumber == 0 || rankPanelPattern[panelNumber - 1])))
        }
    val levelStats = (stats + growthStats * (level - 1) / 1000)
    val rankLevelStats =
        levelStats.fixedPart() +
            levelStats.growthPart() * (100 + rankGrowths[rank] + rarityGrowths[rarity]) / 100
    val panelStats =
        StatData(
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
          it.type to
              it.create(
                  when (it.type) {
                    ActType.Act1 -> act1Level
                    ActType.Act2 -> act2Level
                    ActType.Act3 -> act3Level
                    ActType.ClimaxAct -> climaxActLevel
                    else -> error("Unsupported dress act type.")
                  })
        },
        autoSkills.take(autoSkillCount).flatten() +
            (remakeSkill?.data?.takeIf { remake >= 4 } ?: emptyList()),
        unitSkill.create(unitSkillLevel).skills,
        multipleCA,
        this,
    )
  }
}

object DressCategory {
  val Arcana =
      platformSetOf(
          1030006,
          1020004,
          4030003,
          1060015,
          1080004,
          2040004,
          2050010,
          1010014,
          4040015,
          4020004,
          1040005,
          1070004,
          2020003,
          3020015,
          1090013,
          2010015,
          4050015,
          3040005,
          1050007,
          2030015,
          3050008,
          3030015,
          4010015,
          3010015,
      )

  val TroupeRevueShop =
      platformSetOf(
          1020004,
          2040004,
          3020015,
          4010015,
          4010019,
      )

  val StageGirl =
      platformSetOf(
          1010017,
          1020017,
          1030017,
          1040017,
          1050017,
          1060017,
          1070017,
          1080017,
          1090017,
          2010017,
          2020017,
          2030017,
          2040017,
          2050017,
          3010017,
          3020017,
          3030017,
          3040017,
          3050017,
          4010017,
          4020017,
          4030017,
          4040017,
          4050017,
          5010001,
          5020001,
          5030001,
      )

  val Birthday2022 =
      platformSetOf(
          1010023,
          1020023,
          1030023,
          1040023,
          1050023,
          1060023,
          1070023,
          1080023,
          1090023,
          2010018,
          2020018,
          2030018,
          2040018,
          2050018,
          3010018,
          3020018,
          3030018,
          3040018,
          3050018,
          4010018,
          4020018,
          4030018,
          4040018,
          4050018,
          5010005,
          5020005,
          5030005,
      )

  val Birthday2023 =
      platformSetOf(
          1020026,
          3040014,
          2030020,
          4020020,
          1090026,
          5010008,
          2020019,
          3030020,
          1080025,
          1030028,
          4070004,
          3010022,
          2050024,
          4040021,
          4090004,
          4080004,
          1070028,
          1050028,
          1040028,
          3050022,
          5020009,
          4030021,
      )

  val Movie =
      platformSetOf(
          1010024,
          1020024,
          1030024,
          1040024,
          1050024,
          1060024,
          1070024,
          1080024,
          1090024,
      )

  val RoV =
      platformSetOf(
          1040021,
          1040020,
          1050019,
          5010006,
      )

  val Sweets =
      platformSetOf(
          1090019,
          1010022,
          1070021,
          1050020,
      )

  val MilkyHolmes =
      platformSetOf(
          1020022,
          3050016,
          3010021,
          1010026,
      )

  val StageGirlsCollection =
      platformSetOf(
          1080016,
          1090020,
          2050012,
          4050019,
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

val rarityGrowths =
    listOf(
        0,
        0,
        0,
        10,
        25,
        50,
        75,
    )

val rankGrowths =
    listOf(
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
