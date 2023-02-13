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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3040006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3040006(
    name = "チェシャ猫",
    acts = listOf(
        ActType.Act1.blueprint("一閃") {
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
        ActType.Act2.blueprint("キラめきの輪舞曲") {
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
        ActType.Act3.blueprint("煽動の協奏曲") {
            Act {
                /*
                挑発
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                HP回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [710, 1210, 1990, 3280, 5010]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("チェシャ猫の微笑") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 2
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [460, 790, 1300, 2140, 3260]
                  times2: [3, 3, 3, 3, 3]
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
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          被ダメージダウン(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3040006 = PartialDressBlueprint(
  id = 3040006,
  name = "チェシャ猫",
  baseRarity = 4,
  cost = 12,
  character = Character.Tsukasa,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11039,
  stats = StatData(
    hp = 1827,
    actPower = 100,
    normalDefense = 89,
    specialDefense = 143,
    agility = 140,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 60200,
    actPower = 1660,
    normalDefense = 1480,
    specialDefense = 2370,
    agility = 2320,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一閃",
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
      name = "キラめきの輪舞曲",
      type = ActType.Act2,
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
    ActType.Act3 to ActBlueprint(
      name = "煽動の協奏曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 56,
      parameters = listOf(
        actParameters14,
        actParameters271,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "チェシャ猫の微笑",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 31,
      parameters = listOf(
        actParameters95,
        actParameters340,
        actParameters1,
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
      hp = 9000,
      actPower = 300,
      normalDefense = 300,
      specialDefense = 480,
      agility = 210,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 500,
      specialDefense = 800,
      agility = 350,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 800,
      specialDefense = 1280,
      agility = 560,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1000,
      specialDefense = 1600,
      agility = 700,
    ),
  ),
)
