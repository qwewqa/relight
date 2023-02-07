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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040011
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4040011(
    name = "BLOODY DEVIL",
    acts = listOf(
        ActType.Act1.blueprint("コレクトクラッチ") {
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
        ActType.Act2.blueprint("ライトホールド") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                ターゲット固定
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                回避率アップ(%value%)
                  target: 自身
                  hit_rate3: 100
                  values3: [30, 32, 35, 40, 50]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("ヘビースリーパー") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                ターゲット固定
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                AP増加
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("BLOODY TEA TIME") {
            Act {
                /*
                刻印
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [350, 370, 390, 420, 450]
                  times2: 2
                通常ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [1, 1, 1, 1, 1]
                特殊ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [10, 12, 14, 17, 20]
                  times4: [1, 1, 1, 1, 1]
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
            time: 1
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
        */
        ),
        listOf(
        /*
        auto skill 2:
          最大HPアップ(%value%)
            target: 味方全体
            values: [30, 30, 30, 30, 30]
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
    ),
    unitSkill = null /* 雪・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX75%) 通常防御力アップ %opt2_value%%(MAX75%) 特殊防御力アップ %opt3_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4040011 = PartialDressBlueprint(
  id = 4040011,
  name = "BLOODY DEVIL",
  baseRarity = 4,
  cost = 20,
  character = Character.Shiori,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11020,
  stats = StatData(
    hp = 15000,
    actPower = 650,
    normalDefense = 500,
    specialDefense = 1150,
    agility = 520,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 110000,
    actPower = 2000,
    normalDefense = 3000,
    specialDefense = 4000,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "コレクトクラッチ",
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
      name = "ライトホールド",
      type = ActType.Act2,
      apCost = 2,
      icon = 152,
      parameters = listOf(
        actParameters44,
        actParameters14,
        actParameters39,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "ヘビースリーパー",
      type = ActType.Act3,
      apCost = 3,
      icon = 152,
      parameters = listOf(
        actParameters44,
        actParameters14,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "BLOODY TEA TIME",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 32,
      parameters = listOf(
        actParameters14,
        actParameters333,
        actParameters170,
        actParameters170,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard0,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 11700,
      actPower = 330,
      normalDefense = 180,
      specialDefense = 390,
      agility = 30,
    ),
    StatData(
      hp = 19500,
      actPower = 550,
      normalDefense = 300,
      specialDefense = 650,
      agility = 50,
    ),
    StatData(
      hp = 31200,
      actPower = 880,
      normalDefense = 480,
      specialDefense = 1040,
      agility = 80,
    ),
    StatData(
      hp = 39000,
      actPower = 1100,
      normalDefense = 600,
      specialDefense = 1300,
      agility = 100,
    ),
  ),
)
