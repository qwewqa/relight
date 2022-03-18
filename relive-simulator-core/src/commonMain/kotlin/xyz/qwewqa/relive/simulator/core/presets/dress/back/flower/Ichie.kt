package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.CriticalUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.EffectiveDamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical30UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.DamageDealtPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.DexterityPassive

val KondoIsamiIchie = dress2020014(
    name = "Kondo Isami Ichie",
    acts = listOf(
        ActType.Act1.blueprint("Strong Flash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Warrior's Pride") {
            Act {
                targetSelf().act {
                    applyBuff(
                        DexterityUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        CriticalUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetFront().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Tough Blade") {
            Act {
                targetSelf().act {
                    applyBuff(
                        ActPowerUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetFront().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Kotetsu's Roar") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values2,
                        hitCount = 3,
                        bonusMultiplier = 150,
                        bonusCondition = NormalDamageOnlyCondition,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            DamageDealtPassive.new(10),
        ),
        listOf(
            DexterityPassive.new(10),
        ),
        listOf(
            DamageDealtPassive.new(10),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + BackOnlyCondition,
)
