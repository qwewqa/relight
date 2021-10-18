package xyz.qwewqa.relive.simulator.core.stage.autoskill

import xyz.qwewqa.relive.simulator.core.stage.ActionContext
import xyz.qwewqa.relive.simulator.core.stage.condition.Condition
import xyz.qwewqa.relive.simulator.core.stage.condition.NamedCondition
import xyz.qwewqa.relive.simulator.core.stage.passive.PassiveData

/**
 * Autoskill effects.
 * Note that while the game itself differentiates between true passives and before start passives,
 * both are included here.
 */
interface PassiveEffect {
    val name: String get() = this::class.simpleName ?: "Unknown Passive"
    val category: PassiveEffectCategory
    val tags: List<EffectTag> get() = emptyList()

    fun activate(context: ActionContext, value: Int, time: Int, condition: Condition)
    fun formatName(value: Int, condition: Condition): String {
        val formattedValue = if (value != 0) " $value" else ""
        val formattedCondition = (condition as? NamedCondition)?.let { " [${it.displayName}]" } ?: ""
        return "$name$formattedValue$formattedCondition"
    }
}

/**
 * Tags associated with effects.
 * This is not intended to correspond 1:1 with in-game tags. For example,
 * act up and damage up have been separated.
 * An effect may also have more than one of these.
 */
enum class EffectTag {
    HP,
    Act,
    Damage,
    Defense,
    Agility,
    Dexterity,
    Critical,
    Regeneration,
    BrillianceRegeneration,
    NormalBarrier,
    SpecialBarrier,
    Evasion,
    Fortitude,
    Revive,
    Daze,
    EffectiveDamage,
    ClimaxDamage,
    Brilliance,
    BrillianceDown,
    Poison,
    Burn,
    Stun,
    Sleep,
    Nightmare,
    Confusion,
    Stop,
    Freeze,
    Blindness,
    Mark,
    PoisonResistance,
    BurnResistance,
    StunResistance,
    SleepResistance,
    ConfusionResistance,
    StopResistance,
    FreezeResistance,
    BlindnessResistance,
    MarkResistance,
    Seisho,
    Rinmeikan,
    Frontier,
    Siegfeld,
    Seiran,
    NegativeEffectResistance,
    PerfectAim,
    ApDown,
    ApUp,
    Cutin,
}

/**
 * Determines the order of passive application.
 */
enum class PassiveEffectCategory {
    Passive,
    TurnStartPositive,
    TurnStartNegative,
}

fun PassiveEffect.new(value: Int = 0, time: Int = 1) = PassiveData(
    this,
    value,
    time,
)
