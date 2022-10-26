package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2010014
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.StopBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical30UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBrillianceDrainPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyFront5APUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyFront5StunBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping

val HijikataToshizoTamao = dress2010014(
    name = "Hijikata Toshizo Tamao",
    acts = listOf(
        ActType.Act1.blueprint("Purifying Mow") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Gust of Brilliance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
            }
        },
        ActType.Act3.blueprint("Unconventional Sword") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Baragaki") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = StopBuff,
                        turns = 1,
                        chance = 80,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyFront5APUpBuffPassive.new(time = 2),
        ),
        listOf(
            EnemyFront5StunBuffPassive.new(time = 2),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50),
        )
    ),
    unitSkill = ActCritical30UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
)
