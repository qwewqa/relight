package xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.effect.ActTimedEffect
import xyz.qwewqa.relivesim.presets.TeamActCriticalAutoEffect
import xyz.qwewqa.relivesim.presets.schoolOnly
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.*
import xyz.qwewqa.relivesim.stage.percent

val BabyStageGirlNana = stageGirlPrototype + {
    name = "Stage Girl"
    character = Character.Nana
    attribute = Attribute.Cloud
    damageType = DamageType.Normal
    position = Position.Middle
    stats {
        hp = 3552
        actPower = 256
        normalDefense = 253
        specialDefense = 131
        agility = 205
    }
    positionValue = 21040

    ActType.Act1("Strong Slash", 2) {
        targetFront().act {
            attack(147.percent)
        }
    }
    ActType.Act2("Inspiring Slash", 3) {
        targetFront().act {
            attack(165.percent, hitCount = 2)
        }
        targetAllyAoe().act {
            applyEffect { ActTimedEffect(turns = 3, 20.percent) }
        }
    }
    ActType.Act3("Synchro Slash", 3) {
        targetFront().act {
            attack(165.percent, hitCount = 2)
        }
        targetAllyAoe().act {
            addBrilliance(10)
        }
    }

    unitSkill = TeamActCriticalAutoEffect(50.percent).schoolOnly(School.Seisho)
}
val BabyBSNana = BabyStageGirlNana