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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4040017(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("浄化の斬撃") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1
                */
            }
        },
        ActType.Act2.blueprint("甘苦の斬撃") {
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
                  times2: 1

                field_effects:
                  甘美なひととき (value: 1, time: 3, target: allies)
                  雷鳴 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("激励の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("共に征きます 王の頂！") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率で慢心(5000)を1回付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate3: 100
                  values3: [450, 460, 470, 480, 500]
                  times3: [10, 10, 10, 10, 10]

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  火煙轟々 (value: 1, time: 2, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          クリティカル率アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          クリティカル威力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
          有利属性ダメージアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 2:
          AP減少
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
          AP減少
            target: 味方のシークフェルト音楽学院
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
    ),
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4040017 = PartialDressBlueprint(
  id = 4040017,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Shiori,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 2550,
    actPower = 280,
    normalDefense = 120,
    specialDefense = 200,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 74000,
    actPower = 5000,
    normalDefense = 2010,
    specialDefense = 3100,
    agility = 3650,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "浄化の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 26,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "甘苦の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1012,
      parameters = listOf(
        actParameters30,
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "激励の斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters44,
        actParameters14,
        actParameters32,
        actParameters32,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "共に征きます 王の頂！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1020,
      parameters = listOf(
        actParameters149,
        actParameters30,
        actParameters241,
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
      hp = 5400,
      actPower = 510,
      normalDefense = 90,
      specialDefense = 450,
      agility = 270,
    ),
    StatData(
      hp = 9000,
      actPower = 850,
      normalDefense = 150,
      specialDefense = 750,
      agility = 450,
    ),
    StatData(
      hp = 14400,
      actPower = 1360,
      normalDefense = 240,
      specialDefense = 1200,
      agility = 720,
    ),
    StatData(
      hp = 18000,
      actPower = 1700,
      normalDefense = 300,
      specialDefense = 1500,
      agility = 900,
    ),
  ),
)
