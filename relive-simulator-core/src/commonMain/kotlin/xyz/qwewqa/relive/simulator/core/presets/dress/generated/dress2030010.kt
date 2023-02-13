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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2030010(
    name = "漂流者",
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
        ActType.Act2.blueprint("煌力の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("勝利の協奏曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("大物を狙え！") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[通常]の敵役に特攻)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [307, 323, 338, 353, 369]
                  times1: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
        listOf(
        /*
        auto skill 2:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2030010 = PartialDressBlueprint(
  id = 2030010,
  name = "漂流者",
  baseRarity = 4,
  cost = 12,
  character = Character.Fumi,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 963,
    actPower = 191,
    normalDefense = 50,
    specialDefense = 83,
    agility = 187,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 31720,
    actPower = 3150,
    normalDefense = 820,
    specialDefense = 1380,
    agility = 3090,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters98,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "煌力の斬撃",
      type = ActType.Act2,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters36,
        actParameters3,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "勝利の協奏曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 20,
      parameters = listOf(
        actParameters44,
        actParameters42,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "大物を狙え！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 195,
      parameters = listOf(
        actParameters287,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6900,
      actPower = 360,
      normalDefense = 150,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 11500,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 18400,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 23000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
