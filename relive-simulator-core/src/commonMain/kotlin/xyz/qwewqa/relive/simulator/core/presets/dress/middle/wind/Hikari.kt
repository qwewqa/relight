package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val TowerHikari = Dress(
    name = "Tower Hikari",
    character = Character.Hikari,
    attribute = Attribute.Wind,
    damageType = DamageType.Normal,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 41356,
        actPower = 2707,
        normalDefense = 2235,
        specialDefense = 1487,
        agility = 1892,
    ),
    acts = actsOf(
        ActType.Act1("Walled Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 105,
                    hitCount = 2,
                )
            }
            targetSelf().act {
                applyBuff(
                    NormalBarrierBuff,
                    value = 5000,
                    turns = 3,
                )
            }
        },
        ActType.Act2("Destruction Begins", 2) {
            targetAllyAoe().act {
                applyBuff(
                    DexterityUpBuff,
                    value = 30,
                    turns = 3
                )
                applyBuff(
                    PerfectAim,
                    turns = 3
                )
            }
            targetFront().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
        },
        ActType.Act3("Imminent Calamity", 3) {
            targetAoe().act {
                applyBuff(
                    MarkBuff,
                    turns = 2,
                )
                attack(
                    modifier = 64,
                    hitCount = 2,
                )
            }
        },
        ActType.ClimaxAct("Tower's Conviction", 2) {
            targetAoe().act {
                attack(
                    modifier = 197,
                    hitCount = 5,
                )
            }
            targetAllyAoe().act {
                applyCountableBuff(
                    CountableBuff.Evasion,
                    count = 2,
                )
                applyCountableBuff(
                    CountableBuff.Fortitude,
                    count = 1,
                )
            }
        }
    ),
    autoSkills = listOf(
        SelfFortitudeBuffPassive.new(time = 1),
        TeamCriticalUpBuffPassive.new(20, time = 3),
        TeamDexterityUpBuffPassive.new(10, time = 3),
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
)
