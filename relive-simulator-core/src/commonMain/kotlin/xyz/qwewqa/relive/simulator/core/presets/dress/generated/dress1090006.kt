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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090006(
    name = "猟犬レプラス",
    acts = listOf(
        ActType.Act1.blueprint("一閃") {
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
        ActType.Act2.blueprint("減光の独奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                キラめき獲得ダウン(%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [60, 65, 70, 75, 80]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("減光の協奏曲") {
            Act {
                /*
                キラめき獲得ダウン(%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [60, 65, 70, 75, 80]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("月夜の狩猟") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 3
                キラめき獲得ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [60, 65, 70, 75, 80]
                  times2: [2, 2, 2, 2, 2]
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
            values: [5, 6, 6, 7, 8]
        */
        ),
        listOf(
        /*
        auto skill 2:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          被ダメージダウン(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090006 = PartialDressBlueprint(
  id = 1090006,
  name = "猟犬レプラス",
  baseRarity = 4,
  cost = 12,
  character = Character.Kaoruko,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 32050,
  stats = StatData(
    hp = 944,
    actPower = 185,
    normalDefense = 77,
    specialDefense = 55,
    agility = 186,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 31100,
    actPower = 3050,
    normalDefense = 1280,
    specialDefense = 920,
    agility = 3070,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一閃",
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
      name = "減光の独奏",
      type = ActType.Act2,
      apCost = 3,
      icon = 192,
      parameters = listOf(
        actParameters44,
        actParameters258,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "減光の協奏曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 192,
      parameters = listOf(
        actParameters105,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "月夜の狩猟",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 192,
      parameters = listOf(
        actParameters26,
        actParameters105,
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
      actPower = 390,
      normalDefense = 330,
      specialDefense = 120,
      agility = 180,
    ),
    StatData(
      hp = 11500,
      actPower = 650,
      normalDefense = 550,
      specialDefense = 200,
      agility = 300,
    ),
    StatData(
      hp = 18400,
      actPower = 1040,
      normalDefense = 880,
      specialDefense = 320,
      agility = 480,
    ),
    StatData(
      hp = 23000,
      actPower = 1300,
      normalDefense = 1100,
      specialDefense = 400,
      agility = 600,
    ),
  ),
)
