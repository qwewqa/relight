package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.ImplementationRegistry

interface CountableBuffEffect : BuffEffect
class SimpleCountableBuffEffect(
    override val id: Int?,
    override val name: String,
    override val iconId: Int,
    override val category: BuffCategory,
    override val isLocked: Boolean = false,
) : CountableBuffEffect
