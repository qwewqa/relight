package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val OrpheusFumi = dress2030018(
    name = "Orpheus Fumi",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByLowest { it.specialDefense }.act {
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
        ActType.Act2.blueprint("Sorrowful Tone") {
            Act {
                targetByLowest { it.specialDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetBack(2).act {
                    applyBuff(
                        effect = StunBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Encouraging Tone") {
            Act {
                targetByLowest { it.specialDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Orpheus' Investigation") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = StunBuff, //TODO() locked stun
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(25),
            EnemyBrillianceDrainPassive.new(25), //TODO() target back most
        ),
        listOf(
            EnemyFront5StunBuffPassive.new(2),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
)