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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090018(
    name = "ホワイトサンタ",
    acts = listOf(
        ActType.Act1.blueprint("凍てつく贈り物") {
            Act {
                /*
                継続プラス効果解除
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 2
                凍結
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act2.blueprint("わがままな贈り物") {
            Act {
                /*
                継続プラス効果解除
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 2
                慢心(%value%)
                  target: 前から1番目の敵役
                  hit_rate3: 100
                  values3: [3000, 3500, 4000, 4500, 5000]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("取り乱す贈り物") {
            Act {
                /*
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 2
                錯乱
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ホワイトサンタのプレゼント") {
            Act {
                /*
                継続プラス効果解除
                  target: 後ろから2体の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                急所
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [200, 210, 220, 230, 240]
                  times3: [2, 2, 2, 2, 2]
                凍傷(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [55555, 66666, 77777, 88888, 99999]
                  times4: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ACT2封印
            target: 前から5体の敵役
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方の聖翔音楽学園
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 3:
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090018 = PartialDressBlueprint(
  id = 1090018,
  name = "ホワイトサンタ",
  baseRarity = 4,
  cost = 15,
  character = Character.Kaoruko,
  attribute = Attribute.Cloud,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 2425,
    actPower = 297,
    normalDefense = 120,
    specialDefense = 180,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 79880,
    actPower = 4900,
    normalDefense = 1980,
    specialDefense = 2970,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "凍てつく贈り物",
      type = ActType.Act1,
      apCost = 2,
      icon = 61,
      parameters = listOf(
        actParameters30,
        actParameters38,
        actParameters25,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "わがままな贈り物",
      type = ActType.Act2,
      apCost = 2,
      icon = 237,
      parameters = listOf(
        actParameters30,
        actParameters38,
        actParameters58,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "取り乱す贈り物",
      type = ActType.Act3,
      apCost = 2,
      icon = 236,
      parameters = listOf(
        actParameters30,
        actParameters38,
        actParameters25,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ホワイトサンタのプレゼント",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 241,
      parameters = listOf(
        actParameters30,
        actParameters172,
        actParameters171,
        actParameters251,
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
      hp = 3000,
      actPower = 510,
      normalDefense = 90,
      specialDefense = 300,
      agility = 300,
    ),
    StatData(
      hp = 5000,
      actPower = 850,
      normalDefense = 150,
      specialDefense = 500,
      agility = 500,
    ),
    StatData(
      hp = 8000,
      actPower = 1360,
      normalDefense = 240,
      specialDefense = 800,
      agility = 800,
    ),
    StatData(
      hp = 10000,
      actPower = 1700,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 1000,
    ),
  ),
)
