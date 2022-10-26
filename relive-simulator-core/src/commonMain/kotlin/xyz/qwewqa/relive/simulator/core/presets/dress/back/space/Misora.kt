package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3020009
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.CounterHealBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.InvincibilityBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical30UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.StunResistancePassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpRegenBuffPassive

val LittlePrinceMisora = dress3020009(
    name = "Little Prince Misora",
    acts = listOf(
        ActType.Act1.blueprint("Strong Thrust") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Snake Bite") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Fox Guidance") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = CounterHealBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("End of the Journey") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetAllyFront(5).act {
                    applyBuff(
                        effect = InvincibilityBuff,
                        turns = times2,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            StunResistancePassive.new(100),
        ),
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            TeamHpRegenBuffPassive.new(2000, 3),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + BackOnlyCondition,
)
