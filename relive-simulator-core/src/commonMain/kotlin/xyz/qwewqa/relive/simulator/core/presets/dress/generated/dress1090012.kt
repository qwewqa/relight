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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090012
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090012(
    name = "イザナミ",
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
        ActType.Act2.blueprint("天命の抑圧") {
            Act {
                /*
                スタン
                  target: 敵役全体
                  hit_rate1: 75
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("凍てつく叢雲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                凍結
                  target: 敵役全体
                  hit_rate2: 50
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("イザナミの天地創造") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 4
                クリティカル率ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [40, 42, 44, 47, 50]
                  times2: [3, 3, 3, 3, 3]
                クリティカル威力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [40, 42, 44, 47, 50]
                  times3: [3, 3, 3, 3, 3]
                ACTパワーダウン(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [3, 3, 3, 3, 3]
                刻印
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [2, 2, 2, 2, 2]
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
          クライマックスACT威力アップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
        listOf(
        /*
        auto skill 3:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 4:
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090012 = PartialDressBlueprint(
  id = 1090012,
  name = "イザナミ",
  baseRarity = 4,
  cost = 12,
  character = Character.Kaoruko,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 1156,
    actPower = 201,
    normalDefense = 71,
    specialDefense = 108,
    agility = 187,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 38090,
    actPower = 3310,
    normalDefense = 1170,
    specialDefense = 1780,
    agility = 3080,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
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
      name = "天命の抑圧",
      type = ActType.Act2,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters198,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "凍てつく叢雲",
      type = ActType.Act3,
      apCost = 2,
      icon = 61,
      parameters = listOf(
        actParameters44,
        actParameters135,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "イザナミの天地創造",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 21,
      parameters = listOf(
        actParameters47,
        actParameters111,
        actParameters111,
        actParameters32,
        actParameters14,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 300,
      normalDefense = 90,
      specialDefense = 360,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 150,
      specialDefense = 600,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 240,
      specialDefense = 960,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 300,
      specialDefense = 1200,
      agility = 600,
    ),
  ),
)
