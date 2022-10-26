package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBack1DazeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfReviveBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive


val FoolYachiyo = dress4050015(
    name = "Fool Yachiyo",
    acts = listOf(
        ActType.Act1.blueprint("Gust of Brilliance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
            }
        },
        ActType.Act2.blueprint("Free Heart") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times2,
                    )
                    applyBuff(
                        NegativeEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Eternal Brilliance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Possibility∞Infinity") {
            Act {
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values1,
                            hitCount = 4,
                        )
                    }
                    targetBack().act {
                        applyCountableBuff(
                            CountableBuff.Daze,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamHpUpPassive.new(30),
        ),
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            EnemyBack1DazeBuffPassive.new(1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)
