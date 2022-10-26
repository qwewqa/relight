package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020012
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseSnow
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.HyakkaRyoran
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.RoaringFire
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping

val StageGirlMichiru = dress4020017(
    name = "Stage Girl Michiru",
    acts = listOf(
        ActType.Act1.blueprint("Purification") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Tactician's Prank") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Limitless Radiance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("King's Right Hand") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values2,
                        hitCount = 10,
                    )
                    applyCountableBuff(
                        CountableBuff.Daze,
                        chance = 33,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            TeamHpUpPassive.new(50),
            TeamHpUpPassive.new(30) + SiegfeldOnlyCondition,
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20) + MichiruOnlyCondition,
            TeamBrillianceRecoveryPassive.new(20) + YachiyoOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.StageGirl),
)

val DelightMichiru = dress4020012(
    name = "Delight Michiru",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Tension") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.Act2.blueprint("Applauding Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
                applyAllyStageEffect(ApplauseSnow, 6)
            }
        },
        ActType.Act3.blueprint("Disaster Slash") {
            Act {
                targetBack().act {
                    //TODO(): Misfortune countable
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Delight ~Cry of Passion~") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(times3).act {
                    attack(
                        modifier = values3,
                        hitCount = 10,
                    )
                    applyCountableBuff(
                        CountableBuff.Pride,
                        chance = 33,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran, 2)
                applyEnemyStageEffect(RoaringFire, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
            TeamAPDownBuffPassive.new(time = 2) + SiegfeldOnlyCondition,
        ),
        listOf(
            TeamActUpScalingPassive100.new(30) + SnowOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
)
