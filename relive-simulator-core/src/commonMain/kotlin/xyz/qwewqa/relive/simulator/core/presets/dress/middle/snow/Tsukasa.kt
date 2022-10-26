package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3040018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamPerfectAimBuffPassive

val YellowTsukasa = dress3040018(
    name = "Yellow Frontier Tsukasa",
    acts = listOf(
        ActType.Act1.blueprint("Flash of Brilliance") {
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
        ActType.Act2.blueprint("Flash of Victory") {
            Act {
                targetByLowest { (it.hp / it.maxHp) }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Flash of Evasion") {
            Act {
                targetByLowest { (it.hp / it.maxHp) }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Yellow Tornado") {
            Act {
                targetAllyAoe().act {
                    flipTimed(
                        category = BuffCategory.Negative,
                        count = values1
                    )
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                    attack(
                        modifier = values4,
                        hitCount = 1,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 3),
        ),
        listOf(
            TeamHpUpPassive.new(50),
            TeamHpUpPassive.new(30) + FrontierOnlyCondition,
        ),
        listOf(
            TeamPerfectAimBuffPassive.new(time = 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
