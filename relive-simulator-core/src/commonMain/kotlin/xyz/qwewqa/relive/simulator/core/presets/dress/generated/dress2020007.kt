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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2020007(
    name = "巫女ヒツキ",
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
        ActType.Act2.blueprint("キラめきの一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("天からの祝福") {
            Act {
                /*
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [17, 19, 21, 23, 25]
                  times1: [2, 2, 2, 2, 2]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [17, 19, 21, 23, 25]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("神へ捧ぐ舞") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 2
                混乱
                  target: 敵役全体
                  hit_rate2: 33
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
          与ダメージアップ(%value%)
            target: 自身
            values: [5, 6, 6, 7, 8]
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
          雪属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 花属性の舞台少女のACTパワーアップ %opt1_value%%(MAX5%) クリティカル威力アップ %opt2_value%%(MAX5%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2020007 = PartialDressBlueprint(
  id = 2020007,
  name = "巫女ヒツキ",
  baseRarity = 3,
  cost = 9,
  character = Character.Ichie,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 800,
    actPower = 150,
    normalDefense = 56,
    specialDefense = 56,
    agility = 123,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 26370,
    actPower = 2480,
    normalDefense = 940,
    specialDefense = 940,
    agility = 2040,
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
      name = "キラめきの一閃",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters0,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "天からの祝福",
      type = ActType.Act3,
      apCost = 3,
      icon = 20,
      parameters = listOf(
        actParameters277,
        actParameters277,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "神へ捧ぐ舞",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 59,
      parameters = listOf(
        actParameters95,
        actParameters96,
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
