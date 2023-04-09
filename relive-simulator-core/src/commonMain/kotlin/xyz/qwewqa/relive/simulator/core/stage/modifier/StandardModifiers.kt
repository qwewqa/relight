package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.coerceAtLeast
import xyz.qwewqa.relive.simulator.core.i54.coerceAtMost
import xyz.qwewqa.relive.simulator.core.i54.coerceIn
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.sumOfI54
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.HopeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect

val baseMaxHp = modifier("baseMaxHp")
val maxHpUp = modifier("buffMaxHp")
val maxHpDown = modifier("debuffMaxHp")
val fixedMaxHp = modifier("fixedMaxHp")
val Modifiers.maxHp: I54
  get() {
    return (baseMaxHp ptmod (maxHpUp - maxHpDown)) + fixedMaxHp
  }

inline val Modifiers.hopeFactor: I54
  get() {
    return 20 given { HopeBuff in actor.buffs }
  }

inline val Modifiers.superStrengthFactor: I54
  get() {
    return 30 given { Buffs.SuperStrengthBuff in actor.buffs }
  }

val baseActPower = modifier("baseActPower")
val actPowerUp = modifier("actPowerUp")
val actPowerDown = modifier("actPowerDown")
val fixedActPower = modifier("fixedActPower")
val staminaActPowerUp = modifier("staminaActPowerUp")
inline val Modifiers.actPower: I54
  get() {
    val staminaModifier = staminaActPowerUp given { actor.hp == maxHp }
    val burnModifier = -10 given { BurnBuff in actor.buffs }
    val holdBackModifier = -50 given { Buffs.HoldBackBuff in actor.buffs }
    return (baseActPower ptmod
        (actPowerUp - actPowerDown +
            staminaModifier +
            burnModifier +
            hopeFactor +
            holdBackModifier)) + fixedActPower
  }

val baseNormalDefense = modifier("baseNormalDefense")
val normalDefenseUp = modifier("normalDefenseUp")
val normalDefenseDown = modifier("normalDefenseDown")
val fixedNormalDefense = modifier("fixedNormalDefense")
inline val Modifiers.normalDefense: I54
  get() {
    return (baseNormalDefense ptmod (normalDefenseUp - normalDefenseDown)).coerceAtLeast(0) +
        fixedNormalDefense
  }

val baseSpecialDefense = modifier("baseSpecialDefense")
val specialDefenseUp = modifier("specialDefenseUp")
val specialDefenseDown = modifier("specialDefenseDown")
val fixedSpecialDefense = modifier("fixedSpecialDefense")
inline val Modifiers.specialDefense: I54
  get() {
    return (baseSpecialDefense ptmod (specialDefenseUp - specialDefenseDown)).coerceAtLeast(0) +
        fixedSpecialDefense
  }

val baseAgility = modifier("baseAgility")
val agilityUp = modifier("agilityUp")
val agilityDown = modifier("agilityDown")
val fixedAgility = modifier("fixedAgility")
inline val Modifiers.agility: I54
  get() {
    return (baseAgility ptmod (agilityUp - agilityDown + hopeFactor)) + fixedAgility
  }

val baseDexterity = modifier("baseDexterity")
val buffDexterity = modifier("buffDexterity")
val debuffDexterity = modifier("debuffDexterity")
inline val Modifiers.dexterity: I54
  get() {
    val holdBackModifier = -100 given { Buffs.HoldBackBuff in actor.buffs }
    return (baseDexterity + (hopeFactor + buffDexterity).coerceAtMost(100) + holdBackModifier -
            debuffDexterity)
        .coerceIn(0, 100)
  }

val baseCritical = modifier("baseCritical")
val buffCritical = modifier("buffCritical")
val debuffCritical = modifier("debuffCritical")
inline val Modifiers.critical: I54
  get() {
    val holdBackModifier = -100 given { Buffs.HoldBackBuff in actor.buffs }
    return (baseCritical + buffCritical + holdBackModifier - debuffCritical +
            hopeFactor +
            superStrengthFactor)
        .coerceAtLeast(0)
  }

val criticalDamageReceivedDown = modifier("criticalDamageReceivedDown")

val baseAccuracy = modifier("baseAccuracy")
val accuracyUp = modifier("buffAccuracy")
val accuracyDown = modifier("debuffAccuracy")
inline val Modifiers.accuracy: I54
  get() {
    return baseAccuracy ptmod (accuracyUp - accuracyDown)
  }

val baseEvasion = modifier("baseEvasion")
val evasionUp = modifier("buffEvasion")
val evasionDown = modifier("debuffEvasion")
inline val Modifiers.evasion: I54
  get() {
    return baseEvasion ptmod (evasionUp - evasionDown)
  }

val effectiveDamageUp = modifier("effectiveDamageUp")

val normalReflect = modifier("normalReflect")

val specialReflect = modifier("specialReflect")

val brillianceGainUp = modifier("brillianceGainUp")
val brillianceGainDown = modifier("brillianceGainDown")
val Modifiers.brillianceGainAdjustment: I54
  get() {
    return brillianceGainUp - brillianceGainDown
  }

val hpRecoveryUp = modifier("hpRecoveryUp")
val hpRecoveryDown = modifier("hpRecoveryDown")
val Modifiers.hpRecoveryAdjustment: I54
  get() {
    return hpRecoveryUp - hpRecoveryDown
  }

val absorb = modifier("absorb")

val negativeEffectResistanceUp = modifier("negativeEffectResistanceUp")
val negativeEffectResistanceDown = modifier("negativeEffectResistanceDown")
val negativeCountableEffectResistanceUp = modifier("negativeCountableEffectResistanceUp")
val negativeCountableEffectResistanceDown = modifier("negativeCountableEffectResistanceDown")
val positiveEffectResistanceUp = modifier("positiveEffectResistanceUp")
val positiveCountableEffectResistanceUp = modifier("positiveCountableEffectResistanceUp")

fun Modifiers.positiveEffectResistance(effect: BuffEffect): I54 {
  val resistance =
      when (effect) {
        is CountableBuffEffect -> positiveCountableEffectResistanceUp
        else -> positiveEffectResistanceUp
      }
  val specificResistance = actor.specificBuffResist[effect] ?: 0.i54
  return resistance + specificResistance
}

fun Modifiers.negativeEffectResistance(effect: BuffEffect): I54 {
  val resistance =
      when (effect) {
        is CountableBuffEffect ->
            negativeCountableEffectResistanceUp - negativeCountableEffectResistanceDown
        else -> negativeEffectResistanceUp - negativeEffectResistanceDown
      }
  val specificResistance = actor.specificBuffResist[effect] ?: 0.i54
  return resistance + specificResistance
}

val climaxDamageUp = modifier("climaxDamageUp")
val climaxDamageDown = modifier("climaxDamageDown")
val Modifiers.climaxDamageAdjustment: I54
  get() {
    return climaxDamageUp - climaxDamageDown
  }

val damageDealtUp = modifier("damageDealtUp")
val damageDealtDown = modifier("damageDealtDown")

fun Modifiers.damageDealtUpModifier(target: Actor): I54 {
  return (damageDealtUp +
      superStrengthFactor +
      actor.conditionalDamageDealtUp.sumOfI54 { (cond, value) ->
        value given { cond.evaluate(target) }
      } +
      (actor.againstSchoolDamageDealtUp[target.dress.character.school] ?: 0.i54))
}

val damageReceivedDown = modifier("damageReceivedDown")
val damageReceivedUp = modifier("damageReceivedUp")

fun Modifiers.damageReceivedModifier(attacker: Actor) =
    ((damageReceivedUp - (+damageReceivedDown).coerceAtMost(100)) +
            (actor.fromCharacterDamageReceivedUp[attacker.dress.character] ?: 0.i54))

val brillianceRegen = modifier("brillianceRegen")
val brillianceRegenTurnScaling = modifier("brillianceRegenTurnScaling")
val brillianceSap = modifier("brillianceSap")
val hpFixedRegen = modifier("hpRegen")
val hpPercentRegen = modifier("hpPercentRegen")
val reviveRegen = modifier("reviveRegen")
val superStrengthRegen = modifier("superStrengthRegen")

val counterHealFixed = modifier("counterHealFixed")
val counterHealPercent = modifier("counterHealPercent")

val turnReduceCountablePositiveEffects = modifier("turnReduceCountablePositiveEffects")
val turnReduceCountableNegativeEffects = modifier("turnReduceCountableNegativeEffects")
