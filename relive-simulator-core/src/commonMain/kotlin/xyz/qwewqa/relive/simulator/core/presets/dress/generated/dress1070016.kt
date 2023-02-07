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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070016(
    name = "足利義輝",
    acts = listOf(
        ActType.Act1.blueprint("激化の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [91, 95, 99, 104, 109]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("時代の新風") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (聖翔音楽学園の敵役に特攻)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [74, 78, 82, 87, 91]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("決戦の幕開け") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%) (聖翔音楽学園の敵役に特攻)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [47, 50, 53, 56, 58]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("奥義　一之太刀") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (聖翔音楽学園の敵役に特攻)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [180, 190, 200, 210, 220]
                  times1: [5, 5, 5, 5, 5]

                field_effects:
                  露か涙か (value: 1, time: 6, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ACTパワーダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 2:
          ストップ
            target: 前から1番目の敵役
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          クライマックスACT封印 (解除不可)
            target: 前から3体の敵役
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1070016 = PartialDressBlueprint(
  id = 1070016,
  name = "足利義輝",
  baseRarity = 4,
  cost = 13,
  character = Character.Nana,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 1399,
    actPower = 232,
    normalDefense = 87,
    specialDefense = 131,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 46080,
    actPower = 3830,
    normalDefense = 1440,
    specialDefense = 2160,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "激化の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters142,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "時代の新風",
      type = ActType.Act2,
      apCost = 2,
      icon = 229,
      parameters = listOf(
        actParameters30,
        actParameters106,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "決戦の幕開け",
      type = ActType.Act3,
      apCost = 2,
      icon = 229,
      parameters = listOf(
        actParameters30,
        actParameters235,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "奥義　一之太刀",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1017,
      parameters = listOf(
        actParameters236,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9600,
      actPower = 300,
      normalDefense = 150,
      specialDefense = 690,
      agility = 180,
    ),
    StatData(
      hp = 16000,
      actPower = 500,
      normalDefense = 250,
      specialDefense = 1150,
      agility = 300,
    ),
    StatData(
      hp = 25600,
      actPower = 800,
      normalDefense = 400,
      specialDefense = 1840,
      agility = 480,
    ),
    StatData(
      hp = 32000,
      actPower = 1000,
      normalDefense = 500,
      specialDefense = 2300,
      agility = 600,
    ),
  ),
)
