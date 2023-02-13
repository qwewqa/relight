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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5020001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress5020001(
    name = "舞台少女",
    acts = listOf(
        ActType.Act1.blueprint("回避の斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                回避
                  target: 前から3体の味方
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act2.blueprint("重圧の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [54, 56, 59, 62, 64]
                  times1: 1
                AP増加
                  target: 前から3体の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("吸収の舞") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [10, 11, 12, 13, 15]
                  times1: [0, 0, 0, 0, 0]
                吸収(%value%) (吸収量は与ダメージに依存する)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 23, 26, 29, 33]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("吹き荒れる風は暁の印") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (火傷状態の敵役に特攻)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [170, 175, 180, 185, 200]
                  times1: [3, 3, 3, 3, 3]
                ストップ
                  target: 前から3体の敵役
                  hit_rate2: 75
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]

                field_effects:
                  本日も集中あるのみ（風） (value: 1, time: 6, target: enemies)
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 7, 7, 7]
        */
        ),
        listOf(
        /*
        auto skill 2:
          火傷(%value%)
            target: 敵役全体
            hit_rate: 100
            value: 1000
            time: 3
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
    unitSkill = null /* 青嵐総合芸術院のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress5020001 = PartialDressBlueprint(
  id = 5020001,
  name = "舞台少女",
  baseRarity = 4,
  cost = 15,
  character = Character.Suzu,
  attribute = Attribute.Wind,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 2040,
    actPower = 283,
    normalDefense = 109,
    specialDefense = 142,
    agility = 209,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 66210,
    actPower = 4670,
    normalDefense = 1500,
    specialDefense = 3000,
    agility = 3440,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "回避の斬撃",
      type = ActType.Act1,
      apCost = 2,
      icon = 34,
      parameters = listOf(
        actParameters2,
        actParameters25,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "重圧の輪舞曲",
      type = ActType.Act2,
      apCost = 2,
      icon = 173,
      parameters = listOf(
        actParameters21,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "吸収の舞",
      type = ActType.Act3,
      apCost = 2,
      icon = 44,
      parameters = listOf(
        actParameters139,
        actParameters163,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "吹き荒れる風は暁の印",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 1015,
      parameters = listOf(
        actParameters394,
        actParameters140,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 4800,
      actPower = 570,
      normalDefense = 90,
      specialDefense = 360,
      agility = 300,
    ),
    StatData(
      hp = 8000,
      actPower = 950,
      normalDefense = 150,
      specialDefense = 600,
      agility = 500,
    ),
    StatData(
      hp = 12800,
      actPower = 1520,
      normalDefense = 240,
      specialDefense = 960,
      agility = 800,
    ),
    StatData(
      hp = 16000,
      actPower = 1900,
      normalDefense = 300,
      specialDefense = 1200,
      agility = 1000,
    ),
  ),
)
