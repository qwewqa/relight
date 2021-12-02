package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr12

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.JudgementShizuha
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
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

val tr12VampireShiori = ActorLoadout(
    "TR12 Vampire Shiori",
    Dress(
        name = "Vampire Shiori",
        character = Character.Shiori,
        attribute = Attribute.Moon,
        damageType = DamageType.Special,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 3_500_000,
            actPower = 2100,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Violent Slash", 2) {
                targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act3("Violent Triple Thrust", 2) {
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
                        hitCount = 3,
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
            ActType.Act6("Perfect Aim Concerto", 2) {
                targetSelf().act {
                    applyBuff(
                        PerfectAim,
                        turns = 1,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act7("Purifying Dance", 2) {
                targetSelf().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
                }
            },
            ActType.Act8("Ironclad Dance", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = NormalBarrierBuff,
                        value = 10000,
                        turns = 3,
                    )
                    applyBuff(
                        effect = SpecialBarrierBuff,
                        value = 10000,
                        turns = 3,
                    )
                }
            },
            ActType.Act9("Fierce Dance", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                }
            },
            ActType.ClimaxAct("Bloody Full Moon NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                }
            },
            ActType.ConfusionAct("Thrust", 2) {
                targetAllyRandom().act {
                    attack(
                        modifier = 105,
                        hitCount = 1,
                    )
                }
            },
        ),
        autoSkills = listOf(
            trEventBonusPassive(JudgementShizuha),
            AbnormalResistPassiveA.new(100),
            BossElementResistPassive.new(50),
        ),
    ),
)

val tr12VampireShioriStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act1]
            +boss[ActType.Act2]
        }
        2 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act1]
            +boss[ActType.Act3]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act6]
            +boss[ActType.Act4]
        }
        else -> {
            error("Unsupported.")
        }
    }
}
