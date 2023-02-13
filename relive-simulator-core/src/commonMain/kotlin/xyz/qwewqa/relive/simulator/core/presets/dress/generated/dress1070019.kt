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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1070019(
    name = "ヘルダイバー",
    acts = listOf(
        ActType.Act1.blueprint("キラめきの斬撃") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
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
        ActType.Act2.blueprint("ダイナミックアタック") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [170, 180, 190, 200, 210]
                  times1: 1
                スタン (解除不可)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.Act3.blueprint("ピンポイントクラッチ") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [170, 180, 190, 200, 210]
                  times1: 1
                急所
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [60, 60, 60, 60, 60]
                  times2: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.ClimaxAct.blueprint("Nightmare Show") {
            Act {
                /*
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [240, 250, 260, 270, 280]
                  times2: 2
                急所
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [60, 60, 60, 60, 60]
                  times3: [1, 1, 1, 1, 1]
                スタン (解除不可)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [0, 0, 0, 0, 0]
                  times4: [2, 2, 2, 2, 2]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            values: [50, 50, 50, 50, 50]
        */
        ),
        listOf(
        /*
        auto skill 2:
          すばやさアップ(%value%)
            target: 味方全体
            hit_rate: 100
            value: 10
            time: 3
        */
        ),
        listOf(
        /*
        auto skill 3:
          キラめき回復(%value%)
            target: 味方の大場なな
            hit_rate: 100
            value: 20
            time: 0
          キラめき回復(%value%)
            target: 味方の星見純那
            hit_rate: 100
            value: 20
            time: 0
        */
        ),
    ),
    unitSkill = null /* 月・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val dress1070019 = PartialDressBlueprint(
  id = 1070019,
  name = "ヘルダイバー",
  baseRarity = 4,
  cost = 15,
  character = Character.Nana,
  attribute = Attribute.Moon,
  damageType = DamageType.Normal,
  position = Position.Middle,
  positionValue = 22050,
  stats = StatData(
    hp = 3000,
    actPower = 250,
    normalDefense = 250,
    specialDefense = 125,
    agility = 150,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 73000,
    actPower = 4650,
    normalDefense = 3500,
    specialDefense = 1300,
    agility = 4000,
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
      name = "ダイナミックアタック",
      type = ActType.Act2,
      apCost = 2,
      icon = 57,
      parameters = listOf(
        actParameters66,
        actParameters14,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "ピンポイントクラッチ",
      type = ActType.Act3,
      apCost = 3,
      icon = 240,
      parameters = listOf(
        actParameters66,
        actParameters111,
        actParameters1,
        actParameters1,
        actParameters1,
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "Nightmare Show",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 240,
      parameters = listOf(
        actParameters30,
        actParameters238,
        actParameters111,
        actParameters14,
        actParameters1,
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, null),
  autoSkillPanels = listOf(0, 0, 5, 0),
  rankPanels = growthBoard5,
  friendshipPanels = friendshipPattern0,
  remakeParameters = listOf(
    StatData(
      hp = 9000,
      actPower = 330,
      normalDefense = 750,
      specialDefense = 150,
      agility = 240,
    ),
    StatData(
      hp = 15000,
      actPower = 550,
      normalDefense = 1250,
      specialDefense = 250,
      agility = 400,
    ),
    StatData(
      hp = 24000,
      actPower = 880,
      normalDefense = 2000,
      specialDefense = 400,
      agility = 640,
    ),
    StatData(
      hp = 30000,
      actPower = 1100,
      normalDefense = 2500,
      specialDefense = 500,
      agility = 800,
    ),
  ),
)
