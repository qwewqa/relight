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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1060019(
    name = "毛利元就",
    acts = listOf(
        ActType.Act1.blueprint("一の矢") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 1
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("二の矢") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 2
                通常ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [2, 2, 2, 2, 2]
                特殊ダメージ反射(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("三の矢") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 3
                AP増加
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                通常バリア(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [3000, 3500, 4000, 4500, 5000]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("三矢の絆") {
            Act {
                /*
                継続マイナス効果解除
                  target: 味方全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [200, 210, 220, 230, 240]
                  times2: 3

                field_effects:
                  災禍の呼び声 (value: 1, time: 3, target: enemies)
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
            values: [50, 50, 50, 50, 50]
          最大HPアップ(%value%)
            target: 味方の聖翔音楽学園
            values: [30, 30, 30, 30, 30]
        */
        ),
        listOf(
        /*
        auto skill 2:
          キラめき獲得ダウン(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 80
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方の聖翔音楽学園
            hit_rate: 100
            value: 10
            time: 0
        */
        ),
    ),
    unitSkill = null /* ACTタイプ[特殊]の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1060019 = PartialDressBlueprint(
  id = 1060019,
  name = "毛利元就",
  baseRarity = 4,
  cost = 13,
  character = Character.Junna,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 23050,
  stats = StatData(
    hp = 1282,
    actPower = 243,
    normalDefense = 87,
    specialDefense = 131,
    agility = 217,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 42240,
    actPower = 4010,
    normalDefense = 1440,
    specialDefense = 2160,
    agility = 3580,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一の矢",
      type = ActType.Act1,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters21,
        actParameters30,
        actParameters90,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "二の矢",
      type = ActType.Act2,
      apCost = 2,
      icon = 33,
      parameters = listOf(
        actParameters46,
        actParameters60,
        actParameters60,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "三の矢",
      type = ActType.Act3,
      apCost = 2,
      icon = 173,
      parameters = listOf(
        actParameters223,
        actParameters14,
        actParameters82,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "三矢の絆",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1023,
      parameters = listOf(
        actParameters30,
        actParameters57,
        actParameters1,
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
      hp = 9900,
      actPower = 240,
      normalDefense = 150,
      specialDefense = 690,
      agility = 180,
    ),
    StatData(
      hp = 16500,
      actPower = 400,
      normalDefense = 250,
      specialDefense = 1150,
      agility = 300,
    ),
    StatData(
      hp = 26400,
      actPower = 640,
      normalDefense = 400,
      specialDefense = 1840,
      agility = 480,
    ),
    StatData(
      hp = 33000,
      actPower = 800,
      normalDefense = 500,
      specialDefense = 2300,
      agility = 600,
    ),
  ),
)
