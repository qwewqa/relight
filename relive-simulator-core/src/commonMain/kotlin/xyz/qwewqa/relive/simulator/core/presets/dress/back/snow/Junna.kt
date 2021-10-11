package xyz.qwewqa.relive.simulator.core.presets.dress.back.snow

import xyz.qwewqa.relive.simulator.core.presets.condition.SnowOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.WeAreOnTheStageSnow
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position


val StageGirlJunna = Dress(
    name = "Stage Girl Junna",
    character = Character.Junna,
    attribute = Attribute.Snow,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 34767,
        actPower = 3173,
        normalDefense = 1666,
        specialDefense = 1114,
        agility = 2008,
    ),
    acts = actsOf(
        ActType.Act1("Snipe", 2) {
            targetFront().act {
                attack(
                    modifier = 176,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Blessed Strike", 3) {
            targetFront().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    DamageTakenDownBuff,
                    value = 20,
                    turns = 2,
                )
            }
        },
        ActType.Act3("Piercing Arrow", 3) {
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
        ActType.ClimaxAct("I'll take hold of a star of my own!", 2) {
            targetAllyAoe().act {
                applyBuff(
                    effect = ActPowerUpBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    effect = ClimaxDamageUpBuff,
                    value = 30,
                    turns = 3,
                )
            }
            targetAoe().act {
                attack(
                    modifier = 140,
                    hitCount = 3,
                )
            }
            applyAllyStageEffect(WeAreOnTheStageSnow, 6)
        }
    ),
    autoSkills = listOf(
        SelfFortitudeBuffPassive.new(time = 1),
        SelfTurnBrillianceRecoveryPassive.new(10),
        TeamDexterityUpBuffPassive.new(20,3),
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + SnowOnlyCondition,
)
