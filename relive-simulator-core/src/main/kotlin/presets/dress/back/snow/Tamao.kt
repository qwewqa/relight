package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.IceOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val DeathTamao = Dress(
    name = "Death Tamao",
    character = Character.Tamao,
    attribute = Attribute.Ice,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 32391,
        actPower = 3338,
        normalDefense = 1616,
        specialDefense = 1076,
        agility = 2113,
    ),
    acts = actsOf(
        ActType.Act1("Ardent Slash", 2) {
            targetBack().act {
                attack(
                    modifier = 176,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Soul Rebirth", 2) {
            targetBack().act {
                attack(
                    modifier = 155,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    DexterityUpBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    NegativeEffectResistanceBuff,
                    value = 100,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Death's Whisper", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAoe().act {
                applyBuff(
                    MarkBuff,
                    turns = 2,
                )
                applyBuff(
                    NormalDefenseDownBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.ClimaxAct("Memento Mori", 2) {
            focus {
                targetAoe().act {
                    attack(
                        modifier = 240,
                        hitCount = 3,
                    )
                }
            }
            targetAllyBack(2).act {
                applyBuff(ReviveBuff)
            }
        }
    ),
    autoSkills = listOf(
        EnemyBrillianceDrainPassive.new(20),
        EnemyBack1ConfusionBuffPassive.new(turns = 2),
        ReviveBuffPassive.new(50),
    ),
    unitSkill = listOf(
        TeamActPowerUpPassive.new(50) + IceOnlyCondition,
        TeamCriticalPassive.new(50) + IceOnlyCondition,
    )
)
