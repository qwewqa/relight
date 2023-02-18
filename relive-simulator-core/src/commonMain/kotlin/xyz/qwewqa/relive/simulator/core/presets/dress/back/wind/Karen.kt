package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialReflectBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfReviveBuffPassive

val OfficerKaren = dress1010021(
    name = "Officer Karen",
    acts = listOf(
        ActType.Act1.blueprint("Reaching Out") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
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
        ActType.Act2.blueprint("Strong Sense of Justice") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Healthy Body") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                // TODO: Remove Countable Debuffs
            }
        },
        ActType.ClimaxAct.blueprint("Officer Aijo's Traffic Safety") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = SpecialReflectBuff,
                        value = values2,
                        turns = times2,
                    )
                    // TODO: Remove Countable Debuffs
                }
                targetAoe().act{
                    attack(
                        modifier = values4,
                        hitCount = 6,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            // TODO: Countable NER Team Passive
        ),
        listOf(
            // TODO: Countable NER Self Passive
        )
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
)
