package xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud

import xyz.qwewqa.relive.simulator.core.presets.condition.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*

val StageGirlClaudine = Dress(
    name = "Stage Girl Claudine",
    character = Character.Claudine,
    attribute = Attribute.Cloud,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 34459,
        actPower = 3162,
        normalDefense = 1793,
        specialDefense = 1076,
        agility = 2008,
    ),
    acts = actsOf(
        ActType.Act1("Marked Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 105,
                    hitCount = 1,
                )
                applyBuff(
                    effect = MarkBuff,
                    turns = 3,
                )
            }
        },
        ActType.Act2("Purifying Slash", 2) {
            targetFront().act {
                attack(
                    modifier = 155,
                    hitCount = 1,
                )
            }
            targetAllyFront(3).act {
                dispelTimed(BuffCategory.Negative)
            }
        },
        ActType.Act3("Synchro of Brilliance", 2) {
            targetFront().act {
                attack(
                    modifier = 155,
                    hitCount = 1,
                )
            }
            targetAllyAoe().act {
                addBrilliance(15)
            }
        },
        ActType.ClimaxAct("C'est moi! la star!", 1) {
            targetFront().act {
                dispelTimed(BuffCategory.Positive)
                attack(
                    modifier = 450,
                    hitCount = 3,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    effect = NormalReflectBuff,
                    value = 20,
                    turns = 1,
                )
                applyBuff(
                    effect = SpecialReflectBuff,
                    value = 20,
                    turns = 1,
                )
            }
            //TODO Stage Effect
        }
    ),
    autoSkills = listOf(
        TeamConfusionResistanceBuffPassive.new(100,3),
        TeamBurnResistanceBuffPassive.new(100,3),
        TeamStunResistanceBuffPassive.new(100,3),
    ),
    unitSkill = ActCritical30UnitSkillStageGirl + CloudOnlyCondition,
)