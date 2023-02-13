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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030026
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030026(
    name = "アクエリアス",
    acts = listOf(
        ActType.Act1.blueprint("封印の打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("軽快な打撃") {
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
                  values3: [165, 173, 181, 189, 198]
                  times3: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("致命の打撃") {
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
                AP減少
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("美しき奔流") {
            Act {
                /*
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [3, 3, 3, 3, 3]
                  times2: [0, 0, 0, 0, 0]
                回数マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                慢心(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [3000, 3500, 4000, 4500, 5000]
                  times4: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [200, 210, 220, 230, 240]
                  times5: 3

                field_effects:
                  風雅なる誘い (value: 1, time: 2, target: allies)
                  行雲流水 (value: 1, time: 2, target: allies)
                  キラめきの潮流 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  天体ハイライト (value: 1, time: 2, target: enemies)
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
            time: 2
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          AP減少 (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
            target: 味方の文とミチル
            hit_rate: 100
            value: 100
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 30
            time: 0
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
          祝福[継続マイナス効果解除]
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          キラめき獲得アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 3

          field_effects:
            電光影裏 (value: 1, time: 2, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 0
          継続マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          スタン
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2

          field_effects:
            深淵なる謀 (value: 1, time: 2, target: enemies)
            遅疑逡巡 (value: 1, time: 2, target: enemies)
            マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果3) (value: 1, time: 1, target: allies)
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
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress1030026 = PartialDressBlueprint(
  id = 1030026,
  name = "アクエリアス",
  baseRarity = 4,
  cost = 23,
  character = Character.Mahiru,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14400,
    actPower = 890,
    normalDefense = 1150,
    specialDefense = 555,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 87000,
    actPower = 5800,
    normalDefense = 3800,
    specialDefense = 2900,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "封印の打撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 271,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "軽快な打撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters14,
        actParameters30,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "致命の打撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 39,
      parameters = listOf(
        actParameters63,
        actParameters63,
        actParameters14,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "美しき奔流",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1071,
      parameters = listOf(
        actParameters151,
        actParameters68,
        actParameters30,
        actParameters58,
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
      normalDefense = 600,
      specialDefense = 540,
      agility = 60,
    ),
    StatData(
      hp = 16500,
      actPower = 850,
      normalDefense = 1000,
      specialDefense = 900,
      agility = 100,
    ),
    StatData(
      hp = 26400,
      actPower = 1360,
      normalDefense = 1600,
      specialDefense = 1440,
      agility = 160,
    ),
    StatData(
      hp = 33000,
      actPower = 1700,
      normalDefense = 2000,
      specialDefense = 1800,
      agility = 200,
    ),
  ),
)
