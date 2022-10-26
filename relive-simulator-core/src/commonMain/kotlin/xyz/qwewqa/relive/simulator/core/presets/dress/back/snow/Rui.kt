package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2040012
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2040017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val StageGirlRui = dress2040017(
    name = "Stage Girl Rui",
    acts = listOf(
        ActType.Act1.blueprint("Ardent Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Resolute Blade") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                        bonusMultiplier = 150,
                        bonusCondition = SpecialDamageOnlyCondition,
                    )
                    applyBuff(
                        ActPowerDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        NormalDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Strike of Determination") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        ApDownBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("My life is on this stage!") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values2,
                        hitCount = 10,
                    )

                    applyBuff(
                        StopBuff,
                        turns = 1,
                        chance = 33,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamEffectiveDamageDealtUpBuffPassive.new(20, time = 3),
        ),
        listOf(
            TeamCriticalUpBuffPassive.new(20, time = 3),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20) + TamaoOnlyCondition,
        )
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.StageGirl),
)

val OfficerRui = dress2040012(
    name = "Officer Akikaze Rui",
    acts = listOf(
        ActType.Act1.blueprint("Police Interrogation") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Emergency Deployment") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Rushing to the Scene") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Officer Akikaze's Dramatic Arrest") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values5,
                        hitCount = 10,
                    )
                    applyCountableBuff(
                        CountableBuff.Daze,
                        chance = 33,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            ConditionalDamageDealtPassive(FrontierOnlyCondition).new(20),
        ),
        listOf(
            EnemyBack3LockedAPUpBuffPassive.new(time = 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
)
