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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress4040009(
    name = "アンドロメダ",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの斬撃") {
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
        ActType.Act2.blueprint("減光の輪舞曲") {
            Act {
                /*
                キラめき獲得ダウン(%value%)
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [60, 65, 70, 75, 80]
                  times1: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("鎖の絆") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                クリティカル率アップ(%value%)
                  target: 味方全体
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                有利属性ダメージアップ(%value%)
                  target: 味方全体
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                */
            }
        },
        ActType.ClimaxAct.blueprint("生贄の鎖") {
            Act {
                /*
                継続プラス効果解除
                  target: 後ろから3体の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                ACTパワーダウン(%value%)
                  target: 後ろから3体の敵役
                  hit_rate2: 100
                  values2: [10, 12, 14, 17, 20]
                  times2: [3, 3, 3, 3, 3]
                通常防御力ダウン(%value%)
                  target: 後ろから3体の敵役
                  hit_rate3: 100
                  values3: [20, 22, 24, 27, 30]
                  times3: [3, 3, 3, 3, 3]
                特殊防御力ダウン(%value%)
                  target: 後ろから3体の敵役
                  hit_rate4: 100
                  values4: [20, 22, 24, 27, 30]
                  times4: [3, 3, 3, 3, 3]
                %attr%属性攻撃(威力%value%) (自身のHPが低いほど威力が増加)
                  target: 後ろから3体の敵役
                  hit_rate5: 100
                  values5: [225, 234, 243, 252, 270]
                  times5: 3
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          ターゲット固定
            target: 敵役全体
            hit_rate: 100
            value: 0
            time: 1
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

val dress4040009 = PartialDressBlueprint(
  id = 4040009,
  name = "アンドロメダ",
  baseRarity = 4,
  cost = 12,
  character = Character.Shiori,
  attribute = Attribute.Flower,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 21030,
  stats = StatData(
    hp = 1282,
    actPower = 167,
    normalDefense = 132,
    specialDefense = 72,
    agility = 177,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 42240,
    actPower = 2770,
    normalDefense = 2180,
    specialDefense = 1200,
    agility = 2930,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "キラめきの斬撃",
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
      name = "減光の輪舞曲",
      type = ActType.Act2,
      apCost = 2,
      icon = 192,
      parameters = listOf(
        actParameters103,
        actParameters1,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "鎖の絆",
      type = ActType.Act3,
      apCost = 3,
      icon = 20,
      parameters = listOf(
        actParameters44,
        actParameters42,
        actParameters32,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "生贄の鎖",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 5,
      parameters = listOf(
        actParameters30,
        actParameters42,
        actParameters32,
        actParameters32,
        actParameters289,
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
      actPower = 360,
      normalDefense = 300,
      specialDefense = 150,
      agility = 180,
    ),
    StatData(
      hp = 14000,
      actPower = 600,
      normalDefense = 500,
      specialDefense = 250,
      agility = 300,
    ),
    StatData(
      hp = 22400,
      actPower = 960,
      normalDefense = 800,
      specialDefense = 400,
      agility = 480,
    ),
    StatData(
      hp = 28000,
      actPower = 1200,
      normalDefense = 1000,
      specialDefense = 500,
      agility = 600,
    ),
  ),
)
