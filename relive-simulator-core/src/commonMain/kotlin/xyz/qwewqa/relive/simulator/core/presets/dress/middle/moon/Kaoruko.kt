package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.AlluringEyes
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseMoon
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.Bullseye

val CollectionKaoruko = dress1090020(
    name = "Stage Girl Collection Kaoruko",
    acts = listOf(
        ActType.Act1.blueprint("Graceful Pose") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                    // Unremovable seal stage effect
                }
            }
        },
        ActType.Act2.blueprint("Graceful Walk") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                applyEnemyStageEffect(AlluringEyes, 2)
            }
        },
        ActType.Act3.blueprint("Graceful Smile") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyFront(2).act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Kaoruko Hanayagi's Runway") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
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
                }
                applyAllyStageEffect(Bullseye, 2)
                applyAllyStageEffect(ApplauseMoon, 6)
            }
        },
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(1),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
            TeamBrillianceRecoveryPassive.new(20),
        ),
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    multipleCA = true,
)
