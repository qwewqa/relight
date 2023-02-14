package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val DorothyMichiru = dress4020020(
    name = "Dorothy Michiru",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Light") {
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
                applyEnemyStageEffect(GrayWorld, 2)
            }
        },
        ActType.Act2.blueprint("Fatal Slash") {
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
                applyAllyStageEffect(BloomingFlowers, 2)
            }
        },
        ActType.Act3.blueprint("Support Slash") {
            Act {
                targetBack(2).act {
                    dispelTimed(BuffCategory.Positive)
                    dispelCountable(BuffCategory.Positive, count = 2)
                }
                targetBack(1).act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        NegativeEffectResistanceBuff,
                        value = values5,
                        turns = times5,
                    )
                }
                applyAllyStageEffect(ApplauseMoon, 6)
            }
        },
        ActType.ClimaxAct.blueprint("Tornado of Beginnings") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        ApDownBuff,
                        turns = times2,
                    )
                }
                targetBack(1).act {
                    dispelCountable(BuffCategory.Positive)
                    // TODO: aoe change (2) Revive -> Weak Spot
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
                applyEnemyStageEffect(GrayWorld, turns = 2)
                // TODO: pos SE down
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(value = 50, time = 1),
            TeamBlessingEffectiveDamagePassive.new(value = 50, time = 1),
            TeamBrillianceRecoveryPassive.new(10),
            AllyStageEffectPassive(ApplauseMoon).new(value = 1, time = 2),
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(value = 20, time = 3),
            TeamCriticalUpBuffPassive.new(value = 20, time = 3),
            TeamNegativeEffectResistanceBuffPassive.new(value = 100, time = 3) + MoonOnlyCondition,
            TeamAP2DownBuffPassive.new(time = 1) + MoonOnlyCondition,
            // TODO: locked daze immunity
            EnemyStageEffectPassive(Hesitation).new(value = 1, time = 2),
        ),
        listOf(
            NegativeEffectResistancePassive.new(value = 100),
            CutinInitialCooldownReductionPassive.new(value = 1),
            // TODO: oath dmg up
        ),
        listOf(
            StaminaActUpPassive.new(value = 100),
            TurnHPRecoveryPassive.new(value = 20000),
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    multipleCA = false,
    categories = setOf(DressCategory.Birthday2023),
)
