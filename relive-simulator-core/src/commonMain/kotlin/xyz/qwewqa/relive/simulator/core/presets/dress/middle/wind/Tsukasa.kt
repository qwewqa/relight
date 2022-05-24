package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3040017
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.HyakkaRyoran
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType.*

val StageGirlTsukasa = dress3040017(
    name = "Stage Girl Tsukasa",
    acts = listOf(
        Act1.blueprint("Purifying Flash") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        Act2.blueprint("Relaxing Flash") {
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
                        hitCount = 3,
                    )
                }
            }
        },
        Act3.blueprint("Carefree Flash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
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
        ClimaxAct.blueprint("The king shines his light on the hollow stage!") {
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
                applyAllyStageEffect(HyakkaRyoran, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
            TeamAPDownBuffPassive.new(time = 2) + FrontierOnlyCondition,
        ),
        listOf(
            EnemyBack3LockedAPUpBuffPassive.new(time = 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
