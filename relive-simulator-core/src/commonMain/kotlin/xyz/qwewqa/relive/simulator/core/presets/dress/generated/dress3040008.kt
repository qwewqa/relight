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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3040008
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3040008(
    name = "ランプの魔神",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの一閃") {
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
        ActType.Act2.blueprint("魔神の災い") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                毒(%value%)
                  target: 前から3体の敵役
                  hit_rate2: 100
                  values2: [60, 100, 180, 300, 500]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("惑わしの一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 2
                混乱
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ランプの魔法") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
                毒(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [60, 100, 180, 300, 500]
                  times2: [2, 2, 2, 2, 2]
                混乱
                  target: 敵役全体
                  hit_rate3: 100
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
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
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
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3040008 = PartialDressBlueprint(
  id = 3040008,
  name = "ランプの魔神",
  baseRarity = 4,
  cost = 12,
  character = Character.Tsukasa,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 1061,
    actPower = 173,
    normalDefense = 60,
    specialDefense = 91,
    agility = 177,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 34940,
    actPower = 2850,
    normalDefense = 1000,
    specialDefense = 1500,
    agility = 2930,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの一閃",
      type = ActType.Act1,
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
    ActType.Act2 to ActBlueprint(
      name = "魔神の災い",
      type = ActType.Act2,
      apCost = 3,
      icon = 54,
      parameters = listOf(
        actParameters46,
        actParameters341,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "惑わしの一撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 59,
      parameters = listOf(
        actParameters55,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ランプの魔法",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 54,
      parameters = listOf(
        actParameters83,
        actParameters341,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9300,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 390,
      agility = 180,
    ),
    StatData(
      hp = 15500,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 650,
      agility = 300,
    ),
    StatData(
      hp = 24800,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 1040,
      agility = 480,
    ),
    StatData(
      hp = 31000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 1300,
      agility = 600,
    ),
  ),
)
