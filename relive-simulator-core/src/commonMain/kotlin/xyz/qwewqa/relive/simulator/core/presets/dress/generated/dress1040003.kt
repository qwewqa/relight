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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040003(
    name = "紅き公爵 リシュリュー",
    acts = listOf(
        ActType.Act1.blueprint("斬撃") {
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
        ActType.Act2.blueprint("渾身の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 142, 149, 155]
                  times1: 1
                */
            }
        },
        ActType.Act3.blueprint("柔和の独奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [132, 138, 145, 151, 158]
                  times1: 1
                通常防御力ダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [8, 9, 10, 11, 12]
                  times2: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate3: 100
                  values3: [8, 9, 10, 11, 12]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("薔薇の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [286, 300, 314, 328, 343]
                  times1: 5
                HP回復量ダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [29, 32, 35, 38, 41]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          すばやさアップ(%value%)
            target: 自身
            values: [3, 3, 4, 4, 5]
        */
        ),
        listOf(
        /*
        auto skill 2:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [3, 3, 3, 4, 4]
        */
        ),
        listOf(
        /*
        auto skill 3:
          風属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX20%) 通常防御力アップ %opt2_value%%(MAX10%) 特殊防御力アップ %opt3_value%%(MAX10%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1040003 = PartialDressBlueprint(
  id = 1040003,
  name = "紅き公爵 リシュリュー",
  baseRarity = 3,
  cost = 9,
  character = Character.Claudine,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 14050,
  stats = StatData(
    hp = 900,
    actPower = 128,
    normalDefense = 68,
    specialDefense = 67,
    agility = 143,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 29670,
    actPower = 2120,
    normalDefense = 1140,
    specialDefense = 1120,
    agility = 2360,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "斬撃",
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
      name = "渾身の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters10,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "柔和の独奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 11,
      parameters = listOf(
        actParameters7,
        actParameters116,
        actParameters116,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "薔薇の輪舞曲",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 65,
      parameters = listOf(
        actParameters154,
        actParameters155,
        actParameters1,
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
