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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020012
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4020012(
    name = "Delight",
    acts = listOf(
        ActType.Act1.blueprint("緊張の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                希望
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act2.blueprint("喝采の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]

                field_effects:
                  拍手喝采（雪） (value: 1, time: 6, target: allies)
                */
            }
        },
        ActType.Act3.blueprint("厄災の斬撃") {
            Act {
                /*
                災難[キラめき減少](%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                */
            }
        },
        ActType.ClimaxAct.blueprint("Delight ～激情の叫び～") {
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
          ACTパワーアップ(開幕時味方の舞台上にいる雪属性舞台少女1体につき%value%) (最大100％)
            target: 味方の雪属性
            values: [30, 30, 30, 30, 30]
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4020012 = PartialDressBlueprint(
  id = 4020012,
  name = "Delight",
  baseRarity = 4,
  cost = 20,
  character = Character.Michiru,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 8400,
    actPower = 860,
    normalDefense = 665,
    specialDefense = 320,
    agility = 450,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 55000,
    actPower = 4850,
    normalDefense = 2400,
    specialDefense = 1500,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "緊張の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        actParameters44,
        actParameters25,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "喝采の斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1038,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "厄災の斬撃",
      type = ActType.Act3,
      apCost = 2,
      icon = 273,
      parameters = listOf(
        actParameters64,
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Delight ～激情の叫び～",
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
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 3000,
      actPower = 315,
      normalDefense = 180,
      specialDefense = 90,
      agility = 30,
    ),
    StatData(
      hp = 5000,
      actPower = 525,
      normalDefense = 300,
      specialDefense = 150,
      agility = 50,
    ),
    StatData(
      hp = 8000,
      actPower = 840,
      normalDefense = 480,
      specialDefense = 240,
      agility = 80,
    ),
    StatData(
      hp = 10000,
      actPower = 1050,
      normalDefense = 600,
      specialDefense = 300,
      agility = 100,
    ),
  ),
)
