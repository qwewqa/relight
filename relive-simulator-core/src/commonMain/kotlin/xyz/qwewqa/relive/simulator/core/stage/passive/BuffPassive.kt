package xyz.qwewqa.relive.simulator.core.stage.passive

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.TargetContext
import xyz.qwewqa.relive.simulator.core.stage.actor.CountableBuff
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffect
import xyz.qwewqa.relive.simulator.core.stage.autoskill.PassiveEffectCategory
import xyz.qwewqa.relive.simulator.core.stage.autoskill.EffectTag
import xyz.qwewqa.relive.simulator.core.stage.buff.*
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition

val SelfFortitudeBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Fortitude, EffectTag.Fortitude) { targetSelf() }
val SelfEvasionBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Evasion, EffectTag.Evasion) { targetSelf() }
val SelfReviveBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Revive, EffectTag.Revive) { targetSelf() }
val TeamEvasionBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Evasion, EffectTag.Evasion) { targetAllyAoe(it) }
val TeamReviveBuffPassive: PassiveEffect = GenericCountableBuffPassive(CountableBuff.Revive, EffectTag.Revive) { targetAllyAoe(it) }

val TeamActPowerUpBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerUpBuff, EffectTag.Act,"Team") { targetAllyAoe(it) }
val TeamDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, EffectTag.Dexterity, "Team") { targetAllyAoe(it) }
val TeamCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, EffectTag.Critical, "Team") { targetAllyAoe(it) }
val TeamEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage, "Team") { targetAllyAoe(it) }
val SelfNormalDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(NormalDefenseUpBuff, EffectTag.Defense) { targetSelf() }
val SelfSpecialDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(SpecialDefenseUpBuff, EffectTag.Defense) { targetSelf() }
val TeamSpecialDefenseUpBuffPassive: PassiveEffect = GenericBuffPassive(SpecialDefenseUpBuff, EffectTag.Defense) { targetAllyAoe(it) }
val SelfPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAimBuff, EffectTag.PerfectAim) { targetSelf() }
val TeamPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAimBuff, EffectTag.PerfectAim) { targetAllyAoe(it) }
val SelfDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, EffectTag.Dexterity) { targetSelf() }
val SelfEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage) { targetSelf() }
val SelfCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, EffectTag.Critical) { targetSelf() }
val TeamAgilityUpBuffPassive: PassiveEffect = GenericBuffPassive(AgilityUpBuff, EffectTag.Agility,"Team") { targetAllyAoe(it) }
val TeamAPDownBuffPassive: PassiveEffect = GenericBuffPassive(ApDownBuff, EffectTag.ApDown, "Team") { targetAllyAoe(it) }
val SelfClimaxDamageUpBuffPassive: PassiveEffect = GenericBuffPassive(ClimaxDamageUpBuff, EffectTag.ClimaxDamage) { targetSelf() }
val SelfAbsorbBuffPassive: PassiveEffect = GenericBuffPassive(AbsorbBuff, EffectTag.Absorb) { targetSelf() }
val SelfNormalBarrierBuffPassive: PassiveEffect = GenericBuffPassive(NormalBarrierBuff, EffectTag.NormalBarrier) { targetSelf() }
val SelfSpecialBarrierBuffPassive: PassiveEffect = GenericBuffPassive(SpecialBarrierBuff, EffectTag.SpecialBarrier) { targetSelf() }

val TeamConfusionResistanceBuffPassive: PassiveEffect =
    ResistanceBuffPassive(ConfusionResistanceBuff, EffectTag.ConfusionResistance, "Team") { targetAllyAoe(it) }
val TeamStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff, EffectTag.StopResistance, "Team") { targetAllyAoe(it) }
val SelfStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff, EffectTag.StopResistance) { targetSelf() }
val TeamStunResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StunResistanceBuff, EffectTag.StunResistance, "Team") { targetAllyAoe(it) }
val TeamBurnResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(BurnResistanceBuff, EffectTag.BurnResistance, "Team") { targetAllyAoe(it) }
val TeamFreezeResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(FreezeResistanceBuff, EffectTag.FreezeResistance, "Team") { targetAllyAoe(it) }
val TeamBlindnessResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(BlindnessResistanceBuff, EffectTag.BlindnessResistance, "Team") { targetAllyAoe(it) }
val TeamSleepResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(SleepResistanceBuff, EffectTag.SleepResistance, "Team") { targetAllyAoe(it) }

val EnemyBack1ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff, EffectTag.Confusion, "Enemy Back 1") { targetBack(1) }
val EnemyBack1DazeBuffPassive: PassiveEffect = CountableDebuffPassive(CountableBuff.Daze, EffectTag.Daze, "Enemy Back 1") { targetBack(1) }
val EnemyFront3NightmareBuffPassive: PassiveEffect = DebuffPassive(NightmareBuff, EffectTag.Nightmare, "Enemy Front 3", 80) { targetFront(3) }
val EnemyBack3StopBuffPassive: PassiveEffect = DebuffPassive(StopBuff, EffectTag.Stop, "Enemy Back 3", 80) { targetBack(3) }
val EnemyActPowerDownBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerDownBuff, EffectTag.Act, "Enemy AoE") { targetAoe(it) }
val EnemyDexterityDownBuffPassive: PassiveEffect = GenericBuffPassive(DexterityDownBuff, EffectTag.Dexterity, "Enemy AoE") { targetAoe(it) }
val EnemyFront5APUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy Front 5") { targetFront(5) }
val EnemyBack2APUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy Back 2") { targetBack(2) }
val EnemyBack3APUpBuffPassive : PassiveEffect = GenericBuffPassive(ApUpBuff, EffectTag.ApUp, "Enemy Back 3") { targetBack(3) }
val EnemyBack2LockedAPUpBuffPassive : PassiveEffect = GenericBuffPassive(LockedApUpBuff, EffectTag.ApUp, "Enemy Back 2") { targetBack(2) }
val EnemyBack3LockedAPUpBuffPassive : PassiveEffect = GenericBuffPassive(LockedApUpBuff, EffectTag.ApUp, "Enemy Back 3") { targetBack(3) }
val EnemyProvokeBuffPassive: PassiveEffect = GenericBuffPassive(ProvokeBuff, EffectTag.Provoke, "Enemy AoE") { targetAoe(it) }
val EnemyAggroBuffPassive: PassiveEffect = GenericBuffPassive(AggroBuff, EffectTag.Aggro, "Enemy AoE") { targetAoe(it) }
val EnemyDazeBuffPassive: PassiveEffect = CountableDebuffPassive(CountableBuff.Daze, EffectTag.Daze, "Enemy AoE") { targetAoe(it) }
val EnemyFront5StunBuffPassive: PassiveEffect = DebuffPassive(StunBuff, EffectTag.Stun, "Enemy Front 5") { targetFront(5) }
val EnemyFront2FreezeBuffPassive: PassiveEffect = DebuffPassive(FreezeBuff, EffectTag.Freeze, "Enemy Front 2") { targetFront(2) }

private data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val tag: EffectTag,
    val targetName: String = "Self",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyBuff(buffEffect, value, time)
        }
}

private data class GenericCountableBuffPassive(
    val buff: CountableBuff,
    val tag: EffectTag,
    val targetName: String = "Self",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Buff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyCountableBuff(buff, time)
        }
}

private data class ResistanceBuffPassive(
    val buffEffect: BuffEffect,
    val tag: EffectTag,
    val targetName: String = "Team",
    val target: ActionContext.(Condition) -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Resistance Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context, condition).act {
            applyBuff(buffEffect, value, time)
        }
}

private data class DebuffPassive(
    val buffEffect: BuffEffect,
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
            applyBuff(buffEffect, value, time, chance)
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
            applyCountableBuff(buff, value)
        }
}
