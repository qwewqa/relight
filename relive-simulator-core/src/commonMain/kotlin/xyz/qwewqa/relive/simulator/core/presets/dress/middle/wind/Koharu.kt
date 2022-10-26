package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SeiranOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010005
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedBlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.PoisonBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val SnowWhiteKoharu = dress5010005(
    name = "Snow White Koharu",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
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
        ActType.Act2.blueprint("Delicious Apple") {
            Act {
                targetByLowest { (it.hp / it.maxHp) }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                        bonusMultiplier = 150,
                        bonusCondition = SeishoOnlyCondition,
                    )
                }
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Wonderful Dream") {
            Act {
                targetByLowest { (it.hp / it.maxHp) }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                        bonusMultiplier = 150,
                        bonusCondition = SeishoOnlyCondition,
                    )
                }
                targetAllyBack(3).act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Shackles of Poison") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = PoisonBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = LockedBlindnessBuff,
                        turns = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
            TeamReviveBuffPassive.new(50, time = 1) + SeiranOnlyCondition,
        ),
        listOf(
            EnemyDazeBuffPassive.new(2) + SeishoOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(25),
            EnemyBrillianceDrainPassive.new(25) + SeishoOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Birthday2022)
)
