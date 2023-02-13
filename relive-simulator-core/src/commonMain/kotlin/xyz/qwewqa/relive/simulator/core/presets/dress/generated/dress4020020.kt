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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4020020(
    name = "ドロシー",
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
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [170, 180, 190, 200, 210]
                  times4: 1

                field_effects:
                  灰色の世界 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("致命の斬撃") {
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
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate4: 100
                  values4: [2, 2, 2, 2, 2]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate5: 100
                  values5: [170, 180, 190, 200, 210]
                  times5: 1

                field_effects:
                  百花繚乱 (Lv2で付与) (value: 2, time: 2, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("支援の斬撃") {
            Act {
                /*
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [170, 180, 190, 200, 210]
                  times3: 1
                エール(%value%)
                  target: 味方の次のACT実行者
                  hit_rate4: 100
                  values4: [100, 100, 100, 100, 100]
                  times4: [1, 1, 1, 1, 1]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate5: 100
                  values5: [100, 100, 100, 100, 100]
                  times5: [3, 3, 3, 3, 3]

                field_effects:
                  拍手喝采（月） (Lv2で付与) (value: 2, time: 6, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("はじまりの竜巻") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                変換[起死回生→急所](%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                回数プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率で慢心を1回付与(聖翔音楽学園の敵役に特攻))
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate5: 100
                  values5: [450, 460, 470, 480, 500]
                  times5: [10, 10, 10, 10, 10]

                field_effects:
                  灰色の世界 (value: 1, time: 2, target: enemies)
                  プラス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
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
          祝福[有利属性ダメージアップ](%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 0

          field_effects:
            拍手喝采（月） (value: 1, time: 2, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 2:
          クリティカル率アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          継続マイナス効果耐性アップ(%value%)
            target: 味方の月属性
            hit_rate: 100
            value: 100
            time: 3
          AP減少2
            target: 味方の月属性
            hit_rate: 100
            value: 0
            time: 1
          錯乱耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 3

          field_effects:
            遅疑逡巡 (value: 1, time: 2, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 3:
          誓いのレヴュー特攻(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
        listOf(
        /*
        auto skill 4:
          ACTパワーアップ(%value%) (自身のHPが最大時に発動)
            target: 自身
            values: [100, 100, 100, 100, 100]
          毎ターンHP回復(%value%)
            target: 自身
            values: [20000, 20000, 20000, 20000, 20000]
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4020020 = PartialDressBlueprint(
  id = 4020020,
  name = "ドロシー",
  baseRarity = 4,
  cost = 23,
  character = Character.Michiru,
  attribute = Attribute.Moon,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10700,
    actPower = 1130,
    normalDefense = 815,
    specialDefense = 425,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 68200,
    actPower = 6300,
    normalDefense = 3180,
    specialDefense = 2100,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "軽快な斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1076,
      parameters = listOf(
        actParameters14,
        actParameters30,
        actParameters72,
        actParameters66,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "致命の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1026,
      parameters = listOf(
        actParameters63,
        actParameters63,
        actParameters30,
        actParameters72,
        actParameters66,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "支援の斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1039,
      parameters = listOf(
        actParameters30,
        actParameters72,
        actParameters66,
        actParameters64,
        actParameters53,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "はじまりの竜巻",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1076,
      parameters = listOf(
        actParameters149,
        actParameters14,
        actParameters72,
        actParameters30,
        actParameters241,
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
      normalDefense = 270,
      specialDefense = 180,
      agility = 60,
    ),
    StatData(
      hp = 7000,
      actPower = 700,
      normalDefense = 450,
      specialDefense = 300,
      agility = 100,
    ),
    StatData(
      hp = 11200,
      actPower = 1120,
      normalDefense = 720,
      specialDefense = 480,
      agility = 160,
    ),
    StatData(
      hp = 14000,
      actPower = 1400,
      normalDefense = 900,
      specialDefense = 600,
      agility = 200,
    ),
  ),
)
