package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.ElectricShockOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4020018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.InvincibilityBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val SeimeiMichiru = dress4020018(
    name = "Abe no Seimei Michiru",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByHighest { it.actPower }.act {
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
        ActType.Act2.blueprint("Incantation") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = LockedElectricShockBuff,
                        chance = 75,
                        turns = 2,
                    )
                    applyBuff(
                        effect = LockedConfusionBuff,
                        chance = 75,
                        turns = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Divination") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Purifying Shikigami") {
            Act {
                targetAllyAoe().act {
                    heal(percent = values1)
                }
                targetAllyFront(5).act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times3,
                    )
                    applyBuff(
                        effect = InvincibilityBuff,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = 3,
                        bonusCondition = ElectricShockOnlyCondition,
                        bonusMultiplier = 150,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50,1),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20) + SiegfeldOnlyCondition,
            TeamInvincibilityBuffPassive.new(time = 1) + SiegfeldOnlyCondition,
        ),
        listOf(
            EnemyFront5ElectricShockBuffPassive.new(time = 2),
            EnemyFront5ConfusionBuffPassive.new(time = 2),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
