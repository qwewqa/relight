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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4100002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4100002(
    name = "未来の舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("厳封の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続マイナス効果耐性解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                舞台効果付与封印 (解除不可)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("充溢の斬撃") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [30, 30, 30, 30, 30]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                舞台効果付与封印
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("絢爛の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1

                field_effects:
                  百花繚乱 (value: 1, time: 2, target: allies)
                  燦然たる王威 (value: 1, time: 2, target: allies)
                */
            }
        },
        ActType.ClimaxAct.blueprint("俯仰天地") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                毎ターンキラめき回復(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [2, 2, 2, 2, 2]
                祝福[HP回復](%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [100, 100, 100, 100, 100]
                  times3: [1, 1, 1, 1, 1]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [200, 210, 220, 230, 240]
                  times4: 3
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
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 味方の雪属性
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
            value: 1
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
          AP減少
            target: 味方全体
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
    unitSkill = null /* 雪・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4100002 = PartialDressBlueprint(
  id = 4100002,
  name = "未来の舞台少女",
  baseRarity = 4,
  cost = 20,
  character = Character.Kuina,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 11600,
    actPower = 670,
    normalDefense = 390,
    specialDefense = 910,
    agility = 440,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 70000,
    actPower = 4500,
    normalDefense = 2100,
    specialDefense = 3000,
    agility = 4014,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "厳封の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 271,
      parameters = listOf(
        actParameters44,
        actParameters30,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "充溢の斬撃",
      type = ActType.Act2,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters71,
        actParameters44,
        actParameters14,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "絢爛の斬撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 1026,
      parameters = listOf(
        actParameters44,
        actParameters1,
        actParameters392,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "俯仰天地",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 275,
      parameters = listOf(
        actParameters67,
        actParameters352,
        actParameters64,
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
      hp = 7500,
      actPower = 330,
      normalDefense = 450,
      specialDefense = 450,
      agility = 60,
    ),
    StatData(
      hp = 12500,
      actPower = 550,
      normalDefense = 750,
      specialDefense = 750,
      agility = 100,
    ),
    StatData(
      hp = 20000,
      actPower = 880,
      normalDefense = 1200,
      specialDefense = 1200,
      agility = 160,
    ),
    StatData(
      hp = 25000,
      actPower = 1100,
      normalDefense = 1500,
      specialDefense = 1500,
      agility = 200,
    ),
  ),
)
