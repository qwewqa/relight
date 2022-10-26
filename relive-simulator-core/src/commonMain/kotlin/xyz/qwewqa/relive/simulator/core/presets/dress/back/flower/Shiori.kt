package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val ShutendojiShiori = dress4040018(
    name = "Shuten-doji Shiori",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Purifying Strike") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetFront().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Profusion of Flowers") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetFront(2).act {
                    applyBuff(
                        effect = AgonyBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Nocturne Game") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                    applyBuff(
                        effect = LockedResilienceBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                    applyBuff(
                        effect = AgonyBuff,
                        turns = times4,
                        chance = hitRate4,
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
            TeamHpUpPassive.new(20),
            TeamHpUpPassive.new(20) + SiegfeldOnlyCondition,
        ),
        listOf(
            TeamNegativeEffectResistanceBuffPassive.new(100, 1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
