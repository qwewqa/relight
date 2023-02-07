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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress2030004(
    name = "天使の祝福",
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
        ActType.Act2.blueprint("キラめきの癒し") {
            Act {
                /*
                HP回復(%value%)
                  target: HP割合が1番低い味方
                  hit_rate1: 100
                  values1: [450, 770, 1280, 2100, 3210]
                  times1: [0, 0, 0, 0, 0]
                キラめき回復(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [20, 20, 20, 20, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("祝福の輪舞曲") {
            Act {
                /*
                HP回復(%value%)
                  target: 前グループの味方
                  hit_rate1: 100
                  values1: [610, 1010, 1670, 2000, 2500]
                  times1: [0, 0, 0, 0, 0]
                被ダメージダウン(%value%)
                  target: 前グループの味方
                  hit_rate2: 100
                  values2: [7, 8, 9, 10, 11]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("祝福の光翼") {
            Act {
                /*
                HP回復(%value%)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [730, 1240, 2040, 3360, 5130]
                  times1: [0, 0, 0, 0, 0]
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
          風属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX60%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress2030004 = PartialDressBlueprint(
  id = 2030004,
  name = "天使の祝福",
  baseRarity = 4,
  cost = 12,
  character = Character.Fumi,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 33050,
  stats = StatData(
    hp = 1140,
    actPower = 110,
    normalDefense = 86,
    specialDefense = 62,
    agility = 173,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 37580,
    actPower = 1820,
    normalDefense = 1420,
    specialDefense = 1020,
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
      name = "キラめきの癒し",
      type = ActType.Act2,
      apCost = 2,
      icon = 89,
      parameters = listOf(
        actParameters134,
        actParameters3,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "祝福の輪舞曲",
      type = ActType.Act3,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters282,
        actParameters82,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "祝福の光翼",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters283,
        actParameters1,
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
      hp = 6300,
      actPower = 630,
      normalDefense = 90,
      specialDefense = 420,
      agility = 210,
    ),
    StatData(
      hp = 10500,
      actPower = 1050,
      normalDefense = 150,
      specialDefense = 700,
      agility = 350,
    ),
    StatData(
      hp = 16800,
      actPower = 1680,
      normalDefense = 240,
      specialDefense = 1120,
      agility = 560,
    ),
    StatData(
      hp = 21000,
      actPower = 2100,
      normalDefense = 300,
      specialDefense = 1400,
      agility = 700,
    ),
  ),
)
