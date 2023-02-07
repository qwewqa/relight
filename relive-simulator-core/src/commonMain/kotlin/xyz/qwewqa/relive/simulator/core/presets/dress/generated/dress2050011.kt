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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050011
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2050011(
    name = "ジュリエット",
    acts = listOf(
        ActType.Act1.blueprint("愛の証明") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 3
                刻印
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act2.blueprint("愛の嘆き") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 2

                field_effects:
                  悲壮の奏 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("愛の暖かみ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [50, 50, 50, 50, 50]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("美しき悲劇") {
            Act {
                /*
                必中
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [200, 210, 220, 230, 240]
                  times2: 2
                錯乱
                  target: 立ち位置中の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                通常ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [2, 2, 2, 2, 2]
                特殊ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate5: 100
                  values5: [20, 22, 24, 27, 30]
                  times5: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方の凛明館女学校
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 3:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2050011 = PartialDressBlueprint(
  id = 2050011,
  name = "ジュリエット",
  baseRarity = 4,
  cost = 15,
  character = Character.Yuyuko,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 1962,
    actPower = 295,
    normalDefense = 98,
    specialDefense = 158,
    agility = 220,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 64630,
    actPower = 4880,
    normalDefense = 1620,
    specialDefense = 2610,
    agility = 3630,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "愛の証明",
      type = ActType.Act1,
      apCost = 2,
      icon = 150,
      parameters = listOf(
        actParameters223,
        actParameters14,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "愛の嘆き",
      type = ActType.Act2,
      apCost = 2,
      icon = 1025,
      parameters = listOf(
        actParameters56,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "愛の暖かみ",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters44,
        actParameters303,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "美しき悲劇",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 236,
      parameters = listOf(
        actParameters23,
        actParameters171,
        actParameters25,
        actParameters60,
        actParameters60,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 5100,
      actPower = 510,
      normalDefense = 90,
      specialDefense = 390,
      agility = 270,
    ),
    StatData(
      hp = 8500,
      actPower = 850,
      normalDefense = 150,
      specialDefense = 650,
      agility = 450,
    ),
    StatData(
      hp = 13600,
      actPower = 1360,
      normalDefense = 240,
      specialDefense = 1040,
      agility = 720,
    ),
    StatData(
      hp = 17000,
      actPower = 1700,
      normalDefense = 300,
      specialDefense = 1300,
      agility = 900,
    ),
  ),
)
