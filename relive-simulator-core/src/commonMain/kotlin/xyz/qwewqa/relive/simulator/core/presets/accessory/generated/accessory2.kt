package xyz.qwewqa.relive.simulator.core.presets.accessory.generated

import xyz.qwewqa.relive.simulator.core.stage.accessory.PartialAccessoryBlueprint
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.dress.ActParameters
import xyz.qwewqa.relive.simulator.core.stage.dress.ActBlueprint
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute

val accessory2 = PartialAccessoryBlueprint(
  id = 2,
  iconId = 103000301,
  name = "ポルトスのメイス",
  baseHp = 100,
  baseActPower = 30,
  baseNormalDefense = 20,
  baseSpecialDefense = 5,
  baseDexterity = 0,
  baseCritical = 0,
  baseAgility = 5,
  maxHp = 1000,
  maxActPower = 300,
  maxNormalDefense = 200,
  maxSpecialDefense = 50,
  maxDexterity = 0,
  maxCritical = 0,
  maxAgility = 50,
  growValues = listOf(0, 4, 9, 15, 21, 28, 35, 42, 50, 57, 65, 73, 81, 89, 97, 106, 114, 123, 132, 141, 150, 159, 168, 177, 186, 196, 205, 215, 224, 234, 244, 254, 264, 274, 283, 294, 304, 314, 324, 334, 345, 355, 365, 376, 386, 397, 408, 418, 429, 440, 451, 461, 472, 483, 494, 505, 516, 527, 539, 550, 561, 572, 583, 595, 606, 618, 629, 640, 652, 663, 675, 687, 698, 710, 722, 733, 745, 757, 769, 781, 792, 804, 816, 828, 840, 852, 864, 876, 889, 901, 913, 925, 937, 949, 962, 974, 986, 999, 1011, 1024),
  dressIds = setOf(1030003),
  attribute = null,
  actData = ActBlueprint(
    name = "金鳳花の絨毯",
    type = ActType.ClimaxAct,
    apCost = 2,
    icon = 62,
    parameters = listOf(
      ActParameters(
        values = listOf(243, 250, 260, 270, 280),
        times = listOf(4, 4, 4, 4, 4),
        hitRate = 100,
      ),
      ActParameters(
        values = listOf(30, 32, 34, 37, 40),
        times = listOf(3, 3, 3, 3, 3),
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
)

/*

*/
