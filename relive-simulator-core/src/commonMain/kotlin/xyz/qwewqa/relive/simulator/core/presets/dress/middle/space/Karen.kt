package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010014
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1010020
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.AfterlifeTrials

val WheelOfFortuneKaren = dress1010014(
    name = "Wheel of Fortune Karen",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetFront().act {
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
        ActType.Act2.blueprint("Purity of Heaven") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.Act3.blueprint("Destiny Guidance") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Destiny's End") {
            Act {
                focus {
                    targetFront(3).act {
                        applyBuff(
                            effect = SpecialDefenseDownBuff,
                            value = values1,
                            turns = times1,
                        )
                        attack(
                            modifier = values2,
                            hitCount = 4,
                        )
                    }
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamStunResistanceUpBuffPassive.new(value = 100, time = 6),
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(10, 3),
        ),
        listOf(
            SelfClimaxDamageUpBuffPassive.new(10),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)

val OkuninushiKaren = dress1010020(
    name = "Okuninushi Karen",
    acts = listOf(
        ActType.Act1.blueprint("Life Sword") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
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
        ActType.Act2.blueprint("Life Bow") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = StunBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Life Koto") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Dawn of Compassion") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                log ("TODO") { "Verify how SE works against bosses with fixed movesets" }
                applyEnemyStageEffect(AfterlifeTrials, 5)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfEvasionBuffPassive.new(time = 5),
        ),
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            TeamNegativeEffectResistanceUpBuffPassive.new(100, 1),
        )
    ),
    unitSkill = ActCritical50UnitSkill + (SpaceOnlyCondition or StarOnlyCondition),
)
