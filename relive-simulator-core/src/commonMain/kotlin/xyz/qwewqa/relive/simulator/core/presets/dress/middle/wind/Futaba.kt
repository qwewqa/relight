package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.MiddleOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val HondaFutaba = Dress(
    name = "Honda Futaba",
    character = Character.Futaba,
    attribute = Attribute.Wind,
    damageType = DamageType.Special,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 26154,
        actPower = 2432,
        normalDefense = 1213,
        specialDefense = 1455,
        agility = 1923,
    ),
    acts = actsOf(
        ActType.Act1("Strong Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 176,
                    hitCount = 1,
                )
            }
        },
        ActType.Act2("Victory Battle", 2) {
            targetBack().act {
                attack(
                    modifier = 155,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    ActPowerUpBuff,
                    value = 30,
                    turns = 3
                )
                applyBuff(
                    EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3
                )
            }
        },
        ActType.Act3("Furious War", 3) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    DexterityUpBuff,
                    value = 20,
                    turns = 3
                )
                applyBuff(
                    EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3
                )
            }
        },
        ActType.ClimaxAct("Invincible Spear", 2) {
            targetBack().act {
                flipTimed(
                    category = BuffCategory.Positive,
                    count = 5
                )
                attack(
                    modifier = 369,
                    hitCount = 3,
                    bonusMultiplier = 150,
                    bonusCondition = NormalDamageOnlyCondition
                )
            }
        }
    ),
    autoSkills = listOf(
        TeamDexterityUpBuffPassive.new(10, turns = 3),
        TeamCriticalUpBuffPassive.new(20, turns = 3),
        EffectiveDamageDealtPassive.new(20),
    ),
    unitSkill = ActCritical30UnitSkill + MiddleOnlyCondition,
)
