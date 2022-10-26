package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind


import xyz.qwewqa.relive.simulator.core.presets.condition.SunOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress4040015
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.ClimaxDamageDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.DexterityDownBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.DressCategory
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.ActCritical50UnitSkill
import xyz.qwewqa.relive.simulator.core.stage.passive.EnemyDexterityDownBuffPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.SelfFortitudeBuffPassive

val ChariotShiori = dress4040015(
    name = "Chariot Shiori",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetFront().act {
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
        ActType.Act2.blueprint("Weir Unleashing") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                }
                targetAllyAoe().act{
                    dispelTimed(BuffCategory.Negative)
                }
            }
        },
        ActType.Act3.blueprint("Belligerent Smile") {
            Act {
                targetAoe().act {
                    attack(
                        modifier = values1,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    applyBuff(
                        effect = DexterityDownBuff,
                        value = values3,
                        turns = times3,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Chariot Rampage") {
            Act {
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                    applyBuff(
                        effect = ClimaxDamageDownBuff,
                        value = values2,
                        turns = times2,
                    )
                    attack(
                        modifier = values3,
                        hitCount = 2,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            EnemyDexterityDownBuffPassive.new(10, 3),
        ),
        listOf(
            // TODO: Enemy Agility Down Passive
        ),
        listOf(
            SelfFortitudeBuffPassive.new(1),
        ),
    ),
    unitSkill = ActCritical50UnitSkill + (WindOnlyCondition or SunOnlyCondition),
    categories = setOf(DressCategory.Arcana),
)
