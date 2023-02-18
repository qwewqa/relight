package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.actor.abnormalCountableBuffs
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeCountableEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.modifier.negativeEffectResistance
import xyz.qwewqa.relive.simulator.core.stage.modifier.positiveEffectResistance

fun BuffData.makeSpecificResistanceUpBuff(
    buff: BuffEffect,
    locked: Boolean = false,
) = makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    locked = locked,
    onStart = { value ->
        self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + value
    },
    onEnd = { value ->
        self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) - value
    },
)

val NegativeEffectResistanceUpBuff = buffData(19).makeModifierTimedBuffEffect(
    modifier = negativeEffectResistance,
    category = BuffCategory.Positive,
)

val LockedNegativeEffectResistanceUpBuff = buffData(166).makeLockedVariantOf(NegativeEffectResistanceUpBuff)

val NegativeCountableEffectResistanceUpBuff = buffData(231).makeModifierTimedBuffEffect(
    modifier = negativeCountableEffectResistance,
    category = BuffCategory.Positive,
)

val LockedNegativeCountableEffectResistanceUpBuff = buffData(232).makeLockedVariantOf(NegativeCountableEffectResistanceUpBuff)

val PositiveEffectResistanceUpBuff = buffData(271).makeModifierTimedBuffEffect(
    modifier = positiveEffectResistance,
    category = BuffCategory.Negative,
)

val LockedPositiveEffectResistanceUpBuff = buffData(272).makeLockedVariantOf(PositiveEffectResistanceUpBuff)

val ActionRestrictionResistanceUpBuff = buffData(74).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    locked = true,
    onStart = {
        abnormalBuffs.forEach { buff ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + 100
        }
        abnormalCountableBuffs.forEach { buff ->
            self.specificBuffResist[buff] = (self.specificBuffResist[buff] ?: 0) + 100
        }
    },
    onEnd = {
        abnormalBuffs.forEach { buff ->
            self.specificBuffResist[buff] = self.specificBuffResist[buff]!! - 100
        }
        abnormalCountableBuffs.forEach { buff ->
            self.specificBuffResist[buff] = self.specificBuffResist[buff]!! - 100
        }
    },
)

val PoisonResistanceUpBuff = buffData(75).makeSpecificResistanceUpBuff(PoisonBuff)
val BurnResistanceUpBuff = buffData(76).makeSpecificResistanceUpBuff(BurnBuff)
val ProvokeResistanceUpBuff = buffData(77).makeSpecificResistanceUpBuff(ProvokeBuff)
val StunResistanceUpBuff = buffData(78).makeSpecificResistanceUpBuff(StunBuff)
val SleepResistanceUpBuff = buffData(79).makeSpecificResistanceUpBuff(SleepBuff)
val ConfusionResistanceUpBuff = buffData(80).makeSpecificResistanceUpBuff(ConfusionBuff)
val StopResistanceUpBuff = buffData(81).makeSpecificResistanceUpBuff(StopBuff)
val FreezeResistanceUpBuff = buffData(82).makeSpecificResistanceUpBuff(FreezeBuff)
val BlindResistanceUpBuff = buffData(83).makeSpecificResistanceUpBuff(BlindnessBuff)
val AggroResistanceUpBuff = buffData(102).makeSpecificResistanceUpBuff(AggroBuff)
val DazeResistanceUpBuff = buffData(253).makeSpecificResistanceUpBuff(CountableBuff.Daze)
val PrideResistanceUpBuff = buffData(256).makeSpecificResistanceUpBuff(CountableBuff.Pride)

val LockedPoisonResistanceUpBuff = buffData(128).makeSpecificResistanceUpBuff(PoisonBuff, true)
val LockedBurnResistanceUpBuff = buffData(129).makeSpecificResistanceUpBuff(BurnBuff, true)
val LockedStunResistanceUpBuff = buffData(130).makeSpecificResistanceUpBuff(StunBuff, true)
val LockedSleepResistanceUpBuff = buffData(131).makeSpecificResistanceUpBuff(SleepBuff, true)
val LockedConfusionResistanceUpBuff = buffData(132).makeSpecificResistanceUpBuff(ConfusionBuff, true)
val LockedStopResistanceUpBuff = buffData(133).makeSpecificResistanceUpBuff(StopBuff, true)
val LockedFreezeResistanceUpBuff = buffData(134).makeSpecificResistanceUpBuff(FreezeBuff, true)
val LockedBlindResistanceUpBuff = buffData(135).makeSpecificResistanceUpBuff(BlindnessBuff, true)
val LockedDazeResistanceUpBuff = buffData(254).makeSpecificResistanceUpBuff(CountableBuff.Daze, true)
val LockedPrideResistanceUpBuff = buffData(257).makeSpecificResistanceUpBuff(CountableBuff.Pride, true)
