package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FreezeOnlyCondition = NamedCondition("Freeze") {
    it.buffs.any(FreezeBuff)
}

val ElectricShockOnlyCondition = NamedCondition("Electric Shock") {
    it.buffs.any(ElectricShockBuff, LockedElectricShockBuff)
}

val LovesicknessOnlyCondition = NamedCondition("Lovesickness") {
    it.buffs.any(LovesicknessBuff, LockedLovesicknessBuff)
}

val BurnOnlyCondition = NamedCondition("Burn") {
    it.buffs.any(BurnBuff, LockedBurnBuff)
}

val PoisonOnlyCondition = NamedCondition("Poison") {
    it.buffs.any(PoisonBuff, LockedPoisonBuff)
}
