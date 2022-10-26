package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2050010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.DamageDealtPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.DamageTakenDownPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamCriticalUpBuffPassive

val MagicianYuyuko = dress2050010(
    name = "Magician Yuyuko",
    acts = listOf(
        Act1.blueprint("Static Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = AgilityDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        Act2.blueprint("Weakening Magic") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        },
        Act3.blueprint("Protection of Brilliance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = SpecialBarrierBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ClimaxAct.blueprint("Arcanum Magicae") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = times3,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = values4,
                        turns = times4,
                    )
                    applyBuff(
                        effect = MarkBuff,
                        turns = times5,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            DamageDealtPassive.new(7),
        ),
        listOf(
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            DamageTakenDownPassive.new(10),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)
