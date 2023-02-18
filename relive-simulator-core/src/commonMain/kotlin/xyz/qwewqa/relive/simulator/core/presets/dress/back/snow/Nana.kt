package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*


val FruitTartNana = dress1070021(
    name = "Fruit Tart Nana",
    acts = listOf(
        ActType.Act1.blueprint("Happy Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times4,
                    )
                }
                applyAllyStageEffect(BloomingFlowers, 2)
            }
        },
        ActType.Act2.blueprint("Slash of Hope") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetBack(2).act {
                    removeBrilliance(values2)
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times4,
                    )
                }
                applyEnemyStageEffect(
                    effect = SelfTrapping,
                    level = 2,
                    turns = 2
                )
            }
        },
        ActType.Act3.blueprint("Thunder Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                applyEnemyStageEffect(
                    effect = Thunder,
                    level = 2,
                    turns = 2
                )
                applyAllyStageEffect(
                    effect = ApplauseSnow,
                    turns = 6,
                )

            }
        },
        ActType.ClimaxAct.blueprint("Fruits Co-Performance") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(times4).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyCountableBuff(
                        CountableBuff.Daze,
                        chance = 33,
                    )
                }
                applyAllyStageEffect(BloomingFlowers, 2)
                applyAllyStageEffect(ApplauseSnow, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(50, 1),
            TeamBlessingEffectiveDamagePassive.new(50, 1),
            TeamBrillianceRecoveryPassive.new(10),
            AllyStageEffectPassive(ApplauseSnow).new(value = 1, time = 2)
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
            TeamAPDownBuffPassive.new(time = 1),
            TeamAPDownBuffPassive.new(time = 2) + SeishoOnlyCondition,
            AllyStageEffectPassive(BloomingFlowers).new(1, time = 2)
        ),
        listOf(
            TeamActUpScalingPassive100.new(30) + SnowOnlyCondition,
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
            NegativeCountableResistancePassive.new(value = 100)
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Sweets),
)