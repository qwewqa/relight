package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr13

import xyz.qwewqa.relive.simulator.core.presets.dress.middle.snow.HopeLalafin
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

val tr13SetsunaIchieDiff4 = ActorLoadout(
    "TR13 Setsuna Ichie Difficulty 4",
    Dress(
        name = "Setsuna Ichie",
        character = Character.Ichie,
        attribute = Attribute.Dream,
        damageType = DamageType.Normal,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 120_000_000,
            actPower = 2300,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Strong Flash", 2) {
                targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Violent Twin Flash", 2) {
                targetFront(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act3("Triple Flash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Violent Triple Flash", 2) {
                targetFront(3).act {
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
            ActType.Act6("Weakening Concerto", 2) {
                targetAoe().act{
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act7("Purifying Dance", 2) {
                targetSelf().act{
                    dispelTimed(BuffCategory.Negative)
                }
                targetAoe().act{
                    dispelTimed(BuffCategory.Positive)
                }
            },
            ActType.Act8("Noxious Flower Dance", 2){
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = PoisonBuff,
                        value = 99999,
                        turns = 3,
                    )
                }
            },
            ActType.ClimaxAct("Flower Festival Type 3 NEO", 2) {
                targetAoe().act{
                    attack(
                        modifier = 8000,
                        hitCount = 4,
                    )
                    applyBuff(
                        effect = PoisonBuff,
                        value = 99999,
                        turns = 3,
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
            trEventBonusPassive(HopeLalafin),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr13SetsunaIchieDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act1]
            +boss[ActType.Act3]
        }
        2 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act3]
            +boss[ActType.Act5]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act6]
            +boss[ActType.Act3]
        }
        else -> error("Not supported.")
    }
}