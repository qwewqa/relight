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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4030010(
    name = "シークフェルト音楽学院",
    acts = listOf(
        ActType.Act1.blueprint("一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("キラめきの一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("奮起の協奏曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [2, 2, 2, 2, 2]
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [5, 6, 7, 8, 10]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ルビーンヘッレバルデ") {
            Act {
                /*
                通常防御力アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [5, 6, 7, 8, 10]
                  times1: [2, 2, 2, 2, 2]
                特殊防御力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [2, 2, 2, 2, 2]
                すばやさアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [2, 2, 2, 2, 2]
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
            values: [4, 4, 4, 5, 5]
        */
        ),
        listOf(
        /*
        auto skill 2:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          クリティカル率アップ(%value%)
            target: 自身
            values: [14, 15, 17, 18, 20]
        */
        ),
    ),
    unitSkill = null /* シークフェルト音楽学院かつ、花属性の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4030010 = PartialDressBlueprint(
  id = 4030010,
  name = "シークフェルト音楽学院",
  baseRarity = 4,
  cost = 12,
  character = Character.MeiFan,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11050,
  stats = StatData(
    hp = 1661,
    actPower = 93,
    normalDefense = 150,
    specialDefense = 91,
    agility = 136,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 54720,
    actPower = 1540,
    normalDefense = 2480,
    specialDefense = 1500,
    agility = 2250,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの一撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters2,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "奮起の協奏曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters44,
        actParameters112,
        actParameters112,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ルビーンヘッレバルデ",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 10,
      parameters = listOf(
        actParameters112,
        actParameters112,
        actParameters216,
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
  ),
)
