package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr26

import xyz.qwewqa.relive.simulator.core.presets.dress.back.cloud.SagittariusJunna
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassiveV2
import xyz.qwewqa.relive.simulator.core.stage.HitMode
import xyz.qwewqa.relive.simulator.core.stage.actor.ActType
import xyz.qwewqa.relive.simulator.core.stage.actor.Attribute
import xyz.qwewqa.relive.simulator.core.stage.actor.actsOf
import xyz.qwewqa.relive.simulator.core.stage.actor.defaultDressStats
import xyz.qwewqa.relive.simulator.core.stage.autoskill.new
import xyz.qwewqa.relive.simulator.core.stage.buff.ActPowerDownBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.PerfectAimBuff
import xyz.qwewqa.relive.simulator.core.stage.dress.Dress
import xyz.qwewqa.relive.simulator.core.stage.loadout.ActorLoadout
import xyz.qwewqa.relive.simulator.core.stage.passive.AbnormalGuardPassive
import xyz.qwewqa.relive.simulator.core.stage.strategy.FixedStrategy
import xyz.qwewqa.relive.simulator.stage.character.Character
import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.character.Position

val tr26MusketeerKaren = ActorLoadout(
    "TR26 Musketeer Karen",
    Dress(
        name = "Musketeer Karen",
        character = Character.Karen,
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
            ActType.Act3("Violent Dual Slash", 2) {
                targetFront(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act4("Triple Slash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Tri-Slash", 2) {
                targetFront(3).act{
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act6("Counter Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act7("Weakening Concerto", 3) {
                targetAoe().act{
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Accuracy Concerto", 3){
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
            },
            ActType.ClimaxAct("Dance of Hope NEO", 3) {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = 200,
                        hitCount = 3,
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
            trEventBonusPassive(SagittariusJunna),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr26MusketeerKarenVer2023 = tr26MusketeerKaren.copy(
    name = "TR26 Musketeer Karen 2023",
    dress = tr26MusketeerKaren.dress.copy(
        autoSkills = listOf(
            trEventBonusPassiveV2(SagittariusJunna),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr26MusketeerKarenStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act4]
        }
        2 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act5]
            +boss[ActType.Act6]
        }
        3 -> {
            +boss[ActType.Act7]
            +boss[ActType.ClimaxAct]
        }
        4 ->{
            +boss[ActType.Act2]
            +boss[ActType.Act3]
            +boss[ActType.Act6]
        }
        5 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act8]
        }
        6 ->{
            +boss[ActType.Act3]
            +boss[ActType.Act5]
            +boss[ActType.Act6]
        }
        else -> error("Not supported.")
    }
}

val tr26MusketeerKarenDiff4 = ActorLoadout(
    "TR26 Musketeer Karen Difficulty 4",
    Dress(
        name = "Musketeer Karen",
        character = Character.Karen,
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
            ActType.Act3("Violent Dual Slash", 2) {
                targetFront(2).act {
                    attack(
                        modifier = 120,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act4("Triple Slash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Tri-Slash", 2) {
                targetFront(3).act{
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act6("Counter Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act7("Weakening Concerto", 3) {
                targetAoe().act{
                    applyBuff(
                        effect = ActPowerDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Accuracy Concerto", 3){
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 3,
                    )
                }
            },
            ActType.ClimaxAct("Dance of Hope NEO", 3) {
                targetSelf().act {
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = 99999,
                        hitCount = 3,
                        mode = HitMode.FIXED,
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
            trEventBonusPassive(SagittariusJunna),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr26MusketeerKarenDiff4Ver2023 = tr26MusketeerKarenDiff4.copy(
    name = "TR26 Musketeer Karen Difficulty 4 2023",
    dress = tr26MusketeerKarenDiff4.dress.copy(
        autoSkills = listOf(
            trEventBonusPassiveV2(SagittariusJunna),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr26MusketeerKarenDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act4]
        }
        2 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act5]
            +boss[ActType.Act6]
        }
        3 -> {
            +boss[ActType.Act7]
            +boss[ActType.ClimaxAct]
        }
        4 ->{
            +boss[ActType.Act2]
            +boss[ActType.Act3]
            +boss[ActType.Act6]
        }
        5 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act8]
        }
        6 ->{
            +boss[ActType.Act3]
            +boss[ActType.Act5]
            +boss[ActType.Act6]
        }
        else -> error("Not supported.")
    }
}
