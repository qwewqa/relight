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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010013(
    name = "ジャック・ザ・キッド",
    acts = listOf(
        ActType.Act1.blueprint("激化の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [91, 95, 99, 104, 109]
                  times1: 2
                */
            }
        },
        ActType.Act2.blueprint("減光の射撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                キラめき獲得ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [60, 65, 70, 75, 80]
                  times2: [2, 2, 2, 2, 2]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("形勢逆転") {
            Act {
                /*
                AP増加
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ゴールデン・デュエル") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 3

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
          最大HPアップ(%value%)
            target: 味方全体
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          ACTパワーダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3010013 = PartialDressBlueprint(
  id = 3010013,
  name = "ジャック・ザ・キッド",
  baseRarity = 4,
  cost = 13,
  character = Character.Aruru,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1159,
    actPower = 255,
    normalDefense = 77,
    specialDefense = 116,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 38170,
    actPower = 4210,
    normalDefense = 1280,
    specialDefense = 1920,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "激化の狙撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters144,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "減光の射撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 192,
      parameters = listOf(
        actParameters46,
        actParameters105,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "形勢逆転",
      type = ActType.Act3,
      apCost = 3,
      icon = 173,
      parameters = listOf(
        actParameters14,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ゴールデン・デュエル",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1008,
      parameters = listOf(
        actParameters26,
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
      hp = 6300,
      actPower = 420,
      normalDefense = 90,
      specialDefense = 390,
      agility = 240,
    ),
    StatData(
      hp = 10500,
      actPower = 700,
      normalDefense = 150,
      specialDefense = 650,
      agility = 400,
    ),
    StatData(
      hp = 16800,
      actPower = 1120,
      normalDefense = 240,
      specialDefense = 1040,
      agility = 640,
    ),
    StatData(
      hp = 21000,
      actPower = 1400,
      normalDefense = 300,
      specialDefense = 1300,
      agility = 800,
    ),
  ),
)
