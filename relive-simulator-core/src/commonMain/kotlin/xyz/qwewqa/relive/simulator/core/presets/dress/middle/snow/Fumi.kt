package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030011
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3030015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val NagakuraShinpachiFumi = dress2030011(
    name = "Nagakura Shinpachi Fumi",
    acts = listOf(
        ActType.Act1.blueprint("Evasion Strike") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(3).act {
                    applyCountableBuff(
                        CountableBuff.Evasion,
                        count = times2
                    )
                }
            }
        },
        ActType.Act2.blueprint("Severing Blade") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.Act3.blueprint("Sacred Blade") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Flying Dragon") {
            Act {
                targetSelf().act {
                    applyBuff(
                        ActPowerUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values4,
                        hitCount = 3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamActPowerUpBuffPassive.new(10, time = 3),
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(10, time = 3),
        ),
        listOf(
            TeamSpecialDefenseUpBuffPassive.new(10, time = 3),
        ),
    ),
    unitSkill = HP50Def30UnitSkill + MiddleOnlyCondition,
)