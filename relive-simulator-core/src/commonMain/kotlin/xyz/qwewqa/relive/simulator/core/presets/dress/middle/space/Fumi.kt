package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2030013
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val DonJoseFumi = dress2030013(
    name = "Don Jose Fumi",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetSelf().act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.Act2.blueprint("Honesty") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAllyAoe(SpaceOnlyCondition).act {
                    dispelTimed(BuffCategory.Negative)
                    // TODO: Count. cleanse
                }
            }
        },
        ActType.Act3.blueprint("Earnestness") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetBack().act {
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Mad Love") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values3,
                        turns = times3,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, 1),
            SelfFortitudeBuffPassive.new(time = 4),
        ),
        listOf(
            TeamBrillianceRegenBuffPassive.new(20, 3) + SpaceOnlyCondition,
        ),
        listOf(
            TeamHpUpPassive.new(30) + SpaceOnlyCondition,
            TeamDexterityUpPassive.new(30) + SpaceOnlyCondition,
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
)
