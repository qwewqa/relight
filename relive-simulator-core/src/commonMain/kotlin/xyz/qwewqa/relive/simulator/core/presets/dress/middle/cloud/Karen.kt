package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val MitsuhideKaren = dress1010018(
    name = "Akechi Mitsuhide Karen",
    acts = listOf(
        ActType.Act1.blueprint("Limitless Radiance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Cloud Piercing") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Gale Blade") {
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
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Flames of Justice") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 5,
                    )
                }
                // TODO: SE & Resilience
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + NormalDamageOnlyCondition,
)
