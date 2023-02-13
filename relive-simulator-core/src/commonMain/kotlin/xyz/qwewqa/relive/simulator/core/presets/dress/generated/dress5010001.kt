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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress5010001(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("俊速の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                すばやさアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act2.blueprint("聖域の歌") {
            Act {
                /*
                継続マイナス効果耐性アップ(%value%)
                  target: 前から3体の味方
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("抑止の協奏曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 1
                スタン
                  target: 敵役全体
                  hit_rate2: 50
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ひしめく鼓動は青の炎") {
            Act {
                /*
                必中
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (ACTタイプ[通常]の敵役に特攻)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [125, 135, 145, 155, 170]
                  times4: [3, 3, 3, 3, 3]

                field_effects:
                  本日も集中あるのみ（宙） (value: 1, time: 6, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          通常防御力ダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 2:
          特殊防御力ダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 3:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 青嵐総合芸術院のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress5010001 = PartialDressBlueprint(
  id = 5010001,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Koharu,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24051,
  stats = StatData(
    hp = 2623,
    actPower = 228,
    normalDefense = 97,
    specialDefense = 181,
    agility = 205,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 86410,
    actPower = 3760,
    normalDefense = 1600,
    specialDefense = 2990,
    agility = 3380,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "俊速の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 14,
      parameters = listOf(
        actParameters0,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "聖域の歌",
      type = ActType.Act2,
      apCost = 1,
      icon = 26,
      parameters = listOf(
        actParameters53,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "抑止の協奏曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 57,
      parameters = listOf(
        actParameters21,
        actParameters29,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ひしめく鼓動は青の炎",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1014,
      parameters = listOf(
        actParameters25,
        actParameters32,
        actParameters30,
        actParameters393,
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
      hp = 7800,
      actPower = 450,
      normalDefense = 150,
      specialDefense = 900,
      agility = 270,
    ),
    StatData(
      hp = 13000,
      actPower = 750,
      normalDefense = 250,
      specialDefense = 1500,
      agility = 450,
    ),
    StatData(
      hp = 20800,
      actPower = 1200,
      normalDefense = 400,
      specialDefense = 2400,
      agility = 720,
    ),
    StatData(
      hp = 26000,
      actPower = 1500,
      normalDefense = 500,
      specialDefense = 3000,
      agility = 900,
    ),
  ),
)
