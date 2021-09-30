package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr10

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

val tr10VampireShiori = ActorLoadout(
    "TR10 Vampire Shiori",
    Dress(
        name = "TR10 Vampire Shiori",
        character = Character.Shiori,
        attribute = Attribute.Ice,
        damageType = DamageType.Normal,
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
            PassiveData(
                object : PassiveEffect {
                    override val name = "Boss"
                    override val category = PassiveEffectCategory.Passive

                    override fun activate(context: ActionContext, value: Int, turns: Int, condition: Condition) = context.run {
                        listOf(ApUpBuff, ConfusionBuff).forEach {
                            self.specificBuffResist[it] = 100
                        }
                        Attribute.values().forEach {
                            self.againstAttributeDamageDealtUp[it] = 50
                            self.againstAttributeDamageTakenDown[it] = 50
                        }
                        self.againstAttributeDamageDealtUp[Attribute.Wind] = 0
                        self.againstAttributeDamageTakenDown[Attribute.Wind] = 0
                        self.againstAttributeDamageDealtUp[Attribute.Dream] = 0
                        self.againstAttributeDamageTakenDown[Attribute.Dream] = 0
                    }
                }
            )
        ),
    ),
)

val tr10VampireShioriStrategy = FixedStrategy {
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
        else -> error("Not supported.")
    }
}