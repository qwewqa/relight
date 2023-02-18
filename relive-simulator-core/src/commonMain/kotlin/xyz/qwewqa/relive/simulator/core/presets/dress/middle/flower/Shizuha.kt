package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3050017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.DamageReceivedDownPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBrillianceDrainPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive

val StageGirlShizuha = dress3050017(
    name = "Stage Girl Shizuha",
    acts = listOf(
        ActType.Act1.blueprint("Holy Slash") {
            Act {
                targetAllyFront(3).act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetFront(3).act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Severing Slash") {
            Act {
                targetFront(3).act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Flash Slash") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetFront(3).act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("I spread my wings, to Frontier!") {
            Act {
                focus {
                    targetFront(3).act {
                        applyBuff(
                            effect = NormalDefenseDownBuff,
                            value = values1,
                            turns = times1,
                        )
                        attack(
                            modifier = values2,
                            hitCount = 3,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
        listOf(
            TeamHpUpPassive.new(20),
        ),
        listOf(
            DamageReceivedDownPassive.new(10),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + FrontierOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
