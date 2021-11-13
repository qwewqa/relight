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

val TeamActPowerUpBuffPassive: PassiveEffect = GenericBuffPassive(ActPowerUpBuff, EffectTag.Act,"Team") { targetAllyAoe() }
val TeamDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, EffectTag.Dexterity, "Team") { targetAllyAoe() }
val TeamCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, EffectTag.Critical, "Team") { targetAllyAoe() }
val TeamEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage, "Team") { targetAllyAoe() }
val SelfPerfectAimBuffPassive: PassiveEffect = GenericBuffPassive(PerfectAim, EffectTag.PerfectAim) { targetSelf() }
val SelfDexterityUpBuffPassive: PassiveEffect = GenericBuffPassive(DexterityUpBuff, EffectTag.Dexterity) { targetSelf() }
val SelfEffectiveDamageDealtUpBuffPassive: PassiveEffect =
    GenericBuffPassive(EffectiveDamageDealtUpBuff, EffectTag.EffectiveDamage) { targetSelf() }
val SelfCriticalUpBuffPassive: PassiveEffect = GenericBuffPassive(CriticalUpBuff, EffectTag.Critical) { targetSelf() }
val TeamAgilityUpBuffPassive: PassiveEffect = GenericBuffPassive(AgilityUpBuff, EffectTag.Agility,"Team") { targetAllyAoe() }
val TeamAPDownBuffPassive: PassiveEffect = GenericBuffPassive(ApDownBuff, EffectTag.ApDown, "Team") { targetAllyAoe() }
val SelfClimaxDamageUpBuffPassive: PassiveEffect = GenericBuffPassive(ClimaxDamageUpBuff, EffectTag.ClimaxDamage) { targetSelf() }
val SelfNormalBarrierBuffPassive: PassiveEffect = GenericBuffPassive(NormalBarrierBuff, EffectTag.NormalBarrier) { targetSelf() }
val SelfSpecialBarrierBuffPassive: PassiveEffect = GenericBuffPassive(SpecialBarrierBuff, EffectTag.SpecialBarrier) { targetSelf() }

val TeamConfusionResistanceBuffPassive: PassiveEffect =
    ResistanceBuffPassive(ConfusionResistanceBuff, EffectTag.ConfusionResistance, "Team") { targetAllyAoe() }
val TeamStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff, EffectTag.StopResistance, "Team") { targetAllyAoe() }
val SelfStopResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StopResistanceBuff, EffectTag.StopResistance) { targetSelf() }
val TeamStunResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(StunResistanceBuff, EffectTag.StunResistance, "Team") { targetAllyAoe() }
val TeamBurnResistanceBuffPassive: PassiveEffect = ResistanceBuffPassive(BurnResistanceBuff, EffectTag.BurnResistance, "Team") { targetAllyAoe() }

val EnemyBack1ConfusionBuffPassive: PassiveEffect = DebuffPassive(ConfusionBuff, EffectTag.Confusion, "Enemy Back 1") { targetBack(1) }
val EnemyBack1DazeBuffPassive: PassiveEffect = CountableDebuffPassive(CountableBuff.Daze, EffectTag.Daze, "Enemy Back 1") { targetBack(1) }
val EnemyFront3NightmareBuffPassive: PassiveEffect = DebuffPassive(NightmareBuff, EffectTag.Nightmare, "Enemy Front 3", 80) { targetFront(3) }
val EnemyBack3StopBuffPassive: PassiveEffect = DebuffPassive(StopBuff, EffectTag.Stop, "Enemy Back 3", 80) { targetBack(3) }

private data class GenericBuffPassive(
    val buffEffect: BuffEffect,
    val tag: EffectTag,
    val targetName: String = "Self",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, time)
        }
}

private data class GenericCountableBuffPassive(
    val buff: CountableBuff,
    val tag: EffectTag,
    val targetName: String = "Self",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Buff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyCountableBuff(buff, time)
        }
}

private data class ResistanceBuffPassive(
    val buffEffect: BuffEffect,
    val tag: EffectTag,
    val targetName: String = "Team",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Resistance Buff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartPositive
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, time)
        }
}

private data class DebuffPassive(
    val buffEffect: BuffEffect,
    val tag: EffectTag,
    val targetName: String = "Enemy Team",
    val chance: Int = 100,
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Debuff ${buffEffect.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartNegative
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyBuff(buffEffect, value, time, chance)
        }
}

private data class CountableDebuffPassive(
    val buff: CountableBuff,
    val tag: EffectTag,
    val targetName: String = "Enemy Team",
    val target: ActionContext.() -> TargetContext,
) : PassiveEffect {
    override val name = "Auto Countable Debuff ${buff.name} ($targetName)"
    override val category = PassiveEffectCategory.TurnStartNegative
    override val tags = listOf(tag)

    override fun activate(context: ActionContext, value: Int, time: Int, condition: Condition) =
        target(context).act {
            applyCountableBuff(buff, value)
        }
}
