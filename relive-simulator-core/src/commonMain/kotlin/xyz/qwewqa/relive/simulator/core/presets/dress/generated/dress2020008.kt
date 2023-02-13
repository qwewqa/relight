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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020008
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2020008(
    name = "貂蝉",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの一閃") {
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
        ActType.Act2.blueprint("蠱惑の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                混乱
                  target: 前から3体の敵役
                  hit_rate2: 50
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("祝福の輪舞曲") {
            Act {
                /*
                毎ターンHP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 前から3体の味方
                  hit_rate1: 100
                  values1: [5, 6, 7, 8, 10]
                  times1: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("美しき罠") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
                大火傷(%value%) (ダメージ量は対象の最大HPに依存する)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [3, 3, 3, 3, 3]
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

val dress2020008 = PartialDressBlueprint(
  id = 2020008,
  name = "貂蝉",
  baseRarity = 4,
  cost = 12,
  character = Character.Ichie,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22040,
  stats = StatData(
    hp = 1393,
    actPower = 156,
    normalDefense = 57,
    specialDefense = 112,
    agility = 182,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 45890,
    actPower = 2570,
    normalDefense = 950,
    specialDefense = 1850,
    agility = 3000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの一閃",
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
      name = "蠱惑の輪舞曲",
      type = ActType.Act2,
      apCost = 2,
      icon = 59,
      parameters = listOf(
        actParameters137,
        actParameters29,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "祝福の輪舞曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 28,
      parameters = listOf(
        actParameters93,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "美しき罠",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 55,
      parameters = listOf(
        actParameters85,
        actParameters93,
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
      hp = 7800,
      actPower = 390,
      normalDefense = 480,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 13000,
      actPower = 650,
      normalDefense = 800,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 20800,
      actPower = 1040,
      normalDefense = 1280,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 26000,
      actPower = 1300,
      normalDefense = 1600,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
