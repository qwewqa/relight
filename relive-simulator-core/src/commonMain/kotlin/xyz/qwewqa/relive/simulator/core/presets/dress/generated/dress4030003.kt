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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4030003(
    name = "女帝",
    acts = listOf(
        ActType.Act1.blueprint("強刺突") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("堅守の附与") {
            Act {
                /*
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [3000, 3500, 4000, 4500, 5000]
                  times1: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [3000, 3500, 4000, 4500, 5000]
                  times2: [3, 3, 3, 3, 3]
                AP減少
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("全土の庇護") {
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
        ActType.ClimaxAct.blueprint("女帝陛下の憂鬱") {
            Act {
                /*
                マイナス効果反転(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [3, 3, 3, 3, 3]
                  times1: [0, 0, 0, 0, 0]
                プラス効果反転(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [3, 3, 3, 3, 3]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [117, 123, 128, 134, 140]
                  times3: 4
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          挑発
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2
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
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4030003 = PartialDressBlueprint(
  id = 4030003,
  name = "女帝",
  baseRarity = 4,
  cost = 15,
  character = Character.MeiFan,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 3498,
    actPower = 148,
    normalDefense = 182,
    specialDefense = 273,
    agility = 136,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 115210,
    actPower = 2440,
    normalDefense = 3000,
    specialDefense = 4510,
    agility = 2250,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強刺突",
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
      name = "堅守の附与",
      type = ActType.Act2,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters82,
        actParameters82,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "全土の庇護",
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
      name = "女帝陛下の憂鬱",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 151,
      parameters = listOf(
        actParameters68,
        actParameters68,
        actParameters85,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard1,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 12300,
      actPower = 420,
      normalDefense = 300,
      specialDefense = 900,
      agility = 390,
    ),
    StatData(
      hp = 20500,
      actPower = 700,
      normalDefense = 500,
      specialDefense = 1500,
      agility = 650,
    ),
    StatData(
      hp = 32800,
      actPower = 1120,
      normalDefense = 800,
      specialDefense = 2400,
      agility = 1040,
    ),
    StatData(
      hp = 41000,
      actPower = 1400,
      normalDefense = 1000,
      specialDefense = 3000,
      agility = 1300,
    ),
  ),
)
