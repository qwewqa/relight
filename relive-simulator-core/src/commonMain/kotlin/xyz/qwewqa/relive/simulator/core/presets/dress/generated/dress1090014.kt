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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090014(
    name = "モルドレッド",
    acts = listOf(
        ActType.Act1.blueprint("強一閃") {
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
        ActType.Act2.blueprint("勇猛一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                ACTパワーダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [3, 3, 3, 3, 3]
                クリティカル率ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [30, 32, 34, 37, 40]
                  times3: [3, 3, 3, 3, 3]
                クリティカル威力ダウン(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [30, 32, 34, 37, 40]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("果敢一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                命中率ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("光砕くクラレント") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 5
                ACT1封印
                  target: 後ろから3体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [4, 4, 4, 4, 4]
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
          混乱耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090014 = PartialDressBlueprint(
  id = 1090014,
  name = "モルドレッド",
  baseRarity = 4,
  cost = 12,
  character = Character.Kaoruko,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 32050,
  stats = StatData(
    hp = 1212,
    actPower = 232,
    normalDefense = 89,
    specialDefense = 137,
    agility = 200,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 39920,
    actPower = 3830,
    normalDefense = 1480,
    specialDefense = 2260,
    agility = 3300,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強一閃",
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
      name = "勇猛一閃",
      type = ActType.Act2,
      apCost = 3,
      icon = 9,
      parameters = listOf(
        actParameters36,
        actParameters144,
        actParameters144,
        actParameters144,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "果敢一閃",
      type = ActType.Act3,
      apCost = 3,
      icon = 17,
      parameters = listOf(
        actParameters36,
        actParameters49,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "光砕くクラレント",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 178,
      parameters = listOf(
        actParameters81,
        actParameters92,
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
      hp = 7500,
      actPower = 360,
      normalDefense = 90,
      specialDefense = 150,
      agility = 150,
    ),
    StatData(
      hp = 12500,
      actPower = 600,
      normalDefense = 150,
      specialDefense = 250,
      agility = 250,
    ),
    StatData(
      hp = 20000,
      actPower = 960,
      normalDefense = 240,
      specialDefense = 400,
      agility = 400,
    ),
    StatData(
      hp = 25000,
      actPower = 1200,
      normalDefense = 300,
      specialDefense = 500,
      agility = 500,
    ),
  ),
)
