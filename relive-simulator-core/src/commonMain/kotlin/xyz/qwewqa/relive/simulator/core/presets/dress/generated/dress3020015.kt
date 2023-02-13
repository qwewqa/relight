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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3020015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3020015(
    name = "信仰",
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
        ActType.Act2.blueprint("治癒の祈り") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("堅強の盾") {
            Act {
                /*
                ターゲット固定
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                通常バリア(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [3000, 3500, 4000, 4500, 5000]
                  times2: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [3000, 3500, 4000, 4500, 5000]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("秘石が導く月光の秘蹟") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [328, 345, 361, 378, 394]
                  times1: 4
                吸収(%value%) (吸収量は与ダメージに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 23, 26, 29, 33]
                  times2: [2, 2, 2, 2, 2]
                被ダメージダウン(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          混乱耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
        listOf(
        /*
        auto skill 2:
          スタン耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
        listOf(
        /*
        auto skill 3:
          ストップ耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3020015 = PartialDressBlueprint(
  id = 3020015,
  name = "信仰",
  baseRarity = 4,
  cost = 15,
  character = Character.Misora,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 3445,
    actPower = 145,
    normalDefense = 191,
    specialDefense = 287,
    agility = 136,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 113480,
    actPower = 2390,
    normalDefense = 3160,
    specialDefense = 4740,
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
      name = "治癒の祈り",
      type = ActType.Act2,
      apCost = 2,
      icon = 45,
      parameters = listOf(
        actParameters38,
        actParameters16,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "堅強の盾",
      type = ActType.Act3,
      apCost = 1,
      icon = 152,
      parameters = listOf(
        actParameters14,
        actParameters82,
        actParameters82,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "秘石が導く月光の秘蹟",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 44,
      parameters = listOf(
        actParameters230,
        actParameters163,
        actParameters60,
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
      hp = 15000,
      actPower = 420,
      normalDefense = 300,
      specialDefense = 900,
      agility = 390,
    ),
    StatData(
      hp = 25000,
      actPower = 700,
      normalDefense = 500,
      specialDefense = 1500,
      agility = 650,
    ),
    StatData(
      hp = 40000,
      actPower = 1120,
      normalDefense = 800,
      specialDefense = 2400,
      agility = 1040,
    ),
    StatData(
      hp = 50000,
      actPower = 1400,
      normalDefense = 1000,
      specialDefense = 3000,
      agility = 1300,
    ),
  ),
)
