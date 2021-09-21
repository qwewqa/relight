package xyz.qwewqa.relive.simulator.presets.condition

import xyz.qwewqa.relivesim.stage.character.DamageType
import xyz.qwewqa.relive.simulator.stage.condition.NamedCondition

val NormalDamageOnlyCondition = NamedCondition("Normal Damage Only") {
    it.dress.damageType == DamageType.Normal
}

val SpecialDamageOnlyCondition = NamedCondition("Normal Damage Only") {
    it.dress.damageType == DamageType.Special
}
