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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050012
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2050012(
    name = "舞台少女コレクション",
    acts = listOf(
        ActType.Act1.blueprint("可憐なポーズ") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                ターゲット固定
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("可憐なウォーキング") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                ターゲット固定
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("可憐なスマイル") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                ターゲット固定
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate3: 100
                  values3: [10, 12, 14, 16, 20]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("田中ゆゆ子のランウェイ") {
            Act {
                /*
                不倒 (解除不可)
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [1, 1, 1, 1, 1]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [200, 210, 220, 230, 240]
                  times3: 3
                ターゲット固定
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 50
            time: 2
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
        */
        ),
        listOf(
        /*
        auto skill 3:
          ターゲット固定 (解除不可)
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 4:
          回数マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1
        */
        ),
    ),
    unitSkill = null /* 花・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2050012 = PartialDressBlueprint(
  id = 2050012,
  name = "舞台少女コレクション",
  baseRarity = 4,
  cost = 20,
  character = Character.Yuyuko,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11010,
  stats = StatData(
    hp = 15500,
    actPower = 650,
    normalDefense = 1150,
    specialDefense = 500,
    agility = 521,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 110000,
    actPower = 2000,
    normalDefense = 4000,
    specialDefense = 3000,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "可憐なポーズ",
      type = ActType.Act1,
      apCost = 1,
      icon = 152,
      parameters = listOf(
        actParameters30,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "可憐なウォーキング",
      type = ActType.Act2,
      apCost = 2,
      icon = 152,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "可憐なスマイル",
      type = ActType.Act3,
      apCost = 3,
      icon = 152,
      parameters = listOf(
        actParameters30,
        actParameters14,
        actParameters304,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "田中ゆゆ子のランウェイ",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 194,
      parameters = listOf(
        actParameters25,
        actParameters30,
        actParameters57,
        actParameters14,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard0,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 11700,
      actPower = 330,
      normalDefense = 390,
      specialDefense = 180,
      agility = 30,
    ),
    StatData(
      hp = 19500,
      actPower = 550,
      normalDefense = 650,
      specialDefense = 300,
      agility = 50,
    ),
    StatData(
      hp = 31200,
      actPower = 880,
      normalDefense = 1040,
      specialDefense = 480,
      agility = 80,
    ),
    StatData(
      hp = 39000,
      actPower = 1100,
      normalDefense = 1300,
      specialDefense = 600,
      agility = 100,
    ),
  ),
)
