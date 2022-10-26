package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val MerchantKaoruko = dress1090023(
    name = "Merchant Kaoruko",
    acts = listOf(
        ActType.Act1.blueprint("Flash of Brilliance") {
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
        ActType.Act2.blueprint("Flash of Purification") {
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
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Merchant's Wallet") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetFront(2).act {
                    applyBuff(
                        effect = FreezeBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("The Secret of Commerce") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalBarrierBuff, //TODO() Change to locked version (wasn't sure how to add to damage calc correctly)
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = ApDownBuff,  //TODO() Find out if locked or not
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = DexterityDownBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfEvasionBuffPassive.new(time = 4),
        ),
        listOf(
            TeamHpUpPassive.new(30),
        ),
        listOf(
            TeamNegativeEffectResistanceBuffPassive.new(100, 1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
