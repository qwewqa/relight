package xyz.qwewqa.relivesim.stage

interface AutoEffect {
    /**
     * A human friendly name for this effect.
     */
    val name: String get() = "Unnamed Auto Effect"

    /**
     * Called once, upon activation.
     */
    fun activate()
}

