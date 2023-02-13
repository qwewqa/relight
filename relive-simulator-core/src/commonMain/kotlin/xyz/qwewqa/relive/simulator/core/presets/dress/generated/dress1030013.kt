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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030013(
    name = "チェシャ猫",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの打撃") {
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
        ActType.Act2.blueprint("キラめきの奮起") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [3, 3, 3, 3, 3]
                キラめき回復(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("虚空の協奏曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                命中率ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("サプライズキャットステップ！") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [186, 200, 214, 228, 243]
                  times1: 2
                回避
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                不屈
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          すばやさアップ(%value%)
            target: 自身
            values: [5, 5, 6, 6, 7]
        */
        ),
        listOf(
        /*
        auto skill 3:
          被ダメージダウン(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030013 = PartialDressBlueprint(
  id = 1030013,
  name = "チェシャ猫",
  baseRarity = 4,
  cost = 12,
  character = Character.Mahiru,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22040,
  stats = StatData(
    hp = 1210,
    actPower = 155,
    normalDefense = 58,
    specialDefense = 109,
    agility = 170,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 39860,
    actPower = 2550,
    normalDefense = 950,
    specialDefense = 1800,
    agility = 2800,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの打撃",
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
      name = "キラめきの奮起",
      type = ActType.Act2,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters32,
        actParameters90,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "虚空の協奏曲",
      type = ActType.Act3,
      apCost = 4,
      icon = 17,
      parameters = listOf(
        actParameters137,
        actParameters49,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "サプライズキャットステップ！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 34,
      parameters = listOf(
        actParameters138,
        actParameters25,
        actParameters25,
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
      normalDefense = 150,
      specialDefense = 330,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 600,
      normalDefense = 250,
      specialDefense = 550,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 960,
      normalDefense = 400,
      specialDefense = 880,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1200,
      normalDefense = 500,
      specialDefense = 1100,
      agility = 600,
    ),
  ),
)
