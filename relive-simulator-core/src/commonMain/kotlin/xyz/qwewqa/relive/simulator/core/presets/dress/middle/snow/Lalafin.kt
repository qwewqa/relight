package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3030015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val HopeLalafin = dress3030015(
    name = "Hope Lalafin",
    acts = listOf(
        ActType.Act1.blueprint("Smash of Brilliance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Road to Hope") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    applyCountableBuff(
                        CountableBuff.Hope,
                        count = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Skyward Leap") {
            Act {
                targetAllyBack(5).act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Hope becomes light") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = 240,
                        hitCount = 5,
                    )
                }
                targetAllyBack(3).act {
                    applyCountableBuff(
                        CountableBuff.Hope,
                        count = times2,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            EnemyBack2LockedAPUpBuffPassive.new(time = 3),
        ),
        listOf(
            //TODO() locked CX seal front 3, 2t
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SnowOnlyCondition,
    category = DressCategory.Arcana,
)