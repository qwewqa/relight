package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MiddleOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val OfficerIchie = dress2020013(
    name = "Officer Ichie",
    acts = listOf(
        ActType.Act1.blueprint("Compromise") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Safety First") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    dispelCountable(BuffCategory.Positive)
                    applyCountableBuff(
                        effect = CountableBuff.WeakSpot,
                        count = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Traffic Signal") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(ApplauseMoon, 6)
            }
        },
        ActType.ClimaxAct.blueprint("Officer Otonashi Traffic Control") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(times4).act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                    applyCountableBuff(
                        CountableBuff.Pride,
                        chance = 33,
                    )
                }
                applyAllyStageEffect(Bullseye, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(30)
        ),
        listOf(
            TeamHopeBuffPassive.new(time = 2),
            TeamBlessingHopePassive.new(1, 1)
        ),
        listOf(
            TeamCriticalUpBuffPassive.new(30, 3),
            TeamEffectiveDamageDealtUpBuffPassive.new(30, 3),
        ),
    ),
    unitSkill = (ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition)) + (ActCritical50UnitSkill + BackOnlyCondition),
)
