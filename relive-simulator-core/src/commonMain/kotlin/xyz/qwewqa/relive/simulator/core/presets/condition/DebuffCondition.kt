package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FreezeOnlyCondition = NamedCondition("Freeze") { Buffs.FreezeBuff in it.buffs }

val ElectricShockOnlyCondition =
    NamedCondition("Electric Shock") { Buffs.ElectricShockBuff in it.buffs }

val LovesicknessOnlyCondition =
    NamedCondition("Lovesickness") { Buffs.LovesicknessBuff in it.buffs }

val BurnOnlyCondition = NamedCondition("Burn") { Buffs.BurnBuff in it.buffs }

val PoisonOnlyCondition = NamedCondition("Poison") { Buffs.PoisonBuff in it.buffs }
