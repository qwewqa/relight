package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApDown2Buff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EffectiveDamageDealtUpBuff

fun Actor.activateBlessings() =
    context.targetSelf().act {
      buffs.consumeOnce(Buffs.BlessingHpRecoveryBuff) { value -> heal(percent = value) }
      buffs.consumeOnce(Buffs.BlessingRemoveCountableNegativeEffectsBuff) { _ ->
        dispelCountable(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.BlessingReduceCountableNegativeEffectsBuff) { value ->
        dispelCountable(BuffCategory.Negative, value)
      }
      buffs.consumeOnce(Buffs.BlessingRemoveContinuousNegativeEffectsBuff) {
        dispelTimed(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.BlessingEffectiveDamageUpBuff) { value ->
        applyTimedBuff(EffectiveDamageDealtUpBuff, value, 1)
      }
      buffs.consumeOnce(Buffs.BlessingHopeBuff) { value ->
        applyCountableBuff(Buffs.HopeBuff, count = value)
      }
      buffs.consumeOnce(Buffs.BlessingApDown2) { _ -> applyTimedBuff(ApDown2Buff, 0, 1) }
      buffs.consumeOnce(Buffs.DisasterBrillianceReductionBuff) { value -> removeBrilliance(value) }
      buffs.consumeOnce(Buffs.DisasterDaze) { value ->
        applyCountableBuff(Buffs.DazeBuff, count = value)
      }
      buffs.consumeOnce(Buffs.DisasterApUpBuff) { _ -> applyTimedBuff(ApUpBuff, 0, 1) }
    }
