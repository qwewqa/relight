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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090007(
    name = "マリー・アントワネット",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの一閃") {
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
        ActType.Act2.blueprint("享楽の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                クリティカル威力アップ(%value%)
                  target: 自身
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("情愛の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                通常バリア(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [5000, 6000, 7000, 8000, 10000]
                  times2: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [5000, 6000, 7000, 8000, 10000]
                  times3: [3, 3, 3, 3, 3]
                すばやさアップ(%value%)
                  target: 自身
                  hit_rate4: 100
                  values4: [30, 32, 34, 37, 40]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("アフタヌーン・ティータイム") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 3
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [6, 6, 7, 8, 9]
        */
        ),
        listOf(
        /*
        auto skill 2:
          クリティカル威力アップ(%value%)
            target: 自身
            values: [21, 23, 25, 27, 30]
        */
        ),
        listOf(
        /*
        auto skill 3:
          クリティカル率アップ(%value%)
            target: 自身
            values: [14, 15, 17, 18, 20]
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090007 = PartialDressBlueprint(
  id = 1090007,
  name = "マリー・アントワネット",
  baseRarity = 4,
  cost = 12,
  character = Character.Kaoruko,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 1177,
    actPower = 159,
    normalDefense = 93,
    specialDefense = 58,
    agility = 174,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 38790,
    actPower = 2630,
    normalDefense = 1530,
    specialDefense = 970,
    agility = 2880,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの一閃",
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
      name = "享楽の輪舞曲",
      type = ActType.Act2,
      apCost = 2,
      icon = 8,
      parameters = listOf(
        actParameters136,
        actParameters32,
        actParameters32,
        actParameters32,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "情愛の輪舞曲",
      type = ActType.Act3,
      apCost = 2,
      icon = 30,
      parameters = listOf(
        actParameters136,
        actParameters199,
        actParameters199,
        actParameters144,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "アフタヌーン・ティータイム",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 173,
      parameters = listOf(
        actParameters31,
        actParameters14,
        actParameters32,
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
      actPower = 360,
      normalDefense = 360,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 600,
      normalDefense = 600,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 960,
      normalDefense = 960,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1200,
      normalDefense = 1200,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
