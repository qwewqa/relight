package xyz.qwewqa.relive.simulator.core.stage.modifier

import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.i54.plus
import xyz.qwewqa.relive.simulator.core.i54.times
import xyz.qwewqa.relive.simulator.core.i54.toI54
import xyz.qwewqa.relive.simulator.core.i54.toI54Unchecked
import xyz.qwewqa.relive.simulator.core.stage.actor.Actor

enum class Modifier {
  BaseMaxHp,
  BuffMaxHp,
  DebuffMaxHp,
  FixedMaxHp,
  BaseActPower,
  ActPowerUp,
  ActPowerDown,
  FixedActPower,
  StaminaActPowerUp,
  BaseNormalDefense,
  NormalDefenseUp,
  NormalDefenseDown,
  FixedNormalDefense,
  BaseSpecialDefense,
  SpecialDefenseUp,
  SpecialDefenseDown,
  FixedSpecialDefense,
  BaseAgility,
  AgilityUp,
  AgilityDown,
  FixedAgility,
  BaseDexterity,
  BuffDexterity,
  DebuffDexterity,
  BaseCritical,
  BuffCritical,
  DebuffCritical,
  CriticalDamageReceivedDown,
  BaseAccuracy,
  BuffAccuracy,
  DebuffAccuracy,
  BaseEvasion,
  BuffEvasion,
  DebuffEvasion,
  EffectiveDamageUp,
  NormalReflect,
  SpecialReflect,
  BrillianceGainUp,
  BrillianceGainDown,
  HpRecoveryUp,
  HpRecoveryDown,
  Absorb,
  NegativeEffectResistanceUp,
  NegativeEffectResistanceDown,
  NegativeCountableEffectResistanceUp,
  NegativeCountableEffectResistanceDown,
  PositiveEffectResistanceUp,
  PositiveCountableEffectResistanceUp,
  ClimaxDamageUp,
  ClimaxDamageDown,
  DamageDealtUp,
  DamageDealtDown,
  DamageReceivedDown,
  DamageReceivedUp,
  BrillianceRegen,
  BrillianceRegenTurnScaling,
  BrillianceSap,
  HpRegen,
  HpPercentRegen,
  ReviveRegen,
  SuperStrengthRegen,
  ContinuousPositiveTurnReductionRegen,
  CounterHealFixed,
  CounterHealPercent,
  TurnReduceCountablePositiveEffects,
  TurnReduceCountableNegativeEffects,
  PoisonDamage,
  BurnDamage,
  FrostbiteDamage,
  NightmareDamage,
  Weaken,
}

private val modifierCount = Modifier.values().size

// actor is included so that it may be accessed from extension methods,
// since context receivers are not stable yet.
@Suppress("NOTHING_TO_INLINE")
class Modifiers(val actor: Actor) {
  val values = DoubleArray(modifierCount)

  inline fun get(modifier: Modifier) = values[modifier.ordinal].toI54Unchecked()

  inline fun set(modifier: Modifier, value: I54) {
    values[modifier.ordinal] = value.toDouble()
  }

  inline operator fun Modifier.invoke() = get(this)
  inline operator fun Modifier.invoke(value: I54) {
    set(this, value)
  }
  inline operator fun Modifier.invoke(value: Modifier) {
    set(this, get(value))
  }
  inline operator fun I54.invoke() = this
  inline operator fun Int.invoke() = this.toI54()

  inline operator fun Modifier.unaryPlus() = get(this)
  inline operator fun Modifier.unaryMinus() = -get(this)

  inline infix fun Modifier.setTo(value: I54) {
    set(this, value)
  }

  inline infix fun Modifier.setTo(value: Int) {
    set(this, value.toI54())
  }

  inline infix fun Modifier.setTo(value: Modifier) {
    set(this, get(value))
  }

  inline operator fun Modifier.plus(other: I54) = get(this) + other
  inline operator fun Modifier.minus(other: I54) = get(this) - other
  inline operator fun Modifier.times(other: I54) = get(this) * other
  inline operator fun Modifier.div(other: I54) = get(this) / other
  inline operator fun Modifier.rem(other: I54) = get(this) % other
  inline operator fun Modifier.rangeTo(other: I54) = get(this)..other
  inline operator fun Modifier.compareTo(other: I54) = get(this).compareTo(other)

  inline operator fun Modifier.plus(other: Int) = get(this) + other
  inline operator fun Modifier.minus(other: Int) = get(this) - other
  inline operator fun Modifier.times(other: Int) = get(this) * other
  inline operator fun Modifier.div(other: Int) = get(this) / other
  inline operator fun Modifier.rem(other: Int) = get(this) % other
  inline operator fun Modifier.rangeTo(other: Int) = get(this)..other.toI54()
  inline operator fun Modifier.compareTo(other: Int) = get(this).compareTo(other)

  inline operator fun Modifier.plus(other: Modifier) = get(this) + get(other)
  inline operator fun Modifier.minus(other: Modifier) = get(this) - get(other)
  inline operator fun Modifier.times(other: Modifier) = get(this) * get(other)
  inline operator fun Modifier.div(other: Modifier) = get(this) / get(other)
  inline operator fun Modifier.rem(other: Modifier) = get(this) % get(other)
  inline operator fun Modifier.rangeTo(other: Modifier) = get(this)..get(other)

  inline operator fun I54.plus(other: Modifier) = this + get(other)
  inline operator fun I54.minus(other: Modifier) = this - get(other)
  inline operator fun I54.times(other: Modifier) = this * get(other)
  inline operator fun I54.div(other: Modifier) = this / get(other)
  inline operator fun I54.rem(other: Modifier) = this % get(other)
  inline operator fun I54.rangeTo(other: Modifier) = this..get(other)
  inline operator fun I54.compareTo(other: Modifier) = this.compareTo(get(other))

  inline operator fun Int.plus(other: Modifier) = this.toI54() + get(other)
  inline operator fun Int.minus(other: Modifier) = this.toI54() - get(other)
  inline operator fun Int.times(other: Modifier) = this.toI54() * get(other)
  inline operator fun Int.div(other: Modifier) = this.toI54() / get(other)
  inline operator fun Int.rem(other: Modifier) = this.toI54() % get(other)
  inline operator fun Int.rangeTo(other: Modifier) = this.toI54()..get(other)
  inline operator fun Int.compareTo(other: Modifier) = this.toI54().compareTo(get(other))

  inline operator fun Modifier.plusAssign(other: I54) {
    set(this, get(this) + other)
  }
  inline operator fun Modifier.minusAssign(other: I54) {
    set(this, get(this) - other)
  }
  inline operator fun Modifier.timesAssign(other: I54) {
    set(this, get(this) * other)
  }
  inline operator fun Modifier.divAssign(other: I54) {
    set(this, get(this) / other)
  }
  inline operator fun Modifier.remAssign(other: I54) {
    set(this, get(this) % other)
  }

  inline operator fun Modifier.plusAssign(other: Int) {
    set(this, get(this) + other)
  }
  inline operator fun Modifier.minusAssign(other: Int) {
    set(this, get(this) - other)
  }
  inline operator fun Modifier.timesAssign(other: Int) {
    set(this, get(this) * other)
  }
  inline operator fun Modifier.divAssign(other: Int) {
    set(this, get(this) / other)
  }
  inline operator fun Modifier.remAssign(other: Int) {
    set(this, get(this) % other)
  }

  inline operator fun Modifier.plusAssign(other: Modifier) {
    set(this, get(this) + get(other))
  }
  inline operator fun Modifier.minusAssign(other: Modifier) {
    set(this, get(this) - get(other))
  }
  inline operator fun Modifier.timesAssign(other: Modifier) {
    set(this, get(this) * get(other))
  }
  inline operator fun Modifier.divAssign(other: Modifier) {
    set(this, get(this) / get(other))
  }
  inline operator fun Modifier.remAssign(other: Modifier) {
    set(this, get(this) % get(other))
  }

  inline infix fun I54.ptmul(other: Modifier) = (this.toDouble() * get(other) / 100).toI54()

  inline infix fun Int.ptmul(other: I54) = (this.toDouble() * other / 100).toI54()
  inline infix fun Int.ptmul(other: Int) = (this.toDouble() * other / 100).toI54()
  inline infix fun Int.ptmul(other: Modifier) = (this.toDouble() * get(other) / 100).toI54()

  inline infix fun Modifier.ptmul(other: I54) = (get(this).toDouble() * other / 100).toI54()
  inline infix fun Modifier.ptmul(other: Int) = (get(this).toDouble() * other / 100).toI54()
  inline infix fun Modifier.ptmul(other: Modifier) =
      (get(this).toDouble() * get(other) / 100).toI54()

  inline infix fun I54.ptmod(other: Modifier) = this ptmul (100 + get(other))

  inline infix fun Int.ptmod(other: I54) = this ptmul (100 + other)
  inline infix fun Int.ptmod(other: Int) = this ptmul (100 + other)
  inline infix fun Int.ptmod(other: Modifier) = this ptmul (100 + get(other))

  inline infix fun Modifier.ptmod(other: I54) = this ptmul (100 + other)
  inline infix fun Modifier.ptmod(other: Int) = this ptmul (100 + other)
  inline infix fun Modifier.ptmod(other: Modifier) = this ptmul (100 + get(other))

  inline infix fun I54.given(condition: () -> Boolean) = if (condition()) this else 0.i54
  inline infix fun Int.given(condition: () -> Boolean) = (if (condition()) this else 0).toI54()
  inline infix fun Modifier.given(condition: () -> Boolean) =
      if (condition()) get(this) else 0.toI54()

  inline operator fun <T> invoke(block: Modifiers.() -> T) = block()
}
