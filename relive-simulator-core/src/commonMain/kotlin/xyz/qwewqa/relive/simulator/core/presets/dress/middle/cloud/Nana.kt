package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageCloud
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val StageGirlNana = dress1070017(
    name = "Stage Girl Nana",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Inspiring Slash", 3) {
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
        ActType.Act3.blueprint("Synchro Slash", 3) {
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
        ActType.ClimaxAct.blueprint("I will protect them! Forever... Again and again!", 2) {
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
    category = DressCategory.StageGirl,
)
