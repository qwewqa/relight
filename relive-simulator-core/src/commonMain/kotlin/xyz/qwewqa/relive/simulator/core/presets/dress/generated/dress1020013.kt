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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020013(
    name = "イニシャル ギター",
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
        ActType.Act2.blueprint("脱力の強襲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                ACTパワーダウン(%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("喪失の強襲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 特殊防御力が1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                特殊防御力ダウン(%value%)
                  target: 特殊防御力が1番高い敵役
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("夢ときめくメロディ") {
            Act {
                /*
                すばやさダウン(%value%)
                  target: HP割合が高い3体の敵役
                  hit_rate1: 100
                  values1: [30, 32, 34, 37, 40]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: HP割合が高い3体の敵役
                  hit_rate2: 100
                  values2: [186, 200, 214, 228, 243]
                  times2: 4
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
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
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
    unitSkill = null /* 立ち位置中の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1020013 = PartialDressBlueprint(
  id = 1020013,
  name = "イニシャル ギター",
  baseRarity = 4,
  cost = 12,
  character = Character.Hikari,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1282,
    actPower = 167,
    normalDefense = 60,
    specialDefense = 109,
    agility = 183,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 42240,
    actPower = 2750,
    normalDefense = 1000,
    specialDefense = 1800,
    agility = 3030,
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
      name = "脱力の強襲",
      type = ActType.Act2,
      apCost = 3,
      icon = 9,
      parameters = listOf(
        actParameters44,
        actParameters49,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "喪失の強襲",
      type = ActType.Act3,
      apCost = 3,
      icon = 13,
      parameters = listOf(
        actParameters44,
        actParameters49,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "夢ときめくメロディ",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 15,
      parameters = listOf(
        actParameters49,
        actParameters43,
        actParameters1,
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
      hp = 8400,
      actPower = 360,
      normalDefense = 150,
      specialDefense = 330,
      agility = 150,
    ),
    StatData(
      hp = 14000,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 550,
      agility = 250,
    ),
    StatData(
      hp = 22400,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 880,
      agility = 400,
    ),
    StatData(
      hp = 28000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 1100,
      agility = 500,
    ),
  ),
)
