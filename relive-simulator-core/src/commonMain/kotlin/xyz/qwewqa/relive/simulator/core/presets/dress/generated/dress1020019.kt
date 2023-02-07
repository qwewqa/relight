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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020019(
    name = "真宮寺さくら",
    acts = listOf(
        ActType.Act1.blueprint("浄化の刃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("減光の瞬き") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 2
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                キラめき獲得ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [60, 65, 70, 75, 80]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("大空への跳躍") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 後ろから5体の味方
                  hit_rate1: 100
                  values1: [20, 30, 40, 50, 60]
                  times1: [0, 0, 0, 0, 0]
                AP減少
                  target: 後ろから5体の味方
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("想い出の桜花") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [200, 210, 220, 230, 240]
                  times1: [1, 1, 1, 1, 1]
                錯乱
                  target: 立ち位置後の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
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
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
        */
        ),
        listOf(
        /*
        auto skill 3:
          すばやさアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
    ),
    unitSkill = null /* 風・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1020019 = PartialDressBlueprint(
  id = 1020019,
  name = "真宮寺さくら",
  baseRarity = 4,
  cost = 15,
  character = Character.Hikari,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 2425,
    actPower = 297,
    normalDefense = 120,
    specialDefense = 180,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 79880,
    actPower = 4900,
    normalDefense = 1980,
    specialDefense = 2970,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "浄化の刃",
      type = ActType.Act1,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters38,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "減光の瞬き",
      type = ActType.Act2,
      apCost = 2,
      icon = 192,
      parameters = listOf(
        actParameters56,
        actParameters14,
        actParameters103,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "大空への跳躍",
      type = ActType.Act3,
      apCost = 4,
      icon = 89,
      parameters = listOf(
        actParameters104,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "想い出の桜花",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 236,
      parameters = listOf(
        actParameters105,
        actParameters25,
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
      hp = 3000,
      actPower = 510,
      normalDefense = 90,
      specialDefense = 300,
      agility = 300,
    ),
    StatData(
      hp = 5000,
      actPower = 850,
      normalDefense = 150,
      specialDefense = 500,
      agility = 500,
    ),
    StatData(
      hp = 8000,
      actPower = 1360,
      normalDefense = 240,
      specialDefense = 800,
      agility = 800,
    ),
    StatData(
      hp = 10000,
      actPower = 1700,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 1000,
    ),
  ),
)
