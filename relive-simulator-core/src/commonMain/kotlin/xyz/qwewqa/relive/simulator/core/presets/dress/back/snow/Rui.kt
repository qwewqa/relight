package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.core.presets.condition.TamaoOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val StageGirlRui = Dress(
    name = "Stage Girl Rui",
    character = Character.Rui,
    attribute = Attribute.Snow,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 33766,
        actPower = 3194,
        normalDefense = 1740,
        specialDefense = 1190,
        agility = 2113,
    ),
    acts = actsOf(
        ActType.Act1("Ardent Slash", 2) {
            targetBack().act {
                attack(
                    modifier = 176,
                    hitCount = 1,
                )
            }
        },
        ActType.Act2("Resolute Blade", 2) {
            targetBack().act {
                attack(
                    modifier = 187,
                    hitCount = 2,
                    bonusMultiplier = 150,
                    bonusCondition = SpecialDamageOnlyCondition,
                )
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
            }
        },
        ActType.Act3("Strike of Determination", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 1,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    DexterityUpBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    ApDownBuff,
                    turns = 2,
                )
            }
        },
        ActType.ClimaxAct("My life is on this stage!", 2) {
            targetAoe().act {
                dispelTimed(BuffCategory.Positive)
            }
            targetAnyRandom(10).act {
                attack(
                    modifier = 450,
                    hitCount = 10,
                )

                applyBuff(
                    StopBuff,
                    turns = 1,
                    chance = 33,
                )
            }
        }
    ),
    autoSkills = listOf(
        TeamEffectiveDamageDealtUpBuffPassive.new(20, time = 3),
        TeamCriticalUpBuffPassive.new(20, time = 3),
        TeamBrillianceRecoveryPassive.new(20) + TamaoOnlyCondition,
    ),
    unitSkill = ActCritical50UnitSkill + SnowOnlyCondition,
)

val StageGirlRui95 = StageGirlRui.copy(
    name = "Stage Girl Rui [r9.5]",
    stats = StageGirlRui.stats.copy(
        hp = 32492,
        normalDefense = 1677,
        specialDefense = 1147,
    ),
    base = StageGirlRui,
)
