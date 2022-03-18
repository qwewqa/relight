package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr14

import xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon.MoonAruru
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalResistPassiveA
import xyz.qwewqa.relive.simulator.core.stage.passive.BossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr14EmperorAkira = ActorLoadout(
    "TR14 Emperor Akira",
    Dress(
        name = "Emperor Akira",
        character = Character.Akira,
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
            ActType.Act1("Violent Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Violent Dual Slash", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act3("Violent Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act5("Defense Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 4,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = DamageTakenDownBuff,
                        value = 30,
                        turns = 2,
                    )
                }
            },
            ActType.Act6("Blind Fire Flower", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 3,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 5000,
                        turns = 3,
                    )
                }
            },
            ActType.Act7("Inspiring Gust", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 30,
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
            },
            ActType.ClimaxAct("Galactic Kaiser-Walzer NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 3,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 5000,
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
            trEventBonusPassive(MoonAruru),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr14EmperorAkiraStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act2]
            +boss[ActType.Act7]
        }
        2 -> {
            +boss[ActType.Act5]
            +boss[ActType.Act2]
            +boss[ActType.Act3]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        4 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act2]
            +boss[ActType.Act4]
        }
        5 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act5]
            +boss[ActType.Act4]
        }
        6 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        else -> {
            error("Unsupported.")
        }
    }
}

val tr14EmperorAkiraDiff4 = ActorLoadout(
    "TR14 Emperor Akira Difficulty 4",
    Dress(
        name = "Emperor Akira",
        character = Character.Akira,
        attribute = Attribute.Space,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 200_000_000,
            actPower = 10000,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Violent Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Violent Dual Slash", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act3("Violent Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act5("Defense Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 4,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = DamageTakenDownBuff,
                        value = 30,
                        turns = 2,
                    )
                }
            },
            ActType.Act6("Blind Fire Flower", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 3,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 99999,
                        turns = 3,
                    )
                }
            },
            ActType.Act7("Inspiring Gust", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 30,
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
            },
            ActType.ClimaxAct("Galactic Kaiser-Walzer NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 99999,
                        hitCount = 4,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 3,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 99999,
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
            trEventBonusPassive(MoonAruru),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr14EmperorAkiraDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act2]
            +boss[ActType.Act7]
        }
        2 -> {
            +boss[ActType.Act5]
            +boss[ActType.Act2]
            +boss[ActType.Act3]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        4 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act2]
            +boss[ActType.Act4]
        }
        5 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act5]
            +boss[ActType.Act4]
        }
        6 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        else -> {
            error("Unsupported.")
        }
    }
}
