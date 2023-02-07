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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1060007(
    name = "沖野みなも",
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
        ActType.Act2.blueprint("キラめきの癒し") {
            Act {
                /*
                HP回復(%value%)
                  target: HP割合が1番低い味方
                  hit_rate1: 100
                  values1: [310, 590, 1080, 1790, 2730]
                  times1: [0, 0, 0, 0, 0]
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("祝福の合奏") {
            Act {
                /*
                HP回復(%value%)
                  target: 前グループの味方
                  hit_rate1: 100
                  values1: [240, 460, 840, 1390, 2130]
                  times1: [0, 0, 0, 0, 0]
                通常防御力アップ(%value%)
                  target: 前グループの味方
                  hit_rate2: 100
                  values2: [11, 12, 13, 14, 15]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("スターダスト　レイン") {
            Act {
                /*
                HP回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [510, 990, 1800, 2970, 4530]
                  times1: [0, 0, 0, 0, 0]
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
          花属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 雪属性の舞台少女の最大HPアップ %opt1_value%%(MAX10%) 通常防御力アップ %opt2_value%%(MAX5%) 特殊防御力アップ %opt3_value%%(MAX5%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1060007 = PartialDressBlueprint(
  id = 1060007,
  name = "沖野みなも",
  baseRarity = 3,
  cost = 9,
  character = Character.Junna,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1040,
    actPower = 98,
    normalDefense = 64,
    specialDefense = 65,
    agility = 153,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 34270,
    actPower = 1620,
    normalDefense = 1070,
    specialDefense = 1090,
    agility = 2540,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一撃",
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
      name = "キラめきの癒し",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters210,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "祝福の合奏",
      type = ActType.Act3,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters211,
        actParameters212,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "スターダスト　レイン",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters213,
        actParameters30,
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
  ),
)
