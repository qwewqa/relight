package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4070002
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4070003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val FutureStageGirlShiro = dress4070002(
    name = "Future Stage Girl Shiro",
    acts = listOf(
        ActType.Act1.blueprint("Smash of Brilliance") {
            Act {
                targetFront(1).act {
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
        ActType.Act2.blueprint("Cumulative Slash") {
            Act {
                targetFront(1).act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Exuberant Smash") {
            Act {
                targetFront(1).act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyBack(3).act{
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Schnee & Glockchen") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = LockedNegativeEffectResistanceUpBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = LockedNegativeCountableEffectResistanceUpBuff,
                        turns = times3,
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
            TeamReviveBuffPassive.new(50, 1) + SiegfeldOnlyCondition,
        ),
        listOf(
            TeamHpUpScalingPassive150.new(40) + WindOnlyCondition,
        ),
        listOf(
            CutinInitialCooldownReductionPassive.new(1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
)

val TitaniaShiro = dress4070003(
    name = "Titania Shiro",
    acts = listOf(
        ActType.Act1.blueprint("Enchanting Smash") {
            Act {
                targetBack(1).act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    //TODO(): locked SE seal
                }
                applyEnemyStageEffect(AlluringEyes, 2)
                //TODO(): neg ally se reduction
            }
        },
        ActType.Act2.blueprint("Pressure Smash") {
            Act {
                targetBack(1).act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    //TODO(): locked SE seal
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times4,
                    )
                }
                applyAllyStageEffect(Bullseye, 2)
                //TODO(): neg ally se reduction
            }
        },
        ActType.Act3.blueprint("Exuberant Smash") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
                targetBack(1).act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    //TODO(): locked SE seal
                }
                applyAllyStageEffect(GoldenVitality, 2)
                applyAllyStageEffect(RoyalAuthority, 2)
                //TODO(): neg ally se reduction
            }
        },
        ActType.ClimaxAct.blueprint("At the End of a Dream") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ReviveRegenBuff, //TODO(): determine if this stacks or not
                        value = values1,
                        turns = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    //TODO(): locked SE seal
                    //TODO(): revive reduction
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
                applyAllyStageEffect(ApplauseWind, 6)
                applyEnemyStageEffect(SelfTrapping, 2)
                //TODO(): neg ally se reduction
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(time = 1),
            TeamBrillianceRecoveryPassive.new(30),
            TeamAPDownBuffPassive.new(time = 1),
        ),
        listOf(
            SelfLockedNegativeCountableEffectResistanceUpBuffPassive.new(value = 100, time = 3),
            AllyStageEffectPassive(ElegantInvitation).new(value = 1, time = 1),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
            DispelTimedBuffPassive(NegativeEffectResistanceUpBuff).new(),
            EnemyElectricShockBuffPassive.new(time = 1),
            EnemyAPUpBuffPassive.new(time = 2),
            //TODO(): neg ally se reduction
        ),
        listOf(
            CutinInitialCooldownReductionPassive.new(1),
        )
    ),
    unitSkill = ActCritical75UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    multipleCA = true,
)
