package xyz.qwewqa.relive.simulator.core.presets.dress.front.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.FreezeOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.HPDef75UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamBlindResistanceUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamConfusionResistanceUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamSleepResistanceUpBuffPassive

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
                        effect = EvasionUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DamageReceivedDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Shining Peace") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
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
            TeamBlindResistanceUpBuffPassive.new(time = 6),
        ),
        listOf(
            TeamConfusionResistanceUpBuffPassive.new(time = 6),
        ),
        listOf(
            TeamSleepResistanceUpBuffPassive.new(time = 6),
        ),
    ),
    unitSkill = HPDef75UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)
