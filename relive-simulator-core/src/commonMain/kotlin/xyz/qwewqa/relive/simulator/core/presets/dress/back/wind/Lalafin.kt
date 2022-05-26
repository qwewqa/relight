package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3030018
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WildHope

val RedFrontierLalafin = dress3030018(
    name = "Red Frontier Lalafin",
    acts = listOf(
        ActType.Act1.blueprint("Smash of Brilliance") {
            Act {
                targetBack().act {
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
        ActType.Act2.blueprint("Hope Smash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                applyAllyStageEffect(WildHope,6)
            }
        },
        ActType.Act3.blueprint("Faint Smash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetBack(2).act {
                    applyBuff(
                        effect = StunBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Quintet Prominence Breaker") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = 5,
                        bonusMultiplier = 150,
                        bonusCondition = SpecialDamageOnlyCondition,
                        attribute = Attribute.Dream,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(10),
            TeamBrillianceRecoveryPassive.new(10) + FrontierOnlyCondition,
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1) + FrontierOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
    categories = setOf(DressCategory.Birthday2022),
)
