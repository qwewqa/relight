package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.dress.generated.dress1050024
import xyz.qwewqa.relive.simulator.core.stage.Act
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.blueprint
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val WukongMaya = dress1050024(
    name = "Sun Wukong Maya",
    acts = listOf(
        ActType.Act1.blueprint("Slash of Brilliance") {
            Act {
                targetByLowest { it.normalDefense }.act {
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
        ActType.Act2.blueprint("Mei Houwang's Strike") {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetBack(2).act{
                    applyCountableBuff(CountableBuff.WeakSpot)
                }
            }
        },
        ActType.Act3.blueprint("Qitian Dasheng's Strike") {
            Act {
                targetByLowest { it.normalDefense }.act {
                    attack(
                        modifier = values1,
                        hitCount = 1,
                    )
                }
                targetAoe().act {
                    applyBuff(
                        effect = MarkBuff,
                        turns = times2,
                    )
                }
            }
        },
        ActType.ClimaxAct.blueprint("Ruyi Jingu Bang") {
            Act {
                targetAllyAoe().act {
                    applyBuff(
                        effect = NormalReflectBuff,
                        value = values1,
                        turns = times1,
                    )
                    applyBuff(
                        effect = SpecialReflectBuff,
                        value = values2,
                        turns = times2,
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = values3,
                        hitCount = 1,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        listOf(
            SelfFortitudeBuffPassive.new(time = 3),
        ),
        listOf(
            TeamHpUpPassive.new(50),
            TeamHpUpPassive.new(30) + SeishoOnlyCondition,
        ),
        listOf(
            TeamDexterityUpBuffPassive.new(16, 3),
        )
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
)
