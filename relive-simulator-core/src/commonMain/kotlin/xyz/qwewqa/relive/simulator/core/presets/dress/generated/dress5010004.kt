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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress5010004(
    name = "ロミオ",
    acts = listOf(
        ActType.Act1.blueprint("愛の力") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (暗闇状態の敵役に特攻)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [156, 163, 171, 178, 187]
                  times1: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act2.blueprint("愛の苦しみ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                暗闇 (解除不可)
                  target: 敵役全体
                  hit_rate2: 75
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("愛の暖かみ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [50, 50, 50, 50, 50]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("悲劇の花吹雪") {
            Act {
                /*
                マイナス効果反転(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [3, 3, 3, 3, 3]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (暗闇状態の敵役に特攻)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [180, 190, 200, 210, 220]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方の青嵐総合芸術院
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 3:
          暗闇
            target: 前から5体の敵役
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[通常]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress5010004 = PartialDressBlueprint(
  id = 5010004,
  name = "ロミオ",
  baseRarity = 4,
  cost = 15,
  character = Character.Koharu,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 2623,
    actPower = 230,
    normalDefense = 200,
    specialDefense = 80,
    agility = 210,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 75000,
    actPower = 4900,
    normalDefense = 3300,
    specialDefense = 2000,
    agility = 3400,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "愛の力",
      type = ActType.Act1,
      apCost = 2,
      icon = 189,
      parameters = listOf(
        actParameters33,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "愛の苦しみ",
      type = ActType.Act2,
      apCost = 2,
      icon = 62,
      parameters = listOf(
        actParameters136,
        actParameters198,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "愛の暖かみ",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters44,
        actParameters303,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "悲劇の花吹雪",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 151,
      parameters = listOf(
        actParameters68,
        actParameters30,
        actParameters242,
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
      actPower = 330,
      normalDefense = 840,
      specialDefense = 150,
      agility = 240,
    ),
    StatData(
      hp = 15000,
      actPower = 550,
      normalDefense = 1400,
      specialDefense = 250,
      agility = 400,
    ),
    StatData(
      hp = 24000,
      actPower = 880,
      normalDefense = 2240,
      specialDefense = 400,
      agility = 640,
    ),
    StatData(
      hp = 30000,
      actPower = 1100,
      normalDefense = 2800,
      specialDefense = 500,
      agility = 800,
    ),
  ),
)
