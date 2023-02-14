package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower


import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010022
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val StageGirlKaren = dress1010017(
    name = "Stage Girl Karen",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    addBrilliance(20)
                }
            }
        },
        ActType.Act2.blueprint("Slash of Bravery") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalDefenseUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = SpecialDefenseUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Glittering Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyByHighest (count = 2) { it.actPower }.act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("We will all do Starlight!") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    addBrilliance(values2)
                    applyBuff(
                        effect = BrillianceRegenBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageFlower, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            TeamNormalDefenseUpBuffPassive.new(20,3),
        ),
    ),
    unitSkill = HP50Def50UnitSkill + SeishoOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)

val FinalLinesKaren = dress1010024(
    name = "Final Lines Karen",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
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
        ActType.Act2.blueprint("Passionate Slash") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe(SeishoOnlyCondition).act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                    addBrilliance(values3)
                }
            }
        },
        ActType.Act3.blueprint("A Play I haven't seen yet") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyEnemyStageEffect(RoaringFire, 3)
            }
        },
        ActType.ClimaxAct.blueprint("Aijo Karen goes to the next stage!") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(GlitteringStage, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 2),
        ),
        listOf(
            //TODO() Remove one revive + BackOnlyCondition
            EnemyBrillianceDrainPassive.new(50) + BackOnlyCondition,
        ),
        listOf(
            TeamHpUpPassive.new(50) + SeishoOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Movie),
)

val PuddingKaren = dress1010022(
    name = "Pudding a la mode Karen",
    acts = listOf(
        ActType.Act1.blueprint("Mint") {
            Act {
                targetBack(1).act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
                applyEnemyStageEffect(Thunder, turns = times3)
                // TODO: SE down
            }
        },
        ActType.Act2.blueprint("Chocolate Sauce") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        NegativeCountableEffectResistanceBuff,
                        value = values1,
                        turns = times1
                    )
                }
                targetBack(1).act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(SweetMoment, turns = 2)
                // TODO: SE down
            }
        },
        ActType.Act3.blueprint("Whipped Cream") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetBack(1).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(BloomingFlowers, turns = 2)
                // TODO: SE down
            }
        },
        ActType.ClimaxAct.blueprint("Pudding Press♪") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.InvincibleRebirth,
                        count = times1,
                    )
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Pride,
                    )
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyAllyStageEffect(MellowFlavor, turns = 2)
                    // TODO: revive reduction
                }
            }
        },
    ),
        autoSkills = listOf(
            listOf(
                SelfInvincibleRebirthBuffPassive.new(100, 1),
                SelfFortitudeBuffPassive.new(time = 4),
                TeamReviveBuffPassive.new(value = 50, time = 1),
            ),
            listOf(
                SelfLockedNegativeEffectResistanceBuffPassive.new(value = 100, time = 2),
                TeamNegativeEffectResistanceBuffPassive.new(value = 100, time = 1),
            ),
            listOf(
                TeamBlessingHPRecoveryPassive.new(value = 100, time = 1),
                TeamBlessingHopePassive.new(time = 1),
            ),
            listOf(
                TeamBrillianceRecoveryPassive.new(20),
                EnemyBrillianceDrainPassive.new(30),
                EnemyStageEffectPassive(SugaryCorruption).new(value = 1, time = 2),
            ),
        ),
        unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
        multipleCA = false,
        categories = setOf(DressCategory.Sweets),
)