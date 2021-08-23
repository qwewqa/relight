package xyz.qwewqa.relivesim.presets.stagegirl.backrow.moon

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.DamageDealtAutoEffect
import xyz.qwewqa.relivesim.presets.TeamActCriticalAutoEffect
import xyz.qwewqa.relivesim.presets.effect.ActTimedEffect
import xyz.qwewqa.relivesim.presets.schoolOnly
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.*
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.percent

val BabyStageGirlHikari = stageGirlPrototype + {
    name = "Stage Girl"
    character = Character.Hikari
    attribute = Attribute.Moon
    damageType = DamageType.Special
    position = Position.Back
    stats {
        hp = 2766
        actPower = 372
        normalDefense = 211
        specialDefense = 127
        agility = 275
    }
    positionValue = 34050

    ActType.Act1("Strong Slash", 2) {
        targetFront().act {
            attack(147.percent, hitCount = 2)
        }
    }
    ActType.Act2("Severing Slash", 2) {
        targetAoe().act {
            dispelTimed(EffectClass.Positive)
        }
        targetFront().act {
            attack(147.percent)
        }
    }
    ActType.Act3("Darkness Slash", 2) {
        targetFront().act {
            attack(165.percent)
        }
        targetAoe().act {
            applyEffect { TODO() }
        }
    }
    ActType.ClimaxAct("All of this... is for the sake of \"Starlight\"!", 2) {
        TODO()
    }

    +DamageDealtAutoEffect(10.percent)

    unitSkill = TeamActCriticalAutoEffect(50.percent).schoolOnly(School.Seisho)
}
val BabyBSHikari = BabyStageGirlHikari