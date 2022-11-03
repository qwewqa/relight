package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ThisIsSeparation

val GrudgeRevueKaoruko = dress1090024(
    name = "Grudge Revue Kaoruko",
    acts = listOf(
        Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        Act2.blueprint("Fortitude Slash") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyBack(1).act {
                    applyCountableBuff(
                        effect = CountableBuff.Fortitude,
                        count = times2
                    )
                }
            }
        },
        Act3.blueprint("Blooming Blood") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyBack(2).act {
                    addBrilliance(values2)
                }
            }
        },
        ClimaxAct.blueprint("This is the Parting Road") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                    applyCountableBuff(CountableBuff.Fortitude, times2)
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(ThisIsSeparation, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(2) + BackOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + BackOnlyCondition,
        ),
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Movie),
)
