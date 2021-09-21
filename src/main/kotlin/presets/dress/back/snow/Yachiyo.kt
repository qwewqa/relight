package xyz.qwewqa.relive.simulator.presets.dress.back.snow

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.character.School
import xyz.qwewqa.relive.simulator.presets.condition.IceOnlyCondition
import xyz.qwewqa.relive.simulator.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.presets.condition.characterCondition
import xyz.qwewqa.relive.simulator.presets.condition.schoolCondition
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.buff.*
import xyz.qwewqa.relive.simulator.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.stage.passive.*


val StageGirlYachiyo = Dress(
    name = "Stage Girl Yachiyo",
    character = Character.Yachiyo,
    attribute = Attribute.Ice,
    damageType = DamageType.Special,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 32391,
        actPower = 3354,
        normalDefense = 1048,
        specialDefense = 1578,
        agility = 2215,
    ),
    acts = actsOf(
        ActType.Act1("Prayer Song", 2) {
            targetFront(3).act {
                attack(
                    modifier = 101,
                    hitCount = 2,
                )
            }
            targetAllyFront(3).act {
                applyBuff(
                    ApDownBuff,
                    turns = 2
                )
            }
        },
        ActType.Act2("Goddess Smile", 2) {
            targetAoe().act {
                attack(
                    modifier = 101,
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
                    DexterityUpBuff,
                    value = 30,
                    turns = 3
                )
            }
        },
        ActType.Act3("Piercing Arrow", 3) {
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
                applyBuff(
                    ApUpBuff,
                    turns = 2,
                )
                attack(
                    modifier = 64,
                    hitCount = 2,
                )
            }
        },
        ActType.ClimaxAct("This world is a stage. Even the king is a player!", 2) {
            TODO()
        }
    ),
    autoSkills = listOf(
        EnemyBrillianceDownPassive.new(10),
        TeamHpUpPassive.new(50),
        NegativeEffectResistPassive.new(50),
    ),
    unitSkill = listOf(
        TeamActPassive.new(50) + schoolCondition(School.Siegfeld),
        TeamCriticalPassive.new(50) + schoolCondition(School.Siegfeld),
    )
)
