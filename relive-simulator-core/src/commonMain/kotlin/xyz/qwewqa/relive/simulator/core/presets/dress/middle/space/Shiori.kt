package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.LovesicknessOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040010
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.InvincibilityBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedLovesicknessBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyFront5LovesicknessBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfTurnBrillianceRecoveryPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive

val JulietShiori = dress4040010(
    name = "Juliet Shiori",
    acts = listOf(
        ActType.Act1.blueprint("Love's Power") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                        bonusMultiplier = 150,
                        bonusCondition = LovesicknessOnlyCondition,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Love's Anguish") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = LockedLovesicknessBuff,
                        chance = 75,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Love's Warmth") {
            Act {
                targetFront().act {
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
        ActType.ClimaxAct.blueprint("One Drop of Love") {
            Act {
                targetAllyAoe().act {
                    heal(percent = values1)
                }
                targetAllyFront(5).act {
                    applyBuff(
                        effect = InvincibilityBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 3,
                        bonusMultiplier = 150,
                        bonusCondition = LovesicknessOnlyCondition,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfTurnBrillianceRecoveryPassive.new(20),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            EnemyFront5LovesicknessBuffPassive.new(time = 2),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
)
