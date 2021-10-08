package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr11

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr11CheerYachiyo = ActorLoadout(
    "TR11 Cheer Yachiyo",
    Dress(
        name = "Cheer Yachiyo",
        character = Character.Yachiyo,
        attribute = Attribute.Dream,
        damageType = DamageType.Special,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 4_500_000,
            actPower = 2100,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Slash", 2) {
                targetFront().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Violent Slash", 2) {
                targetFront().act {
                    attack(
                        modifier = 200,
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
                targetAoe().act{
                    attack(
                        modifier = 100,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act8("Deterrence Slash", 2) {
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
            ActType.Act9("Weakening Concerto", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.ClimaxAct("Beautiful Pose♪ NEO", 2) {
                targetAoe().act{
                    attack(
                        modifier = 200,
                        hitCount = 4,
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
            PassiveData(
                object : PassiveEffect {
                    override val name = "Boss"
                    override val category = PassiveEffectCategory.Passive

                    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
                    }
                }
            )
        ),
    ),
)

val tr11CheerYachiyoStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act5]
            +boss[ActType.Act9]
        }
        2 -> {
            +boss[ActType.Act4]
            +boss[ActType.Act6]
            +boss[ActType.Act8]
        }
        3 -> {
            +boss[ActType.Act9]
            +boss[ActType.Act6]
            +boss[ActType.ClimaxAct]
        }
        else -> error("Not supported.")
    }
}