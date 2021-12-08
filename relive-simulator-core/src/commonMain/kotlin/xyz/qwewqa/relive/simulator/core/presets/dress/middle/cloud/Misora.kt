package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress3020017
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val StageGirlMisora = dress3020017(
    name = "Stage Girl Misora",
    acts = listOf(
        ActType.Act1.blueprint("Rear Flash", 2) {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
            }
        },
        ActType.Act2.blueprint("Lightning Speed", 2) {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act {
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyCountableBuff(
                        CountableBuff.Evasion,
                        count = times3,
                    )
                }
            }
        },
        ActType.Act3.blueprint("Leap to the Skies", 4) {
            Act {
                targetAllyBack(5).act {
                    addBrilliance(values1)
                    applyBuff(
                        effect = ApDownBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Aim towards those skies, Frontier!", 2) {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    attack(
                        modifier = values2,
                        hitCount = 5,
                    )
                    applyBuff(
                        effect = LockedPositiveEffectResistanceBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyBrillianceDrainPassive.new(10),
        ),
        listOf(
            SelfReviveBuffPassive.new(50, time = 1),
        ),
        listOf(
            NegativeEffectResistancePassive.new(50),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + CloudOnlyCondition,
    category = DressCategory.StageGirl,
)
