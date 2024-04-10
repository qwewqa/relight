package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.common.DisplayBuffData
import xyz.qwewqa.relive.simulator.core.i54.I54
import xyz.qwewqa.relive.simulator.core.i54.i54
import xyz.qwewqa.relive.simulator.core.stage.PlatformMap
import xyz.qwewqa.relive.simulator.core.stage.PlatformSet
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ActionRestrictionResistanceUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.IntimidationBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.OverwhelmBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.TurnRemoveContinuousNegativeEffectsBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.TurnRemoveCountableNegativeEffectsBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.abnormalBuffs
import xyz.qwewqa.relive.simulator.core.stage.buff.ContinuousBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.CountableBuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.activateBlessings
import xyz.qwewqa.relive.simulator.core.stage.buff.displayPriority
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.platformMapOf
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf
import xyz.qwewqa.relive.simulator.core.stage.toPlatformMap
import kotlin.math.min

data class ContinuousBuffDetails(
    val effect: ContinuousBuffEffect<*>,
    val value: I54,
    val turns: Int,
)

data class CountableBuffDetails(
    val effect: CountableBuffEffect,
    val value: I54,
)

val BUFF_GROUP_LEVEL_COUNT = 2

class BuffManager(val actor: Actor) {
  private val positiveBuffs =
      platformMapOf<Int, PlatformSet<ContinuousBuffImpl<*>>>().apply {
        (1..BUFF_GROUP_LEVEL_COUNT).forEach { this[it] = platformSetOf() }
      }
  private val negativeBuffs =
      platformMapOf<Int, PlatformSet<ContinuousBuffImpl<*>>>().apply {
        (1..BUFF_GROUP_LEVEL_COUNT).forEach { this[it] = platformSetOf() }
      }
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
      platformMapOf<Int, PlatformMap<CountableBuffEffect, MutableList<CountableBuffStack>>>()
          .apply { (1..BUFF_GROUP_LEVEL_COUNT).forEach { this[it] = platformMapOf() } }
  private val negativeCountableBuffs =
      platformMapOf<Int, PlatformMap<CountableBuffEffect, MutableList<CountableBuffStack>>>()
          .apply { (1..BUFF_GROUP_LEVEL_COUNT).forEach { this[it] = platformMapOf() } }
  private val positiveCountableBuffStacks = platformMapOf<Int, MutableList<CountableBuffStack>>().apply {
    (1..BUFF_GROUP_LEVEL_COUNT).forEach { this[it] = mutableListOf() }
  }
  private val negativeCountableBuffStacks = platformMapOf<Int, MutableList<CountableBuffStack>>().apply {
    (1..BUFF_GROUP_LEVEL_COUNT).forEach { this[it] = mutableListOf() }
  }

  var guardOnAbnormal = false

  fun get(buff: ContinuousBuffEffect<*>): Set<ContinuousBuff<*>> = buffsByEffect[buff] ?: emptySet()
  fun continuousPositive(): Set<ContinuousBuff<*>> = positiveBuffs.values.flatten().toSet()
  fun continuousNegative(): Set<ContinuousBuff<*>> = negativeBuffs.values.flatten().toSet()
  fun countablePositive(): Map<CountableBuffEffect, List<CountableBuffStack>> =
      platformMapOf<CountableBuffEffect, List<CountableBuffStack>>().also { results ->
        positiveCountableBuffs.values.forEach { results.putAll(it) }
      }
  fun countableNegative(): Map<CountableBuffEffect, List<CountableBuffStack>> =
      platformMapOf<CountableBuffEffect, List<CountableBuffStack>>().also { results ->
        negativeCountableBuffs.values.forEach { results.putAll(it) }
      }

  operator fun contains(buffEffect: ContinuousBuffEffect<*>) = count(buffEffect) > 0
  operator fun contains(buff: CountableBuffEffect) = count(buff) > 0
  fun count(buffEffect: ContinuousBuffEffect<*>) =
      (buffsByEffect[buffEffect]?.size ?: 0) + (pseudoBuffs[buffEffect] ?: 0)
  fun count(buff: CountableBuffEffect) =
      when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff.groupLevel]!![buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff.groupLevel]!![buff]
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
            }[groupLevel]!!
            .addQuick(activeBuff)
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
    buffEffect.onStart(actor.context, value, null)
    pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) + 1
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
        }[buff.groupLevel]!!
    val effectStacks =
        when (buff.category) {
              BuffCategory.Positive -> positiveCountableBuffs
              BuffCategory.Negative -> negativeCountableBuffs
            }[buff.groupLevel]!!
            .getOrPut(buff) { mutableListOf() }
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

  fun removeLast(buff: CountableBuffEffect): I54 {
    val categoryStacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }[buff.groupLevel]!!
    val stacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[buff.groupLevel]!![buff]
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

  fun removeFirst(buff: CountableBuffEffect): I54 {
    val categoryStacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }[buff.groupLevel]!!
    val stacks =
        when (buff.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[buff.groupLevel]!![buff]
    if (stacks == null || stacks.size == 0)
        error("Cannot remove countable buff $buff which is already at zero stacks.")
    val prevCount = stacks.size
    val stack = stacks.removeFirst()
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
        }[buff.groupLevel]!![buff]
    return stacks?.lastOrNull()?.value
  }

  inline fun consumeOnce(buff: CountableBuffEffect, action: (I54) -> Unit = {}): Boolean {
    if (count(buff) == 0) {
      return false
    }
    action(removeFirst(buff))
    return true
  }

  inline fun consumeAll(buff: CountableBuffEffect, action: (I54) -> Unit = {}): Boolean {
    val count = count(buff)
    if (count == 0) {
      return false
    }
    repeat(count) { action(removeFirst(buff)) }
    return true
  }

  inline fun consumeUpTo(buff: CountableBuffEffect, max: Int, action: (I54) -> Unit = {}): Boolean {
    val count = count(buff)
    if (count == 0) {
      return false
    }
    repeat(count.coerceAtMost(max)) { action(removeFirst(buff)) }
    return true
  }

  fun tryRemove(buff: CountableBuffEffect) =
      if (count(buff) > 0) {
        removeLast(buff)
        true
      } else {
        false
      }

  /** Remove all non-ephemeral buffs. */
  fun clear() {
    positiveBuffs.values.forEach { level -> level.toList().forEach { it.remove() } }
    negativeBuffs.values.forEach { level -> level.toList().forEach { it.remove() } }
    positiveCountableBuffs.values.forEach { it.clear() }
    negativeCountableBuffs.values.forEach { it.clear() }
  }

  fun removeAll(buffEffect: ContinuousBuffEffect<*>) {
    (buffsByEffect[buffEffect] ?: return).toList().forEach { it.remove() }
  }

  fun remove(category: BuffCategory, groupLevel: Int = 1) {
    when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }[groupLevel]!!
        .filter { !it.effect.isLocked }
        .forEach { it.remove() }
  }

  fun adjustContinuousTurns(category: BuffCategory, delta: Int, groupLevel: Int = 1) {
    val buffs =
        when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }[groupLevel]!!
    buffs.forEach { it.turns = (it.turns + delta).coerceAtLeast(0) }
    if (delta < 0) {
      buffs.filter { it.turns == 0 }.forEach { it.remove() }
    }
  }

  fun removeCountable(category: BuffCategory, groupLevel: Int = 1) {
    val stacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[groupLevel]!!
    stacks.keys.forEach { if (!it.isLocked) stacks[it]!!.clear() }
  }

  fun increaseCountable(category: BuffCategory, count: Int, groupLevel: Int = 1) {
    val stacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[groupLevel]!!
    // TODO: Test how this works for countables that can have different values
    stacks.values.forEach {
      it.lastOrNull()?.let { buff ->
        addCountable(buff = buff.effect, count = count, value = buff.value)
      }
    }
  }

  fun removeCountables(category: BuffCategory, count: Int, groupLevel: Int = 1): Int {
    val categoryStacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }[groupLevel]!!
    val stacks =
        when (category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[groupLevel]!!
    val targets = categoryStacks.takeLast(count)
    targets.forEach { stack ->
      val effectStacks = stacks[stack.effect]!!
      effectStacks.removeAt(effectStacks.lastIndexOf(stack))
    }
    repeat(targets.size) { categoryStacks.removeLast() }
    return targets.size
  }

  fun removeCountables(effect: CountableBuffEffect, count: Int, groupLevel: Int = 1): Int {
    val categoryStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }[groupLevel]!!
    val effectStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[groupLevel]!![effect]
            ?: return 0 // No stacks of this effect if null
    val actualCount = min(count, effectStacks.size)
    repeat(actualCount) {
      val stack = effectStacks.removeLast()
      categoryStacks.remove(stack)
    }
    return actualCount
  }

  fun removeCountable(effect: CountableBuffEffect, groupLevel: Int = 1): Int {
    val categoryStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffStacks
          BuffCategory.Negative -> negativeCountableBuffStacks
        }[groupLevel]!!
    val effectStacks =
        when (effect.category) {
          BuffCategory.Positive -> positiveCountableBuffs
          BuffCategory.Negative -> negativeCountableBuffs
        }[groupLevel]!![effect]
            ?: return 0 // No stacks of this effect if null
    val actualCount = effectStacks.size
    repeat(actualCount) {
      val stack = effectStacks.removeLast()
      categoryStacks.remove(stack)
    }
    return actualCount
  }

  fun flip(category: BuffCategory, count: Int, groupLevel: Int = 1) {
    val targets =
        when (category) {
          BuffCategory.Positive -> positiveBuffs
          BuffCategory.Negative -> negativeBuffs
        }[groupLevel]!!
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
            positiveCountableBuffs.values.forEach { level ->
              level.forEach { (effect, buffs) -> add(effect to buffs.size) }
            }
            negativeCountableBuffs.values.forEach { level ->
              level.forEach { (effect, buffs) -> add(effect to buffs.size) }
            }
          }
          .filter { (_, value) -> value > 0 }
          .sortedByDescending { (effect, _) -> effect.displayPriority }
          .map { (effect, value) -> DisplayBuffData(effect.iconId, effect.isLocked, value) }

  fun tick() =
      actor.run {
        while (OverwhelmBuff in buffs) {
          buffs.removeLast(OverwhelmBuff)
        }
        while (IntimidationBuff in buffs) {
          buffs.removeLast(IntimidationBuff)
        }

        val hpRegenValue = mod { +Modifier.HpRegen } + mod { maxHp ptmul Modifier.HpPercentRegen }
        if (hpRegenValue > 0) {
          context.log("HP Regen") { "HP Regen tick." }
          heal(hpRegenValue)
        }

        val brillianceRegenValue = mod {
          Modifier.BrillianceRegen + context.stage.turn * Modifier.BrillianceRegenTurnScaling
        }
        if (brillianceRegenValue > 0) {
          context.log("Brilliance Regen") { "Brilliance Regen tick." }
          addBrilliance(brillianceRegenValue)
        }

        val brillianceSapValue = mod { +Modifier.BrillianceSap }
        if (brillianceSapValue > 0) {
          context.log("Brilliance Sap") { "Brilliance Sap tick." }
          addBrilliance(-brillianceSapValue)
        }

        val reviveRegenValue = mod { +Modifier.ReviveRegen }
        if (reviveRegenValue > 0) {
          context.log("Revive Regen") { "Revive Regen tick." }
          addCountable(Buffs.ReviveBuff, count = reviveRegenValue.toInt())
        }

        val superStrengthRegenValue = mod { +Modifier.SuperStrengthRegen }
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

        val turnReduceCountableNegativeEffects = mod {
          +Modifier.TurnReduceCountableNegativeEffects
        }
        if (turnReduceCountableNegativeEffects > 0) {
          removeCountables(BuffCategory.Negative, count = turnReduceCountableNegativeEffects.toInt())
        }

        positiveBuffs.values.forEach { it.tick() }

        val burn = mod { +Modifier.BurnDamage }
        if (burn > 0) {
          context.log("Burn") { "Burn tick." }
          damage(burn, additionalEffects = false)
        }

        val poison = mod { +Modifier.PoisonDamage }
        if (poison > 0) {
          context.log("Poison") { "Poison tick." }
          damage(poison, additionalEffects = false)
        }

        val nightmare = mod { +Modifier.NightmareDamage }
        if (nightmare > 0) {
          context.log("Nightmare") { "Nightmare tick." }
          damage(nightmare, additionalEffects = false)
        }

        //        if (TurnDispelCountablePositiveEffectsBuff in buffs) {
        //          removeCountable(BuffCategory.Positive)
        //        }

        val weakenCoef = mod { +Modifier.Weaken }
        if (weakenCoef > 0) {
          context.log("Weaken") { "Weaken tick." }
          damage((maxHp ptmul weakenCoef).toI54(), additionalEffects = false)
        }

        val turnReduceCountablePositiveEffects = mod {
          +Modifier.TurnReduceCountablePositiveEffects
        }
        if (turnReduceCountablePositiveEffects > 0) {
          removeCountables(BuffCategory.Positive, count = turnReduceCountablePositiveEffects.toInt())
        }

        val continuousPositiveTurnReductionRegenTurns = mod {
          +Modifier.ContinuousPositiveTurnReductionRegen
        }
        if (continuousPositiveTurnReductionRegenTurns > 0) {
          buffs.adjustContinuousTurns(
              BuffCategory.Positive, -continuousPositiveTurnReductionRegenTurns.toInt())
        }

        negativeBuffs.values.forEach { it.tick() }

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
              }[effect.groupLevel]!!
              .remove(this)
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
        listOf(Buffs.HopeBuff, Buffs.GreaterHopeBuff),
        listOf(Buffs.CheerBuff),
        listOf(Buffs.SuperStrengthBuff, Buffs.GreaterSuperStrengthBuff),
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
        Buffs.DelusionBuff,
    )
