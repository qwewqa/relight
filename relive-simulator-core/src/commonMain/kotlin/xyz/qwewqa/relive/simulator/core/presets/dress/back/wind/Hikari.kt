package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.MovieOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020019
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.AlluringEyes
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ThisIsTheStage
import xyz.qwewqa.relive.simulator.stage.character.Position

val SakuraShingujiHikari = dress1020019(
    name = "Sakura Shinguji Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Purifying Blade") {
            Act {
                targetBack(1).act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
            }
        },
        ActType.Act2.blueprint("Dim Blink") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        ApUpBuff,
                        turns = times2,
                    )
                    applyBuff(
                        BrillianceGainDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Skyward Leap") {
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
        ActType.ClimaxAct.blueprint("Nostalgic Cherry Blossoms") {
            Act {
                targetAoe().act {
                    focus {
                        attack(
                            modifier = values1,
                            hitCount = 1,
                        )
                    }
                }
                targetAoe { it.dress.position == Position.Back }.act {
                    applyCountableBuff(CountableBuff.Daze)
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            TeamAgilityUpBuffPassive.new(10, time = 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
)

val FinalLinesHikari = dress1020024(
    name = "Final Lines Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Hope") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times1,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceUpBuff)
                    // Unremovable seal stage effect
                }
                //Reduce 2 most recent negative ally SE by 1 level
            }
        },
        ActType.Act2.blueprint("Enchanting Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                applyEnemyStageEffect(AlluringEyes, 2)
            }
        },
        ActType.Act3.blueprint("Desired Stage") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyBack(3).act {
                    addBrilliance(values2)
                    applyCountableBuff(
                        effect = CountableBuff.BlessingCountableDebuffReduction,
                        value = values3,
                        count = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Kagura Hikari, I am the Star!") {
            Act {
                targetAllyAoe(MovieOnlyCondition).act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Daze,
                        count = times2,
                    )
                    //TODO: Revive reduction
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(ThisIsTheStage, 3) //TODO: Add the Dex to Karen/Hikari to the SE
            }
        },
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
            TeamReviveBuffPassive.new(time = 2) + MovieOnlyCondition,
            TeamHopeBuffPassive.new(time = 2) + MovieOnlyCondition,
            //TODO: Revive reduction
        ),
        listOf(
            EnemyDazeBuffPassive.new(time = 1),
            EnemyBrillianceDrainPassive.new(30),
            EnemyDazeBuffPassive.new(time = 1) + MovieOnlyCondition,
        ),
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
            TeamNegativeEffectResistanceUpBuffPassive.new(100, 1),
        ),
        listOf(
            CutinInitialCooldownReductionPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Movie),
)
