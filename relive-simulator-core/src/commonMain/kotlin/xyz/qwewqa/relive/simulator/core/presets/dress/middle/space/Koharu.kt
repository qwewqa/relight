package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeiranOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5010001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyNormalDefenseBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemySpecialDefenseBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ConcentrationSpace

val StageGirlKoharu = dress5010001(
    name = "Stage Girl Koharu",
    acts = listOf(
        ActType.Act1.blueprint("Quick Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = AgilityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Sacred Song") {
            Act {
                targetAllyFront(3).act {
                    applyBuff(
                        effect = NegativeEffectResistanceUpBuff,
                        value = values1,
                        turns = times1,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Restraint Concerto") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = StunBuff,
                        chance = 50,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Blue Fire") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = times1,
                    )
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAllyAoe().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act {
                    attack(
                        modifier = values4,
                        hitCount = 3,
                        bonusMultiplier = 150,
                        bonusCondition = NormalDamageOnlyCondition,
                        attribute = Attribute.Dream,
                    )
                }
                log ("TODO") { "Verify SE is working as intended." }
                applyEnemyStageEffect(ConcentrationSpace, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyNormalDefenseBuffPassive.new(20,3),
        ),
        listOf(
            EnemySpecialDefenseBuffPassive.new(20,3),
        ),
        listOf(
            SelfFortitudeBuffPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SeiranOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
