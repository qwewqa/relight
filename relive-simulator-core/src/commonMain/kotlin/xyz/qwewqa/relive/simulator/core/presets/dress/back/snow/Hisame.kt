package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow


import xyz.qwewqa.relive.simulator.core.presets.condition.PoisonOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeiranOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5030001
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.passive.DexterityPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyPoisonBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.HP50Def50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ConcentrationSnow

val StageGirlHisame = dress5030001(
    name = "Stage Girl Hisame",
    acts = listOf(
        ActType.Act1.blueprint("Target Immunity") {
            Act {
                log ("TODO") { "Verify Aggro cleanse is working as intended." }
                targetAllyAoe().act {
                    dispelTimed(AggroBuff)
                    applyBuff(
                        effect = AggroResistanceUpBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Song of Healing") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(3).act {
                    applyBuff(
                        effect = CounterHealBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Fortitude Concerto") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Fortitude,
                        count = 1,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Let It Rain") {
            Act {
                targetSelf().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = values3,
                        hitCount = 3,
                        bonusMultiplier = 150,
                        bonusCondition = PoisonOnlyCondition,
                        attribute = Attribute.Dream,
                    )
                }
                log ("TODO") { "Verify SE is working as intended." }
                applyEnemyStageEffect(ConcentrationSnow, 6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyPoisonBuffPassive.new(1000,3),
        ),
        listOf(
            DexterityPassive.new(10),
        ),
        listOf(
            SelfFortitudeBuffPassive.new(time = 1),
        ),
    ),
    unitSkill = HP50Def50UnitSkill + SeiranOnlyCondition,
    categories = setOf(DressCategory.StageGirl),
)
