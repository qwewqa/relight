package xyz.qwewqa.relive.simulator.core.presets.dress.back.wind

import xyz.qwewqa.relive.simulator.core.presets.condition.WindOnlyCondition
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.*
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position


val FoolYachiyo = Dress(
    name = "Fool Yachiyo",
    character = Character.Yachiyo,
    attribute = Attribute.Wind,
    damageType = DamageType.Normal,
    position = Position.Back,
    stats = defaultDressStats.copy(
        hp = 32122,
        actPower = 3416,
        normalDefense = 1454,
        specialDefense = 1025,
        agility = 2328,
    ),
    acts = actsOf(
        ActType.Act1("Gust of Brilliance", 2) {
            targetAllyAoe().act {
                addBrilliance(20)
            }
        },
        ActType.Act2("Free Heart", 2) {
            targetBack().act {
                attack(
                    modifier = 155,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    ApDownBuff,
                    turns = 2,
                )
                applyBuff(
                    NegativeEffectResistanceBuff,
                    value = 100,
                    turns = 3,
                )
            }
        },
        ActType.Act3("Eternal Brilliance", 2) {
            targetBack().act {
                attack(
                    modifier = 198,
                    hitCount = 2,
                )
            }
            targetAllyAoe().act {
                applyBuff(
                    ActPowerUpBuff,
                    value = 30,
                    turns = 3
                )
                applyBuff(
                    DexterityUpBuff,
                    value = 30,
                    turns = 3
                )
            }
        },
        ActType.ClimaxAct("Possibility∞Infinity", 2) {
            focus {
                targetAoe().act {
                    attack(
                        modifier = 240,
                        hitCount = 4,
                    )
                }
                targetBack().act {
                    applyCountableBuff(
                        CountableBuff.Daze,
                    )
                }
            }
        }
    ),
    autoSkills = listOf(
        TeamHpUpPassive.new(30),
        ApplyReviveBuffPassive.new(50),
        EnemyBack1DazeBuffPassive.new(1),
    ),
    unitSkill = ActCritical50UnitSkill + WindOnlyCondition,
)
