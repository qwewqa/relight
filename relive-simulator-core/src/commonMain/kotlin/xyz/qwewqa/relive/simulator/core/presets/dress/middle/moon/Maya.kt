package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MiddleOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050025
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
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
    unitSkill = ActCritical30UnitSkillStageGirl + MoonOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)

val SoulRevueMaya = dress1050025(
    name = "Soul Revue Maya",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByHighest { it.actPower }.act {
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
                targetByHighest { it.actPower }.act {
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
                targetByHighest { it.actPower }.act {
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
            EnemyDazeBuffPassive.new(2) + MiddleOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + MiddleOnlyCondition,
        ),
        listOf(
            TeamBrillianceGainUpBuffPassive.new(50, 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
)
