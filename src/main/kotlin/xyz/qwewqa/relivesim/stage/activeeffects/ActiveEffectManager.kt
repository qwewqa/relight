package xyz.qwewqa.relivesim.stage.activeeffects

import java.sql.Time

class ActiveEffectManager<T>(val target: T) {
    private val neutralEffects = mutableListOf<TimedEffect<T>>()
    private val positiveEffects = mutableListOf<TimedEffect<T>>()
    private val negativeEffects = mutableListOf<TimedEffect<T>>()
    private val effectsByType = mutableMapOf<EffectType, MutableSet<TimedEffect<T>>>()

    private val positiveStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val negativeStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val neutralStackedEffects = mutableMapOf<StackedEffect, Int>()

    /*
    A note about flip:
    It is presently untested whether flip adds the new effects at the end of the list,
    or replaces the existing effects in-place.
     */

    fun add(effect: TimedEffect<T>) {
        effect.start(target)
        when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.add(effect)
        effectsByType.getOrPut(effect.effectType) { mutableSetOf() }.add(effect)
    }

    fun add(effect: StackedEffect) {
        when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }.let { it[effect] = (it[effect] ?: 0) + 1 }
    }

    fun remove(effect: StackedEffect) {
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

    fun remove(effectClass: EffectClass, predicate: (TimedEffect<T>) -> Boolean) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.removeAll { eff -> predicate(eff).also { if (it) eff.processRemoval() } }
    }

    fun dispel(effectClass: EffectClass, includeLocked: Boolean = false) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.removeAll { eff -> (includeLocked or !eff.locked).also { if (it) eff.processRemoval() } }
    }

    fun dispelStacked(effectClass: EffectClass) {
        when (effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }.replaceAll { _, _ -> 0 }
    }

    fun get(effect: StackedEffect): Int {
        return when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }[effect] ?: 0
    }

    fun hasEffectType(type: EffectType) = effectsByType[type]?.isNotEmpty() ?: false

    private fun TimedEffect<T>.processTick() = tick(target).also {
        if (it) {
            processRemoval()
        }
    }

    private fun TimedEffect<T>.processRemoval() {
        effectsByType[effectType]!!.remove(this)
        stop(target)
    }

    fun tick() {
        positiveEffects.removeAll { eff -> eff.processTick() }
        neutralEffects.removeAll { eff -> eff.processTick() }
        negativeEffects.removeAll { eff -> eff.processTick() }
    }
}