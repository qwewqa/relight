package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.buff.AbnormalGuardBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.buff.abnormalBuffs
import xyz.qwewqa.relive.simulator.core.stage.log

expect fun countableBuffMap(): MutableMap<CountableBuff, Int>

class BuffManager(val actor: Actor) {
    private val positiveBuffs = LinkedHashSet<ActiveBuff>()
    private val negativeBuffs = LinkedHashSet<ActiveBuff>()
    private val buffsByEffect = mutableMapOf<BuffEffect, LinkedHashSet<ActiveBuff>>()

    private val _effectNameMapping = mutableMapOf<String, BuffEffect>()
    val effectNameMapping: Map<String, BuffEffect> get() = _effectNameMapping

    private val positiveCountableBuffs = countableBuffMap()
    private val negativeCountableBuffs = countableBuffMap()

    private val passiveActions = mutableListOf<ActionContext.() -> Unit>()

    var guardOnAbnormal = false

    fun get(buff: BuffEffect) = buffsByEffect[buff] ?: emptySet()
    fun any(vararg buffEffect: BuffEffect) = buffEffect.any { any(it) }
    fun any(buffEffect: BuffEffect) = count(buffEffect) > 0
    fun any(buff: CountableBuff) = count(buff) > 0
    fun count(buffEffect: BuffEffect) = buffsByEffect[buffEffect]?.size ?: 0
    fun count(buff: CountableBuff) = when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff]
    } ?: 0

    fun BuffEffect.activate(value: Int, turns: Int, ephemeral: Boolean = false, relatedBuff: ActiveBuff? = null) =
        ActiveBuff(this, value, turns, ephemeral, relatedBuff).also { activeBuff ->
            activeBuff.start()
            when (category) {
                BuffCategory.Positive -> positiveBuffs
                BuffCategory.Negative -> negativeBuffs
            }.add(activeBuff)
            buffsByEffect.getOrPut(this) {
                _effectNameMapping[name] = this
                LinkedHashSet()
            }.add(activeBuff)
            actor.context.log("Buff") { "Buff ${activeBuff.name} added." }
        }

    /**
     * Adds a buff without normal exclusivity checks or turn expiry.
     * Intended for stage effects and locked buffs.
     * Removed like normal buffs using the [remove] method.
     */
    fun addEphemeral(buffEffect: BuffEffect, value: Int): ActiveBuff {
        return buffEffect.activate(value, -1, true)
    }

    fun add(buffEffect: BuffEffect, value: Int, turns: Int): ActiveBuff? {
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
            addEphemeral(related, value)
        }
        val buff = buffEffect.activate(value, turns, relatedBuff = relatedBuff)
        if (guardOnAbnormal && buffEffect in abnormalBuffs) {
            actor.context.log("Buff") { "Abnormal Guard activated." }
            add(AbnormalGuardBuff, 100, 9)
        }
        return buff
    }

    fun addCountable(buff: CountableBuff, count: Int = 1) {
        when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }.let { it[buff] = (it[buff] ?: 0) + count }
        if (guardOnAbnormal && buff in abnormalCountableBuffs) {
            actor.context.log("Buff") { "Abnormal Guard activated." }
            add(AbnormalGuardBuff, 100, 9)
        }
    }

    fun addPassive(passive: ActionContext.() -> Unit) {
        passiveActions += passive
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
        actor.context.log("Buff") { "Buff ${buff.name} removed." }
    }

    fun remove(buff: CountableBuff) {
        val category = when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }
        val prevCount = count(buff)
        if (prevCount <= 0) error("Cannot remove countable buff $buff which is already at zero stacks.")
        category[buff] = prevCount - 1
        actor.context.log("Buff") { "Countable buff ${buff.name} removed (prev: $prevCount, new: ${prevCount - 1})." }
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

    fun removeAll(buffEffect: BuffEffect) {
        (buffsByEffect[buffEffect] ?: return).toList().forEach { remove(it) }
    }

    fun dispel(category: BuffCategory) {
        when (category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }.filter { !it.ephemeral && !it.effect.locked }.forEach { remove(it) }
    }

    fun dispelCountable(category: BuffCategory) {
        when (category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }.clear()
    }

    fun flip(category: BuffCategory, count: Int) {
        val targets = when (category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }
        val affected = targets.filter { it.effect.flipped != null && !it.ephemeral }.takeLast(count)
        affected.forEach {
            actor.context.log("Buff") { "Flipping buff ${it.name}." }
            remove(it)
            add(it.effect.flipped!!, it.value, it.turns)
        }
    }

    fun tick() {
        passiveActions.forEach { it(actor.context) }
        negativeBuffs.tick()
        positiveBuffs.tick()
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
        toRemove.forEach { remove(it) }
    }

    private fun ActiveBuff.start() = effect.onStart(actor.context, value)
    private fun ActiveBuff.end() = effect.onEnd(actor.context, value)
}

class ActiveBuff(
    val effect: BuffEffect,
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

    override fun toString() = "[${effect.name}](value = $value, turns = $turns)"
}

operator fun BuffEffect.invoke(value: Int, turns: Int, ephemeral: Boolean = false, relatedBuff: ActiveBuff? = null) =
    ActiveBuff(this, value, turns, ephemeral, relatedBuff)

enum class CountableBuff(val category: BuffCategory) {
    Evasion(BuffCategory.Positive),
    Fortitude(BuffCategory.Positive),
    Revive(BuffCategory.Positive),
    Daze(BuffCategory.Negative),
    Pride(BuffCategory.Negative),
    Hope(BuffCategory.Positive),
    WeakSpot(BuffCategory.Negative),
}

val abnormalCountableBuffs = setOf(
    CountableBuff.Daze,
    CountableBuff.Pride,
)
