package xyz.qwewqa.relivesim.presets.stagegirl

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.effect.*
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.percent

val JusticeNana = stageGirlPrototype + {
    name = "Justice"
    character = Character.Nana
    attribute = Attribute.Space
    damageType = DamageType.Normal
    position = Position.Back
    stats {
        hp = 31701
        actPower = 3416
        normalDefense = 1577
        specialDefense = 1025
        agility = 2113
    }
    positionValue = 35050

    ActType.Act1("Brilliance Slash", 2) {
        targetFront().act {
            attack(112.percent, hitCount = 2)
        }
        targetSelf().act {
            addBrilliance(20)
        }
    }
    ActType.Act2("Sword of Justice", 2) {
        targetAoe().act {
            attack(64.percent, hitCount = 2)
        }
        targetAllyAoe().act {
            applyEffects(
                { ActTimedEffect(turns = 3, 20.percent) },
                { ApDownTimedEffect(turns = 2) },
            )
        }
    }
    ActType.Act3("Right Judgement", 2) {
        targetBack().act {
            attack(198.percent, hitCount = 3)
        }
        targetAllyAoe().act {
            dispelTimed(EffectClass.Negative)
            heal(30.percent)
        }
    }
    ActType.ClimaxAct("Absolute Justice", 2) {
        targetSelf().act {
            applyEffects(
                { ActTimedEffect(turns = 3, 20.percent) },
                { DexterityTimedEffect(turns = 3, 20.percent) },
                { CriticalTimedEffect(turns = 3, 20.percent) },
            )
        }
        targetAoe().act {
            attack(240.percent, hitCount = 4)
        }
    }

    +TeamTimedDexterityAutoEffect(turns = 3, 10.percent)
    +TeamTimedEffectiveDamageAutoEffect(turns = 3, 20.percent)
    // Brilliance Down

    unitSkill = TeamActCriticalAutoEffect(50.percent).attributeOnly(Attribute.Space)
}

val IzanagiNana = stageGirlPrototype + {
    name = "Izanagi"
    character = Character.Nana
    attribute = Attribute.Space
    damageType = DamageType.Normal
    position = Position.Back
    stats {
        hp = 15843
        actPower = 2704
        normalDefense = 885
        specialDefense = 418
        agility = 1796
    }
    positionValue = 35050

    ActType.Act1("Strong Slash", 2) {
        targetFront().act {
            attack(176.percent)
        }
    }
    ActType.Act2("Sacred Will", 2) {
        targetBack(3).act {
            attack(116.percent)
        }
        targetAllyAoe().act {
            applyEffect { NegativeEffectResistanceTimedEffect(turns = 3) }
        }
    }
    ActType.Act3("Cloud Piercing", 2) {
        targetHighestAct().act {
            attack(198.percent)
        }
        targetAllyAoe().act {
            applyEffect { PerfectAimTimedEffect(3) }
        }
    }
    ActType.ClimaxAct("Izanagi's Creation", 2) {
        targetAoe().act {
            attack(197.percent, hitCount = 3)
        }
        targetAllyAoe().act {
            applyEffect { DexterityTimedEffect(turns = 3, 50.percent) }
            applyEffect { CriticalTimedEffect(turns = 3, 50.percent) }
        }
        // TODO: Barriers
    }

    +FortitudeAutoEffect()
    +ClimaxPowerAutoEffect(10.percent)
    +TurnBrillianceAutoEffect(20)
    +TeamTimedApDownAutoEffect(1)

    unitSkill = TeamActCriticalAutoEffect(30.percent).damageTypeOnly(DamageType.Normal)
}
