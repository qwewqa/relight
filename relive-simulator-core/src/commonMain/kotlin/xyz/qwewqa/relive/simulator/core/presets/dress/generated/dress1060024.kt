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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1060024(
    name = "狩りのレヴュー",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("圧力の一撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1

                field_effects:
                  自縄自縛 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.Act3.blueprint("光の矢") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                キラめき回復(%value%)
                  target: 後ろから2体の味方
                  hit_rate2: 100
                  values2: [60, 65, 70, 75, 80]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("殺してみせろよ 大場なな") {
            Act {
                /*
                必中
                  target: 自身
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [3, 3, 3, 3, 3]
                不屈
                  target: 自身
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [200, 210, 220, 230, 240]
                  times3: 3

                field_effects:
                  星見純那が主役の舞台 (value: 1, time: 3, target: allies)
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
          錯乱
            target: 立ち位置後の敵役
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき減少(%value%)
            target: 立ち位置後の敵役
            hit_rate: 100
            value: 50
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 4:
          AP増加
            target: 立ち位置後の敵役
            hit_rate: 100
            value: 0
            time: 3
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = true,
    categories = setOf(),
)
*/

val dress1060024 = PartialDressBlueprint(
  id = 1060024,
  name = "狩りのレヴュー",
  baseRarity = 4,
  cost = 20,
  character = Character.Junna,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 8495,
    actPower = 855,
    normalDefense = 645,
    specialDefense = 305,
    agility = 450,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 55000,
    actPower = 4800,
    normalDefense = 2500,
    specialDefense = 1500,
    agility = 4100,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの一撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 89,
      parameters = listOf(
        actParameters0,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "圧力の一撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1022,
      parameters = listOf(
        actParameters44,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "光の矢",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters44,
        actParameters148,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "殺してみせろよ 大場なな",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1028,
      parameters = listOf(
        actParameters23,
        actParameters14,
        actParameters57,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 3000,
      actPower = 315,
      normalDefense = 180,
      specialDefense = 90,
      agility = 30,
    ),
    StatData(
      hp = 5000,
      actPower = 525,
      normalDefense = 300,
      specialDefense = 150,
      agility = 50,
    ),
    StatData(
      hp = 8000,
      actPower = 840,
      normalDefense = 480,
      specialDefense = 240,
      agility = 80,
    ),
    StatData(
      hp = 10000,
      actPower = 1050,
      normalDefense = 600,
      specialDefense = 300,
      agility = 100,
    ),
  ),
)
