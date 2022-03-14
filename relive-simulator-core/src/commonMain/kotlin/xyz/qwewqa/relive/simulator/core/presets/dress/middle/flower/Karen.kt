package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower


import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010017
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageFlower
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageSpace

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
