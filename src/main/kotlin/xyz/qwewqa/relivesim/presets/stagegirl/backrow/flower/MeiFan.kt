package xyz.qwewqa.relivesim.presets.stagegirl.backrow.flower

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.effect.*
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.effect.EffectType
import xyz.qwewqa.relivesim.stage.percent

val StageGirlMeiFan = stageGirlPrototype + {
    name = "Stage Girl"
    character = Character.MeiFan
    attribute = Attribute.Flower
    damageType = DamageType.Normal
    position = Position.Back
    stats {
        hp = 33084
        actPower = 3251
        normalDefense = 1616
        specialDefense = 1239
        agility = 2113
    }
    positionValue = 34050

    ActType.Act1("Strong Slash", 2) {
        targetFront().act {
            attack(176.percent, hitCount = 2)
        }
    }
    ActType.Act2("Flash of Determination", 2) {
        targetSelf().act {
            applyEffects(
                { EffectiveDamageTimedEffect(turns = 3, 30.percent) },
                { DexterityTimedEffect(turns = 3, 20.percent) },
            )
        }
        targetHighestAct().act {
            attack(198.percent, hitCount = 2)
        }
    }
    ActType.Act3("Unwavering Passion", 2) {
        targetHighestAct().act {
            attack(198.percent, hitCount = 2)
        }
        targetAllyAoe().act {
            applyEffects(
                { ActTimedEffect(turns = 3, 20.percent) },
                { ApDownTimedEffect(turns = 2) },
            )
        }
    }
    ActType.ClimaxAct("O king, my burning passion will create your noble path!", 2) {
        targetHighestAct().act {
            applyEffects(
                { ActTimedEffect(turns = 3, -30.percent) },
                { NormalDefenseTimedEffect(turns = 3, -30.percent) },
            )
            attack(
                369.percent,
                bonusMultiplier = 150.percent,
                bonusCondition = { data.damageType == DamageType.Special },
                hitCount = 4,
            )
        }
    }

    +TeamTimedActAutoEffect(turns = 3, 20.percent)
    +EffectType.Confuse.teamResistAutoEffect()
    +EffectType.Stop.teamResistAutoEffect()

    unitSkill = TeamActCriticalAutoEffect(50.percent).attributeOnly(Attribute.Flower)
}