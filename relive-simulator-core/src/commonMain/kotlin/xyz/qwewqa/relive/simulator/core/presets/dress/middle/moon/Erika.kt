package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress9020001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ApDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBrillianceDrainPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfReviveBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.AngelicSmile

// Note: JP calls her Erika even though EN has her as Erica
val ParisCombatRevueFlowerDivisionErika = dress9020001(
    name = "Paris Combat Revue: Flower Division Erika",
    acts = listOf(
        ActType.Act1.blueprint("Gust of Brilliance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
            }
        },
        ActType.Act2.blueprint("Gale Dance") {
            Act {
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyBuff(
                        NegativeEffectResistanceUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Motivated Strike") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Sacre de Lumiere") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 5,
                    )
                }
                targetAllyBack(2).act {
                    applyCountableBuff(
                        CountableBuff.Revive,
                        count = times2,
                    )
                }
                applyAllyStageEffect(
                    AngelicSmile,
                    turns = 2,
                )
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
            SelfReviveBuffPassive.new(50, time = 1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (MoonOnlyCondition or StarOnlyCondition),
)
