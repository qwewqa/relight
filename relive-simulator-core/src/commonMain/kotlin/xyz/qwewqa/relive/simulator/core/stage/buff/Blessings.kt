package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApDown2Buff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EffectiveDamageDealtUpBuff

fun Actor.activateBlessings() =
    context.targetSelf().act {
      // TODO: Fix consumption order pending testing
      buffs.consumeOnce(Buffs.BlessingHpRecoveryBuff) { value -> heal(percent = value) }
      buffs.consumeOnce(Buffs.BlessingRemoveCountableNegativeEffectsBuff) { _ ->
        removeCountable(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.BlessingReduceCountableNegativeEffectsBuff) { value ->
        removeCountable(BuffCategory.Negative, count = value.toInt())
      }
      buffs.consumeOnce(Buffs.BlessingRemoveContinuousNegativeEffectsBuff) {
        removeContinuous(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.BlessingEffectiveDamageUpBuff) { value ->
        applyContinuousBuff(EffectiveDamageDealtUpBuff, value, 1)
      }
      buffs.consumeOnce(Buffs.BlessingHopeBuff) { value ->
        applyCountableBuff(Buffs.HopeBuff, count = value.toInt())
      }
      buffs.consumeOnce(Buffs.BlessingApDown2) { _ -> applyContinuousBuff(ApDown2Buff, 0, 1) }
      buffs.consumeOnce(Buffs.DisasterBrillianceReductionBuff) { value -> removeBrilliance(value) }
      buffs.consumeOnce(Buffs.DisasterDaze) { value ->
        applyCountableBuff(Buffs.DazeBuff, count = value.toInt())
      }
      buffs.consumeOnce(Buffs.DisasterApUpBuff) { _ -> applyContinuousBuff(ApUpBuff, 0, 1) }
    }
