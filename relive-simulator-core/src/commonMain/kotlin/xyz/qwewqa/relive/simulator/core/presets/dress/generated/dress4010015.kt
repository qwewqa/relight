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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4010015(
    name = "皇帝",
    acts = listOf(
        ActType.Act1.blueprint("烈刺突") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("皇帝の威厳") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [3000, 3500, 4000, 4500, 5000]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("皇帝の威信") {
            Act {
                /*
                ターゲット固定
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                回避率アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [30, 32, 35, 40, 50]
                  times2: [2, 2, 2, 2, 2]
                被ダメージダウン(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("威光堂々　～銀河皇帝円舞曲～") {
            Act {
                /*
                刻印
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [328, 345, 361, 378, 394]
                  times2: 3
                通常ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [1, 1, 1, 1, 1]
                特殊ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [10, 12, 14, 17, 20]
                  times4: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          最大HPアップ(%value%)
            target: 味方全体
            values: [20, 20, 20, 20, 20]
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
          ターゲット固定
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4010015 = PartialDressBlueprint(
  id = 4010015,
  name = "皇帝",
  baseRarity = 4,
  cost = 15,
  character = Character.Akira,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 3500,
    actPower = 200,
    normalDefense = 150,
    specialDefense = 300,
    agility = 180,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 110000,
    actPower = 2000,
    normalDefense = 3000,
    specialDefense = 4000,
    agility = 3300,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "烈刺突",
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
      name = "皇帝の威厳",
      type = ActType.Act2,
      apCost = 2,
      icon = 173,
      parameters = listOf(
        actParameters46,
        actParameters14,
        actParameters82,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "皇帝の威信",
      type = ActType.Act3,
      apCost = 1,
      icon = 152,
      parameters = listOf(
        actParameters14,
        actParameters39,
        actParameters60,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "威光堂々　～銀河皇帝円舞曲～",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 33,
      parameters = listOf(
        actParameters14,
        actParameters276,
        actParameters171,
        actParameters171,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard0,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 12900,
      actPower = 390,
      normalDefense = 300,
      specialDefense = 900,
      agility = 240,
    ),
    StatData(
      hp = 21500,
      actPower = 650,
      normalDefense = 500,
      specialDefense = 1500,
      agility = 400,
    ),
    StatData(
      hp = 34400,
      actPower = 1040,
      normalDefense = 800,
      specialDefense = 2400,
      agility = 640,
    ),
    StatData(
      hp = 43000,
      actPower = 1300,
      normalDefense = 1000,
      specialDefense = 3000,
      agility = 800,
    ),
  ),
)
