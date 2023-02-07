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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070015(
    name = "イザナギ",
    acts = listOf(
        ActType.Act1.blueprint("強斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("聖域の天命") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [97, 102, 106, 111, 116]
                  times1: 1
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("雲射る刃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                必中
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("イザナギの天地創造") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 3
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [40, 42, 44, 47, 50]
                  times2: [3, 3, 3, 3, 3]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [40, 42, 44, 47, 50]
                  times3: [3, 3, 3, 3, 3]
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [10000, 11000, 12000, 13000, 15000]
                  times4: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate5: 100
                  values5: [10000, 11000, 12000, 13000, 15000]
                  times5: [3, 3, 3, 3, 3]
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
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          クライマックスACT威力アップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
        listOf(
        /*
        auto skill 3:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 4:
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[通常]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1070015 = PartialDressBlueprint(
  id = 1070015,
  name = "イザナギ",
  baseRarity = 4,
  cost = 12,
  character = Character.Nana,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 938,
    actPower = 242,
    normalDefense = 80,
    specialDefense = 38,
    agility = 187,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 30910,
    actPower = 4000,
    normalDefense = 1320,
    specialDefense = 640,
    agility = 3080,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters96,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "聖域の天命",
      type = ActType.Act2,
      apCost = 2,
      icon = 26,
      parameters = listOf(
        actParameters28,
        actParameters53,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "雲射る刃",
      type = ActType.Act3,
      apCost = 2,
      icon = 35,
      parameters = listOf(
        actParameters44,
        actParameters23,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "イザナギの天地創造",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 20,
      parameters = listOf(
        actParameters26,
        actParameters111,
        actParameters111,
        actParameters234,
        actParameters234,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6900,
      actPower = 180,
      normalDefense = 300,
      specialDefense = 180,
      agility = 180,
    ),
    StatData(
      hp = 11500,
      actPower = 300,
      normalDefense = 500,
      specialDefense = 300,
      agility = 300,
    ),
    StatData(
      hp = 18400,
      actPower = 480,
      normalDefense = 800,
      specialDefense = 480,
      agility = 480,
    ),
    StatData(
      hp = 23000,
      actPower = 600,
      normalDefense = 1000,
      specialDefense = 600,
      agility = 600,
    ),
  ),
)
