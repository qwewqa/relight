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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090004(
    name = "ドン・サルヴァトーリ",
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
        ActType.Act3.blueprint("奮起の合奏") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [13, 14, 16, 17, 19]
                  times1: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 前グループの敵役
                  hit_rate2: 100
                  values2: [102, 108, 113, 118, 123]
                  times2: 1
                */
            }
        },
        ActType.ClimaxAct.blueprint("Fuoco!") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [286, 300, 314, 328, 343]
                  times1: 5
                回避
                  target: 自身
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 10
            time: 0
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
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 立ち位置前の舞台少女が2人以上編成されているとき自身のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090004 = PartialDressBlueprint(
  id = 1090004,
  name = "ドン・サルヴァトーリ",
  baseRarity = 4,
  cost = 12,
  character = Character.Kaoruko,
  attribute = Attribute.Dream,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 14050,
  stats = StatData(
    hp = 1054,
    actPower = 158,
    normalDefense = 72,
    specialDefense = 79,
    agility = 166,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 34730,
    actPower = 2620,
    normalDefense = 1200,
    specialDefense = 1300,
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
      name = "奮起の合奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters8,
        actParameters86,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Fuoco!",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters154,
        actParameters14,
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
      hp = 11400,
      actPower = 360,
      normalDefense = 150,
      specialDefense = 450,
      agility = 240,
    ),
    StatData(
      hp = 19000,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 750,
      agility = 400,
    ),
    StatData(
      hp = 30400,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 1200,
      agility = 640,
    ),
    StatData(
      hp = 38000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 1500,
      agility = 800,
    ),
  ),
)
