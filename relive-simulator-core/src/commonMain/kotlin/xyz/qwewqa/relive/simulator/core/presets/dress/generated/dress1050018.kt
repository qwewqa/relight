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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1050018(
    name = "武田信玄",
    acts = listOf(
        ActType.Act1.blueprint("繚乱の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [91, 95, 99, 104, 109]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("風の如く") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 2
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("火の如く") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                通常ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [2, 2, 2, 2, 2]
                特殊ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("風林火山") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 5

                field_effects:
                  昏迷の影 (value: 1, time: 6, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方の西條クロディーヌ
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1050018 = PartialDressBlueprint(
  id = 1050018,
  name = "武田信玄",
  baseRarity = 4,
  cost = 13,
  character = Character.Maya,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 1101,
    actPower = 264,
    normalDefense = 75,
    specialDefense = 111,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 36290,
    actPower = 4360,
    normalDefense = 1240,
    specialDefense = 1840,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "繚乱の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters143,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "風の如く",
      type = ActType.Act2,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters56,
        actParameters30,
        actParameters90,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "火の如く",
      type = ActType.Act3,
      apCost = 2,
      icon = 33,
      parameters = listOf(
        actParameters46,
        actParameters60,
        actParameters60,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "風林火山",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1008,
      parameters = listOf(
        actParameters83,
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
      hp = 6600,
      actPower = 390,
      normalDefense = 90,
      specialDefense = 360,
      agility = 240,
    ),
    StatData(
      hp = 11000,
      actPower = 650,
      normalDefense = 150,
      specialDefense = 600,
      agility = 400,
    ),
    StatData(
      hp = 17600,
      actPower = 1040,
      normalDefense = 240,
      specialDefense = 960,
      agility = 640,
    ),
    StatData(
      hp = 22000,
      actPower = 1300,
      normalDefense = 300,
      specialDefense = 1200,
      agility = 800,
    ),
  ),
)
