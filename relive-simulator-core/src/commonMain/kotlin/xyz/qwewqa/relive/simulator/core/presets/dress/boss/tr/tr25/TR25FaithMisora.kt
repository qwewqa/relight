package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr25

import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.FinalLinesHikari
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.core.stage.passive.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val tr25FaithMisora = ActorLoadout(
    "TR25 Faith Misora",
    Dress(
        name = "Faith Misora",
        character = Character.Misora,
        attribute = Attribute.Snow,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 12_500_000,
            actPower = 2100,
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
                        effect = PerfectAimBuff,
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
            trEventBonusPassive(FinalLinesHikari),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr25FaithMisoraStrategy = FixedStrategy {
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

val tr25FaithMisoraDiff4 = ActorLoadout(
    "TR25 Faith Misora Difficulty 4",
    Dress(
        name = "Faith Misora",
        character = Character.Misora,
        attribute = Attribute.Snow,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 600_000_000,
            actPower = 10000,
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
                        effect = PerfectAimBuff,
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
                        modifier = 99999,
                        hitCount = 2,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 99999,
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
                        modifier = 99999,
                        hitCount = 4,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 99999,
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
            trEventBonusPassive(FinalLinesHikari),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr25FaithMisoraDiff4Strategy = FixedStrategy {
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
        4 -> {
            +boss[ActType.Act4]
            +boss[ActType.Act7]
            +boss[ActType.Act1]
        }
        5 -> {
            +boss[ActType.Act9]
            +boss[ActType.Act7]
            +boss[ActType.Act10]
        }
        6 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act7]
            +boss[ActType.Act8]
        }
        else -> {
            error("Unsupported.")
        }
    }
}
