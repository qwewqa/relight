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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2010010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2010010(
    name = "イニシャル キーボード",
    acts = listOf(
        ActType.Act1.blueprint("強斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("創造の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (ACTタイプ[特殊]の敵役に特攻)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [156, 163, 171, 178, 187]
                  times1: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("弛緩の強襲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 通常防御力が1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                通常防御力ダウン(%value%)
                  target: 通常防御力が1番高い敵役
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("夢繋げるメロディ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 通常防御力が高い3体の敵役
                  hit_rate1: 100
                  values1: [186, 200, 214, 228, 243]
                  times1: 4
                通常防御力ダウン(%value%)
                  target: 通常防御力が高い3体の敵役
                  hit_rate2: 100
                  values2: [30, 32, 34, 37, 40]
                  times2: [3, 3, 3, 3, 3]
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
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          ストップ耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2010010 = PartialDressBlueprint(
  id = 2010010,
  name = "イニシャル キーボード",
  baseRarity = 4,
  cost = 12,
  character = Character.Tamao,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1119,
    actPower = 188,
    normalDefense = 109,
    specialDefense = 47,
    agility = 183,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 36860,
    actPower = 3110,
    normalDefense = 1810,
    specialDefense = 780,
    agility = 3030,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters98,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "創造の斬撃",
      type = ActType.Act2,
      apCost = 3,
      icon = 196,
      parameters = listOf(
        actParameters33,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "弛緩の強襲",
      type = ActType.Act3,
      apCost = 3,
      icon = 11,
      parameters = listOf(
        actParameters44,
        actParameters145,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "夢繋げるメロディ",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 11,
      parameters = listOf(
        actParameters43,
        actParameters145,
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
      hp = 9000,
      actPower = 300,
      normalDefense = 330,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 550,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 880,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1100,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
