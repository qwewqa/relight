package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.RinmeikanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2020018
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.DisasterHail

val StageGirlIchie = dress2020017(
    name = "Stage Girl Ichie",
    acts = listOf(
        ActType.Act1.blueprint("Gust of Brilliance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
            }
        },
        ActType.Act2.blueprint("Purifying Song") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Purifying Voice") {
            Act {
                targetAoe().act {
                    dispelCountable(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Ichie's Mechanical Illusion") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = FreezeBuff,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(30),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            EnemyFront2FreezeBuffPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)

val CerberusIchie = dress2020018(
    name = "Cerberus Ichie",
    acts = listOf(
        ActType.Act1.blueprint("Flash of Brilliance") {
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
        ActType.Act2.blueprint("Faithful Servant") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Consume Everything") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Bite of the Underworld") {
            Act {
                targetAllyBack(3).act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times3,
                    )
                }
                targetBack(3).act {
                    attack(
                        modifier = values4,
                        hitCount = 3,
                    )
                }
                applyEnemyStageEffect(DisasterHail, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamHpUpPassive.new(20),
            TeamHpUpPassive.new(20) + RinmeikanOnlyCondition,
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1) + RinmeikanOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
    categories = setOf(DressCategory.Birthday2022),
)
