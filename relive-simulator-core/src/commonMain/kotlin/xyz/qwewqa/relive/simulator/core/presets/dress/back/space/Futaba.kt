package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1080017
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageSpace

val StageGirlFutaba = dress1080017(
    name = "Stage Girl Futaba",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Cursed Slash") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = HPRecoveryDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Relaxing Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("I will dash forth with fighting spirit!") {
            Act {
                targetAoe().act {
                    applyBuff(
                        effect = HPRecoveryDownBuff,
                        value = values1,
                        turns = times1,
                    )
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageSpace, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfEvasionBuffPassive.new(time = 1),
        ),
        listOf(
            StunResistancePassive.new(100),
        ),
        listOf(
            DexterityPassive.new(15),
        ),
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + SpaceOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
