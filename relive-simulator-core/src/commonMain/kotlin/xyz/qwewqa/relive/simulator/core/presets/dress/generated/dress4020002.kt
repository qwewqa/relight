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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4020002(
    name = "水の神",
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
        ActType.Act2.blueprint("キラめきの斬撃") {
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
        ActType.Act3.blueprint("神器の大盾") {
            Act {
                /*
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [190, 380, 690, 1140, 1740]
                  times1: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ツー・フリーレン") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前グループの敵役
                  hit_rate1: 100
                  values1: [223, 234, 245, 256, 267]
                  times1: 2
                凍結
                  target: 前グループの敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          凍結耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          被ダメージダウン(%value%)
            target: 自身
            values: [2, 3, 3, 3, 4]
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

val dress4020002 = PartialDressBlueprint(
  id = 4020002,
  name = "水の神",
  baseRarity = 3,
  cost = 9,
  character = Character.Michiru,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11050,
  stats = StatData(
    hp = 1471,
    actPower = 82,
    normalDefense = 78,
    specialDefense = 117,
    agility = 113,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 48470,
    actPower = 1350,
    normalDefense = 1310,
    specialDefense = 1970,
    agility = 1880,
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
      name = "キラめきの斬撃",
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
      name = "神器の大盾",
      type = ActType.Act3,
      apCost = 3,
      icon = 31,
      parameters = listOf(
        actParameters363,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ツー・フリーレン",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 61,
      parameters = listOf(
        actParameters338,
        actParameters14,
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
