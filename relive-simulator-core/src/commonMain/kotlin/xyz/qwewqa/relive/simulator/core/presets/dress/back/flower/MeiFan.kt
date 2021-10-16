package xyz.qwewqa.relive.simulator.core.presets.dress.back.flower

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val StageGirlMeiFan = Dress(
    name = "Stage Girl Mei Fan",
    character = Character.MeiFan,
    attribute = Attribute.Flower,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 33084,
        actPower = 3251,
        normalDefense = 1616,
        specialDefense = 1239,
        agility = 2113,
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
        ActType.Act2("Flash of Determination", 2) {
            targetSelf().act {
                applyBuff(
                    EffectiveDamageDealtUpBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    DexterityUpBuff,
                    value = 20,
                    turns = 3,
                )
            }
            targetByHighest { it.actPower }.act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
        },
        ActType.Act3("Unwavering Passion", 2) {
            targetByHighest { it.actPower }.act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    ActPowerUpBuff,
                    value = 20,
                    turns = 3,
                )
                applyBuff(
                    ApDownBuff,
                    turns = 2,
                )
            }
        },
        ActType.ClimaxAct("O king, my burning passion will create your noble path!", 2) {
            targetBack().act {
                applyBuff(
                    ActPowerDownBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    NormalDefenseDownBuff,
                    value = 30,
                    turns = 3,
                )
                attack(
                    modifier = 369,
                    hitCount = 4,
                    bonusMultiplier = 150,
                    bonusCondition = SpecialDamageOnlyCondition,
                )
            }
        }
    ),
    autoSkills = listOf(
        TeamActPowerUpBuffPassive.new(20, time = 3),
        TeamConfusionResistanceBuffPassive.new(100, time = 6),
        TeamStopResistanceBuffPassive.new(100, time = 6),
    ),
    unitSkill = ActCritical50UnitSkill + FlowerOnlyCondition,
)

val StageGirlMeiFan95 = StageGirlMeiFan.copy(
    name = "Stage Girl Mei Fan [r9.5]",
    stats = StageGirlMeiFan.stats.copy(
        hp = 31836,
        normalDefense = 1557,
        specialDefense = 1194,
    ),
    base = StageGirlMeiFan,
)