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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090022
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090022(
    name = "叛逆の将 カタリーナ",
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
        ActType.Act2.blueprint("創造の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[特殊]の敵役に特攻)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [156, 163, 171, 178, 187]
                  times1: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("騎士団長の誓い") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                有利属性ダメージアップ(%value%)
                  target: 後ろから3体の味方
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("黒獅子の爪痕 Encore") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[特殊]の敵役に特攻)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [307, 323, 338, 353, 369]
                  times1: [2, 2, 2, 2, 2]
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
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 2:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 3:
          クリティカル率アップ(%value%)
            target: 自身
            values: [10, 10, 10, 10, 10]
        */
        ),
    ),
    unitSkill = null /* 自身のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090022 = PartialDressBlueprint(
  id = 1090022,
  name = "叛逆の将 カタリーナ",
  baseRarity = 4,
  cost = 13,
  character = Character.Kaoruko,
  attribute = Attribute.Wind,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 1511,
    actPower = 201,
    normalDefense = 164,
    specialDefense = 103,
    agility = 200,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 49770,
    actPower = 3310,
    normalDefense = 2700,
    specialDefense = 1710,
    agility = 3300,
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
      name = "創造の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 196,
      parameters = listOf(
        actParameters33,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "騎士団長の誓い",
      type = ActType.Act3,
      apCost = 2,
      icon = 39,
      parameters = listOf(
        actParameters44,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "黒獅子の爪痕 Encore",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 196,
      parameters = listOf(
        actParameters265,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 390,
      normalDefense = 570,
      specialDefense = 150,
      agility = 150,
    ),
    StatData(
      hp = 15000,
      actPower = 650,
      normalDefense = 950,
      specialDefense = 250,
      agility = 250,
    ),
    StatData(
      hp = 24000,
      actPower = 1040,
      normalDefense = 1520,
      specialDefense = 400,
      agility = 400,
    ),
    StatData(
      hp = 30000,
      actPower = 1300,
      normalDefense = 1900,
      specialDefense = 500,
      agility = 500,
    ),
  ),
)
