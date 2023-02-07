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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030002(
    name = "太陽の国の騎士",
    acts = listOf(
        ActType.Act1.blueprint("打撃") {
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
        ActType.Act2.blueprint("キラめきの打撃") {
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
        ActType.Act3.blueprint("脱力の独奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [132, 138, 145, 151, 158]
                  times1: 1
                ACTパワーダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [8, 9, 10, 11, 12]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("お日様の祝福") {
            Act {
                /*
                通常バリア(%value%)
                  target: 前グループの味方
                  hit_rate1: 100
                  values1: [510, 990, 1800, 2970, 4530]
                  times1: [3, 3, 3, 3, 3]
                通常防御力アップ(%value%)
                  target: 前グループの味方
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 29]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          被ダメージダウン(%value%)
            target: 自身
            values: [2, 3, 3, 3, 4]
        */
        ),
        listOf(
        /*
        auto skill 2:
          与ダメージアップ(%value%)
            target: 自身
            values: [2, 3, 3, 3, 4]
        */
        ),
        listOf(
        /*
        auto skill 3:
          通常バリア(%value%)
            target: 自身
            hit_rate: 100
            value: 750
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX20%) 通常防御力アップ %opt2_value%%(MAX10%) 特殊防御力アップ %opt3_value%%(MAX10%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030002 = PartialDressBlueprint(
  id = 1030002,
  name = "太陽の国の騎士",
  baseRarity = 3,
  cost = 9,
  character = Character.Mahiru,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 981,
    actPower = 119,
    normalDefense = 49,
    specialDefense = 73,
    agility = 165,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 32310,
    actPower = 1970,
    normalDefense = 820,
    specialDefense = 1230,
    agility = 2740,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "打撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの打撃",
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
      name = "脱力の独奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 9,
      parameters = listOf(
        actParameters7,
        actParameters116,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "お日様の祝福",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 30,
      parameters = listOf(
        actParameters117,
        actParameters118,
        actParameters1,
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
  ),
)
