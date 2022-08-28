package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3050018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val BlackShizuha = dress3050018(
    name = "Black Frontier Shizuha",
    acts = listOf(
        ActType.Act1.blueprint("Humble Slash") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times3,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Anguish Slash") {
            Act {
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    applyBuff(
                        effect = AgonyBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Mortifying Slash") {
            Act {
                targetByHighest { (it.actPower) }.act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    applyBuff(
                        effect = AgonyBuff,
                        turns = times3,
                    )
                    addBrilliance(-values4)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Black Tempest Break") {
            Act {
                targetBack(3).act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.WeakSpot,
                        count = times2,
                    )
                    applyBuff(
                        effect = AgonyBuff,
                        turns = times3,
                    )
                    focus {
                        attack(
                            modifier = values4,
                            hitCount = times4,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            //TODO(): Revive Reduction
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
        ),
        listOf(
            TeamNegativeEffectResistanceBuffPassive.new(100, 1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SnowOnlyCondition,
    categories = setOf(DressCategory.Birthday2022),
)
