package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050007
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBack3StopBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfReviveBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive

val WorldMaya = dress1050007(
    name = "World Maya",
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
        ActType.Act2.blueprint("Sky and Earth") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Light and Darkness") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Genesis of Unmatched Brilliance") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = StopBuff,
                        turns = times3,
                        chance = 80,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            TeamHpUpPassive.new(30),
        ),
        listOf(
            EnemyBack3StopBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)
