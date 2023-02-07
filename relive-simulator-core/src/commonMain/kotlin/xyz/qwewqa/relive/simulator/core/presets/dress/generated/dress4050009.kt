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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4050009(
    name = "悠木園子",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("ビューティステップ") {
            Act {
                /*
                回避率アップ(%value%)
                  target: 前から3体の味方
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [2, 2, 2, 2, 2]
                毎ターンHP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 前から3体の味方
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("勝利への一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                ACTパワーアップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [3, 3, 3, 3, 3]
                クリティカル威力アップ(%value%)
                  target: 味方全体
                  hit_rate4: 100
                  values4: [10, 12, 14, 17, 20]
                  times4: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("ビューティポージング♪") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [186, 200, 214, 228, 243]
                  times1: 3
                被ダメージダウン(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                退場回避 (発動時に効果解除)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          回避
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
          凍結耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4050009 = PartialDressBlueprint(
  id = 4050009,
  name = "悠木園子",
  baseRarity = 4,
  cost = 12,
  character = Character.Yachiyo,
  attribute = Attribute.Space,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1189,
    actPower = 167,
    normalDefense = 54,
    specialDefense = 100,
    agility = 186,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 39170,
    actPower = 2760,
    normalDefense = 900,
    specialDefense = 1650,
    agility = 3080,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの一撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters2,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "ビューティステップ",
      type = ActType.Act2,
      apCost = 2,
      icon = 18,
      parameters = listOf(
        actParameters60,
        actParameters112,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "勝利への一撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 20,
      parameters = listOf(
        actParameters136,
        actParameters42,
        actParameters42,
        actParameters42,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "ビューティポージング♪",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 155,
      parameters = listOf(
        actParameters95,
        actParameters32,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard3,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 6000,
      actPower = 450,
      normalDefense = 120,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 10000,
      actPower = 750,
      normalDefense = 200,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 16000,
      actPower = 1200,
      normalDefense = 320,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 20000,
      actPower = 1500,
      normalDefense = 400,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
