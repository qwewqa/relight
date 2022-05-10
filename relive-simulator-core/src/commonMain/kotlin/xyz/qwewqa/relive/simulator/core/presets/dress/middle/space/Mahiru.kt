package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020018 //1030023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val SorcererMahiru = dress2020018(
    name = "Sorcerer Mahiru",
    acts = listOf(
        ActType.Act1.blueprint("Smash of Brilliance") {
            Act {
                targetBack().act {
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
        ActType.Act2.blueprint("Enchanting Pride") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Gravity Field") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Flash of Darkness") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedSpecialBarrierBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = Ap2DownBuff,
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
            SelfReviveBuffPassive.new(50, time = 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(10),
            TeamBrillianceRecoveryPassive.new(10) + SeishoOnlyCondition,
        ),
        listOf(
            TeamAP2DownBuffPassive.new(time = 1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
    categories = setOf(DressCategory.Birthday2022)
)
