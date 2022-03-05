package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.buff.ElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.FreezeBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.LockedElectricShockBuff
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FreezeOnlyCondition = NamedCondition("Freeze") {
    it.buffs.any(FreezeBuff)
}

val ElectricShockOnlyCondition = NamedCondition("Electric Shock") {
    it.buffs.any(ElectricShockBuff, LockedElectricShockBuff)
}