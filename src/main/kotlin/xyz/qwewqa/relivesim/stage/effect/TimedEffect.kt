package xyz.qwewqa.relivesim.stage.effect

import xyz.qwewqa.relivesim.stage.context.ActionContext

interface TimedEffect {
    val effectClass: EffectClass
    val effectType: EffectType

    val locked: Boolean get() = false

    /**
     * The number of remaining turns this effect has.
     */
    var turns: Int

    /**
     * Executes when the effect is applied.
     */
    fun start(context: ActionContext)

    /**
     * Executes at the end of a turn.
     * Returns true if the effect is expiring.
     */
    fun tick(context: ActionContext): Boolean {
        turns -= 1
        return turns <= 0
    }

    /**
     * Executes upon expiration.
     */
    fun stop(context: ActionContext)
}

interface FlippableEffect : TimedEffect {
    /**
     * Returns an instance of this effect when flipped or null if this instance cannot be flipped.
     * The caller is responsible for both ending and removing the current effect,
     * as well as adding and starting the new effect.
     */
    fun flipped(context: ActionContext): TimedEffect?
}

enum class EffectClass {
    Positive,
    Negative,
}

enum class EffectType {
    Other,
    Poison,
    Burn,
    Stun,
    Sleep,
    Confuse,
    Stop,
    Freeze,
    Blind,
    Mark,
    Provoke,
    Aggro,
    ExitEvasion,
}

