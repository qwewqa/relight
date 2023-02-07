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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2040014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2040014(
    name = "斎藤一",
    acts = listOf(
        ActType.Act1.blueprint("繚乱の一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [91, 95, 99, 104, 109]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("妖毒の誘い") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                猛毒(%value%) (ダメージ量は対象の最大HPに依存する)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [6, 8, 10, 12, 15]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("命の刃") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%) (毒状態の敵役に特攻)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [74, 78, 82, 87, 91]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("無敵の剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [240, 250, 260, 270, 280]
                  times1: 5
                退場解除(%value%) (回復量は対象の最大HPに依存する)
                  target: 退場した中で、前から1番目の味方
                  hit_rate2: 100
                  values2: [50, 55, 60, 65, 70]
                  times2: [0, 0, 0, 0, 0]

                field_effects:
                  電光影裏 (value: 1, time: 2, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ACTパワーアップ(%value%)
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
            target: 味方の凛明館女学校
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方の秋風塁
            hit_rate: 100
            value: 20
            time: 0
          キラめき回復(%value%)
            target: 味方の田中ゆゆ子
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2040014 = PartialDressBlueprint(
  id = 2040014,
  name = "斎藤一",
  baseRarity = 4,
  cost = 13,
  character = Character.Rui,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1445,
    actPower = 223,
    normalDefense = 93,
    specialDefense = 139,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 47620,
    actPower = 3690,
    normalDefense = 1530,
    specialDefense = 2300,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "繚乱の一撃",
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
      name = "妖毒の誘い",
      type = ActType.Act2,
      apCost = 2,
      icon = 54,
      parameters = listOf(
        actParameters46,
        actParameters32,
        actParameters163,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "命の刃",
      type = ActType.Act3,
      apCost = 3,
      icon = 158,
      parameters = listOf(
        actParameters32,
        actParameters32,
        actParameters106,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "無敵の剣",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 197,
      parameters = listOf(
        actParameters295,
        actParameters296,
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
      hp = 4800,
      actPower = 540,
      normalDefense = 90,
      specialDefense = 300,
      agility = 210,
    ),
    StatData(
      hp = 8000,
      actPower = 900,
      normalDefense = 150,
      specialDefense = 500,
      agility = 350,
    ),
    StatData(
      hp = 12800,
      actPower = 1440,
      normalDefense = 240,
      specialDefense = 800,
      agility = 560,
    ),
    StatData(
      hp = 16000,
      actPower = 1800,
      normalDefense = 300,
      specialDefense = 1000,
      agility = 700,
    ),
  ),
)
