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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030014(
    name = "みらい",
    acts = listOf(
        ActType.Act1.blueprint("バラード") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                睡眠
                  target: 前から3体の敵役
                  hit_rate2: 33
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("ロックンロール") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                スタン
                  target: 前から3体の敵役
                  hit_rate2: 33
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("キラめきの歌") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [10, 11, 12, 13, 15]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("夢のステージをみんなに！") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
                ストップ
                  target: 敵役全体
                  hit_rate2: 75
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          クリティカル率アップ(%value%)
            target: 自身
            values: [15, 15, 15, 15, 15]
        */
        ),
        listOf(
        /*
        auto skill 2:
          被ダメージダウン(%value%)
            target: 自身
            values: [15, 15, 15, 15, 15]
        */
        ),
        listOf(
        /*
        auto skill 3:
          退場回避 (発動時に効果解除)
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030014 = PartialDressBlueprint(
  id = 1030014,
  name = "みらい",
  baseRarity = 4,
  cost = 12,
  character = Character.Mahiru,
  attribute = Attribute.Dream,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 1428,
    actPower = 156,
    normalDefense = 56,
    specialDefense = 111,
    agility = 152,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 47040,
    actPower = 2570,
    normalDefense = 920,
    specialDefense = 1840,
    agility = 2500,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "バラード",
      type = ActType.Act1,
      apCost = 2,
      icon = 58,
      parameters = listOf(
        actParameters137,
        actParameters96,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "ロックンロール",
      type = ActType.Act2,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters137,
        actParameters96,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キラめきの歌",
      type = ActType.Act3,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters139,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "夢のステージをみんなに！",
      type = ActType.ClimaxAct,
      apCost = 3,
      icon = 60,
      parameters = listOf(
        actParameters85,
        actParameters140,
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
    StatData(
      hp = 8400,
      actPower = 360,
      normalDefense = 150,
      specialDefense = 360,
      agility = 240,
    ),
    StatData(
      hp = 14000,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 600,
      agility = 400,
    ),
    StatData(
      hp = 22400,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 960,
      agility = 640,
    ),
    StatData(
      hp = 28000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 1200,
      agility = 800,
    ),
  ),
)
