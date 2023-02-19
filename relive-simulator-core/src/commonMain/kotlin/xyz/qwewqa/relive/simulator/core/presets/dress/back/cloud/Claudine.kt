package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.MarkBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical30UnitSkillStageGirl
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamBurnResistanceUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamConfusionResistanceUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamStunResistanceUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageCloud

val StageGirlClaudine = dress1040017(
    name = "Stage Girl Claudine",
    acts = listOf(
        ActType.Act1.blueprint("Marked Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = MarkBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Purifying Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyFront(3).act {
                    dispelTimed(BuffCategory.Negative)
                }
            }
        },
        ActType.Act3.blueprint("Synchro of Brilliance") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("C'est moi! la star!") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = SpecialReflectBuff,
                        value = values4,
                        turns = times4,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageCloud, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamConfusionResistanceUpBuffPassive.new(100, 3),
        ),
        listOf(
            TeamBurnResistanceUpBuffPassive.new(100, 3),
        ),
        listOf(
            TeamStunResistanceUpBuffPassive.new(100, 3),
        ),
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.StageGirl),
)
