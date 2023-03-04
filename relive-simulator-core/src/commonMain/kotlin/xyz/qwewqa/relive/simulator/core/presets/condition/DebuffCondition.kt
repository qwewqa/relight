package xyz.qwewqa.relive.simulator.core.presets.condition

import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition

val FreezeOnlyCondition = NamedCondition("Freeze") { FreezeBuff in it.buffs }

val ElectricShockOnlyCondition = NamedCondition("Electric Shock") { ElectricShockBuff in it.buffs }

val LovesicknessOnlyCondition = NamedCondition("Lovesickness") { LovesicknessBuff in it.buffs }

val BurnOnlyCondition = NamedCondition("Burn") { BurnBuff in it.buffs }

val PoisonOnlyCondition = NamedCondition("Poison") { PoisonBuff in it.buffs }
