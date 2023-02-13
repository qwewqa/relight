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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3020009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3020009(
    name = "星の王子さま",
    acts = listOf(
        ActType.Act1.blueprint("強刺突") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("ヘビのひと噛み") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("キツネの教え") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 11, 12, 13, 15]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("旅の終わりに") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [250, 260, 270, 280, 300]
                  times1: 3
                無敵
                  target: 前から5体の味方
                  hit_rate2: 100
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
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
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
          毎ターンHP回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 2000
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3020009 = PartialDressBlueprint(
  id = 3020009,
  name = "星の王子さま",
  baseRarity = 4,
  cost = 12,
  character = Character.Misora,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 1343,
    actPower = 195,
    normalDefense = 41,
    specialDefense = 77,
    agility = 180,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 44240,
    actPower = 3220,
    normalDefense = 680,
    specialDefense = 1270,
    agility = 2980,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強刺突",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters98,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "ヘビのひと噛み",
      type = ActType.Act2,
      apCost = 3,
      icon = 20,
      parameters = listOf(
        actParameters44,
        actParameters145,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キツネの教え",
      type = ActType.Act3,
      apCost = 3,
      icon = 45,
      parameters = listOf(
        actParameters2,
        actParameters219,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "旅の終わりに",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 156,
      parameters = listOf(
        actParameters325,
        actParameters25,
        actParameters1,
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
      hp = 5100,
      actPower = 360,
      normalDefense = 180,
      specialDefense = 330,
      agility = 180,
    ),
    StatData(
      hp = 8500,
      actPower = 600,
      normalDefense = 300,
      specialDefense = 550,
      agility = 300,
    ),
    StatData(
      hp = 13600,
      actPower = 960,
      normalDefense = 480,
      specialDefense = 880,
      agility = 480,
    ),
    StatData(
      hp = 17000,
      actPower = 1200,
      normalDefense = 600,
      specialDefense = 1100,
      agility = 600,
    ),
  ),
)
