package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow


import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2040018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val HadesRui = dress2040018(
    name = "Hades Rui",
    acts = listOf(
        ActType.Act1.blueprint("Col-Blooded King") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    removeBrilliance(values3)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyEnemyStageEffect(AlluringEyes, 2)
            }
        },
        ActType.Act2.blueprint("Merciless King") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(Majestic, 2)
            }
        },
        ActType.Act3.blueprint("Stern King") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(ApplauseSnow, 6)
            }
        },
        ActType.ClimaxAct.blueprint("Hades's Conviction") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    // Change (2) Revive -> Weak Spot
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
                // Curtains Closed to Back 1
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
            TeamNegativeEffectResistanceBuffPassive.new(100, 3) + SnowOnlyCondition,
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(30),
            EnemyBrillianceDrainPassive.new(30),
            EnemyStageEffectPassive(Hesitation).new(1, 2),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
            TeamAP2DownBuffPassive.new(time = 1) + SnowOnlyCondition,
        ),
        listOf(
            // Oath Revue +50% Dmg to Self
            NegativeEffectResistancePassive.new(100),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
