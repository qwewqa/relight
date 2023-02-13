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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3050016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3050016(
    name = "エルキュール",
    acts = listOf(
        ActType.Act1.blueprint("魅了の斬撃") {
            Act {
                /*
                希望
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                必中
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [30, 30, 30, 30, 30]
                  times3: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate5: 100
                  values5: [165, 173, 181, 189, 198]
                  times5: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("輝く斬撃") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [2, 2, 2, 2, 2]
                回数マイナス効果減少(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [1, 1, 1, 1, 1]
                  times2: [0, 0, 0, 0, 0]
                キラめき回復(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [40, 40, 40, 40, 40]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [2, 2, 2, 2, 2]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("軽快な斬撃") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [2, 2, 2, 2, 2]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [30, 30, 30, 30, 30]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  電光影裏 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("トイズ～トライアセンド～") {
            Act {
                /*
                不倒 (解除不可)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [2, 2, 2, 2, 2]
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [0, 0, 0, 0, 0]
                悶絶
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [260, 270, 280, 290, 300]
                  times5: [5, 5, 5, 5, 5]

                field_effects:
                  凶変 (value: 1, time: 2, target: enemies)
                  心躍る芳醇 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 100
            time: 1
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          無敵 (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          希望
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 3
          回数マイナス効果減少(%value%)
            target: 味方全体
            hit_rate: 100
            value: 1
            time: 0
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          毎ターンキラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          回数マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          急所
            target: 敵役全体
            hit_rate: 100
            value: 60
            time: 2
          災難[キラめき減少](%value%)
            target: 敵役全体
            hit_rate: 100
            value: 100
            time: 1
          災難[AP増加]
            target: 敵役全体
            hit_rate: 100
            value: 1
            time: 1
          慢心(%value%)
            target: 前から2体の敵役
            hit_rate: 100
            value: 3000
            time: 1

          field_effects:
            甘き堕落 (value: 1, time: 2, target: enemies)
            遅疑逡巡 (value: 1, time: 2, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 4:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
          毎ターン怪力付与(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3050016 = PartialDressBlueprint(
  id = 3050016,
  name = "エルキュール",
  baseRarity = 4,
  cost = 23,
  character = Character.Shizuha,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10600,
    actPower = 1120,
    normalDefense = 420,
    specialDefense = 820,
    agility = 521,
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
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "魅了の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1044,
      parameters = listOf(
        actParameters25,
        actParameters14,
        actParameters351,
        actParameters30,
        actParameters44,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "輝く斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1046,
      parameters = listOf(
        actParameters352,
        actParameters59,
        actParameters70,
        actParameters44,
        actParameters14,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "軽快な斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1009,
      parameters = listOf(
        actParameters14,
        actParameters351,
        actParameters351,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "トイズ～トライアセンド～",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 194,
      parameters = listOf(
        actParameters14,
        actParameters351,
        actParameters151,
        actParameters25,
        actParameters353,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard4,
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
