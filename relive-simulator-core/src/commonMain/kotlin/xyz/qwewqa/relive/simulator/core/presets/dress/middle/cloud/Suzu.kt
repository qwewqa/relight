package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.StarOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress5020005
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedNegativeCountableResistanceBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.ApplauseCloud
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.SelfTrapping

val SnowWhitePrinceSuzu = dress5020005(
    name = "Snow White Prince Suzu",
    acts = listOf(
        ActType.Act1.blueprint("More than Anything in the World") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                targetAllyAoe().act {
                    applyCountableBuff(
                        effect = CountableBuff.Hope,
                        count = times3,
                    )
                }
            }
        },
        ActType.Act2.blueprint("For Her") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyAllyStageEffect(ApplauseCloud, 6)
            }
        },
        ActType.Act3.blueprint("By My Side Forever") {
            Act {
                targetFront().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                }
                applyEnemyStageEffect(SelfTrapping, 2)
            }
        },
        ActType.ClimaxAct.blueprint("Kiss of Detoxification") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = LockedNegativeCountableResistanceBuff,
                        value = values1,
                        turns = times1,
                    )
                }
                targetFront().act {
                    attack(
                        modifier = values2,
                        hitCount = times2,
                    )
                    //Curtains Closed
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
            SelfFortitudeBuffPassive.new(time = 4),
            TeamReviveBuffPassive.new(50, time = 1) + CloudOnlyCondition,
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(20, 3),
            TeamCriticalUpBuffPassive.new(20, 3),
            TeamEffectiveDamageDealtUpBuffPassive.new(20, 3),
        ),
        listOf(
            TeamAPDownBuffPassive.new(time = 2) + CloudOnlyCondition,
        ),
        //Oath Revue +50% Dmg to Self
    ),
    unitSkill = ActCritical50UnitSkill + (CloudOnlyCondition or StarOnlyCondition),
    categories = setOf(DressCategory.Birthday2022),
)
