package xyz.qwewqa.relive.simulator.core.presets.dress.front.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val EmpressMeiFan = dress4030003(
    name = "Empress Mei Fan",
    acts = listOf(
        ActType.Act1.blueprint("Strong Thrust", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Ironclad Bestowal", 2) {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalBarrierBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = SpecialBarrierBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Whole Protection", 1) {
            Act {
                targetAoe().act {
                    applyBuff(
                        effect = Aggro,
                        turns = times1,

                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DamageTakenDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Empress's Gloom", 2) {
            Act {
                targetAllyAoe().act {
                    flipTimed(BuffCategory.Negative, times1)
                }
                targetAoe().act {
                    flipTimed(BuffCategory.Positive, times2)
                    attack(
                        modifier = values3,
                        hitCount = 4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyProvokeBuffPassive.new(time = 2),
        ),
        listOf(
            NegativeEffectResistancePassive.new(50),
        ),
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = HPDef75UnitSkill + CloudOnlyCondition,
    category = DressCategory.Arcana,
)
