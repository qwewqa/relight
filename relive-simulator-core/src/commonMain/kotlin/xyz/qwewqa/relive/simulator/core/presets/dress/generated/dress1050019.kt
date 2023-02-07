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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1050019(
    name = "アンドレ",
    acts = listOf(
        ActType.Act1.blueprint("精悍な剣") {
            Act {
                /*
                回数マイナス効果減少(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [1, 1, 1, 1, 1]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                ACT2封印
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("忠義の剣") {
            Act {
                /*
                回数マイナス効果耐性解除
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                災難[キラめき減少](%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [100, 100, 100, 100, 100]
                  times2: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1
                */
            }
        },
        ActType.Act3.blueprint("慈愛の剣") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [40, 40, 40, 40, 40]
                  times2: [0, 0, 0, 0, 0]
                回数マイナス効果耐性アップ(%value%) (解除不可)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("誠心のばら") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                不倒 (解除不可)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [200, 210, 220, 230, 240]
                  times4: 3

                field_effects:
                  ジュ・テーム (value: 1, time: 2, target: allies)
                  嘆きの傷痕 (value: 1, time: 3, target: enemies)
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
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
            time: 4
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方のベルサイユのばらシリーズ
            hit_rate: 100
            value: 50
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 2:
          祝福[HP回復](%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1
          祝福[回数マイナス効果減少](%value%)
            target: 味方全体
            hit_rate: 100
            value: 2
            time: 1
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
        listOf(
        /*
        auto skill 3:
          継続マイナス効果耐性解除
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 0
          AP増加
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 4:
          カットインスキル発動準備ターン短縮(%value%)
            target: 自身
            values: [1, 1, 1, 1, 1]
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%)\n立ち位置後の舞台少女のACTパワーアップ %opt3_value%%(MAX50%) クリティカル威力アップ %opt4_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1050019 = PartialDressBlueprint(
  id = 1050019,
  name = "アンドレ",
  baseRarity = 4,
  cost = 20,
  character = Character.Maya,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 14848,
    actPower = 748,
    normalDefense = 480,
    specialDefense = 990,
    agility = 430,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 77000,
    actPower = 4950,
    normalDefense = 2520,
    specialDefense = 3300,
    agility = 4014,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "精悍な剣",
      type = ActType.Act1,
      apCost = 2,
      icon = 249,
      parameters = listOf(
        actParameters59,
        actParameters44,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "忠義の剣",
      type = ActType.Act2,
      apCost = 2,
      icon = 273,
      parameters = listOf(
        actParameters30,
        actParameters64,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "慈愛の剣",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters44,
        actParameters70,
        actParameters62,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "誠心のばら",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1048,
      parameters = listOf(
        actParameters67,
        actParameters14,
        actParameters150,
        actParameters57,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 12000,
      actPower = 330,
      normalDefense = 180,
      specialDefense = 390,
      agility = 60,
    ),
    StatData(
      hp = 20000,
      actPower = 550,
      normalDefense = 300,
      specialDefense = 650,
      agility = 100,
    ),
    StatData(
      hp = 32000,
      actPower = 880,
      normalDefense = 480,
      specialDefense = 1040,
      agility = 160,
    ),
    StatData(
      hp = 40000,
      actPower = 1100,
      normalDefense = 600,
      specialDefense = 1300,
      agility = 200,
    ),
  ),
)
