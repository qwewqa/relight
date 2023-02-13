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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090021(
    name = "十二支 卯",
    acts = listOf(
        ActType.Act1.blueprint("煌めく一閃") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
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
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("吸収の一閃") {
            Act {
                /*
                回数マイナス効果減少(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [2, 2, 2, 2, 2]
                  times1: [0, 0, 0, 0, 0]
                回数マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1
                キラめき吸収(%value%)
                  target: 後ろから2体の敵役
                  hit_rate4: 100
                  values4: [100, 100, 100, 100, 100]
                  times4: [0, 0, 0, 0, 0]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("圧倒の一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [131, 137, 143, 150, 157]
                  times1: 1
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                圧倒
                  target: 敵役の次のACT実行者
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("始まりのジャンプ！") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                連続クライマックスACT化
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [225, 236, 247, 258, 270]
                  times4: 3
                慢心(%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [3000, 3500, 4000, 4500, 5000]
                  times5: [1, 1, 1, 1, 1]

                field_effects:
                  飛躍の誓い (value: 1, time: 2, target: allies)
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
            time: 2
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          祝福[継続マイナス効果解除]
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          祝福[HP回復](%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 0
          継続マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          舞台効果付与封印
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          回数マイナス効果耐性アップ(%value%)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
          回数マイナス効果耐性アップ(%value%)
            target: 味方全体
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
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
    ),
    unitSkill = null /* 花・風・雪の舞台少女のACTパワーアップ %opt1_value%%(MAX25%) クリティカル威力アップ %opt2_value%%(MAX25%)
自身のACTパワーアップ %opt3_value%%(MAX25%) クリティカル威力アップ %opt4_value%%(MAX25%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090021 = PartialDressBlueprint(
  id = 1090021,
  name = "十二支 卯",
  baseRarity = 4,
  cost = 23,
  character = Character.Kaoruko,
  attribute = Attribute.Sun,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14400,
    actPower = 870,
    normalDefense = 1150,
    specialDefense = 540,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 86800,
    actPower = 5950,
    normalDefense = 3800,
    specialDefense = 2900,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "煌めく一閃",
      type = ActType.Act1,
      apCost = 2,
      icon = 271,
      parameters = listOf(
        actParameters3,
        actParameters30,
        actParameters14,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "吸収の一閃",
      type = ActType.Act2,
      apCost = 2,
      icon = 274,
      parameters = listOf(
        actParameters72,
        actParameters53,
        actParameters44,
        actParameters151,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "圧倒の一閃",
      type = ActType.Act3,
      apCost = 2,
      icon = 297,
      parameters = listOf(
        actParameters239,
        actParameters14,
        actParameters25,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "始まりのジャンプ！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 298,
      parameters = listOf(
        actParameters149,
        actParameters14,
        actParameters72,
        actParameters264,
        actParameters58,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard8,
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
