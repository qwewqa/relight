package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.context.ActionContext
import java.util.*
import kotlin.collections.LinkedHashSet

class ActiveEffectManager(val character: CharacterState) {
    private val positiveEffects = LinkedHashSet<TimedEffect>()
    private val negativeEffects = LinkedHashSet<TimedEffect>()
    private val effectsByType: MutableMap<EffectType, MutableSet<TimedEffect>> = EnumMap(EffectType::class.java)

    private val positiveStackedEffects = mutableMapOf<StackedEffect, Int>()
    private val negativeStackedEffects = mutableMapOf<StackedEffect, Int>()

    /*
    A note about flip:
    It is presently untested whether flip adds the new effects at the end of the list,
    or replaces the existing effects in-place.
     */

    val context get() = character.context

    fun get(effectType: EffectType): Set<TimedEffect> {
        return effectsByType[effectType] ?: emptySet()
    }

    fun get(effect: StackedEffect): Int {
        return when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
        }[effect] ?: 0
    }

    fun add(effect: TimedEffect) {
        effect.start(context)
        val added = when (effect.effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
        }.add(effect)
        if (!added) error("Effect is already active.")
        effectsByType.getOrPut(effect.effectType) { mutableSetOf() }.add(effect)
    }

    fun add(effect: StackedEffect) {
        when (effect.effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
        }.let { it[effect] = (it[effect] ?: 0) + 1 }
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
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
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

    fun dispelStacked(effectClass: EffectClass) {
        when (effectClass) {
            EffectClass.Positive -> positiveStackedEffects
            EffectClass.Negative -> negativeStackedEffects
        }.replaceAll { _, _ -> 0 }
    }

    fun tick(effectClass: EffectClass) {
        when (effectClass) {
            EffectClass.Positive -> positiveEffects
            EffectClass.Negative -> negativeEffects
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