package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.common.DisplayBuffData
import xyz.qwewqa.relive.simulator.core.stage.*
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.modifier.brillianceRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.hpFixedRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.hpPercentRegen
import xyz.qwewqa.relive.simulator.core.stage.modifier.reviveRegen
import xyz.qwewqa.relive.simulator.stage.character.Position
import kotlin.math.min


class BuffManager(val actor: Actor) {
    private val positiveBuffs = platformSetOf<TimedBuffImpl<*>>()
    private val negativeBuffs = platformSetOf<TimedBuffImpl<*>>()
    private val buffsByEffect = platformMapOf<TimedBuffEffect<*>, PlatformSet<TimedBuffImpl<*>>>()

    /**
     * We count these for checking whether a buff is active or not, but they are controlled by another source,
     * such as another buff (used for implementing locked versions of buffs) or stage effects.
     */
    private val pseudoBuffs = platformMapOf<TimedBuffEffect<*>, Int>()

    private val _effectNameMapping = platformMapOf<String, TimedBuffEffect<*>>()
    val effectNameMapping: Map<String, TimedBuffEffect<*>> get() = _effectNameMapping

    private val positiveCountableBuffs = platformMapOf<CountableBuff, MutableList<CountableBuffStack>>()
    private val negativeCountableBuffs = platformMapOf<CountableBuff, MutableList<CountableBuffStack>>()
    private val positiveCountableBuffStacks = mutableListOf<CountableBuffStack>()
    private val negativeCountableBuffStacks = mutableListOf<CountableBuffStack>()

    var guardOnAbnormal = false

    fun get(buff: TimedBuffEffect<*>): Set<TimedBuff<*>> = buffsByEffect[buff] ?: emptySet()
    fun all(): Set<TimedBuff<*>> = positiveBuffs + negativeBuffs
    fun timed(): Set<TimedBuff<*>> = positiveBuffs + negativeBuffs
    fun timedPositive(): Set<TimedBuff<*>> = positiveBuffs
    fun timedNegative(): Set<TimedBuff<*>> = negativeBuffs
    fun countablePositive(): Map<CountableBuff, List<CountableBuffStack>> = positiveCountableBuffs
    fun countableNegative(): Map<CountableBuff, List<CountableBuffStack>> = negativeCountableBuffs

    operator fun contains(buffEffect: TimedBuffEffect<*>) = count(buffEffect) > 0
    operator fun contains(buff: CountableBuff) = count(buff) > 0
    fun count(buffEffect: TimedBuffEffect<*>) = (buffsByEffect[buffEffect]?.size ?: 0) + (pseudoBuffs[buffEffect] ?: 0)
    fun count(buff: CountableBuff) = when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff]
    }?.size ?: 0

    private fun TimedBuffEffect<*>.activate(
        source: Actor?,
        value: Int,
        turns: Int,
    ) = startTimedBuff(this, source, value, turns).also { activeBuff ->
        when (category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }.addQuick(activeBuff)
        buffsByEffect.getOrPut(this) {
            _effectNameMapping[name] = this
            platformSetOf()
        }.addQuick(activeBuff)
        actor.context.log("Buff", debug = true) { "Buff ${activeBuff.name} added." }
    }

    fun activatePsuedoBuff(buffEffect: TimedBuffEffect<Unit>, value: Int = 0) {
        actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($value) added." }
        pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) + 1
        buffEffect.onStart(actor.context, value, null)
    }

    fun updatePseudoBuff(buffEffect: TimedBuffEffect<Unit>, oldValue: Int, newValue: Int) {
        if (oldValue == newValue) {
            return
        }
        actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($oldValue -> $newValue) updated." }
        buffEffect.onEnd(actor.context, oldValue, null, Unit)
        buffEffect.onStart(actor.context, newValue, null)
    }

    fun removePseudoBuff(buffEffect: TimedBuffEffect<Unit>, value: Int) {
        actor.context.log("Buff", debug = true) { "Pseudo buff ${buffEffect.name} ($value) removed." }
        pseudoBuffs[buffEffect] = (pseudoBuffs[buffEffect] ?: 0) - 1
        buffEffect.onEnd(actor.context, value, null, Unit)
    }

    fun add(source: Actor?, buffEffect: TimedBuffEffect<*>, value: Int, turns: Int): TimedBuff<*>? {
        require(turns >= 0) { "Buff turns should not be negative." }
        if (buffEffect.exclusive) {
            val existing = get(buffEffect).singleOrNull()
            if (existing != null) {
                if (value > existing.value || turns > existing.turns) {
                    actor.context.log("Buff") { "Exclusive buff ${buffEffect.formatName(turns)} (${turns}t) overrides existing $existing." }
                    existing.remove()
                } else {
                    actor.context.log("Buff") { "Exclusive buff ${buffEffect.formatName(turns)} (${turns}t) blocked by existing $existing." }
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

    fun addCountable(buff: CountableBuff, count: Int = 1, value: Int = 0) {
        val categoryStacks = when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffStacks
            BuffCategory.Negative -> negativeCountableBuffStacks
        }
        val effectStacks = when (buff.category) {
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

    fun remove(buff: CountableBuff): Int {
        val categoryStacks = when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffStacks
            BuffCategory.Negative -> negativeCountableBuffStacks
        }
        val stacks = when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }[buff]
        if (stacks == null || stacks.size == 0) error("Cannot remove countable buff $buff which is already at zero stacks.")
        val prevCount = stacks.size
        val stack = stacks.removeLast()
        categoryStacks.remove(stack)
        val value = stack.value
        actor.context.log("Buff") { "Countable buff ${buff.name}${if (value != 0) " ($value)" else ""} removed (prev: $prevCount, new: ${prevCount - 1})." }
        return value
    }

    fun getNext(buff: CountableBuff): Int? {
        val stacks = when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }[buff]
        return stacks?.lastOrNull()?.value
    }

    inline fun consumeOnce(buff: CountableBuff, action: (Int) -> Unit = {}): Boolean {
        if (count(buff) == 0) {
            return false
        }
        action(remove(buff))
        return true
    }

    inline fun consumeAll(buff: CountableBuff, action: (Int) -> Unit = {}): Boolean {
        val count = count(buff)
        if (count == 0) {
            return false
        }
        repeat(count) {
            action(remove(buff))
        }
        return true
    }

    inline fun consumeUpTo(buff: CountableBuff, max: Int, action: (Int) -> Unit = {}): Boolean {
        val count = count(buff)
        if (count == 0) {
            return false
        }
        repeat(count.coerceAtMost(max)) {
            action(remove(buff))
        }
        return true
    }

    fun tryRemove(buff: CountableBuff) = if (count(buff) > 0) {
        remove(buff)
        true
    } else {
        false
    }

    /**
     * Remove all non-ephemeral buffs.
     */
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
        }.filter { !it.effect.isLocked }.forEach { it.remove() }
    }

    fun dispelCountable(category: BuffCategory) {
        when (category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }.clear()
    }

    fun dispelCountable(category: BuffCategory, count: Int) {
        val categoryStacks = when (category) {
            BuffCategory.Positive -> positiveCountableBuffStacks
            BuffCategory.Negative -> negativeCountableBuffStacks
        }
        val stacks = when (category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }
        val targets = categoryStacks.takeLast(count)
        targets.forEach { stack ->
            val effectStacks = stacks[stack.effect]!!
            effectStacks.removeAt(effectStacks.lastIndexOf(stack))
        }
        repeat(targets.size) {
            categoryStacks.removeLast()
        }
    }

    fun dispelCountable(effect: CountableBuff, count: Int) {
        val categoryStacks = when (effect.category) {
            BuffCategory.Positive -> positiveCountableBuffStacks
            BuffCategory.Negative -> negativeCountableBuffStacks
        }
        val effectStacks = when (effect.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }[effect] ?: return  // No stacks of this effect if null
        repeat(min(count, effectStacks.size)) {
            val stack = effectStacks.removeLast()
            categoryStacks.remove(stack)
        }
    }

    fun flip(category: BuffCategory, count: Int) {
        val targets = when (category) {
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

    fun getDisplayBuffs(): List<DisplayBuffData> = buildList {
        buffsByEffect.forEach { (effect, values) ->
            add(effect to (values.maxOfOrNull { it.turns } ?: 0))
        }
        positiveCountableBuffs.forEach { (effect, buffs) ->
            add(effect to buffs.size)
        }
        negativeCountableBuffs.forEach { (effect, buffs) ->
            add(effect to buffs.size)
        }
    }.filter { (_, value) ->
        value > 0
    }.sortedByDescending { (effect, _) ->
        effect.displayPriority
    }.map { (effect, value) ->
        DisplayBuffData(effect.iconId, effect.isLocked, value)
    }

    fun tick() = actor.run {
        val hpRegenValue = mod { +hpFixedRegen } + mod { maxHp pfmul hpPercentRegen }
        if (hpRegenValue > 0) {
            context.log("HP Regen") { "HP Regen tick." }
            heal(hpRegenValue)
        }

        val brillianceRegenValue = mod { +brillianceRegen }
        if (brillianceRegenValue > 0) {
            context.log("Brilliance Regen") { "Brilliance Regen tick." }
            addBrilliance(brillianceRegenValue)
        }

        val reviveRegenValue = mod { +reviveRegen }
        if (reviveRegenValue > 0) {
            context.log("Revive Regen") { "Revive Regen tick." }
            addCountable(CountableBuff.Revive, count = reviveRegenValue)
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

        negativeBuffs.tick()

        if (actor.brilliance >= 100 || actor.dress.position == Position.None) {  // Bosses activate each turn
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
    ) = onStart(actor.context, value, source).also {
        related?.let { activatePsuedoBuff(it, value) }
    }

    private fun <T> TimedBuffEffect<T>.endEffect(
        source: Actor?,
        value: Int,
        data: T,
    ) = onEnd(actor.context, value, source, data).also {
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

    private inner class TimedBuffImpl<T> (
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
            val removed = when (effect.category) {
                BuffCategory.Positive -> positiveBuffs
                BuffCategory.Negative -> negativeBuffs
            }.remove(this)
            require(removed) { "Buff is not active." }
            buffsByEffect[effect]!!.remove(this)
            effect.endEffect(source, value, data)
            actor.context.log("Buff", debug = true) { "Buff $name removed." }
        }
        override fun toString() = "[${effect.name}](value = $value, turns = ${if (turns >= 0) turns else "!"})"
    }
}

enum class CountableBuff(
    override val category: BuffCategory,
    override val iconId: Int,
) : CountableBuffEffect {
    Evasion(BuffCategory.Positive, 27),
    Fortitude(BuffCategory.Positive, 29),
    Revive(BuffCategory.Positive, 164),
    InvincibleRebirth(BuffCategory.Positive, 265),
    Daze(BuffCategory.Negative, 167),
    Pride(BuffCategory.Negative, 168),
    Hope(BuffCategory.Positive, 169),
    WeakSpot(BuffCategory.Negative, 170),
    DisasterBrillianceReduction(BuffCategory.Negative, 254),
    BlessingHpRecovery(BuffCategory.Positive, 255),
    BlessingCountableDebuffReduction(BuffCategory.Positive, 256),
    DisasterDaze(BuffCategory.Negative, 257),
    BlessingContinuousDebuffRemoval(BuffCategory.Positive, 258),
    BlessingHope(BuffCategory.Positive, 260),
    BlessingEffectiveDamage(BuffCategory.Positive, 264),
    DisasterApUp(BuffCategory.Negative, 267),
    BlessingAp2Down(BuffCategory.Positive, 268),
    Cheer(BuffCategory.Positive, 282),
}

val consumeOnAttackCountableBuffs = listOf(
    CountableBuff.Hope,
    CountableBuff.Cheer,
)

class CountableBuffStack(
    val effect: CountableBuff,
    val value: Int,
)

val countableBuffsByName = (CountableBuff.values().associateBy { it.name.lowercase() } + mapOf(
    "impudence" to CountableBuff.Pride,
    "evade" to CountableBuff.Evasion,
    "fort" to CountableBuff.Fortitude,
)).toPlatformMap()

val abnormalCountableBuffs = platformSetOf(
    CountableBuff.Daze,
    CountableBuff.Pride,
)
