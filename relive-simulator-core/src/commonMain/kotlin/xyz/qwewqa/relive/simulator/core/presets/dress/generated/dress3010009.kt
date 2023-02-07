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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010009(
    name = "ドロシー",
    acts = listOf(
        ActType.Act1.blueprint("かかしの知性") {
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
                  values2: [129, 136, 141, 148, 155]
                  times2: 1
                */
            }
        },
        ActType.Act2.blueprint("ブリキのハート") {
            Act {
                /*
                通常バリア(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [3000, 4000, 5000, 6000, 8000]
                  times1: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [3000, 4000, 5000, 6000, 8000]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [129, 136, 141, 148, 155]
                  times3: 1
                */
            }
        },
        ActType.Act3.blueprint("ライオンの勇気") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [10, 12, 14, 17, 20]
                  times1: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [129, 136, 141, 148, 155]
                  times3: 1
                */
            }
        },
        ActType.ClimaxAct.blueprint("虹の彼方に！") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (1HITごとに20%の確率でスタンを2ターン付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate1: 100
                  values1: [286, 300, 314, 328, 343]
                  times1: [10, 10, 10, 10, 10]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 2:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3010009 = PartialDressBlueprint(
  id = 3010009,
  name = "ドロシー",
  baseRarity = 4,
  cost = 12,
  character = Character.Aruru,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 995,
    actPower = 195,
    normalDefense = 69,
    specialDefense = 46,
    agility = 188,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 32790,
    actPower = 3210,
    normalDefense = 1140,
    specialDefense = 770,
    agility = 3110,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "かかしの知性",
      type = ActType.Act1,
      apCost = 2,
      icon = 10006,
      parameters = listOf(
        actParameters30,
        actParameters36,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "ブリキのハート",
      type = ActType.Act2,
      apCost = 2,
      icon = 30,
      parameters = listOf(
        actParameters191,
        actParameters191,
        actParameters36,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "ライオンの勇気",
      type = ActType.Act3,
      apCost = 2,
      icon = 8,
      parameters = listOf(
        actParameters42,
        actParameters42,
        actParameters36,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "虹の彼方に！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters192,
        actParameters1,
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
      hp = 6600,
      actPower = 390,
      normalDefense = 360,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 11000,
      actPower = 650,
      normalDefense = 600,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 17600,
      actPower = 1040,
      normalDefense = 960,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 22000,
      actPower = 1300,
      normalDefense = 1200,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
