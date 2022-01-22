package xyz.qwewqa.relive.simulator.core.presets.dress.front.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.FreezeOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val HierophantMichiru = dress4020004(
    name = "Hierophant Michiru",
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
        ActType.Act2.blueprint("Trustworthy Light") {
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
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("King's Guidance") {
            Act {
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
                        turns = times1,

                        )
                }
                targetSelf().act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
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
        ActType.ClimaxAct.blueprint("Shining Peace") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 4,
                        bonusMultiplier = 150,
                        bonusCondition = FreezeOnlyCondition,
                    )
                } // TODO() Check Freeze Amp
                // TODO() Exit Removal
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamBlindnessResistanceBuffPassive.new(time = 6),
        ),
        listOf(
            TeamConfusionResistanceBuffPassive.new(time = 6),
        ),
        listOf(
            TeamSleepResistanceBuffPassive.new(time = 6),
        ),
    ),
    unitSkill = HPDef75UnitSkill + SnowOnlyCondition,
    category = DressCategory.Arcana,
)
