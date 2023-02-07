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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2030007(
    name = "鶴のつう",
    acts = listOf(
        ActType.Act1.blueprint("勝利の喝采") {
            Act {
                /*
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate2: 100
                  values2: [129, 136, 141, 148, 155]
                  times2: 1
                */
            }
        },
        ActType.Act2.blueprint("強斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [147, 154, 161, 168, 176]
                  times1: 1
                */
            }
        },
        ActType.Act3.blueprint("キラめきの合奏") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                キラめき回復(%value%)
                  target: 後ろから2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("娘の秘密") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (1HITごとに20%の確率で暗闇を2ターン付与)
                  target: 敵役全体から1HITごとにランダムに1体
                  hit_rate1: 100
                  values1: [286, 300, 314, 328, 343]
                  times1: [10, 10, 10, 10, 10]
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
          クリティカル威力アップ(%value%)
            target: 自身
            values: [15, 17, 19, 20, 22]
        */
        ),
        listOf(
        /*
        auto skill 3:
          クライマックスACT威力アップ(%value%)
            target: 自身
            values: [10, 11, 12, 13, 15]
        */
        ),
    ),
    unitSkill = null /* 宙・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2030007 = PartialDressBlueprint(
  id = 2030007,
  name = "鶴のつう",
  baseRarity = 4,
  cost = 12,
  character = Character.Fumi,
  attribute = Attribute.Space,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 865,
    actPower = 186,
    normalDefense = 75,
    specialDefense = 48,
    agility = 187,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 28490,
    actPower = 3060,
    normalDefense = 1230,
    specialDefense = 790,
    agility = 3080,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "勝利の喝采",
      type = ActType.Act1,
      apCost = 2,
      icon = 20,
      parameters = listOf(
        actParameters32,
        actParameters36,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "強斬撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 1,
      parameters = listOf(
        actParameters96,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "キラめきの合奏",
      type = ActType.Act3,
      apCost = 3,
      icon = 89,
      parameters = listOf(
        actParameters36,
        actParameters50,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "娘の秘密",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 62,
      parameters = listOf(
        actParameters192,
        actParameters1,
        actParameters1,
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
      hp = 7500,
      actPower = 390,
      normalDefense = 300,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 12500,
      actPower = 650,
      normalDefense = 500,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 20000,
      actPower = 1040,
      normalDefense = 800,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 25000,
      actPower = 1300,
      normalDefense = 1000,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
