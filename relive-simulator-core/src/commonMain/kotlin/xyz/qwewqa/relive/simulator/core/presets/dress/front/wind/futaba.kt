package xyz.qwewqa.relive.simulator.core.presets.dress.front.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1080004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val StrengthFutaba = dress1080004(
    name = "Strength Futaba",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Purity of Strength", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Resilient Protection", 1) {
            Act {
                targetAoe().act {
                    applyBuff(
                        effect = Aggro,
                        turns = times1,

                        )
                }
                targetSelf().act {
                    applyBuff(
                        effect = CounterHeal,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DamageTakenDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Lion's Roar", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 5,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = HpRegenBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamConfusionResistanceBuffPassive.new(time = 6),
        ),
        listOf(
            TeamFreezeResistanceBuffPassive.new(time = 6),
        ),
        listOf(
            TeamStunResistanceBuffPassive.new(time = 6),
        ),
    ),
    unitSkill = HPDef75UnitSkill + WindOnlyCondition,
    category = DressCategory.Arcana,
)
