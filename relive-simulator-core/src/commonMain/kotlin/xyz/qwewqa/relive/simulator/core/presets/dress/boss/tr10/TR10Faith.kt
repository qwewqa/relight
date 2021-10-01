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

val tr10FaithMisora = ActorLoadout(
    "TR10 Faith Misora",
    Dress(
        name = "Faith Misora",
        character = Character.Misora,
        attribute = Attribute.Ice,
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
            ActType.Act1("Violent Thrust", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Violent Dual Thrust", 2) {
                targetBack(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
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
                        hitCount = 4,
                    )
                }
            },
            ActType.Act5("Evasion Strike", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
                targetSelf().act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = 50,
                        turns = 2,
                    )
                }
            },
            ActType.Act6("Inspiring Gust", 2) {
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
            ActType.Act7("Weakening Concerto", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Freezing Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = FreezeBuff,
                        turns = 1,
                        chance = 100,
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
                        effect = FreezeBuff,
                        turns = 1,
                        chance = 100,
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

val tr10FaithMisoraStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act1]
            +boss[ActType.Act2]
        }
        2 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act3]
            +boss[ActType.Act5]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act7]
            +boss[ActType.Act3]
        }
    }
}