package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.*
import xyz.qwewqa.relivesim.stage.percent

class ConditionalTeamAutoEffect(
    val base: TeamAutoEffect,
    val condition: (ActionContext, CharacterState) -> Boolean,
    val conditionName: String,
) : TeamAutoEffect() {
    override fun toString() = "($conditionName) $base"
    override val effectClass get() = base.effectClass

    override fun apply(context: ActionContext, target: CharacterState) {
        base.apply(context, target)
    }

    override fun activate(context: ActionContext) = context.run {
        team.forEach { if (condition(this, it)) apply(this, it) }
    }
}

fun TeamAutoEffect.conditional(
    conditionName: String = "Conditional",
    condition: (ActionContext, CharacterState) -> Boolean,
) = ConditionalTeamAutoEffect(this, condition, conditionName)

class DamageDealtAutoEffect(efficacy: Percent) : SimplePercentAutoEffect(efficacy) {
    override fun activate(context: ActionContext) = context.run {
        self.damageDealtUp.value += efficacy
    }
}

class DexterityAutoEffect(efficacy: Percent) : SimplePercentAutoEffect(efficacy) {
    override fun activate(context: ActionContext) = context.run {
        self.dexterity.value += efficacy
    }
}

class EffectiveDamageAutoEffect(efficacy: Percent) : SimplePercentAutoEffect(efficacy) {
    override fun activate(context: ActionContext) = context.run {
        self.effectiveDamage.value += efficacy
    }
}

class TeamActCriticalAutoEffect(val efficacy: Percent) : AutoEffect {
    override fun toString() = "TeamActCriticalAutoEffect(efficacy = $efficacy)"
    override val effectClass = EffectClass.Positive

    override fun activate(context: ActionContext) = context.run {
        team.forEach {
            it.actPower.buff += efficacy
            it.critical.value += efficacy
        }
    }
}

class TeamHpDefenseAutoEffect(val hpEfficacy: Percent, val defenseEfficacy: Percent) : AutoEffect {
    override fun toString() = "TeamHpDefenseAutoEffect(hpEfficacy = $hpEfficacy, defenseEfficacy = $defenseEfficacy)"
    override val effectClass = EffectClass.Positive

    override fun activate(context: ActionContext) = context.run {
        team.forEach {
            it.maxHp.buff += hpEfficacy
            it.normalDefense.buff += defenseEfficacy
            it.specialDefense.buff += defenseEfficacy
        }
    }
}

data class TeamDexterityAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamDexterityAutoEffect(turns = $turns, efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.applyTimedEffect(DexterityTimedEffect(turns, efficacy))
    }
}

data class TeamEffectiveDamageAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamEffectiveDamageAutoEffect(turns = $turns, efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.applyTimedEffect(EffectiveDamageTimedEffect(turns, efficacy))
    }
}
