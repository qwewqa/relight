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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3030007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress3030007(
    name = "アルセーヌ・ルパン",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの打撃") {
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
        ActType.Act2.blueprint("暗黒の打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                暗闇
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("キラめきの風") {
            Act {
                /*
                キラめき回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [15, 16, 17, 18, 20]
                  times1: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("颯爽登場！正義の大怪盗！") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (火傷状態の敵役に特攻)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: [1, 1, 1, 1, 1]
                火傷(%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [333, 444, 555, 666, 777]
                  times2: [3, 3, 3, 3, 3]
                通常防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [3, 3, 3, 3, 3]
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
          クリティカル率アップ(%value%)
            target: 自身
            values: [8, 9, 10, 11, 12]
        */
        ),
        listOf(
        /*
        auto skill 3:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress3030007 = PartialDressBlueprint(
  id = 3030007,
  name = "アルセーヌ・ルパン",
  baseRarity = 4,
  cost = 12,
  character = Character.Lalafin,
  attribute = Attribute.Snow,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 946,
    actPower = 189,
    normalDefense = 72,
    specialDefense = 48,
    agility = 185,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 31180,
    actPower = 3120,
    normalDefense = 1200,
    specialDefense = 800,
    agility = 3060,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの打撃",
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
      name = "暗黒の打撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 62,
      parameters = listOf(
        actParameters2,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キラめきの風",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters34,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "颯爽登場！正義の大怪盗！",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 182,
      parameters = listOf(
        actParameters123,
        actParameters331,
        actParameters32,
        actParameters32,
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
      hp = 7200,
      actPower = 360,
      normalDefense = 360,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 12000,
      actPower = 600,
      normalDefense = 600,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 19200,
      actPower = 960,
      normalDefense = 960,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 24000,
      actPower = 1200,
      normalDefense = 1200,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
