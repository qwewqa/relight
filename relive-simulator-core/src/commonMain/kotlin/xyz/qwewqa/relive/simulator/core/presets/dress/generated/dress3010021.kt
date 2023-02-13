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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010021(
    name = "コーデリア",
    acts = listOf(
        ActType.Act1.blueprint("必中の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [3, 3, 3, 3, 3]
                AP減少
                  target: 味方全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]

                field_effects:
                  百発百中、一発必中 (Lv2で付与) (value: 2, time: 2, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("魅了の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                キラめき減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [0, 0, 0, 0, 0]
                AP増加
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                希望
                  target: 味方全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [1, 1, 1, 1, 1]

                field_effects:
                  魅惑の瞳 (Lv2で付与) (value: 2, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("雷鳴の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 30, 30, 30, 30]
                  times2: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [30, 30, 30, 30, 30]
                  times3: [3, 3, 3, 3, 3]

                field_effects:
                  雷鳴 (Lv2で付与) (value: 2, time: 2, target: enemies)
                  拍手喝采（宙） (Lv2で付与) (value: 2, time: 6, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("トイズ～ハイパーセンシティブ～") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                回数プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率で慢心(5000)を1回付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate5: 100
                  values5: [450, 460, 470, 480, 500]
                  times5: [10, 10, 10, 10, 10]

                field_effects:
                  百発百中、一発必中 (value: 1, time: 2, target: allies)
                  拍手喝采（宙） (value: 1, time: 6, target: allies)
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
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          祝福[有利属性ダメージアップ](%value%)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 0

          field_effects:
            拍手喝采（宙） (value: 1, time: 2, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 2:
          クリティカル率アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          AP減少
            target: 味方の宙属性
            hit_rate: 100
            value: 0
            time: 2

          field_effects:
            百発百中、一発必中 (value: 1, time: 2, target: allies)
        */
        ),
        listOf(
        /*
        auto skill 3:
          ACTパワーアップ(開幕時味方の舞台上にいる宙属性舞台少女1体につき%value%) (最大100％)
            target: 味方の宙属性
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 4:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
          回数マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
        */
        ),
    ),
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress3010021 = PartialDressBlueprint(
  id = 3010021,
  name = "コーデリア",
  baseRarity = 4,
  cost = 23,
  character = Character.Aruru,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14300,
    actPower = 880,
    normalDefense = 560,
    specialDefense = 1160,
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
      name = "必中の狙撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1035,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters53,
        actParameters14,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "魅了の狙撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1044,
      parameters = listOf(
        actParameters44,
        actParameters71,
        actParameters14,
        actParameters25,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "雷鳴の狙撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1012,
      parameters = listOf(
        actParameters44,
        actParameters63,
        actParameters63,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "トイズ～ハイパーセンシティブ～",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1035,
      parameters = listOf(
        actParameters149,
        actParameters14,
        actParameters30,
        actParameters30,
        actParameters241,
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
