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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1040019(
    name = "Delight",
    acts = listOf(
        ActType.Act1.blueprint("搦手の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: HP割合が1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                回数マイナス効果耐性解除
                  target: HP割合が1番高い敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                急所
                  target: HP割合が1番高い敵役
                  hit_rate3: 100
                  values3: [60, 60, 60, 60, 60]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act2.blueprint("虚飾の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                回数マイナス効果耐性解除
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                慢心(%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [3000, 3500, 4000, 4500, 5000]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("狼藉の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                回数マイナス効果耐性解除
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                錯乱
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("Delight ～仲裁の剣～") {
            Act {
                /*
                回数マイナス効果減少(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [3, 3, 3, 3, 3]
                  times1: [0, 0, 0, 0, 0]
                急所
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [2, 2, 2, 2, 2]
                錯乱
                  target: 敵役全体
                  hit_rate3: 50
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [200, 210, 220, 230, 240]
                  times4: 3
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
          回数マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 2
          回数マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 0
        */
        ),
    ),
    unitSkill = null /* 風・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1040019 = PartialDressBlueprint(
  id = 1040019,
  name = "Delight",
  baseRarity = 4,
  cost = 20,
  character = Character.Claudine,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 8600,
    actPower = 850,
    normalDefense = 340,
    specialDefense = 660,
    agility = 455,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 55100,
    actPower = 4900,
    normalDefense = 1510,
    specialDefense = 2300,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "搦手の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 240,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters111,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "虚飾の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 237,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters58,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "狼藉の斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 236,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters25,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Delight ～仲裁の剣～",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 249,
      parameters = listOf(
        actParameters68,
        actParameters173,
        actParameters136,
        actParameters57,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 3000,
      actPower = 315,
      normalDefense = 90,
      specialDefense = 180,
      agility = 30,
    ),
    StatData(
      hp = 5000,
      actPower = 525,
      normalDefense = 150,
      specialDefense = 300,
      agility = 50,
    ),
    StatData(
      hp = 8000,
      actPower = 840,
      normalDefense = 240,
      specialDefense = 480,
      agility = 80,
    ),
    StatData(
      hp = 10000,
      actPower = 1050,
      normalDefense = 300,
      specialDefense = 600,
      agility = 100,
    ),
  ),
)
