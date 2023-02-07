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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010005
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4010005(
    name = "ドクター",
    acts = listOf(
        ActType.Act1.blueprint("刺突") {
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
        ActType.Act2.blueprint("キラめきの刺突") {
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
        ActType.Act3.blueprint("キラめきの輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [92, 97, 101, 106, 110]
                  times1: 1
                キラめき回復(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ドクター晶の特効薬") {
            Act {
                /*
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [28, 31, 34, 37, 40]
                  times1: [2, 2, 2, 2, 2]
                吸収(%value%) (吸収量は与ダメージに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [18, 19, 21, 23, 25]
                  times2: [2, 2, 2, 2, 2]
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [140, 280, 520, 850, 1300]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          通常バリア(%value%)
            target: 自身
            hit_rate: 100
            value: 2270
            time: 3
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
          宙属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX60%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4010005 = PartialDressBlueprint(
  id = 4010005,
  name = "ドクター",
  baseRarity = 4,
  cost = 12,
  character = Character.Akira,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 32050,
  stats = StatData(
    hp = 1082,
    actPower = 165,
    normalDefense = 69,
    specialDefense = 69,
    agility = 161,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 35670,
    actPower = 2730,
    normalDefense = 1140,
    specialDefense = 1140,
    agility = 2650,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "刺突",
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
      name = "キラめきの刺突",
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
      name = "キラめきの輪舞曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters270,
        actParameters50,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ドクター晶の特効薬",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 39,
      parameters = listOf(
        actParameters352,
        actParameters353,
        actParameters354,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6600,
      actPower = 450,
      normalDefense = 90,
      specialDefense = 360,
      agility = 240,
    ),
    StatData(
      hp = 11000,
      actPower = 750,
      normalDefense = 150,
      specialDefense = 600,
      agility = 400,
    ),
    StatData(
      hp = 17600,
      actPower = 1200,
      normalDefense = 240,
      specialDefense = 960,
      agility = 640,
    ),
    StatData(
      hp = 22000,
      actPower = 1500,
      normalDefense = 300,
      specialDefense = 1200,
      agility = 800,
    ),
  ),
)
