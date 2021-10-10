package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ActionContext

interface BuffEffect {
    val name: String get() = this::class.simpleName ?: "Unknown Buff"
    val category: BuffCategory
    val locked: Boolean get() = false
    val exclusive: Boolean get() = false

    /**
     * A buff effect to apply at the same time as this buff.
     * Intended for use with locked buffs, which may simply reference their original version.
     */
    val related: BuffEffect? get() = null

    /**
     * The flipped version of this buff. For example, Act Power Up flipped is Act Power Down.
     */
    val flipped: BuffEffect? get() = null

    fun onStart(context: ActionContext, value: Int) {}
    fun onEnd(context: ActionContext, value: Int) {}
    fun formatName(value: Int): String = if (value != 0) {
        "$name $value"
    } else {
        name
    }
}

enum class BuffCategory {
    Positive,
    Negative,
}
