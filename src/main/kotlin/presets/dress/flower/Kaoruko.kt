package xyz.qwewqa.relive.simulator.presets.dress.middle.flower

import xyz.qwewqa.relive.simulator.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.buff.*
import xyz.qwewqa.relive.simulator.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.stage.passive.ActionTarget
import xyz.qwewqa.relive.simulator.stage.passive.GenericBuffPassive
import xyz.qwewqa.relive.simulator.stage.passive.TeamActPassive
import xyz.qwewqa.relive.simulator.stage.passive.TeamCriticalPassive
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position

val DevilKaoruko = Dress(
    name = "Devil Kaoruko",
    character = Character.Kaoruko,
    attribute = Attribute.Flower,
    damageType = DamageType.Special,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 38597,
        actPower = 3020,
        normalDefense = 1213,
        specialDefense = 1827,
        agility = 2113,
    ),
    acts = actsOf(
        ActType.Act1("Brilliance Slash", 2) {
            targetBack().act {
                attack(
                    modifier = 112,
                    hitCount = 1,
                )
            }
            targetSelf().act {
                addBrilliance(20)
            }
        },
        ActType.Act2("Soul Contract", 2) {
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
                    turns = 3,
                )
                applyBuff(
                    EffectiveDamageDealtBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Devil's Whisper", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
                dispelTimed(BuffCategory.Positive)
                dispelCountable(BuffCategory.Positive)
            }
        },
        ActType.ClimaxAct("Flames of Hell", 2) {
            TODO()
        }
    ),
    autoSkills = listOf(
        GenericBuffPassive(DexterityUpBuff, ActionTarget.Team).new(10, turns = 3),
        GenericBuffPassive(CriticalUpBuff, ActionTarget.Team).new(20, turns = 3),
        // TODO: CX Seal
    ),
    unitSkill = listOf(
        TeamActPassive.new(50) + FlowerOnlyCondition,
        TeamCriticalPassive.new(50) + FlowerOnlyCondition,
    )
)
