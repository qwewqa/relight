package xyz.qwewqa.relivesim.presets.stagegirl.backrow.space

import xyz.qwewqa.relivesim.dsl.stageGirlPrototype
import xyz.qwewqa.relivesim.presets.*
import xyz.qwewqa.relivesim.presets.effect.*
import xyz.qwewqa.relivesim.stage.act.ActType
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.Character
import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.percent

val SanadaMahiru = stageGirlPrototype + {
    name = "Sanada"
    character = Character.Mahiru
    attribute = Attribute.Space
    damageType = DamageType.Normal
    position = Position.Back
    stats {
        hp = 18605
        actPower = 2747
        normalDefense = 1541
        specialDefense = 1076
        agility = 2113
    }
    positionValue = 34050

    ActType.Act1("Strong Slash", 2) {
        targetFront().act {
            attack(176.percent)
        }
    }
    ActType.Act2("Spearheading Blade", 2) {
        targetSelf().act {
            applyEffects(
                { ActTimedEffect(turns = 3, 20.percent) },
                { CriticalTimedEffect(turns = 3, 20.percent) },
            )
        }
        targetHighestAct().act {
            attack(155.percent, hitCount = 2)
        }
    }
    ActType.Act3("Dashing Blade", 2) {
        targetSelf().act {
            applyEffects(
                { DexterityTimedEffect(turns = 3, 20.percent) },
                { EffectiveDamageTimedEffect(turns = 3, 30.percent) },
            )
        }
        targetHighestAct().act {
            attack(198.percent, hitCount = 2)
        }
    }
    ActType.ClimaxAct("Greatest Spear", 2) {
        targetHighestAct().act {
            applyEffects(
                { MarkTimedEffect(turns = 2) },
                { NormalDefenseTimedEffect(turns = 3, -30.percent) },
            )
            attack(
                369.percent,
                bonusMultiplier = 150.percent,
                bonusCondition = { data.damageType == DamageType.Special },
                hitCount = 3,
            )
        }
    }

    +DamageDealtAutoEffect(10.percent)
    +DexterityAutoEffect(10.percent)
    +EffectiveDamageAutoEffect(20.percent)

    unitSkill = TeamActCriticalAutoEffect(30.percent).positionOnly(Position.Back)
}