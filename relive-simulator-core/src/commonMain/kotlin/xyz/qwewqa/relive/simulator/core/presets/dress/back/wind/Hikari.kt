package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020019
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.ApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BrillianceGainDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBrillianceDrainPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamAgilityUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive
import xyz.qwewqa.relive.simulator.stage.character.Position

val SakuraShingujiHikari = dress1020019(
    name = "Sakura Shinguji Hikari",
    acts = listOf(
        ActType.Act1.blueprint("Purifying Blade") {
            Act {
                targetBack(1).act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
            }
        },
        ActType.Act2.blueprint("Dim Blink") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        ApUpBuff,
                        turns = times2,
                    )
                    applyBuff(
                        BrillianceGainDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Skyward Leap") {
            Act {
                targetAllyBack(5).act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Nostalgic Cherry Blossoms") {
            Act {
                targetAoe().act {
                    focus {
                        attack(
                            modifier = values1,
                            hitCount = 1,
                        )
                    }
                }
                targetAoe { it.dress.position == Position.Back }.act {
                    applyCountableBuff(CountableBuff.Daze)
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            TeamAgilityUpBuffPassive.new(10, time = 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
)
