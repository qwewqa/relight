package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.DeathsKiss

val LokiYachiyo = dress4050013(
    name = "Loki Yachiyo",
    acts = listOf(
        ActType.Act1.blueprint("Brilliance Slash") {
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
        ActType.Act2.blueprint("Prank") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                applyEnemyStageEffect(DeathsKiss,3)
            }
        },
        ActType.Act3.blueprint("Mischief") {
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
        ActType.ClimaxAct.blueprint("Trickster") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetBack(3).act {
                    //TODO() Locked CX Seal & Locked Act 3 Seal
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50,2),
        ),
        listOf(
            TeamHpUpPassive.new(20),
            TeamHpUpPassive.new(20) + SiegfeldOnlyCondition,
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(10),
            TeamBrillianceRecoveryPassive.new(10) + SiegfeldOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SiegfeldOnlyCondition,
)
