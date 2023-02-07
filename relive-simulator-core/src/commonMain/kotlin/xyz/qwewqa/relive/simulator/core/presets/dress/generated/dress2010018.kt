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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2010018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2010018(
    name = "ペルセポネー",
    acts = listOf(
        ActType.Act1.blueprint("冥府の掟") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1

                field_effects:
                  死の口づけ (value: 1, time: 3, target: enemies)
                  雷鳴 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("冥府の安寧") {
            Act {
                /*
                継続プラス効果解除
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                慢心(%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [3000, 3500, 4000, 4500, 5000]
                  times2: [1, 1, 1, 1, 1]
                災難[AP増加]
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate4: 100
                  values4: [165, 173, 181, 189, 198]
                  times4: 1
                */
            }
        },
        ActType.Act3.blueprint("冥府の静寂") {
            Act {
                /*
                AP減少 (解除不可)
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1

                field_effects:
                  黄金の活力 (value: 1, time: 2, target: allies)
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("数奇な運命") {
            Act {
                /*
                回数マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                慢心(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [3000, 3500, 4000, 4500, 5000]
                  times2: [1, 1, 1, 1, 1]
                変換[起死回生→急所](%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [200, 210, 220, 230, 240]
                  times4: 3

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 100
            time: 0
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
          AP減少2
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          回数マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          慢心(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 3000
            time: 1
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 50
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          祝福[希望](%value%)
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
            威風凛々 (value: 1, time: 2, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 4:
          継続マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
          回数マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress2010018 = PartialDressBlueprint(
  id = 2010018,
  name = "ペルセポネー",
  baseRarity = 4,
  cost = 23,
  character = Character.Tamao,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14300,
    actPower = 880,
    normalDefense = 1160,
    specialDefense = 560,
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
      name = "冥府の掟",
      type = ActType.Act1,
      apCost = 2,
      icon = 1024,
      parameters = listOf(
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "冥府の安寧",
      type = ActType.Act2,
      apCost = 2,
      icon = 237,
      parameters = listOf(
        actParameters30,
        actParameters58,
        actParameters113,
        actParameters44,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "冥府の静寂",
      type = ActType.Act3,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        actParameters14,
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "数奇な運命",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 287,
      parameters = listOf(
        actParameters30,
        actParameters58,
        actParameters108,
        actParameters57,
        actParameters1,
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
