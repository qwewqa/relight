package xyz.qwewqa.relivesim.presets.stagegirl.backrow.cloud

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.effect.MarkTimedEffect
import xyz.qwewqa.relivesim.presets.TeamActCriticalAutoEffect
import xyz.qwewqa.relivesim.presets.attributeOnly
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.effect.EffectClass
import xyz.qwewqa.relivesim.stage.percent

val StageGirlClaudine = stageGirlPrototype + {
    name = "Stage Girl"
    character = Character.Claudine
    attribute = Attribute.Cloud
    damageType = DamageType.Normal
    position = Position.Back
    stats {
        hp = 34459
        actPower = 3162
        normalDefense = 1793
        specialDefense = 1076
        agility = 2008
    }
    positionValue = 35050

    ActType.Act1("Marked Slash", 2) {
        targetFront().act {
            attack(105.percent)
            applyEffect { MarkTimedEffect(turns = 3) }
        }
    }
    ActType.Act2("Purifying Flash", 2) {
        targetFront().act {
            attack(155.percent)
        }
        targetAllyFront(3).act {
            dispelTimed(EffectClass.Negative)
        }
    }
    ActType.Act3("Synchro of Brilliance", 2) {
        targetFront().act {
            attack(155.percent)
        }
        targetAllyAoe().act {
            addBrilliance(15)
        }
    }

    unitSkill = TeamActCriticalAutoEffect(30.percent).attributeOnly(Attribute.Cloud)
}
val BSClaudine = StageGirlClaudine