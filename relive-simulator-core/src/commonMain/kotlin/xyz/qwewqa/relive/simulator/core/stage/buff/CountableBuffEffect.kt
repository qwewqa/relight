package xyz.qwewqa.relive.simulator.core.stage.buff

interface CountableBuffEffect : BuffEffect

class SimpleCountableBuffEffect(
    override val id: Int?,
    override val name: String,
    override val iconId: Int,
    override val groupId: Int,
    override val groupLevel: Int,
    override val category: BuffCategory,
    override val isLocked: Boolean = false,
) : CountableBuffEffect
