package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.character.Attribute
import xyz.qwewqa.relivesim.stage.character.CharacterState
import xyz.qwewqa.relivesim.stage.character.DamageType

interface DamageCalculator {
    fun calculate(
        stage: Stage,
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int = 1,
        isClimax: Boolean = false,
        overrideAttribute: Attribute? = null,
    ): DamageResult
}

class StandardDamageCalculator : DamageCalculator {
    override fun calculate(
        stage: Stage,
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int,
        isClimax: Boolean,
        overrideAttribute: Attribute?,
    ): DamageResult {
        var atk = 2.0 * attacker.actPower.get() * modifier
        if (attacker.inCX) atk *= 1.1
        val def = when (attacker.loadout.data.damageType) {
            DamageType.Normal -> target.normalDefense.get()
            DamageType.Special -> target.specialDefense.get()
            else -> 0.0
        }
        val attribute = overrideAttribute ?: attacker.loadout.data.attribute
        var eleCoef = target.loadout.data.effectivenessTable.getValue(attribute)
        if (eleCoef > 1.0) eleCoef *= 100.percent + attacker.effectiveDamage.get()
        val critCoef = 100.percent + attacker.critical.get().coerceAtLeast(0.percent)
        val dex = attacker.dexterity.get().coerceIn(0.percent, 100.percent)
        val acc = (100.percent + attacker.accuracy.get() - target.evasion.get()).coerceIn(0.percent, 100.percent) *
                if (attacker.blindCounter > 0) 30.percent else 100.percent
        val dmgDealtCoef = (100.percent + attacker.damageDealtUp.get() - target.damageTakenDown.get())
            .coerceAtLeast(0.percent)
        // mark
        // cx damage up
        val bonusCoef = 100.percent + attacker.eventBonus
        val atkFactor = (atk / hitCount).toInt()
        val defFactor = (def / hitCount).toInt()
        val baseDmg = (
                (atkFactor - defFactor).coerceAtLeast(atkFactor / 10) *
                        eleCoef *
                        bonusCoef *
                        dmgDealtCoef
                ).toInt()
        val criticalDmg = (baseDmg * critCoef).toInt()
        return DamageResult(
            base = baseDmg,
            critical = criticalDmg,
            criticalChance = dex.asDouble(),
            hitChance = acc.asDouble(),
        )
    }
}

class LoggingDamageCalculator(private val calculator: DamageCalculator = StandardDamageCalculator()) :
    DamageCalculator {
    override fun calculate(
        stage: Stage,
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int,
        isClimax: Boolean,
        overrideAttribute: Attribute?,
    ): DamageResult {
        return calculator.calculate(stage, attacker, target, modifier, hitCount, isClimax, overrideAttribute).apply {
            stage.log("DamageCalculator") {
                "[${attacker.loadout.data.displayName}] attacks [${target.loadout.data.displayName}]\n" +
                        "Info: { base: $base, critical: $critical, criticalChance: $criticalChance, hitChance: $hitChance }\n" +
                        "Possible base rolls: ${possibleRolls(false)}\n" +
                        "Possible critical rolls: ${possibleRolls(true)}"
            }
        }
    }
}

data class DamageResult(
    val base: Int,
    val critical: Int,
    val criticalChance: Double,
    val hitChance: Double,
) {
    fun possibleRolls(critical: Boolean = false) = (-8..8).map {
        ((if (critical) this.critical else this.base) * (1.0 + it / 100.0)).toInt()
    }
}
