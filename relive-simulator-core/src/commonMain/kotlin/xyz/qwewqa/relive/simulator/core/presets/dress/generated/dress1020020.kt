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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020020(
    name = "野球少女",
    acts = listOf(
        ActType.Act1.blueprint("キラめきのスイング") {
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
        ActType.Act2.blueprint("トリックプレー") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 2
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("扇の要") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[通常]の敵役に特攻)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [74, 78, 82, 87, 91]
                  times1: [2, 2, 2, 2, 2]
                回避率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 32, 35, 40, 50]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("気迫のファインプレー") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 3

                field_effects:
                  鉄壁の守備 (value: 1, time: 1, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          すばやさアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 3:
          AP減少
            target: ACTパワーが高い3体の味方
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1020020 = PartialDressBlueprint(
  id = 1020020,
  name = "野球少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Hikari,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 1934,
    actPower = 291,
    normalDefense = 102,
    specialDefense = 153,
    agility = 242,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 63710,
    actPower = 4810,
    normalDefense = 1680,
    specialDefense = 2520,
    agility = 3990,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきのスイング",
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
      name = "トリックプレー",
      type = ActType.Act2,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters56,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "扇の要",
      type = ActType.Act3,
      apCost = 2,
      icon = 195,
      parameters = listOf(
        actParameters108,
        actParameters39,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "気迫のファインプレー",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1010,
      parameters = listOf(
        actParameters26,
        actParameters1,
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
      hp = 5400,
      actPower = 510,
      normalDefense = 90,
      specialDefense = 390,
      agility = 210,
    ),
    StatData(
      hp = 9000,
      actPower = 850,
      normalDefense = 150,
      specialDefense = 650,
      agility = 350,
    ),
    StatData(
      hp = 14400,
      actPower = 1360,
      normalDefense = 240,
      specialDefense = 1040,
      agility = 560,
    ),
    StatData(
      hp = 18000,
      actPower = 1700,
      normalDefense = 300,
      specialDefense = 1300,
      agility = 700,
    ),
  ),
)
