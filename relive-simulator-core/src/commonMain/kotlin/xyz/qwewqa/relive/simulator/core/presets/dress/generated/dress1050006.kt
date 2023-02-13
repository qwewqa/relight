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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050006
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1050006(
    name = "アマテラス",
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
        ActType.Act3.blueprint("奮起の輪舞曲") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから2体の敵役
                  hit_rate1: 100
                  values1: [93, 98, 102, 107, 112]
                  times1: 1
                ACTパワーアップ(%value%)
                  target: 自身
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("八咫鏡　天照一閃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [117, 123, 128, 134, 140]
                  times1: 4
                大火傷(%value%) (ダメージ量は対象の最大HPに依存する)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [5, 6, 7, 8, 10]
                  times2: [3, 3, 3, 3, 3]
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
          与ダメージアップ(%value%)
            target: 自身
            values: [7, 7, 8, 9, 10]
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
    unitSkill = null /* 花・陽属性の舞台少女のACTパワーアップ %opt1_value%%(MAX15%) クリティカル威力アップ %opt2_value%%(MAX15%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1050006 = PartialDressBlueprint(
  id = 1050006,
  name = "アマテラス",
  baseRarity = 4,
  cost = 12,
  character = Character.Maya,
  attribute = Attribute.Flower,
  damageType = DamageType.Special,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 1070,
    actPower = 178,
    normalDefense = 52,
    specialDefense = 86,
    agility = 182,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 35250,
    actPower = 2950,
    normalDefense = 860,
    specialDefense = 1420,
    agility = 3000,
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
      name = "奮起の輪舞曲",
      type = ActType.Act3,
      apCost = 3,
      icon = 8,
      parameters = listOf(
        actParameters2,
        actParameters42,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "八咫鏡　天照一閃",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 55,
      parameters = listOf(
        actParameters85,
        actParameters93,
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
      hp = 6000,
      actPower = 420,
      normalDefense = 150,
      specialDefense = 300,
      agility = 180,
    ),
    StatData(
      hp = 10000,
      actPower = 700,
      normalDefense = 250,
      specialDefense = 500,
      agility = 300,
    ),
    StatData(
      hp = 16000,
      actPower = 1120,
      normalDefense = 400,
      specialDefense = 800,
      agility = 480,
    ),
    StatData(
      hp = 20000,
      actPower = 1400,
      normalDefense = 500,
      specialDefense = 1000,
      agility = 600,
    ),
  ),
)
