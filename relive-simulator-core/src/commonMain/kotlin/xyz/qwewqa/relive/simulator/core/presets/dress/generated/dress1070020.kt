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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070020(
    name = "ジークフリート",
    acts = listOf(
        ActType.Act1.blueprint("宿望の剣") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
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

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("勇気の剣") {
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
                  values3: [165, 173, 181, 189, 198]
                  times3: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("悪を討つ剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [131, 137, 143, 150, 157]
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
                AP増加
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("愛のバルムンク") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                慢心耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [2, 2, 2, 2, 2]
                錯乱耐性アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [260, 270, 280, 290, 300]
                  times4: 8
                慢心(%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [3000, 3500, 4000, 4500, 5000]
                  times5: [1, 1, 1, 1, 1]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 50
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
        */
        ),
        listOf(
        /*
        auto skill 2:
          継続マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
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

val dress1070020 = PartialDressBlueprint(
  id = 1070020,
  name = "ジークフリート",
  baseRarity = 4,
  cost = 20,
  character = Character.Nana,
  attribute = Attribute.Star,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24060,
  stats = StatData(
    hp = 12000,
    actPower = 700,
    normalDefense = 900,
    specialDefense = 350,
    agility = 440,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 73000,
    actPower = 4600,
    normalDefense = 3200,
    specialDefense = 1900,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "宿望の剣",
      type = ActType.Act1,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters3,
        actParameters14,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "勇気の剣",
      type = ActType.Act2,
      apCost = 2,
      icon = 26,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "悪を討つ剣",
      type = ActType.Act3,
      apCost = 3,
      icon = 271,
      parameters = listOf(
        actParameters239,
        actParameters30,
        actParameters14,
        actParameters14,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "愛のバルムンク",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 237,
      parameters = listOf(
        actParameters67,
        actParameters62,
        actParameters62,
        actParameters240,
        actParameters58,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard7,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 7500,
      actPower = 330,
      normalDefense = 450,
      specialDefense = 450,
      agility = 60,
    ),
    StatData(
      hp = 12500,
      actPower = 550,
      normalDefense = 750,
      specialDefense = 750,
      agility = 100,
    ),
    StatData(
      hp = 20000,
      actPower = 880,
      normalDefense = 1200,
      specialDefense = 1200,
      agility = 160,
    ),
    StatData(
      hp = 25000,
      actPower = 1100,
      normalDefense = 1500,
      specialDefense = 1500,
      agility = 200,
    ),
  ),
)
