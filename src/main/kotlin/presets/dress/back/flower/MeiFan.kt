package xyz.qwewqa.relive.simulator.presets.dress.back.flower

import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relive.simulator.presets.condition.FlowerOnlyCondition
import xyz.qwewqa.relive.simulator.presets.condition.IceOnlyCondition
import xyz.qwewqa.relive.simulator.presets.condition.SpecialDamageOnlyCondition
import xyz.qwewqa.relive.simulator.presets.condition.characterCondition
import xyz.qwewqa.relive.simulator.stage.actor.ActType
import xyz.qwewqa.relive.simulator.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.stage.autoskill.new
import xyz.qwewqa.relive.simulator.stage.buff.*
import xyz.qwewqa.relive.simulator.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.stage.passive.*

val StageGirlMeiFan = Dress(
    name = "Stage Girl MeiFan",
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
            targetBack().act {
                attack(
                    modifier = 176,
                    hitCount = 2,
                )
            }
        },
        ActType.Act2("Flash of Determination", 2) {
            targetSelf().act {
                applyBuff(
                    EffectiveDamageDealtBuff,
                    value = 30,
                    turns = 3,
                )
                applyBuff(
                    DexterityUpBuff,
                    value = 20,
                    turns = 3,
                )
            }
            targetHighest { it.actPower }.act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
        },
        ActType.Act3("Unwavering Passion", 2) {
            targetHighest { it.actPower }.act {
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
        GenericBuffPassive(ActPowerUpBuff, ActionTarget.Team).new(20, turns = 3),
        ResistanceBuffPassive(BuffResistanceBuff(ConfusionBuff), ActionTarget.Team).new(100, turns = 6),
        ResistanceBuffPassive(BuffResistanceBuff(StopBuff), ActionTarget.Team).new(100, turns = 6),
    ),
    unitSkill = listOf(
        TeamActPassive.new(50) + FlowerOnlyCondition,
        TeamCriticalPassive.new(50) + FlowerOnlyCondition,
    )
)
