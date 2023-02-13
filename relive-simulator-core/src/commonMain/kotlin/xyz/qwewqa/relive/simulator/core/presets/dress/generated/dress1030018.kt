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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030018(
    name = "ジャンヌ・ダルク",
    acts = listOf(
        ActType.Act1.blueprint("オルレアンの解放") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [91, 95, 99, 104, 109]
                  times1: 2
                */
            }
        },
        ActType.Act2.blueprint("聖女の先導") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [3, 3, 3, 3, 3]
                すばやさアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [30, 32, 34, 37, 40]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("聖女の突撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                ACTパワーダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [3, 3, 3, 3, 3]
                スタン
                  target: 敵役全体
                  hit_rate3: 50
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("救世主の導き") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに20%の確率でストップを1ターン付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate2: 100
                  values2: [350, 370, 390, 420, 450]
                  times2: [10, 10, 10, 10, 10]
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
          ACTパワーアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 3:
          毎ターンHP回復(%value%)
            target: 自身
            values: [1500, 1500, 1500, 1500, 1500]
        */
        ),
        listOf(
        /*
        auto skill 4:
          すばやさアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
    ),
    unitSkill = null /* 風・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030018 = PartialDressBlueprint(
  id = 1030018,
  name = "ジャンヌ・ダルク",
  baseRarity = 4,
  cost = 12,
  character = Character.Mahiru,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 1457,
    actPower = 174,
    normalDefense = 54,
    specialDefense = 127,
    agility = 152,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 48000,
    actPower = 2880,
    normalDefense = 900,
    specialDefense = 2100,
    agility = 2500,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "オルレアンの解放",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters144,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "聖女の先導",
      type = ActType.Act2,
      apCost = 2,
      icon = 8,
      parameters = listOf(
        actParameters38,
        actParameters145,
        actParameters145,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "聖女の突撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 9,
      parameters = listOf(
        actParameters38,
        actParameters145,
        actParameters29,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "救世主の導き",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 10006,
      parameters = listOf(
        actParameters30,
        actParameters146,
        actParameters1,
        actParameters1,
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
      hp = 7800,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 300,
      agility = 240,
    ),
    StatData(
      hp = 13000,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 500,
      agility = 400,
    ),
    StatData(
      hp = 20800,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 800,
      agility = 640,
    ),
    StatData(
      hp = 26000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 1000,
      agility = 800,
    ),
  ),
)
