package xyz.qwewqa.relive.simulator.core.presets.dress.front.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040011
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.modifier.actPower
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val BloodyDevilShiori = dress4040011(
    name = "BLOODY DEVIL Shiori",
    acts = listOf(
        ActType.Act1.blueprint("Collect Clutch") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = AggroBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Light Hold") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
                        turns = times2,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = EvasionUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Heavy Sleeper") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = AggroBuff,
                        turns = times2,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("BLOODY TEA TIME") {
            Act {
                targetByHighest { it.mod { +actPower } }.act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = times1,
                    )
                    attack(
                        modifier = values2,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values3,
                        turns = times3,
                    )
                    applyBuff(
                        effect = SpecialReflectBuff,
                        value = values4,
                        turns = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50,1),
            SelfEvasionBuffPassive.new(time = 4),
        ),
        listOf(
            TeamHpUpPassive.new(30),
        ),
        listOf(
            EnemyLockedAggroBuffPassive.new(time = 2),
        ),
    ),
    unitSkill = HPDef75UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
)
