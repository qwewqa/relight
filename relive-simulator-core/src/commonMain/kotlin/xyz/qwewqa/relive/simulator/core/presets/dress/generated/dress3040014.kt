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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3040014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3040014(
    name = "弁財天",
    acts = listOf(
        ActType.Act1.blueprint("魅了の一閃") {
            Act {
                /*
                AP減少
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [170, 180, 190, 200, 210]
                  times4: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("捕縛の一閃") {
            Act {
                /*
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [3, 3, 3, 3, 3]
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [2, 2, 2, 2, 2]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [170, 180, 190, 200, 210]
                  times4: 1

                field_effects:
                  拍手喝采（花） (value: 1, time: 6, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("渦巻く一閃") {
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
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                回数プラス効果減少(%value%)
                  target: 後ろから2体の敵役
                  hit_rate4: 100
                  values4: [2, 2, 2, 2, 2]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate5: 100
                  values5: [170, 180, 190, 200, 210]
                  times5: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("出航！宝船") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                殉葬
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                変換[起死回生→急所](%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [1, 1, 1, 1, 1]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率で慢心を1回付与(聖翔音楽学園の敵役に特攻))
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate5: 100
                  values5: [450, 460, 470, 480, 500]
                  times5: [10, 10, 10, 10, 10]
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
            time: 2
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
          継続マイナス効果耐性アップ(%value%)
            target: 味方の花属性
            hit_rate: 100
            value: 100
            time: 3
          AP減少2
            target: 味方の花属性
            hit_rate: 100
            value: 0
            time: 1
          錯乱耐性アップ(%value%) (解除不可)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 3

          field_effects:
            遅疑逡巡 (value: 1, time: 2, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 3:
          誓いのレヴュー特攻(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
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
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val _dress3040014 = PartialDressBlueprint(
  id = 3040014,
  name = "弁財天",
  baseRarity = 4,
  cost = 23,
  character = Character.Tsukasa,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10700,
    actPower = 1120,
    normalDefense = 430,
    specialDefense = 840,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 68200,
    actPower = 6300,
    normalDefense = 2100,
    specialDefense = 3180,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "魅了の一閃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(2, 2, 2, 2, 2),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(2, 2, 2, 2, 2),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(170, 180, 190, 200, 210),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "捕縛の一閃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1036,
      parameters = listOf(
        ActParameters(
          values = listOf(100, 100, 100, 100, 100),
          times = listOf(3, 3, 3, 3, 3),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(2, 2, 2, 2, 2),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(170, 180, 190, 200, 210),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "渦巻く一閃",
      type = ActType.Act3,
      apCost = 2,
      icon = 1026,
      parameters = listOf(
        ActParameters(
          values = listOf(30, 30, 30, 30, 30),
          times = listOf(3, 3, 3, 3, 3),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(30, 30, 30, 30, 30),
          times = listOf(3, 3, 3, 3, 3),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(2, 2, 2, 2, 2),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(170, 180, 190, 200, 210),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "出航！宝船",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 287,
      parameters = listOf(
        ActParameters(
          values = listOf(50, 50, 50, 50, 50),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(1, 1, 1, 1, 1),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(450, 460, 470, 480, 500),
          times = listOf(10, 10, 10, 10, 10),
          hitRate = 100,
        ),
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = listOf(
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 1),
      StatBoost(StatBoostType.ActPower, 1),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.NormalDefense, 1),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 1),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Hp, 2),
    ),
    listOf(
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 7),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 3),
      StatBoost(StatBoostType.Act1Level, 0),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 3),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.Hp, 3),
      StatBoost(StatBoostType.ActPower, 3),
      StatBoost(StatBoostType.SpecialDefense, 5),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Hp, 4),
    ),
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 3),
      StatBoost(StatBoostType.NormalDefense, 7),
      StatBoost(StatBoostType.Hp, 4),
      StatBoost(StatBoostType.Agility, 8),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 4),
      StatBoost(StatBoostType.NormalDefense, 3),
      StatBoost(StatBoostType.Act1Level, 0),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 4),
      StatBoost(StatBoostType.Act1Level, 0),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.SpecialDefense, 8),
      StatBoost(StatBoostType.ActPower, 5),
      StatBoost(StatBoostType.NormalDefense, 4),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Hp, 5),
    ),
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 5),
      StatBoost(StatBoostType.NormalDefense, 8),
      StatBoost(StatBoostType.SpecialDefense, 5),
      StatBoost(StatBoostType.Agility, 9),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 5),
      StatBoost(StatBoostType.NormalDefense, 8),
      StatBoost(StatBoostType.Hp, 5),
    ),
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.Agility, 11),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Act1Level, 0),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.SpecialDefense, 6),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
    ),
  ),
  friendshipPanels = listOf(
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 1),
      StatBoost(StatBoostType.Hp, 1),
      StatBoost(StatBoostType.NormalDefense, 1),
      StatBoost(StatBoostType.SpecialDefense, 1),
      StatBoost(StatBoostType.Agility, 1),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 1),
      StatBoost(StatBoostType.Hp, 1),
      StatBoost(StatBoostType.NormalDefense, 1),
      StatBoost(StatBoostType.SpecialDefense, 1),
      StatBoost(StatBoostType.Agility, 1),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 1),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
  ),
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
