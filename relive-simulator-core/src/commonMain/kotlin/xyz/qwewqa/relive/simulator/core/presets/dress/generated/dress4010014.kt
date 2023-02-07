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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4010014(
    name = "昼行燈 クラウス大尉",
    acts = listOf(
        ActType.Act1.blueprint("浄化の薙払") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [84, 88, 92, 97, 101]
                  times3: 1
                */
            }
        },
        ActType.Act2.blueprint("キラめきの風") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [15, 16, 17, 18, 20]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("昼行燈の影") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 1

                field_effects:
                  悲壮の奏 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("雪解") {
            Act {
                /*
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [20, 22, 24, 26, 30]
                  times1: [0, 0, 0, 0, 0]
                回避
                  target: 前から5体の味方
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [5, 5, 5, 5, 5]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [200, 210, 220, 230, 240]
                  times3: 2
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          錯乱
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方のシークフェルト音楽学院
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4010014 = PartialDressBlueprint(
  id = 4010014,
  name = "昼行燈 クラウス大尉",
  baseRarity = 4,
  cost = 13,
  character = Character.Akira,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1288,
    actPower = 248,
    normalDefense = 138,
    specialDefense = 88,
    agility = 218,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 42240,
    actPower = 4010,
    normalDefense = 2160,
    specialDefense = 1440,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "浄化の薙払",
      type = ActType.Act1,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters136,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの風",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters34,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "昼行燈の影",
      type = ActType.Act3,
      apCost = 2,
      icon = 1025,
      parameters = listOf(
        actParameters21,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "雪解",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters273,
        actParameters224,
        actParameters171,
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
      hp = 6000,
      actPower = 450,
      normalDefense = 330,
      specialDefense = 90,
      agility = 210,
    ),
    StatData(
      hp = 10000,
      actPower = 750,
      normalDefense = 550,
      specialDefense = 150,
      agility = 350,
    ),
    StatData(
      hp = 16000,
      actPower = 1200,
      normalDefense = 880,
      specialDefense = 240,
      agility = 560,
    ),
    StatData(
      hp = 20000,
      actPower = 1500,
      normalDefense = 1100,
      specialDefense = 300,
      agility = 700,
    ),
  ),
)
