package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4050017
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
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position


val StageGirlYachiyo = dress4050017(
    name = "Stage Girl Yachiyo",
    acts = listOf(
        ActType.Act1.blueprint("Prayer Song", 2) {
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
        ActType.Act2.blueprint("Goddess Smile", 2) {
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
        ActType.Act3.blueprint("Piercing Arrow", 3) {
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
        ActType.ClimaxAct.blueprint("This world is a stage. Even the king is a player!", 2) {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = FreezeBuff,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(10),
        ),
        listOf(
            TeamHpUpPassive.new(50),
        ),
        listOf(
            NegativeEffectResistancePassive.new(50),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SiegfeldOnlyCondition,
    category = DressCategory.StageGirl,
)
