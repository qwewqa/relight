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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030008
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030008(
    name = "黒沢あひる",
    acts = listOf(
        ActType.Act1.blueprint("打撃") {
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
        ActType.Act2.blueprint("喪失の合奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前グループの敵役
                  hit_rate1: 100
                  values1: [102, 108, 113, 118, 123]
                  times1: 1
                特殊防御力ダウン(%value%)
                  target: 前グループの敵役
                  hit_rate2: 100
                  values2: [14, 16, 17, 19, 20]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("脱力の合奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろグループの敵役
                  hit_rate1: 100
                  values1: [102, 108, 113, 118, 123]
                  times1: 1
                ACTパワーダウン(%value%)
                  target: 後ろグループの敵役
                  hit_rate2: 100
                  values2: [14, 15, 17, 18, 20]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("アクア インパクト") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [286, 300, 314, 328, 343]
                  times1: 1
                凍結
                  target: 前から1番目の敵役
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
          与ダメージアップ(%value%)
            target: 自身
            values: [4, 4, 5, 5, 6]
        */
        ),
        listOf(
        /*
        auto skill 2:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [6, 6, 7, 8, 9]
        */
        ),
        listOf(
        /*
        auto skill 3:
          クライマックスACT威力アップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030008 = PartialDressBlueprint(
  id = 1030008,
  name = "黒沢あひる",
  baseRarity = 4,
  cost = 12,
  character = Character.Mahiru,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 824,
    actPower = 186,
    normalDefense = 60,
    specialDefense = 60,
    agility = 175,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 27150,
    actPower = 3080,
    normalDefense = 1000,
    specialDefense = 1000,
    agility = 2890,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "打撃",
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
      name = "喪失の合奏",
      type = ActType.Act2,
      apCost = 3,
      icon = 13,
      parameters = listOf(
        actParameters86,
        actParameters131,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "脱力の合奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 9,
      parameters = listOf(
        actParameters86,
        actParameters132,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "アクア インパクト",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 61,
      parameters = listOf(
        actParameters37,
        actParameters14,
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
      hp = 7800,
      actPower = 390,
      normalDefense = 120,
      specialDefense = 390,
      agility = 210,
    ),
    StatData(
      hp = 13000,
      actPower = 650,
      normalDefense = 200,
      specialDefense = 650,
      agility = 350,
    ),
    StatData(
      hp = 20800,
      actPower = 1040,
      normalDefense = 320,
      specialDefense = 1040,
      agility = 560,
    ),
    StatData(
      hp = 26000,
      actPower = 1300,
      normalDefense = 400,
      specialDefense = 1300,
      agility = 700,
    ),
  ),
)
