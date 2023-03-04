package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApDown2Buff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EffectiveDamageDealtUpBuff

fun Actor.activateBlessings() =
    context.targetSelf().act {
      buffs.consumeOnce(Buffs.BlessingHpRecovery) { value -> heal(percent = value) }
      buffs.consumeOnce(Buffs.BlessingCountableDebuffReduction) { value ->
        dispelCountable(BuffCategory.Negative, value)
      }
      buffs.consumeOnce(Buffs.BlessingContinuousDebuffRemoval) {
        dispelTimed(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.BlessingEffectiveDamage) { value ->
        applyTimedBuff(EffectiveDamageDealtUpBuff, value, 1)
      }
      buffs.consumeOnce(Buffs.BlessingHope) { value ->
        applyCountableBuff(Buffs.HopeBuff, count = value)
      }
      buffs.consumeOnce(Buffs.BlessingApDown2) { _ -> applyTimedBuff(ApDown2Buff, 0, 1) }
      buffs.consumeOnce(Buffs.DisasterBrillianceReduction) { value -> removeBrilliance(value) }
      buffs.consumeOnce(Buffs.DisasterDaze) { value ->
        applyCountableBuff(Buffs.DazeBuff, count = value)
      }
      buffs.consumeOnce(Buffs.DisasterApUp) { _ -> applyTimedBuff(ApUpBuff, 0, 1) }
    }
