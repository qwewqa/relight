package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.stageeffect.StageEffect

val SelfFortitudeBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.Fortitude, EffectTag.Fortitude) { targetSelf() }
val SelfEvasionBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.EvasionBuff, EffectTag.Evasion) { targetSelf() }
val SelfReviveBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.Revive, EffectTag.Revive) { targetSelf() }
val SelfInvincibleRebirthBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.InvincibleRebirth, EffectTag.Revive) { targetSelf() }
val TeamEvasionBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.EvasionBuff, EffectTag.Evasion) { targetAllyAoe(it) }
val TeamReviveBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.Revive, EffectTag.Revive) { targetAllyAoe(it) }
val TeamInvincibleRebirthBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.InvincibleRebirth, EffectTag.Revive) { targetAllyAoe(it) }
val TeamFortitudeBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.Fortitude, EffectTag.Fortitude) { targetAllyAoe(it) }
val SelfHopeBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.Hope, EffectTag.Hope) { targetSelf() }
val TeamBlessingHPRecoveryPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingHpRecovery, EffectTag.HpRecovery, "Team") { targetAllyAoe(it) }
val TeamBlessingCountableDebuffReductionPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingCountableDebuffReduction, EffectTag.NegativeCountableReduction, "Team") { targetAllyAoe(it) }
val SelfBlessingCountableDebuffReductionPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingCountableDebuffReduction, EffectTag.NegativeCountableReduction, "Self") { targetSelf() }
val TeamBlessingContinuousDebuffRemovalPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingContinuousDebuffRemoval, EffectTag.NegativeEffectCleanse, "Team") { targetAllyAoe(it) }
val SelfBlessingContinuousDebuffRemovalPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingContinuousDebuffRemoval, EffectTag.NegativeEffectCleanse, "Self") { targetSelf() }
val TeamBlessingEffectiveDamagePassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingEffectiveDamage, EffectTag.EffectiveDamage, "Team") { targetAllyAoe(it) }
val SelfBlessingEffectiveDamagePassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingEffectiveDamage, EffectTag.EffectiveDamage, "Self") { targetSelf() }
val TeamHopeBuffPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.Hope, EffectTag.Hope, "Team") { targetAllyAoe(it) }
val TeamBlessingHopePassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingHope, EffectTag.Hope, "Team") { targetAllyAoe(it) }
val TeamBlessingApDown2Passive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingApDown2, EffectTag.AP2Down, "Team") { targetAllyAoe(it) }
val SelfBlessingBlessingContinuousDebuffRemovalPassive: PassiveEffect = GenericCountableBuffPassive(Buffs.BlessingContinuousDebuffRemoval, EffectTag.NegativeEffectCleanse, "Self") { targetSelf() }

val TeamActPowerUpBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerUpBuff, EffectTag.Act,"Team") { targetAllyAoe(it) }
val TeamDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, EffectTag.Dexterity, "Team") { targetAllyAoe(it) }
val TeamCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, EffectTag.Critical, "Team") { targetAllyAoe(it) }
val TeamEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage, "Team") { targetAllyAoe(it) }
val SelfNormalDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(NormalDefenseUpBuff, EffectTag.Defense) { targetSelf() }
val SelfSpecialDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(SpecialDefenseUpBuff, EffectTag.Defense) { targetSelf() }
val TeamNormalDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(NormalDefenseUpBuff, EffectTag.Defense) { targetAllyAoe(it) }
val TeamSpecialDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(SpecialDefenseUpBuff, EffectTag.SpecialDefense) { targetAllyAoe(it) }
val SelfPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAimBuff, EffectTag.PerfectAim) { targetSelf() }
val TeamPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAimBuff, EffectTag.PerfectAim) { targetAllyAoe(it) }
val SelfDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, EffectTag.Dexterity) { targetSelf() }
val SelfEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage) { targetSelf() }
val SelfLockedEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(LockedEffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage) { targetSelf() }
val SelfCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, EffectTag.Critical) { targetSelf() }
val TeamAgilityUpBuffPassive: PassiveEffect = GenericBuffPassive(AgilityUpBuff, EffectTag.Agility,"Team") { targetAllyAoe(it) }
val TeamAPDownBuffPassive: PassiveEffect = GenericBuffPassive(ApDownBuff, EffectTag.ApDown, "Team") { targetAllyAoe(it) }
val TeamLockedAPDownBuffPassive: PassiveEffect = GenericBuffPassive(LockedApDownBuff, EffectTag.ApDown, "Team") { targetAllyAoe(it) }
val TeamAP2DownBuffPassive: PassiveEffect = GenericBuffPassive(ApDown2Buff, EffectTag.AP2Down, "Team") { targetAllyAoe(it) }
val SelfAP2DownBuffPassive: PassiveEffect = GenericBuffPassive(ApDown2Buff, EffectTag.AP2Down, "Self") { targetSelf() }
val SelfClimaxDamageUpBuffPassive: PassiveEffect = GenericBuffPassive(ClimaxDamageUpBuff, EffectTag.ClimaxDamage) { targetSelf() }
val SelfAbsorbBuffPassive: PassiveEffect = GenericBuffPassive(AbsorbBuff, EffectTag.Absorb) { targetSelf() }
val TeamInvincibilityBuffPassive: PassiveEffect = GenericBuffPassive(InvincibilityBuff, EffectTag.Invincibility) { targetAllyAoe(it) }
val TeamLockedInvincibilityBuffPassive: PassiveEffect = GenericBuffPassive(LockedInvincibilityBuff, EffectTag.Invincibility) { targetAllyAoe(it) }
val SelfNormalBarrierBuffPassive: PassiveEffect = GenericBuffPassive(NormalBarrierBuff, EffectTag.NormalBarrier) { targetSelf() }
val SelfSpecialBarrierBuffPassive: PassiveEffect = GenericBuffPassive(SpecialBarrierBuff, EffectTag.SpecialBarrier) { targetSelf() }
val TeamHpRegenBuffPassive: PassiveEffect = GenericBuffPassive(HpRegenBuff, EffectTag.HpRegen, "Team") { targetAllyAoe(it) }
val TeamContinuousNegativeEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(ContinuousNegativeEffectResistanceUpBuff, EffectTag.NegativeEffectResistance, "Team") { targetAllyAoe(it) }
val TeamLockedContinuousNegativeEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(LockedContinuousNegativeEffectResistanceUpBuff, EffectTag.NegativeEffectResistance, "Team") { targetAllyAoe(it) }
val SelfContinuousNegativeEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(ContinuousNegativeEffectResistanceUpBuff, EffectTag.NegativeEffectResistance) { targetSelf() }
val SelfLockedContinuousNegativeEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(LockedContinuousNegativeEffectResistanceUpBuff, EffectTag.NegativeEffectResistance) { targetSelf() }
val SelfNegativeCountableEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(NegativeCountableEffectResistanceUpBuff, EffectTag.NegativeCountableResistance) { targetSelf() }
val SelfLockedNegativeCountableEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(LockedNegativeCountableEffectResistanceUpBuff, EffectTag.NegativeCountableResistance) { targetSelf() }
val SelfExitEvasionBuffPassive: PassiveEffect = GenericBuffPassive(ExitEvasionBuff, EffectTag.ExitEvasion) { targetSelf() }
val TeamDamageDealtUpBuffPassive: PassiveEffect = GenericBuffPassive(DamageDealtUpBuff, EffectTag.Damage, "Team") { targetAllyAoe(it) }
val TeamDamageReceivedDownBuffPassive: PassiveEffect = GenericBuffPassive(DamageReceivedDownBuff, EffectTag.Damage, "Team") { targetAllyAoe(it) }
val TeamBrillianceGainUpBuffPassive: PassiveEffect = GenericBuffPassive(BrillianceGainUpBuff, EffectTag.BrillianceUp, "Team") { targetAllyAoe(it) }
val TeamBrillianceRegenBuffPassive: PassiveEffect = GenericBuffPassive(BrillianceRegenBuff, EffectTag.BrillianceRegeneration, "Team") { targetAllyAoe(it) }
val SelfBrillianceRegenBuffPassive: PassiveEffect = GenericBuffPassive(BrillianceRegenBuff, EffectTag.BrillianceRegeneration, "Self") { targetSelf() }
val SelfLockedBrillianceRegenBuffPassive: PassiveEffect = GenericBuffPassive(LockedBrillianceRegenBuff, EffectTag.BrillianceRegeneration, "Self") { targetSelf() }
val TeamNegativeCountableEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(NegativeCountableEffectResistanceUpBuff, EffectTag.NegativeCountableResistance, "Team") { targetAllyAoe(it) }
val TeamLockedNegativeCountableEffectResistanceUpBuffPassive: PassiveEffect = GenericBuffPassive(LockedNegativeCountableEffectResistanceUpBuff, EffectTag.NegativeCountableResistance, "Team") { targetAllyAoe(it) }
val TeamConfusionResistanceUpBuffPassive: PassiveEffect =
    ResistanceUpBuffPassive(ConfusionResistanceUpBuff, EffectTag.ConfusionResistance, "Team") { targetAllyAoe(it) }
val TeamStopResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(StopResistanceUpBuff, EffectTag.StopResistance, "Team") { targetAllyAoe(it) }
val SelfStopResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(StopResistanceUpBuff, EffectTag.StopResistance) { targetSelf() }
val TeamStunResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(StunResistanceUpBuff, EffectTag.StunResistance, "Team") { targetAllyAoe(it) }
val TeamBurnResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(BurnResistanceUpBuff, EffectTag.BurnResistance, "Team") { targetAllyAoe(it) }
val TeamFreezeResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(FreezeResistanceUpBuff, EffectTag.FreezeResistance, "Team") { targetAllyAoe(it) }
val TeamBlindResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(BlindResistanceUpBuff, EffectTag.BlindnessResistance, "Team") { targetAllyAoe(it) }
val TeamSleepResistanceUpBuffPassive: PassiveEffect = ResistanceUpBuffPassive(SleepResistanceUpBuff, EffectTag.SleepResistance, "Team") { targetAllyAoe(it) }
val EnemyBack1ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff, EffectTag.Confusion, "Enemy Back 1") { targetBack(1) }
val EnemyBack1DazeBuffPassive: PassiveEffect = CountableDebuffPassive(Buffs.DazeBuff, EffectTag.Daze, "Enemy Back 1") { targetBack(1) }
val EnemyFront3NightmareBuffPassive: PassiveEffect = DebuffPassive(NightmareBuff, EffectTag.Nightmare, "Enemy Front 3", 80) { targetFront(3) }
val EnemyBack3StopBuffPassive: PassiveEffect = DebuffPassive(StopBuff, EffectTag.Stop, "Enemy Back 3", 80) { targetBack(3) }
val EnemyActPowerDownBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerDownBuff, EffectTag.Act, "Enemy AoE") { targetAoe(it) }
val EnemyDexterityDownBuffPassive: PassiveEffect = GenericBuffPassive(DexterityDownBuff, EffectTag.Dexterity, "Enemy AoE") { targetAoe(it) }
val EnemyNormalDefenseBuffPassive: PassiveEffect = GenericBuffPassive(NormalDefenseDownBuff, EffectTag.Defense, "Enemy AoE") { targetAoe(it) }
val EnemySpecialDefenseBuffPassive: PassiveEffect = GenericBuffPassive(SpecialDefenseDownBuff, EffectTag.SpecialDefense, "Enemy AoE") { targetAoe(it) }
val EnemyFront5APUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy Front 5") { targetFront(5) }
val EnemyBack2APUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy Back 2") { targetBack(2) }
val EnemyBack3APUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy Back 3") { targetBack(3) }
val EnemyBack2LockedAPUpBuffPassive : PassiveEffect = GenericBuffPassive(LockedApUpBuff, EffectTag.ApUp, "Enemy Back 2") { targetBack(2) }
val EnemyBack3LockedAPUpBuffPassive : PassiveEffect = GenericBuffPassive(LockedApUpBuff, EffectTag.ApUp, "Enemy Back 3") { targetBack(3) }
val EnemyAPUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy AoE") { targetAoe(it) }
val EnemyProvokeBuffPassive: PassiveEffect = GenericBuffPassive(ProvokeBuff, EffectTag.Provoke, "Enemy AoE") { targetAoe(it) }
val EnemyAggroBuffPassive: PassiveEffect = GenericBuffPassive(AggroBuff, EffectTag.Aggro, "Enemy AoE") { targetAoe(it) }
val EnemyLockedAggroBuffPassive: PassiveEffect = GenericBuffPassive(LockedAggroBuff, EffectTag.Aggro, "Enemy AoE") { targetAoe(it) }
val EnemyDazeBuffPassive: PassiveEffect = CountableDebuffPassive(Buffs.DazeBuff, EffectTag.Daze, "Enemy AoE") { targetAoe(it) }
val EnemyPrideBuffPassive: PassiveEffect = CountableDebuffPassive(Buffs.Pride, EffectTag.Pride, "Enemy AoE") {targetAoe(it)}
val EnemyFront5StunBuffPassive: PassiveEffect = DebuffPassive(StunBuff, EffectTag.Stun, "Enemy Front 5") { targetFront(5) }
val EnemyStunBuffPassive: PassiveEffect = DebuffPassive(StunBuff, EffectTag.Stun, "Enemy AoE") { targetAoe(it) }
val EnemyFront2FreezeBuffPassive: PassiveEffect = DebuffPassive(FreezeBuff, EffectTag.Freeze, "Enemy Front 2") { targetFront(2) }
val EnemyFront5ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff, EffectTag.Confusion, "Enemy Front 5") { targetFront(5) }
val EnemyFront5ElectricShockBuffPassive: PassiveEffect = DebuffPassive(ElectricShockBuff, EffectTag.ElectricShock, "Enemy Front 5") { targetFront(5) }
val EnemyElectricShockBuffPassive: PassiveEffect = DebuffPassive(ElectricShockBuff, EffectTag.ElectricShock, "Enemy AoE") { targetAoe(it) }
val EnemyFront5LovesicknessBuffPassive: PassiveEffect = DebuffPassive(LovesicknessBuff, EffectTag.Lovesickness, "Enemy Front 5") { targetFront(5) }
val EnemyLovesicknessBuffPassive: PassiveEffect = DebuffPassive(LovesicknessBuff, EffectTag.Lovesickness, "Enemy AoE") { targetAoe(it) }
val EnemyBurnBuffPassive: PassiveEffect = DebuffPassive(BurnBuff, EffectTag.Burn, "Enemy AoE") { targetAoe(it) }
val EnemyPoisonBuffPassive: PassiveEffect = DebuffPassive(PoisonBuff, EffectTag.Poison, "Enemy AoE") { targetAoe(it) }
val EnemyBack2SleepBuffPassive: PassiveEffect = DebuffPassive(SleepBuff, EffectTag.Sleep, "Enemy Back 2") { targetBack(2) }

private data class GenericBuffPassive(
    val buffEffect: TimedBuffEffect<*>,
    val tag: EffectTag,
    val targetName: String = "Self",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositiveB
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyTimedBuff(buffEffect, value, time)
        }
}

private data class GenericCountableBuffPassive(
    val buff: CountableBuff,
    val tag: EffectTag,
    val targetName: String = "Self",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Buff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositiveB
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyCountableBuff(buff, time, value)
        }
}

private data class ResistanceUpBuffPassive(
    val buffEffect: TimedBuffEffect<*>,
    val tag: EffectTag,
    val targetName: String = "Team",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Resistance Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositiveB
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyTimedBuff(buffEffect, value, time)
        }
}

private data class DebuffPassive(
    val buffEffect: TimedBuffEffect<*>,
    val tag: EffectTag,
    val targetName: String = "Enemy Team",
    val chance: Int = 100,
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartNegative
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyTimedBuff(buffEffect, value, time, chance)
        }
}

private data class CountableDebuffPassive(
    val buff: CountableBuff,
    val tag: EffectTag,
    val targetName: String = "Enemy Team",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Debuff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartNegative
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyCountableBuff(buff, time, value)
        }
}

data class AllyStageEffectPassive(
    val effect: StageEffect
) : PassiveEffect {
    override val name = "Auto Ally Stage Effect [${effect.name}]"
    override val category = PassiveEffectCategory.TurnStartPositiveA //Unconfirmed category

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        applyAllyStageEffect(effect, time, value)
    }
}

data class EnemyStageEffectPassive(
    val effect: StageEffect
) : PassiveEffect {
    override val name = "Auto Enemy Stage Effect [${effect.name}]"
    override val category = PassiveEffectCategory.TurnStartNegative //Unconfirmed category

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        applyEnemyStageEffect(effect, time, value)
    }
}

data class DispelTimedBuffPassive(
    val buff: TimedBuffEffect<*>,
) : PassiveEffect {
    override val name = "Auto Dispel Timed Buff [${buff.name}]"
    override val category = PassiveEffectCategory.TurnStartNegative //Unconfirmed category

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        targetAoe(condition).act {
            dispelTimed(buff)
        }
    }
}

object DispelRevivePassive : PassiveEffect {
    override val name = "Auto Dispel Revive"
    override val category = PassiveEffectCategory.TurnStartPositiveB // Why?

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        targetAoe(condition).act {
            dispelCountable(Buffs.Revive, time)
        }
    }
}

object DispelFortitudePassive : PassiveEffect {
    override val name = "Auto Dispel Fortitude"
    override val category = PassiveEffectCategory.TurnStartPositiveB // Why?

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) = context.run {
        targetAoe(condition).act {
            dispelCountable(Buffs.Fortitude, time)
        }
    }
}
