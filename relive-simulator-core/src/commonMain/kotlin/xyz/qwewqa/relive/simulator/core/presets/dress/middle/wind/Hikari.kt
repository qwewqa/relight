package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020004
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val TowerHikari = dress1020004(
    name = "Tower Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Walled Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        NormalBarrierBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Destruction Begins") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        PerfectAimBuff,
                        turns = times1,
                    )
                    applyBuff(
                        DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetFront().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Imminent Calamity") {
            Act {
                targetAoe().act {
                    applyBuff(
                        MarkBuff,
                        turns = times1,
                    )
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Tower's Conviction") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 5,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        CountableBuff.Evasion,
                        count = times2,
                    )
                    applyCountableBuff(
                        CountableBuff.Fortitude,
                        count = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            TeamCriticalUpBuffPassive.new(20, time = 3),
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(10, time = 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
    categories = setOf(DressCategory.Arcana, DressCategory.TroupeRevueShop),
)
