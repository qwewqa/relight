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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040015(
    name = "シンフォギア装者",
    acts = listOf(
        ActType.Act1.blueprint("繚乱の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [91, 95, 99, 104, 109]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("勇気の歌声") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("常闇の剣舞") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [97, 101, 106, 112, 116]
                  times1: 2
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                毒(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2000, 2500, 3000, 3500, 4000]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("EMPRESS†REBELLION") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                スタン
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%) (毒状態の敵役に特攻)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [125, 135, 145, 155, 170]
                  times3: [5, 5, 5, 5, 5]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          特殊バリア(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10000
            time: 3
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
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
        listOf(
        /*
        auto skill 4:
          すばやさダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1040015 = PartialDressBlueprint(
  id = 1040015,
  name = "シンフォギア装者",
  baseRarity = 4,
  cost = 12,
  character = Character.Claudine,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 33050,
  stats = StatData(
    hp = 1072,
    actPower = 206,
    normalDefense = 79,
    specialDefense = 118,
    agility = 191,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 35330,
    actPower = 3400,
    normalDefense = 1300,
    specialDefense = 1950,
    agility = 3150,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "繚乱の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters143,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "勇気の歌声",
      type = ActType.Act2,
      apCost = 2,
      icon = 10006,
      parameters = listOf(
        actParameters30,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "常闇の剣舞",
      type = ActType.Act3,
      apCost = 3,
      icon = 173,
      parameters = listOf(
        actParameters167,
        actParameters14,
        actParameters168,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "EMPRESS†REBELLION",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters30,
        actParameters14,
        actParameters169,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6600,
      actPower = 330,
      normalDefense = 90,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 11000,
      actPower = 550,
      normalDefense = 150,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 17600,
      actPower = 880,
      normalDefense = 240,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 22000,
      actPower = 1100,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
