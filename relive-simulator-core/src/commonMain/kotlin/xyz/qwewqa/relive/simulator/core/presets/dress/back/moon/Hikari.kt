package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BlindnessBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.BlindnessResistancePassive
import xyz.qwewqa.relive.simulator.core.stage.passive.DamageDealtPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamActPowerUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageMoon

val StageGirlHikari = dress1020017(
    name = "Stage Girl Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Severing Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.Act3.blueprint("Darkness Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = times2,
                        chance = 70,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("All of this... is for the sake of \"Starlight\"!") {
            Act {
                targetSelf().act {
                    applyBuff(
                        PerfectAimBuff,
                        turns = times1
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = times3,
                        chance = 80,
                    )
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = values4,
                        turns = times4,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageMoon, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            DamageDealtPassive.new(10),
        ),
        listOf(
            TeamActPowerUpBuffPassive.new(10, time = 3)
        ),
        listOf(
            // TODO: Agility buff (though it's largely irrelevant in PvE)
        ),
        listOf(
            BlindnessResistancePassive.new(100),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SeishoOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
