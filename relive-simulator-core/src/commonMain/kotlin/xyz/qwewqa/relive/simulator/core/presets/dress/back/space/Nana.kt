package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070004
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070015
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val IzanagiNana = dress1070015(
    name = "Izanagi Nana",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Sacred Will") {
            Act {
                targetBack(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Cloud Piercing") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Izanagi's Creation") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 3
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = NormalBarrierBuff,
                        value = values4,
                        turns = times4,
                    )
                    applyBuff(
                        effect = SpecialBarrierBuff,
                        value = values5,
                        turns = times5,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            SelfClimaxDamageUpBuffPassive.new(10),
        ),
        listOf(
            SelfTurnBrillianceRecoveryPassive.new(20),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + NormalDamageOnlyCondition,
)

val JusticeNana = dress1070004(
    name = "Justice Nana",
    acts = listOf(
        ActType.Act1.blueprint("Brilliance Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Sword of Justice") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Right Judgement") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    heal(percent = values3)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Absolute Justice") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = 4
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(10, 3),
        ),
        listOf(
            TeamEffectiveDamageDealtUpBuffPassive.new(20, 3),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)

val HuntingRevueNana = dress1070024(
    name = "Revue of Hunting Nana",
    acts = listOf(
        ActType.Act1.blueprint("Power Flash") {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Hopeful Flash") {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Brilliance Leap") {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(3).act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("To You...a Beautiful End") {
            Act {
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values1,
                            hitCount = 4,
                            bonusMultiplier = 150,
                            bonusCondition = SeishoOnlyCondition,
                        )
                    }
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times2
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 2),
        ),
        listOf(
            EnemyDazeBuffPassive.new(time = 2) + SeishoOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50) + SeishoOnlyCondition,
        ),
        listOf(
            ConditionalDamageDealtPassive(SeishoOnlyCondition).new(20),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Movie),
)
