package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3020018
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseMoon
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.DisasterHail
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WildHope

val BlueFrontierMisora = dress3020018(
    name = "Blue Frontier Misora",
    acts = listOf(
        ActType.Act1.blueprint("Wisdom Flash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times1,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.Act2.blueprint("Lively Flash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = NegativeEffectResistanceBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values3,
                        hitCount = times3,
                    )
                }
                applyAllyStageEffect(WildHope, 2)
            }
        },
        ActType.Act3.blueprint("Brilliance Flash") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = EffectiveDamageDealtUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetBack().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                }
                applyAllyStageEffect(ApplauseMoon, 6)
            }
        },
        ActType.ClimaxAct.blueprint("Sky Blue Combo Shooting") {
            Act {
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Revive,
                        count = times1,
                    )
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times2,
                    )
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
                targetAnyRandom(times4).act {
                    attack(
                        modifier = values4,
                        hitCount = times4,
                    )
                    applyCountableBuff(
                        CountableBuff.Daze,
                        chance = 33,
                    )
                }
                applyEnemyStageEffect(DisasterHail, 3)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
            TeamNegativeEffectResistanceBuffPassive.new(100, 3) + MoonOnlyCondition,
        ),
        listOf(
            EnemyBrillianceDrainPassive.new(50),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 1),
            TeamAP2DownBuffPassive.new(time = 1) + MoonOnlyCondition,
        ),
        listOf(
            // Oath Revue +50% Dmg to Self
            NegativeEffectResistancePassive.new(100),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
    categories = setOf(DressCategory.Birthday2022),
)
