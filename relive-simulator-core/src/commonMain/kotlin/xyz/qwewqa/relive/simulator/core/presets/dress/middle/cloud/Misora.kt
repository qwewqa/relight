package xyz.qwewqa.relive.simulator.core.presets.dress.middle.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.CloudOnlyCondition
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

val StageGirlMisora = Dress(
    name = "Stage Girl Misora",
    character = Character.Misora,
    attribute = Attribute.Cloud,
    damageType = DamageType.Normal,
    position = Position.Middle,
    stats = defaultDressStats.copy(
        hp = 40003,
        actPower = 2997,
        normalDefense = 2073,
        specialDefense = 1300,
        agility = 1938,
    ),
    acts = actsOf(
        ActType.Act1("Rear Flash", 2) {
            targetByLowest { it.normalDefense }.act {
                attack(
                    modifier = 176,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Lightning Speed", 2) {
            targetByLowest { it.normalDefense }.act {
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
                    ApplyEvasionBuff,
                    value = 1,
                )
            }
        },
        ActType.Act3("Leap to the Skies", 4) {
            targetAllyBack(5).act {
                addBrilliance(60)
                applyBuff(
                    effect = ApDownBuff,
                    turns = 2,
                )
            }
        },
        ActType.ClimaxAct("Aim towards those skies, Frontier!", 2) {
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
                attack(
                    modifier = 197,
                    hitCount = 5,
                )
                applyBuff(
                    effect = LockedPositiveEffectResistanceBuff,
                    turns = 2
                )
            }
        }
    ),
    autoSkills = listOf(
        EnemyBrillianceDrainPassive.new(10),
        ApplyReviveBuffPassive.new(50),
        NegativeEffectResistancePassive.new(50),
    ),
    unitSkill = ActCritical50UnitSkill + CloudOnlyCondition,
)
