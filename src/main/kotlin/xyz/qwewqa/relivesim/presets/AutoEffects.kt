package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.character.School
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

fun TeamAutoEffect.fullConditional(
    conditionName: String = "Conditional",
    condition: (ActionContext, CharacterState) -> Boolean,
) = ConditionalTeamAutoEffect(this, condition, conditionName)

fun TeamAutoEffect.conditional(
    conditionName: String = "Conditional",
    condition: (CharacterState) -> Boolean,
) = ConditionalTeamAutoEffect(this, { _, target -> condition(target) }, conditionName)

fun TeamAutoEffect.attributeOnly(attribute: Attribute) = conditional(attribute.name) {
    it.loadout.data.attribute == attribute
}

fun TeamAutoEffect.positionOnly(position: Position) = conditional(position.name) {
    it.loadout.data.position == position
}

fun TeamAutoEffect.schoolOnly(school: School) = conditional(school.name) {
    it.loadout.data.character.school == school
}

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

class TeamActCriticalAutoEffect(val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamActCriticalAutoEffect(efficacy = $efficacy)"
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.run {
            actPower.buff += efficacy
            critical.value += efficacy
        }
    }
}

class TeamHpDefenseAutoEffect(val hpEfficacy: Percent, val defenseEfficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamHpDefenseAutoEffect(hpEfficacy = $hpEfficacy, defenseEfficacy = $defenseEfficacy)"
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.run {
            maxHp.buff += hpEfficacy
            normalDefense.buff += defenseEfficacy
            specialDefense.buff += defenseEfficacy
        }
    }
}

data class TeamActDexterityAutoEffect(val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamActDexterityAutoEffect(efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.actPower.buff += efficacy
    }
}


data class TeamTimedDexterityAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamTimedDexterityAutoEffect(turns = $turns, efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.applyTimedEffect(DexterityTimedEffect(turns, efficacy))
    }
}

data class TeamTimedEffectiveDamageAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamTimedEffectiveDamageAutoEffect(turns = $turns, efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: CharacterState) = context.run {
        target.applyTimedEffect(EffectiveDamageTimedEffect(turns, efficacy))
    }
}
