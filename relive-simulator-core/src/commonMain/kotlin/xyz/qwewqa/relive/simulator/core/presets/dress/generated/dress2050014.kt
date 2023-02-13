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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2050014(
    name = "沖田総司",
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
        ActType.ClimaxAct.blueprint("三段突き") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [186, 200, 214, 228, 243]
                  times1: 3

                field_effects:
                  電光影裏 (value: 1, time: 6, target: allies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          最大HPアップ(%value%)
            target: 味方全体
            values: [10, 10, 10, 10, 10]
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき回復(%value%)
            target: 自身
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          ACTパワーアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 3
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2050014 = PartialDressBlueprint(
  id = 2050014,
  name = "沖田総司",
  baseRarity = 4,
  cost = 13,
  character = Character.Yuyuko,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
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
        actParameters143,
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
        actParameters164,
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
        actParameters108,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "三段突き",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1009,
      parameters = listOf(
        actParameters97,
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
      hp = 9300,
      actPower = 330,
      normalDefense = 150,
      specialDefense = 660,
      agility = 180,
    ),
    StatData(
      hp = 15500,
      actPower = 550,
      normalDefense = 250,
      specialDefense = 1100,
      agility = 300,
    ),
    StatData(
      hp = 24800,
      actPower = 880,
      normalDefense = 400,
      specialDefense = 1760,
      agility = 480,
    ),
    StatData(
      hp = 31000,
      actPower = 1100,
      normalDefense = 500,
      specialDefense = 2200,
      agility = 600,
    ),
  ),
)
