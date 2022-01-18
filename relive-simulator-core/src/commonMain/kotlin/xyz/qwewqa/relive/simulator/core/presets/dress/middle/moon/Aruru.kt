package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.ArcanaOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3010015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val MoonAruru = dress3010015(
    name = "Moon Aruru",
    acts = listOf(
        ActType.Act1.blueprint("Moonlight's Brilliance", 1) {
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
        ActType.Act2.blueprint("Moonlight Madness", 3) {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Moon Halo", 4) {
            Act {
                targetAllyBack(5).act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Rising Moon☆Rampage！", 2) {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = LockedPositiveEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(50) + ArcanaOnlyCondition,
        ),
        listOf(
            TeamEvasionBuffPassive.new(time = 5) + ArcanaOnlyCondition,
        ),
        listOf(
            TeamReviveBuffPassive.new(50, time = 2) + ArcanaOnlyCondition,
        )
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
    category = DressCategory.Arcana,
)