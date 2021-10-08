package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val NormalDamageOnlyCondition = NamedCondition("Normal Damage") {
    it.dress.damageType == DamageType.Normal
}

val SpecialDamageOnlyCondition = NamedCondition("Special Damage") {
    it.dress.damageType == DamageType.Special
}
