package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.TheStageWhereHoshimiJunnaPlaysTheLead
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageSnow

val StageGirlJunna = dress1060017(
    name = "Stage Girl Junna",
    acts = listOf(
        ActType.Act1.blueprint("Snipe") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Blessed Strike") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        DamageTakenDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Piercing Arrow") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("I'll take hold of a star of my own!") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = ClimaxDamageUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageSnow, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            SelfTurnBrillianceRecoveryPassive.new(10),
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
        )
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + SnowOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)

val HuntingRevueJunna = dress1060024(
    name = "Revue of Hunting Junna",
    acts = listOf(
        ActType.Act1.blueprint("Strike of Brilliance") {
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
        ActType.Act2.blueprint("Pressure Blow") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.Act3.blueprint("Arrow of Light") {
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
        ActType.ClimaxAct.blueprint("See if you can kill me, Daiba Nana!") {
            Act {
                targetSelf().act {
                    applyCountableBuff(CountableBuff.Fortitude, 2)
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 3,
                    )
                }
                applyAllyStageEffect(TheStageWhereHoshimiJunnaPlaysTheLead, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(2) + BackOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + BackOnlyCondition,
        ),
        listOf(
            EnemyAPUpBuffPassive.new(time = 3) + BackOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SnowOnlyCondition,
    multipleCA = true,
)
