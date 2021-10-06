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

val tr12Boss2Seisho = ActorLoadout(
    "TR12 Boss 2 Seisho",
    Dress(
        name = "Boss 2 Seisho",
        character = Character.Nana,
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
            ActType.Act1("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 2,
                    )
                }
            },
            ActType.Act2("Strike", 2) {
                targetFront().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Strong Slash", 2) {
                targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act4("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Strong Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act6("Counter Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act7("Ironclad Dance", 2) {
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
            ActType.Act8("Perfect Aim Concerto", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAim,
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
            ActType.Act9("Purifying Dance", 2) {
                targetSelf().act {
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act {
                    dispelTimed(BuffCategory.Positive)
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
            ActType.ClimaxAct("Dreaming Bell NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 2,
                    )
                }
            },
            ActType.ConfusionAct("Strike", 2) {
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

val tr12Boss2SeishoStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        2 -> {
            +boss[ActType.Act10]
            +boss[ActType.Act3]
            +boss[ActType.Act5]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act8]
            +boss[ActType.Act6]
        }
        else -> {
            error("Unsupported.")
        }
    }
}