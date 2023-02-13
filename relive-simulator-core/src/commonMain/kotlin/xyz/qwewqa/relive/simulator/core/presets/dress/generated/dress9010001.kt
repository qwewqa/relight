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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress9010001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress9010001(
    name = "帝国華撃団・花組",
    acts = listOf(
        ActType.Act1.blueprint("祈りの剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                AP減少
                  target: 前から3体の味方
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("女神の剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("貫きの剣") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [54, 56, 59, 62, 64]
                  times3: 2
                */
            }
        },
        ActType.ClimaxAct.blueprint("破邪剣征・桜花放神") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 挑発・ターゲット固定を無視し、敵役全体
                  hit_rate1: 100
                  values1: [240, 250, 260, 270, 280]
                  times1: [3, 3, 3, 3, 3]
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
            value: 20
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
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
    unitSkill = null /* 風・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress9010001 = PartialDressBlueprint(
  id = 9010001,
  name = "帝国華撃団・花組",
  baseRarity = 4,
  cost = 15,
  character = Character.Sakura,
  attribute = Attribute.Wind,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 2448,
    actPower = 300,
    normalDefense = 161,
    specialDefense = 161,
    agility = 230,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 77000,
    actPower = 4960,
    normalDefense = 2660,
    specialDefense = 2660,
    agility = 3800,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "祈りの剣",
      type = ActType.Act1,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters46,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "女神の剣",
      type = ActType.Act2,
      apCost = 2,
      icon = 20,
      parameters = listOf(
        actParameters46,
        actParameters32,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "貫きの剣",
      type = ActType.Act3,
      apCost = 3,
      icon = 173,
      parameters = listOf(
        actParameters30,
        actParameters14,
        actParameters56,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "破邪剣征・桜花放神",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 198,
      parameters = listOf(
        actParameters374,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard6,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 3000,
      actPower = 510,
      normalDefense = 390,
      specialDefense = 90,
      agility = 240,
    ),
    StatData(
      hp = 5000,
      actPower = 850,
      normalDefense = 650,
      specialDefense = 150,
      agility = 400,
    ),
    StatData(
      hp = 8000,
      actPower = 1360,
      normalDefense = 1040,
      specialDefense = 240,
      agility = 640,
    ),
    StatData(
      hp = 10000,
      actPower = 1700,
      normalDefense = 1300,
      specialDefense = 300,
      agility = 800,
    ),
  ),
)
