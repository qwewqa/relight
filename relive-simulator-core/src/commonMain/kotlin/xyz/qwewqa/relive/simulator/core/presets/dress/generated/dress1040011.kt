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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040011
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040011(
    name = "エドワード・ティーチ",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの斬撃") {
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
        ActType.Act2.blueprint("標的捕捉") {
            Act {
                /*
                刻印
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("士気高揚") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                通常防御力アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [10, 12, 14, 17, 20]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("黒髭の砲弾") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: HP割合が低い3体の敵役
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 6
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [1, 1, 1, 1, 1]
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
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 7, 7, 7]
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
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1040011 = PartialDressBlueprint(
  id = 1040011,
  name = "エドワード・ティーチ",
  baseRarity = 4,
  cost = 12,
  character = Character.Claudine,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1138,
    actPower = 187,
    normalDefense = 106,
    specialDefense = 54,
    agility = 185,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 37480,
    actPower = 3080,
    normalDefense = 1760,
    specialDefense = 900,
    agility = 3060,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの斬撃",
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
      name = "標的捕捉",
      type = ActType.Act2,
      apCost = 2,
      icon = 150,
      parameters = listOf(
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "士気高揚",
      type = ActType.Act3,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters137,
        actParameters42,
        actParameters42,
        actParameters42,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "黒髭の砲弾",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 45,
      parameters = listOf(
        actParameters166,
        actParameters16,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 300,
      normalDefense = 360,
      specialDefense = 150,
      agility = 150,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 600,
      specialDefense = 250,
      agility = 250,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 960,
      specialDefense = 400,
      agility = 400,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1200,
      specialDefense = 500,
      agility = 500,
    ),
  ),
)
