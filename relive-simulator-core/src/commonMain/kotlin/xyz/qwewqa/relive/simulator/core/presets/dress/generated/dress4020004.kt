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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4020004(
    name = "法王",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの斬撃") {
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
        ActType.Act2.blueprint("信頼の光") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("王の導き") {
            Act {
                /*
                ターゲット固定
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                回避率アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [30, 32, 35, 40, 50]
                  times2: [2, 2, 2, 2, 2]
                被ダメージダウン(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("道に光を、戦場に花を") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (凍結状態の敵役に特攻)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [307, 323, 338, 353, 369]
                  times1: [4, 4, 4, 4, 4]
                退場解除(%value%) (回復量は対象の最大HPに依存する)
                  target: 退場した中で、後ろから1番目の味方
                  hit_rate2: 100
                  values2: [40, 42, 44, 47, 50]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          暗闇耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
        listOf(
        /*
        auto skill 2:
          混乱耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
        listOf(
        /*
        auto skill 3:
          睡眠耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 6
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4020004 = PartialDressBlueprint(
  id = 4020004,
  name = "法王",
  baseRarity = 4,
  cost = 15,
  character = Character.Michiru,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 3323,
    actPower = 158,
    normalDefense = 287,
    specialDefense = 191,
    agility = 136,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 109450,
    actPower = 2600,
    normalDefense = 4740,
    specialDefense = 3160,
    agility = 2250,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの斬撃",
      type = ActType.Act1,
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
    ActType.Act2 to ActBlueprint(
      name = "信頼の光",
      type = ActType.Act2,
      apCost = 2,
      icon = 20,
      parameters = listOf(
        actParameters38,
        actParameters42,
        actParameters42,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "王の導き",
      type = ActType.Act3,
      apCost = 1,
      icon = 152,
      parameters = listOf(
        actParameters14,
        actParameters39,
        actParameters60,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "道に光を、戦場に花を",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 197,
      parameters = listOf(
        actParameters363,
        actParameters293,
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
      hp = 13200,
      actPower = 390,
      normalDefense = 840,
      specialDefense = 300,
      agility = 390,
    ),
    StatData(
      hp = 22000,
      actPower = 650,
      normalDefense = 1400,
      specialDefense = 500,
      agility = 650,
    ),
    StatData(
      hp = 35200,
      actPower = 1040,
      normalDefense = 2240,
      specialDefense = 800,
      agility = 1040,
    ),
    StatData(
      hp = 44000,
      actPower = 1300,
      normalDefense = 2800,
      specialDefense = 1000,
      agility = 1300,
    ),
  ),
)
