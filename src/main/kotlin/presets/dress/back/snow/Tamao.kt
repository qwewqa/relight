package xyz.qwewqa.relive.simulator.presets.dress.back.snow

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relive.simulator.presets.condition.IceOnlyCondition
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.buff.*
import xyz.qwewqa.relive.simulator.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.stage.passive.*

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
        EnemyBrillianceDownPassive.new(20),
        DebuffPassive(ConfusionBuff, ActionTarget.EnemyBack(1)).new(turns = 2),
        GenericBuffPassive(ReviveBuff, ActionTarget.Self).new(50),
    ),
    unitSkill = listOf(
        TeamActPassive.new(50) + IceOnlyCondition,
        TeamCriticalPassive.new(50) + IceOnlyCondition,
    )
)
