package xyz.qwewqa.relive.simulator.core.stage.actor

import kotlin.math.min
import xyz.qwewqa.relive.simulator.common.DisplayBuffData
import xyz.qwewqa.relive.simulator.core.stage.PlatformSet
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ActionRestrictionResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.OverwhelmBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.TurnDispelContinuousNegativeEffectsBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.TurnDispelCountableNegativeEffectsBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.abnormalBuffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.burnDamage
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.nightmareDamage
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.poisonDamage
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.TimedBuffEffect
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
  private val positiveBuffs = platformSetOf<TimedBuffImpl<*>>()
  private val negativeBuffs = platformSetOf<TimedBuffImpl<*>>()
  private val buffsByEffect = platformMapOf<TimedBuffEffect<*>, PlatformSet<TimedBuffImpl<*>>>()

  /**
   * We count these for checking whether a buff is active or not, but they are controlled by another
   * source, such as another buff (used for implementing locked versions of buffs) or stage effects.
   */
  private val pseudoBuffs = platformMapOf<TimedBuffEffect<*>, Int>()

  private val _effectNameMapping = platformMapOf<String, TimedBuffEffect<*>>()
  val effectNameMapping: Map<String, TimedBuffEffect<*>>
    get() = _effectNameMapping

  private val positiveCountableBuffs =
      platformMapOf<CountableBuffEffect, MutableList<CountableBuffStack>>()
  private val negativeCountableBuffs =
      platformMapOf<CountableBuffEffect, MutableList<CountableBuffStack>>()
  private val positiveCountableBuffStacks = mutableListOf<CountableBuffStack>()
  private val negativeCountableBuffStacks = mutableListOf<CountableBuffStack>()

  var guardOnAbnormal = false

  fun get(buff: TimedBuffEffect<*>): Set<TimedBuff<*>> = buffsByEffect[buff] ?: emptySet()
  fun all(): Set<TimedBuff<*>> = positiveBuffs + negativeBuffs
  fun timed(): Set<TimedBuff<*>> = positiveBuffs + negativeBuffs
  fun timedPositive(): Set<TimedBuff<*>> = positiveBuffs
  fun timedNegative(): Set<TimedBuff<*>> = negativeBuffs
  fun countablePositive(): Map<CountableBuffEffect, List<CountableBuffStack>> =
      positiveCountableBuffs
  fun countableNegative(): Map<CountableBuffEffect, List<CountableBuffStack>> =
      negativeCountableBuffs

  operator fun contains(buffEffect: TimedBuffEffect<*>) = count(buffEffect) > 0
  operator fun contains(buff: CountableBuffEffect) = count(buff) > 0
  fun count(buffEffect: TimedBuffEffect<*>) =
      (buffsByEffect[buffEffect]?.size ?: 0) + (pseudoBuffs[buffEffect] ?: 0)
  fun count(buff: CountableBuffEffect) =
      when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff]
      }?.size
          ?: 0

  private fun TimedBuffEffect<*>.activate(
      source: Actor?,
      value: Int,
      turns: Int,
  ) =
      startTimedBuff(this, source, value, turns).also { activeBuff ->
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

  fun activatePsuedoBuff(buffEffect: TimedBuffEffect<Unit>, value: Int = 0) {
    actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($value) added." }
    buffEffect.related?.let { activatePsuedoBuff(it, value) }
    pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) + 1
    buffEffect.onStart(actor.context, value, null)
  }

  fun updatePseudoBuff(buffEffect: TimedBuffEffect<Unit>, oldValue: Int, newValue: Int) {
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

  fun removePseudoBuff(buffEffect: TimedBuffEffect<Unit>, value: Int) {
    actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($value) removed." }
    buffEffect.related?.let { removePseudoBuff(it, value) }
    pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) - 1
    buffEffect.onEnd(actor.context, value, null, Unit)
  }

  fun add(source: Actor?, buffEffect: TimedBuffEffect<*>, value: Int, turns: Int): TimedBuff<*>? {
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
      add(null, ActionRestrictionResistanceUpBuff, 100, 9)
    }
    return buff
  }

  fun addCountable(buff: CountableBuffEffect, count: Int = 1, value: Int = 0) {
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
      add(null, ActionRestrictionResistanceUpBuff, 100, 9)
    }
  }

  fun remove(buff: CountableBuffEffect): Int {
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
      "Countable buff ${buff.name}${if (value != 0) " ($value)" else ""} removed (prev: $prevCount, new: ${prevCount - 1})."
    }
    return value
  }

  fun getNext(buff: CountableBuffEffect): Int? {
    val stacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[buff]
    return stacks?.lastOrNull()?.value
  }

  inline fun consumeOnce(buff: CountableBuffEffect, action: (Int) -> Unit = {}): Boolean {
    if (count(buff) == 0) {
      return false
    }
    action(remove(buff))
    return true
  }

  inline fun consumeAll(buff: CountableBuffEffect, action: (Int) -> Unit = {}): Boolean {
    val count = count(buff)
    if (count == 0) {
      return false
    }
    repeat(count) { action(remove(buff)) }
    return true
  }

  inline fun consumeUpTo(buff: CountableBuffEffect, max: Int, action: (Int) -> Unit = {}): Boolean {
    val count = count(buff)
    if (count == 0) {
      return false
    }
    repeat(count.coerceAtMost(max)) { action(remove(buff)) }
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

  fun removeAll(buffEffect: TimedBuffEffect<*>) {
    (buffsByEffect[buffEffect] ?: return).toList().forEach { it.remove() }
  }

  fun dispel(category: BuffCategory) {
    when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }
        .filter { !it.effect.isLocked }
        .forEach { it.remove() }
  }

  fun dispelCountable(category: BuffCategory) {
    when (category) {
      BuffCategory.Positive -> positiveCountableBuffs
      BuffCategory.Negative -> negativeCountableBuffs
    }.let { buffs -> buffs.keys.forEach { if (!it.isLocked) buffs[it]!!.clear() } }
  }

  fun dispelCountable(category: BuffCategory, count: Int): Int {
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

  fun dispelCountable(effect: CountableBuffEffect, count: Int): Int {
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

  fun dispelCountable(effect: CountableBuffEffect): Int {
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

        val hpRegenValue = mod { +hpFixedRegen } + mod { maxHp pfmul hpPercentRegen }
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
          addCountable(Buffs.ReviveBuff, count = reviveRegenValue)
        }

        val superStrengthRegenValue = mod { +superStrengthRegen }
        if (superStrengthRegenValue > 0) {
          context.log("Super Strength Regen") { "Super Strength Regen tick." }
          addCountable(Buffs.SuperStrengthBuff, count = superStrengthRegenValue)
        }

        if (TurnDispelContinuousNegativeEffectsBuff in buffs) {
          dispel(BuffCategory.Negative)
        }

        if (TurnDispelCountableNegativeEffectsBuff in buffs) {
          dispelCountable(BuffCategory.Negative)
        }

        val turnReduceCountableNegativeEffects = mod { +turnReduceCountableNegativeEffects }
        if (turnReduceCountableNegativeEffects > 0) {
          dispelCountable(BuffCategory.Negative, count = turnReduceCountableNegativeEffects)
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
        //          dispelCountable(BuffCategory.Positive)
        //        }

        val turnReduceCountablePositiveEffects = mod { +turnReduceCountablePositiveEffects }
        if (turnReduceCountablePositiveEffects > 0) {
          dispelCountable(BuffCategory.Positive, count = turnReduceCountablePositiveEffects)
        }

        negativeBuffs.tick()

        if (actor.brilliance >= 100 || !actor.hasBrillianceBar) { // Bosses activate each turn
          actor.activateBlessings()
        }
      }

  private fun Collection<TimedBuffImpl<*>>.tick() {
    if (isEmpty()) return
    val toRemove = mutableListOf<TimedBuffImpl<*>>()
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

  private fun <T> startTimedBuff(
      effect: TimedBuffEffect<T>,
      source: Actor?,
      value: Int,
      turns: Int,
  ) = TimedBuffImpl(effect, source, value, turns, effect.startEffect(source, value))

  private fun <T> TimedBuffEffect<T>.startEffect(
      source: Actor?,
      value: Int,
  ) = onStart(actor.context, value, source).also { related?.let { activatePsuedoBuff(it, value) } }

  private fun <T> TimedBuffEffect<T>.endEffect(
      source: Actor?,
      value: Int,
      data: T,
  ) =
      onEnd(actor.context, value, source, data).also {
        related?.let { removePseudoBuff(it, value) }
      }

  interface TimedBuff<T> {
    val effect: TimedBuffEffect<T>
    val source: Actor?
    val value: Int
    val turns: Int
    val data: T
    val originalTurns: Int
    val name: String

    fun updateValue(newValue: Int): TimedBuff<T>
    fun remove()
  }

  private inner class TimedBuffImpl<T>(
      override val effect: TimedBuffEffect<T>,
      override val source: Actor?,
      override val value: Int,
      override var turns: Int,
      override var data: T,
  ) : TimedBuff<T> {
    override val originalTurns = turns
    override val name
      get() = "${effect.formatName(value)} (${turns}/${originalTurns}t)"

    override fun updateValue(newValue: Int): TimedBuff<T> {
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
    val value: Int,
)

val countableBuffsByName =
    (Buffs.values.filterIsInstance<CountableBuffEffect>().associateBy { it.name.lowercase() } +
            mapOf(
                "impudence" to Buffs.ImpudenceBuff,
                "evade" to Buffs.EvasionBuff,
                "fort" to Buffs.Fortitude,
            ))
        .toPlatformMap()

val abnormalCountableBuffs =
    platformSetOf(
        Buffs.DazeBuff,
        Buffs.ImpudenceBuff,
    )
