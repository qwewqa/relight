package xyz.qwewqa.relivesim.stage

interface ActiveEffect {
    /**
     * A human-friendly name for the buff itself, including its efficacy and timer, if relevant.
     * Should not include information about the target.
     */
    val displayName: String get() = "Unnamed Active Effect"

    /**
     * Executes when the effect is applied.
     */
    fun start()

    /**
     * Executes at the end of a turn.
     * Returns true if the effect is expiring.
     */
    fun tick(): Boolean

    /**
     * Executes upon activation,
     * Returns true if the effect is expiring.
     */
    fun activate(): Boolean

    /**
     * Executes upon expiration
     */
    fun stop()
}

interface TargetedActiveEffect : ActiveEffect {
    /**
     * The target, which this effect is applied to.
     */
    val target: CharacterData
}

interface FlippableEffect : ActiveEffect {
    /**
     * Returns an instance of this effect when flipped.
     * The caller is responsible for both ending and removing the current effect,
     * as well as adding and starting the new effect.
     */
    fun flipped(): ActiveEffect
}
