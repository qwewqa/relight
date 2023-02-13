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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3020017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3020017(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("裏一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 通常防御力が1番低い敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 2
                */
            }
        },
        ActType.Act2.blueprint("電光石火") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 通常防御力が1番低い敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 2
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                回避
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
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
        ActType.ClimaxAct.blueprint("あの空目指してすすめフロンティア！") {
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
                  values2: [164, 172, 181, 189, 197]
                  times2: 5
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
            target: 敵役全体
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 50
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3020017 = PartialDressBlueprint(
  id = 3020017,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Misora,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 23050,
  stats = StatData(
    hp = 2448,
    actPower = 258,
    normalDefense = 191,
    specialDefense = 112,
    agility = 212,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 77000,
    actPower = 4550,
    normalDefense = 3000,
    specialDefense = 2000,
    agility = 3200,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "裏一閃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters103,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "電光石火",
      type = ActType.Act2,
      apCost = 2,
      icon = 20,
      parameters = listOf(
        actParameters55,
        actParameters32,
        actParameters25,
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
        actParameters106,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "あの空目指してすすめフロンティア！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 235,
      parameters = listOf(
        actParameters30,
        actParameters83,
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
      hp = 9000,
      actPower = 330,
      normalDefense = 900,
      specialDefense = 150,
      agility = 270,
    ),
    StatData(
      hp = 15000,
      actPower = 550,
      normalDefense = 1500,
      specialDefense = 250,
      agility = 450,
    ),
    StatData(
      hp = 24000,
      actPower = 880,
      normalDefense = 2400,
      specialDefense = 400,
      agility = 720,
    ),
    StatData(
      hp = 30000,
      actPower = 1100,
      normalDefense = 3000,
      specialDefense = 500,
      agility = 900,
    ),
  ),
)
