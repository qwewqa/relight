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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4040006(
    name = "ヴァンパイア",
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
        ActType.Act2.blueprint("夜への誘い") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                睡眠
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("血の結界") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [3000, 4000, 5000, 6000, 8000]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ブラッディ・フルムーン") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 4
                暗闇
                  target: 後ろから3体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                毒(%value%)
                  target: 後ろから3体の敵役
                  hit_rate3: 100
                  values3: [2000, 2500, 3000, 3500, 4000]
                  times3: [2, 2, 2, 2, 2]
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
          毒耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          暗闇耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4040006 = PartialDressBlueprint(
  id = 4040006,
  name = "ヴァンパイア",
  baseRarity = 4,
  cost = 12,
  character = Character.Shiori,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 21040,
  stats = StatData(
    hp = 1352,
    actPower = 159,
    normalDefense = 54,
    specialDefense = 131,
    agility = 167,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 44550,
    actPower = 2630,
    normalDefense = 900,
    specialDefense = 2160,
    agility = 2750,
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
      name = "夜への誘い",
      type = ActType.Act2,
      apCost = 2,
      icon = 58,
      parameters = listOf(
        actParameters36,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "血の結界",
      type = ActType.Act3,
      apCost = 3,
      icon = 31,
      parameters = listOf(
        actParameters0,
        actParameters380,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ブラッディ・フルムーン",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 54,
      parameters = listOf(
        actParameters47,
        actParameters14,
        actParameters168,
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
      hp = 8400,
      actPower = 360,
      normalDefense = 150,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 14000,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 22400,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 28000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
