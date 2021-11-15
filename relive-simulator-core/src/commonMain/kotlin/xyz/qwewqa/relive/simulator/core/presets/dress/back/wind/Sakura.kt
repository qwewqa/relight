package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress9010001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyBrillianceDrainPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.NegativeEffectResistancePassive
import xyz.qwewqa.relive.simulator.core.stage.passive.TeamHpUpPassive

val ImperialCombatRevueFlowerDivisionSakura = dress9010001(
    name = "Imperial Combat Revue: Flower Division Sakura",
    acts = listOf(
        ActType.Act1.blueprint("Sword of Prayer", 2) {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyFront(3).act {
                    applyBuff(
                        ApDownBuff,
                        turns = 2
                    )
                }
            }
        },
        ActType.Act2.blueprint("Sword of Divinity", 2) {
            Act {
                targetAoe().act {
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
                        DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Piercing Sword", 3) {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        ApUpBuff,
                        turns = times2,
                    )
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Haja Kensei - Ouka Houshin", 2) {
            Act {
                focus {
                    targetAoe().act {
                        attack(
                            modifier = values1,
                            hitCount = 3,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            NegativeEffectResistancePassive.new(50),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
)