package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition
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

val StageGirlNana = Dress(
    name = "Stage Girl Nana",
    character = Character.Nana,
    attribute = Attribute.Cloud,
    damageType = DamageType.Normal,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 48000,
        actPower = 2284,
        normalDefense = 2264,
        specialDefense = 1169,
        agility = 1576,
    ),
    acts = actsOf(
        ActType.Act1("Strong Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 176,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Inspiring Slash", 3) {
            targetFront().act {
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
            }
        },
        ActType.Act3("Synchro Slash", 3) {
            targetFront().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                addBrilliance(15)
            }
        },
        ActType.ClimaxAct("I will protect them! Forever... Again and again!", 2) {
            focus {
                targetAoe().act {
                    attack(
                        modifier = 140,
                        hitCount = 2,
                    )
                }
            }
            //Stage Effect "We Are on the Stage (Cloud)"  Need to code stage effect(s).
        }
    ),
    autoSkills = listOf(
        SelfStopResistanceBuffPassive.new(50),
        ApplyFortitudeBuffPassive.new(50),
        TeamActPowerUpBuffPassive.new(20,3),
    ),
    unitSkill = ActCritical50UnitSkill + SeishoOnlyCondition,
)
