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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4050007(
    name = "マッチ売りの少女",
    acts = listOf(
        ActType.Act1.blueprint("一撃") {
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
        ActType.Act2.blueprint("キラめきの大盾") {
            Act {
                /*
                特殊バリア(%value%)
                  target: 前から2体の味方
                  hit_rate1: 100
                  values1: [460, 790, 1300, 2140, 3260]
                  times1: [3, 3, 3, 3, 3]
                キラめき回復(%value%)
                  target: 前から2体の味方
                  hit_rate2: 100
                  values2: [20, 23, 25, 27, 30]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("煽動の協奏曲") {
            Act {
                /*
                挑発
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                カウンターヒール(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("揺らめく幻") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                特殊防御力アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [20, 22, 24, 27, 30]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          毎ターンキラめき回復(%value%)
            target: 自身
            values: [4, 4, 4, 5, 5]
        */
        ),
        listOf(
        /*
        auto skill 2:
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          被ダメージダウン(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
        */
        ),
    ),
    unitSkill = null /* 雪・陽属性の舞台少女の最大HPアップ %opt1_value%%(MAX30%) 通常防御力アップ %opt2_value%%(MAX15%) 特殊防御力アップ %opt3_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4050007 = PartialDressBlueprint(
  id = 4050007,
  name = "マッチ売りの少女",
  baseRarity = 4,
  cost = 12,
  character = Character.Yachiyo,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Front,
  positionValue = 11039,
  stats = StatData(
    hp = 1841,
    actPower = 99,
    normalDefense = 87,
    specialDefense = 147,
    agility = 137,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 60660,
    actPower = 1630,
    normalDefense = 1450,
    specialDefense = 2440,
    agility = 2260,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "一撃",
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
      name = "キラめきの大盾",
      type = ActType.Act2,
      apCost = 3,
      icon = 31,
      parameters = listOf(
        actParameters340,
        actParameters50,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "煽動の協奏曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 56,
      parameters = listOf(
        actParameters14,
        actParameters16,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "揺らめく幻",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 12,
      parameters = listOf(
        actParameters0,
        actParameters32,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard0,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 300,
      normalDefense = 300,
      specialDefense = 480,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 500,
      specialDefense = 800,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 800,
      specialDefense = 1280,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1000,
      specialDefense = 1600,
      agility = 600,
    ),
  ),
)
