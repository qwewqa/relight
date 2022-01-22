package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030017
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1030021
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.HyakkaRyoran
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageFlower

val SakuyahimeMahiru = dress1030021(
    name = "Konohana Sakuya-hime Mahiru",
    acts = listOf(
        ActType.Act1.blueprint("Brilliance Flower") {
            Act {
                targetByHighest { it.actPower }.act {
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
        ActType.Act2.blueprint("Scattered Flowers") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Budding Flower") {
            Act {
                targetByHighest { it.actPower }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyBack(2).act {
                    addBrilliance(values2)
                }
            }
        },
        ActType.ClimaxAct.blueprint("Shinonome's Flying Flowers") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 3,
                    )
                }
                applyAllyStageEffect(HyakkaRyoran,2)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfEvasionBuffPassive.new(time = 5),
        ),
        listOf(
            SelfReviveBuffPassive.new(50, 1),
        ),
        listOf(
            EnemyBack3APUpBuffPassive.new(time = 3),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + FlowerOnlyCondition,
)

val StageGirlMahiru = dress1030017(
    name = "Stage Girl Mahiru",
    acts = listOf(
        ActType.Act1.blueprint("Strong Smash") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Sluggish Smash") {
            Act {
                targetFront().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = AgilityDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Budding Flower") {
            Act {
                targetFront(3).act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAllyByHighest(count = 2) { it.actPower }.act {
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
            }
        },
        ActType.ClimaxAct.blueprint("Shinonome's Flying Flowers") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                    applyBuff(
                        effect = AccuracyRateDownBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Fortitude,
                        count = times3,
                    )
                }
                applyAllyStageEffect(WeAreOnTheStageFlower,6)
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            ConfusionResistancePassive.new(100),
        ),
        listOf(
            SelfEvasionBuffPassive.new(time = 1),
        ),
        listOf(
            TeamAgilityUpBuffPassive.new(10,3),
        ),
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + FlowerOnlyCondition,
    category = DressCategory.StageGirl,
)