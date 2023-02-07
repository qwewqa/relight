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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1010017(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
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
        ActType.Act2.blueprint("剛勇の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                通常防御力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [2, 2, 2, 2, 2]
                特殊防御力アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [30, 32, 34, 37, 40]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("煌星の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 2
                キラめき回復(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("みんなを、スタァライト！しちゃいます！！") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 2
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                毎ターンキラめき回復(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 10, 10, 10, 10]
                  times3: [3, 3, 3, 3, 3]

                field_effects:
                  私たちはもう舞台の上（花） (value: 1, time: 6, target: allies)
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
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          通常防御力アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
    ),
    unitSkill = null /* 聖翔音楽学園の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX50%) 特殊防御力アップ %opt3_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1010017 = PartialDressBlueprint(
  id = 1010017,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Karen,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 21050,
  stats = StatData(
    hp = 2871,
    actPower = 201,
    normalDefense = 196,
    specialDefense = 109,
    agility = 205,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 94570,
    actPower = 3320,
    normalDefense = 3250,
    specialDefense = 1800,
    agility = 3380,
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
      name = "剛勇の斬撃",
      type = ActType.Act2,
      apCost = 3,
      icon = 10,
      parameters = listOf(
        actParameters38,
        actParameters49,
        actParameters49,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "煌星の斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters38,
        actParameters50,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "みんなを、スタァライト！しちゃいます！！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1001,
      parameters = listOf(
        actParameters51,
        actParameters3,
        actParameters52,
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
      hp = 6600,
      actPower = 510,
      normalDefense = 840,
      specialDefense = 150,
      agility = 240,
    ),
    StatData(
      hp = 11000,
      actPower = 850,
      normalDefense = 1400,
      specialDefense = 250,
      agility = 400,
    ),
    StatData(
      hp = 17600,
      actPower = 1360,
      normalDefense = 2240,
      specialDefense = 400,
      agility = 640,
    ),
    StatData(
      hp = 22000,
      actPower = 1700,
      normalDefense = 2800,
      specialDefense = 500,
      agility = 800,
    ),
  ),
)
