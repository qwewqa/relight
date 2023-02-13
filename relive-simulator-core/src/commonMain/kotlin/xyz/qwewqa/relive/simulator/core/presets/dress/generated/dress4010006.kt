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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4010006(
    name = "ペルセウス",
    acts = listOf(
        ActType.Act1.blueprint("刺突") {
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
        ActType.Act2.blueprint("キラめきの癒し") {
            Act {
                /*
                HP回復(%value%)
                  target: HP割合が1番低い味方
                  hit_rate1: 100
                  values1: [450, 770, 1280, 2100, 3210]
                  times1: [0, 0, 0, 0, 0]
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("勝利への行進") {
            Act {
                /*
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [10, 11, 13, 14, 15]
                  times1: [3, 3, 3, 3, 3]
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [330, 560, 930, 1530, 2330]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("アテネの盾") {
            Act {
                /*
                ターゲット固定
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                通常ダメージ反射(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [2, 2, 2, 2, 2]
                特殊ダメージ反射(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          被ダメージダウン(%value%)
            target: 自身
            values: [4, 4, 5, 5, 6]
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
          雲属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 宙・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4010006 = PartialDressBlueprint(
  id = 4010006,
  name = "ペルセウス",
  baseRarity = 4,
  cost = 12,
  character = Character.Akira,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11039,
  stats = StatData(
    hp = 1810,
    actPower = 95,
    normalDefense = 144,
    specialDefense = 89,
    agility = 157,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 59620,
    actPower = 1580,
    normalDefense = 2380,
    specialDefense = 1470,
    agility = 2590,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "刺突",
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
      name = "キラめきの癒し",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters135,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "勝利への行進",
      type = ActType.Act3,
      apCost = 2,
      icon = 20,
      parameters = listOf(
        actParameters358,
        actParameters359,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "アテネの盾",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 152,
      parameters = listOf(
        actParameters14,
        actParameters60,
        actParameters60,
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
      hp = 9000,
      actPower = 300,
      normalDefense = 480,
      specialDefense = 300,
      agility = 150,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 800,
      specialDefense = 500,
      agility = 250,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 1280,
      specialDefense = 800,
      agility = 400,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1600,
      specialDefense = 1000,
      agility = 500,
    ),
  ),
)
