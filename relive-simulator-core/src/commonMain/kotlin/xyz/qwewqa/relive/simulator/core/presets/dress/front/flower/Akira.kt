package xyz.qwewqa.relive.simulator.core.presets.dress.front.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4010015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val EmperorAkira = dress4010015(
    name = "Emperor Akira",
    acts = listOf(
        ActType.Act1.blueprint("Ardent Thrust") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Emperor's Authority") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = SpecialBarrierBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Emperor's Prestige") {
            Act {
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
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
        ActType.ClimaxAct.blueprint("Galactic Kaiser-Walzer") {
            Act {
                targetByHighest { it.actPower }.act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = times1,
                    )
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamHpUpPassive.new(20),
        ),
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            EnemyAggroBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = HPDef75UnitSkill + FlowerOnlyCondition,
    category = DressCategory.Arcana,
)
