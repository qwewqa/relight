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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040008
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4040008(
    name = "シークフェルト音楽学院",
    acts = listOf(
        ActType.Act1.blueprint("癒しの斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("天使の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 前から3体の味方
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("慈愛") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: HP割合が低い3体の味方
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ヤーデアングリフ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 3
                通常バリア(%value%)
                  target: HP割合が低い3体の味方
                  hit_rate2: 100
                  values2: [1000, 1200, 1400, 1600, 2000]
                  times2: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: HP割合が低い3体の味方
                  hit_rate3: 100
                  values3: [1000, 1200, 1400, 1600, 2000]
                  times3: [3, 3, 3, 3, 3]
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: HP割合が低い3体の味方
                  hit_rate4: 100
                  values4: [5, 7, 9, 12, 15]
                  times4: [0, 0, 0, 0, 0]
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
            values: [5, 6, 6, 7, 8]
        */
        ),
        listOf(
        /*
        auto skill 2:
          すばやさアップ(%value%)
            target: 自身
            values: [8, 9, 10, 11, 12]
        */
        ),
        listOf(
        /*
        auto skill 3:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* シークフェルト音楽学院かつ、宙属性の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4040008 = PartialDressBlueprint(
  id = 4040008,
  name = "シークフェルト音楽学院",
  baseRarity = 4,
  cost = 12,
  character = Character.Shiori,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 23050,
  stats = StatData(
    hp = 1189,
    actPower = 119,
    normalDefense = 93,
    specialDefense = 59,
    agility = 182,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 39170,
    actPower = 1960,
    normalDefense = 1530,
    specialDefense = 980,
    agility = 3000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "癒しの斬撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 6,
      parameters = listOf(
        actParameters0,
        actParameters141,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "天使の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters36,
        actParameters187,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "慈愛",
      type = ActType.Act3,
      apCost = 3,
      icon = 6,
      parameters = listOf(
        actParameters36,
        actParameters187,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ヤーデアングリフ",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters194,
        actParameters381,
        actParameters381,
        actParameters382,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
  ),
)
