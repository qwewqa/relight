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
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.AgonyBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.BurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterAgonyBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterArroganceBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterBurnBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterHopeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterInsanityBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.HopeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.WeakenBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect

val Modifiers.maxHp: I54
  get() {
    return (Modifier.BaseMaxHp ptmod (Modifier.BuffMaxHp - Modifier.DebuffMaxHp)) +
        Modifier.FixedMaxHp
  }

inline val Modifiers.hopeFactor: I54
  get() {
    return 20 given { HopeBuff in actor.buffs || GreaterHopeBuff in actor.buffs }
  }

inline val Modifiers.superStrengthFactor: I54
  get() {
    return 30 given { Buffs.SuperStrengthBuff in actor.buffs }
  }

inline val Modifiers.actPower: I54
  get() {
    val staminaModifier = Modifier.StaminaActPowerUp given { actor.hp == maxHp }
    val burnModifier = -10 given { BurnBuff in actor.buffs || GreaterBurnBuff in actor.buffs }
    val holdBackModifier = -50 given { Buffs.HoldBackBuff in actor.buffs }
    return (Modifier.BaseActPower ptmod
        (Modifier.ActPowerUp - Modifier.ActPowerDown +
            staminaModifier +
            burnModifier +
            hopeFactor +
            holdBackModifier)) + Modifier.FixedActPower
  }

inline val Modifiers.normalDefense: I54
  get() {
    return (Modifier.BaseNormalDefense ptmod
            (Modifier.NormalDefenseUp - Modifier.NormalDefenseDown))
        .coerceAtLeast(0) + Modifier.FixedNormalDefense
  }

inline val Modifiers.specialDefense: I54
  get() {
    return (Modifier.BaseSpecialDefense ptmod
            (Modifier.SpecialDefenseUp - Modifier.SpecialDefenseDown))
        .coerceAtLeast(0) + Modifier.FixedSpecialDefense
  }

inline val Modifiers.agility: I54
  get() {
    return (Modifier.BaseAgility ptmod
        (Modifier.AgilityUp - Modifier.AgilityDown + hopeFactor +
            (if (GreaterInsanityBuff in actor.buffs) (-99).i54 else 0.i54) +
            (if (GreaterArroganceBuff in actor.buffs) (-99).i54 else 0.i54))) + Modifier.FixedAgility
  }

inline val Modifiers.dexterity: I54
  get() {
    val holdBackModifier = -100 given { Buffs.HoldBackBuff in actor.buffs }
    return (Modifier.BaseDexterity +
            (hopeFactor + Modifier.BuffDexterity).coerceAtMost(100) +
            holdBackModifier - Modifier.DebuffDexterity)
        .coerceIn(0, 100)
  }

inline val Modifiers.critical: I54
  get() {
    val holdBackModifier = -100 given { Buffs.HoldBackBuff in actor.buffs }
    return (Modifier.BaseCritical + Modifier.BuffCritical + holdBackModifier -
            Modifier.DebuffCritical + hopeFactor + superStrengthFactor)
        .coerceAtLeast(0)
  }

inline val Modifiers.accuracy: I54
  get() {
    return Modifier.BaseAccuracy ptmod (Modifier.BuffAccuracy - Modifier.DebuffAccuracy)
  }

inline val Modifiers.evasion: I54
  get() {
    return Modifier.BaseEvasion ptmod (Modifier.BuffEvasion - Modifier.DebuffEvasion)
  }

val Modifiers.brillianceGainAdjustment: I54
  get() {
    return Modifier.BrillianceGainUp - Modifier.BrillianceGainDown
  }

val Modifiers.hpRecoveryAdjustment: I54
  get() {
    return Modifier.HpRecoveryUp - Modifier.HpRecoveryDown
  }

fun Modifiers.positiveEffectResistance(effect: BuffEffect): I54 {
  if (effect.groupLevel == 1 && Buffs.GreaterStagnationBuff in actor.buffs) {
    return 100.i54
  }
  val resistance =
      when (effect.groupLevel) {
        1 ->
            when (effect) {
              is CountableBuffEffect -> +Modifier.PositiveCountableEffectResistanceUp
              else -> +Modifier.PositiveEffectResistanceUp
            }
        2 -> 0.i54
        else -> throw NotImplementedError("Unknown effect group level ${effect.groupLevel}")
      }
  val specificResistance = actor.specificBuffResist[effect] ?: 0.i54
  return resistance + specificResistance
}

fun Modifiers.negativeEffectResistance(effect: BuffEffect): I54 {
  val resistance =
      when (effect.groupLevel) {
        1 ->
            when (effect) {
              is CountableBuffEffect ->
                  Modifier.NegativeCountableEffectResistanceUp -
                      Modifier.NegativeCountableEffectResistanceDown
              else -> Modifier.NegativeEffectResistanceUp - Modifier.NegativeEffectResistanceDown
            }
        2 -> when (effect) {
          is CountableBuffEffect ->
              Modifier.GreaterNegativeCountableEffectResistanceUp -
                  Modifier.GreaterNegativeCountableEffectResistanceDown
          else -> Modifier.GreaterNegativeEffectResistanceUp -
              Modifier.GreaterNegativeEffectResistanceDown
        }
        else -> throw NotImplementedError("Unknown effect group level ${effect.groupLevel}")
      }
  val specificResistance = actor.specificBuffResist[effect] ?: 0.i54
  return resistance + specificResistance
}

val Modifiers.climaxDamageAdjustment: I54
  get() {
    return Modifier.ClimaxDamageUp - Modifier.ClimaxDamageDown
  }

fun Modifiers.damageDealtUpModifier(target: Actor): I54 {
  return (Modifier.DamageDealtUp +
      superStrengthFactor +
      actor.conditionalDamageDealtUp.sumOfI54 { (cond, value) ->
        value given { cond.evaluate(target) }
      } +
      (actor.againstSchoolDamageDealtUp[target.dress.character.school] ?: 0.i54))
}

fun Modifiers.damageReceivedModifier(attacker: Actor) =
    ((Modifier.DamageReceivedUp - (+Modifier.DamageReceivedDown).coerceAtMost(100)) +
        (actor.fromCharacterDamageReceivedUp[attacker.dress.character] ?: 0.i54) +
        (if (WeakenBuff in actor.buffs) 10.i54 else 0.i54) +
        (if (AgonyBuff in actor.buffs || GreaterAgonyBuff in actor.buffs) 30.i54 else 0.i54) +
        (if (GreaterArroganceBuff in actor.buffs) 30.i54 else 0.i54) +
        (if (GreaterInsanityBuff in actor.buffs) 30.i54 else 0.i54))
