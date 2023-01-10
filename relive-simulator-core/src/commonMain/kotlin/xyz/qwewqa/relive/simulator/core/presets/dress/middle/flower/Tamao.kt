package xyz.qwewqa.relive.simulator.core.presets.dress.middle.flower

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress2010018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.*

val PersephoneTamao = dress2010018(
    name = "Persephone Tamao",
    acts = listOf(
        ActType.Act1.blueprint("Laws of the Underworld") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = times1,
                    )
                }
                applyEnemyStageEffect(DeathsKiss, 3)
                applyEnemyStageEffect(Thunder, 2)
            }
        },
        ActType.Act2.blueprint("Peace of the Underworld") {
            Act {
                targetByHighest { it.actPower }.act {
                    dispelTimed(BuffCategory.Positive)
                    applyCountableBuff(CountableBuff.Pride, count = times2, value = values2)
                    applyCountableBuff(CountableBuff.DisasterApUp, count = times3, value = values3)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Quiet of the Underworld") {
            Act {
                targetSelf().act {
                    applyBuff(LockedApDownBuff, turns = times1)
                }
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(GoldenVitality, 2)
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Adverse Fate") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Negative)
                    applyCountableBuff(CountableBuff.Pride, count = times2, value = values2)
                    // TODO: Implement conversion
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            BrillianceRecoveryPassive.new(100),
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(value = 50, time = 1),
            TeamAP2DownBuffPassive.new(time = 1),
        ),
        listOf(
            DispelTimedBuffPassive(NegativeCountableEffectResistanceBuff).new(),
            EnemyPrideBuffPassive.new(value = 3000, time = 1),
            EnemyBrillianceDrainPassive.new(value = 50),
        ),
        listOf(
            TeamBlessingHopePassive.new(time = 1),
            TeamBlessingAp2DownPassive.new(time = 1),
            AllyStageEffectPassive(Majestic).new(value = 1, time = 2),
        ),
        listOf(
            SelfLockedNegativeEffectResistanceBuffPassive.new(value = 100, time = 2),
            SelfLockedNegativeCountableEffectResistanceBuffPassive.new(value = 100, time = 2),
        ),
    ),
    unitSkill = ActCritical75UnitSkill + (FlowerOnlyCondition or SunOnlyCondition),
    multipleCA = true,
    categories = setOf(DressCategory.Birthday2022),
)
