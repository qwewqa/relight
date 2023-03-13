package xyz.qwewqa.relive.simulator.core.stage.actor

import kotlin.math.min
import xyz.qwewqa.relive.simulator.common.DisplayBuffData
import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.PlatformSet
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ActionRestrictionResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.OverwhelmBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.TurnRemoveContinuousNegativeEffectsBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.TurnRemoveCountableNegativeEffectsBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.abnormalBuffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.burnDamage
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.nightmareDamage
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.poisonDamage
import xyz.qwewqa.relive.simulator.core.stage.buff.ContinuousBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.activateBlessings
import xyz.qwewqa.relive.simulator.core.stage.buff.displayPriority
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.modifier.brillianceRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.brillianceRegenTurnScaling
import xyz.qwewqa.relive.simulator.core.stage.modifier.brillianceSap
import xyz.qwewqa.relive.simulator.core.stage.modifier.hpFixedRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.hpPercentRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.modifier.reviveRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.superStrengthRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.turnReduceCountableNegativeEffects
import xyz.qwewqa.relive.simulator.core.stage.modifier.turnReduceCountablePositiveEffects
import xyz.qwewqa.relive.simulator.core.stage.platformMapOf
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf
import xyz.qwewqa.relive.simulator.core.stage.toPlatformMap

class BuffManager(val actor: Actor) {
  private val positiveBuffs = platformSetOf<ContinuousBuffImpl<*>>()
  private val negativeBuffs = platformSetOf<ContinuousBuffImpl<*>>()
  private val buffsByEffect =
      platformMapOf<ContinuousBuffEffect<*>, PlatformSet<ContinuousBuffImpl<*>>>()

  /**
   * We count these for checking whether a buff is active or not, but they are controlled by another
   * source, such as another buff (used for implementing locked versions of buffs) or stage effects.
   */
  private val pseudoBuffs = platformMapOf<ContinuousBuffEffect<*>, Int>()

  private val _effectNameMapping = platformMapOf<String, ContinuousBuffEffect<*>>()
  val effectNameMapping: Map<String, ContinuousBuffEffect<*>>
    get() = _effectNameMapping

  private val positiveCountableBuffs =
      platformMapOf<CountableBuffEffect, MutableList<CountableBuffStack>>()
  private val negativeCountableBuffs =
      platformMapOf<CountableBuffEffect, MutableList<CountableBuffStack>>()
  private val positiveCountableBuffStacks = mutableListOf<CountableBuffStack>()
  private val negativeCountableBuffStacks = mutableListOf<CountableBuffStack>()

  var guardOnAbnormal = false

  fun get(buff: ContinuousBuffEffect<*>): Set<ContinuousBuff<*>> = buffsByEffect[buff] ?: emptySet()
  fun all(): Set<ContinuousBuff<*>> = positiveBuffs + negativeBuffs
  fun continuous(): Set<ContinuousBuff<*>> = positiveBuffs + negativeBuffs
  fun continuousPositive(): Set<ContinuousBuff<*>> = positiveBuffs
  fun continuousNegative(): Set<ContinuousBuff<*>> = negativeBuffs
  fun countablePositive(): Map<CountableBuffEffect, List<CountableBuffStack>> =
      positiveCountableBuffs
  fun countableNegative(): Map<CountableBuffEffect, List<CountableBuffStack>> =
      negativeCountableBuffs

  operator fun contains(buffEffect: ContinuousBuffEffect<*>) = count(buffEffect) > 0
  operator fun contains(buff: CountableBuffEffect) = count(buff) > 0
  fun count(buffEffect: ContinuousBuffEffect<*>) =
      (buffsByEffect[buffEffect]?.size ?: 0) + (pseudoBuffs[buffEffect] ?: 0)
  fun count(buff: CountableBuffEffect) =
      when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff]
      }?.size
          ?: 0

  private fun ContinuousBuffEffect<*>.activate(
      source: Actor?,
      value: I54,
      turns: Int,
  ) =
      startContinuousBuff(this, source, value, turns).also { activeBuff ->
        when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }.addQuick(activeBuff)
        buffsByEffect
            .getOrPut(this) {
              _effectNameMapping[name] = this
              platformSetOf()
            }
            .addQuick(activeBuff)
        actor.context.log("Buff", debug = true) { "Buff ${activeBuff.name} added." }
      }

  fun activatePsuedoBuff(buffEffect: ContinuousBuffEffect<Unit>, value: I54 = 0.i54) {
    actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($value) added." }
    buffEffect.related?.let { activatePsuedoBuff(it, value) }
    pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) + 1
    buffEffect.onStart(actor.context, value, null)
  }

  fun updatePseudoBuff(buffEffect: ContinuousBuffEffect<Unit>, oldValue: I54, newValue: I54) {
    if (oldValue == newValue) {
      return
    }
    actor.context.log("Buff", debug = true) {
      "Pseudo buff ${buffEffect.name} ($oldValue -> $newValue) updated."
    }
    buffEffect.related?.let { updatePseudoBuff(it, oldValue, newValue) }
    buffEffect.onEnd(actor.context, oldValue, null, Unit)
    buffEffect.onStart(actor.context, newValue, null)
  }

  fun removePseudoBuff(buffEffect: ContinuousBuffEffect<Unit>, value: I54) {
    actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($value) removed." }
    buffEffect.related?.let { removePseudoBuff(it, value) }
    pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) - 1
    buffEffect.onEnd(actor.context, value, null, Unit)
  }

  fun add(
      source: Actor?,
      buffEffect: ContinuousBuffEffect<*>,
      value: I54,
      turns: Int
  ): ContinuousBuff<*>? {
    require(turns >= 0) { "Buff turns should not be negative." }
    if (buffEffect.exclusive) {
      val existing = get(buffEffect).singleOrNull()
      if (existing != null) {
        if (value > existing.value || turns > existing.turns) {
          actor.context.log("Buff") {
            "Exclusive buff ${buffEffect.formatName(turns)} (${turns}t) overrides existing $existing."
          }
          existing.remove()
        } else {
          actor.context.log("Buff") {
            "Exclusive buff ${buffEffect.formatName(turns)} (${turns}t) blocked by existing $existing."
          }
          return null
        }
      }
    }
    val buff = buffEffect.activate(source, value, turns)
    if (guardOnAbnormal && buffEffect in abnormalBuffs) {
      actor.context.log("Buff") { "Abnormal Guard activated." }
      add(null, ActionRestrictionResistanceUpBuff, 100.i54, 9)
    }
    return buff
  }

  fun addCountable(buff: CountableBuffEffect, count: Int = 1, value: I54 = 0.i54) {
    val categoryStacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }
    val effectStacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }.getOrPut(buff) { mutableListOf() }
    repeat(count) {
      val stack = CountableBuffStack(buff, value)
      categoryStacks.add(stack)
      effectStacks.add(stack)
    }
    if (guardOnAbnormal && buff in abnormalCountableBuffs) {
      actor.context.log("Buff") { "Abnormal Guard activated." }
      add(null, ActionRestrictionResistanceUpBuff, 100.i54, 9)
    }
  }

  fun remove(buff: CountableBuffEffect): I54 {
    val categoryStacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }
    val stacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[buff]
    if (stacks == null || stacks.size == 0)
        error("Cannot remove countable buff $buff which is already at zero stacks.")
    val prevCount = stacks.size
    val stack = stacks.removeLast()
    categoryStacks.remove(stack)
    val value = stack.value
    actor.context.log("Buff") {
      "Countable buff ${buff.name}${if (value != 0.i54) " ($value)" else ""} removed (prev: $prevCount, new: ${prevCount - 1})."
    }
    return value
  }

  fun removeHighest(buff: CountableBuffEffect): I54 {
    val categoryStacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }
    val stacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[buff]
    if (stacks == null || stacks.size == 0)
        error("Cannot remove countable buff $buff which is already at zero stacks.")
    val prevCount = stacks.size
    val stack = stacks.maxBy { it.value }
    stacks.remove(stack)
    categoryStacks.remove(stack)
    val value = stack.value
    actor.context.log("Buff") {
      "Countable buff ${buff.name}${if (value != 0.i54) " ($value)" else ""} removed (prev: $prevCount, new: ${prevCount - 1})."
    }
    return value
  }

  fun getNext(buff: CountableBuffEffect): I54? {
    val stacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[buff]
    return stacks?.lastOrNull()?.value
  }

  inline fun consumeOnce(buff: CountableBuffEffect, action: (I54) -> Unit = {}): Boolean {
    if (count(buff) == 0) {
      return false
    }
    action(removeHighest(buff))
    return true
  }

  inline fun consumeAll(buff: CountableBuffEffect, action: (I54) -> Unit = {}): Boolean {
    val count = count(buff)
    if (count == 0) {
      return false
    }
    repeat(count) { action(removeHighest(buff)) }
    return true
  }

  inline fun consumeUpTo(buff: CountableBuffEffect, max: Int, action: (I54) -> Unit = {}): Boolean {
    val count = count(buff)
    if (count == 0) {
      return false
    }
    repeat(count.coerceAtMost(max)) { action(removeHighest(buff)) }
    return true
  }

  fun tryRemove(buff: CountableBuffEffect) =
      if (count(buff) > 0) {
        remove(buff)
        true
      } else {
        false
      }

  /** Remove all non-ephemeral buffs. */
  fun clear() {
    positiveBuffs.toList().forEach { it.remove() }
    negativeBuffs.toList().forEach { it.remove() }
    positiveCountableBuffs.clear()
    negativeCountableBuffs.clear()
  }

  fun removeAll(buffEffect: ContinuousBuffEffect<*>) {
    (buffsByEffect[buffEffect] ?: return).toList().forEach { it.remove() }
  }

  fun remove(category: BuffCategory) {
    when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }
        .filter { !it.effect.isLocked }
        .forEach { it.remove() }
  }

  fun adjustContinuousTurns(category: BuffCategory, delta: Int) {
    val buffs =
        when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }
    buffs.forEach { it.turns = (it.turns + delta).coerceAtLeast(0) }
    if (delta < 0) {
      buffs.filter { it.turns == 0 }.forEach { it.remove() }
    }
  }

  fun removeCountable(category: BuffCategory) {
    val stacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }
    stacks.keys.forEach { if (!it.isLocked) stacks[it]!!.clear() }
  }

  fun increaseCountable(category: BuffCategory, count: Int) {
    val stacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }
    // TODO: Test how this works for countables that can have different values
    stacks.values.forEach {
      it.lastOrNull()?.let { buff ->
        addCountable(buff = buff.effect, count = count, value = buff.value)
      }
    }
  }

  fun removeCountable(category: BuffCategory, count: Int): Int {
    val categoryStacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }
    val stacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }
    val targets = categoryStacks.takeLast(count)
    targets.forEach { stack ->
      val effectStacks = stacks[stack.effect]!!
      effectStacks.removeAt(effectStacks.lastIndexOf(stack))
    }
    repeat(targets.size) { categoryStacks.removeLast() }
    return targets.size
  }

  fun removeCountable(effect: CountableBuffEffect, count: Int): Int {
    val categoryStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }
    val effectStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[effect]
            ?: return 0 // No stacks of this effect if null
    val actualCount = min(count, effectStacks.size)
    repeat(actualCount) {
      val stack = effectStacks.removeLast()
      categoryStacks.remove(stack)
    }
    return actualCount
  }

  fun removeCountable(effect: CountableBuffEffect): Int {
    val categoryStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }
    val effectStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[effect]
            ?: return 0 // No stacks of this effect if null
    val actualCount = effectStacks.size
    repeat(actualCount) {
      val stack = effectStacks.removeLast()
      categoryStacks.remove(stack)
    }
    return actualCount
  }

  fun flip(category: BuffCategory, count: Int) {
    val targets =
        when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }
    val affected = targets.filter { it.effect.flipped != null }.takeLast(count)
    affected.forEach {
      actor.context.log("Buff") { "Flipped buff ${it.name}." }
      it.remove()
      add(null, it.effect.flipped!!, it.value, it.turns)
    }
  }

  fun getDisplayBuffs(): List<DisplayBuffData> =
      buildList {
            buffsByEffect.forEach { (effect, values) ->
              add(effect to (values.maxOfOrNull { it.turns } ?: 0))
            }
            positiveCountableBuffs.forEach { (effect, buffs) -> add(effect to buffs.size) }
            negativeCountableBuffs.forEach { (effect, buffs) -> add(effect to buffs.size) }
          }
          .filter { (_, value) -> value > 0 }
          .sortedByDescending { (effect, _) -> effect.displayPriority }
          .map { (effect, value) -> DisplayBuffData(effect.iconId, effect.isLocked, value) }

  fun tick() =
      actor.run {
        while (OverwhelmBuff in buffs) {
          buffs.remove(OverwhelmBuff)
        }

        val hpRegenValue = mod { +hpFixedRegen } + mod { maxHp ptmul hpPercentRegen }
        if (hpRegenValue > 0) {
          context.log("HP Regen") { "HP Regen tick." }
          heal(hpRegenValue)
        }

        val brillianceRegenValue = mod {
          brillianceRegen + context.stage.turn * brillianceRegenTurnScaling
        }
        if (brillianceRegenValue > 0) {
          context.log("Brilliance Regen") { "Brilliance Regen tick." }
          addBrilliance(brillianceRegenValue)
        }

        val brillianceSapValue = mod { +brillianceSap }
        if (brillianceSapValue > 0) {
          context.log("Brilliance Sap") { "Brilliance Sap tick." }
          addBrilliance(-brillianceSapValue)
        }

        val reviveRegenValue = mod { +reviveRegen }
        if (reviveRegenValue > 0) {
          context.log("Revive Regen") { "Revive Regen tick." }
          addCountable(Buffs.ReviveBuff, count = reviveRegenValue.toInt())
        }

        val superStrengthRegenValue = mod { +superStrengthRegen }
        if (superStrengthRegenValue > 0) {
          context.log("Super Strength Regen") { "Super Strength Regen tick." }
          addCountable(Buffs.SuperStrengthBuff, count = superStrengthRegenValue.toInt())
        }

        if (TurnRemoveContinuousNegativeEffectsBuff in buffs) {
          remove(BuffCategory.Negative)
        }

        if (TurnRemoveCountableNegativeEffectsBuff in buffs) {
          removeCountable(BuffCategory.Negative)
        }

        val turnReduceCountableNegativeEffects = mod { +turnReduceCountableNegativeEffects }
        if (turnReduceCountableNegativeEffects > 0) {
          removeCountable(BuffCategory.Negative, count = turnReduceCountableNegativeEffects.toInt())
        }

        positiveBuffs.tick()

        val burn = mod { +burnDamage }
        if (burn > 0) {
          context.log("Burn") { "Burn tick." }
          damage(burn, additionalEffects = false)
        }

        val poison = mod { +poisonDamage }
        if (poison > 0) {
          context.log("Poison") { "Poison tick." }
          damage(poison, additionalEffects = false)
        }

        val nightmare = mod { +nightmareDamage }
        if (nightmare > 0) {
          context.log("Nightmare") { "Nightmare tick." }
          damage(nightmare, additionalEffects = false)
        }

        //        if (TurnDispelCountablePositiveEffectsBuff in buffs) {
        //          removeCountable(BuffCategory.Positive)
        //        }

        val turnReduceCountablePositiveEffects = mod { +turnReduceCountablePositiveEffects }
        if (turnReduceCountablePositiveEffects > 0) {
          removeCountable(BuffCategory.Positive, count = turnReduceCountablePositiveEffects.toInt())
        }

        negativeBuffs.tick()

        if (actor.brilliance >= 100 || !actor.hasBrillianceBar) { // Bosses activate each turn
          actor.activateBlessings()
        }
      }

  private fun Collection<ContinuousBuffImpl<*>>.tick() {
    if (isEmpty()) return
    val toRemove = mutableListOf<ContinuousBuffImpl<*>>()
    for (buff in this) {
      if (--buff.turns <= 0) {
        toRemove += buff
      }
    }
    toRemove.forEach {
      it.remove()
      actor.context.log("Buff", debug = true) { "Buff ${it.name} expired." }
    }
  }

  private fun <T> startContinuousBuff(
      effect: ContinuousBuffEffect<T>,
      source: Actor?,
      value: I54,
      turns: Int,
  ) = ContinuousBuffImpl(effect, source, value, turns, effect.startEffect(source, value))

  private fun <T> ContinuousBuffEffect<T>.startEffect(
      source: Actor?,
      value: I54,
  ) = onStart(actor.context, value, source).also { related?.let { activatePsuedoBuff(it, value) } }

  private fun <T> ContinuousBuffEffect<T>.endEffect(
      source: Actor?,
      value: I54,
      data: T,
  ) =
      onEnd(actor.context, value, source, data).also {
        related?.let { removePseudoBuff(it, value) }
      }

  interface ContinuousBuff<T> {
    val effect: ContinuousBuffEffect<T>
    val source: Actor?
    val value: I54
    val turns: Int
    val data: T
    val originalTurns: Int
    val name: String

    fun updateValue(newValue: I54): ContinuousBuff<T>
    fun remove()
  }

  private inner class ContinuousBuffImpl<T>(
      override val effect: ContinuousBuffEffect<T>,
      override val source: Actor?,
      override val value: I54,
      override var turns: Int,
      override var data: T,
  ) : ContinuousBuff<T> {
    override val originalTurns = turns
    override val name
      get() = "${effect.formatName(value)} (${turns}/${originalTurns}t)"

    override fun updateValue(newValue: I54): ContinuousBuff<T> {
      effect.endEffect(source, value, data)
      data = effect.startEffect(source, newValue)
      return this
    }

    override fun remove() {
      val removed =
          when (effect.category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
          }.remove(this)
      require(removed) { "Buff is not active." }
      buffsByEffect[effect]!!.remove(this)
      effect.endEffect(source, value, data)
      actor.context.log("Buff", debug = true) { "Buff $name removed." }
    }
    override fun toString() =
        "[${effect.name}](value = $value, turns = ${if (turns >= 0) turns else "!"})"
  }
}

val consumeOnAttackCountableBuffs =
    listOf(
        Buffs.HopeBuff,
        Buffs.CheerBuff,
        Buffs.SuperStrengthBuff,
    )

class CountableBuffStack(
    val effect: CountableBuffEffect,
    val value: I54,
)

val countableBuffsByName =
    (Buffs.values.filterIsInstance<CountableBuffEffect>().associateBy { it.name.lowercase() } +
            mapOf(
                "impudence" to Buffs.ImpudenceBuff,
                "evade" to Buffs.EvasionBuff,
                "fort" to Buffs.FortitudeBuff,
            ))
        .toPlatformMap()

val abnormalCountableBuffs =
    platformSetOf(
        Buffs.DazeBuff,
        Buffs.ImpudenceBuff,
    )
