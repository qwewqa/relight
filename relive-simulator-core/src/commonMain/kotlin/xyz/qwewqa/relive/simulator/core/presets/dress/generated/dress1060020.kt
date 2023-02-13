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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1060020(
    name = "野球少女",
    acts = listOf(
        ActType.Act1.blueprint("キラめきのスイング") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("スライディングキャッチ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 2
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("バックアップ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[特殊]の敵役に特攻)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [74, 78, 82, 87, 91]
                  times1: [2, 2, 2, 2, 2]
                回避
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("熱血バックホーム") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [200, 210, 220, 230, 240]
                  times1: 3

                field_effects:
                  勝負根性 (value: 1, time: 3, target: allies)
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
            value: 10
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          AP増加
            target: 敵役全体
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

val dress1060020 = PartialDressBlueprint(
  id = 1060020,
  name = "野球少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Junna,
  attribute = Attribute.Wind,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 2369,
    actPower = 260,
    normalDefense = 172,
    specialDefense = 114,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 78040,
    actPower = 4290,
    normalDefense = 2840,
    specialDefense = 1890,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきのスイング",
      type = ActType.Act1,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters2,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "スライディングキャッチ",
      type = ActType.Act2,
      apCost = 2,
      icon = 26,
      parameters = listOf(
        actParameters56,
        actParameters53,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "バックアップ",
      type = ActType.Act3,
      apCost = 2,
      icon = 196,
      parameters = listOf(
        actParameters108,
        actParameters25,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "熱血バックホーム",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1013,
      parameters = listOf(
        actParameters57,
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
      actPower = 330,
      normalDefense = 900,
      specialDefense = 150,
      agility = 210,
    ),
    StatData(
      hp = 15000,
      actPower = 550,
      normalDefense = 1500,
      specialDefense = 250,
      agility = 350,
    ),
    StatData(
      hp = 24000,
      actPower = 880,
      normalDefense = 2400,
      specialDefense = 400,
      agility = 560,
    ),
    StatData(
      hp = 30000,
      actPower = 1100,
      normalDefense = 3000,
      specialDefense = 500,
      agility = 700,
    ),
  ),
)
