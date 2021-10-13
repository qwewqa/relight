package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.FrontierOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val JudgementShizuha = Dress(
    name = "Judgement Shizuha",
    character = Character.Shizuha,
    attribute = Attribute.Cloud,
    damageType = DamageType.Special,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 31372,
        actPower = 3338,
        normalDefense = 1157,
        specialDefense = 1735,
        agility = 2113,
    ),
    acts = actsOf(
        ActType.Act1("Slash of Brilliance", 2) {
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
        ActType.Act2("Time of Decision", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAoe().act {
                applyBuff(
                    effect = MarkBuff,
                    turns = 2,
                )
                applyBuff(
                    effect = SpecialDefenseDownBuff,
                    value = 30,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Time of Judgement", 2) {
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
        ActType.ClimaxAct("Love & Rebirth Judgement", 2) {
            focus {
                targetAoe().act {
                    attack(
                        modifier = 240,
                        hitCount = 4,
                        bonusMultiplier = 150,
                        bonusCondition = SeishoOnlyCondition,
                    )
                }
            }
            targetAllyBack(2).act {
                heal(
                    percent = 50,
                )
            }
        }
    ),
    autoSkills = listOf(
        SelfReviveBuffPassive.new(50, time = 1),
        TeamHpUpPassive.new(30),
        TeamHpUpPassive.new(30) + FrontierOnlyCondition,
        EnemyFront3NightmareBuffPassive.new(6666,3)
    /* This should be a high probability nightmare, but I'm not sure how to do that without using ApplyBuff
    *  or rewriting buffEffect to have chance as a third argument. Need to remember to give bosses resistance to
    *  nightmare during TR12 (if they have it).
    */
    ),
    unitSkill = ActCritical50UnitSkill + CloudOnlyCondition,
)
