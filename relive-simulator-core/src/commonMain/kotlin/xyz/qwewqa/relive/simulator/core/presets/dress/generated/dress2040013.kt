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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2040013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2040013(
    name = "砂浜のダークホース",
    acts = listOf(
        ActType.Act1.blueprint("強烈なアタック") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("希望のアタック") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                希望
                  target: 自身
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("重圧のアタック") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                AP増加
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("情熱アタック") {
            Act {
                /*
                回数プラス効果減少(%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [3, 3, 3, 3, 3]
                  times1: [0, 0, 0, 0, 0]
                AP増加
                  target: 後ろから3体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [3, 3, 3, 3, 3]
                暗闇
                  target: 後ろから3体の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate4: 100
                  values4: [300, 325, 350, 375, 400]
                  times4: 3
                クライマックスACT封印 (解除不可)
                  target: 後ろから3体の敵役
                  hit_rate5: 100
                  values5: [0, 0, 0, 0, 0]
                  times5: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 50
            time: 1
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 100
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 0
          キラめき回復(%value%)
            target: 味方の凛明館女学校
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2040013 = PartialDressBlueprint(
  id = 2040013,
  name = "砂浜のダークホース",
  baseRarity = 4,
  cost = 20,
  character = Character.Rui,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 11626,
    actPower = 686,
    normalDefense = 326,
    specialDefense = 926,
    agility = 432,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 73000,
    actPower = 4600,
    normalDefense = 1900,
    specialDefense = 3200,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強烈なアタック",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters98,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "希望のアタック",
      type = ActType.Act2,
      apCost = 2,
      icon = 238,
      parameters = listOf(
        actParameters44,
        actParameters25,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "重圧のアタック",
      type = ActType.Act3,
      apCost = 3,
      icon = 10006,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "情熱アタック",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 252,
      parameters = listOf(
        actParameters68,
        actParameters23,
        actParameters23,
        actParameters279,
        actParameters14,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 7500,
      actPower = 330,
      normalDefense = 450,
      specialDefense = 450,
      agility = 60,
    ),
    StatData(
      hp = 12500,
      actPower = 550,
      normalDefense = 750,
      specialDefense = 750,
      agility = 100,
    ),
    StatData(
      hp = 20000,
      actPower = 880,
      normalDefense = 1200,
      specialDefense = 1200,
      agility = 160,
    ),
    StatData(
      hp = 25000,
      actPower = 1100,
      normalDefense = 1500,
      specialDefense = 1500,
      agility = 200,
    ),
  ),
)
