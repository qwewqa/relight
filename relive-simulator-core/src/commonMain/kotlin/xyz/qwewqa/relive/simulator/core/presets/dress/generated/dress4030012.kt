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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030012
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4030012(
    name = "ブラックサンタ",
    acts = listOf(
        ActType.Act1.blueprint("勝利の贈り物") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act2.blueprint("自由な贈り物") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("反撃の贈り物") {
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
        ActType.ClimaxAct.blueprint("ブラックサンタのプレゼント") {
            Act {
                /*
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [20, 22, 24, 26, 30]
                  times1: [0, 0, 0, 0, 0]
                無敵
                  target: 前から5体の味方
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 挑発・ターゲット固定を無視し、敵役全体
                  hit_rate3: 100
                  values3: [240, 250, 260, 270, 280]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ACT1封印
            target: 前から5体の敵役
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
        listOf(
        /*
        auto skill 3:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方のシークフェルト音楽学院
            values: [30, 30, 30, 30, 30]
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[通常]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4030012 = PartialDressBlueprint(
  id = 4030012,
  name = "ブラックサンタ",
  baseRarity = 4,
  cost = 15,
  character = Character.MeiFan,
  attribute = Attribute.Dream,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 3117,
    actPower = 260,
    normalDefense = 260,
    specialDefense = 137,
    agility = 230,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 83000,
    actPower = 4600,
    normalDefense = 3400,
    specialDefense = 1800,
    agility = 3800,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "勝利の贈り物",
      type = ActType.Act1,
      apCost = 2,
      icon = 39,
      parameters = listOf(
        actParameters46,
        actParameters32,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "自由な贈り物",
      type = ActType.Act2,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters46,
        actParameters14,
        actParameters53,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "反撃の贈り物",
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
      name = "ブラックサンタのプレゼント",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 156,
      parameters = listOf(
        actParameters273,
        actParameters25,
        actParameters374,
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
      normalDefense = 750,
      specialDefense = 150,
      agility = 240,
    ),
    StatData(
      hp = 13000,
      actPower = 550,
      normalDefense = 1250,
      specialDefense = 250,
      agility = 400,
    ),
    StatData(
      hp = 20800,
      actPower = 880,
      normalDefense = 2000,
      specialDefense = 400,
      agility = 640,
    ),
    StatData(
      hp = 26000,
      actPower = 1100,
      normalDefense = 2500,
      specialDefense = 500,
      agility = 800,
    ),
  ),
)
