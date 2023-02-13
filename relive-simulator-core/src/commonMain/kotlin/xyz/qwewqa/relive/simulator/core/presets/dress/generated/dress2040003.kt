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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2040003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2040003(
    name = "柳生十兵衛",
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
        ActType.Act2.blueprint("キラめきの大盾") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                通常バリア(%value%)
                  target: 後ろから2体の味方
                  hit_rate2: 100
                  values2: [300, 510, 840, 1390, 2120]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("堅守の歌") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [9, 10, 11, 12, 13]
                  times1: [3, 3, 3, 3, 3]
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [210, 360, 590, 970, 1490]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("奥義・影斬り") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 3
                ステータスアップ効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
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
            values: [4, 4, 5, 5, 6]
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
          通常バリア(%value%)
            target: 自身
            hit_rate: 100
            value: 2270
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX60%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2040003 = PartialDressBlueprint(
  id = 2040003,
  name = "柳生十兵衛",
  baseRarity = 4,
  cost = 12,
  character = Character.Rui,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11045,
  stats = StatData(
    hp = 1722,
    actPower = 102,
    normalDefense = 143,
    specialDefense = 93,
    agility = 128,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 56740,
    actPower = 1690,
    normalDefense = 2370,
    specialDefense = 1530,
    agility = 2120,
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
      name = "キラめきの大盾",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters3,
        actParameters127,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "堅守の歌",
      type = ActType.Act3,
      apCost = 2,
      icon = 30,
      parameters = listOf(
        actParameters11,
        actParameters291,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "奥義・影斬り",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 10006,
      parameters = listOf(
        actParameters31,
        actParameters30,
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
    StatData(
      hp = 9000,
      actPower = 300,
      normalDefense = 480,
      specialDefense = 300,
      agility = 210,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 800,
      specialDefense = 500,
      agility = 350,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 1280,
      specialDefense = 800,
      agility = 560,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1600,
      specialDefense = 1000,
      agility = 700,
    ),
  ),
)
