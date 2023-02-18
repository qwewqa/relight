package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.modifier.*

val HpRegenBuff = buffData(268).makeSimpleTimedBuffEffect(
    category = BuffCategory.Positive,
    onStart = { value ->
        if (value <= 100) {
            self.mod { hpPercentRegen += value }
        } else {
            self.mod { hpFixedRegen += value }
        }
    },
    onEnd = { value ->
        if (value <= 100) {
            self.mod { hpPercentRegen -= value }
        } else {
            self.mod { hpFixedRegen -= value }
        }
    },
)

val BrillianceRegenBuff = buffData(22).copy(name = "Brilliance Regen").makeModifierTimedBuffEffect(
    modifier = brillianceRegen,
    category = BuffCategory.Positive,
)

val LockedBrillianceRegenBuff = buffData(279).copy(name = "Locked Brilliance Regen").makeLockedVariantOf(
    BrillianceRegenBuff,
)

val ReviveRegenBuff = buffData(280).makeModifierTimedBuffEffect(
    modifier = reviveRegen,
    category = BuffCategory.Positive,
)
