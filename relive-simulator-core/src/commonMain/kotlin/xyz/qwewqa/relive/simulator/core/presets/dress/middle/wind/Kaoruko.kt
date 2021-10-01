package xyz.qwewqa.relive.simulator.core.presets.dress.middle.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SelfOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val CatalinaKaoruko = Dress(
    name = "Catalina Kaoruko",
    character = Character.Kaoruko,
    attribute = Attribute.Wind,
    damageType = DamageType.Normal,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 25519,
        actPower = 2238,
        normalDefense = 1827,
        specialDefense = 1157,
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
        ActType.Act2("Creation Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 187,
                    hitCount = 1,
                    bonusMultiplier = 150,
                    bonusCondition = SpecialDamageOnlyCondition,
                )
            }
        },
        ActType.Act3("General's Oath", 2) {
            targetFront().act {
                attack(
                    modifier = 198,
                    hitCount = 1,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.ClimaxAct("Black Lion's Scratch Encore", 2) {
            targetByHighest { it.actPower }.act {
                attack(
                    modifier = 369,
                    hitCount = 2,
                    bonusMultiplier = 150,
                    bonusCondition = SpecialDamageOnlyCondition,
                )
            }
        }
    ),
    autoSkills = listOf(
        DamageDealtPassive.new(10),
        EffectiveDamageDealtPassive.new(10),
        DexterityPassive.new(10),
    ),

    //Not sure how you wish to implement selfish US.

    unitSkill = ActCritical50UnitSkill + SelfOnlyCondition,
)
