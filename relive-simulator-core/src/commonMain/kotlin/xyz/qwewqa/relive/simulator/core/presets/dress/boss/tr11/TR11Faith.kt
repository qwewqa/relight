package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr11

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr11FaithMisora = ActorLoadout(
    "TR11 Faith Misora",
    Dress(
        name = "Faith Misora",
        character = Character.Misora,
        attribute = Attribute.Space,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 5_000_000,
            actPower = 2300,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Weakening Concerto", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act2("Slash", 2) {
                targetFront().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Dual Slash", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 100,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act4("Violent Dual Slash", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act5("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 80,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act6("Violent Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act7("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 100,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act8("Perfect Aim Concerto", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAim,
                        turns = 1,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act9("Blind Burning Flower", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = 3,
                    )
                }
            },
            ActType.Act10("Inspiring Gust", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 50,
                        turns = 3,
                    )
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
                }
            },
            ActType.ClimaxAct("Moonlight Sacrament NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                    applyBuff(
                        effect = BlindnessBuff,
                        turns = 3,
                    )
                }
            },
            ActType.ConfusionAct("Slash", 2) {
                targetAllyRandom().act {
                    attack(
                        modifier = 105,
                        hitCount = 1,
                    )
                }
            },
        ),
        autoSkills = listOf(
            AbnormalResistPassive.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr11FaithMisoraStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act2]
            +boss[ActType.Act3]
            +boss[ActType.Act10]
        }
        2 -> {
            +boss[ActType.Act3]
            +boss[ActType.Act6]
            +boss[ActType.Act1]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act10]
            +boss[ActType.Act8]
        }
        else -> {
            error("Unsupported.")
        }
    }
}