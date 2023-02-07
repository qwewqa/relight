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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040009(
    name = "ツクヨミ",
    acts = listOf(
        ActType.Act1.blueprint("斬撃") {
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
        ActType.Act2.blueprint("月影") {
            Act {
                /*
                吸収(%value%) (吸収量は与ダメージに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [20, 23, 26, 29, 33]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("闇ヲ呑ム月") {
            Act {
                /*
                吸収(%value%) (吸収量は与ダメージに依存する)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 23, 26, 29, 33]
                  times1: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [15, 16, 17, 18, 20]
                  times3: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("夜之食国") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
                猛毒(%value%) (ダメージ量は対象の最大HPに依存する)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [6, 8, 10, 12, 15]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          被ダメージダウン(%value%)
            target: 自身
            values: [4, 4, 5, 5, 6]
        */
        ),
        listOf(
        /*
        auto skill 2:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1040009 = PartialDressBlueprint(
  id = 1040009,
  name = "ツクヨミ",
  baseRarity = 4,
  cost = 12,
  character = Character.Claudine,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1011,
    actPower = 179,
    normalDefense = 51,
    specialDefense = 85,
    agility = 179,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 33320,
    actPower = 2960,
    normalDefense = 850,
    specialDefense = 1400,
    agility = 2950,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "斬撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "月影",
      type = ActType.Act2,
      apCost = 2,
      icon = 44,
      parameters = listOf(
        actParameters162,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "闇ヲ呑ム月",
      type = ActType.Act3,
      apCost = 4,
      icon = 44,
      parameters = listOf(
        actParameters121,
        actParameters44,
        actParameters34,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "夜之食国",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 54,
      parameters = listOf(
        actParameters83,
        actParameters163,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6300,
      actPower = 390,
      normalDefense = 150,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 10500,
      actPower = 650,
      normalDefense = 250,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 16800,
      actPower = 1040,
      normalDefense = 400,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 21000,
      actPower = 1300,
      normalDefense = 500,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
