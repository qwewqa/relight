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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2030015(
    name = "節制",
    acts = listOf(
        ActType.Act1.blueprint("調整") {
            Act {
                /*
                AP減少
                  target: 後ろから3体の味方
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("稚拙な運用") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 3
                刻印
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                通常防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("巧みな管理") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [54, 56, 59, 62, 64]
                  times3: 2
                */
            }
        },
        ActType.ClimaxAct.blueprint("幸福都市検察法第14条『強攻排除』") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [197, 205, 210, 215, 230]
                  times2: 4
                悪夢(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2222, 3333, 4444, 5555, 6666]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          睡眠
            target: 後ろから2体の敵役
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方の凛明館女学校
            values: [30, 30, 30, 30, 30]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2030015 = PartialDressBlueprint(
  id = 2030015,
  name = "節制",
  baseRarity = 4,
  cost = 15,
  character = Character.Fumi,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1877,
    actPower = 306,
    normalDefense = 92,
    specialDefense = 142,
    agility = 220,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 61830,
    actPower = 5050,
    normalDefense = 1520,
    specialDefense = 2340,
    agility = 3630,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "調整",
      type = ActType.Act1,
      apCost = 1,
      icon = 157,
      parameters = listOf(
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "稚拙な運用",
      type = ActType.Act2,
      apCost = 2,
      icon = 150,
      parameters = listOf(
        actParameters223,
        actParameters14,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "巧みな管理",
      type = ActType.Act3,
      apCost = 3,
      icon = 173,
      parameters = listOf(
        actParameters30,
        actParameters14,
        actParameters56,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "幸福都市検察法第14条『強攻排除』",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 234,
      parameters = listOf(
        actParameters30,
        actParameters288,
        actParameters48,
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
      hp = 5700,
      actPower = 480,
      normalDefense = 90,
      specialDefense = 450,
      agility = 270,
    ),
    StatData(
      hp = 9500,
      actPower = 800,
      normalDefense = 150,
      specialDefense = 750,
      agility = 450,
    ),
    StatData(
      hp = 15200,
      actPower = 1280,
      normalDefense = 240,
      specialDefense = 1200,
      agility = 720,
    ),
    StatData(
      hp = 19000,
      actPower = 1600,
      normalDefense = 300,
      specialDefense = 1500,
      agility = 900,
    ),
  ),
)
