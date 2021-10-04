package xyz.qwewqa.relive.simulator.core.presets.dress.back.space

import xyz.qwewqa.relive.simulator.core.presets.condition.NormalDamageOnlyCondition
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

val IzanagiNana = Dress(
    name = "Izanagi Nana",
    character = Character.Nana,
    attribute = Attribute.Space,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 15843,
        actPower = 2704,
        normalDefense = 885,
        specialDefense = 418,
        agility = 1796,
    ),
    acts = actsOf(
        ActType.Act1("Strong Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 176,
                    hitCount = 1,
                )
            }
        },
        ActType.Act2("Sacred Will", 2) {
            targetBack(3).act {
                attack(
                    modifier = 116,
                    hitCount = 1,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = NegativeEffectResistanceBuff,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Cloud Piercing", 2) {
            targetByHighest { it.actPower }.act {
                attack(
                    modifier = 198,
                    hitCount = 1,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = PerfectAim,
                    turns = 3,
                )
            }
        },
        ActType.ClimaxAct("Izanagi's Creation", 2) {
            targetAoe().act {
                attack(
                    modifier = 197,
                    hitCount = 3
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 50,
                    turns = 3,
                )
                applyBuff(
                    effect = CriticalUpBuff,
                    value = 50,
                    turns = 3,
                )
                applyBuff(
                    effect = NormalBarrierBuff,
                    value = 15000,
                    turns = 3,
                )
                applyBuff(
                    effect = SpecialBarrierBuff,
                    value = 15000,
                    turns = 3,
                )
            }
        }
    ),
    autoSkills = listOf(
        ApplyFortitudeBuffPassive.new(50),
        SelfClimaxDamageUpBuffPassive.new(10),
    //    SelfBrillianceRecoveryPerTurnPassive.new(20),
        TeamAPDownBuffPassive.new(turns=1),
    ),
    unitSkill = ActCritical30UnitSkill + NormalDamageOnlyCondition,
)

val JusticeNana = Dress(
    name = "Justice Nana",
    character = Character.Nana,
    attribute = Attribute.Space,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 31701,
        actPower = 3416,
        normalDefense = 1577,
        specialDefense = 1025,
        agility = 2113,
    ),
    acts = actsOf(
        ActType.Act1("Brilliance Slash", 2) {
            targetBack().act {
                attack(
                    modifier = 112,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Sword of Justice", 2) {
            targetAoe().act {
                attack(
                    modifier = 64,
                    hitCount = 2
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = 20,
                    turns = 3,
                )
                applyBuff(
                    effect = ApDownBuff,
                    turns = 2,
                )
            }
        },
        ActType.Act3("Right Judgement", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 3,
                )
            }
            targetAllyAoe().act {
                dispelTimed(BuffCategory.Negative)
                heal(percent = 30)
            }
        },
        ActType.ClimaxAct("Izanagi's Creation", 2) {
            targetSelf().act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = 20,
                    turns = 3,
                )
                applyBuff(
                    effect = DexterityUpBuff,
                    value = 20,
                    turns = 3,
                )
                applyBuff(
                    effect = CriticalUpBuff,
                    value = 20,
                    turns = 3,
                )
            }
            targetAoe().act {
                attack(
                    modifier = 240,
                    hitCount = 4
                )
            }
        }
    ),
    autoSkills = listOf(
        TeamDexterityUpBuffPassive.new(10,3),
        TeamEffectiveDamageDealtUpBuffPassive.new(20,3),
        EnemyBrillianceDrainPassive.new(20),
    ),
    unitSkill = ActCritical50UnitSkill + SpaceOnlyCondition,
)