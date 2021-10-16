package xyz.qwewqa.relive.simulator.core.presets.dress.back.moon

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageMoon
import xyz.qwewqa.relive.simulator.core.presets.condition.SeishoOnlyCondition

val StageGirlHikariBaby = Dress(
    name = "Stage Girl Hikari [r1, lv1, bond1]",
    character = Character.Hikari,
    attribute = Attribute.Moon,
    damageType = DamageType.Special,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 2550,
        actPower = 353,
        normalDefense = 201,
        specialDefense = 121,
        agility = 261,
    ),
    acts = actsOf(
        ActType.Act1("Strong Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 147,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Severing Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 147,
                    hitCount = 1,
                )
                dispelTimed(BuffCategory.Positive)
            }
        },
        ActType.Act3("Darkness Slash", 3) {
            targetFront().act {
                attack(
                    modifier = 165,
                    hitCount = 1,
                )
            }
            targetAoe().act {
                applyBuff(
                    effect = BlindnessBuff,
                    turns = 3,
                    chance = 70,
                )
            }
        },
        ActType.ClimaxAct("All of this... is for the sake of \"Starlight\"!", 2) {
            targetSelf().act {
                applyBuff(
                    PerfectAim,
                    turns = 1
                )
            }
            targetAoe().act {
                attack(
                    modifier = 117,
                    hitCount = 2,
                )
                applyBuff(
                    effect = BlindnessBuff,
                    turns = 2,
                    chance = 80,
                )
                applyBuff(
                    effect = ActPowerDownBuff,
                    value = 20,
                    turns = 3,
                )
            }
            applyAllyStageEffect(WeAreOnTheStageMoon, 6)
        }
    ),
    autoSkills = listOf(
        DamageDealtPassive.new(10),
    ),
    unitSkill = ActCritical50UnitSkill + SeishoOnlyCondition,
)
