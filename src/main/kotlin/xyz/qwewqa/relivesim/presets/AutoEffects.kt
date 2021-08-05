package xyz.qwewqa.relivesim.presets

import xyz.qwewqa.relivesim.presets.effect.ActTimedEffect
import xyz.qwewqa.relivesim.presets.effect.ApDownTimedEffect
import xyz.qwewqa.relivesim.presets.effect.DexterityTimedEffect
import xyz.qwewqa.relivesim.presets.effect.EffectiveDamageTimedEffect
import xyz.qwewqa.relivesim.stage.Percent
import xyz.qwewqa.relivesim.stage.character.*
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

fun TeamAutoEffect.damageTypeOnly(type: DamageType) = conditional(type.name) {
    it.loadout.data.damageType == type
}

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

data class TeamActCriticalAutoEffect(val efficacy: Percent) : TeamAutoEffect() {
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.run {
            actPower.buff += efficacy
            critical.value += efficacy
        }
    }
}

data class TeamActAutoEffect(val efficacy: Percent) : TeamAutoEffect() {
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

data class TeamTimedActAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.act {
            applyEffect { ActTimedEffect(turns, efficacy) }
        }
    }
}

data class TeamTimedDexterityAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.act {
            applyEffect { DexterityTimedEffect(turns, efficacy) }
        }
    }
}

data class TeamTimedApDownAutoEffect(val turns: Int) : TeamAutoEffect() {
    override val effectClass = EffectClass.Positive

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.act {
            applyEffect { ApDownTimedEffect(turns) }
        }
    }
}

data class TeamTimedEffectiveDamageAutoEffect(val turns: Int, val efficacy: Percent) : TeamAutoEffect() {
    override val effectClass = if (efficacy >= 0.percent) EffectClass.Positive else EffectClass.Negative

    override fun apply(context: ActionContext, target: StageGirl) = context.run {
        target.act {
            applyEffect { EffectiveDamageTimedEffect(turns, efficacy) }
        }
    }
}

data class SelfBrillianceRecoveryAutoEffect(val amount: Int) : AutoEffect {
    override val effectClass = EffectClass.Positive

    override fun activate(context: ActionContext) = context.run {
        self.addBrilliance(amount)
    }
}

data class TurnBrillianceAutoEffect(val amount: Int) : AutoEffect {
    override val effectClass: EffectClass = EffectClass.Positive

    override fun activate(context: ActionContext) = context.run {
        self.effects.addPassive { self.addBrilliance(amount) }
    }
}

data class FortitudeAutoEffect(val count: Int = 1) : AutoEffect {
    override val effectClass: EffectClass = EffectClass.Positive

    override fun activate(context: ActionContext) = context.run {
        self.effects.add(StackedEffect.Fortitude, count)
    }
}

data class ClimaxPowerAutoEffect(val efficacy: Percent) : AutoEffect {
    override val effectClass: EffectClass = EffectClass.Positive

    override fun activate(context: ActionContext) = context.run {
        self.climaxDamage.buff += efficacy
    }
}
