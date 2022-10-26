package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4060002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val FutureStageGirlStella = dress4060002(
    name = "Future Stage Girl Stella",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetBack().act {
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
        ActType.Act2.blueprint("Inspiring Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe(MoonOnlyCondition).act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                    addBrilliance(values3)
                }
            }
        },
        ActType.Act3.blueprint("Stalemate Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Anastrophe") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    // TODO(): Remove X Counts
                }
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times3,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
        ),
        listOf(
            TeamActUpScalingPassive100.new(30) + MoonOnlyCondition
        ),
        listOf(
            CutinInitialCooldownReductionPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
)
