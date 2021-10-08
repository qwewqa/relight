package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.BackOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.MeiFanOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SiegfeldOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.YachiyoOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val FuMeiFan = Dress(
    name = "Second Lieutenant Fu Mei Fan",
    character = Character.MeiFan,
    attribute = Attribute.Moon,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 18324,
        actPower = 2975,
        normalDefense = 798,
        specialDefense = 1215,
        agility = 2113,
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
        ActType.ClimaxAct("Oni's Fist", 2) {
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
            }
            targetAnyRandom(10).act {
                attack(
                    modifier = 450,
                    hitCount = 10,
                )
                applyBuff(
                    effect = StopBuff,
                    chance = 33,
                )
            }
        }
    ),
    autoSkills = listOf(
        TeamDexterityUpBuffPassive.new(20,3),
        TeamCriticalUpBuffPassive.new(20,3),
        TeamHpUpPassive.new(100) + SiegfeldOnlyCondition,
        TeamBrillianceRecoveryPassive.new(20) + MeiFanOnlyCondition,
        TeamBrillianceRecoveryPassive.new(20) + YachiyoOnlyCondition,
    ),
    unitSkill = ActCritical30UnitSkill + BackOnlyCondition,
)
