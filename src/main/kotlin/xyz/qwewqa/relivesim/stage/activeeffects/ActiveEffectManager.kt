package xyz.qwewqa.relivesim.stage.activeeffects

import java.util.*
import kotlin.collections.LinkedHashSet

class ActiveEffectManager<T>(val target: T) {
    private val neutralEffects = LinkedHashSet<TimedEffect<T>>()
    private val positiveEffects = LinkedHashSet<TimedEffect<T>>()
    private val negativeEffects = LinkedHashSet<TimedEffect<T>>()
    private val effectsByType: MutableMap<EffectType, MutableSet<TimedEffect<T>>> = EnumMap(EffectType::class.java)

    private val positiveStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val negativeStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val neutralStackedEffects = mutableMapOf<StackedEffect, Int>()

    /*
    A note about flip:
    It is presently untested whether flip adds the new effects at the end of the list,
    or replaces the existing effects in-place.
     */

    fun get(effectType: EffectType): Set<TimedEffect<T>> {
        return effectsByType[effectType] ?: emptySet()
    }

    fun get(effect: StackedEffect): Int {
        return when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }[effect] ?: 0
    }

    fun add(effect: TimedEffect<T>) {
        effect.start(target)
        val added = when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.add(effect)
        if (!added) error("Effect is already active.")
        effectsByType.getOrPut(effect.effectType) { mutableSetOf() }.add(effect)
    }

    fun add(effect: StackedEffect) {
        when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }.let { it[effect] = (it[effect] ?: 0) + 1 }
    }

    fun removeTimed(effect: TimedEffect<T>) {
        val removed = when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.remove(effect)
        if (!removed) error("Effect is not active.")
        effectsByType[effect.effectType]!!.remove(effect)
        effect.stop(target)
    }

    fun removeStacked(effect: StackedEffect) {
        when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
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
            EffectClass.Neutral -> neutralEffects
        }.apply {
            filter { includeLocked or !it.locked }.forEach {
                remove(it)
                effectsByType[it.effectType]!!.remove(it)
                it.stop(target)
            }
        }
    }

    fun dispelStacked(effectClass: EffectClass) {
        when (effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }.replaceAll { _, _ -> 0 }
    }

    fun tick() {
        positiveEffects.tick()
        neutralEffects.tick()
        negativeEffects.tick()
    }

    private fun LinkedHashSet<TimedEffect<T>>.tick() {
        filter { it.tick(target) }.forEach {
            remove(it)
            effectsByType[it.effectType]!!.remove(it)
            it.stop(target)
        }
    }
}