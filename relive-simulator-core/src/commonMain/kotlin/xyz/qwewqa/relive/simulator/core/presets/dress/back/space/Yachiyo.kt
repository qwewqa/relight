package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050009
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050014
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.AngelicSmile
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseSpace

val SonokoYachiyo = dress4050009(
    name = "Sonoko Yuki Yachiyo",
    acts = listOf(
        ActType.Act1.blueprint("Strike of Brilliance") {
            Act {
                targetFront().act {
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
        ActType.Act2.blueprint("Beauty Step") {
            Act {
                targetAllyFront(3).act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = HpRegenBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Strike to Victory") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
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
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Beautiful Pose♪") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DamageTakenDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ExitEvasionBuff,
                        turns = times3,
                    )
                    log ("TODO") { "Verify EE is working as intended." }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfEvasionBuffPassive.new(time = 1),
        ),
        listOf(
            StunResistancePassive.new(100),
        ),
        listOf(
            FreezeResistancePassive.new(100),
        ),
    ),
    unitSkill = HP50Def30UnitSkill + BackOnlyCondition,
)

val CoyoteCainYachiyo = dress4050014(
    name = "Warrant Officer Coyote Cain Yachiyo",
    acts = listOf(
        ActType.Act1.blueprint("Lovely Arrow") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Love Arrow") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    heal(percent = values3)
                }
            }
        },
        ActType.Act3.blueprint("Arrow of Freedom") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = SpecialReflectBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Aggressive Coyote") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetBack(2).act {
                    applyCountableBuff(CountableBuff.Daze, count = times2 )
                }
                applyAllyStageEffect(AngelicSmile, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
        listOf(
            TeamDamageDealtUpBuffPassive.new(value = 30, time = 2) + SpaceOnlyCondition,
            TeamDamageTakenDownBuffPassive.new(value = 30, time = 2) + SpaceOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + SpaceOnlyCondition,
)

val CollectionYachiyo = dress4050019(
    name = "Stage Girl Collection Yachiyo",
    acts = listOf(
        ActType.Act1.blueprint("Alluring Pose") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Alluring Walking") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = BrillianceGainDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Alluring Smile") {
            Act {
                targetAllyBack(5).act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Tsuruhime Yachiyo's Runway") {
            Act {
                targetSelf().act {
                    applyCountableBuff(CountableBuff.Hope, count = times1)
                }
                targetAoe().act {
                    // TODO() Remove 5 Forts
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(ApplauseSpace, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(30),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20) + SiegfeldOnlyCondition,
        ),
        listOf(
            TeamNegativeEffectResistanceBuffPassive.new(100, 1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
    multipleCA = true,
)
