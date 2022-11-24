package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val SageJunna = dress1060023(
    name = "Sage Junna",
    acts = listOf(
        ActType.Act1.blueprint("Wise Guidance") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    dispelTimed(BuffCategory.Positive)
                }
                // TODO(): Unremovable seal stage effect
            }
        },
        ActType.Act2.blueprint("Talented Guidance") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Future Guidance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetBack(3).act {
                    addBrilliance(-values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Tome of Wisdom") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                focus {
                    targetAoe().act {
                        applyCountableBuff(
                            effect = CountableBuff.Daze,
                            count = times2,
                        )

                        // TODO(): Revive Reduction

                        // TODO(): Fortitude Reduction

                        attack(
                            modifier = values5,
                            hitCount = times5,
                        )
                    }
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
            BrillianceRecoveryPassive.new(100),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50),
        ),
        listOf(
            SelfLockedNegativeEffectResistanceBuffPassive.new(100, 2),
            SelfLockedNegativeCountableEffectResistanceBuffPassive.new(100, 2),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Birthday2022),
)
