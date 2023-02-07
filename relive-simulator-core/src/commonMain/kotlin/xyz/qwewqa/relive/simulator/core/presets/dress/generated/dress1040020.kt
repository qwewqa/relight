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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040020(
    name = "オスカル",
    acts = listOf(
        ActType.Act1.blueprint("情熱の剣") {
            Act {
                /*
                祝福[回数マイナス効果減少](%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [1, 1, 1, 1, 1]
                  times1: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("高潔な剣") {
            Act {
                /*
                回避
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("美しき剣") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 後ろから5体の味方
                  hit_rate1: 100
                  values1: [60, 60, 60, 60, 60]
                  times1: [0, 0, 0, 0, 0]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("麗しきばら") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                キラめき減少(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [0, 0, 0, 0, 0]
                錯乱
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [200, 210, 220, 230, 240]
                  times4: 3

                field_effects:
                  散華のさだめ (value: 1, time: 2, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          AP減少2 (解除不可)
            target: 自身
            hit_rate: 100
            value: 0
            time: 2
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
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
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
        auto skill 4:
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%)\n立ち位置中の舞台少女のACTパワーアップ %opt3_value%%(MAX50%) クリティカル威力アップ %opt4_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1040020 = PartialDressBlueprint(
  id = 1040020,
  name = "オスカル",
  baseRarity = 4,
  cost = 20,
  character = Character.Claudine,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14848,
    actPower = 748,
    normalDefense = 990,
    specialDefense = 480,
    agility = 430,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 77000,
    actPower = 4950,
    normalDefense = 3300,
    specialDefense = 2520,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "情熱の剣",
      type = ActType.Act1,
      apCost = 2,
      icon = 1044,
      parameters = listOf(
        actParameters173,
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "高潔な剣",
      type = ActType.Act2,
      apCost = 3,
      icon = 1022,
      parameters = listOf(
        actParameters25,
        actParameters174,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "美しき剣",
      type = ActType.Act3,
      apCost = 4,
      icon = 89,
      parameters = listOf(
        actParameters175,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "麗しきばら",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 236,
      parameters = listOf(
        actParameters30,
        actParameters150,
        actParameters25,
        actParameters57,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 12000,
      actPower = 330,
      normalDefense = 390,
      specialDefense = 180,
      agility = 60,
    ),
    StatData(
      hp = 20000,
      actPower = 550,
      normalDefense = 650,
      specialDefense = 300,
      agility = 100,
    ),
    StatData(
      hp = 32000,
      actPower = 880,
      normalDefense = 1040,
      specialDefense = 480,
      agility = 160,
    ),
    StatData(
      hp = 40000,
      actPower = 1100,
      normalDefense = 1300,
      specialDefense = 600,
      agility = 200,
    ),
  ),
)
