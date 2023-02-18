package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.modifier.absorb
import xyz.qwewqa.relive.simulator.core.stage.modifier.counterHeal


val PerfectAimBuff = buffData(28).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    exclusive = true,
)

val LockedPerfectAimBuff = buffData(273).makeLockedVariantOf(PerfectAimBuff)


val AggroBuff = buffData(29).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val LockedAggroBuff = buffData(219).makeLockedVariantOf(AggroBuff)

val ProvokeBuff = buffData(49).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val ContractionBuff = buffData(267).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val AbsorbBuff = buffData(37).makeModifierTimedBuffEffect(
    modifier = absorb,
    category = BuffCategory.Positive,
)

val CounterHealBuff = buffData(38).makeModifierTimedBuffEffect(
    modifier = counterHeal,
    category = BuffCategory.Positive,
)

val InvincibilityBuff = buffData(104).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    exclusive = true,
)

val LockedInvincibilityBuff = buffData(281).makeLockedVariantOf(InvincibilityBuff)

val ExitEvasionBuff = buffData(103).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    exclusive = true,
)

val ResilienceBuff = buffData(139).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    exclusive = true,
)

val LockedResilienceBuff = buffData(234).makeLockedVariantOf(ResilienceBuff)

val MultipleCAficationBuff = buffData(276).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    exclusive = true,
)