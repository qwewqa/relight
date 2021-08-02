package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext
import java.util.*
import kotlin.collections.LinkedHashSet

class ActiveEffectManager {
    private val neutralEffects = LinkedHashSet<TimedEffect>()
    private val positiveEffects = LinkedHashSet<TimedEffect>()
    private val negativeEffects = LinkedHashSet<TimedEffect>()
    private val effectsByType: MutableMap<EffectType, MutableSet<TimedEffect>> = EnumMap(EffectType::class.java)

    private val positiveStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val negativeStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val neutralStackedEffects = mutableMapOf<StackedEffect, Int>()

    /*
    A note about flip:
    It is presently untested whether flip adds the new effects at the end of the list,
    or replaces the existing effects in-place.
     */

    fun get(effectType: EffectType): Set<TimedEffect> {
        return effectsByType[effectType] ?: emptySet()
    }

    fun get(effect: StackedEffect): Int {
        return when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }[effect] ?: 0
    }

    fun add(effect: TimedEffect, context: ActionContext) {
        effect.start(context)
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

    fun removeTimed(effect: TimedEffect, context: ActionContext) {
        val removed = when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.remove(effect)
        if (!removed) error("Effect is not active.")
        effectsByType[effect.effectType]!!.remove(effect)
        effect.stop(context)
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

    fun removeAll(type: EffectType, context: ActionContext) {
        effectsByType[type]?.toList()?.forEach {
            removeTimed(it, context)
        }
    }

    fun dispelTimed(effectClass: EffectClass, includeLocked: Boolean = false, context: ActionContext) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.apply {
            filter { includeLocked or !it.locked }.forEach {
                remove(it)
                effectsByType[it.effectType]!!.remove(it)
                it.stop(context)
            }
        }
    }

    fun dispelStacked(effectClass: EffectClass, context: ActionContext) {
        when (effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
            EffectClass.Neutral -> neutralStackedEffects
        }.replaceAll { _, _ -> 0 }
    }

    fun tick(effectClass: EffectClass, context: ActionContext) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
            EffectClass.Neutral -> neutralEffects
        }.tick(context)
    }

    private fun LinkedHashSet<TimedEffect>.tick(context: ActionContext) {
        filter { it.tick(context) }.forEach {
            remove(it)
            effectsByType[it.effectType]!!.remove(it)
            it.stop(context)
        }
    }
}