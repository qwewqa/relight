package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.DisasterHail


val DancerClaudine = dress1040023(
    name = "Dancer Claudine",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
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
        ActType.Act2.blueprint("Utsusemi Dance") {
            Act {
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                }
            }
        },
        ActType.Act3.blueprint("Bubble Dance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetBack(3).act {
                    dispelTimed(NegativeEffectResistanceBuff)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Regenerating Dance") {
            Act {
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyEnemyStageEffect(DisasterHail, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
        listOf(
            TeamActUpScalingPassive100.new(30) + FlowerOnlyCondition
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
