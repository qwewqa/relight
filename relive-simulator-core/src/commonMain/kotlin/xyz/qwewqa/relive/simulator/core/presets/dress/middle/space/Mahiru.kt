package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030023
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030026
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val SorcererMahiru = dress1030023(
    name = "Sorcerer Mahiru",
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
        ActType.Act2.blueprint("Enchanting Pride") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Gravity Field") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Flash of Darkness") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedSpecialBarrierBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = Ap2DownBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = DexterityDownBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(10),
            TeamBrillianceRecoveryPassive.new(10) + SeishoOnlyCondition,
        ),
        listOf(
            TeamAP2DownBuffPassive.new(time = 1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022)
)

val AquariusMahiru = dress1030026(
    name = "Aquarius Mahiru",
    acts = listOf(
        ActType.Act1.blueprint("Sealing Smash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                    //TODO(): SE seal
                }
            }
        },
        ActType.Act2.blueprint("Smash of Light") {
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
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
                //TODO(): neg ally SE reduction
            }
        },
        ActType.Act3.blueprint("Fatal Smash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times3,
                    )
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Beautiful Torrent") {
            Act {
                targetAllyAoe().act {
                    heal(percent = values1)
                }
                targetAoe().act {
                    dispelCountable(BuffCategory.Positive, count = 3)
                    dispelTimed(NegativeCountableEffectResistanceBuff)
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times4,
                    )
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
                applyAllyStageEffect(ElegantInvitation, 2)
                applyAllyStageEffect(FloatingWithTheTide, 2)
                applyAllyStageEffect(SparklingTide, 2)
                //TODO(): neg ally se reduction
                applyEnemyStageEffect(CelestialHighlights, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(time = 1),
            TeamLockedAPDownBuffPassive.new(time = 1),
            TeamInvincibleRebirthBuffPassive.new(time = 1) + (FumiOnlyCondition or MichiruOnlyCondition),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(30),
            TeamBlessingHPRecoveryPassive.new(value = 100, time = 1),
            TeamBlessingCountableDebuffReductionPassive.new(value = 1, time = 1),
            TeamBlessingContinuousDebuffRemovalPassive.new(time = 1),
            TeamBrillianceGainUpBuffPassive.new(value = 50, time = 3),
            AllyStageEffectPassive(LightningShade).new(value = 1, time = 2),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50),
            DispelTimedBuffPassive(NegativeEffectResistanceBuff).new(),
            EnemyStunBuffPassive.new(time = 2),
            EnemyStageEffectPassive(PlanOfTheAbyss).new(value = 1, time = 1),
            EnemyStageEffectPassive(Hesitation).new(value = 1, time = 2),
            //TODO(): neg ally se reduction
        ),
        listOf(
            StaminaActUpPassive.new(value = 100),
            TurnHPRecoveryPassive.new(value = 20000),
        )
    ),
    unitSkill = ActCritical75UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    multipleCA = true,
)
