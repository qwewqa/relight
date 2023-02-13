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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010026
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1010026(
    name = "ネロ",
    acts = listOf(
        ActType.Act1.blueprint("封印の斬撃") {
            Act {
                /*
                回数マイナス効果減少(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [1, 1, 1, 1, 1]
                  times1: [0, 0, 0, 0, 0]
                希望
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("重圧の斬撃") {
            Act {
                /*
                不屈
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                AP増加 (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate5: 100
                  values5: [165, 173, 181, 189, 198]
                  times5: 1
                */
            }
        },
        ActType.Act3.blueprint("活力の斬撃") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 前から2体の味方
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                キラめき減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [30, 30, 30, 30, 30]
                  times3: [0, 0, 0, 0, 0]
                キラめき獲得ダウン(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [100, 100, 100, 100, 100]
                  times4: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate5: 100
                  values5: [165, 173, 181, 189, 198]
                  times5: 1

                field_effects:
                  黄金の活力 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("トイズ～ダイレクトハック～") {
            Act {
                /*
                全回数プラス効果数増加(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [2, 2, 2, 2, 2]
                  times1: [0, 0, 0, 0, 0]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                錯乱
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%) (陽属性および星属性の敵役に特攻)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [200, 210, 220, 230, 240]
                  times5: [3, 3, 3, 3, 3]

                field_effects:
                  トキメキ発見 (value: 1, time: 2, target: allies)
                  甘き堕落 (value: 1, time: 2, target: enemies)
                  雷鳴 (value: 1, time: 2, target: enemies)
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
          AP減少2 (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 0
          回数マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
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
          カットインスキル封印
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
          継続マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          祝福[HP回復](%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1
          祝福[回数マイナス効果減少](%value%)
            target: 味方全体
            hit_rate: 100
            value: 1
            time: 1
          祝福[AP減少2]
            target: 味方全体
            hit_rate: 100
            value: 2
            time: 1

          field_effects:
            心躍る芳醇 (value: 1, time: 2, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 4:
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
          毎ターン回数マイナス効果減少(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
          被ダメージダウン(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress1010026 = PartialDressBlueprint(
  id = 1010026,
  name = "ネロ",
  baseRarity = 4,
  cost = 23,
  character = Character.Karen,
  attribute = Attribute.Dream,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14300,
    actPower = 900,
    normalDefense = 560,
    specialDefense = 1170,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 87000,
    actPower = 5800,
    normalDefense = 2900,
    specialDefense = 3800,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "封印の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        actParameters59,
        actParameters25,
        actParameters44,
        actParameters14,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "重圧の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 271,
      parameters = listOf(
        actParameters25,
        actParameters30,
        actParameters14,
        actParameters14,
        actParameters44,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "活力の斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1057,
      parameters = listOf(
        actParameters67,
        actParameters30,
        actParameters71,
        actParameters64,
        actParameters44,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "トイズ～ダイレクトハック～",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1077,
      parameters = listOf(
        actParameters72,
        actParameters30,
        actParameters25,
        actParameters14,
        actParameters57,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9900,
      actPower = 510,
      normalDefense = 540,
      specialDefense = 600,
      agility = 60,
    ),
    StatData(
      hp = 16500,
      actPower = 850,
      normalDefense = 900,
      specialDefense = 1000,
      agility = 100,
    ),
    StatData(
      hp = 26400,
      actPower = 1360,
      normalDefense = 1440,
      specialDefense = 1600,
      agility = 160,
    ),
    StatData(
      hp = 33000,
      actPower = 1700,
      normalDefense = 1800,
      specialDefense = 2000,
      agility = 200,
    ),
  ),
)
