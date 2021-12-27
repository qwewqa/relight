package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr14

import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
import xyz.qwewqa.relive.simulator.core.presets.dress.middle.moon.MoonAruru
import xyz.qwewqa.relive.simulator.core.stage.HitMode
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

val tr14MusketeerMahiru = ActorLoadout(
    "TR14 Musketeer Mahiru",
    Dress(
        name = "Musketeer Mahiru",
        character = Character.Mahiru,
        attribute = Attribute.Dream,
        damageType = DamageType.Special,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 4_500_000,
            actPower = 2300,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Smash", 2) {
                targetFront().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Smash", 2) {
                targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Smash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Smash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Accuracy Smash", 2) {
                targetSelf().act{
                    applyBuff(
                        effect = PerfectAim,
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
            ActType.Act6("Counter Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act7("Softening Concerto", 2) {
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
            ActType.Act8("Heavy Pressure Concerto", 2){
                targetAoe().act{
                    attack(
                        modifier = 200,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Buttercup Carpet NEO", 2) {
                targetAoe().act{
                    attack(
                        modifier = 250,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = ApUpBuff,
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
            trEventBonusPassive(MoonAruru),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr14MusketeerMahiruStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act1]
            +boss[ActType.Act4]
        }
        2 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        4 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act5]
        }
        5 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act8]
        }
        6 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act5]
        }
        else -> error("Not supported.")
    }
}

val tr14MusketeerMahiruDiff4 = ActorLoadout(
    "TR14 Musketeer Mahiru Difficulty 4",
    Dress(
        name = "Musketeer Mahiru",
        character = Character.Mahiru,
        attribute = Attribute.Dream,
        damageType = DamageType.Special,
        position = Position.None,
        stats = defaultDressStats.copy(
            hp = 180_000_000,
            actPower = 10000,
            normalDefense = 650,
            specialDefense = 650,
            agility = 1,
        ),
        acts = actsOf(
            ActType.Act1("Smash", 2) {
                targetFront().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Smash", 2) {
                targetFront().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Smash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Smash", 2) {
                targetFront(3).act {
                    attack(
                        modifier = 100,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act5("Accuracy Smash", 2) {
                targetSelf().act{
                    applyBuff(
                        effect = PerfectAim,
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
            ActType.Act6("Counter Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 2,
                    )
                }
            },
            ActType.Act7("Softening Concerto", 2) {
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
            ActType.Act8("Heavy Pressure Concerto", 2){
                targetAoe().act{
                    attack(
                        modifier = 200,
                        hitCount = 3,
                    )
                    applyBuff(
                        effect = ApUpBuff,
                        turns = 2,
                    )
                }
            },
            ActType.ClimaxAct("Buttercup Carpet NEO", 2) {
                targetAoe().act{
                    attack(
                        modifier = 99999,
                        hitCount = 3,
                        mode = HitMode.FIXED,
                    )
                    applyBuff(
                        effect = ApUpBuff,
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
            trEventBonusPassive(MoonAruru),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr14MusketeerMahiruDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act1]
            +boss[ActType.Act4]
        }
        2 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act2]
            +boss[ActType.Act6]
        }
        4 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act5]
        }
        5 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act8]
        }
        6 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act5]
        }
        else -> error("Not supported.")
    }
}