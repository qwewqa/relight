package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff

fun Actor.activateBlessings() = context.targetSelf().act {
    buffs.consumeAll(CountableBuff.DisasterBrillianceReduction) { value ->
        removeBrilliance(value)
    }
    buffs.consumeAll(CountableBuff.DisasterDaze) { value ->
        applyCountableBuff(CountableBuff.Daze, count = value)
    }
    buffs.consumeAll(CountableBuff.BlessingHpRecovery) { value ->
        heal(percent = value)
    }
    buffs.consumeAll(CountableBuff.BlessingCountableDebuffReduction) { value ->
        dispelCountable(BuffCategory.Negative, value)
    }
    buffs.consumeAll(CountableBuff.BlessingContinuousDebuffRemoval) {
        dispelTimed(BuffCategory.Negative)
    }
    buffs.consumeAll(CountableBuff.BlessingEffectiveDamage) { value ->
        applyBuff(EffectiveDamageDealtUpBuff, value, 1)
    }
    buffs.consumeAll(CountableBuff.BlessingHope) { value ->
        applyCountableBuff(CountableBuff.Hope, count = value)
    }
}
