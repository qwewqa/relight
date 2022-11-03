package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.common.DisplayBuffData
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.log
import xyz.qwewqa.relive.simulator.stage.character.Position
import kotlin.math.min

expect fun activeBuffSet(): MutableSet<ActiveBuff>
expect fun <V> buffEffectMap(): MutableMap<TimedBuffEffect, V>
expect fun countableBuffMap(): MutableMap<CountableBuff, MutableList<CountableBuffStack>>

class BuffManager(val actor: Actor) {
    private val positiveBuffs = activeBuffSet()
    private val negativeBuffs = activeBuffSet()
    private val buffsByEffect = buffEffectMap<MutableSet<ActiveBuff>>()

    private val _effectNameMapping = mutableMapOf<String, TimedBuffEffect>()
    val effectNameMapping: Map<String, TimedBuffEffect> get() = _effectNameMapping

    private val positiveCountableBuffs = countableBuffMap()
    private val negativeCountableBuffs = countableBuffMap()
    private val positiveCountableBuffStacks = mutableListOf<CountableBuffStack>()
    private val negativeCountableBuffStacks = mutableListOf<CountableBuffStack>()

    var guardOnAbnormal = false

    fun get(buff: TimedBuffEffect) = buffsByEffect[buff] ?: emptySet()
    fun all() = positiveBuffs + negativeBuffs
    fun timed(): Set<ActiveBuff> = positiveBuffs + negativeBuffs
    fun timedPositive(): Set<ActiveBuff> = positiveBuffs
    fun timedNegative(): Set<ActiveBuff> = negativeBuffs
    fun countablePositive(): Map<CountableBuff, List<CountableBuffStack>> = positiveCountableBuffs
    fun countableNegative(): Map<CountableBuff, List<CountableBuffStack>> = negativeCountableBuffs

    // Note that this can be slow if called very frequently (e.g. in the damage formula)
    // In those cases it is better to increment/decrement a variable on the actor in the buff and then check it directly
    fun any(vararg buffEffect: TimedBuffEffect) = buffEffect.any { any(it) }
    fun any(buffEffect: TimedBuffEffect) = count(buffEffect) > 0
    fun any(buff: CountableBuff) = count(buff) > 0
    fun count(buffEffect: TimedBuffEffect) = buffsByEffect[buffEffect]?.size ?: 0
    fun count(buff: CountableBuff) = when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff]
    }?.size ?: 0

    fun TimedBuffEffect.activate(
        source: Actor?,
        value: Int,
        turns: Int,
        ephemeral: Boolean = false,
        relatedBuff: ActiveBuff? = null
    ) =
        ActiveBuff(this, value, turns, ephemeral, relatedBuff).also { activeBuff ->
            onApply(source, actor)
            activeBuff.start()
            when (category) {
                BuffCategory.Positive -> positiveBuffs
                BuffCategory.Negative -> negativeBuffs
            }.add(activeBuff)
            buffsByEffect.getOrPut(this) {
                _effectNameMapping[name] = this
                activeBuffSet()
            }.add(activeBuff)
            actor.context.log("Buff", debug = true) { "Buff ${activeBuff.name} added." }
        }

    /**
     * Adds a buff without normal exclusivity checks or turn expiry.
     * Intended for stage effects and locked buffs.
     * Removed like normal buffs using the [remove] method.
     */
    fun addEphemeral(source: Actor?, buffEffect: TimedBuffEffect, value: Int): ActiveBuff {
        return buffEffect.activate(source, value, -1, true)
    }

    fun add(source: Actor?, buffEffect: TimedBuffEffect, value: Int, turns: Int): ActiveBuff? {
        require(turns >= 0) { "Buff turns should not be negative." }
        if (buffEffect.exclusive) {
            val existing = get(buffEffect).singleOrNull { !it.ephemeral }
            if (existing != null) {
                if (turns > existing.turns) {
                    actor.context.log("Buff") { "Exclusive buff ${buffEffect.formatName(turns)} (${turns}t) overrides existing $existing." }
                    remove(existing)
                } else {
                    actor.context.log("Buff") { "Exclusive buff ${buffEffect.formatName(turns)} (${turns}t) blocked by existing $existing." }
                    return null
                }
            }
        }
        val relatedBuff = buffEffect.related?.let { related ->
            addEphemeral(source, related, value)
        }
        val buff = buffEffect.activate(source, value, turns, relatedBuff = relatedBuff)
        if (guardOnAbnormal && buffEffect in abnormalBuffs) {
            actor.context.log("Buff") { "Abnormal Guard activated." }
            add(null, AbnormalGuardBuff, 100, 9)
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
            add(null, AbnormalGuardBuff, 100, 9)
        }
    }

    fun remove(buff: ActiveBuff) {
        val removed = when (buff.effect.category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }.remove(buff)
        require(removed) { "Buff is not active." }
        buffsByEffect[buff.effect]!!.remove(buff)
        buff.end()
        if (buff.relatedBuff != null) {
            remove(buff.relatedBuff)
        }
        actor.context.log("Buff", debug = true) { "Buff ${buff.name} removed." }
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
        positiveBuffs.filter { !it.ephemeral }.forEach { remove(it) }
        negativeBuffs.filter { !it.ephemeral }.forEach { remove(it) }
        positiveCountableBuffs.clear()
        negativeCountableBuffs.clear()
    }

    fun removeAll(buffEffect: TimedBuffEffect) {
        (buffsByEffect[buffEffect] ?: return).toList().forEach { remove(it) }
    }

    fun dispel(category: BuffCategory) {
        when (category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }.filter { !it.ephemeral && !it.effect.isLocked }.forEach { remove(it) }
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
        val affected = targets.filter { it.effect.flipped != null && !it.ephemeral }.takeLast(count)
        affected.forEach {
            actor.context.log("Buff") { "Flipped buff ${it.name}." }
            remove(it)
            add(null, it.effect.flipped!!, it.value, it.turns)
        }
    }

    fun getDisplayBuffs(): List<DisplayBuffData> = buildList {
        buffsByEffect.forEach { (effect, values) ->
            add(effect to (values.filter { !it.ephemeral }.maxOfOrNull { it.turns } ?: 0))
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

    private fun hpSlipTotal(effect: TimedBuffEffect): Int {
        val values = get(effect).map { it.value }
        val fixed = values.filter { it > 100 }.sum()
        val percent = values.filter { it <= 100 }.sumOf { actor.maxHp * it / 100 }
        return fixed + percent
    }

    fun tick() = actor.run {
        val hpRegen = hpSlipTotal(HpRegenBuff) + hpRegen + hpPercentRegen * maxHp / 100
        if (hpRegen > 0) {
            context.log("HP Regen") { "HP Regen tick." }
            heal(hpRegen)
        }

        val brillianceRegen = get(BrillianceRegenBuff).sumOf { it.value } + brillianceRegen
        if (brillianceRegen > 0) {
            context.log("Brilliance Regen") { "Brilliance Regen tick." }
            addBrilliance(brillianceRegen)
        }

        positiveBuffs.tick()

        val burn = hpSlipTotal(BurnBuff)
        if (burn > 0) {
            context.log("Burn") { "Burn tick." }
            damage(burn, additionalEffects = false)
        }

        val poison = hpSlipTotal(PoisonBuff)
        if (poison > 0) {
            context.log("Poison") { "Poison tick." }
            damage(poison, additionalEffects = false)
        }

        val nightmare = hpSlipTotal(NightmareBuff)
        if (nightmare > 0) {
            context.log("Nightmare") { "Nightmare tick." }
            damage(nightmare, additionalEffects = false)
        }

        negativeBuffs.tick()

        if (actor.brilliance >= 100 || actor.dress.position == Position.None) {  // Bosses activate each turn
            actor.activateBlessings()
        }
    }

    private fun Collection<ActiveBuff>.tick() {
        if (isEmpty()) return
        val toRemove = mutableListOf<ActiveBuff>()
        for (buff in this) {
            if (!buff.ephemeral) {
                if (--buff.turns <= 0) {
                    toRemove += buff
                }
            }
        }
        toRemove.forEach {
            remove(it)
            actor.context.log("Buff", debug = true) { "Buff ${it.name} expired." }
        }
    }

    private fun ActiveBuff.start() = effect.onStart(actor.context, value)
    private fun ActiveBuff.end() = effect.onEnd(actor.context, value)

    operator fun TimedBuffEffect.invoke(
        value: Int,
        turns: Int,
        ephemeral: Boolean = false,
        relatedBuff: ActiveBuff? = null
    ) =
        ActiveBuff(this, value, turns, ephemeral, relatedBuff)

}

class ActiveBuff(
    val effect: TimedBuffEffect,
    var value: Int,
    var turns: Int,
    val ephemeral: Boolean = false,
    val relatedBuff: ActiveBuff? = null, // For buffs like locked buffs, which reference their original
) {
    val originalTurns = turns
    val name
        get() = if (ephemeral) {
            "${effect.formatName(value)} (ephemeral)"
        } else {
            "${effect.formatName(value)} (${turns}/${originalTurns}t)"
        }

    override fun toString() = "[${effect.name}](value = $value, turns = ${if (turns >= 0) turns else "!"})"
}

enum class CountableBuff(
    override val category: BuffCategory,
    override val iconId: Int,
) : BuffEffect {
    Evasion(BuffCategory.Positive, 27),
    Fortitude(BuffCategory.Positive, 29),
    Revive(BuffCategory.Positive, 164),
    Daze(BuffCategory.Negative, 167),
    Pride(BuffCategory.Negative, 168),
    Hope(BuffCategory.Positive, 169),
    WeakSpot(BuffCategory.Negative, 170),
    DisasterBrillianceReduction(BuffCategory.Negative, 254),
    BlessingHpRecovery(BuffCategory.Positive, 255),
    BlessingCountableDebuffReduction(BuffCategory.Positive, 256),
    DisasterDaze(BuffCategory.Negative, 257),
    BlessingContinuousDebuffRemoval(BuffCategory.Positive, 258),
    BlessingEffectiveDamage(BuffCategory.Positive, 286),
    BlessingHope(BuffCategory.Positive, 260),
}

class CountableBuffStack(
    val effect: CountableBuff,
    val value: Int,
)

val countableBuffsByName = CountableBuff.values().associateBy { it.name.lowercase() } + mapOf(
    "impudence" to CountableBuff.Pride,
    "evade" to CountableBuff.Evasion,
    "fort" to CountableBuff.Fortitude,
)

val abnormalCountableBuffs = setOf(
    CountableBuff.Daze,
    CountableBuff.Pride,
)
