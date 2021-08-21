package xyz.qwewqa.relivesim.presets.stagegirl.midrow.flower

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.TeamActCriticalAutoEffect
import xyz.qwewqa.relivesim.presets.TeamTimedCriticalAutoEffect
import xyz.qwewqa.relivesim.presets.TeamTimedDexterityAutoEffect
import xyz.qwewqa.relivesim.presets.attributeOnly
import xyz.qwewqa.relivesim.presets.effect.ActTimedEffect
import xyz.qwewqa.relivesim.presets.effect.DexterityTimedEffect
import xyz.qwewqa.relivesim.presets.effect.EffectiveDamageTimedEffect
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.percent

val DevilKaoruko = stageGirlPrototype + {
    name = "Devil"
    character = Character.Kaoruko
    attribute = Attribute.Flower
    damageType = DamageType.Normal
    position = Position.Back
    stats {
        hp = 38597
        actPower = 3020
        normalDefense = 1213
        specialDefense = 1827
        agility = 2113
    }
    positionValue = 25050

    ActType.Act1("Brilliance Slash", 2) {
        targetFront().act {
            attack(112.percent, hitCount = 2)
        }
        targetSelf().act {
            addBrilliance(20)
        }
    }
    ActType.Act2("Soul Contract", 2) {
        targetBack().act {
            attack(155.percent, hitCount = 2)
        }
        targetAllyAoe().act {
            applyEffects(
                { ActTimedEffect(turns = 3, 30.percent) },
                { EffectiveDamageTimedEffect(turns = 3, 30.percent) },
            )
        }
    }
    ActType.Act3("Devil's Whisper", 3) {
        targetBack().act {
            attack(198.percent, hitCount = 2)
        }
        targetAoe().act {
            dispelTimed(EffectClass.Positive)
            dispelCountable(EffectClass.Positive)
        }
    }
    ActType.ClimaxAct("Flames of Hell", 2) {
        targetAllyAoe().act {
            dispelTimed(EffectClass.Negative)
        }
        targetAoe().act {
            attack(240.percent, hitCount = 4)
            dispelTimed(EffectClass.Positive)
        }
    }

    +TeamTimedDexterityAutoEffect(turns = 3, 10.percent)
    +TeamTimedCriticalAutoEffect(turns = 3, 20.percent)
    // TODO: Seal

    unitSkill = TeamActCriticalAutoEffect(50.percent).attributeOnly(Attribute.Flower)
}