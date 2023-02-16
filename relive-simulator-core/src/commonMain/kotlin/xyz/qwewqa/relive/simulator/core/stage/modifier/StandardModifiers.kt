package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect

val baseMaxHp = modifier("baseMaxHp")
val maxHpUp = modifier("buffMaxHp")
val Modifiers.maxHp: Int
    get() {
        return baseMaxHp pfmod maxHpUp
    }

inline val Modifiers.hopeFactor: Int
    get() {
        return 20 given { actor.buffs.any(CountableBuff.Hope) }
    }

val baseActPower = modifier("baseActPower")
val actPowerUp = modifier("actPowerUp")
val fixedActPower = modifier("fixedActPower")
val staminaActPowerUp = modifier("staminaActPowerUp")
inline val Modifiers.actPower: Int
    get() {
        val stam = staminaActPowerUp given { actor.hp == actor.maxHp }
        return baseActPower pfmod (actPowerUp + stam + hopeFactor) + fixedActPower
    }

val baseNormalDefense = modifier("baseNormalDefense")
val normalDefenseUp = modifier("normalDefenseUp")
inline val Modifiers.normalDefense: Int
    get() {
        return baseNormalDefense pfmod normalDefenseUp
    }

val baseSpecialDefense = modifier("baseSpecialDefense")
val specialDefenseUp = modifier("specialDefenseUp")
inline val Modifiers.specialDefense: Int
    get() {
        return baseSpecialDefense pfmod specialDefenseUp
    }

val baseAgility = modifier("baseAgility")
val agilityUp = modifier("agilityUp")
inline val Modifiers.agility: Int
    get() {
        return baseAgility pfmod (agilityUp + hopeFactor)
    }

val baseDexterity = modifier("baseDexterity")
val buffDexterity = modifier("buffDexterity")
val debuffDexterity = modifier("debuffDexterity")
inline val Modifiers.dexterity: Int
    get() {
        return baseDexterity + (+buffDexterity).coerceAtMost(100) - debuffDexterity + hopeFactor
    }

val baseCritical = modifier("baseCritical")
val buffCritical = modifier("buffCritical")
val debuffCritical = modifier("debuffCritical")
inline val Modifiers.critical: Int
    get() {
        return baseCritical + buffCritical - debuffCritical + hopeFactor
    }

val baseAccuracy = modifier("baseAccuracy")
val buffAccuracy = modifier("buffAccuracy")
val debuffAccuracy = modifier("debuffAccuracy")
inline val Modifiers.accuracy: Int
    get() {
        return baseAccuracy + buffAccuracy - debuffAccuracy + hopeFactor
    }

val baseEvasion = modifier("baseEvasion")
val buffEvasion = modifier("buffEvasion")
val debuffEvasion = modifier("debuffEvasion")
inline val Modifiers.evasion: Int
    get() {
        return baseEvasion + buffEvasion - debuffEvasion + hopeFactor
    }

val effectiveDamageUp = modifier("effectiveDamageUp")

val normalReflect = modifier("normalReflect")

val specialReflect = modifier("specialReflect")

val brillianceGainUp = modifier("brillianceGainUp")
val brillianceGainDown = modifier("brillianceGainDown")
val Modifiers.brillianceGainAdjustment: Int
    get() {
        return brillianceGainUp - brillianceGainDown
    }

val hpRecoveryUp = modifier("hpRecoveryUp")
val hpRecoveryDown = modifier("hpRecoveryDown")
val Modifiers.hpRecoveryAdjustment: Int
    get() {
        return hpRecoveryUp - hpRecoveryDown
    }

val absorb = modifier("absorb")

val negativeEffectResistance = modifier("negativeEffectResistance")
val negativeCountableEffectResistance = modifier("negativeCountableEffectResistance")
val positiveEffectResistance = modifier("positiveEffectResistance")
val positiveCountableEffectResistance = modifier("positiveCountableEffectResistance")
fun Modifiers.positiveEffectResistance(effect: BuffEffect): Int {
    val resistance = when (effect) {
        is TimedBuffEffect -> positiveCountableEffectResistance
        else -> positiveEffectResistance
    }
    val specificResistance = actor.specificBuffResist[effect] ?: 0
    return resistance + specificResistance
}

fun Modifiers.negativeEffectResistance(effect: BuffEffect): Int {
    val resistance = when (effect) {
        is TimedBuffEffect -> negativeCountableEffectResistance
        else -> negativeEffectResistance
    }
    val specificResistance = actor.specificBuffResist[effect] ?: 0
    return resistance + specificResistance
}

val climaxDamageUp = modifier("climaxDamageUp")

val damageDealtUp = modifier("damageDealtUp")
val damageDealtDown = modifier("damageDealtDown")
fun Modifiers.damageDealtModifier(target: Actor): Int {
    return (
            damageDealtUp
                    + actor.conditionalDamageDealtUp.sumOf { (cond, value) -> value given cond.evaluate(target) }
                    - damageDealtDown
            )
}

val damageTakenDown = modifier("damageTakenDown")
val damageTakenUp = modifier("damageTakenUp")
val Modifiers.damageTakenModifier: Int
    get() {
        return (+damageTakenDown).coerceAtMost(50) - damageTakenUp
    }

val brillianceRegen = modifier("brillianceRegen")
val hpRegen = modifier("hpRegen")
val hpPercentRegen = modifier("hpPercentRegen")
val reviveRegen = modifier("reviveRegen")

val counterHeal = modifier("counterHeal")
