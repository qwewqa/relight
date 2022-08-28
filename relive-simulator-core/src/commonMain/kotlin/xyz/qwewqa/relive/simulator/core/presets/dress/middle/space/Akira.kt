package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping

val DelightAkira = dress4010019(
    name = "Delight Akira",
    acts = listOf(
        ActType.Act1.blueprint("Thrust of Brilliance") {
            Act {
                targetBack().act {
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
        ActType.Act2.blueprint("Thrust of Tension") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.Act3.blueprint("Fading Thrust") {
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
        ActType.ClimaxAct.blueprint("Delight ~The King's Majesty~") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedResilienceBuff,
                        turns = times1,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                    applyBuff(
                        effect = PoisonBuff,
                        value = values4,
                        turns = times4,
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
            TeamNegativeEffectResistanceBuffPassive.new(100, 1),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = (ActCritical50UnitSkill + SpaceOnlyCondition) + (ActCritical50UnitSkill + MiddleOnlyCondition),
)
