package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1040024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.FlamesFallingTogether

val SoulRevueClaudine = dress1040024(
    name = "Soul Revue Claudine",
    acts = listOf(
        Act1.blueprint("Slash of Brilliance") {
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
        Act2.blueprint("Lacking Soul") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetBack(3).act {
                    // TODO: Count. dispel correctly
                    // reduceCountable(BuffCategory.Positive)
                }
            }
        },
        Act3.blueprint("Shining Talent") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(2).act {
                    addBrilliance(values2)
                }
            }
        },
        ClimaxAct.blueprint("Tonight with brilliance") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Fortitude,
                        count = times2,
                    )
                }
                targetAoe().act {
                    // reduceCountable(BuffCategory.Positive)
                    // TODO: Count. dispel correctly
                    attack(
                        // TODO: Attack ignores aggro, provoke, barriers, reflect, invincibility
                        modifier = values4,
                        hitCount = 3,
                    )
                }
                applyAllyStageEffect(FlamesFallingTogether, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyPrideBuffPassive.new(2) + NormalDamageOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + NormalDamageOnlyCondition,
        ),
        listOf(
            EnemyAPUpBuffPassive.new( time = 3) + NormalDamageOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
)
