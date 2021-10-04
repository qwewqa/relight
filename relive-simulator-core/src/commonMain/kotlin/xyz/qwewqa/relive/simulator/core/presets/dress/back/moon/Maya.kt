package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.core.presets.condition.MoonOnlyCondition
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val WorldMaya = Dress(
    name = "World Maya",
    character = Character.Maya,
    attribute = Attribute.Moon,
    damageType = DamageType.Special ,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 32122,
        actPower = 3416,
        normalDefense = 1025,
        specialDefense = 1455,
        agility = 2328,
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
        ActType.Act2("Sky and Earth", 2) {
            targetBack().act {
                attack(
                    modifier = 155,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    effect = NegativeEffectResistanceBuff,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Light and Darkness", 2) {
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
                    effect = EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.ClimaxAct("Genesis of Unmatched Brilliance", 2) {
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
            }
            targetAoe().act {
                attack(
                    modifier = 240,
                    hitCount = 4,
                )
                applyBuff(
                    effect = StopBuff,
                    chance = 80,
                )
            }
        }
    ),
    autoSkills = listOf(
        ApplyReviveBuffPassive.new(50),
        TeamHpUpPassive.new(30),
        EnemyBack3StopBuffPassive.new(turns=1),
    /* This should be a high probability stop, but I'm not sure how to do that without using ApplyBuff
    *  or rewriting buffEffect to have chance as a third argument. Need to remember to give bosses resistance to
    *  stop during TR11 (if they have it).
    */
    ),
    unitSkill = ActCritical50UnitSkill + MoonOnlyCondition,
)
