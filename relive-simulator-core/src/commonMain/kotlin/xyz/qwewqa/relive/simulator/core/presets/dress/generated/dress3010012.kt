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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010012
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010012(
    name = "イニシャル ドラム",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの重奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                キラめき回復(%value%)
                  target: 後ろから2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("浄化の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("聖域の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果耐性アップ(%value%)
                  target: 前から3体の味方
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("夢重ねるビート") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
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
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          混乱耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          ストップ耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3010012 = PartialDressBlueprint(
  id = 3010012,
  name = "イニシャル ドラム",
  baseRarity = 4,
  cost = 12,
  character = Character.Aruru,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34051,
  stats = StatData(
    hp = 1340,
    actPower = 158,
    normalDefense = 54,
    specialDefense = 100,
    agility = 182,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 44160,
    actPower = 2600,
    normalDefense = 900,
    specialDefense = 1650,
    agility = 3000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの重奏",
      type = ActType.Act1,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters2,
        actParameters50,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "浄化の狙撃",
      type = ActType.Act2,
      apCost = 3,
      icon = 10005,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "聖域の狙撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 26,
      parameters = listOf(
        actParameters44,
        actParameters53,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "夢重ねるビート",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters85,
        actParameters30,
        actParameters53,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 5400,
      actPower = 480,
      normalDefense = 120,
      specialDefense = 300,
      agility = 210,
    ),
    StatData(
      hp = 9000,
      actPower = 800,
      normalDefense = 200,
      specialDefense = 500,
      agility = 350,
    ),
    StatData(
      hp = 14400,
      actPower = 1280,
      normalDefense = 320,
      specialDefense = 800,
      agility = 560,
    ),
    StatData(
      hp = 18000,
      actPower = 1600,
      normalDefense = 400,
      specialDefense = 1000,
      agility = 700,
    ),
  ),
)
