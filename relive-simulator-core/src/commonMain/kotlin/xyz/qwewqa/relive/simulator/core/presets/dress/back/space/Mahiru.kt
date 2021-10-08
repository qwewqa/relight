package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position


val SanadaMahiru = Dress(
    name = "Sanada Yukimura Mahiru",
    character = Character.Mahiru,
    attribute = Attribute.Space,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 18605,
        actPower = 2747,
        normalDefense = 1541,
        specialDefense = 1076,
        agility = 2113,
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
        ActType.Act2("Spearheading Blade", 2) {
            targetSelf().act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = 20,
                    turns = 3,
                )
                applyBuff(
                    effect = CriticalUpBuff,
                    value = 20,
                    turns = 3,
                )
            }
            targetByHighest { it.actPower }.act {
                attack(
                    modifier = 155,
                    hitCount = 2,
                )
            }
        },
        ActType.Act3("Dashing Blade", 2) {
            targetSelf().act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 20,
                    turns = 3,
                )
                applyBuff(
                    effect = EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3,
                )
            }
            targetByHighest { it.actPower }.act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
        },
        ActType.ClimaxAct("Greatest Spear", 2) {
            targetByHighest { it.actPower }.act {
                applyBuff(
                    effect = MarkBuff,
                    turns = 2
                )
                applyBuff(
                    effect = NormalDefenseDownBuff,
                    value = 30,
                    turns = 3,
                )
                attack(
                    modifier = 369,
                    hitCount = 3,
                    bonusMultiplier = 150,
                    bonusCondition = SpecialDamageOnlyCondition,
                )
            }
        }
    ),
    autoSkills = listOf(
        DamageDealtPassive.new(10),
        DexterityPassive.new(10),
        EffectiveDamageDealtPassive.new(20),
    ),
    unitSkill = ActCritical30UnitSkill + BackOnlyCondition,
)
