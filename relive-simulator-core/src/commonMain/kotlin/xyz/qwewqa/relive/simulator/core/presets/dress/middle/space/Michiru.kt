package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val JoshuaMichiru = dress4020014(
    name = "First Lieutenant Joshua Michiru",
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
        ActType.Act2.blueprint("Victory Strategy") {
            Act {
                targetFront(3).act {
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.Act3.blueprint("Blade of Justice") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyFront(3).act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Purge Blade") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                        bonusMultiplier = 150,
                        bonusCondition = SpecialDamageOnlyCondition,
                    )
                    applyBuff(
                        effect = StopBuff,
                        turns = times2,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyActPowerDownBuffPassive.new(20,3),
        ),
        listOf(
            TeamStopResistanceBuffPassive.new(100,3)
        ),
        listOf(
            EffectiveDamageDealtPassive.new(20)
        ),
    ),
    unitSkill = ActCritical30UnitSkill + MiddleOnlyCondition,
)
