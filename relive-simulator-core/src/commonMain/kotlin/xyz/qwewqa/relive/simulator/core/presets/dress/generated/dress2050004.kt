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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2050004(
    name = "風魔小太郎",
    acts = listOf(
        ActType.Act1.blueprint("一撃") {
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
        ActType.Act2.blueprint("忍法・錆刃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 1
                毒(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [30, 50, 90, 150, 250]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("忍法・霧隠れ") {
            Act {
                /*
                回避
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("奥義・風魔手裏剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [328, 345, 361, 378, 394]
                  times1: 3
                特殊防御力ダウン(%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [20, 22, 24, 26, 29]
                  times2: [3, 3, 3, 3, 3]
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
            values: [5, 6, 6, 7, 8]
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
    unitSkill = null /* 立ち位置中の舞台少女が2人以上編成されているとき自身のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2050004 = PartialDressBlueprint(
  id = 2050004,
  name = "風魔小太郎",
  baseRarity = 4,
  cost = 12,
  character = Character.Yuyuko,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22049,
  stats = StatData(
    hp = 965,
    actPower = 179,
    normalDefense = 69,
    specialDefense = 70,
    agility = 164,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 31800,
    actPower = 2950,
    normalDefense = 1130,
    specialDefense = 1160,
    agility = 2710,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一撃",
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
      name = "忍法・錆刃",
      type = ActType.Act2,
      apCost = 3,
      icon = 54,
      parameters = listOf(
        actParameters21,
        actParameters205,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "忍法・霧隠れ",
      type = ActType.Act3,
      apCost = 3,
      icon = 34,
      parameters = listOf(
        actParameters25,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "奥義・風魔手裏剣",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters276,
        actParameters301,
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
      hp = 9900,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 480,
      agility = 180,
    ),
    StatData(
      hp = 16500,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 800,
      agility = 300,
    ),
    StatData(
      hp = 26400,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 1280,
      agility = 480,
    ),
    StatData(
      hp = 33000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 1600,
      agility = 600,
    ),
  ),
)
