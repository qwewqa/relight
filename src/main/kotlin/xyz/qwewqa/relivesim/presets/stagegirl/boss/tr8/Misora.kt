package xyz.qwewqa.relivesim.presets.stagegirl.boss.tr8

import xyz.qwewqa.relivesim.dsl.fixedStrategy
import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.effect.*
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.effect.autoEffect
import xyz.qwewqa.relivesim.stage.percent

val TR8FaithMisora = stageGirlPrototype + {
    name = "Faith (TR8)"
    attribute = Attribute.Wind
    character = Character.Misora
    damageType = DamageType.Normal
    stats {
        hp = 5_000_000
        actPower = 1900
        normalDefense = 650
        specialDefense = 650
        agility = 1  // who knows
    }

    +autoEffect("Boss Special", EffectClass.Positive) {
        self.againstAttributeDamageDealtUp[Attribute.Wind] = 50.percent
        self.againstAttributeDamageDealtUp[Attribute.Ice] = 50.percent
        self.againstAttributeDamageDealtUp[Attribute.Cloud] = 50.percent
        self.againstAttributeDamageDealtUp[Attribute.Moon] = 50.percent
        self.againstAttributeDamageDealtUp[Attribute.Space] = 50.percent
        self.againstAttributeDamageTakenDown[Attribute.Wind] = 50.percent
        self.againstAttributeDamageTakenDown[Attribute.Ice] = 50.percent
        self.againstAttributeDamageTakenDown[Attribute.Cloud] = 50.percent
        self.againstAttributeDamageTakenDown[Attribute.Moon] = 50.percent
        self.againstAttributeDamageDealtUp[Attribute.Space] = 50.percent
    }

    ActType.Act1("Violent Thrust", 2) {
        targetFront().act {
            attack(150.percent)
        }
    }
    ActType.Act2("Violent Dual Thrust", 2) {
        targetFront(2).act {
            attack(120.percent, hitCount = 2)
        }
    }
    ActType.Act3("Violent Triple Thrust", 2) {
        targetFront(3).act {
            attack(100.percent, hitCount = 3)
        }
    }
    ActType.Act4("Counter Concerto", 2) {
        targetAoe().act {
            attack(120.percent, hitCount = 2)
        }
    }
    ActType.Act5("Inspiring Gust", 2) {
        targetSelf().act {
            applyEffect { ActTimedEffect(turns = 3, 50.percent) }
            applyEffect { DexterityTimedEffect(turns = 3, 50.percent) }
            applyEffect { CriticalTimedEffect(turns = 3, 50.percent) }
        }
    }
    ActType.Act6("Flip Fiery Concerto", 2) {
        targetAoe().act {
            attack(150.percent, hitCount = 3)
            flipTimed(EffectClass.Positive, 5)
        }
    }
    ActType.Act7("Restraint Concerto", 2) {
        targetAoe().act {
            attack(150.percent, hitCount = 4)
            applyEffect { StopTimedEffect(turns = 1) }
        }
    }
    ActType.ClimaxAct("Moonlight Sacrament NEO", 2) {
        targetAoe().act {
            attack(200.percent, hitCount = 4)
            applyEffect { StopTimedEffect(turns = 1) }
        }
    }
}

val TR8FaithMisoraStrategy = fixedStrategy {
    val boss = this.team.stageGirls.values.first()

    when (turn) {
        1 -> {
            +boss[ActType.Act1]
            +boss[ActType.Act2]
            +boss[ActType.Act5]
        }
        2 -> {
            +boss[ActType.Act6]
            +boss[ActType.Act2]
            +boss[ActType.Act3]
        }
        3 -> {
            +boss[ActType.ClimaxAct]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
        4 -> {
            +boss[ActType.Act5]
            +boss[ActType.Act2]
            +boss[ActType.Act4]
        }
        5 -> {
            +boss[ActType.Act7]
            +boss[ActType.Act6]
            +boss[ActType.Act4]
        }
        6 -> {
            +boss[ActType.Act5]
            +boss[ActType.Act3]
            +boss[ActType.Act4]
        }
    }
}
