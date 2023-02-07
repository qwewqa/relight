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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070010(
    name = "マーリン",
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
        ActType.Act2.blueprint("キラめきの独奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                キラめき回復(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("気絶の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: HP割合が低い2体の敵役
                  hit_rate1: 100
                  values1: [121, 127, 133, 139, 145]
                  times1: 1
                スタン
                  target: HP割合が低い2体の敵役
                  hit_rate2: 33
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("二頭の竜の予言") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [328, 345, 361, 378, 394]
                  times1: 1
                毎ターンキラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                毎ターンHP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [5, 6, 7, 8, 10]
                  times3: [3, 3, 3, 3, 3]
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
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1070010 = PartialDressBlueprint(
  id = 1070010,
  name = "マーリン",
  baseRarity = 4,
  cost = 12,
  character = Character.Nana,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 865,
    actPower = 187,
    normalDefense = 73,
    specialDefense = 50,
    agility = 178,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 28490,
    actPower = 3090,
    normalDefense = 1210,
    specialDefense = 820,
    agility = 2950,
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
      name = "キラめきの独奏",
      type = ActType.Act2,
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
    ActType.Act3 to ActBlueprint(
      name = "気絶の輪舞曲",
      type = ActType.Act3,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters232,
        actParameters94,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "二頭の竜の予言",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 29,
      parameters = listOf(
        actParameters233,
        actParameters42,
        actParameters91,
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
      hp = 6900,
      actPower = 390,
      normalDefense = 90,
      specialDefense = 420,
      agility = 180,
    ),
    StatData(
      hp = 11500,
      actPower = 650,
      normalDefense = 150,
      specialDefense = 700,
      agility = 300,
    ),
    StatData(
      hp = 18400,
      actPower = 1040,
      normalDefense = 240,
      specialDefense = 1120,
      agility = 480,
    ),
    StatData(
      hp = 23000,
      actPower = 1300,
      normalDefense = 300,
      specialDefense = 1400,
      agility = 600,
    ),
  ),
)
