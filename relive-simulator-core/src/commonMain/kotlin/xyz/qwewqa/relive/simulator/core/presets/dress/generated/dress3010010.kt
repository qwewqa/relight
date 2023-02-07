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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3010010(
    name = "フロンティア芸術学校",
    acts = listOf(
        ActType.Act1.blueprint("狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("渾身の狙撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 142, 149, 155]
                  times1: 3
                */
            }
        },
        ActType.Act3.blueprint("トリプルショット") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [132, 138, 145, 151, 158]
                  times1: 3
                */
            }
        },
        ActType.ClimaxAct.blueprint("ヘヴンメーカー") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [93, 98, 103, 107, 112]
                  times1: 3
                すばやさダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [13, 14, 16, 17, 19]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          すばやさアップ(%value%)
            target: 自身
            values: [3, 3, 4, 4, 5]
        */
        ),
        listOf(
        /*
        auto skill 2:
          ガンナー特攻(%value%)
            target: 自身
            values: [50, 75, 75, 75, 100]
        */
        ),
        listOf(
        /*
        auto skill 3:
          与ダメージアップ(%value%)
            target: 自身
            values: [5, 6, 6, 7, 8]
        */
        ),
    ),
    unitSkill = null /* None */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3010010 = PartialDressBlueprint(
  id = 3010010,
  name = "フロンティア芸術学校",
  baseRarity = 3,
  cost = 9,
  character = Character.Aruru,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 693,
    actPower = 154,
    normalDefense = 64,
    specialDefense = 38,
    agility = 141,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 22850,
    actPower = 2550,
    normalDefense = 1080,
    specialDefense = 650,
    agility = 2340,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "狙撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "渾身の狙撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters305,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "トリプルショット",
      type = ActType.Act3,
      apCost = 3,
      icon = 1,
      parameters = listOf(
        actParameters306,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ヘヴンメーカー",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 15,
      parameters = listOf(
        actParameters307,
        actParameters8,
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
  ),
)
