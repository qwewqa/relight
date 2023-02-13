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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1060010(
    name = "ジキル博士",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの一撃") {
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
        ActType.Act2.blueprint("浄化の協奏曲") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("キラめきの風") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("もう一人の自分") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
                ACTチェンジ
                  target: 自身
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [4, 4, 4, 4, 4]
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate4: 100
                  values4: [10, 12, 14, 17, 20]
                  times4: [3, 3, 3, 3, 3]
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate5: 100
                  values5: [20, 22, 24, 27, 30]
                  times5: [0, 0, 0, 0, 0]
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
            values: [8, 9, 10, 11, 12]
        */
        ),
        listOf(
        /*
        auto skill 3:
          クリティカル率アップ(%value%)
            target: 自身
            values: [14, 15, 17, 18, 20]
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1060010 = PartialDressBlueprint(
  id = 1060010,
  name = "ジキル博士",
  baseRarity = 4,
  cost = 12,
  character = Character.Junna,
  attribute = Attribute.Wind,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1063,
    actPower = 184,
    normalDefense = 82,
    specialDefense = 52,
    agility = 167,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 35020,
    actPower = 3040,
    normalDefense = 1360,
    specialDefense = 860,
    agility = 2750,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの一撃",
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
      name = "浄化の協奏曲",
      type = ActType.Act2,
      apCost = 2,
      icon = 10006,
      parameters = listOf(
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キラめきの風",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "もう一人の自分",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 8,
      parameters = listOf(
        actParameters85,
        actParameters94,
        actParameters42,
        actParameters42,
        actParameters90,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9300,
      actPower = 300,
      normalDefense = 390,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 15500,
      actPower = 500,
      normalDefense = 650,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 24800,
      actPower = 800,
      normalDefense = 1040,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 31000,
      actPower = 1000,
      normalDefense = 1300,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
