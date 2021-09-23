package xyz.qwewqa.relive.simulator.core.stage.actor

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffEffect
import xyz.qwewqa.relive.simulator.core.stage.buff.BuffCategory
import xyz.qwewqa.relive.simulator.core.stage.log

class BuffManager(val actor: Actor) {
    private val positiveBuffs = LinkedHashSet<ActiveBuff>()
    private val negativeBuffs = LinkedHashSet<ActiveBuff>()
    private val buffsByEffect = mutableMapOf<BuffEffect, LinkedHashSet<ActiveBuff>>()

    private val positiveCountableBuffs = mutableMapOf<CountableBuff, Int>()
    private val negativeCountableBuffs = mutableMapOf<CountableBuff, Int>()

    private val passiveActions = mutableListOf<ActionContext.() -> Unit>()

    fun get(buff: BuffEffect) = buffsByEffect[buff] ?: emptySet()
    fun any(vararg buffEffect: BuffEffect) = buffEffect.any { any(it) }
    fun any(buffEffect: BuffEffect) = count(buffEffect) > 0
    fun any(buff: CountableBuff) = count(buff) > 0
    fun count(buffEffect: BuffEffect) = buffsByEffect[buffEffect]?.size ?: 0
    fun count(buff: CountableBuff) = when (buff.category) {
        BuffCategory.Positive -> positiveCountableBuffs[buff]
        BuffCategory.Negative -> negativeCountableBuffs[buff]
    } ?: 0

    fun add(buffEffect: BuffEffect, value: Int, turns: Int): ActiveBuff? {
        if (buffEffect.exclusive) {
            val existing = get(buffEffect).singleOrNull()
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
        val buff = buffEffect(value, turns)
        buff.start()
        when (buffEffect.category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }.add(buff)
        buffsByEffect.getOrPut(buffEffect) { LinkedHashSet() }.add(buff)
        actor.context.log("Buff") { "Buff ${buff.name} added." }
        return buff
    }

    fun addCountable(buff: CountableBuff, count: Int = 1) {
        when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }.let { it[buff] = (it[buff] ?: 0) + count }
    }

    fun addPassive(passive: ActionContext.() -> Unit) {
        passiveActions += passive
    }

    fun remove(buff: ActiveBuff) {
        val removed = when (buff.effect.category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }.remove(buff)
        if (!removed) error("Buff is not active.")
        buffsByEffect[buff.effect]!!.remove(buff)
        buff.end()
        actor.context.log("Buff") { "Buff ${buff.name} removed." }
    }

    fun remove(buff: CountableBuff) {
        when (buff.category) {
            BuffCategory.Positive -> positiveCountableBuffs
            BuffCategory.Negative -> negativeCountableBuffs
        }.let { it[buff] = (it[buff] ?: 0) - 1 }
        actor.context.log("Buff") { "Countable buff ${buff.name} removed." }
    }

    fun clear() {
        dispel(BuffCategory.Positive)
        dispel(BuffCategory.Negative)
        dispelCountable(BuffCategory.Positive)
        dispelCountable(BuffCategory.Negative)
    }

    fun removeAll(buffEffect: BuffEffect) {
        (buffsByEffect[buffEffect] ?: return).toList().forEach { remove(it) }
    }

    fun dispel(category: BuffCategory) {
        val targets = when (category) {
            BuffCategory.Positive -> positiveBuffs
            BuffCategory.Negative -> negativeBuffs
        }
        targets.forEach { it.end() }
        targets.clear()
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
        val affected = targets.filter { it.effect.flipped != null }.takeLast(count)
        affected.forEach {
            actor.context.log("Buff") { "Flipping buff ${it.name}." }
            remove(it)
            add(it.effect.flipped!!, it.value, it.turns)
        }
    }

    fun tick() {
        passiveActions.forEach { it(actor.context) }
        negativeBuffs.toList().forEach {
            it.turns--
            if (it.turns <= 0) remove(it)
        }
        positiveBuffs.toList().forEach {
            it.turns--
            if (it.turns <= 0) remove(it)
        }
    }

    private fun ActiveBuff.start() = effect.onStart(actor.context, value)
    private fun ActiveBuff.end() = effect.onEnd(actor.context, value)
}

class ActiveBuff(
    val effect: BuffEffect,
    var value: Int,
    var turns: Int,
) {
    val name get() = "${effect.formatName(value)} (${turns}t)"
    override fun toString() = "${effect::class.simpleName}(value = $value, turns = $turns)"
}

operator fun BuffEffect.invoke(value: Int, turns: Int) = ActiveBuff(this, value, turns)

enum class CountableBuff(val category: BuffCategory) {
    Evade(BuffCategory.Positive),
    Fortitude(BuffCategory.Positive),
    Revive(BuffCategory.Positive),
}
