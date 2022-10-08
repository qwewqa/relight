package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.Bullseye
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.AlluringEyes
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseMoon

val CollectionKaoruko = dress1090020(
    name = "Stage Girl Collection Kaoruko",
    acts = listOf(
        ActType.Act1.blueprint("Graceful Pose") {
            targetBack().act {
                attack(
                    modifier = values1,
                    hitCount = times1,
                )
            }
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
                // Unremovable seal stage effect
            }
        }
        ActType.Act2.blueprint("Graceful Walk") {
            targetBack().act {
                attack(
                    modifier = values1,
                    hitCount = times1,
                )
            }
            applyEnemyStageEffect(AlluringEyes, 2)
        }
        ActType.Act3.blueprint("Graceful Smile") {
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
        ActType.ClimaxAct.blueprint("Kaoruko Hanayagi's Runway") {
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
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        )
        listOf(
            EnemyDazeBuffPassive.new(1),
        )
        listOf(
            EnemyBrillianceDrainPassive.new(30),
            TeamBrillianceRecoveryPassive.new(20),
        )
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
    multipleCA = true,
)