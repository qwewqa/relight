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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3030013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3030013(
    name = "正義の探偵ジョーカー",
    acts = listOf(
        ActType.Act1.blueprint("強打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 2
                */
            }
        },
        ActType.Act2.blueprint("正義の糾弾") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [97, 101, 106, 112, 116]
                  times1: 1
                毒(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [3000, 3500, 4000, 4500, 5000]
                  times2: [2, 2, 2, 2, 2]
                火傷(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [1000, 1500, 2000, 2500, 3000]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("正義の重圧") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                ストップ
                  target: 後ろから3体の敵役
                  hit_rate2: 50
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("バレット・オブ・ジャスティス") {
            Act {
                /*
                無属性攻撃(%value%) (完全固定値ダメージ)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [60003, 70002, 80001, 90000, 99999]
                  times1: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          宙属性被ダメージダウン(%value%)
            target: 味方全体
            hit_rate: 100
            value: 80
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 2:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 3:
          クリティカル威力ダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3030013 = PartialDressBlueprint(
  id = 3030013,
  name = "正義の探偵ジョーカー",
  baseRarity = 4,
  cost = 13,
  character = Character.Lalafin,
  attribute = Attribute.Moon,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 1259,
    actPower = 250,
    normalDefense = 127,
    specialDefense = 54,
    agility = 212,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 41470,
    actPower = 4130,
    normalDefense = 2090,
    specialDefense = 900,
    agility = 3500,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強打撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters103,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "正義の糾弾",
      type = ActType.Act2,
      apCost = 3,
      icon = 54,
      parameters = listOf(
        actParameters335,
        actParameters336,
        actParameters190,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "正義の重圧",
      type = ActType.Act3,
      apCost = 3,
      icon = 60,
      parameters = listOf(
        actParameters137,
        actParameters136,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "バレット・オブ・ジャスティス",
      type = ActType.ClimaxAct,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters337,
        actParameters1,
        actParameters1,
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
      hp = 6000,
      actPower = 450,
      normalDefense = 330,
      specialDefense = 120,
      agility = 240,
    ),
    StatData(
      hp = 10000,
      actPower = 750,
      normalDefense = 550,
      specialDefense = 200,
      agility = 400,
    ),
    StatData(
      hp = 16000,
      actPower = 1200,
      normalDefense = 880,
      specialDefense = 320,
      agility = 640,
    ),
    StatData(
      hp = 20000,
      actPower = 1500,
      normalDefense = 1100,
      specialDefense = 400,
      agility = 800,
    ),
  ),
)
