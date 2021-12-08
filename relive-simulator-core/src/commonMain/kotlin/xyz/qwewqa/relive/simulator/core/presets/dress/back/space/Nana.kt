package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070004
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1070015
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

val IzanagiNana = dress1070015(
    name = "Izanagi Nana",
    acts = listOf(
        ActType.Act1.blueprint("Strong Slash", 2) {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Sacred Will", 2) {
            Act {
                targetBack(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Cloud Piercing", 2) {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = PerfectAim,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Izanagi's Creation", 2) {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 3
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = NormalBarrierBuff,
                        value = values4,
                        turns = times4,
                    )
                    applyBuff(
                        effect = SpecialBarrierBuff,
                        value = values5,
                        turns = times5,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
        listOf(
            SelfClimaxDamageUpBuffPassive.new(10),
        ),
        listOf(
            SelfTurnBrillianceRecoveryPassive.new(20),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = ActCritical30UnitSkill + NormalDamageOnlyCondition,
)

val JusticeNana = dress1070004(
    name = "Justice Nana",
    acts = listOf(
        ActType.Act1.blueprint("Brilliance Slash", 2) {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Sword of Justice", 2) {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Right Judgement", 2) {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    heal(percent = values3)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Izanagi's Creation", 2) {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = 4
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(10, 3),
        ),
        listOf(
            TeamEffectiveDamageDealtUpBuffPassive.new(20, 3),
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(20),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
    category = DressCategory.Arcana,
)
