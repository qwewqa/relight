package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.RinmeikanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedConfusionBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.SleepBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfTurnBrillianceRecoveryPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamAPDownBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.LightOfCourage

val StageGirlFumi = dress2030017(
    name = "Stage Girl Fumi",
    acts = listOf(
        ActType.Act1.blueprint("Aggravating Slash") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Drowsy Song") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        turns = times2,
                        chance = 50,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Mad Dance") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = LockedConfusionBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("To a new life, to a new stage!") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 4,
                        bonusMultiplier = 150,
                        bonusCondition = SiegfeldOnlyCondition,
                    )
                }
                applyAllyStageEffect(
                    LightOfCourage,
                    turns = 6,
                )
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamHpUpPassive.new(30),
        ),
        listOf(
            SelfTurnBrillianceRecoveryPassive.new(20),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1) + RinmeikanOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + RinmeikanOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
