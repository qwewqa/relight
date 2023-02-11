package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val BenikageEncoreFumi = dress2030014(
    name = "Benikage Encore Fumi",
    acts = listOf(
        ActType.Act1.blueprint("Charming Slash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyEnemyStageEffect(AlluringEyes, 2)
            }
        },
        ActType.Act2.blueprint("Sweet Slash") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(SweetMoment, 2)
            }
        },
        ActType.Act3.blueprint("Slash of Ovation") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(StandingOvationFlower, 6)
            }
        },
        ActType.ClimaxAct.blueprint("Inferno Shadow Art Encore") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetBack().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(StandingOvationFlower, turns = 6)
                applyAllyStageEffect(BloomingFlowers, turns = 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(10, 3),
            TeamCriticalUpBuffPassive.new(10, 3),
            TeamNegativeEffectResistanceBuffPassive.new(100, 3) + FlowerOnlyCondition,
        ),
        listOf(
            BrillianceRecoveryPassive.new(20),
            EnemyStageEffectPassive(SunsetTune).new(value = 1, time = 6)
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
            TeamAP2DownBuffPassive.new(time = 1) + FlowerOnlyCondition,
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
        ),
    ),
    unitSkill = ActCritical100UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    categories = setOf(),
)