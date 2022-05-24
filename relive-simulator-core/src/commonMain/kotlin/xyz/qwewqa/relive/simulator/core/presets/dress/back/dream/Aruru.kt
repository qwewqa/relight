package xyz.qwewqa.relive.simulator.core.presets.dress.back.dream

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010018
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*

val WhiteFrontierAruru = dress3010018(
    name = "White Frontier Aruru",
    acts = listOf(
        Act1.blueprint("Power Sharpshooting") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        Act2.blueprint("Purifying Sharpshooting") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = 1,
                    )
                }
            }
        },
        Act3.blueprint("Carefree Sharpshooting") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        },
        ClimaxAct.blueprint("Rising White Blaster") {
            Act {
                targetAllyFront(5).act {
                    applyBuff(
                        effect = InvincibilityBuff,
                        turns = times1,
                    )
                }
                targetAoe().act {
                    // TODO: Attack ignores aggro, provoke, barriers, reflect, and invincibility
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = FreezeBuff,
                        turns = times3,
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
            NegativeEffectResistancePassive.new(50),
            NegativeCountableResistancePassive.new(50),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time=1),
        )
    ),
    unitSkill = ActCritical30UnitSkill + NormalDamageOnlyCondition,
    categories = setOf(DressCategory.Birthday2022)
)
