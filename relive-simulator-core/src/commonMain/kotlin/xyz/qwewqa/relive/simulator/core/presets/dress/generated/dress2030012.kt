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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030012
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2030012(
    name = "PONZU DEVIL",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
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
        ActType.Act2.blueprint("マッドネスアタック") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [170, 180, 190, 200, 210]
                  times1: 1
                混乱 (解除不可)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("ピンポイントクラッチ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [170, 180, 190, 200, 210]
                  times1: 1
                急所
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("PONZU毒霧") {
            Act {
                /*
                継続プラス効果解除
                  target: 前から2体の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                急所
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [2, 2, 2, 2, 2]
                毒(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [55555, 66666, 77777, 88888, 99999]
                  times3: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%) (必中、無敵・反射・バリアを無視)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [200, 210, 220, 230, 240]
                  times4: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [50, 50, 50, 50, 50]
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方の夢大路文
            hit_rate: 100
            value: 20
            time: 0
          キラめき回復(%value%)
            target: 味方の秋風塁
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

val dress2030012 = PartialDressBlueprint(
  id = 2030012,
  name = "PONZU DEVIL",
  baseRarity = 4,
  cost = 15,
  character = Character.Fumi,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 3111,
    actPower = 260,
    normalDefense = 135,
    specialDefense = 260,
    agility = 160,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 83000,
    actPower = 4600,
    normalDefense = 1700,
    specialDefense = 3400,
    agility = 4050,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの斬撃",
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
      name = "マッドネスアタック",
      type = ActType.Act2,
      apCost = 2,
      icon = 59,
      parameters = listOf(
        actParameters66,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "ピンポイントクラッチ",
      type = ActType.Act3,
      apCost = 3,
      icon = 240,
      parameters = listOf(
        actParameters66,
        actParameters110,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "PONZU毒霧",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 240,
      parameters = listOf(
        actParameters30,
        actParameters172,
        actParameters263,
        actParameters105,
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
      hp = 7800,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 750,
      agility = 240,
    ),
    StatData(
      hp = 13000,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 1250,
      agility = 400,
    ),
    StatData(
      hp = 20800,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 2000,
      agility = 640,
    ),
    StatData(
      hp = 26000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 2500,
      agility = 800,
    ),
  ),
)
