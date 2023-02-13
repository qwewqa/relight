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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1060016(
    name = "ヴィヴィアン",
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
        ActType.Act2.blueprint("湖の不穏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [97, 102, 106, 111, 116]
                  times1: 1
                キラめき獲得ダウン(%value%)
                  target: 前から3体の敵役
                  hit_rate2: 100
                  values2: [40, 45, 50, 55, 60]
                  times2: [2, 2, 2, 2, 2]
                HP回復量ダウン(%value%)
                  target: 前から3体の敵役
                  hit_rate3: 100
                  values3: [60, 65, 70, 75, 80]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("湖の平穏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 11, 12, 13, 15]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("アヴァロンへの誘い") {
            Act {
                /*
                プラス効果反転(%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [3, 3, 3, 3, 3]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate2: 100
                  values2: [186, 200, 214, 228, 243]
                  times2: 6
                被ダメージダウン(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                回避
                  target: 味方全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          風属性被ダメージダウン(%value%)
            target: 味方全体
            hit_rate: 100
            value: 80
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 2:
          与ダメージアップ(%value%)
            target: 自身
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 3:
          有利属性ダメージアップ(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 4:
          HP回復量ダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 80
            time: 2
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1060016 = PartialDressBlueprint(
  id = 1060016,
  name = "ヴィヴィアン",
  baseRarity = 4,
  cost = 12,
  character = Character.Junna,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 1445,
    actPower = 173,
    normalDefense = 54,
    specialDefense = 129,
    agility = 176,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 47620,
    actPower = 2850,
    normalDefense = 900,
    specialDefense = 2130,
    agility = 2900,
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
      name = "湖の不穏",
      type = ActType.Act2,
      apCost = 3,
      icon = 192,
      parameters = listOf(
        actParameters28,
        actParameters218,
        actParameters105,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "湖の平穏",
      type = ActType.Act3,
      apCost = 3,
      icon = 45,
      parameters = listOf(
        actParameters2,
        actParameters219,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "アヴァロンへの誘い",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 151,
      parameters = listOf(
        actParameters68,
        actParameters220,
        actParameters32,
        actParameters25,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 7500,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 300,
      agility = 210,
    ),
    StatData(
      hp = 12500,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 500,
      agility = 350,
    ),
    StatData(
      hp = 20000,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 800,
      agility = 560,
    ),
    StatData(
      hp = 25000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 1000,
      agility = 700,
    ),
  ),
)
