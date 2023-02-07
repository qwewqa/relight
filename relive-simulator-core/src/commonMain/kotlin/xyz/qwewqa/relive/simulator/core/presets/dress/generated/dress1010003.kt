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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1010003(
    name = "銃士ダルタニャン",
    acts = listOf(
        ActType.Act1.blueprint("斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("渾身の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 142, 149, 155]
                  times1: 1
                */
            }
        },
        ActType.Act3.blueprint("柔和の独奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [132, 138, 145, 151, 158]
                  times1: 1
                通常防御力ダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [9, 10, 11, 12, 13]
                  times2: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate3: 100
                  values3: [9, 10, 11, 12, 13]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("希望の乱舞") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [123, 129, 135, 141, 147]
                  times1: 1
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
            values: [4, 4, 5, 5, 6]
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
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1010003 = PartialDressBlueprint(
  id = 1010003,
  name = "銃士ダルタニャン",
  baseRarity = 4,
  cost = 12,
  character = Character.Karen,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 14048,
  stats = StatData(
    hp = 1007,
    actPower = 156,
    normalDefense = 74,
    specialDefense = 78,
    agility = 165,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 33180,
    actPower = 2580,
    normalDefense = 1220,
    specialDefense = 1290,
    agility = 2730,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "斬撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "渾身の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters10,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "柔和の独奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 11,
      parameters = listOf(
        actParameters7,
        actParameters11,
        actParameters11,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "希望の乱舞",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 10002,
      parameters = listOf(
        actParameters12,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard1,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 10500,
      actPower = 330,
      normalDefense = 450,
      specialDefense = 150,
      agility = 120,
    ),
    StatData(
      hp = 17500,
      actPower = 550,
      normalDefense = 750,
      specialDefense = 250,
      agility = 200,
    ),
    StatData(
      hp = 28000,
      actPower = 880,
      normalDefense = 1200,
      specialDefense = 400,
      agility = 320,
    ),
    StatData(
      hp = 35000,
      actPower = 1100,
      normalDefense = 1500,
      specialDefense = 500,
      agility = 400,
    ),
  ),
)
