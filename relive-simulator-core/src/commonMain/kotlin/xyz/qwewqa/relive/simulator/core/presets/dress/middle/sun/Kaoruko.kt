package xyz.qwewqa.relive.simulator.core.presets.dress.middle.sun

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val FourthZodiacRabbitKaoruko = dress1090021(
    name = "Fourth Zodiac Rabbit Kaoruko",
    acts = listOf(
        ActType.Act1.blueprint("Brilliant Flash") {
            Act {
                targetSelf().act {
                    addBrilliance(values1)
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    //TODO(): seal SE 2t
                }
                targetBack().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                //TODO(): lower 2 neg ally SE by 1
            }
        },
        ActType.Act2.blueprint("Absorb Flash") {
            Act {
                targetAllyAoe().act {
                    dispelCountable(BuffCategory.Negative, values1)
                    applyBuff(
                        effect = NegativeCountableEffectResistanceUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack(2).act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                    //TODO(): Absorb kira 100
                }
                //TODO(): lower 2 neg ally SE by 1
            }
        },
        ActType.Act3.blueprint("Overwhelm Flash") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times2,
                    )
                }
                //TODO(): overwhelm next acting enemy
                applyEnemyStageEffect(AlluringEyes, 2)
                //TODO(): lower 2 neg ally SE by 1
            }
        },
        ActType.ClimaxAct.blueprint("Starting Jump") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = MultipleCAficationBuff,
                        turns = times2,
                    )
                }
                // TODO: revive reduction
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times5,
                    )
                }
                applyAllyStageEffect(LeapOath, 2)
                //TODO(): lower 2 neg ally SE by 1
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(time = 1),
            TeamBlessingContinuousDebuffRemovalPassive.new(time = 1),
            TeamBlessingHPRecoveryPassive.new(value = 20, time = 1),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
            DispelTimedBuffPassive(NegativeEffectResistanceUpBuff).new(),
            //TODO(): AoE SE seal
        ),
        listOf(
            SelfNegativeCountableEffectResistanceUpBuffPassive.new(value = 100, time = 2),
            TeamNegativeCountableEffectResistanceUpBuffPassive.new(value = 100, time = 1),
        ),
        listOf(
            TeamActUpScalingPassive120.new(30) + (FlowerOnlyCondition or WindOnlyCondition or SnowOnlyCondition),
            SelfActUpScalingPassive120.new(30) + (FlowerOnlyCondition or WindOnlyCondition or SnowOnlyCondition),
            CutinInitialCooldownReductionPassive.new(1),
        ),
    ),
    unitSkill = (ActCritical25UnitSkill + (FlowerOnlyCondition or WindOnlyCondition or SnowOnlyCondition)) + SelfActCritical25UnitSkill,
)