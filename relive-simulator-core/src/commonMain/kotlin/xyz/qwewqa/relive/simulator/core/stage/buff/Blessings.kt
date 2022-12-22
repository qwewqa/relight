package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff

fun Actor.activateBlessings() = context.targetSelf().act {
    buffs.consumeOnce(CountableBuff.BlessingHpRecovery) { value ->
        heal(percent = value)
    }
    buffs.consumeOnce(CountableBuff.BlessingCountableDebuffReduction) { value ->
        dispelCountable(BuffCategory.Negative, value)
    }
    buffs.consumeOnce(CountableBuff.BlessingContinuousDebuffRemoval) {
        dispelTimed(BuffCategory.Negative)
    }
    buffs.consumeOnce(CountableBuff.BlessingEffectiveDamage) { value ->
        applyBuff(EffectiveDamageDealtUpBuff, value, 1)
    }
    buffs.consumeOnce(CountableBuff.BlessingHope) { value ->
        applyCountableBuff(CountableBuff.Hope, count = value)
    }
    buffs.consumeOnce(CountableBuff.BlessingAp2Down) { _ ->
        applyBuff(Ap2DownBuff, 0, 1)
    }
    buffs.consumeOnce(CountableBuff.DisasterBrillianceReduction) { value ->
        removeBrilliance(value)
    }
    buffs.consumeOnce(CountableBuff.DisasterDaze) { value ->
        applyCountableBuff(CountableBuff.Daze, count = value)
    }
    buffs.consumeOnce(CountableBuff.DisasterApUp) { _ ->
        applyBuff(ApUpBuff, 0, 1)
    }
}
