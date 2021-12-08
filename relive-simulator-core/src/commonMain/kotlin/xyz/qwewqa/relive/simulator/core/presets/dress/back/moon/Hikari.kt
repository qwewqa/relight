package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageMoon
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1020017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint

val StageGirlHikari = dress1020017(
    name = "Stage Girl Hikari",
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
        ActType.Act2.blueprint("Severing Slash", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.Act3.blueprint("Darkness Slash", 3) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = times2,
                        chance = 70,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("All of this... is for the sake of \"Starlight\"!", 2) {
            Act {
                targetSelf().act {
                    applyBuff(
                        PerfectAim,
                        turns = times1
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = times3,
                        chance = 80,
                    )
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = values4,
                        turns = times4,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageMoon, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            DamageDealtPassive.new(10),
        ),
        listOf(
            TeamActPowerUpBuffPassive.new(10, time = 3)
        ),
        listOf(
            // TODO: Agility buff (though it's largely irrelevant in PvE)
        ),
        listOf(
            BlindnessResistancePassive.new(100),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SeishoOnlyCondition,
    category = DressCategory.StageGirl,
)
