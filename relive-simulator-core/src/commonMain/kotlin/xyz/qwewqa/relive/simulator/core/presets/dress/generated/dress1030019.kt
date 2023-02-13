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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030019(
    name = "真田幸村",
    acts = listOf(
        ActType.Act1.blueprint("強斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("先陣を切る刃") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [10, 12, 14, 17, 20]
                  times1: [3, 3, 3, 3, 3]
                クリティカル威力アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [129, 136, 141, 148, 155]
                  times3: 2
                */
            }
        },
        ActType.Act3.blueprint("颯爽たる刃") {
            Act {
                /*
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [10, 12, 14, 17, 20]
                  times1: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 2
                */
            }
        },
        ActType.ClimaxAct.blueprint("日ノ本一の槍") {
            Act {
                /*
                刻印
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                通常防御力ダウン(%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%) (ACTタイプ[特殊]の敵役に特攻)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [307, 323, 338, 353, 369]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          与ダメージアップ(%value%)
            target: 自身
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 2:
          クリティカル率アップ(%value%)
            target: 自身
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 3:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030019 = PartialDressBlueprint(
  id = 1030019,
  name = "真田幸村",
  baseRarity = 4,
  cost = 13,
  character = Character.Mahiru,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1101,
    actPower = 246,
    normalDefense = 138,
    specialDefense = 97,
    agility = 220,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 36290,
    actPower = 4060,
    normalDefense = 2280,
    specialDefense = 1600,
    agility = 3630,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters98,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "先陣を切る刃",
      type = ActType.Act2,
      apCost = 2,
      icon = 22,
      parameters = listOf(
        actParameters42,
        actParameters42,
        actParameters55,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "颯爽たる刃",
      type = ActType.Act3,
      apCost = 2,
      icon = 39,
      parameters = listOf(
        actParameters42,
        actParameters32,
        actParameters38,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "日ノ本一の槍",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 196,
      parameters = listOf(
        actParameters14,
        actParameters32,
        actParameters147,
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
      hp = 6600,
      actPower = 450,
      normalDefense = 300,
      specialDefense = 90,
      agility = 210,
    ),
    StatData(
      hp = 11000,
      actPower = 750,
      normalDefense = 500,
      specialDefense = 150,
      agility = 350,
    ),
    StatData(
      hp = 17600,
      actPower = 1200,
      normalDefense = 800,
      specialDefense = 240,
      agility = 560,
    ),
    StatData(
      hp = 22000,
      actPower = 1500,
      normalDefense = 1000,
      specialDefense = 300,
      agility = 700,
    ),
  ),
)
