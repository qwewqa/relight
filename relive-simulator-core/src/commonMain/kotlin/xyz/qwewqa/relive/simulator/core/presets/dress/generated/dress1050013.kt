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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1050013(
    name = "ヘラクレス",
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
        ActType.Act2.blueprint("獅子の咆哮") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                通常バリア(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [3000, 4000, 5000, 6000, 8000]
                  times2: [3, 3, 3, 3, 3]
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("煽動の強襲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                挑発
                  target: 後ろから3体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ヘラクレスの猛撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (1HITごとに20%の確率でスタンを2ターン付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate1: 100
                  values1: [286, 300, 314, 328, 343]
                  times1: [10, 10, 10, 10, 10]
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
          通常バリア(%value%)
            target: 自身
            hit_rate: 100
            value: 6000
            time: 3
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
    unitSkill = null /* 立ち位置中の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1050013 = PartialDressBlueprint(
  id = 1050013,
  name = "ヘラクレス",
  baseRarity = 4,
  cost = 12,
  character = Character.Maya,
  attribute = Attribute.Moon,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 21030,
  stats = StatData(
    hp = 1282,
    actPower = 167,
    normalDefense = 132,
    specialDefense = 72,
    agility = 177,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 42240,
    actPower = 2770,
    normalDefense = 2180,
    specialDefense = 1200,
    agility = 2930,
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
      name = "獅子の咆哮",
      type = ActType.Act2,
      apCost = 3,
      icon = 30,
      parameters = listOf(
        actParameters44,
        actParameters191,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "煽動の強襲",
      type = ActType.Act3,
      apCost = 3,
      icon = 56,
      parameters = listOf(
        actParameters136,
        actParameters23,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ヘラクレスの猛撃",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters192,
        actParameters1,
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
      hp = 8400,
      actPower = 360,
      normalDefense = 300,
      specialDefense = 150,
      agility = 150,
    ),
    StatData(
      hp = 14000,
      actPower = 600,
      normalDefense = 500,
      specialDefense = 250,
      agility = 250,
    ),
    StatData(
      hp = 22400,
      actPower = 960,
      normalDefense = 800,
      specialDefense = 400,
      agility = 400,
    ),
    StatData(
      hp = 28000,
      actPower = 1200,
      normalDefense = 1000,
      specialDefense = 500,
      agility = 500,
    ),
  ),
)
