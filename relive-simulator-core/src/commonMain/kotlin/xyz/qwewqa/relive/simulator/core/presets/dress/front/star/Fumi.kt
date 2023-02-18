package xyz.qwewqa.relive.simulator.core.presets.dress.front.star

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val RedDukeRichelieuFumi = dress2030020(
    name = "Red Duke Richelieu Fumi",
    acts = listOf(
        Act1.blueprint("Seal Slash") {
            Act {
                targetAllyFront(2).act {
                    applyBuff(
                        effect = BrillianceGainUpBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = AggroBuff,
                        turns = times3,
                    )
                    //TODO(): SE seal
                }
                targetBack().act {
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
            }
        },
        Act2.blueprint("Resolute Slash") {
            Act {
                targetAllyFront(2).act {
                    applyBuff(
                        effect = BrillianceGainUpBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
                        turns = times4,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
                //TODO: Reduce negative ally SE level
            }
        },
        Act3.blueprint("Happy Slash") {
            Act {
                targetAllyFront(2).act {
                    applyBuff(
                        effect = BrillianceGainUpBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedApDownBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
                        turns = times3,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(MellowFlavor, 2)
            }
        },
        ClimaxAct.blueprint("Flowers of Evil") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = LockedResilienceBuff,
                        turns = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyBuff(
                        effect = LockedAggroBuff,
                        turns = times5,
                    )
                }
                applyEnemyStageEffect(BattleStrategy, 2)
                applyEnemyStageEffect(ShadowStupor, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfInvincibleRebirthBuffPassive.new(time = 1),
            SelfFortitudeBuffPassive.new(time = 2),
            TeamReviveBuffPassive.new(time = 1),
            TeamLockedInvincibilityBuffPassive.new(time = 1),
        ),
        listOf(
            DispelTimedBuffPassive(NegativeEffectResistanceUpBuff).new(),
            EnemyLockedAggroBuffPassive.new(time = 2),
            EnemyAPUpBuffPassive.new(time = 2),
            EnemyStageEffectPassive(Thunder).new(value = 1, time = 2),
            EnemyStageEffectPassive(AfterlifeTrials).new(value = 1, time = 2),
            EnemyStageEffectPassive(BattleStrategy).new(value = 3, time = 2),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
            TeamBrillianceRecoveryPassive.new(50),
            TeamBlessingHPRecoveryPassive.new(100, 1),
            AllyStageEffectPassive(GoldenVitality).new(value = 1, time = 6),
        ),
        listOf(
            TeamActUpScalingPassive120.new(30) + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition),
            SelfActUpScalingPassive120.new(30) + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition),
            //TODO(): Passive SE Seal Resist
            HpUpPassive.new(50),
        ),
    ),
    unitSkill = (ActCritical25UnitSkill + (SpaceOnlyCondition or MoonOnlyCondition or CloudOnlyCondition)) + SelfActCritical25UnitSkill,
    categories = setOf(DressCategory.Birthday2023),
)
