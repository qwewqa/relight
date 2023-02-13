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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1080005
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1080005(
    name = "清水次郎長",
    acts = listOf(
        ActType.Act1.blueprint("斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                */
            }
        },
        ActType.Act2.blueprint("キラめきの斬撃") {
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
        ActType.Act3.blueprint("敏速の輪舞曲") {
            Act {
                /*
                すばやさアップ(%value%)
                  target: 後ろグループの味方
                  hit_rate1: 100
                  values1: [8, 9, 10, 11, 12]
                  times1: [3, 3, 3, 3, 3]
                通常バリア(%value%)
                  target: 後ろグループの味方
                  hit_rate2: 100
                  values2: [300, 510, 850, 1390, 2130]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("桜梅爛漫　花吹雪") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から3体の敵役
                  hit_rate1: 100
                  values1: [164, 172, 181, 189, 197]
                  times1: 2
                キラめき回復(%value%)
                  target: 後ろグループの味方
                  hit_rate2: 100
                  values2: [14, 15, 17, 19, 20]
                  times2: [0, 0, 0, 0, 0]
                通常ダメージ反射(%value%)
                  target: 後ろグループの味方
                  hit_rate3: 100
                  values3: [14, 15, 17, 18, 20]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          被ダメージダウン(%value%)
            target: 自身
            values: [4, 4, 5, 5, 6]
        */
        ),
        listOf(
        /*
        auto skill 2:
          回避
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身のACTパワーアップ %opt1_value%%(MAX30%) クリティカル威力アップ %opt2_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1080005 = PartialDressBlueprint(
  id = 1080005,
  name = "清水次郎長",
  baseRarity = 4,
  cost = 12,
  character = Character.Futaba,
  attribute = Attribute.Moon,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 32048,
  stats = StatData(
    hp = 1075,
    actPower = 170,
    normalDefense = 69,
    specialDefense = 68,
    agility = 172,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 35420,
    actPower = 2810,
    normalDefense = 1130,
    specialDefense = 1130,
    agility = 2850,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "斬撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 1,
      parameters = listOf(
        actParameters0,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "キラめきの斬撃",
      type = ActType.Act2,
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
    ActType.Act3 to ActBlueprint(
      name = "敏速の輪舞曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 14,
      parameters = listOf(
        actParameters117,
        actParameters244,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "桜梅爛漫　花吹雪",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 32,
      parameters = listOf(
        actParameters51,
        actParameters245,
        actParameters246,
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
      hp = 6300,
      actPower = 450,
      normalDefense = 90,
      specialDefense = 390,
      agility = 210,
    ),
    StatData(
      hp = 10500,
      actPower = 750,
      normalDefense = 150,
      specialDefense = 650,
      agility = 350,
    ),
    StatData(
      hp = 16800,
      actPower = 1200,
      normalDefense = 240,
      specialDefense = 1040,
      agility = 560,
    ),
    StatData(
      hp = 21000,
      actPower = 1500,
      normalDefense = 300,
      specialDefense = 1300,
      agility = 700,
    ),
  ),
)
