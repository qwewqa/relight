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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090011
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090011(
    name = "スクールアイドル",
    acts = listOf(
        ActType.Act1.blueprint("ミラクルステップ") {
            Act {
                /*
                回避率アップ(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [30, 32, 35, 40, 50]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("キラめきの舞") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                キラめき回復(%value%)
                  target: ACTパワーが高い2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("抑止の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [84, 88, 92, 97, 101]
                  times1: 1
                ストップ
                  target: 後ろから3体の敵役
                  hit_rate2: 25
                  values2: [0, 0, 0, 0, 0]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("キラキラの歌声") {
            Act {
                /*
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate1: 100
                  values1: [20, 22, 24, 27, 30]
                  times1: [3, 3, 3, 3, 3]
                クリティカル率アップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから3体の敵役
                  hit_rate3: 100
                  values3: [186, 200, 214, 228, 243]
                  times3: 3
                ストップ
                  target: 後ろから3体の敵役
                  hit_rate4: 50
                  values4: [0, 0, 0, 0, 0]
                  times4: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          暗闇耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          ストップ耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          毎ターンHP回復(%value%)
            target: 自身
            values: [1000, 1000, 1000, 1000, 1000]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1090011 = PartialDressBlueprint(
  id = 1090011,
  name = "スクールアイドル",
  baseRarity = 4,
  cost = 12,
  character = Character.Kaoruko,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 35050,
  stats = StatData(
    hp = 946,
    actPower = 196,
    normalDefense = 78,
    specialDefense = 46,
    agility = 192,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 31180,
    actPower = 3230,
    normalDefense = 1280,
    specialDefense = 760,
    agility = 3170,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "ミラクルステップ",
      type = ActType.Act1,
      apCost = 2,
      icon = 18,
      parameters = listOf(
        actParameters39,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの舞",
      type = ActType.Act2,
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
    ActType.Act3 to ActBlueprint(
      name = "抑止の輪舞曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 60,
      parameters = listOf(
        actParameters137,
        actParameters101,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "キラキラの歌声",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 60,
      parameters = listOf(
        actParameters32,
        actParameters32,
        actParameters97,
        actParameters136,
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
      normalDefense = 300,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 12000,
      actPower = 600,
      normalDefense = 500,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 19200,
      actPower = 960,
      normalDefense = 800,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 24000,
      actPower = 1200,
      normalDefense = 1000,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
