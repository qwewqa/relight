package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr12

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

val tr12TowerHikari = ActorLoadout(
    "TR12 Tower Hikari",
    Dress(
        name = "Tower Hikari",
        character = Character.Hikari,
        attribute = Attribute.Moon,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 5_000_000,
            actPower = 2100,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Counter Solo", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
                // TODO targetSelf().act {
//                    applyBuff(
//                        effect = NormalReflectBuff,
//                        value = 30,
//                        turns = 2,
//                    )
//                }
            },
            ActType.Act2("Violent Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Dual Slash", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 80,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act4("Violent Dual Slash", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act5("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act6("Violent Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act7("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.Act8("Inspiring Gust", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = DexterityUpBuff,
                        value = 30,
                        turns = 3,
                    )
                    applyBuff(
                        effect = CriticalUpBuff,
                        value = 30,
                        turns = 3,
                    )
                }
            },
            ActType.Act9("Restraint Firedance", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = BurnBuff,
                        value = 7000,
                        turns = 3,
                    )
                    applyBuff(
                        effect = StunBuff,
                        turns = 2,
                    )
                }
            },
            ActType.Act10("Weakening Concerto", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.ClimaxAct("Tower's Conviction NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 2,
                    )
                }
                // TODO targetSelf().act {
//                    applyBuff(
//                        effect = NormalReflectBuff,
//                        value = 30,
//                        turns = 2,
//                    )
//                }
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
                        listOf(ApUpBuff, ConfusionBuff).forEach {
                            self.specificBuffResist[it] = 100
                        }
                        Attribute.values().forEach {
                            self.againstAttributeDamageDealtUp[it] = 50
                            self.againstAttributeDamageTakenDown[it] = 50
                        }
                        self.againstAttributeDamageDealtUp[Attribute.Cloud] = 0
                        self.againstAttributeDamageTakenDown[Attribute.Cloud] = 0
                        self.againstAttributeDamageDealtUp[Attribute.Dream] = 0
                        self.againstAttributeDamageTakenDown[Attribute.Dream] = 0
                    }
                }
            )
        ),
    ),
)

val tr12TowerHikariStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act10]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        2 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act6]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act6]
            +boss[ActType.Act9]
        }
        else -> {
            error("Unsupported.")
        }
    }
}