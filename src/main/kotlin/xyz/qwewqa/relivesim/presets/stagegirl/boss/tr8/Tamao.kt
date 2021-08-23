package xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8

import xyz.qwewqa.relivesim.dsl.fixedStrategy
import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.effect.*
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.effect.TimedEffect
import xyz.qwewqa.relivesim.stage.percent

val TR8EvilBanishingKomachiTamao = stageGirlPrototype + {
    name = "Evil Banishing Komachi (TR8)"
    attribute = Attribute.Dream
    character = Character.Tamao
    damageType = DamageType.Special
    stats {
        hp = 4_500_000
        actPower = 1900
        normalDefense = 650
        specialDefense = 650
        agility = 1  // who knows
    }

    ActType.Act1("Slash", 2) {
        targetBack().act {
            attack(100.percent)
        }
    }
    ActType.Act2("Strong Slash", 2) {
        targetBack().act {
            attack(150.percent, hitCount = 2)
        }
    }
    ActType.Act3("Triple Slash", 2) {
        targetBack(3).act {
            attack(70.percent, hitCount = 3)
        }
    }
    ActType.Act4("Strong Triple Slash", 2) {
        targetBack(3).act {
            attack(100.percent, hitCount = 3)
        }
    }
    ActType.Act5("Counter Concerto", 2) {
        targetAoe().act {
            attack(120.percent, hitCount = 2)
        }
    }
    ActType.Act6("Pursuit Concerto", 2) {
        targetAoe().act {
            attack(150.percent, hitCount = 4)
        }
    }
    ActType.Act7("Helpless Concerto", 2) {
        targetAoe().act {
            applyEffect { DexterityTimedEffect(turns = 3, -50.percent) }
            applyEffect { CriticalTimedEffect(turns = 3, -50.percent) }
        }
    }
    ActType.Act8("Evasion Dance", 2) {
        targetSelf().act {
            applyEffect { EvasionTimedEffect(turns = 2, 50.percent) }
        }
    }
    ActType.Act9("Perfect Aim Flurry", 2) {
        targetSelf().act {
            applyEffect { ActTimedEffect(turns = 3, 50.percent) }
            applyEffect { PerfectAimTimedEffect(turns = 1) }
        }
        targetAoe().act {
            attack(150.percent, hitCount = 4)
        }
    }
    ActType.ClimaxAct("Cherry Blossom Quick-Draw NEO", 2) {
        targetSelf().act {
            applyEffect { ActTimedEffect(turns = 3, 50.percent) }
            applyEffect { PerfectAimTimedEffect(turns = 1) }
        }
        targetAoe().act {
            attack(200.percent, hitCount = 4)
        }
    }
}

val TR8EvilBanishingKomachiTamaoStrategy = fixedStrategy {
    val boss = this.team.stageGirls.values.first()

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
            +boss[ActType.Act6]
            +boss[ActType.ClimaxAct]
        }
        4 -> {
            TODO()
        }
    }
}
