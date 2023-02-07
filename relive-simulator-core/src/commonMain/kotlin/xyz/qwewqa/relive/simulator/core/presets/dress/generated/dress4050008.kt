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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050008
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4050008(
    name = "キューピッド",
    acts = listOf(
        ActType.Act1.blueprint("煽動の協奏曲") {
            Act {
                /*
                挑発
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act2.blueprint("清めの矢") {
            Act {
                /*
                継続マイナス効果解除
                  target: HP割合が低い2体の味方
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: HP割合が低い2体の味方
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [0, 0, 0, 0, 0]
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
        ActType.ClimaxAct.blueprint("ラヴ・アロー") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 1
                ターゲット固定
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                毎ターンHP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate3: 100
                  values3: [10, 12, 14, 17, 20]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          毒耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 2:
          火傷耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
        listOf(
        /*
        auto skill 3:
          スタン耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
        */
        ),
    ),
    unitSkill = null /* 立ち位置後の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX60%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4050008 = PartialDressBlueprint(
  id = 4050008,
  name = "キューピッド",
  baseRarity = 4,
  cost = 12,
  character = Character.Yachiyo,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Front,
  positionValue = 11039,
  stats = StatData(
    hp = 1778,
    actPower = 111,
    normalDefense = 143,
    specialDefense = 86,
    agility = 136,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 58580,
    actPower = 1840,
    normalDefense = 2370,
    specialDefense = 1420,
    agility = 2250,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "煽動の協奏曲",
      type = ActType.Act1,
      apCost = 2,
      icon = 56,
      parameters = listOf(
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "清めの矢",
      type = ActType.Act2,
      apCost = 2,
      icon = 10005,
      parameters = listOf(
        actParameters30,
        actParameters140,
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
      name = "ラヴ・アロー",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 152,
      parameters = listOf(
        actParameters123,
        actParameters14,
        actParameters216,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard1,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 300,
      normalDefense = 480,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 15000,
      actPower = 500,
      normalDefense = 800,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 24000,
      actPower = 800,
      normalDefense = 1280,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 30000,
      actPower = 1000,
      normalDefense = 1600,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
