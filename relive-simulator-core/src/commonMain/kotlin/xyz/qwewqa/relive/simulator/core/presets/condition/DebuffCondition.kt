package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.buff.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FreezeOnlyCondition = NamedCondition("Freeze") {
    it.buffs.any(FreezeBuff)
}