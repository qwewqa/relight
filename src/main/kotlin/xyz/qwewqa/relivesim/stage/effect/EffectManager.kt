package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.context.ActionContext
import java.util.*
import kotlin.collections.LinkedHashSet

class EffectManager(val stageGirl: StageGirl) {
    private val positiveEffects = LinkedHashSet<TimedEffect>()
    private val negativeEffects = LinkedHashSet<TimedEffect>()
    private val effectsByType: MutableMap<EffectType, LinkedHashSet<TimedEffect>> = EnumMap(EffectType::class.java)

    private val positiveCountableEffects = mutableMapOf<StackedEffect, Int>()
    private val negativeCountableEffects = mutableMapOf<StackedEffect, Int>()

    private val passiveEffects = mutableListOf<ActionContext.() -> Unit>()

    /*
    A note about flip:
    It is presently untested whether flip adds the new effects at the end of the list,
    or replaces the existing effects in-place.
     */

    val context get() = stageGirl.context

    fun get(effectType: EffectType): Set<TimedEffect> {
        return effectsByType[effectType] ?: emptySet()
    }

    fun count(effectType: EffectType): Int {
        return get(effectType).size
    }

    fun get(effect: StackedEffect): Int {
        return when (effect.effectClass) {
            EffectClass.Positive -> positiveCountableEffects
            EffectClass.Negative -> negativeCountableEffects
        }[effect] ?: 0
    }

    fun add(effect: TimedEffect) {
        if (effect.exclusive) {
            removeAll(effect.effectType)
        }
        effect.start(context)
        val added = when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
        }.add(effect)
        if (!added) error("Effect is already active.")
        effectsByType.getOrPut(effect.effectType) { LinkedHashSet() }.add(effect)
    }

    fun add(effect: StackedEffect, count: Int = 1) {
        when (effect.effectClass) {
            EffectClass.Positive -> positiveCountableEffects
            EffectClass.Negative -> negativeCountableEffects
        }.let { it[effect] = (it[effect] ?: 0) + count }
    }

    fun addPassive(passive: ActionContext.() -> Unit) {
        passiveEffects += passive
    }

    fun removeTimed(effect: TimedEffect) {
        val removed = when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
        }.remove(effect)
        if (!removed) error("Effect is not active.")
        effectsByType[effect.effectType]!!.remove(effect)
        effect.stop(context)
    }

    fun removeStacked(effect: StackedEffect) {
        when (effect.effectClass) {
            EffectClass.Positive -> positiveCountableEffects
            EffectClass.Negative -> negativeCountableEffects
        }.let {
            val value = it[effect]
            if (value == null || value <= 0) throw RuntimeException("Cannot remove effect with no active stacks.")
            it[effect] = value - 1
        }
    }

    fun removeAll(type: EffectType) {
        effectsByType[type]?.toList()?.forEach {
            removeTimed(it)
        }
    }

    fun dispelTimed(effectClass: EffectClass, includeLocked: Boolean = false) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
        }.apply {
            filter { includeLocked or !it.locked }.forEach {
                remove(it)
                effectsByType[it.effectType]!!.remove(it)
                it.stop(context)
            }
        }
    }

    fun flipTimed(effectClass: EffectClass, count: Int, includeLocked: Boolean = false) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
        }.apply {
            filter { includeLocked or !it.locked }.filterIsInstance<FlippableEffect>().takeLast(count).map {
                remove(it)
                effectsByType[it.effectType]!!.remove(it)
                it.stop(context)
                it.flipped(context)
            }.forEach {
                this@EffectManager.add(it)
            }
        }
    }

    fun dispelCountable(effectClass: EffectClass) {
        when (effectClass) {
            EffectClass.Positive -> positiveCountableEffects
            EffectClass.Negative -> negativeCountableEffects
        }.replaceAll { _, _ -> 0 }
    }

    fun tick() {
        passiveEffects.forEach { it(context) }
        positiveEffects.tick()
        negativeEffects.tick()
    }

    private fun LinkedHashSet<TimedEffect>.tick() {
        filter { it.tick(context) }.forEach {
            remove(it)
            effectsByType[it.effectType]!!.remove(it)
            it.stop(context)
        }
    }
}