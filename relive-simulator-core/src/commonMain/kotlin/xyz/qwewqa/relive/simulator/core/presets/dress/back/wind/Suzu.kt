package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.BurnOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeiranOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5020001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ConcentrationWind

val StageGirlSuzu = dress5020001(
    name = "Stage Girl Suzu",
    acts = listOf(
        ActType.Act1.blueprint("Evasion Slash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyFront(3).act {
                    applyCountableBuff(CountableBuff.Evasion, 1)
                }
            }
        },
        ActType.Act2.blueprint("Pressure Rondo") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Absorb Dance") {
            Act {
                targetAllyAoe().act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = AbsorbBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Dawn Storm") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                        bonusMultiplier = 150,
                        bonusCondition = BurnOnlyCondition,
                        attribute = Attribute.Dream,
                    )
                    applyBuff(
                        effect = StopBuff,
                        chance = 75,
                        turns = times2,
                    )
                }
                log ("TODO") { "Verify SE is working as intended." }
                applyEnemyStageEffect(ConcentrationWind, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            DamageDealtPassive.new(7),
        ),
        listOf(
            EnemyBurnBuffPassive.new(1000,3),
        ),
        listOf(
            SelfFortitudeBuffPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + SeiranOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
