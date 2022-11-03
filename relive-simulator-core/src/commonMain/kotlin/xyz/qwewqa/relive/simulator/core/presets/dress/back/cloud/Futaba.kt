package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1080024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BrillianceGainDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedNegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.YoureAllHopeless

val GrudgeRevueFutaba = dress1080024(
    name = "Grudge Revue Futaba",
    acts = listOf(
        Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByLowest { it.normalDefense }.act {
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
        Act2.blueprint("Dimming Slash") {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = BrillianceGainDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        Act3.blueprint("Fruits of Effort") {
            Act {
                targetAllyBack(5).act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ClimaxAct.blueprint("This is the Parting Road") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(CountableBuff.Revive, count = times1)
                    applyBuff(
                        effect = LockedNegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(YoureAllHopeless, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            SelfNegativeEffectResistanceBuffPassive.new(time = 3),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
        listOf(
            TeamNegativeCountableResistanceBuffPassive.new(100, 1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Movie),
)
