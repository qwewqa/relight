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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1080004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1080004(
    name = "力",
    acts = listOf(
        ActType.Act1.blueprint("強斬撃") {
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
        ActType.Act2.blueprint("力の浄化") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("剛毅の庇護") {
            Act {
                /*
                ターゲット固定
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [1, 1, 1, 1, 1]
                被ダメージダウン(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("獅子の咆哮") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [328, 345, 361, 378, 394]
                  times1: 5
                毎ターンHP回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10000, 12000, 14000, 16000, 20000]
                  times2: [3, 3, 3, 3, 3]
                回避率アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [30, 32, 35, 40, 50]
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
          凍結耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
        listOf(
        /*
        auto skill 3:
          スタン耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
    ),
    unitSkill = null /* 風・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1080004 = PartialDressBlueprint(
  id = 1080004,
  name = "力",
  baseRarity = 4,
  cost = 15,
  character = Character.Futaba,
  attribute = Attribute.Wind,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 3428,
    actPower = 153,
    normalDefense = 273,
    specialDefense = 182,
    agility = 136,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 112910,
    actPower = 2520,
    normalDefense = 4510,
    specialDefense = 3000,
    agility = 2250,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters96,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "力の浄化",
      type = ActType.Act2,
      apCost = 2,
      icon = 26,
      parameters = listOf(
        actParameters38,
        actParameters30,
        actParameters53,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "剛毅の庇護",
      type = ActType.Act3,
      apCost = 1,
      icon = 152,
      parameters = listOf(
        actParameters14,
        actParameters16,
        actParameters60,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "獅子の咆哮",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 28,
      parameters = listOf(
        actParameters164,
        actParameters243,
        actParameters39,
        actParameters1,
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
      hp = 12000,
      actPower = 360,
      normalDefense = 900,
      specialDefense = 300,
      agility = 390,
    ),
    StatData(
      hp = 20000,
      actPower = 600,
      normalDefense = 1500,
      specialDefense = 500,
      agility = 650,
    ),
    StatData(
      hp = 32000,
      actPower = 960,
      normalDefense = 2400,
      specialDefense = 800,
      agility = 1040,
    ),
    StatData(
      hp = 40000,
      actPower = 1200,
      normalDefense = 3000,
      specialDefense = 1000,
      agility = 1300,
    ),
  ),
)
