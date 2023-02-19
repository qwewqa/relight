package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MayaOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MiddleOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050023
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050025
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.Thunder
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.TrialsForHeroesTemptationsForSaints
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageMoon

val StageGirlMaya = dress1050017(
    name = "Stage Girl Maya",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Mysterious Slash") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetSelf().act {
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
        ActType.Act3.blueprint("Purifying Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Tonight, I will show you my brilliance!") {
            Act {
                log ("TODO") { "This CX does not currently force units to Exit at 0 hp." }
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                        mode = HitMode.FIXED,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageMoon, 6)
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
            TeamCriticalUpBuffPassive.new(10,3),
        ),
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + (MoonOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.StageGirl),
)

val SoulRevueMaya = dress1050025(
    name = "Soul Revue Maya",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
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
        ActType.Act2.blueprint("Slash of Thunder") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                applyEnemyStageEffect(Thunder, 2)
            }
        },
        ActType.Act3.blueprint("Act of Genius") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(2).act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Look up from the abyss. I am the star!") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Fortitude,
                        count = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
                applyAllyStageEffect(TrialsForHeroesTemptationsForSaints, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(time = 2) + MiddleOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + MiddleOnlyCondition,
        ),
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Movie),
)

val WarriorMaya = dress1050023(
    name = "Warrior Maya",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetBack().act {
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
        ActType.Act2.blueprint("Sword of Hope") {
            Act {
                targetAllyAoe().act {
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
            }
        },
        ActType.Act3.blueprint("Sword of Recovery") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Glory of Rebirth") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.WeakSpot,
                        count = times3,
                    )

                }
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values4,
                            hitCount = times4,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamReviveBuffPassive.new(50, time = 2) + MayaOnlyCondition,
            TeamEvasionBuffPassive.new(time = 3) + MayaOnlyCondition,
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
            NegativeCountableResistancePassive.new(100),
        ),
        listOf(
            TeamEvasionUpBuffScalingPassive60.new(15, time = 2) + MoonOnlyCondition
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
