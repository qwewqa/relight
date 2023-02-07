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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020016(
    name = "漂流者",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの快気") {
            Act {
                /*
                火傷解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                火傷耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                キラめき回復(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [20, 20, 20, 20, 20]
                  times3: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("キラめきの輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                キラめき回復(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("抑止の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: HP割合が低い2体の敵役
                  hit_rate1: 100
                  values1: [106, 112, 116, 122, 128]
                  times1: 1
                ストップ
                  target: HP割合が低い2体の敵役
                  hit_rate2: 25
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("全力SOS") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [328, 345, 361, 378, 394]
                  times1: 2
                毎ターンキラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [2000, 3000, 4000, 5000, 8000]
                  times3: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [2000, 3000, 4000, 5000, 8000]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          火傷耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 3
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
          クライマックスACT威力アップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1020016 = PartialDressBlueprint(
  id = 1020016,
  name = "漂流者",
  baseRarity = 4,
  cost = 12,
  character = Character.Hikari,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 938,
    actPower = 189,
    normalDefense = 82,
    specialDefense = 51,
    agility = 185,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 30910,
    actPower = 3130,
    normalDefense = 1360,
    specialDefense = 840,
    agility = 3060,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの快気",
      type = ActType.Act1,
      apCost = 2,
      icon = 92,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters3,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの輪舞曲",
      type = ActType.Act2,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters36,
        actParameters50,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "抑止の斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 60,
      parameters = listOf(
        actParameters98,
        actParameters99,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "全力SOS",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 29,
      parameters = listOf(
        actParameters24,
        actParameters42,
        actParameters100,
        actParameters100,
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
      hp = 6900,
      actPower = 360,
      normalDefense = 300,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 11500,
      actPower = 600,
      normalDefense = 500,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 18400,
      actPower = 960,
      normalDefense = 800,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 23000,
      actPower = 1200,
      normalDefense = 1000,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
