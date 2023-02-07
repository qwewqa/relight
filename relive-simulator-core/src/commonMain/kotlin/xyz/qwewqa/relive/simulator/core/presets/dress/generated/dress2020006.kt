package xyz.qwewqa.relive.simulator.core.presets.dress.generated

import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.StatData
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.PartialDressBlueprint
import xyz.qwewqa.relive.simulator.core.stage.dress.StatBoost
import xyz.qwewqa.relive.simulator.core.stage.dress.StatBoostType
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

/*
import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2020006(
    name = "竜宮の踊り子",
    acts = listOf(
        ActType.Act1.blueprint("一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("キラめきの一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("奮起の独奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: HP割合が1番低い敵役
                  hit_rate1: 100
                  values1: [132, 138, 145, 151, 158]
                  times1: 1
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [13, 14, 16, 17, 19]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("竜宮オールスターズ☆") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [328, 345, 361, 378, 394]
                  times1: 3
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ストップ耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [6, 6, 7, 8, 9]
        */
        ),
        listOf(
        /*
        auto skill 3:
          吸収(%value%) (吸収量は与ダメージに依存する)
            target: 自身
            values: [5, 5, 5, 5, 5]
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2020006 = PartialDressBlueprint(
  id = 2020006,
  name = "竜宮の踊り子",
  baseRarity = 4,
  cost = 12,
  character = Character.Ichie,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 39999,
  stats = StatData(
    hp = 816,
    actPower = 186,
    normalDefense = 62,
    specialDefense = 62,
    agility = 176,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 26880,
    actPower = 3060,
    normalDefense = 1020,
    specialDefense = 1020,
    agility = 2900,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一閃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの一閃",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters2,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "奮起の独奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters7,
        actParameters8,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "竜宮オールスターズ☆",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters276,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 7500,
      actPower = 390,
      normalDefense = 120,
      specialDefense = 390,
      agility = 210,
    ),
    StatData(
      hp = 12500,
      actPower = 650,
      normalDefense = 200,
      specialDefense = 650,
      agility = 350,
    ),
    StatData(
      hp = 20000,
      actPower = 1040,
      normalDefense = 320,
      specialDefense = 1040,
      agility = 560,
    ),
    StatData(
      hp = 25000,
      actPower = 1300,
      normalDefense = 400,
      specialDefense = 1300,
      agility = 700,
    ),
  ),
)
