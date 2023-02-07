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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2050010(
    name = "魔術師",
    acts = listOf(
        ActType.Act1.blueprint("鈍足の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 2
                すばやさダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act2.blueprint("脱力の魔術") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 2
                ACTパワーダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                通常防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("キラめきの加護") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [10, 11, 12, 13, 15]
                  times1: [0, 0, 0, 0, 0]
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [3000, 3500, 4000, 4500, 5000]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("アルカナム・マジーケ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 5
                混乱
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                暗闇
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                大火傷(%value%) (ダメージ量は対象の最大HPに依存する)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [5, 6, 7, 8, 10]
                  times4: [3, 3, 3, 3, 3]
                刻印
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [2, 2, 2, 2, 2]
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
            values: [7, 7, 7, 7, 7]
        */
        ),
        listOf(
        /*
        auto skill 2:
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 3:
          被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 10]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2050010 = PartialDressBlueprint(
  id = 2050010,
  name = "魔術師",
  baseRarity = 4,
  cost = 15,
  character = Character.Yuyuko,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 2332,
    actPower = 258,
    normalDefense = 127,
    specialDefense = 191,
    agility = 197,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 76810,
    actPower = 4260,
    normalDefense = 2100,
    specialDefense = 3160,
    agility = 3250,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "鈍足の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 15,
      parameters = listOf(
        actParameters125,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "脱力の魔術",
      type = ActType.Act2,
      apCost = 2,
      icon = 9,
      parameters = listOf(
        actParameters56,
        actParameters32,
        actParameters32,
        actParameters32,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キラめきの加護",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters138,
        actParameters80,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "アルカナム・マジーケ",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 59,
      parameters = listOf(
        actParameters222,
        actParameters14,
        actParameters14,
        actParameters91,
        actParameters14,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 360,
      normalDefense = 150,
      specialDefense = 900,
      agility = 300,
    ),
    StatData(
      hp = 15000,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 1500,
      agility = 500,
    ),
    StatData(
      hp = 24000,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 2400,
      agility = 800,
    ),
    StatData(
      hp = 30000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 3000,
      agility = 1000,
    ),
  ),
)
