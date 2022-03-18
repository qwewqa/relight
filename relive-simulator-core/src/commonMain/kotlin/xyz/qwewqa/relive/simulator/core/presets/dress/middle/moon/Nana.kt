package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val HelldiverNana = dress1070019(
    name = "Helldiver Nana",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
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
        ActType.Act2.blueprint("Dynamic Attack") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = LockedStunBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Carefree Strike") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.WeakSpot,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Nightmare Show") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.WeakSpot,
                    )
                    applyBuff(
                        effect = LockedStunBuff,
                        turns = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            NegativeEffectResistancePassive.new(50),
        ),
        listOf(
            TeamAgilityUpBuffPassive.new(10, time = 3),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20) + NanaOnlyCondition,
            TeamBrillianceRecoveryPassive.new(20) + JunnaOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
)
