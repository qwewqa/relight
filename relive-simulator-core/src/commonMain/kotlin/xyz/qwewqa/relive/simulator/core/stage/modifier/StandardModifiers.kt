package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.BurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect

val baseMaxHp = modifier("baseMaxHp")
val maxHpUp = modifier("buffMaxHp")
val Modifiers.maxHp: Int
    get() {
        return baseMaxHp pfmod maxHpUp
    }

inline val Modifiers.hopeFactor: Int
    get() {
        return 20 given { CountableBuff.Hope in actor.buffs }
    }

val baseActPower = modifier("baseActPower")
val actPowerUp = modifier("actPowerUp")
val actPowerDown = modifier("actPowerDown")
val fixedActPower = modifier("fixedActPower")
val staminaActPowerUp = modifier("staminaActPowerUp")
inline val Modifiers.actPower: Int
    get() {
        val staminaModifier = staminaActPowerUp given { actor.hp == maxHp }
        val burnModifier = -10 given { BurnBuff in actor.buffs }
        return baseActPower pfmod (actPowerUp - actPowerDown + staminaModifier + burnModifier + hopeFactor) + fixedActPower
    }

val baseNormalDefense = modifier("baseNormalDefense")
val normalDefenseUp = modifier("normalDefenseUp")
val normalDefenseDown = modifier("normalDefenseDown")
inline val Modifiers.normalDefense: Int
    get() {
        return baseNormalDefense pfmod (normalDefenseUp - normalDefenseDown)
    }

val baseSpecialDefense = modifier("baseSpecialDefense")
val specialDefenseUp = modifier("specialDefenseUp")
val specialDefenseDown = modifier("specialDefenseDown")
inline val Modifiers.specialDefense: Int
    get() {
        return baseSpecialDefense pfmod (specialDefenseUp - specialDefenseDown)
    }

val baseAgility = modifier("baseAgility")
val agilityUp = modifier("agilityUp")
val agilityDown = modifier("agilityDown")
inline val Modifiers.agility: Int
    get() {
        return baseAgility pfmod (agilityUp - agilityDown + hopeFactor)
    }

val baseDexterity = modifier("baseDexterity")
val buffDexterity = modifier("buffDexterity")
val debuffDexterity = modifier("debuffDexterity")
inline val Modifiers.dexterity: Int
    get() {
        return (baseDexterity + (hopeFactor + buffDexterity).coerceAtMost(100) - debuffDexterity + hopeFactor).coerceAtMost(100)
    }

val baseCritical = modifier("baseCritical")
val buffCritical = modifier("buffCritical")
val debuffCritical = modifier("debuffCritical")
inline val Modifiers.critical: Int
    get() {
        return baseCritical + buffCritical - debuffCritical + hopeFactor
    }

val baseAccuracy = modifier("baseAccuracy")
val accuracyUp = modifier("buffAccuracy")
val accuracyDown = modifier("debuffAccuracy")
inline val Modifiers.accuracy: Int
    get() {
        return baseAccuracy pfmod (accuracyUp - accuracyDown)
    }

val baseEvasion = modifier("baseEvasion")
val evasionUp = modifier("buffEvasion")
val evasionDown = modifier("debuffEvasion")
inline val Modifiers.evasion: Int
    get() {
        return baseEvasion pfmod (evasionUp - evasionDown)
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
        is CountableBuffEffect -> positiveCountableEffectResistance
        else -> positiveEffectResistance
    }
    val specificResistance = actor.specificBuffResist[effect] ?: 0
    return resistance + specificResistance
}

fun Modifiers.negativeEffectResistance(effect: BuffEffect): Int {
    val resistance = when (effect) {
        is CountableBuffEffect -> negativeCountableEffectResistance
        else -> negativeEffectResistance
    }
    val specificResistance = actor.specificBuffResist[effect] ?: 0
    return resistance + specificResistance
}

val climaxDamageUp = modifier("climaxDamageUp")
val climaxDamageDown = modifier("climaxDamageDown")
val Modifiers.climaxDamageAdjustment: Int
    get() {
        return climaxDamageUp - climaxDamageDown
    }

val damageDealtUp = modifier("damageDealtUp")
val damageDealtDown = modifier("damageDealtDown")
fun Modifiers.damageDealtUpModifier(target: Actor): Int {
    return (
            damageDealtUp
                    + actor.conditionalDamageDealtUp.sumOf { (cond, value) -> value given cond.evaluate(target) }
            )
}

val damageReceivedDown = modifier("damageReceivedDown")
val damageReceivedUp = modifier("damageReceivedUp")
val Modifiers.damageReceivedModifier: Int
    get() {
        return damageReceivedUp - (+damageReceivedDown).coerceAtMost(50)
    }

val brillianceRegen = modifier("brillianceRegen")
val hpFixedRegen = modifier("hpRegen")
val hpPercentRegen = modifier("hpPercentRegen")
val reviveRegen = modifier("reviveRegen")

val counterHeal = modifier("counterHeal")
