package xyz.qwewqa.relive.simulator.core.stage.buff

interface CountableBuffEffect : BuffEffect {
    override val isLocked: Boolean get() = false
}
class SimpleCountableBuffEffect(
    override val name: String,
    override val iconId: Int,
    override val category: BuffCategory,
) : CountableBuffEffect
