package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr9

import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position
import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.actor.*
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.loadout.Dress
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy

val tr9QueenOfHeartsShizuha = ActorLoadout(
    "TR9 Queen of Hearts Shizuha",
    Dress(
        name = "Queen of Hearts Shizuha",
        character = Character.Shizuha,
        attribute = Attribute.Dream,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 4_500_000,
            actPower = 1900,
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
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Slash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Violent Triple Slash", 2) {
                targetFront(3).act {
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
                        hitCount = 2,
                    )
                }
            },
            ActType.Act6("Pursuit Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 24,
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
            ActType.Act8("Softening Concerto", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = NormalDefenseDownBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = SpecialDefenseDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act9("Befuddling Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 2,
                        chance = 80,
                    )
                }
            },
            ActType.ClimaxAct("Off with her head! NEO", 2) {
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = ConfusionBuff,
                        turns = 2,
                        chance = 80,
                    )
                }
            },
            ActType.ConfusionAct("Smash", 2) {
                targetAllyRandom().act {
                    attack(
                        modifier = 105,
                        hitCount = 1,
                    )
                }
            },
        ),
        autoSkills = listOf(
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr9QueenOfHeartsShizuhaStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act1]
            +boss[ActType.Act3]
        }
        2 -> {
            +boss[ActType.Act4]
            +boss[ActType.Act3]
            +boss[ActType.Act8]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
    }
}
