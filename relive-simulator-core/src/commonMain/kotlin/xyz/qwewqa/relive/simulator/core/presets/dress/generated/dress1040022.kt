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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040022
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040022(
    name = "カプリコーン",
    acts = listOf(
        ActType.Act1.blueprint("希望の斬撃") {
            Act {
                /*
                希望
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                回数マイナス効果耐性アップ(%value%) (解除不可)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("活力の斬撃") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1

                field_effects:
                  黄金の活力 (value: 1, time: 2, target: allies)
                  雷鳴 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("煌めく斬撃") {
            Act {
                /*
                AP減少2
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                キラめき回復(%value%)
                  target: 前から2体の味方
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [0, 0, 0, 0, 0]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [1, 1, 1, 1, 1]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  百発百中、一発必中 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("牧神パーンの笛") {
            Act {
                /*
                AP減少 (解除不可)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                回数マイナス効果解除
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                錯乱
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [197, 210, 220, 230, 240]
                  times5: 3

                field_effects:
                  黄金の活力 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                  凶変 (value: 1, time: 2, target: enemies)
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
          祝福[AP減少2]
            target: 味方全体
            hit_rate: 100
            value: 1
            time: 1
          無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
            target: 味方の氷雨とひかりとつかさ
            hit_rate: 100
            value: 100
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 50
            time: 0
          ACTパワーアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          回数マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          災難[キラめき減少](%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 1

          field_effects:
            甘き堕落 (value: 1, time: 2, target: enemies)
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
          AP減少2
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
          キラめき獲得アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 3

          field_effects:
            電光影裏 (value: 1, time: 6, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 4:
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress1040022 = PartialDressBlueprint(
  id = 1040022,
  name = "カプリコーン",
  baseRarity = 4,
  cost = 23,
  character = Character.Claudine,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14100,
    actPower = 900,
    normalDefense = 1170,
    specialDefense = 550,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 86700,
    actPower = 5900,
    normalDefense = 3800,
    specialDefense = 2900,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "希望の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1044,
      parameters = listOf(
        actParameters14,
        actParameters62,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "活力の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1057,
      parameters = listOf(
        actParameters30,
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "煌めく斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 1035,
      parameters = listOf(
        actParameters14,
        actParameters175,
        actParameters59,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "牧神パーンの笛",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1064,
      parameters = listOf(
        actParameters14,
        actParameters30,
        actParameters30,
        actParameters25,
        actParameters176,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard2,
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
