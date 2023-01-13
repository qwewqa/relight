package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3040014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val BenzaitenTsukasa = dress3040014(
    name = "Benzaiten Tsukasa",
    acts = listOf(
        ActType.Act1.blueprint("Flash of Charm") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack(2).act {
                    dispelTimed(BuffCategory.Positive)
                    dispelCountable(BuffCategory.Positive, count = 2)
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.Act2.blueprint("Flash of Arrest") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        NegativeEffectResistanceBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetBack(2).act {
                    dispelTimed(BuffCategory.Positive)
                    dispelCountable(BuffCategory.Positive, count = 2)
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(ApplauseFlower, 6)
            }
        },
        ActType.Act3.blueprint("Swirling Flash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack(2).act {
                    dispelTimed(BuffCategory.Positive)
                    dispelCountable(BuffCategory.Positive, count = 2)
                }
                targetBack(1).act {
                    attack(
                        modifier = values5,
                        hitCount = times5,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Raise the Sails!") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    // Change (1) Revive -> Weak Spot, Sacrifice
                }
                targetAnyRandom(times5).act {
                    attack(
                        modifier = values5,
                        hitCount = times5,
                        bonusCondition = SeishoOnlyCondition,
                        bonusMultiplier = 150,
                        )
                    applyCountableBuff(
                        CountableBuff.Pride,
                        chance = 33,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(value = 50, time = 1),
            TeamBlessingEffectiveDamagePassive.new(value = 50, time = 1),
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(value = 20, time = 3),
            TeamCriticalUpBuffPassive.new(value = 20, time = 3),
            TeamNegativeEffectResistanceBuffPassive.new(value = 100, time = 3) + FlowerOnlyCondition,
            TeamAP2DownBuffPassive.new(time = 1) + FlowerOnlyCondition,
            // TODO: locked daze immunity
            EnemyStageEffectPassive(Hesitation).new(value = 1, time = 2),
        ),
        listOf(
            NegativeEffectResistancePassive.new(value = 100),
            // TODO: oath dmg up
        ),
        listOf(
            StaminaActUpPassive.new(value = 100),
            TurnHPRecoveryPassive.new(value = 20000),
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    multipleCA = false,
    categories = setOf(DressCategory.Birthday2023),
)
