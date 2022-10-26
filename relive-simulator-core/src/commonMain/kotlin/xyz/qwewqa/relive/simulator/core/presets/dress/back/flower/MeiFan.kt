package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4030017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamActPowerUpBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamConfusionResistanceBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamStopResistanceBuffPassive

val StageGirlMeiFan = dress4030017(
    name = "Stage Girl Mei Fan",
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
        ActType.Act2.blueprint("Flash of Determination") {
            Act {
                targetSelf().act {
                    applyBuff(
                        EffectiveDamageDealtUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Unwavering Passion") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        ApDownBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("O king, my burning passion will create your noble path!") {
            Act {
                targetBack().act {
                    applyBuff(
                        ActPowerDownBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        NormalDefenseDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    attack(
                        modifier = values3,
                        hitCount = 4,
                        bonusMultiplier = 150,
                        bonusCondition = SpecialDamageOnlyCondition,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamActPowerUpBuffPassive.new(20, time = 3),
        ),
        listOf(
            TeamConfusionResistanceBuffPassive.new(100, time = 6),
        ),
        listOf(
            TeamStopResistanceBuffPassive.new(100, time = 6),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.StageGirl),
)
