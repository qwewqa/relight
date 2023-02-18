package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.ClimaxDamageUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.DamageReceivedDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.JunnaHoshimisStage
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
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        DamageReceivedDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Synchro Strike") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
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
                        modifier = values3,
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
    name = "Hunting Revue Junna",
    acts = listOf(
        ActType.Act1.blueprint("Strike of Brilliance") {
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
        ActType.Act2.blueprint("Pressure Blow") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
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
                applyAllyStageEffect(JunnaHoshimisStage, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(time = 2) + BackOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + BackOnlyCondition,
        ),
        listOf(
            EnemyAPUpBuffPassive.new(time = 3) + BackOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Movie),
)
