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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress5010006(
    name = "マリー・アントワネット",
    acts = listOf(
        ActType.Act1.blueprint("制圧の斬撃") {
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

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("優雅な斬撃") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [131, 137, 143, 150, 157]
                  times2: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("吸光の斬撃") {
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
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [131, 137, 143, 150, 157]
                  times3: 1
                キラめき吸収(%value%)
                  target: 後ろから2体の敵役
                  hit_rate4: 100
                  values4: [100, 100, 100, 100, 100]
                  times4: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("気高きばら") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                祝福[回数マイナス効果減少](%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [1, 1, 1, 1, 1]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [225, 236, 247, 258, 270]
                  times4: [3, 3, 3, 3, 3]
                錯乱
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [1, 1, 1, 1, 1]

                field_effects:
                  神授の力 (value: 1, time: 2, target: allies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
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
            target: 自身
            hit_rate: 100
            value: 50
            time: 1
          退場回避 (発動時に効果解除)
            target: 自身
            hit_rate: 100
            value: 0
            time: 3
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          回数マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 2:
          慢心(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 3000
            time: 1
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 0
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          祝福[回数マイナス効果減少](%value%)
            target: 味方全体
            hit_rate: 100
            value: 2
            time: 1
          祝福[HP回復](%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 1
          災難[キラめき減少](%value%)
            target: 前から1番目の敵役
            hit_rate: 100
            value: 100
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 4:
          ACTパワーアップ(開幕時味方の舞台上にいる花・風・雪属性舞台少女1体につき%value%) (最大120％)
            target: 自身
            values: [30, 30, 30, 30, 30]
          ACTパワーアップ(開幕時味方の舞台上にいる花・風・雪属性舞台少女1体につき%value%) (最大120％)
            target: 味方の花・風・雪属性
            values: [30, 30, 30, 30, 30]
        */
        ),
    ),
    unitSkill = null /* 花・風・雪の舞台少女のACTパワーアップ %opt1_value%%(MAX25%) クリティカル威力アップ %opt2_value%%(MAX25%)
自身のACTパワーアップ %opt3_value%%(MAX25%) クリティカル威力アップ %opt4_value%%(MAX25%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress5010006 = PartialDressBlueprint(
  id = 5010006,
  name = "マリー・アントワネット",
  baseRarity = 4,
  cost = 20,
  character = Character.Koharu,
  attribute = Attribute.Sun,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 13600,
    actPower = 935,
    normalDefense = 450,
    specialDefense = 715,
    agility = 450,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 66000,
    actPower = 5280,
    normalDefense = 2250,
    specialDefense = 2750,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "制圧の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1046,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "優雅な斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters14,
        actParameters239,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "吸光の斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 274,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters239,
        actParameters151,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "気高きばら",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1050,
      parameters = listOf(
        actParameters67,
        actParameters114,
        actParameters72,
        actParameters264,
        actParameters25,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard11,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 12000,
      actPower = 330,
      normalDefense = 180,
      specialDefense = 390,
      agility = 60,
    ),
    StatData(
      hp = 20000,
      actPower = 550,
      normalDefense = 300,
      specialDefense = 650,
      agility = 100,
    ),
    StatData(
      hp = 32000,
      actPower = 880,
      normalDefense = 480,
      specialDefense = 1040,
      agility = 160,
    ),
    StatData(
      hp = 40000,
      actPower = 1100,
      normalDefense = 600,
      specialDefense = 1300,
      agility = 200,
    ),
  ),
)
