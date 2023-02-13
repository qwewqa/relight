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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1020023(
    name = "勇者",
    acts = listOf(
        ActType.Act1.blueprint("キラめきのいちげき") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("きゅうしょのいちげき") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                急所
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("じゃくたいかのいちげき") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                クライマックスACT威力ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [40, 42, 44, 47, 50]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("伝説の勇者") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [200, 210, 220, 230, 240]
                  times1: 1
                毎ターンキラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [5, 6, 7, 8, 10]
                  times3: [2, 2, 2, 2, 2]
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
            time: 5
        */
        ),
        listOf(
        /*
        auto skill 2:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 50
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 30
            time: 3
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1020023 = PartialDressBlueprint(
  id = 1020023,
  name = "勇者",
  baseRarity = 4,
  cost = 23,
  character = Character.Hikari,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10494,
    actPower = 1104,
    normalDefense = 826,
    specialDefense = 426,
    agility = 500,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 67700,
    actPower = 6300,
    normalDefense = 3190,
    specialDefense = 2100,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきのいちげき",
      type = ActType.Act1,
      apCost = 1,
      icon = 89,
      parameters = listOf(
        actParameters0,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "きゅうしょのいちげき",
      type = ActType.Act2,
      apCost = 2,
      icon = 240,
      parameters = listOf(
        actParameters44,
        actParameters111,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "じゃくたいかのいちげき",
      type = ActType.Act3,
      apCost = 3,
      icon = 220,
      parameters = listOf(
        actParameters44,
        actParameters112,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "伝説の勇者",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 45,
      parameters = listOf(
        actParameters107,
        actParameters42,
        actParameters113,
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
      hp = 4200,
      actPower = 420,
      normalDefense = 270,
      specialDefense = 180,
      agility = 60,
    ),
    StatData(
      hp = 7000,
      actPower = 700,
      normalDefense = 450,
      specialDefense = 300,
      agility = 100,
    ),
    StatData(
      hp = 11200,
      actPower = 1120,
      normalDefense = 720,
      specialDefense = 480,
      agility = 160,
    ),
    StatData(
      hp = 14000,
      actPower = 1400,
      normalDefense = 900,
      specialDefense = 600,
      agility = 200,
    ),
  ),
)
