package xyz.qwewqa.relive.simulator.core.presets.dress.middle.star

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val SiegfriedNana = dress1070020(
    name = "Siegfried Nana",
    acts = listOf(
        Act1.blueprint("Sword of Longing") {
            Act {
                targetSelf().act {
                    addBrilliance(values1)
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
                targetBack(2).act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                //TODO: Reduce negative ally SE level
            }
        },
        Act2.blueprint("Sword of Courage") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack(2).act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                //TODO: Reduce negative ally SE level
            }
        },
        Act3.blueprint("Sword for Evil") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    dispelTimed(NegativeEffectResistanceBuff)
                    //TODO: Locked SE Seal
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times4,
                    )
                }
                //TODO: Reduce negative ally SE level
            }
        },
        ClimaxAct.blueprint("Balmung of Love") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = PrideResistanceBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DazeResistanceBuff,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                        count = times5,
                    )
                }
                //TODO: Reduce negative ally SE level
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(50, 1),
        ),
        listOf(
            TeamNegativeEffectResistanceBuffPassive.new(100, 2),
            SelfLockedNegativeEffectResistanceBuffPassive.new(100, 2),
        ),
        listOf(
            TeamBlessingCountableDebuffReductionPassive.new(2, 1),
            TeamBlessingHPRecoveryPassive.new(20, 1),
        ),
        listOf(
            TeamActUpScalingPassive120.new(30) + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition),
            SelfActUpScalingPassive120.new(30) + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition),
        ),
    ),
    unitSkill = (ActCritical25UnitSkill + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition)) + SelfActCritical25UnitSkill,
    multipleCA = true,
)
