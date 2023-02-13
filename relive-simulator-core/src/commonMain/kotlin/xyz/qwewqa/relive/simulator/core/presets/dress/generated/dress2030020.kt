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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2030020(
    name = "紅き公爵リシュリュー",
    acts = listOf(
        ActType.Act1.blueprint("封印の斬撃") {
            Act {
                /*
                キラめき獲得アップ(%value%)
                  target: 前から2体の味方
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                ターゲット固定
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
                  target: 後ろから1番目の敵役
                  hit_rate5: 100
                  values5: [165, 173, 181, 189, 198]
                  times5: 1
                */
            }
        },
        ActType.Act2.blueprint("覚悟の斬撃") {
            Act {
                /*
                キラめき獲得アップ(%value%)
                  target: 前から2体の味方
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [2, 2, 2, 2, 2]
                ターゲット固定
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate5: 100
                  values5: [165, 173, 181, 189, 198]
                  times5: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("軽快な斬撃") {
            Act {
                /*
                キラめき獲得アップ(%value%)
                  target: 前から2体の味方
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                AP減少 (解除不可)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                ターゲット固定
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
                  心躍る芳醇 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("Flowers of Evil") {
            Act {
                /*
                不倒 (解除不可)
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [3, 3, 3, 3, 3]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [225, 234, 243, 252, 270]
                  times4: 3
                ターゲット固定 (解除不可)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [2, 2, 2, 2, 2]

                field_effects:
                  戦場掌握 (value: 1, time: 2, target: enemies)
                  昏迷の影 (value: 1, time: 2, target: enemies)
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
            time: 2
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
          継続マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          ターゲット固定 (解除不可)
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2

          field_effects:
            雷鳴 (value: 1, time: 2, target: enemies)
            幽世の試練 (value: 1, time: 2, target: enemies)
            戦場掌握 (Lv3で付与) (value: 3, time: 2, target: enemies)
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
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 0
          祝福[HP回復](%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1

          field_effects:
            黄金の活力 (value: 1, time: 6, target: allies)
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
          舞台効果付与封印耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
          最大HPアップ(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
    ),
    unitSkill = null /* 月・宙・雲の舞台少女のACTパワーアップ %opt1_value%%(MAX25%) クリティカル威力アップ %opt2_value%%(MAX25%)
自身のACTパワーアップ %opt3_value%%(MAX25%) クリティカル威力アップ %opt4_value%%(MAX25%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2030020 = PartialDressBlueprint(
  id = 2030020,
  name = "紅き公爵リシュリュー",
  baseRarity = 4,
  cost = 23,
  character = Character.Fumi,
  attribute = Attribute.Star,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 18700,
    actPower = 840,
    normalDefense = 700,
    specialDefense = 1450,
    agility = 560,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 135500,
    actPower = 2600,
    normalDefense = 4290,
    specialDefense = 5080,
    agility = 5200,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "封印の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 271,
      parameters = listOf(
        actParameters149,
        actParameters30,
        actParameters14,
        actParameters14,
        actParameters44,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "覚悟の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 152,
      parameters = listOf(
        actParameters149,
        actParameters30,
        actParameters62,
        actParameters14,
        actParameters44,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "軽快な斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1054,
      parameters = listOf(
        actParameters149,
        actParameters14,
        actParameters14,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Flowers of Evil",
      type = ActType.ClimaxAct,
      apCost = 1,
      icon = 1074,
      parameters = listOf(
        actParameters14,
        actParameters63,
        actParameters30,
        actParameters289,
        actParameters14,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard9,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 15000,
      actPower = 480,
      normalDefense = 330,
      specialDefense = 540,
      agility = 60,
    ),
    StatData(
      hp = 25000,
      actPower = 800,
      normalDefense = 550,
      specialDefense = 900,
      agility = 100,
    ),
    StatData(
      hp = 40000,
      actPower = 1280,
      normalDefense = 880,
      specialDefense = 1440,
      agility = 160,
    ),
    StatData(
      hp = 50000,
      actPower = 1600,
      normalDefense = 1100,
      specialDefense = 1800,
      agility = 200,
    ),
  ),
)
