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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4010003(
    name = "セイレーン",
    acts = listOf(
        ActType.Act1.blueprint("刺突") {
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
        ActType.Act2.blueprint("キラめきの刺突") {
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
        ActType.Act3.blueprint("甘美の歌") {
            Act {
                /*
                継続マイナス効果解除
                  target: 後ろから2体の味方
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                ACTパワーアップ(%value%)
                  target: 後ろから2体の味方
                  hit_rate2: 100
                  values2: [12, 13, 14, 15, 17]
                  times2: [3, 3, 3, 3, 3]
                必中
                  target: 後ろから2体の味方
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("海峡に響く歌声") {
            Act {
                /*
                %attr%属性攻撃(威力%value%) (バリア無視)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 2
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          睡眠耐性アップ(%value%)
            target: 自身
            values: [100, 100, 100, 100, 200]
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
          花属性被ダメージダウン(%value%)
            target: 自身
            values: [10, 10, 10, 10, 15]
        */
        ),
    ),
    unitSkill = null /* 立ち位置中の舞台少女が2人以上編成されているとき自身の最大HPアップ %opt1_value%%(MAX60%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress4010003 = PartialDressBlueprint(
  id = 4010003,
  name = "セイレーン",
  baseRarity = 4,
  cost = 12,
  character = Character.Akira,
  attribute = Attribute.Snow,
  damageType = DamageType.Special,
  position = Position.Middle,
  positionValue = 24050,
  stats = StatData(
    hp = 1213,
    actPower = 150,
    normalDefense = 58,
    specialDefense = 95,
    agility = 169,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 39980,
    actPower = 2480,
    normalDefense = 970,
    specialDefense = 1570,
    agility = 2800,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "刺突",
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
      name = "キラめきの刺突",
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
      name = "甘美の歌",
      type = ActType.Act3,
      apCost = 3,
      icon = 10005,
      parameters = listOf(
        actParameters30,
        actParameters344,
        actParameters23,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "海峡に響く歌声",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 3,
      parameters = listOf(
        actParameters93,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard2,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 8400,
      actPower = 420,
      normalDefense = 150,
      specialDefense = 390,
      agility = 150,
    ),
    StatData(
      hp = 14000,
      actPower = 700,
      normalDefense = 250,
      specialDefense = 650,
      agility = 250,
    ),
    StatData(
      hp = 22400,
      actPower = 1120,
      normalDefense = 400,
      specialDefense = 1040,
      agility = 400,
    ),
    StatData(
      hp = 28000,
      actPower = 1400,
      normalDefense = 500,
      specialDefense = 1300,
      agility = 500,
    ),
  ),
)
