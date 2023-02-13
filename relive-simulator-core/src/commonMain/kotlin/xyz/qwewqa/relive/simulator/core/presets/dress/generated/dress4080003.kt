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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4080003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4080003(
    name = "聖ニコラス",
    acts = listOf(
        ActType.Act1.blueprint("善行を積む") {
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
        ActType.Act2.blueprint("訓戒と施し") {
            Act {
                /*
                変換[回数マイナス効果→起死回生](%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [2, 2, 2, 2, 2]
                  times1: [0, 0, 0, 0, 0]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
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
        ActType.Act3.blueprint("逆転の一閃") {
            Act {
                /*
                変換[回数マイナス効果→起死回生](%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [2, 2, 2, 2, 2]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [131, 137, 143, 150, 157]
                  times2: 1
                AP増加
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("聖夜の祈り") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                変換[回数マイナス効果→起死回生](%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [0, 0, 0, 0, 0]
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
                錯乱
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [1, 1, 1, 1, 1]

                field_effects:
                  幸福の足音 (value: 1, time: 2, target: allies)
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
          祝福[HP回復](%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
          継続マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1
          スタン耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
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
          恋わずらい
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 4:
          ACTパワーアップ(開幕時味方の舞台上にいる月・宙・雲属性舞台少女1体につき%value%) (最大120％)
            target: 味方の月・宙・雲属性
            values: [30, 30, 30, 30, 30]
          ACTパワーアップ(開幕時味方の舞台上にいる月・宙・雲属性舞台少女1体につき%value%) (最大120％)
            target: 自身
            values: [30, 30, 30, 30, 30]
        */
        ),
    ),
    unitSkill = null /* 月・宙・雲の舞台少女のACTパワーアップ %opt1_value%%(MAX25%) クリティカル威力アップ %opt2_value%%(MAX25%)
自身のACTパワーアップ %opt3_value%%(MAX25%) クリティカル威力アップ %opt4_value%%(MAX25%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress4080003 = PartialDressBlueprint(
  id = 4080003,
  name = "聖ニコラス",
  baseRarity = 4,
  cost = 23,
  character = Character.Ryoko,
  attribute = Attribute.Star,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10600,
    actPower = 1120,
    normalDefense = 420,
    specialDefense = 820,
    agility = 490,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 68000,
    actPower = 6290,
    normalDefense = 2100,
    specialDefense = 3180,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "善行を積む",
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
      name = "訓戒と施し",
      type = ActType.Act2,
      apCost = 2,
      icon = 274,
      parameters = listOf(
        actParameters72,
        actParameters14,
        actParameters44,
        actParameters151,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "逆転の一閃",
      type = ActType.Act3,
      apCost = 2,
      icon = 295,
      parameters = listOf(
        actParameters72,
        actParameters239,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "聖夜の祈り",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 295,
      parameters = listOf(
        actParameters67,
        actParameters72,
        actParameters72,
        actParameters264,
        actParameters25,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard10,
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
