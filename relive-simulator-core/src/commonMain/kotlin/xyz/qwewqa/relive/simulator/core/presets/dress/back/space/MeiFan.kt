package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory

val SakataNoKintokiMeiFan = dress4030018(
    name = "Sakata no Kintoki Mei Fan",
    acts = listOf(
        ActType.Act1.blueprint("Bear Slayer") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        CountableBuff.Hope,
                        count = times1,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Earth Spider Slayer") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times1,
                    )
                    applyCountableBuff(
                        CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Axe-Bearer") {
            Act {
                targetAllyFront(3).act {
                    addBrilliance(values1)
                }
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Contest of Strength") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1
                    )
                    applyCountableBuff(
                        CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.WeakSpot,
                        count = times3,
                    )
                }
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values4,
                            hitCount = times4,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamReviveBuffPassive.new(50, time = 2) + MeiFanOnlyCondition,
            TeamFortitudeBuffPassive.new(time = 3) + MeiFanOnlyCondition,
            TeamAPDownBuffPassive.new(time = 2) + MeiFanOnlyCondition,
        ),
        listOf(
            NegativeEffectResistancePassive.new(100),
            NegativeCountableResistancePassive.new(100),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20),
            EnemyBrillianceDrainPassive.new(20),
        )
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
    categories = setOf(DressCategory.Birthday2022),
)