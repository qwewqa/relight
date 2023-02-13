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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090016(
    name = "紫式部",
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
        ActType.Act2.blueprint("歌人の呟き") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[通常]の敵役に特攻)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [156, 163, 171, 178, 187]
                  times1: [2, 2, 2, 2, 2]
                ACTパワーダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("悲哀の歌") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                刻印
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("あはれの美学") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (ACTタイプ[通常]の敵役に特攻)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate2: 100
                  values2: [307, 323, 338, 353, 369]
                  times2: [10, 10, 10, 10, 10]

                field_effects:
                  落日の音色 (value: 1, time: 6, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          クリティカル率アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 味方の花柳香子
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 3
        */
        ),
    ),
    unitSkill = null /* 風・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090016 = PartialDressBlueprint(
  id = 1090016,
  name = "紫式部",
  baseRarity = 4,
  cost = 15,
  character = Character.Kaoruko,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 2304,
    actPower = 262,
    normalDefense = 120,
    specialDefense = 180,
    agility = 220,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 75890,
    actPower = 4320,
    normalDefense = 1980,
    specialDefense = 2970,
    agility = 3630,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
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
      name = "歌人の呟き",
      type = ActType.Act2,
      apCost = 2,
      icon = 195,
      parameters = listOf(
        actParameters221,
        actParameters32,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "悲哀の歌",
      type = ActType.Act3,
      apCost = 2,
      icon = 150,
      parameters = listOf(
        actParameters38,
        actParameters14,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "あはれの美学",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1007,
      parameters = listOf(
        actParameters30,
        actParameters262,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9600,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 900,
      agility = 210,
    ),
    StatData(
      hp = 16000,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 1500,
      agility = 350,
    ),
    StatData(
      hp = 25600,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 2400,
      agility = 560,
    ),
    StatData(
      hp = 32000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 3000,
      agility = 700,
    ),
  ),
)
