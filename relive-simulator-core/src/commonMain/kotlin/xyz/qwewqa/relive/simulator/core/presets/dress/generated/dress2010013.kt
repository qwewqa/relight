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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2010013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2010013(
    name = "かぐや姫",
    acts = listOf(
        ActType.Act1.blueprint("断切の斬撃") {
            Act {
                /*
                継続プラス効果解除
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [129, 136, 141, 148, 155]
                  times2: 1
                */
            }
        },
        ActType.Act2.blueprint("鈍重の舞") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                すばやさダウン(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.Act3.blueprint("月の幻惑") {
            Act {
                /*
                命中率ダウン(%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [30, 32, 34, 37, 40]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("月の導き") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 4
                睡眠
                  target: 敵役全体
                  hit_rate2: 75
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                猛毒(%value%) (ダメージ量は対象の最大HPに依存する)
                  target: 敵役全体
                  hit_rate3: 75
                  values3: [6, 8, 10, 12, 15]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          睡眠耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [20, 20, 20, 20, 20]
        */
        ),
        listOf(
        /*
        auto skill 3:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2010013 = PartialDressBlueprint(
  id = 2010013,
  name = "かぐや姫",
  baseRarity = 4,
  cost = 12,
  character = Character.Tamao,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 25050,
  stats = StatData(
    hp = 1147,
    actPower = 187,
    normalDefense = 71,
    specialDefense = 106,
    agility = 185,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 37790,
    actPower = 3080,
    normalDefense = 1170,
    specialDefense = 1760,
    agility = 3060,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "断切の斬撃",
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
      name = "鈍重の舞",
      type = ActType.Act2,
      apCost = 3,
      icon = 15,
      parameters = listOf(
        actParameters44,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "月の幻惑",
      type = ActType.Act3,
      apCost = 2,
      icon = 17,
      parameters = listOf(
        actParameters49,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "月の導き",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 58,
      parameters = listOf(
        actParameters47,
        actParameters198,
        actParameters272,
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
      normalDefense = 150,
      specialDefense = 360,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 250,
      specialDefense = 600,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 400,
      specialDefense = 960,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 500,
      specialDefense = 1200,
      agility = 600,
    ),
  ),
)
