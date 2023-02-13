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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4020017(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("浄化の薙払") {
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
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [84, 88, 92, 97, 101]
                  times3: 1
                */
            }
        },
        ActType.Act2.blueprint("策略家のいたずら") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 2
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("永遠の輝き") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("わが宿命は、王と共に！") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (1HITごとに33%の確率で錯乱を1回付与)
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
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方のシークフェルト音楽学院
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方の鳳ミチル
            hit_rate: 100
            value: 20
            time: 0
          キラめき回復(%value%)
            target: 味方の鶴姫やちよ
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4020017 = PartialDressBlueprint(
  id = 4020017,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Michiru,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 2500,
    actPower = 300,
    normalDefense = 200,
    specialDefense = 100,
    agility = 200,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 55000,
    actPower = 4800,
    normalDefense = 2500,
    specialDefense = 1500,
    agility = 3850,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "浄化の薙払",
      type = ActType.Act1,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters30,
        actParameters53,
        actParameters137,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "策略家のいたずら",
      type = ActType.Act2,
      apCost = 2,
      icon = 157,
      parameters = listOf(
        actParameters55,
        actParameters14,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "永遠の輝き",
      type = ActType.Act3,
      apCost = 2,
      icon = 8,
      parameters = listOf(
        actParameters38,
        actParameters32,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "わが宿命は、王と共に！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 236,
      parameters = listOf(
        actParameters30,
        actParameters146,
        actParameters1,
        actParameters1,
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
      hp = 5400,
      actPower = 510,
      normalDefense = 450,
      specialDefense = 90,
      agility = 270,
    ),
    StatData(
      hp = 9000,
      actPower = 850,
      normalDefense = 750,
      specialDefense = 150,
      agility = 450,
    ),
    StatData(
      hp = 14400,
      actPower = 1360,
      normalDefense = 1200,
      specialDefense = 240,
      agility = 720,
    ),
    StatData(
      hp = 18000,
      actPower = 1700,
      normalDefense = 1500,
      specialDefense = 300,
      agility = 900,
    ),
  ),
)
