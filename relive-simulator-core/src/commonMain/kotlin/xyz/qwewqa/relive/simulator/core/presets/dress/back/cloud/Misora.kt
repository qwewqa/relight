package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MisoraOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.ShizuhaOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val AceMisora = Dress(
    name = "Stormy Ace Misora",
    character = Character.Misora,
    attribute = Attribute.Cloud,
    damageType = DamageType.Special,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 18470,
        actPower = 3000,
        normalDefense = 798,
        specialDefense = 1196,
        agility = 2085,
    ),
    acts = actsOf(
        ActType.Act1("Gale Dance", 2) {
            targetAllyAoe().act {
                dispelTimed(BuffCategory.Negative)
                applyBuff(
                    effect = NegativeEffectResistanceBuff,
                    value = 100,
                    turns = 3
                )
            }
            targetAoe().act {
                attack(
                    modifier = 101,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Forced Breakthrough", 2) {
            targetBack().act {
                attack(
                    modifier = 155,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = ApDownBuff,
                    turns = 2,
                )
                applyBuff(
                    effect = EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Limitless Radiance", 2) {
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
        ActType.ClimaxAct("Turbulent Shooting Typhoon", 2) {
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
            }
            targetAnyRandom(10).act {
                attack(
                    modifier = 450,
                    hitCount = 10,
                )
                // TODO applyBuff(
//                    effect = PrideBuff,
//                    chance = 33,
//                )
            }
        }
    ),
    autoSkills = listOf(
        TeamDexterityUpBuffPassive.new(20,3),
        TeamCriticalUpBuffPassive.new(20,3),
        TeamHpUpPassive.new(100) + FrontierOnlyCondition,
        TeamBrillianceRecoveryPassive.new(20) + MisoraOnlyCondition,
        TeamBrillianceRecoveryPassive.new(20) + ShizuhaOnlyCondition,
    ),
    unitSkill = ActCritical30UnitSkill + BackOnlyCondition,
)
