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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3050015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3050015(
    name = "ギルガメッシュ",
    acts = listOf(
        ActType.Act1.blueprint("王の城壁") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果3) (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("王の雄姿") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [10, 10, 10, 10, 10]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("永遠の命") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [1, 1, 1, 1, 1]
                  times2: [0, 0, 0, 0, 0]

                field_effects:
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("ウルクの王") {
            Act {
                /*
                不倒
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                回数マイナス効果減少(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [2, 2, 2, 2, 2]
                  times2: [0, 0, 0, 0, 0]
                殉葬
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                起死回生減少(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [2, 2, 2, 2, 2]
                  times4: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [200, 210, 220, 230, 240]
                  times5: 3

                field_effects:
                  神々の黄昏 (value: 1, time: 2, target: enemies)
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
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            hit_rate: 100
            value: 100
            time: 2
          継続マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
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
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
          起死回生減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 1
            time: 0

          field_effects:
            深淵なる謀 (value: 1, time: 1, target: enemies)
        */
        ),
        listOf(
        /*
        auto skill 4:
          錯乱耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 100]
        */
        ),
    ),
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3050015 = PartialDressBlueprint(
  id = 3050015,
  name = "ギルガメッシュ",
  baseRarity = 4,
  cost = 23,
  character = Character.Shizuha,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10500,
    actPower = 1140,
    normalDefense = 440,
    specialDefense = 800,
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
      name = "王の城壁",
      type = ActType.Act1,
      apCost = 2,
      icon = 271,
      parameters = listOf(
        actParameters3,
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "王の雄姿",
      type = ActType.Act2,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        actParameters319,
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "永遠の命",
      type = ActType.Act3,
      apCost = 3,
      icon = 1044,
      parameters = listOf(
        actParameters44,
        actParameters59,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ウルクの王",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 289,
      parameters = listOf(
        actParameters25,
        actParameters108,
        actParameters25,
        actParameters108,
        actParameters57,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard3,
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
