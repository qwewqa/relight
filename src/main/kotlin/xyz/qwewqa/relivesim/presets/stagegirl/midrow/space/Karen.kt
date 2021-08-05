package xyz.qwewqa.relivesim.presets.stagegirl.midrow.space

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.effect.DexterityTimedEffect
import xyz.qwewqa.relivesim.presets.effect.EffectiveDamageTimedEffect
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.percent

val WheelOfFortuneKaren = stageGirlPrototype + {
    name = "Wheel of Fortune"
    character = Character.Karen
    attribute = Attribute.Space
    damageType = DamageType.Special
    position = Position.Middle
    stats {
        hp = 40965
        actPower = 2771
        normalDefense = 1336
        specialDefense = 2010
        agility = 2215
    }
    positionValue = 24050

    ActType.Act1("Slash of Brilliance", 2) {
        targetFront().act {
            attack(112.percent)
        }
        targetSelf().act {
            addBrilliance(20)
        }
    }
    ActType.Act2("Purity of Heaven", 2) {
        targetFront().act {
            attack(198.percent, hitCount = 2)
        }
        targetAoe().act {
            dispelTimed(EffectClass.Positive)
        }
    }
    ActType.Act3("Destiny Guidance", 3) {
        targetAoe().act {
            attack(64.percent, hitCount = 3)
        }
        targetAllyAoe().act {
            applyEffect { DexterityTimedEffect(turns = 3, 20.percent) }
            applyEffect { EffectiveDamageTimedEffect(turns = 3, 30.percent) }
        }
    }

    +TeamTimedDexterityAutoEffect(turns = 3, 10.percent)

    unitSkill = TeamActCriticalAutoEffect(50.percent).attributeOnly(Attribute.Space)
}