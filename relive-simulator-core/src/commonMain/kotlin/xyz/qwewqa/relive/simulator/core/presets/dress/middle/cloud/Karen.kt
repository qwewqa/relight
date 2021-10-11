package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val MitsuhideKaren = Dress(
    name = "Akechi Mitsuhide Karen",
    character = Character.Karen,
    attribute = Attribute.Cloud,
    damageType = DamageType.Normal,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 21653,
        actPower = 2707,
        normalDefense = 1454,
        specialDefense = 964,
        agility = 2085,
    ),
    acts = actsOf(
        ActType.Act1("Limitless Radiance", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.Act2("Cloud Piercing", 2) {
            targetByHighest { it.actPower } .act {
                attack(
                    modifier = 198,
                    hitCount = 1,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = PerfectAim,
                    turns = 3
                )
            }
        },
        ActType.Act3("Gale Blade", 2) {
            targetAllyAoe().act {
                dispelTimed(BuffCategory.Negative)
                applyBuff(
                    effect = NegativeEffectResistanceBuff,
                    value = 100,
                    turns = 3,
                )
            }
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
        },
        ActType.ClimaxAct("Flames of Justice", 2) {
            targetAoe().act {
                attack(
                    modifier = 240,
                    hitCount = 5,
                )
            }
            // TODO
/*            targetAllyFront(5).act {
*                applyBuff(
*                    effect = Resilience,   Need to code Resilience.
*                    turns = 1,
*                )
*            }
*             Stage Effect "Self Trapping"  Need to code stage effect(s).
*/      }
    ),
    autoSkills = listOf(
        TeamAPDownBuffPassive.new(time = 1),
        TeamHpUpPassive.new(50),
        EnemyBrillianceDrainPassive.new(50),
    ),
    unitSkill = ActCritical30UnitSkill + NormalDamageOnlyCondition,
)
