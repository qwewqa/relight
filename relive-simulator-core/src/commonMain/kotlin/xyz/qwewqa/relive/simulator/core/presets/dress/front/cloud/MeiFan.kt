package xyz.qwewqa.relive.simulator.core.presets.dress.front.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030003
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyProvokeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.HPDef75UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.NegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive

val EmpressMeiFan = dress4030003(
    name = "Empress Mei Fan",
    acts = listOf(
        ActType.Act1.blueprint("Strong Thrust") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Ironclad Bestowal") {
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
        ActType.Act3.blueprint("Whole Protection") {
            Act {
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
                        turns = times1,

                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = EvasionUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DamageReceivedDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Empress's Gloom") {
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
    unitSkill = HPDef75UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)
