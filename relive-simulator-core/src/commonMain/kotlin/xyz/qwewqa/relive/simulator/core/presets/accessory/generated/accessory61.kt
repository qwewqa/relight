package xyz.qwewqa.relive.simulator.core.presets.accessory.generated

import xyz.qwewqa.relive.simulator.core.stage.accessory.PartialAccessoryBlueprint
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute

val accessory61 = PartialAccessoryBlueprint(
  id = 61,
  iconId = 800000803,
  name = "陽のブローチ",
  baseHp = 10000,
  baseActPower = 500,
  baseNormalDefense = 500,
  baseSpecialDefense = 500,
  baseDexterity = 0,
  baseCritical = 0,
  baseAgility = 0,
  maxHp = 40000,
  maxActPower = 2000,
  maxNormalDefense = 2000,
  maxSpecialDefense = 2000,
  maxDexterity = 0,
  maxCritical = 0,
  maxAgility = 0,
  growValues = listOf(0, 4, 9, 15, 21, 28, 35, 42, 50, 57, 65, 73, 81, 89, 97, 106, 114, 123, 132, 141, 150, 159, 168, 177, 186, 196, 205, 215, 224, 234, 244, 254, 264, 274, 283, 294, 304, 314, 324, 334, 345, 355, 365, 376, 386, 397, 408, 418, 429, 440, 451, 461, 472, 483, 494, 505, 516, 527, 539, 550, 561, 572, 583, 595, 606, 618, 629, 640, 652, 663, 675, 687, 698, 710, 722, 733, 745, 757, 769, 781, 792, 804, 816, 828, 840, 852, 864, 876, 889, 901, 913, 925, 937, 949, 962, 974, 986, 999, 1011, 1024),
  dressIds = setOf(),
  attribute = Attribute.Sun,
)

/*
auto_skill_1 (lb2):
  [start] 起死回生(%value%) (回復量は対象の最大HPに依存する)
    target: 自身
    hit_rate: 100
    value: 50
    time: 1
  [start] 不屈
    target: 自身
    hit_rate: 100
    value: 0
    time: 4
auto_skill_2 (lb5):
  [start] 祝福[有利属性ダメージアップ](%value%)
    target: 自身
    hit_rate: 100
    value: 50
    time: 2
auto_skill_3 (lb8):
  [start] 祝福[回数マイナス効果減少](%value%)
    target: 自身
    hit_rate: 100
    value: 2
    time: 1
  [start] 祝福[継続マイナス効果解除]
    target: 自身
    hit_rate: 100
    value: 0
    time: 1
auto_skill_4 (lb10):
  [start] 有利属性ダメージアップ(%value%) (解除不可)
    target: 自身
    hit_rate: 100
    value: 30
    time: 12
  [start] 無敵の再生者(%value%) (回復量は対象の最大HPに依存する)
    target: 自身
    hit_rate: 100
    value: 100
    time: 1
*/
