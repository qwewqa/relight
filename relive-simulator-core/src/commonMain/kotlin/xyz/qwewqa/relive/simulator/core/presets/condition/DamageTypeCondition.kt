package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.stage.character.DamageType
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val NormalDamageOnlyCondition = NamedCondition("Normal Damage Only") {
    it.dress.damageType == DamageType.Normal
}

val SpecialDamageOnlyCondition = NamedCondition("Normal Damage Only") {
    it.dress.damageType == DamageType.Special
}
