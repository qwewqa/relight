package xyz.qwewqa.relive.simulator.core.presets.dress.middle.space

import xyz.qwewqa.relive.simulator.core.presets.condition.SpaceOnlyCondition
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

val WheelOfFortuneKaren = Dress(
    name = "Wheel of Fortune Karen",
    character = Character.Karen,
    attribute = Attribute.Space,
    damageType = DamageType.Special,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 40965,
        actPower = 2771,
        normalDefense = 1336,
        specialDefense = 2010,
        agility = 2215,
    ),
    acts = actsOf(
        ActType.Act1("Slash of Brilliance", 2) {
            targetFront().act {
                attack(
                    modifier = 112,
                    hitCount = 1,
                )
            }
            targetSelf().act {
                addBrilliance(20)
            }
        },
        ActType.Act2("Purity of Heaven", 2) {
            targetFront().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
            }
        },
        ActType.Act3("Destiny Guidance", 3) {
            targetAoe().act {
                attack(
                    modifier = 64,
                    hitCount = 3,
                )
            }
            targetAllyAoe().act {
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
        },
        ActType.ClimaxAct("Destiny's End", 2) {
            focus {
                targetFront(3).act {
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = 30,
                        turns = 3,
                    )
                    attack(
                        modifier = 243,
                        hitCount = 4,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        TeamStunResistanceBuffPassive.new(value= 100, turns = 6),
        TeamDexterityUpBuffPassive.new(10,3),
        SelfClimaxDamageUpBuffPassive.new(10),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
)
