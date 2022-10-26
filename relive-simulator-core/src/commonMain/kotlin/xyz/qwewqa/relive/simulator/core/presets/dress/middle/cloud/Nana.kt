package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070023
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedStunBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageCloud

val StageGirlNana = dress1070017(
    name = "Stage Girl Nana",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Inspiring Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Synchro Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("I will protect them! Forever... Again and again!") {
            Act {
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values1,
                            hitCount = 2,
                        )
                    }
                }
                applyAllyStageEffect(WeAreOnTheStageCloud, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
        StopResistancePassive.new(100),
        ),
        listOf(
        SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
        TeamActPowerUpBuffPassive.new(20,3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SeishoOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)

val DemonKingNana = dress1070023(
    name = "Demon King Nana",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Abyss Nightmare") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1
                    )
                }
                targetAoe(SeishoOnlyCondition).act {
                    reduceCountable(BuffCategory.Positive)
                }
            }
        },
        ActType.Act3.blueprint("Soul Take") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1
                    )
                }
                targetAoe(SeishoOnlyCondition).act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = LockedStunBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Dark Feast") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1
                    )
                }
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values2,
                            hitCount = 3,
                            bonusMultiplier = 150,
                            bonusCondition = SeishoOnlyCondition,
                        )
                    }
                }
                targetAoe(SeishoOnlyCondition).act {
                    applyCountableBuff(
                        CountableBuff.Daze,
                        count = times3,
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
            EnemyBrillianceDrainPassive.new(50) + SeishoOnlyCondition,
        ),
        listOf(
            TeamNegativeEffectResistanceBuffPassive.new(100, 1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
