package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val SunIchie = dress2020003(
    name = "Sun Ichie",
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
        ActType.Act2.blueprint("Sun Glamor") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        ActPowerDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        AccuracyRateDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Raging Sun") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        BurnBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Brilliant☆Sunshine!") {
            Act {
                log ("TODO") { "Burn Amp not implemented" }
                targetAoe().act {
                    applyBuff(
                        LockedBurnBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        SpecialDefenseDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    attack(
                        modifier = values3,
                        hitCount = 4,
                        //TODO: bonusMultiplier = 150, bonusCondition = BurnOnlyCondition,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            EnemyActPowerDownBuffPassive.new(20,3),
        ),
        listOf(
            EnemyDexterityDownBuffPassive.new(10,3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + FlowerOnlyCondition,
)