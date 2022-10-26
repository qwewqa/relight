package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3030017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val StageGirlLalafin = dress3030017(
    name = "Stage Girl Lalafin",
    acts = listOf(
        ActType.Act1.blueprint("Purifying Smash") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values3,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Relaxing Smash") {
            Act {
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                    attack(
                        modifier = values4,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Carefree Smash") {
            Act {
                targetBack().act {
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
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("With love and courage, to Frontier!") {
            Act {
                targetSelf().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values3,
                        hitCount = 10,
                    )
                    applyCountableBuff(
                        CountableBuff.Daze,
                        chance = 33,
                    )
                }
                targetAoe().act {
                    applyCountableBuff(CountableBuff.WeakSpot)
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(10),
            TeamBrillianceRecoveryPassive.new(10) + FrontierOnlyCondition,
        ),
        listOf(
            EnemyBack3APUpBuffPassive.new(time = 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.StageGirl),
)
