package xyz.qwewqa.relivesim.stage

import xyz.qwewqa.relivesim.stage.activeeffects.EffectType

interface DamageCalculator {
    fun calculate(
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int = 1,
        overrideAttribute: Attribute? = null,
    ): DamageResult
}

class StandardDamageCalculator : DamageCalculator {
    override fun calculate(
        attacker: CharacterState,
        target: CharacterState,
        modifier: Percent,
        hitCount: Int,
        overrideAttribute: Attribute?,
    ): DamageResult {
        var atk = 2.0 * attacker.actPower.get() * modifier
        if (attacker.inCA) atk *= 1.1
        val def = when (attacker.characterData.damageType) {
            DamageType.Normal -> target.normalDefense.get()
            DamageType.Special -> target.specialDefense.get()
            else -> 0.0
        }
        val attribute = overrideAttribute ?: attacker.characterData.attribute
        var eleCoef = target.characterData.effectivenessTable.getValue(attribute)
        if (eleCoef > 1.0) eleCoef *= 100.percent + attacker.effectiveDamage.get()
        val critCoef = 100.percent + attacker.critical.get().coerceAtLeast(0.percent)
        val dex = attacker.dexterity.get().coerceIn(0.percent, 100.percent)
        val acc = (100.percent + attacker.accuracy.get() - target.evasion.get()).coerceIn(0.percent, 100.percent) *
                if (attacker.effects.hasEffectType(EffectType.Blind)) 30.percent else 100.percent
        // mark
        val bonusCoef = 100.percent + attacker.eventBonus
        val atkFactor = (atk / hitCount).toInt()
        val defFactor = (def / hitCount).toInt()
        val baseDmg = ((atkFactor - defFactor).coerceAtLeast(atkFactor / 10) * eleCoef * bonusCoef).toInt()
        val criticalDmg = (baseDmg * critCoef).toInt()
        return DamageResult(
            base = baseDmg,
            critical = criticalDmg,
            criticalChance = dex.asDouble(),
            hitChance = acc.asDouble(),
        )
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
