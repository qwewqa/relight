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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010015(
    name = "月",
    acts = listOf(
        ActType.Act1.blueprint("月光のキラめき") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("月光の狂気") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [220, 240, 260, 280, 300]
                  times1: 1
                混乱
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("月光環") {
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
        ActType.ClimaxAct.blueprint("Rising Moon☆Rampage！") {
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
                  values2: [200, 210, 220, 230, 240]
                  times2: 3
                プラス効果耐性アップ(%value%) (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
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
            target: 敵役のアルカナ・アルカディアシリーズ
            hit_rate: 100
            value: 50
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          回避
            target: 味方のアルカナ・アルカディアシリーズ
            hit_rate: 100
            value: 0
            time: 5
        */
        ),
        listOf(
        /*
        auto skill 3:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方のアルカナ・アルカディアシリーズ
            hit_rate: 100
            value: 50
            time: 2
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3010015 = PartialDressBlueprint(
  id = 3010015,
  name = "月",
  baseRarity = 4,
  cost = 15,
  character = Character.Aruru,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 3117,
    actPower = 267,
    normalDefense = 137,
    specialDefense = 267,
    agility = 167,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 83000,
    actPower = 4550,
    normalDefense = 1800,
    specialDefense = 3350,
    agility = 4100,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "月光のキラめき",
      type = ActType.Act1,
      apCost = 1,
      icon = 89,
      parameters = listOf(
        actParameters0,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "月光の狂気",
      type = ActType.Act2,
      apCost = 3,
      icon = 59,
      parameters = listOf(
        actParameters318,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "月光環",
      type = ActType.Act3,
      apCost = 4,
      icon = 89,
      parameters = listOf(
        actParameters106,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Rising Moon☆Rampage！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 235,
      parameters = listOf(
        actParameters30,
        actParameters57,
        actParameters62,
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
      hp = 7800,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 750,
      agility = 240,
    ),
    StatData(
      hp = 13000,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 1250,
      agility = 400,
    ),
    StatData(
      hp = 20800,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 2000,
      agility = 640,
    ),
    StatData(
      hp = 26000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 2500,
      agility = 800,
    ),
  ),
)
