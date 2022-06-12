package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.KaorukoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090022
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1090016
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SunsetTune

val CatalinaKaoruko = dress1090022(
    name = "Rebellious General Catalina Kaoruko",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Creation Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                        bonusMultiplier = 150,
                        bonusCondition = SpecialDamageOnlyCondition,
                    )
                }
            }
        },
        ActType.Act3.blueprint("General's Oath") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(3).act {
                    applyBuff(
                        EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Black Lion's Scratch Encore") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                        bonusMultiplier = 150,
                        bonusCondition = SpecialDamageOnlyCondition,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            DamageDealtPassive.new(10),
        ),
        listOf(
            EffectiveDamageDealtPassive.new(10),
        ),
        listOf(
            DexterityPassive.new(10),
        )
    ),
    unitSkill = SelfActCritical50UnitSkill,
)

val MurasakiKaoruko = dress1090016(
    name = "Murasaki Shikibu Kaoruko",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Poetic Murmur") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                        bonusMultiplier = 150,
                        bonusCondition = NormalDamageOnlyCondition,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Sorrowful Song") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Esthetics of Subtlety") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(10).act {
                    attack(
                        modifier = values2,
                        hitCount = 10,
                        bonusMultiplier = 150,
                        bonusCondition = NormalDamageOnlyCondition,
                    )
                }
                applyEnemyStageEffect(SunsetTune, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(10, 3),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20) + KaorukoOnlyCondition,
        ),
        listOf(
            // TODO: Locked NER
            SelfNegativeEffectResistanceBuffPassive.new(100, 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
)
