package xyz.qwewqa.relivesim.stage.activeeffects

import xyz.qwewqa.relivesim.stage.CharacterState

interface TimedEffect<T> {
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
    fun start(target: T)

    /**
     * Executes at the end of a turn.
     * Returns true if the effect is expiring.
     */
    fun tick(target: T): Boolean {
        turns -= 1
        return turns <= 0
    }

    /**
     * Executes upon expiration.
     */
    fun stop(target: T)
}

typealias CharacterEffect = TimedEffect<CharacterState>

interface FlippableEffect<T> : TimedEffect<T> {
    /**
     * Returns an instance of this effect when flipped or null if this instance cannot be flipped.
     * The caller is responsible for both ending and removing the current effect,
     * as well as adding and starting the new effect.
     */
    fun flipped(target: T): TimedEffect<T>?
}

enum class EffectClass {
    Neutral,
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

