package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr27

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive2023
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow.CapricornClaudine
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr27MafiaNana = ActorLoadout(
    "TR27 Mafia Nana",
    Dress(
        name = "Mafia Nana",
        character = Character.Nana,
        attribute = Attribute.Dream,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 7_500_000,
            actPower = 2300,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Strike", 2) {
                targetBack().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Counter Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act6("Pursuit Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 4,
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
                        effect = NormalDefenseUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = SpecialDefenseUpBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Purifying Dance", 2) {
                targetSelf().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            },
            ActType.Act9("Constraint Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = StunBuff,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Stay Away! NEO", 2) {
                targetAoe().act{
                    attack(
                        modifier = 200,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = StunBuff,
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
            trEventBonusPassive2023(CapricornClaudine),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr27MafiaNanaStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act4]
            +boss[ActType.Act7]
        }
        2 -> {
            +boss[ActType.Act3]
            +boss[ActType.Act3]
            +boss[ActType.Act7]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        4 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act5]
        }
        5 -> {
            +boss[ActType.Act9]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        6 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act5]
            +boss[ActType.Act6]
        }
        else -> error("Not supported.")
    }
}

val tr27MafiaNanaDiff4 = ActorLoadout(
    "TR27 Mafia Nana Difficulty 4",
    Dress(
        name = "Mafia Nana",
        character = Character.Nana,
        attribute = Attribute.Dream,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 1_080_000_000,
            actPower = 10000,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Strike", 2) {
                targetBack().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Counter Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act6("Pursuit Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 4,
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
                        effect = NormalDefenseUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = SpecialDefenseUpBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Purifying Dance", 2) {
                targetSelf().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            },
            ActType.Act9("Constraint Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 99999,
                        hitCount = 3,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = StunBuff,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Stay Away! NEO", 2) {
                targetAoe().act{
                    attack(
                        modifier = 99999,
                        hitCount = 3,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = StunBuff,
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
            trEventBonusPassive2023(CapricornClaudine),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr27MafiaNanaDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act4]
            +boss[ActType.Act7]
        }
        2 -> {
            +boss[ActType.Act3]
            +boss[ActType.Act3]
            +boss[ActType.Act7]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        4 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act5]
        }
        5 -> {
            +boss[ActType.Act9]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        6 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act5]
            +boss[ActType.Act6]
        }
        else -> {
            error("Unsupported.")
        }
    }
}
