package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.NegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfReviveBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.DeathsKiss

val RomeoKaren = dress1010019(
    name = "Romeo Karen",
    acts = listOf(
        ActType.Act1.blueprint("Gust of Brilliance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
            }
        },
        ActType.Act2.blueprint("Carefree Heart") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times2
                    )
                    applyBuff(
                        NegativeEffectResistanceBuff,
                        value = values3,
                        turns = times3
                    )
                }
            }
        },
        ActType.Act3.blueprint("Piercing Sword") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        ApUpBuff,
                        turns = times2
                    )
                    attack(
                        modifier = values3,
                        hitCount = 2
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Rose Escape") {
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
                        hitCount = 3
                    )
                }
                applyEnemyStageEffect(DeathsKiss, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            NegativeEffectResistancePassive.new(50),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
)