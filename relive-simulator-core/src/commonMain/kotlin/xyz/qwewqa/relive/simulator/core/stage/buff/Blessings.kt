package xyz.qwewqa.relive.simulator.core.stage.buff

import xyz.qwewqa.relive.simulator.core.stage.actor.Actor
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApDown2Buff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.ApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.EffectiveDamageDealtUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterApDown2Buff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterApUpBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterDisasterGreaterDishearteningBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterDishearteningBuff
import xyz.qwewqa.relive.simulator.core.stage.buff.Buffs.GreaterEffectiveDamageDealtUpBuff

fun Actor.activateBlessings() =
    context.targetSelf().act {
      // TODO: Fix consumption order pending testing
      buffs.consumeOnce(Buffs.BlessingHpRecoveryBuff) { value -> heal(percent = value) }
      buffs.consumeOnce(Buffs.GreaterBlessingHpRecoveryBuff) { value -> heal(percent = value) }
      buffs.consumeOnce(Buffs.BlessingRemoveCountableNegativeEffectsBuff) { _ ->
        removeCountable(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.GreaterBlessingGreaterDispelCountableNegativeEffectsBuff) { _ ->
        removeCountableLevel(BuffCategory.Negative, 2)
      }
      buffs.consumeOnce(Buffs.BlessingReduceCountableNegativeEffectsBuff) { value ->
        removeCountable(BuffCategory.Negative, count = value.toInt())
      }
      buffs.consumeOnce(Buffs.BlessingRemoveContinuousNegativeEffectsBuff) {
        removeContinuous(BuffCategory.Negative)
      }
      buffs.consumeOnce(Buffs.GreaterBlessingGreaterDispelContinuousNegativeEffects) {
        removeContinuous(BuffCategory.Negative, 2)
      }
      buffs.consumeOnce(Buffs.BlessingEffectiveDamageUpBuff) { value ->
        applyContinuousBuff(EffectiveDamageDealtUpBuff, value, 1)
      }
      buffs.consumeOnce(Buffs.GreaterBlessingGreaterEffectiveElementDamageDealtUpBuff) { value ->
        applyContinuousBuff(GreaterEffectiveDamageDealtUpBuff, value, 1)
      }
      buffs.consumeOnce(Buffs.BlessingHopeBuff) { value ->
        applyCountableBuff(Buffs.HopeBuff, count = value.toInt())
      }
      buffs.consumeOnce(Buffs.BlessingApDown2) { _ -> applyContinuousBuff(ApDown2Buff, 0, 1) }
      buffs.consumeOnce(Buffs.GreaterBlessingGreaterResilienceBuff) { _ ->
        applyContinuousBuff(Buffs.GreaterResilienceBuff, 0, 1)
      }
      buffs.consumeOnce(Buffs.GreaterBlessingGreaterApDown2Buff) { _ ->
        applyContinuousBuff(GreaterApDown2Buff, 0, 1)
      }
      buffs.consumeOnce(Buffs.DisasterBrillianceReductionBuff) { value -> removeBrilliance(value) }
      buffs.consumeOnce(Buffs.GreaterDisasterBrillianceReductionBuff) { value ->
        removeBrilliance(value)
      }
      buffs.consumeOnce(Buffs.DisasterDaze) { value ->
        applyCountableBuff(Buffs.DazeBuff, count = value.toInt())
      }
      buffs.consumeOnce(Buffs.DisasterApUpBuff) { _ -> applyContinuousBuff(ApUpBuff, 0, 1) }
      buffs.consumeOnce(Buffs.GreaterDisasterGreaterApUpBuff) { _ ->
        applyContinuousBuff(GreaterApUpBuff, 0, 1)
      }
      buffs.consumeOnce(GreaterDisasterGreaterDishearteningBuff) { value ->
        applyContinuousBuff(GreaterDishearteningBuff, value, 1)
      }
    }
