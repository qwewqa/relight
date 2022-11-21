package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4070002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedNegativeCountableResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedNegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

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
                        effect = LockedNegativeEffectResistanceBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = LockedNegativeCountableResistanceBuff,
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
