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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070009(
    name = "クリスマスのお七",
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
        ActType.Act2.blueprint("キラめきの斬撃") {
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
        ActType.Act3.blueprint("勝利の歌") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("大バナナ号、発進！") {
            Act {
                /*
                必中
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [117, 123, 128, 134, 140]
                  times2: 3
                スタン
                  target: 敵役全体
                  hit_rate3: 33
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
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
            values: [5, 6, 6, 7, 8]
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
          クライマックスACT威力アップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1070009 = PartialDressBlueprint(
  id = 1070009,
  name = "クリスマスのお七",
  baseRarity = 4,
  cost = 12,
  character = Character.Nana,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 32050,
  stats = StatData(
    hp = 996,
    actPower = 172,
    normalDefense = 67,
    specialDefense = 85,
    agility = 182,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 32830,
    actPower = 2840,
    normalDefense = 1110,
    specialDefense = 1410,
    agility = 3000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "斬撃",
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
      name = "キラめきの斬撃",
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
      name = "勝利の歌",
      type = ActType.Act3,
      apCost = 3,
      icon = 20,
      parameters = listOf(
        actParameters137,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "大バナナ号、発進！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 35,
      parameters = listOf(
        actParameters14,
        actParameters31,
        actParameters96,
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
      actPower = 390,
      normalDefense = 90,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 11000,
      actPower = 650,
      normalDefense = 150,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 17600,
      actPower = 1040,
      normalDefense = 240,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 22000,
      actPower = 1300,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
