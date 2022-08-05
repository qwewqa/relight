package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.RinmeikanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val EurydiceYuyuko = dress2050018(
    name = "Eurydice Yuyuko",
    acts = listOf(
        ActType.Act1.blueprint("Strike of Brilliance") {
            Act {
                targetByHighest { it.actPower }.act {
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
        ActType.Act2.blueprint("Strength of Awaiting") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe(RinmeikanOnlyCondition).act {
                    dispelTimed(BuffCategory.Negative),
                    reduceCountable(BuffCategory.Negative)
                }
            }
        },
        ActType.Act3.blueprint("Power to Believe") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe(RinmeikanOnlyCondition).act {
                    applyCountableBuff(
                        CountableBuff.Hope,
                        count = times2,
                    )
                    applyBuff(
                        ApDownBuff,
                        turns = times3
                    )
                    addBrilliance(values4)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Empty Prayer") {
            Act {
                targetAoe().act {
                    // TODO: reducing only revive
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive(time = 4)
        ),
        listOf(
            TeamHpUpPassive.new(20),
            TeamHpUpPassive.new(20) + RinmeikanOnlyCondition,
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 2) + RinmeikanOnlyCondition,
        )
    ),
    unitSkill = ActCritical50UnitSkill + FlowerOnlyCondition,
    categories = setOf(DressCategory.Birthday2022),
)