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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020025
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020025(
    name = "心を込めて手作り中 Encore",
    acts = listOf(
        ActType.Act1.blueprint("軽快な斬撃") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("甘美な斬撃") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [170, 180, 190, 200, 210]
                  times2: 1

                field_effects:
                  甘美なひととき (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("致命の斬撃") {
            Act {
                /*
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [30, 30, 30, 30, 30]
                  times1: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1

                field_effects:
                  拍手万雷（宙） (value: 1, time: 6, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("マカロン・ドリーム Encore") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                希望
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [350, 370, 390, 420, 450]
                  times4: 3

                field_effects:
                  拍手万雷（宙） (value: 1, time: 6, target: allies)
                  百花繚乱 (value: 1, time: 2, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          クリティカル率アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
          継続マイナス効果耐性アップ(%value%)
            target: 味方の宙属性
            hit_rate: 100
            value: 100
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 20
            time: 0

          field_effects:
            落日の音色 (value: 1, time: 6, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 3:
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          AP減少2
            target: 味方の宙属性
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 4:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
        */
        ),
    ),
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX100%) クリティカル威力アップ %opt2_value%%(MAX100%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1020025 = PartialDressBlueprint(
  id = 1020025,
  name = "心を込めて手作り中 Encore",
  baseRarity = 4,
  cost = 23,
  character = Character.Hikari,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10700,
    actPower = 1130,
    normalDefense = 410,
    specialDefense = 810,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 68200,
    actPower = 6300,
    normalDefense = 2100,
    specialDefense = 3180,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "軽快な斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1044,
      parameters = listOf(
        actParameters14,
        actParameters30,
        actParameters66,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "甘美な斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1030,
      parameters = listOf(
        actParameters30,
        actParameters66,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "致命の斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 1069,
      parameters = listOf(
        actParameters63,
        actParameters63,
        actParameters66,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "マカロン・ドリーム Encore",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1069,
      parameters = listOf(
        actParameters67,
        actParameters25,
        actParameters30,
        actParameters115,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 4200,
      actPower = 420,
      normalDefense = 180,
      specialDefense = 270,
      agility = 60,
    ),
    StatData(
      hp = 7000,
      actPower = 700,
      normalDefense = 300,
      specialDefense = 450,
      agility = 100,
    ),
    StatData(
      hp = 11200,
      actPower = 1120,
      normalDefense = 480,
      specialDefense = 720,
      agility = 160,
    ),
    StatData(
      hp = 14000,
      actPower = 1400,
      normalDefense = 600,
      specialDefense = 900,
      agility = 200,
    ),
  ),
)
