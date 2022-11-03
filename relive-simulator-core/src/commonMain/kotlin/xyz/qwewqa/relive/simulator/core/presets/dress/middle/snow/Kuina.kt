package xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4100002
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BrillianceRegenBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.NegativeEffectResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.HyakkaRyoran
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.RoyalAuthority

val FutureStageGirlKuina = dress4100002(
    name = "Future Stage Girl Kuina",
    acts = listOf(
        ActType.Act1.blueprint("Hermetic Slash") {
            Act {
                targetBack().act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                targetAoe().act {
                    dispelTimed(NegativeEffectResistanceBuff)
                    // TODO(): Seal stage effect
                }
            }
        },
        ActType.Act2.blueprint("Exuberant Slash") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                }
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                //AOE seal stage effect
            }
        },
        ActType.Act3.blueprint("Elaborate Slash") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran, 2)
                applyAllyStageEffect(RoyalAuthority, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Swear by Heaven and Earth") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyBuff(
                        effect = BrillianceRegenBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.BlessingHpRecovery,
                        count = times3,
                        value = values3,
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
            TeamReviveBuffPassive.new(50, 1) + SnowOnlyCondition,
        ),
        listOf(
            TeamBlessingHPRecoveryPassive.new(100, 1),
            TeamBlessingCountableDebuffReductionPassive.new(1, 1),
        ),
        listOf(
            TeamBrillianceRecoveryPassive.new(20),
            TeamAPDownBuffPassive.new(time = 1),
        ),
        listOf(
            CutinInitialCooldownReductionPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (SnowOnlyCondition or SunOnlyCondition),
)
