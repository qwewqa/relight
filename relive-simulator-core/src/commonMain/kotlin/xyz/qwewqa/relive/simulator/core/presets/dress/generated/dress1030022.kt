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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030022
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030022(
    name = "イシュタル",
    acts = listOf(
        ActType.Act1.blueprint("豊穣の務め") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 20, 20, 20, 20]
                  times1: [0, 0, 0, 0, 0]
                AP減少
                  target: 味方全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [165, 173, 181, 189, 198]
                  times3: 1

                field_effects:
                  マイナス舞台効果Lvダウン(%value%) (直近付与された舞台効果2) (value: 1, time: 1, target: allies)
                */
            }
        },
        ActType.Act2.blueprint("開戦の打撃") {
            Act {
                /*
                継続マイナス効果耐性アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [100, 100, 100, 100, 100]
                  times1: [2, 2, 2, 2, 2]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                回数マイナス効果耐性解除
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [0, 0, 0, 0, 0]
                慢心(%value%)
                  target: 後ろから1番目の敵役
                  hit_rate4: 100
                  values4: [3000, 3500, 4000, 4500, 5000]
                  times4: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("美の衝動") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                カットインスキル封印
                  target: 後ろから2体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]

                field_effects:
                  拍手喝采（花） (value: 1, time: 6, target: allies)
                  魅惑の瞳 (value: 1, time: 2, target: enemies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("愛の魔物") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [2, 2, 2, 2, 2]
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                ストップ
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [1, 1, 1, 1, 1]
                カットインスキル封印
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate5: 100
                  values5: [200, 210, 220, 230, 240]
                  times5: 3
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 100
            time: 1
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 2
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方全体
            hit_rate: 100
            value: 50
            time: 1
          不屈
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 2
        */
        ),
        listOf(
        /*
        auto skill 2:
          回数マイナス効果耐性アップ(%value%) (解除不可)
            target: 自身
            hit_rate: 100
            value: 100
            time: 12
          回数マイナス効果耐性アップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 100
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方全体
            hit_rate: 100
            value: 20
            time: 0
          キラめき減少(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 30
            time: 0
          カットインスキル封印
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
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX75%) クリティカル威力アップ %opt2_value%%(MAX75%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030022 = PartialDressBlueprint(
  id = 1030022,
  name = "イシュタル",
  baseRarity = 4,
  cost = 23,
  character = Character.Mahiru,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 10400,
    actPower = 1130,
    normalDefense = 430,
    specialDefense = 800,
    agility = 510,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 68200,
    actPower = 6300,
    normalDefense = 2100,
    specialDefense = 3180,
    agility = 4600,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "豊穣の務め",
      type = ActType.Act1,
      apCost = 2,
      icon = 1046,
      parameters = listOf(
        actParameters3,
        actParameters14,
        actParameters44,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "開戦の打撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 26,
      parameters = listOf(
        actParameters62,
        actParameters44,
        actParameters30,
        actParameters58,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "美の衝動",
      type = ActType.Act3,
      apCost = 2,
      icon = 293,
      parameters = listOf(
        actParameters44,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "愛の魔物",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 293,
      parameters = listOf(
        actParameters149,
        actParameters30,
        actParameters25,
        actParameters23,
        actParameters57,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 4200,
      actPower = 420,
      normalDefense = 180,
      specialDefense = 270,
      agility = 60,
    ),
    StatData(
      hp = 7000,
      actPower = 700,
      normalDefense = 300,
      specialDefense = 450,
      agility = 100,
    ),
    StatData(
      hp = 11200,
      actPower = 1120,
      normalDefense = 480,
      specialDefense = 720,
      agility = 160,
    ),
    StatData(
      hp = 14000,
      actPower = 1400,
      normalDefense = 600,
      specialDefense = 900,
      agility = 200,
    ),
  ),
)
