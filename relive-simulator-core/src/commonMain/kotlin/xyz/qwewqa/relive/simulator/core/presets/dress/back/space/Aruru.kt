package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*


val CordeliaAruru = dress3010021(
    name = "Cordelia Aruru",
    acts = listOf(
        ActType.Act1.blueprint("Deadly Sharpshooting") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times4,
                    )
                }
                applyAllyStageEffect(
                    effect = Bullseye,
                    level = 2,
                    turns = 2,
                )
            }
        },
        ActType.Act2.blueprint("Sharpshooting of Hope") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetBack(2).act {
                    removeBrilliance(values2)
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times4,
                    )
                }
                applyEnemyStageEffect(
                    effect = AlluringEyes,
                    level = 2,
                    turns = 2
                )
            }
        },
        ActType.Act3.blueprint("Thunder Sharpshooting") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                applyEnemyStageEffect(
                    effect = Thunder,
                    level = 2,
                    turns = 2
                )
                applyAllyStageEffect(
                    effect = ApplauseSpace,
                    level = 2,
                    turns = 6,
                )

            }
        },
        ActType.ClimaxAct.blueprint("Toys~Hyper Sensitive~") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
                targetBack(1).act {
                    dispelCountable(BuffCategory.Positive)
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(times4).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyCountableBuff(
                        CountableBuff.Pride,
                        chance = 33,
                    )
                }
                applyAllyStageEffect(Bullseye, 2)
                applyAllyStageEffect(ApplauseSpace, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(50, 1),
            TeamBlessingEffectiveDamagePassive.new(50, 1),
            TeamBrillianceRecoveryPassive.new(10),
            AllyStageEffectPassive(ApplauseSpace).new(value = 1, time = 2)
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
            TeamAPDownBuffPassive.new(time = 1),
            TeamAPDownBuffPassive.new(time = 2) + SpaceOnlyCondition,
            AllyStageEffectPassive(Bullseye).new(1, time = 2)
        ),
        listOf(
            TeamActUpScalingPassive100.new(30) + SpaceOnlyCondition,
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
            NegativeCountableResistancePassive.new(value = 100)
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    multipleCA = true,
    categories = setOf(),
)