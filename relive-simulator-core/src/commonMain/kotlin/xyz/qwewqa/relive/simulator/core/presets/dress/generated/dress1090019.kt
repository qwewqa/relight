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
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val dress = dress1090019(
    name = "アイスクリーム",
    acts = listOf(
        ActType.Act1.blueprint("バニラ") {
            Act {
                /*
                継続プラス効果解除
                  target: ACTパワーが1番高い敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                凍傷(%value%)
                  target: ACTパワーが1番高い敵役
                  hit_rate3: 100
                  values3: [55555, 66666, 77777, 88888, 99999]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act2.blueprint("ストロベリー") {
            Act {
                /*
                継続プラス効果解除
                  target: 後ろから1番目の敵役
                  hit_rate1: 100
                  values1: [0, 0, 0, 0, 0]
                  times1: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 後ろから1番目の敵役
                  hit_rate2: 100
                  values2: [165, 173, 181, 189, 198]
                  times2: 1
                凍傷(%value%)
                  target: 後ろから1番目の敵役
                  hit_rate3: 100
                  values3: [55555, 66666, 77777, 88888, 99999]
                  times3: [1, 1, 1, 1, 1]
                */
            }
        },
        ActType.Act3.blueprint("チョコレート") {
            Act {
                /*
                %attr%属性攻撃(威力%value%)
                  target: 前から1番目の敵役
                  hit_rate1: 100
                  values1: [165, 173, 181, 189, 198]
                  times1: 1
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                AP増加
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [0, 0, 0, 0, 0]
                  times3: [2, 2, 2, 2, 2]
                */
            }
        },
        ActType.ClimaxAct.blueprint("SWEET BOMB") {
            Act {
                /*
                起死回生(%value%) (回復量は対象の最大HPに依存する)
                  target: 味方全体
                  hit_rate1: 100
                  values1: [50, 50, 50, 50, 50]
                  times1: [1, 1, 1, 1, 1]
                継続プラス効果解除
                  target: 敵役全体
                  hit_rate2: 100
                  values2: [0, 0, 0, 0, 0]
                  times2: [0, 0, 0, 0, 0]
                %attr%属性攻撃(威力%value%)
                  target: 敵役全体
                  hit_rate3: 100
                  values3: [200, 210, 220, 230, 240]
                  times3: 3
                凍傷(%value%)
                  target: 敵役全体
                  hit_rate4: 100
                  values4: [55555, 66666, 77777, 88888, 99999]
                  times4: [1, 1, 1, 1, 1]
                */
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        /*
        auto skill 1:
          起死回生(%value%) (回復量は対象の最大HPに依存する)
            target: 自身
            hit_rate: 100
            value: 50
            time: 1
          不屈
            target: 自身
            hit_rate: 100
            value: 0
            time: 4
        */
        ),
        listOf(
        /*
        auto skill 2:
          無敵
            target: 味方全体
            hit_rate: 100
            value: 0
            time: 1
        */
        ),
        listOf(
        /*
        auto skill 3:
          継続マイナス効果耐性アップ(%value%)
            target: 自身
            hit_rate: 100
            value: 100
            time: 12
          回数マイナス効果耐性アップ(%value%)
            target: 自身
            hit_rate: 100
            value: 100
            time: 12
        */
        ),
        listOf(
        /*
        auto skill 4:
          最大HPアップ(開幕時味方の舞台上にいる雲属性舞台少女1体につき%value%) (最大150％)
            target: 味方の雲属性
            values: [40, 40, 40, 40, 40]
        */
        ),
    ),
    unitSkill = null /* 雲・星属性の舞台少女のACTパワーアップ %opt1_value%%(MAX50%) クリティカル威力アップ %opt2_value%%(MAX50%) */,
    multipleCA = false,
    categories = setOf(),
)
*/

val _dress1090019 = PartialDressBlueprint(
  id = 1090019,
  name = "アイスクリーム",
  baseRarity = 4,
  cost = 20,
  character = Character.Kaoruko,
  attribute = Attribute.Cloud,
  damageType = DamageType.Normal,
  position = Position.Back,
  positionValue = 34050,
  stats = StatData(
    hp = 8400,
    actPower = 880,
    normalDefense = 660,
    specialDefense = 310,
    agility = 450,
    dexterity = 5,
    critical = 50,
    accuracy = 0,
    evasion = 0,
  ),
  growthStats = StatData(
    hp = 55100,
    actPower = 4900,
    normalDefense = 2400,
    specialDefense = 1500,
    agility = 4000,
  ),
  actParameters = mapOf(
    ActType.Act1 to ActBlueprint(
      name = "バニラ",
      type = ActType.Act1,
      apCost = 2,
      icon = 241,
      parameters = listOf(
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(165, 173, 181, 189, 198),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(55555, 66666, 77777, 88888, 99999),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
      ),
    ),
    ActType.Act2 to ActBlueprint(
      name = "ストロベリー",
      type = ActType.Act2,
      apCost = 2,
      icon = 241,
      parameters = listOf(
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(165, 173, 181, 189, 198),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(55555, 66666, 77777, 88888, 99999),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
      ),
    ),
    ActType.Act3 to ActBlueprint(
      name = "チョコレート",
      type = ActType.Act3,
      apCost = 3,
      icon = 173,
      parameters = listOf(
        ActParameters(
          values = listOf(165, 173, 181, 189, 198),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(2, 2, 2, 2, 2),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
      ),
    ),
    ActType.ClimaxAct to ActBlueprint(
      name = "SWEET BOMB",
      type = ActType.ClimaxAct,
      apCost = 2,
      icon = 241,
      parameters = listOf(
        ActParameters(
          values = listOf(50, 50, 50, 50, 50),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(200, 210, 220, 230, 240),
          times = listOf(3, 3, 3, 3, 3),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(55555, 66666, 77777, 88888, 99999),
          times = listOf(1, 1, 1, 1, 1),
          hitRate = 100,
        ),
        ActParameters(
          values = listOf(0, 0, 0, 0, 0),
          times = listOf(0, 0, 0, 0, 0),
          hitRate = 0,
        ),
      ),
    ),
  ),
  autoSkillRanks = listOf(1, 4, 9, 9),
  autoSkillPanels = listOf(0, 0, 5, 5),
  rankPanels = listOf(
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 1),
      StatBoost(StatBoostType.ActPower, 1),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.NormalDefense, 1),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 1),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Hp, 2),
    ),
    listOf(
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 7),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 3),
      StatBoost(StatBoostType.Act1Level, 0),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 3),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.SpecialDefense, 5),
      StatBoost(StatBoostType.Hp, 3),
      StatBoost(StatBoostType.ActPower, 3),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Hp, 4),
    ),
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 3),
      StatBoost(StatBoostType.NormalDefense, 7),
      StatBoost(StatBoostType.Hp, 4),
      StatBoost(StatBoostType.Agility, 8),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 4),
      StatBoost(StatBoostType.NormalDefense, 3),
      StatBoost(StatBoostType.Act1Level, 0),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 4),
      StatBoost(StatBoostType.Act1Level, 0),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.SpecialDefense, 8),
      StatBoost(StatBoostType.ActPower, 5),
      StatBoost(StatBoostType.NormalDefense, 4),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Hp, 5),
    ),
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 5),
      StatBoost(StatBoostType.NormalDefense, 8),
      StatBoost(StatBoostType.SpecialDefense, 5),
      StatBoost(StatBoostType.Agility, 9),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 5),
      StatBoost(StatBoostType.NormalDefense, 8),
      StatBoost(StatBoostType.Hp, 5),
    ),
    listOf(
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.Act2Level, 0),
      StatBoost(StatBoostType.Agility, 11),
      StatBoost(StatBoostType.ClimaxActLevel, 0),
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.Act3Level, 0),
      StatBoost(StatBoostType.Act1Level, 0),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.SpecialDefense, 6),
    ),
    listOf(
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.Hp, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.SpecialDefense, 6),
      StatBoost(StatBoostType.ActPower, 6),
      StatBoost(StatBoostType.NormalDefense, 6),
    ),
  ),
  friendshipPanels = listOf(
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 1),
      StatBoost(StatBoostType.Hp, 1),
      StatBoost(StatBoostType.NormalDefense, 1),
      StatBoost(StatBoostType.SpecialDefense, 1),
      StatBoost(StatBoostType.Agility, 1),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 1),
      StatBoost(StatBoostType.Hp, 1),
      StatBoost(StatBoostType.NormalDefense, 1),
      StatBoost(StatBoostType.SpecialDefense, 1),
      StatBoost(StatBoostType.Agility, 1),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 1),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.None, 0),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
      StatBoost(StatBoostType.ActPower, 2),
      StatBoost(StatBoostType.Hp, 2),
      StatBoost(StatBoostType.NormalDefense, 2),
      StatBoost(StatBoostType.SpecialDefense, 2),
      StatBoost(StatBoostType.Agility, 2),
  ),
  remakeParameters = listOf(
    StatData(
      hp = 3000,
      actPower = 315,
      normalDefense = 180,
      specialDefense = 90,
      agility = 30,
    ),
    StatData(
      hp = 5000,
      actPower = 525,
      normalDefense = 300,
      specialDefense = 150,
      agility = 50,
    ),
    StatData(
      hp = 8000,
      actPower = 840,
      normalDefense = 480,
      specialDefense = 240,
      agility = 80,
    ),
    StatData(
      hp = 10000,
      actPower = 1050,
      normalDefense = 600,
      specialDefense = 300,
      agility = 100,
    ),
  ),
)
