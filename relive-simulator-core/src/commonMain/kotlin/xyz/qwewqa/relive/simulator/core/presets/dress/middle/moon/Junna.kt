package xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1060021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val AnastasiaJunna = dress1060021(
    name = "Anastasia Junna",
    acts = listOf(
        ActType.Act1.blueprint("Purification Strike", 2) {
            Act {
                targetAllyAoe().act {
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
        ActType.Act2.blueprint("Strike of Relaxation", 2) {
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
        ActType.Act3.blueprint("Freedom Strike", 2) {
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
                        effect = DexterityUpBuff,
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
        ActType.ClimaxAct.blueprint("Sacre de Lumiere", 2) {
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
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
        ),
        listOf(
            TeamHpUpPassive.new(50),
            TeamHpUpPassive.new(30) + SeishoOnlyCondition,
        ),
        listOf(
            EnemyBack3APUpBuffPassive.new(),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
)