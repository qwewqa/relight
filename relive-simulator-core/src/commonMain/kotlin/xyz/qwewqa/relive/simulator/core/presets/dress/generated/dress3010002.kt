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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010002(
    name = "駆け出し船長",
    acts = listOf(
        ActType.Act1.blueprint("狙撃") {
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
        ActType.Act2.blueprint("キラめきの狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 3
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("キラめきの風") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [15, 16, 17, 18, 20]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("チェストオブグローリー") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [17, 19, 20, 22, 24]
                  times1: [3, 3, 3, 3, 3]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [27, 30, 32, 35, 38]
                  times2: [3, 3, 3, 3, 3]
                すばやさアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [16, 18, 20, 22, 23]
                  times3: [3, 3, 3, 3, 3]
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
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [4, 4, 4, 5, 5]
        */
        ),
        listOf(
        /*
        auto skill 3:
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3010002 = PartialDressBlueprint(
  id = 3010002,
  name = "駆け出し船長",
  baseRarity = 4,
  cost = 12,
  character = Character.Aruru,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 32050,
  stats = StatData(
    hp = 1038,
    actPower = 173,
    normalDefense = 82,
    specialDefense = 53,
    agility = 158,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 34210,
    actPower = 2860,
    normalDefense = 1350,
    specialDefense = 870,
    agility = 2600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "狙撃",
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
      name = "キラめきの狙撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters308,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キラめきの風",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters34,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "チェストオブグローリー",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 8,
      parameters = listOf(
        actParameters309,
        actParameters310,
        actParameters201,
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
      normalDefense = 300,
      specialDefense = 150,
      agility = 240,
    ),
    StatData(
      hp = 11000,
      actPower = 750,
      normalDefense = 500,
      specialDefense = 250,
      agility = 400,
    ),
    StatData(
      hp = 17600,
      actPower = 1200,
      normalDefense = 800,
      specialDefense = 400,
      agility = 640,
    ),
    StatData(
      hp = 22000,
      actPower = 1500,
      normalDefense = 1000,
      specialDefense = 500,
      agility = 800,
    ),
  ),
)
