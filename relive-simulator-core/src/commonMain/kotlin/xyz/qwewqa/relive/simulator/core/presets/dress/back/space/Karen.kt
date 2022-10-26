package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseSpace
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping

val PrincessKaren = dress1010023(
    name = "Princess Karen",
    acts = listOf(
        ActType.Act1.blueprint("Light of Hope") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    //TODO(): Disaster [Kira] Countable
                }
            }
        },
        ActType.Act2.blueprint("Fight Together") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(ApplauseSpace, 6)
            }
        },
        ActType.Act3.blueprint("Dominate Evil") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Light of Rescue") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    //TODO(): Count Negative Effects Reduction (3)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetFront().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(50, time = 1) + SpaceOnlyCondition,
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
            TeamEffectiveDamageDealtUpBuffPassive.new(20, 3),
            TeamBrillianceRecoveryPassive.new(20),
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
            NegativeCountableResistancePassive.new(100),
        ),
        //Oath Revue +50% Dmg to Self
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
