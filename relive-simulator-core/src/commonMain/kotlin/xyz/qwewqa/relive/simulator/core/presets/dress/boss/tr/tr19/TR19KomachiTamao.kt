package xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.tr19

import xyz.qwewqa.relive.simulator.core.presets.dress.back.wind.SoulRevueClaudine
import xyz.qwewqa.relive.simulator.core.presets.dress.boss.tr.trEventBonusPassive
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

val tr19KomachiTamao = ActorLoadout(
    "TR19 Komachi Tamao",
    Dress(
        name = "Komachi Tamao",
        character = Character.Tamao,
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
            ActType.Act1("Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Slash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Slash", 2) {
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
                        hitCount = 2,
                    )
                }
            },
            ActType.Act6("Pursuit Concerto", 2) {
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.Act7("Helpless Concerto", 2) {
                targetAoe().act {
                    applyBuff(
                        effect = DexterityDownBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = CriticalDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Evasion Dance", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = 50,
                        turns = 2,
                    )
                }
            },
            ActType.Act9("Perfect Aim Flurry", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.ClimaxAct("Cherry Blossom Quick-Draw NEO", 2) {
                targetSelf().act {
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1,
                    )
                }
                targetAoe().act {
                    attack(
                        modifier = 200,
                        hitCount = 4,
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
            trEventBonusPassive(SoulRevueClaudine),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr19KomachiTamaoStrategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act1]
            +boss[ActType.Act3]
        }
        2 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act4]
            +boss[ActType.Act5]
        }
        3 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act5]
            +boss[ActType.ClimaxAct]
        }
        else -> {
            error("Unsupported.")
        }
    }
}

val tr19KomachiTamaoDiff4 = ActorLoadout(
    "TR19 Komachi Tamao Difficulty 4",
    Dress(
        name = "Komachi Tamao",
        character = Character.Tamao,
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
            ActType.Act1("Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 100,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act2("Strong Slash", 2) {
                targetBack().act {
                    attack(
                        modifier = 150,
                        hitCount = 1,
                    )
                }
            },
            ActType.Act3("Triple Flash", 2) {
                targetBack(3).act {
                    attack(
                        modifier = 70,
                        hitCount = 3,
                    )
                }
            },
            ActType.Act4("Strong Triple Flash", 2) {
                targetBack(3).act {
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
            ActType.Act6("Pursuit Concerto", 2) {
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.Act7("Helpless Concerto", 2) {
                targetAoe().act{
                    applyBuff(
                        effect = DexterityDownBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = CriticalDownBuff,
                        value = 50,
                        turns = 3,
                    )
                }
            },
            ActType.Act8("Evasion Dance", 2){
                targetSelf().act {
                    applyBuff(
                        effect = EvasionRateUpBuff,
                        value = 50,
                        turns = 2,
                    )
                }
            },
            ActType.Act9("Perfect Aim Flurry", 2){
                targetSelf().act{
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = 150,
                        hitCount = 4,
                    )
                }
            },
            ActType.ClimaxAct("Cherry Blossom Quick-Draw NEO", 2) {
                targetSelf().act{
                    applyBuff(
                        effect = ActPowerUpBuff,
                        value = 50,
                        turns = 3,
                    )
                    applyBuff(
                        effect = PerfectAimBuff,
                        turns = 1
                    )
                }
                targetAoe().act{
                    attack(
                        modifier = 99999,
                        hitCount = 4,
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
            trEventBonusPassive(SoulRevueClaudine),
            AbnormalGuardPassive.new(),
        ),
    ),
)

val tr19KomachiTamaoDiff4Strategy = FixedStrategy {
    val boss = this.team.actors.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act1]
            +boss[ActType.Act3]
        }
        2 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act4]
            +boss[ActType.Act5]
        }
        3 -> {
            +boss[ActType.Act8]
            +boss[ActType.Act5]
            +boss[ActType.ClimaxAct]
        }
        4 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act2]
            +boss[ActType.Act5]
        }
        5 ->{
            +boss[ActType.Act8]
            +boss[ActType.Act4]
            +boss[ActType.Act6]
        }
        6 ->{
            +boss[ActType.Act7]
            +boss[ActType.Act9]
            +boss[ActType.Act6]
        }
        else -> error("Not supported.")
    }
}
