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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1030016(
    name = "聖翔音楽学園",
    acts = listOf(
        ActType.Act1.blueprint("快気の打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 自身
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act2.blueprint("癒しの打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: 前から1番目の味方
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.Act3.blueprint("祝福の打撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [129, 136, 141, 148, 155]
                  times1: 1
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: HP割合が1番低い味方
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [0, 0, 0, 0, 0]
                */
            }
        },
        ActType.ClimaxAct.blueprint("Love Judgement") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [88, 92, 96, 101, 105]
                  times1: 1
                通常バリア(%value%)
                  target: HP割合が1番低い味方
                  hit_rate2: 100
                  values2: [1500, 1800, 2100, 2500, 3000]
                  times2: [3, 3, 3, 3, 3]
                特殊バリア(%value%)
                  target: HP割合が1番低い味方
                  hit_rate3: 100
                  values3: [1500, 1800, 2100, 2500, 3000]
                  times3: [3, 3, 3, 3, 3]
                HP回復(%value%) (回復量は対象の最大HPに依存する)
                  target: HP割合が1番低い味方
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [0, 0, 0, 0, 0]
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
            values: [5, 6, 6, 7, 8]
        */
        ),
        listOf(
        /*
        auto skill 2:
          すばやさアップ(%value%)
            target: 自身
            values: [8, 9, 10, 11, 12]
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
    unitSkill = null /* 聖翔音楽学園かつ、花属性の舞台少女の最大HPアップ %opt1_value%%(MAX50%) 通常防御力アップ %opt2_value%%(MAX30%) 特殊防御力アップ %opt3_value%%(MAX30%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1030016 = PartialDressBlueprint(
  id = 1030016,
  name = "聖翔音楽学園",
  baseRarity = 4,
  cost = 12,
  character = Character.Mahiru,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 33050,
  stats = StatData(
    hp = 1107,
    actPower = 121,
    normalDefense = 95,
    specialDefense = 60,
    agility = 182,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 36480,
    actPower = 2000,
    normalDefense = 1580,
    specialDefense = 1000,
    agility = 3000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "快気の打撃",
      type = ActType.Act1,
      apCost = 1,
      icon = 6,
      parameters = listOf(
        actParameters0,
        actParameters141,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "癒しの打撃",
      type = ActType.Act2,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters2,
        actParameters141,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "祝福の打撃",
      type = ActType.Act3,
      apCost = 3,
      icon = 6,
      parameters = listOf(
        actParameters36,
        actParameters141,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Love Judgement",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 6,
      parameters = listOf(
        actParameters0,
        actParameters142,
        actParameters142,
        actParameters90,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard4,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
  ),
)
