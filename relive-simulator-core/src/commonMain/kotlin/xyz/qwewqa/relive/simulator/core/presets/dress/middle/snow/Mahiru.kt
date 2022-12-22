package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.Thunder
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreRivals

val CompetitionRevueMahiru = dress1030024(
    name = "Competition Revue Mahiru",
    acts = listOf(
        Act1.blueprint("Sealed Smash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                    //TODO(): unremovable stage effect seal 2t
                }
            }
        },
        Act2.blueprint("Smash of Thunder") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                applyEnemyStageEffect(Thunder, 2)
            }
        },
        Act3.blueprint("Ready to Stand on Stage") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyFront(2).act {
                    addBrilliance(values2)
                }
            }
        },
        ClimaxAct.blueprint("Shine on the stage where dreams bloom!") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times2,
                    )
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(WeAreRivals, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(time = 2) + SpecialDamageOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + SpecialDamageOnlyCondition,
        ),
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Movie),
)
