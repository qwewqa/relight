package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.StageGirl
import xyz.qwewqa.relivesim.stage.character.Position
import xyz.qwewqa.relivesim.stage.character.School
import xyz.qwewqa.relivesim.stage.context.ActionContext
import xyz.qwewqa.relivesim.stage.effect.*
import xyz.qwewqa.relivesim.stage.percent

class ConditionalTeamAutoEffect(
    val base: TeamAutoEffect,
    val condition: (ActionContext, StageGirl) -> Boolean,
    val conditionName: String,
) : TeamAutoEffect() {
    override fun toString() = "($conditionName) $base"
    override val effectClass get() = base.effectClass

    override fun apply(context: ActionContext, target: StageGirl) {
        base.apply(context, target)
    }

    override fun activate(context: ActionContext) = context.run {
        team.forEach { if (condition(this, it)) apply(this, it) }
    }
}

fun TeamAutoEffect.fullConditional(
    conditionName: String = "Conditional",
    condition: (ActionContext, StageGirl) -> Boolean,
) = ConditionalTeamAutoEffect(this, condition, conditionName)

fun TeamAutoEffect.conditional(
    conditionName: String = "Conditional",
    condition: (StageGirl) -> Boolean,
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
    override fun getModifier(context: ActionContext) = context.run {
        self.damageDealtUp
    }
}

class DexterityAutoEffect(efficacy: Percent) : SimplePercentAutoEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.dexterity
    }
}

class EffectiveDamageAutoEffect(efficacy: Percent) : SimplePercentAutoEffect(efficacy) {
    override fun getModifier(context: ActionContext) = context.run {
        self.effectiveDamage
    }
}

class TeamActCriticalAutoEffect(val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamActCriticalAutoEffect(efficacy = $efficacy)"
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.run {
            actPower.buff += efficacy
            critical.value += efficacy
        }
    }
}

class TeamActAutoEffect(val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamActAutoEffect(efficacy = $efficacy)"
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.run {
            actPower.buff += efficacy
        }
    }
}

class TeamHpDefenseAutoEffect(val hpEfficacy: Percent, val defenseEfficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamHpDefenseAutoEffect(hpEfficacy = $hpEfficacy, defenseEfficacy = $defenseEfficacy)"
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
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

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.actPower.buff += efficacy
    }
}

data class TeamTimedDexterityAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamTimedDexterityAutoEffect(turns = $turns, efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.act {
            applyEffect { DexterityTimedEffect(turns, efficacy) }
        }
    }
}

data class TeamTimedEffectiveDamageAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override fun toString() = "TeamTimedEffectiveDamageAutoEffect(turns = $turns, efficacy = $efficacy)"
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.act {
            applyEffect { EffectiveDamageTimedEffect(turns, efficacy) }
        }
    }
}
