package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020012
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val HeroHikari = dress1020023(
    name = "Hero Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Strike of Brilliance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Strike of Weakness") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetBack(2).act {
                    applyCountableBuff(CountableBuff.WeakSpot)
                }
            }
        },
        ActType.Act3.blueprint("Weakening Strike") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = ClimaxDamageDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Legendary Hero") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = BrillianceRegenBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CounterHealBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfEvasionBuffPassive.new(time = 5),
        ),
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            TeamCriticalUpBuffPassive.new(30,3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)

val SleepingBeautyHikari = dress1020012(
    name = "Sleeping Beauty Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Nightmare Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 50,
                        turns = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Blessed Rondo") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyFront(3).act {
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Tragic Thorns") {
            Act {
                targetBack(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = MarkBuff,
                        turns = 2,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 50,
                        turns = 2,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            DamageDealtPassive.new(10),
        ),
        listOf(
            DexterityPassive.new(16),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + BackOnlyCondition,
)

