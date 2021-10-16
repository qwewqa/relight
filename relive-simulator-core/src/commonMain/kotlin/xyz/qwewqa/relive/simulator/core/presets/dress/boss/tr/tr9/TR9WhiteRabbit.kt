package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr9

import xyz.qwewqa.relive.simulator.core.presets.dress.back.snow.DeathTamao
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
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

val tr9WhiteRabbitMisora = ActorLoadout(
    "TR9 White Rabbit Misora",
    Dress(
        name = "White Rabbit Misora",
        character = Character.Misora,
        attribute = Attribute.Dream,
        damageType = DamageType.Special,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 5_000_000,
            actPower = 1900,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Strong Thrust", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Dual Thrust", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act3("Triple Thrust", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Thrust", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 120,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act6("Weakening Concerto", 2) {
                targetAoe().run {
                    applyBuff(
                        ActPowerDownBuff,
                        value = 50,
                        turns = 3,
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
            ActType.Act8("Perfect Aim Thrust", 2) {
                TODO()
            },
            ActType.ClimaxAct("I'm Late! NEO", 2) {
                TODO()
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
            trEventBonusPassive(DeathTamao),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr9WhiteRabbitMisoraStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act1]
            +boss[ActType.Act3]
        }
        2 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act4]
            +boss[ActType.Act5]
        }
    }
}
