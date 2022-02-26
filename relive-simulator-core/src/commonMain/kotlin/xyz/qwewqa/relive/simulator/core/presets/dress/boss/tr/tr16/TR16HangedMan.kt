package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr16

import xyz.qwewqa.relive.simulator.core.presets.dress.back.space.HuntingRevueNana
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
import xyz.qwewqa.relive.simulator.core.stage.passive.BuggedHMRuiBossElementResistPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr16HangedManRui = ActorLoadout(
    "TR16 Hanged Man Rui",
    Dress(
        name = "Hanged Man Rui",
        character = Character.Rui,
        attribute = Attribute.Cloud,
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
                        modifier = 100,
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
            ActType.Act5("Pursuit Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.Act6("Dimming Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = BrillianceGainDownBuff,
                        value = 80,
                        turns = 2,
                    )
                }
            },
            ActType.Act7("Inspiring Gust", 2) {
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
            ActType.Act8("Sleeping Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 75,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Upside Down World NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 75,
                        turns = 2,
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
            trEventBonusPassive(HuntingRevueNana),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr16HangedManRuiStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        2 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act6]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act3]
        }
        4 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act7]
            +boss[ActType.Act5]
        }
        5 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act7]
            +boss[ActType.Act4]
        }
        6 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act3]
            +boss[ActType.Act5]
        }
        else -> {
            error("Unsupported.")
        }
    }
}

val tr16BuggedHangedManRui = ActorLoadout(
    "TR16 Bugged Hanged Man Rui",
    Dress(
        name = "Hanged Man Rui",
        character = Character.Rui,
        attribute = Attribute.Cloud,
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
                        modifier = 100,
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
            ActType.Act5("Pursuit Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.Act6("Dimming Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = BrillianceGainDownBuff,
                        value = 80,
                        turns = 2,
                    )
                }
            },
            ActType.Act7("Inspiring Gust", 2) {
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
            ActType.Act8("Sleeping Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 75,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Upside Down World NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 75,
                        turns = 2,
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
            trEventBonusPassive(HuntingRevueNana),
            AbnormalResistPassiveA.new(100),
            BuggedHMRuiBossElementResistPassive.new(50),
        ),
    ),
)

val tr16BuggedHangedManRuiStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        2 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act6]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act3]
        }
        4 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act7]
            +boss[ActType.Act5]
        }
        5 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act7]
            +boss[ActType.Act4]
        }
        6 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act3]
            +boss[ActType.Act5]
        }
        else -> {
            error("Unsupported.")
        }
    }
}

val tr16HangedManRuiDiff4 = ActorLoadout(
    "TR16 Hanged Man Rui Difficulty 4",
    Dress(
        name = "Hanged Man Rui",
        character = Character.Rui,
        attribute = Attribute.Cloud,
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
                        modifier = 100,
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
            ActType.Act5("Pursuit Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.Act6("Dimming Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = BrillianceGainDownBuff,
                        value = 80,
                        turns = 2,
                    )
                }
            },
            ActType.Act7("Inspiring Gust", 2) {
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
            ActType.Act8("Sleeping Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 75,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Upside Down World NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 99999,
                        hitCount = 4,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = SleepBuff,
                        chance = 75,
                        turns = 2,
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
            trEventBonusPassive(HuntingRevueNana),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr16HangedManRuiDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        2 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act6]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act3]
        }
        4 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act7]
            +boss[ActType.Act5]
        }
        5 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act7]
            +boss[ActType.Act4]
        }
        6 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act3]
            +boss[ActType.Act5]
        }
        else -> {
            error("Unsupported.")
        }
    }
}