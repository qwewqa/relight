package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower


import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BrillianceRegenBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NormalDefenseUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SpecialDefenseUpBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.GlitteringStage
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.RoaringFire
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageFlower

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
)
