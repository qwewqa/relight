package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.modifier.Modifier
import xyz.qwewqa.relive.simulator.core.stage.modifier.damageReceivedUp
import xyz.qwewqa.relive.simulator.core.stage.modifier.maxHp
import xyz.qwewqa.relive.simulator.core.stage.modifier.modifier
import xyz.qwewqa.relive.simulator.core.stage.platformSetOf

private fun BuffData.makeDamageOverTimeBuffEffect(
    modifier: Modifier,
    exclusive: Boolean = false,
    locked: Boolean = false,
) = makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = exclusive,
    locked = locked,
    onStart = { value ->
        val damage = if (value <= 100) {
            self.mod { +maxHp pfmul value }.coerceAtMost(99_999)
        } else {
            value
        }
        self.mod { modifier += damage }
    },
    onEnd = { value ->
        val damage = if (value <= 100) {
            self.mod { +maxHp pfmul value }.coerceAtMost(99_999)
        } else {
            value
        }
        self.mod { modifier -= damage }
    },
)

val poisonDamage = modifier("poisonDamage")
val burnDamage = modifier("burnDamage")
val frostbiteDamage = modifier("frostbiteDamage")
val nightmareDamage = modifier("nightmareDamage")

val PoisonBuff = buffData(48).makeDamageOverTimeBuffEffect(poisonDamage)

val BurnBuff = buffData(49).makeDamageOverTimeBuffEffect(burnDamage)

val StunBuff = buffData(50).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val SleepBuff = buffData(51).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val ConfusionBuff = buffData(52).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val StopBuff = buffData(53).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val FreezeBuff = buffData(54).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val BlindnessBuff = buffData(55).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val LovesicknessBuff = buffData(162).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val ElectricShockBuff = buffData(169).makeSimpleTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
)

val NightmareBuff = buffData(174).makeDamageOverTimeBuffEffect(nightmareDamage, exclusive = true)

val FrostbiteBuff = buffData(185).makeDamageOverTimeBuffEffect(frostbiteDamage, exclusive = true)

val AgonyBuff = buffData(218).makeIdempotentTimedBuffEffect(
    category = BuffCategory.Negative,
    exclusive = true,
    onStart = {
        self.mod { damageReceivedUp += 30 }
    },
    onEnd = {
        self.mod { damageReceivedUp -= 30 }
    },
)

val LockedStunBuff = buffData(111).makeLockedVariantOf(StunBuff)
val LockedConfusionBuff = buffData(138).makeLockedVariantOf(ConfusionBuff)
val LockedPoisonBuff = buffData(140).makeLockedVariantOf(PoisonBuff)
val LockedBurnBuff = buffData(141).makeLockedVariantOf(BurnBuff)
val LockedBlindnessBuff = buffData(142).makeLockedVariantOf(BlindnessBuff)
val LockedLovesicknessBuff = buffData(163).makeLockedVariantOf(LovesicknessBuff)
val LockedElectricShockBuff = buffData(170).makeLockedVariantOf(ElectricShockBuff)

val abnormalBuffs = platformSetOf(
    StopBuff,
    SleepBuff,
    NightmareBuff,
    ConfusionBuff,
    FreezeBuff,
    StunBuff,
    LockedStunBuff,
    BurnBuff,
    LockedBurnBuff,
    PoisonBuff,
    LockedPoisonBuff,
    AgonyBuff,
    LovesicknessBuff,
    LockedLovesicknessBuff,
    ElectricShockBuff,
    LockedElectricShockBuff,
    FrostbiteBuff,
)
