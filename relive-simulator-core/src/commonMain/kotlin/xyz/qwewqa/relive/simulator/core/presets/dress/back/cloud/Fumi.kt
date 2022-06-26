package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud


import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.RinmeikanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val TemperanceFumi = dress2030015(
    name = "Temperance Fumi",
    acts = listOf(
        Act1.blueprint("Adjustment") {
            Act {
                targetAllyBack(3).act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                }
            }
        },
        Act2.blueprint("Clumsy Handling") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                    applyBuff(
                        effect = MarkBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        Act3.blueprint("Skillful Management") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times2,
                    )
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
            }
        },
        ClimaxAct.blueprint("Article 14: Forceful Removal") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    applyBuff(
                        effect = NightmareBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
        listOf(
            EnemyBack2SleepBuffPassive.new(time = 1),
        ),
        listOf(
            TeamHpUpPassive.new(50),
            TeamHpUpPassive.new(30) + RinmeikanOnlyCondition,
        )
    ),
    unitSkill = ActCritical50UnitSkill + CloudOnlyCondition,
    categories = setOf(DressCategory.Arcana),
)
